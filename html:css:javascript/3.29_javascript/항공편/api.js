const flightScheduleApi = (function(){
    'use strict';
    const SERVICE_KEY1 = "T6%2BWvA9ua7sQsXeQaik8a2UeEQVedRIFS2zssUITFbSw55k5xv0918kj9jNsTD03mRmx8kJe5o5%2BkoGDKymTrw%3D%3D";
    const SERVICE_KEY2 = "T6+WvA9ua7sQsXeQaik8a2UeEQVedRIFS2zssUITFbSw55k5xv0918kj9jNsTD03mRmx8kJe5o5+koGDKymTrw=="
    //운행스케줄 api
    const api = new Object();
    
    async function getAirlineList(){
        let url = 'http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getAirmanList'; /*URL*/
        let queryParams = '?' + encodeURIComponent('serviceKey') + '='+SERVICE_KEY1; /*Service Key*/
        queryParams += '&' + encodeURIComponent('_type') + '=' + encodeURIComponent('json'); /**/
        url+=queryParams;
        //TODO#1 항공사 리스트 구하기
        const response = await fetch(url);
        const json = await response.json(); 
        const items = json.response.body.items.item;
        console.log(items);
        return items;
        

        
    }

    api.getAirportList = async function(){
        let url = "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getArprtList";
        let queryParams = '?' + encodeURIComponent('serviceKey') + '='+SERVICE_KEY1; /*Service Key*/
            queryParams += '&' + encodeURIComponent('_type') + '=' + encodeURIComponent('json'); /**/
            url+=queryParams;
            //TODO#2 공항리스트 구하기
            const response = await fetch(url);
            const json = await response.json();
            const items = json.response.body.items.item;
            console.log(items);
            
            return items;


                    }

    /* 
        * @param {*} depAirportId  출발공항 아이디
        * @param {*} arrAirportId  도착공항 아이디
        * @param {*} depPlandTime  출발시간 : 20230321
        * @param {*} airlineId     항공사 아이디
    */
    //getFlightSchedule("NAARKJJ","NAARKPC","20201202","AAR");
    async function getFlightSchedule(depAirportId,arrAirportId,depPlandTime,airlineId){
        let url = "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getFlightOpratInfoList";
        let queryParams = "?serviceKey="  + encodeURIComponent(SERVICE_KEY2);
        queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
        queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
        queryParams += '&' + encodeURIComponent('_type') + '=' + encodeURIComponent('json'); /**/
        queryParams += '&' + encodeURIComponent('depAirportId') + '=' + encodeURIComponent(depAirportId); /**/
        queryParams += '&' + encodeURIComponent('arrAirportId') + '=' + encodeURIComponent(arrAirportId); /**/
        queryParams += '&' + encodeURIComponent('depPlandTime') + '=' + encodeURIComponent(depPlandTime); /**/
        queryParams += '&' + encodeURIComponent('airlineId') + '=' + encodeURIComponent(airlineId); /**/
        url = url + queryParams;
        console.log(url);

        //TODO#3 항공운항정보 조회
        const response = await fetch(url);
        const json = await response.json();
        const items = json.response.body.items.item;
        console.log(items);
        

        for(const item of items) {
            if(item.economyCharge == undefined){
                item.economyCharge = "";
            }
            if(item.prestigeCharge == undefined){
                item.prestigeCharge = "";
            }
        }

        return items;

        
    }

    api.search=async function(depAirportId,arrAirportId,depPlandTime){
        const airlineList = await getAirlineList();

        //조회로직 실행
        depPlandTime = depPlandTime.replaceAll("-","");
        const promiseList = [];

        for (const airline of airlineList) {
            const promise = getFlightSchedule(depAirportId,arrAirportId,depPlandTime,airline.airlineId);
            //TODO#4 항공사별 운항정보를 얻어서 하나의 리스트로 리턴
            promiseList.push(promise);
        }
        const result = Promise.all(promiseList).then((values) => {
            const items=[];
            for(let i=0; i<values.length; i++){
                const insertList = values[i];
                for(let j=0; j<insertList.length;j++){
                    items.push(insertList[j]);
                }
            }
        return items;
        }
    );
    
        return result;
    }

    return api;
})();



window.addEventListener("DOMContentLoaded",async function(){
    'use strict'
    
    const departureId = document.getElementById("departureId");
    const arrivalId = document.getElementById("arrivalId");
    
    //비행날짜
    const plandDate = document.getElementById("plandDate");
    //TODO#5 기본 날짜를 오늘로 설정
    plandDate.value = new Date().toISOString().substring(0,10);
    
   

    //FIXME #6 공항리스트 호출.
    const airportList = await flightScheduleApi.getAirportList();
    console.log(airportList);

    for (const item of airportList) {
    //TODO#7  selectBox (departureId,arrivalId)에 공항리스트 할당
        const option = document.createElement("option");
        option.value = item.airportId;
        option.text = item.airportNm;
        departureId.append(option);
        arrivalId.append(option.cloneNode(true));

    }

    const validateForm = function(form){
        const departureId = form["departureId"];
        const arrivalId = form["arrivalId"];
        const departureIdValue  = departureId.options[departureId.selectedIndex].value;
        const arrivalIdValue  = arrivalId.options[arrivalId.selectedIndex].value;
        //TODO#8 form validation
        if(departureIdValue == "" || arrivalIdValue== "" || departureIdValue == arrivalIdValue ){
            alert("출발과 도착 공항을 다르게 지정해주세요!")
            return false;
        }

        return true;
    };

    const findForm = document.getElementById("find-form");
    
    findForm.addEventListener("submit",async function(event){
        event.preventDefault();
        if(validateForm(event.target)==false){
            return;
        }


        //schedule 조회
        try{
            
            const depPlandTime = document.getElementById("plandDate").value;
            const items = await flightScheduleApi.search(departureId.value,arrivalId.value,depPlandTime);
            
            searchResult(items);

        }catch(e){
            console.log("item error");
            alert(e);
        }
    });

});

function searchResult(items){

    const scheduleTbl = document.getElementById("schedule-tbl");
    const tbody = scheduleTbl.getElementsByTagName("tbody")[0];

    while(tbody.firstChild){
       //TODO#9tbody에 담겨있는 모든 <tr> 삭제
        tbody.firstChild.remove();

    }

    for(let i=0; i<items.length; i++){

        const tr = document.createElement("tr");
        //TODO#10 tbdoy에 <tr><td>...</td> ... </tr> 만들어서 넣기
        const td1 = document.createElement("td");
        const td2 = document.createElement("td");
        const td3 = document.createElement("td");
        const td4 = document.createElement("td");
        const td5 = document.createElement("td");
        const td6 = document.createElement("td");
        const td7 = document.createElement("td");
        const td8 = document.createElement("td");
        //항공편명	vihicleId
        td1.innerText=items[i].vihicleId;
        //항공사명	airlineNm
        td2.innerHTML=items[i].airlineNm;
        //출발시간	depPlandTime
        td3.innerText=convertDate(items[i].depPlandTime);
        //도착시간	arrPlandTime
        td4.innerText=convertDate(items[i].arrPlandTime);

        //일반석운임	economyCharge
        https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Intl/NumberFormat
        td5.innerText=new Intl.NumberFormat().format(items[i].economyCharge);
        //비즈니스석운임	prestigeCharge
        td6.innerText=new Intl.NumberFormat().format(items[i].prestigeCharge);
        //출발공항	depAirportNm
        td7.innerText=items[i].depAirportNm;
        //  도착공항	arrAirportNm
        td8.innerText=items[i].arrAirportNm;

        tr.append(td1);
        tr.append(td2);
        tr.append(td3);
        tr.append(td4);
        tr.append(td5);
        tr.append(td6);
        tr.append(td7);
        tr.append(td8);
        tbody.append(tr);
    }
}

function convertDate(str){
    str = str.toString();
    //202303221125 -> 2023 03 22 11:25
    return str.substring(0,4) 
            + "-" + str.substring(4,6)
            + "-" + str.substring(6,8) 
            + " " + str.substring(8,10) 
            + ":" + str.substring(10,12);
}


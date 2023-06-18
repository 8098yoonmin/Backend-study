window.addEventListener("DOMContentLoaded", function(){
    'use strict'; 

    const loginFormValidate = function(form){
        if(form['mem_id'].value.trim()==""){
            alert("아이디가 비어있습니다.!")
            form['mem_id'].focus();
            return false;
        }
        if(form['mem_name'].value.trim()==""){
            alert("이름이 비어있습니다.!");
            form['mem_name'].focus();
            return false;
        }
        if(form['mem_pw'].value != form['mem_repw'].value){
            alert("비밀번호가 일치하지 않습니다.!")
            return false;
        }
        
    };

    const loginForm = document.getElementById("register_form");

    loginForm.addEventListener("submit", async function(event){
        event.preventDefault();


        const userId = event.target['mem_id'].value;
        const userPw = event.target['mem_pw'].value;
        const userNm = event.target['mem_name'].value;
        
        if(loginFormValidate(event.target) == false){
            
            return ;
        }
        
        let result = null ;
        try{
            result = await dupCheck(userId);
            console.log(result)
        }
        catch{
            alert(error);
        }

        if(result== true){
            alert("이미 존재하는 아이디 입니다.")
            return;
        }
        
        //회원가입
        try{
            const user = await doRegister(userId, userNm, userPw);
            
        } catch(error){
            alert(error);
        }

       
    });

 });

//회원등록
async function doRegister(mem_id, mem_name, mem_pw){
    const url = 'http://133.186.144.236:8100/api/users';
    const user ={
        userId : mem_id,
        userName: mem_name,
        userPassword : mem_pw
    }
    const options ={
        method:'POST',
        headers:{
            'Content-Type':'application/json'
        },
        body: JSON.stringify(user)
    }

    const res = await fetch(url, options);

    if(!res.ok){
        throw new Error("fetch error");
    } 
    console.log("연결완료");
    };
 



 //회원아이디 중복체크 
 async function dupCheck(mem_id){
    const url = "http://133.186.144.236:8100/api/users/{"+mem_id+"}/exist"
    const user ={
        userId : mem_id,
    }
    const options = {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(user)
    }
    const response = await fetch(url, options);
    if(response.ok) {
        return response.json();
    }
    else{
        throw new Error("connect error")
    }
    
 }

 

 
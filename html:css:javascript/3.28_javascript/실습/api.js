let myName="marco";
let yourName='Ahn';
let phrse = `my name is ${myName}`;

let content=`
    <table>
        <tbody>
            <tr>
                <td>${myName}</td>
            </tr>
        </tbody>
    </table>
`

content = "<table><tbody><tr><td>" +myName +"</td></tr>";


let user = {
    name: MediaRecorder,
    age: 30,
    getName: function(){
        return this.name;
    }
};
// object 내에 함수 사용 가능, 메소드라고 부름

console(user.name);
user.age;

const map1 = new Map();
map1.set(key, value); 

map1 = new Map(); //재할당이 안된다는 말은 이게 안된다는 말(객체를 재생성)

map1.set(key, value); //이건 가능

// '=='은 객체의 값 비교, '==='는 객체의 타입까지비교


//즉시실행
(function(){

})();

//함수 특징++
//함수 안에서 함수를 return할 수 있다. 
//변수에 함수할당 가능
//인수에 함수할당 가능
function sayHello() {
    return function(){};
}

//객체 복사
const newPerson2 ={
    name:'marco',
    age:30
};

for(key in newPerson) {
    newPerson2[key] = newPerson[key];
}

//얕은복사
const newPerson3 = Object.assign({}, newPerson2);

//배열 (대괄호를 사용하거나, array객체를 이용하면 됨=)

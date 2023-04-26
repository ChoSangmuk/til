# JavaScript Syntax Summary

## 변수
- var, let, const 를 통해 타입 구분 없이 변수를 선언, 선언과 동시에 초기화 가능
- JavaScript는 자동으로 자료형을 변환 
  - 숫자와 문자열을 더할 때 숫자보다는 문자열이 우선시 됨
  - 더하기를 제외한 사칙 연산자는 숫자가 우선시 됨
  - 강제 형 변환
```js
var stringVar = 'string'; // 문자열 ', " 사용
var numberVar = 10; // 숫자
var booleanVar = true; // 물리언
var functionVar = function () {}; // 함수
var objectVar = {}; // 객체

typeof(stringVar) // 타입 확인

// ===	양 변의 자료형과 값이 일치합니다.
// !==	양 변의 자료형 또는 값이 다릅니다.

Number() : 다른 자료형을 숫자로
String() : 다른 자료형을 문자열로
Boolean() : 다른 자료형을 불리언형
// false를 반환하는 5가지 경우
  Boolean(0)
  Boolean(NaN)
  Boolean('')
  Boolean(null)
  Boolean(undefined)
```

## Map
- https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Map
```
let myMap = new Map()

let keyString = '문자열'
let keyObj    = {}
let keyFunc   = function() {}

// 값 설정
myMap.set(keyString, "'문자열'과 관련된 값")
myMap.set(keyObj, 'keyObj와 관련된 값')
myMap.set(keyFunc, 'keyFunc와 관련된 값')

myMap.size              // 3

// getting the values
myMap.get(keyString)    // "'문자열'과 관련된 값"
myMap.get(keyObj)       // "keyObj와 관련된 값"
myMap.get(keyFunc)      // "keyFunc와 관련된 값"

myMap.get('문자열')    // "'문자열'과 관련된 값"
                         // keyString === '문자열'이기 때문
myMap.get({})            // undefined, keyObj !== {}
myMap.get(function() {}) // undefined, keyFunc !== function () {}
```

## 함수
- https://opentutorials.org/course/787/4963
```js
// 일반형
function name(param, ...){
  return ...;
}
```
### 함수형 프로그램
- 순수 함수
```
입력이 같다면 항상 같은 결과
외부에 영향(부수 효과)이 없는 함수
외부에 영향을 받지 않는 함수 
객체의 값을 직접 변경해서는 안되며, 변경시에는 새로운 객체를 반환해야함
```
- 일급함수
```
함수가 값이 될 수 있다.
함수를 변수에 저장 가능하다.
함수에 인자로 함수전달이 가능하다.
```

- 클로저...
```
```

## 조건문
- if
```js
if ( ) { } 
else if ( ) { } 
else { }
```
- switch
```js
switch(parm) {
  case 0:
    // 로직
    break;
  case 1:
    // 로직
    break;
  default:
    // 로직
    break;
}
```
- short
```js
true || alert('실행될까요?A');
false || alert('실행될까요?B');
// A는 실행되지 않고 B는 실행된다.
 
true && alert('실행될까요?C');
false && alert('실행될까요?D');
// C는 실행되고 D는 실행되지 않는다.
```

## 반복문
- for, for in
```js
var array = ['포도', '사과', '바나나', '망고'];
for(var i=0; i<array.length; i++) alert(array[i]);
for(var i in array) alert(array[i]);
```

- while, do while
```js
// 0부터 9까지 출력하는 while문
var value = 0;
while(value < 10) {
    console.log("for : value의 값은="+value);
    value++;
}
// do while
do {
    console.log("for : value의 값은="+value);
    value++;
} while(value < 10);
```

## 클래스
```js
//class의 선언 - 낙타표기법으로 첫번째 글자를 대문자로 함수를 하나 선언한다.
function Clazz(msg){
  // 변수를 객체의 멤버로 사용하기 위해 this 예약어를 사용해서 정의한다.
  this.name = 'I am Class';
  this.message = msg;

  // this를 사용하지 않은 변수
  message2 = "find me!";
  // 멤버함수 선언
  this.print = function(){
    console.log(message2);
  };
}

// 객체를 생성
var myClazz = new Clazz('good to see u!');
console.log(myClazz.message);
// this를 사용하지 않은 message2 변수는 외부에서 참조할 수 없다.
console.log(myClazz.message2);
// this로 선언된 함수를 통해 사용할 수 있다.
myClazz.print();
```
```js
function Clazz(msg){
    this.name = 'I am Class';
    this.message = msg;

    message2 = "find me!";
}
//Clazz 객체의 prototype 을 가져와서 message값을 리턴하는 함수를 하나 추가한다.
Clazz.prototype.getMessage = function(){
    return this.message;
}

Clazz.prototype.getMessage2 = function(){
    return this.message2;
}

// 객체를 생성
var myClazz = new Clazz('good to see u!');
console.log(myClazz.getMessage());
// 내부에 선언된 함수와는 다르게 prototype으로 선언한 함수는 값을 사용할 수 없다.
console.log(myClazz.getMessage2());
```
```js
function Clazz(){
    this.name = 'Hello there!';
    this.message;
}

// message 변수에 값을 입력하는 함수
Clazz.prototype.setMessage = function(msg){
    this.message = msg;
}
// message 변수의 값을 가져오는 함수
Clazz.prototype.getMessage = function(){
    return this.message;
}

// exports 명령어를 사용함으로써 다른파일에서 require 예약어를 이용해 Clazz 객체를 사용할 수 있게된다.
// exports 명령어의 위치는 파일의 어떤곳에 위치해도 동일하게 동작한다.
module.exports = Clazz;
```
```js
// NodeClass 를 선언한다. 여기서 NodeClass 는 변수명이 아니라 class명 이므로 첫글자를 대문자로 한다.
var NodeClass = require('./NodeClass');

// new 연산자를 사용해서 NodeClass 클래스를 nodeClass 변수로 초기화한다.
var nodeClass = new NodeClass();

// setMessage 함수로 값을 입력한다.
nodeClass.setMessage('Good to See u!');

// 입력된 값을 출력한다.
console.log(nodeClass.getMessage());
```
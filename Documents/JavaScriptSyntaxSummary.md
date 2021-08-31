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

### 문자열 
- 문자열 관련 함수
  - [참고](https://lktprogrammer.tistory.com/124)
```js
var name = new String("문자열 데이터");
var name = "문자열 데이터";

String.charAt(1) // 문자열을 배열 취급하고 해당 인덱스의 문자를 반환

String.indexOf("찾을 문자", index) // 찾을 문자와 일치하는 최초의 문자의 Index를 반환하는 함수, 두 번째 인자 지정 시 검색하는 시작 Index지정
String.lastIndexOf("찾을 문자") // 찾을 문자를 문자열 오른쪽에서부터 찾는 함수, 
// 두 함수 모두 일치하는 문자를 찾지 못하면 -1을 반환합니다.

String.replace("찾을 문자", "치환할 문자") // 최초로 발견된 일치하는 문자열에 대해서만 치환
String.replaceAll("찾을 문자", "치환할 문자") // 일치하는 모든 문자열에 대해서 치환

String.substring(startIndex, endIndex) // endIndex 미 포함
String.substr(startIndex, 문자개수)

String.split("문자")// 첫 번째 인자 문자를 기준으로 문자열을 잘라 각 배열 요소에 담은 뒤에 해당 배열 객체를 반환해주는 함수

String.toLowerCase() 
String.toUpperCase()

String.concat("합칠 문자열")
String.trim() // 공백제거
String.length // 길이는 함수가 아니라 속성
```

## 배열
- 배열의 생성과 초기화 
```js
/* new Array() */
const arr = []; // []
const arr = new Array(); // []
const arr = new Array(5); // [ <5 empty items> ]
/* 직접 초기화 */
const arr = [0, 0, 0, 0, 0]; // [ 0, 0, 0, 0, 0 ]
/* new Array()로 초기값 설정 */
const arr = new Array(0, 0, 0, 0, 0); // [ 0, 0, 0, 0, 0 ]

/* Array.from( , 콜백)으로 길이가 5, 값이 0인 배열 생성하기 */
const arr = Array.from({length: 5}, () => 0); // => Array(5) [0, 0, 0, 0, 0]
/* Array.from()으로 길이가 5, 값이 (0~5)인 배열 생성, i(index) 1씩 증가 */
const arr = Array.from({length: 5}, (v, i) => i); // => Array(5) [0, 1, 2, 3, 4]
/* 콜백함수의 첫번째 매개변수, v 생략시 undefined 반환 */
const arr = Array.from({length: 5}, (i) => i); // => Array(5) [undefined, undefined, undefined, undefined, undefined]
/* console.log()로 v의 값을 확인해보면 undefined가 출력된다. */
const arr = Array.from({length: 5}, (v, i) => {
  console.log(v, i)
  return i;
});
// => undefined 0...4

/* Array.from() 콜백의 첫번째 매개변수는 undfined. */
const arr = Array.from({length: 5}, (undefined, i) => i); // => Array(5) [0, 1, 2, 3, 4]
```
- 배열의 함수
  - [참고](http://blog.302chanwoo.com/2017/08/javascript-array-method/)
```js
// pop : 배열 뒷부분의 값을 삭제
var arr = [ 1, 2, 3, 4 ];
arr.pop();
console.log( arr ); // [ 1, 2, 3 ]
// push : 배열 뒷부분에 값을 삽입
var arr = [ 1, 2, 3, 4 ];
arr.push( 5 );
console.log( arr ); // [ 1, 2, 3, 4, 5 ]
// unshift : 배열 앞부분에 값을 삽입
var arr = [ 1, 2, 3, 4 ];
arr.unshift( 0 );
console.log( arr ); // [ 0, 1, 2, 3, 4 ]
// shift : 배열 앞부분의 값을 삭제
var arr = [ 1, 2, 3, 4 ];
arr.shift();
console.log( arr ); // [ 2, 3, 4 ]

// splice( index, 제거할 요소 개수, 배열에 추가될 요소 ) : 배열의 특정위치에 요소를 추가하거나 삭제
var arr = [ 1, 2, 3, 4, 5, 6, 7 ];
arr.splice( 3, 2 );
console.log( arr ); // [ 1, 2, 3, 6, 7 ]   3번째 인덱스에서부터 2개 제거
arr = [ 1, 2, 3, 4, 5, 6, 7 ];
arr.splice( 2, 1, "a", "b");
console.log( arr ); // [ 1, 2, "a", "b", 4, 5, 6, 7 ] 2번째 인덱스에서 1개 제거 후 "a"와 "b"를 추가

// slice( startIndex, endIndex) : startIndex부터 endIndex까지(endIndex는 불포함)에 대한 shallow copy를 새로운 배열 객체로 반환
var arr = [ 1, 2, 3, 4, 5, 6, 7 ];
var newArr = arr.slice( 3, 6 ); // [ 4, 5, 6 ]

// concat : 다수의 배열을 합치고 병합된 배열의 사본을 반환
var arr1 = [ 1, 2, 3 ], arr2 = [ 4, 5, 6 ];
var arr3 = arr2.concat( arr1 ); // [ 4, 5, 6, 1, 2, 3 ]

// every : 배열의 모든 요소가 제공한 함수로 구현된 테스트를 통과하는지를 테스트
var arr =[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
var isEven = function( value ) {
  // value가 2의 배수이면 true를 반환한다.
  return value % 2 === 0;
};
console.log( arr.every( isEven ) ); // false  모든 요소가 true이면 true를 return 하고 그렇지 않으면 false

// some : 지정된 함수의 결과가 true일 때까지 배열의 각 원소를 반복
var arr =[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
var isEven = function( value ) {
  // value가 2의 배수이면 true를 반환한다.
  return value % 2 === 0;
};
console.log( arr.some( isEven ) ); // true  하나라도 true이면 true를 return

// forEach : 배열의 각 원소별로 지정된 함수를 실행한다.
var arr =[ 1, 2, 3 ];
arr.forEach( function( value ) {
  console.log( value );   // 1 2 3
});

// map : 배열의 각 원소별로 지정된 함수를 실행한 결과로 구성된 새로운 배열을 반환한다.
var arr =[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
var isEven = function( value ) {
  return value % 2 === 0;
};
var newArr = arr.map( isEven );
console.log( newArr ); // [ false, true, false, true, false, true, false, true, false, true ]

// filter : 지정된 함수의 결과 값을 true로 만드는 원소들로만 구성된 별도의 배열을 반환한다.
var arr =[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
var isEven = function( value ) {
  return value % 2 === 0;
};
var newArr = arr.filter( isEven );
console.log( newArr ); // [ 2, 4, 6, 8, 10 ]

// reduce : 누산기(accumulator) 및 배열의 각 값(좌에서 우로)에 대해 (누산된) 한 값으로 줄도록 함수를 적용
var arr =[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
var value = arr.reduce( function( previousValue, currentValue, index ) {
  return previousValue + currentValue;
});
console.log( value ); // 55

// reverse : 배열의 원소 순서를 거꾸로 바꾼다.
var arr =[ 1, 2, 3, 4 ];
arr.reverse(); // [ 4, 3, 2, 1 ]

// sort : 배열의 원소를 알파벳순으로, 또는 지정된 함수에 따른 순서로 정렬한다. 모든 원소를 문자열로 취급해 사전적으로 정렬 
var arr = [ 13, 12, 11, 10, 5, 3, 2, 1 ];
arr.sort();
console.log( arr ); // [ 1, 10, 11, 12, 13, 2, 3, 5 ];

// sort에 함수로 정렬
var arr = [ 13, 12, 11, 10, 5, 3, 2, 1 ];
arr.sort( function( a, b ) {
  return a - b;
})
console.log( arr ); // [ 1, 2, 3, 5, 10, 11, 12, 13 ]

// toString : 배열을 문자열로 바꾸어 반환한다
var arr =[ 1, 2, 3, 4 ];
console.log( arr.toString() ); // 1, 2, 3, 4

// valueOf : toString과 비슷, 그러나 배열을 반환
var arr =[ 1, 2, 3, 4 ];
console.log( arr.valueOf() ); // [ 1, 2, 3, 4 ]

// join : 배열 원소 전부를 하나의 문자열로 합친다.
var arr =[ 1, 2, 3, 4 ];
console.log( arr.join() );      // 1,2,3,4
console.log( arr.join( '-' ) ); // 1-2-3-4
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

## 정규 표현식
```js
/^A/ // A로 시작하는 문자열
/A$/ // A로 종료하는 문자열
* // 0회 이상 반복
+ // 1회 이상 반복
? // 0회 또는 1회 반복
. // 모든 단일 문자 1개와 대응
a{2}  // a가 2번 나타남
X|Y // X 혹은 Y
\ // 특수문자 앞에 위치한 백슬래시는 문자그대로 확인
[] // 문자 셋
```

## 입력
```js
var input = prompt('당신의 나이는?', '여기에 값을 입력하세요.'); // 문자열
```

### 백준 입력
```js
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line', function(line) {
  console.log(line);

  rl.close();
}).on("close", function() {
  process.exit();
});
```

```js
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  input.push(line)
})
  .on('close', function () {
  console.log(input);
  process.exit();
});
```

```js
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

let num = Number(input);

for (let i = 1; i <= num; i++) {
  console.log(i);
}
```

```js
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let count = input[0];
let numbers = [];

for (let i = 1; i < input.length; i++) {
  if (input[i] !== '') {
    numbers.push(input[i].split(' '));
  }
}

for (let i = 0; i < numbers.length; i++){
  let num1 = Number(numbers[i][0]);
  let num2 = Number(numbers[i][1]);

  console.log(num1 + num2);
}
```

```js
let input = require('fs').readFileSync('./dev/temp').toString().split('\n');
input = input.map(value => Number(value));
console.log(input);

input.sort(function (a, b) {
  console.log();
  console.log(input)
  console.log(a, b)
  return a - b;
})

console.log();
console.log(input);
console.log();

// compareFunction(a, b) < 0 => a를 b보다 낮은 인덱스로 소트
// compareFunction(a, b) = 0  => 그대로 이후 해당 두개는 무시됨
// compareFunction(a, b)이  => b를 a보다 낮은 인덱스로 소트
// compareFunction(a, b)은 
// 요소 a와 b의 특정 쌍이 두 개의 인수로 주어질 때 항상 동일한 값을 반환해야합니다. 
//일치하지 않는 결과가 반환되면 정렬 순서는 정의되지 않습니다.
```
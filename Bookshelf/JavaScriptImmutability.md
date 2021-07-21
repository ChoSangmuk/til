# JavaScript Immutability

- [인프런(생활코딩 - JavaScript Immutability)](https://www.inflearn.com/course/javascript-immutability/dashboard)
- [생활코딩 홈페이지](https://opentutorials.org/module/4075)
- [Youtube divide](https://www.youtube.com/playlist?list=PLuHgQVnccGMBxNK38TqfBWk-QpEI7UkY8)

## 1. 수업 소개
- [WEB2 JavaScript](https://opentutorials.org/course/3085) 수업 참고
- [WEB2 Node.js](https://opentutorials.org/course/3332) 수업 참고
```js
mutate - 변화
mutable - 변화 가능한
mutability - 변화 가능함 

immutability - 변화 가능하지 않음
```
- 데이터의 원본이 변경, 훼손 가능 여부에 대한 것
  - 원시 데이터 타입과 객체의 동작방법 간의 차이
  - 객체를 복제하는 방법
  - 원본 객체를 수정하지 않고 복제본을 수정하는 방법

## 2. 이름에 대한 불변함: const vs. var
- 변수가 가르키는 (메모리 상의) 값을 불변하게 유지
```js
var v = 1; // v 라는 이름의 값은 1 이다
v = 2;
console.log('v :', v); // 2

// "이름이 가르키는 값을 어떻게 불변하게 할것 인가"
const c = 1; // 값을 변경 되는 것이 불가능
c = 2; // type error 발생
```

## 3.0. 변수 할당 방식 비교
- (메모리 상의) 값 자체를 불변하게 유지
- 자바스크립트는 여러 가지 데이터 타입이 존재
- primitive : 원시 데이터 타입, 더 이상 쪼갤 수 없는 최소한의 데이터
  - Number
  - String
  - Boolean
  - Null
  - Undefined
  - Symbol
- Object : 객체, 복합적인 요소들의 집합, 서로 연관된 것의 모음
  - Object
  - Array
  - Function
- 자바스크립트에서 어떠한 값을 가르킬 때, 어떠한 타입인지에 따라 동작 방법이 완전히 다름

## 3.1. 초기 값의 비교
```js
var p1 = 1; // 메모리 상의 A 공간에 1이 위치하고, p1은 A를 가르킴
var p2 = 1; // 이미 메모리 상의 A라는 공간에 1이라는 값이 존재하기 때문에 P2도 A를 가르킴
console.log(p1,p2,p1===p2);// p1, p2는 메모리 상의 같은 공간을 가르킴, true
// === true 의 의미는 메모리 상의 같은 값을 가르킨다는 의미
// 여기서 1은 원시 데이터 타입(Number)임 -> 더 이상 변경 될 수 없음, 불변, immutability
 
var o1 = {name:'kim'} // 메모리 상의 A 공간에 객체가 위치하고, o1은 A를 가르킴
var o2 = {name:'kim'} // 메모리 상의 B 공간에 객체가 위치하고, o2은 B를 가르킴
// 객체의 경우 같이 같아도 메모리상에 다른 공간에 위치하게됨
console.log(o1,o2,o1===o2); // o1, o2는 메모리 상의 다른 공간을 가르킴, false
// 객체의 프로퍼티는 계속해서 변경될 수 있음
// 객체는 변경의 가능성이 있기 때문에 같은 값의 객체라고 해도 별도로 생성하여 따로따로 보관
```

## 3.2. 객체의 가변성
```js
var p1 = 1 
var p2 = 1
var p3 = p1 // 1은 원시 데이터 타입이고 불변이기 때문에, p3는 p1, p2와 메모리 상의 같은 1을 가르킴
p3 = 2 // 2 라는 데이터가 없기 때문에 2라는 데이터가 메모리 상에 새롭게 위치하고 p3는 2를 가르킴, p1, p2는 변경되지 않음

var o1 = {name:'kim'} // 메모리 상의 A 공간에 객체가 위치하고, o1은 A를 가르킴
var o2 = {name:'kim'} // 메모리 상의 B 공간에 객체가 위치하고, o2은 B를 가르킴
var o3 = o1 // o3는 A를 가르킴
o3.name = 'lee' // A를 가르키던 o1의 값도 변경됨
```
- 의도했다면 굉장히 편한 기능, 아니라면 심각한 버그
- 원본 데이터는 수정되지 않고 o3만 바꾸고 싶을 떄는 어떻게 해야할까?

## 3.3. 객체의 복사
```js
var o1 = {name:'kim'} // 메모리 상의 A 공간에 객체가 위치하고, o1은 A를 가르킴
var o2 = o1 // o2는 A를 가르킴
// o2.name ='lee' // o1도 영향을 받음

// o1의 값을 복사해서 복사한 값을 o3가 가지자
var o3 = Object.assign({}, o1); // 메모리 상의 B 공간에 객체가 위치하고, o3은 B를 가르킴
// assign은 0번째 객체와 뒤에따라오는 객체들을 병합해서 하나의 객체로 만들어줌
o3.name = 'lee'; // B만 변경됨, A는 영향이 없음
console.log(o1, o3, o1 === o3); // false
```

## 3.4. 중첩된 개체의 복사
- Nested(중첩된) object : 객체가 중복되는 경우
```js
var o1 = {name:'kim', score:[1,2]};
// {name:"kim",score:o1o} 메모리 상의 A라는 공간에 저장
// [1,2] 메모리 상의 B라는 공간에 저장됨
// o1은 메모리 상의 A를 가르키고 o1o은 메모리 상의 B를 가르킴
var o2 = Object.assign({}, o1);
// {name:"kim",score:o2o} C라는 공간에 저장
// o2는 c를 가르키고, o2o는 B를 가르킴
// assign을 이용하여 객체를 복사했지만, score는 여전히 같은 공간을 가르킴
// o2.score.push(3); // push는 원본(B)을 바꿔버림 -> o1도 영향을 받음
o2.score = o2.score.concat();
// concat은 원본을 복사하여 (인자를 추가하여) 새롭게 할당 
// 이렇게 하면 [1,2]는 새로운 공간 D에 생성됨
// slice, Array.from 사용
console.log(o1, o2, o1 === o2, o1.score === o2.score); // false, false
```

## 4. 불변의 함수 만들기
```js
// o1의 값을 변경해 버림
function fn(person){
  person.name ='lee';
}
var o1 = {name:"kim"};
fn(o1);

// o1의 값이 변경되지 않음
function fn(person){
  person = Object.assign({},person);
  person.name ='lee';
  return person
}
var o1 = {name:"kim"};
var o2 = fn(o1);

// o1의 값이 변경되지 않음
function fn(person){
  person.name ='lee';
}
var o1 = {name:"kim"};
var o2 = Object.assign({},o1);
fn(o2);
```

## 5. 가변과 불변 API 비교
- JavaScript 배열 내장 API에 관하여
```js
var score = [1,2,3];
score.push(4); // 원본을 변경
var score2 = score.concat(4)// 원본은 그대로
```
- 무엇이 옮다고 할 수 없음, 올바른 상황에 맞게 사용해야함

## 6. Object freeze로 객체를 불면하게 만들기
- 원본 데이터 수정이 되지 않게 주의하는 것도 좋지만 아예 변경 가능성 자체를 막는 것도 좋은 방법
- Object.freeze 객체의 프로퍼티를 얼림
```js
var o1 = {name:'kim', score:[1,2]}
Object.freeze(o1);

o1.name = 'lee'; // o1의 name가 변경되지 않음
// freeze를 푸는 명령어는 없음, 변경을 원하면 복사해서 써야함
o1.city = 'seoul'; // 존재하지 않던 프로퍼티를 추가하는 것은 막을 수 있음
o1.score.push(3); // Nested(중첩된) object의 변경은 막을 수 없음, 상단에 Object.freeze(o1.score)를 추가하면 막을 수 있음
console.log(o1);
```

## 7. const vs. object freeze
- const와 Object.freeze의 차이
- const는 "이름이 가르키는 대상(메모리 상의 값)"을 못바꾸게함
- Object.freeze "값"을 변경할 수 없게한다
```js
const o1 = {name:"kim"};
Object.freeze(o1);
const o2 = {name:"lee"};
// o1 = o2 // const 때문에 오류
o1.name = 'park'; // 오류는 없지만 변경되지 않음
```

## 8. 수업을 마치며
- 불변함은 발전된 개념이 아니며, 적당하고 합리적인 선택을 해야함
- 더 공부할 것
  - Functional Programming 
    - 함수를 부품으로 사용하는 프로그래밍 패러다임
    - 부품은 항상 같은 결과를 내놓아야함 -> 순수 함수(pure function), immutability 해야함
  - 불변 라이브러리 - 성능 저하를 최소화할 수 있음
    - immutable.js
    - immer
    - mori
  - react : 컴포넌트 생성 & 수정 시, 이전 데이터와 현재 데이터를 비교 함
    - 불변으로 만들어둔다면 단순 비교 연산자(===)로 데이터 변경 여부를 확인 가능
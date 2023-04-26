# RegExp
- 자주 사용되는 자바스크립트 문자열 정규 표현식 (Regular Expressions)

## Summary
- In JavaScript, regular expressions are also objects.
- RegExp exec(), test()
- String match(), matchAll(), replace(), replaceAll(), search(), split()
```
{} -> 반복하는 방법
() -> 기억하고 재사용하는 방법
[] -> 문자셋 
```

-----

## 패턴 작성
### 선언
- 단순 문자와 특수 문자의 조합으로 나타내짐
```js
const re = /ab+c/; // 정규식 리터럴, 슬래시(/)로 감싸는 패턴
let re = new RegExp("ab+c"); //  RegExp 객체의 생성자 함수를 호출
```

### 단순 패턴
- 문자열이 있는 그대로 대응될 때
- ex) /abc/라는 패턴은 문자열에서 정확히 'abc' 라는 문자들이 모두 함께 순서대로 나타나야 대응

### 특수 문자 사용 
- 단순 패턴 이상의 복잡한 패턴에 대한 대응이 필요할 때
- ex) /ab\*c/ 패턴은  'a' 문자 뒤에 0개 이상의 'b' 문자가 나타나고 바로 뒤에 'c' 문자가 나타나는 문자 조합에 대응

-----

## 정규식에서의 특수문자
### 1. 백슬래시, 이스케이프 ( \\ )
- 특수 문자가 아닌 문자(non-special character) 앞에서 사용된 백슬래시는 '해당 문자는 특별하고, 문자 그대로 해석되면 안된다'
- 특수 문자 앞에 위치한 백슬래시는 '다음에 나오는 문자는 특별하지않고, 문자 그대로 해석되어야 한다'
```js
// +++ 백슬래시(\) 는 문자열에서도 이스케이프 문자
// +++ RegExp("pattern") pattern에 백슬래시(\)를 쓰려면 \ 자체를 이스케이프 해야함 
// +++ /pattern\*/ = new RegExp('pattern\\*')와 같이 백슬래시 자체를 이스케이프 해야함

// /pattern\*/ // /pattern\*/
// new RegExp('pattern*') // /pattern*/
// new RegExp('pattern\*') // /pattern*/
// new RegExp('pattern\\*') // /pattern\*/

// /pattern\*/.test('pattern*') // true
// new RegExp('pattern*').test('pattern*') // true
// new RegExp('pattern\*').test('pattern*') // true
// new RegExp('pattern\\*').test('pattern*') // true
```

### 2. 문자열의 시작 ( ^ ) 과 종료 ( $ )
- 각각 입력의 시작, 끝 부분에 대응
- 다중 행 플래그( m ) 설정 시, 각기 다른 문자열처럼 검사
- '^' 가 문자셋( [abc] ) 패턴의 첫 글자로 쓰인다면, 그 때는 전혀 다른 의미를 가짐
```js
console.log(/^A/.test("an A"));   // false
console.log(/^A/.test("An E"));   // true 
console.log(/t$/.test("eater"));  // false
console.log(/t$/.test("eat"));    // true

console.log(/^A/m.test(`Commodo est.
ACommodo dolore aliqua in labore eiusmod non aliquip exercitation dolor officia commodo est.
Commodo est.`)); // true 

console.log(/A$/m.test(`Commodo est.
ACommodo dolore aliqua in labore eiusmod non aliquip exercitation dolor officia commodo est.A
Commodo est.`)); // true 
``` 

### 3. 문자의 반복 
__0 회 이상 반복 ( * ) === {0,}__
- 앞의 표현식이 0회 이상 연속으로 반복되는 부분과 대응
```js
console.log(/bo*/.test("A ghost booooed")); // true, 'boooo' 와 대응
console.log(/bo*/.test("A bird warbled"));  // true, 'b' 와 대응
console.log(/bo*/.test("A goat grunted"));  // false
```
__1 회 이상 반복 ( + ) === {1,}__
- 앞의 표현식이 1회 이상 연속으로 반복되는 부분과 대응
```js
console.log(/a+/.test("candy"));        // true, 'a' 와 대응
console.log(/a+/.test("caaaaaaandy"));  // true, 모든 'a' 들에 대응
console.log(/a+/.test("cndy"));         // false
```
__0회 또는 1 회 반복 ( ? ) === {0,1}__
- 앞의 표현식이 0 또는 1회 등장하는 부분과 대응
```js 
console.log(/e?le?/.test("angel"));   // true, 'el' 와 대응
console.log(/e?le?/.test("angle"));   // true, 'le' 와 대응
console.log(/e?le?/.test("oslo"));    // true, 'l' 와 대응

// +++ 만약 수량자 *, +, ?, {} 바로 뒤에 사용하면, 기본적으로 탐욕스럽던(가능한 한 많이 대응시킴) 수량자를 탐욕스럽지 않게(가능한 가장 적은 문자들에 대응시킴) 만듭니다. 예를 들어, /\d+/를 "123abc"에 적용시키면 "123"과 대응됩니다. 그러나 /\d+?/를 같은 문자열에 적용시키면 오직 "1"과만 대응
// +++ 또한 이 문자는 x(?=y) 와 x(?!y) 항목에서 설명하는 바와 같이 사전 검증(lookahead assertion)을 위해서도 쓰입니다.
```
__횟수만큼 반복 ( {n} )__
- 앞 표현식이 n번 나타나는 부분에 대응 (n은 반드시 양의 정수)
```js 
console.log(/a{2}/.test("caandy."));    // true, 모든 'a' 와 대응
console.log(/a{2}/.test("caaandy."));   // true, 첫 'aa' 에 대응
console.log(/a{2}/.test("candy."));     // false
```
__특정 범위 내 반복 ( {n, m} )__
- 앞 문자가 최소 n개, 최대 m개가 나타나는 부분에 대응 (n과 m은 양의 정수이고, n <= m를 만족) 
- m이 생략된다면, m은 ∞로 취급
```js
console.log(/a{1,3}/.test("caandy."));        // true, 'aa' 와 대응
console.log(/a{1,3}/.test("caaaaaaandy."));   // true, 첫 'aaa' 에만 대응
console.log(/a{1,3}/.test("cndy."));         // false
```

### 4. OR ( x|y )
- 'x' 또는 'y'에 대응
```js
console.log(/green|red/.test("green apple")); // true, 'green'에 대응
console.log(/green|red/.test("red apple"));   // true, 'red'에 대응
console.log(/green|red/.test("greeed"));      // false
```

### 5. 단일 문자 대응( . )
- 개행 문자를 제외한 모든 단일 문자와 대응
```js
console.log(/.n/.test("nay, an apple is on the tree")); // true, 'an'과 'on'에 대응
console.log(/.n/.test("nay, apple is the tree"));       // false, 'nay' 에는 대응되지 않음
```

### 6. 포획 기억 ( (x) )
- 'x'에 대응하고 해당 내용을 기억
- 포획 괄호(capturing parentheses)
- \\n 패턴은 앞의 n번째 포획 괄호에 대응된 문자열과 똑같은 문자열에 대응
```js
console.log(/(foo) (bar) \1 \2/.test("foo bar foo bar"));     // true, 'foo bar foo bar' 와 대응
console.log(/(foo) (bar) \1/.test("foo bar foo bar"));        // true, 'foo bar foo' 와 대응
console.log(/(foo) (bar) \1 \1/.test("foo bar foo foo---"));  // true, 'foo bar foo foo'와 대응
console.log(/(foo) (bar) \1 \1/.test("foo bar foo bar---"));  // false

// +++ \1, \2, \n과 같은 문법은 정규식의 패턴 부분에서 사용됩니다. 
// +++ 정규식의 치환 부분에서는 $1, $2, $n과 같은 문법이 사용되어야 합니다. 
// +++ 예를 들어, 'bar foo'.replace( /(...) (...)/, '$2 $1')와 같이 사용되어야 합니다.
// +++ $& 패턴은 앞에서 대응된 전체 문자열을 가리킵니다.
// +++ console.log('bar foo'.replace( /(...) (...)/, '$2 $1'));      // foo bar
```

### 12. 포획 ( (?:x) )
- 'x'에 대응되지만 대응된 것을 기억하지 않음
- 비포획 괄호(non-capturing parentheses)
```js
console.log(/foo{1,2}/.exec('foo'));
fo
foo
fooo
foofoo

/foo{1,2}/ // foo, fooo
/(foo){1,2}/ // foo, foofoo
/(?:foo){1,2}/ // foo, foofoo

// +++ 정규식 연산자가 같이 동작할 수 있게 하위 표현을 정의할 수 있습니다. 정규식 예제 /(?:foo){1,2}/을 생각해보세요. 만약 정규식이 /foo{1,2}/라면, {1,2}는 'foo'의 마지막 'o' 에만 적용됩니다. 비포획 괄호과 같이 쓰인다면, {1,2}는 단어 'foo' 전체에 적용됩니다.
```

### 13. lookahead ( x(?=y) )
```
+++ 오직 'y'가 뒤따라오는 'x'에만 대응

+++ /Jack(?=Sprat)/ 는 'Sprat'가 뒤따라오는 'Jack' 에만 대응
+++ /Jack(?=Sprat|Frost)/는 'Sprat' 또는 'Frost'가 뒤따라오는 'Jack'에만 대응됩니다. 그러나, 'Sprat' 및 'Frost' 는 대응 결과의 일부가 아닙니다.
```

### 14. negated lookahead ( x(?!y) )
```
+++ 'x'뒤에  'y'가 없는 경우에만 'x'에 일치

+++ /\d+(?!\.)/는 소숫점이 뒤따라오지 않는 숫자에 일치
+++ 정규식 /\d+(?!\.)/.exec("3.141")는 '3.141' 이 아닌 '141'에 일치합니다.
```

### 15. Character set ( \[xyz\] )
```
+++ 문자셋(Character set) 입니다. 이 패턴 타입은 괄호 안의 어떤 문자(이스케이프 시퀀스까지 포함)와도 대응
+++ 점(.) 이나 별표 (*) 같은 특수 문자는 문자셋 내부에서는 특수 문자가 아닙니다. 따라서 이스케이프시킬 필요가 없습니다. 
+++ 하이픈을 이용하여 문자의 범위를 지정해줄 수 있습니다.

+++ 패턴 [a-d] 는 패턴 [abcd] 와 똑같이 동작, "brisket"의 'b' 에 일치하고, "city"의 'c' 에 일치
+++ 패턴 /[a-z.]+/ 와 /[\w.]+/ 는 "test.i.ng" 전체 문자열이 일치
```

## 플래그
- 전역 검색 및 대소문자 구분 검색과 같은 기능을 허용하는 optional flags 가 존재
- 플래그는 순서에 관계없이 개별적으로 또는 함께 사용할 수 있으며 정규식의 일부로 포함

|Flag|Description|Corresponding property|
|-----|-----|-----|
|g|패턴과 일치하는 모든 것들을 검색<br>Flag가 없는 경우 패턴과 일치하는 1번째 결과만 반환|RegExp.prototype.global|
|i|대소문자를 구분하지 않는 검색|RegExp.prototype.ignoreCase|
|m|다중 행 모드(multiline mode)를 활성화|RegExp.prototype.multiline|
|s|( . )이 개행 문자(\n)를 포함하도록 활성화|RegExp.prototype.dotAll|
|-----|-----|-----|
|d|하위 문자열 일치에 대한 인덱스를 생성합니다.<br>Generate indices for substring matches.|RegExp.prototype.hasIndices|
|u|유니코드 전체 지원<br>패턴을 유니코드 코드 포인트의 시퀀스로 취급<br>"unicode"; treat a pattern as a sequence of unicode code points.|RegExp.prototype.unicode|
|y|문자 내 특정 위치에서 검색을 진행하는 ‘sticky’ 모드를 활성화 <br>대상 문자열의 현재 위치에서 시작하여 일치하는 "고정" 검색을 수행<br>Perform a "sticky" search that matches starting at the current position in the target string. See sticky.|RegExp.prototype.sticky|

## Reference
- https://ko.javascript.info/regexp-introduction
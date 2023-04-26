# String
- 자주 사용되는 자바스크립트 문자열 Instance methods

## Summary
- 문자열 메소드는 보통 다음과 같은 특징을 가짐
  - case sensitive
  - startIndex는 포함됨, endIndex의 경우 미포함(startIndex <= ~ < endIndex)
  - Default str ==> undefined, ''
  - str = '' ==> 항상 존재
  - Default startIndex ==> 0, 오류
  - Default endIndex ==> sampleStr.length
  - Index < 0 ==> 0, Index, 알 수 없음
  - Index >= sampleStr.length ==> sampleStr.length, 알 수 없음

- index를 통해 조회하는 경우, 되도록이면 0 <= index <= sampleStr.length, 시작 index < 종료 index 가 되게끔 입력

## 선언
```js
var sampleStr = new String("To be, or not to be, that is the question."); 
var sampleStr = "To be, or not to be, that is the question.";
sampleStr.length // 42, 길이는 함수가 아니라 속성
```

## 1. at(startIndex), charAt(startIndex), \[startIndex\], charCodeAt(startIndex)
- return String 
- 해당 인덱스의 문자 반환
- 문자열은 유사 배열임으로 배열처럼 접근이 가능
```js
let sampleStr = 'To be, or not to be, that is the question.' // 42

console.log(sampleStr.at(1));               // o
console.log(sampleStr.charCodeAt(1));       // 111
console.log(sampleStr[1]);                  // o
console.log(sampleStr.charAt(1));           // o

// Default startIndex ==> 0, 오류
console.log(sampleStr.at());                // T
console.log(sampleStr.charAt());            // T
// console.log(sampleStr[]);                // SyntaxError
console.log(sampleStr.charCodeAt());        // 84

// startIndex < 0 ==> startIndex, 알 수 없음
console.log(sampleStr.at(-2));              // n
console.log(sampleStr.charAt(-2));          // ''
console.log(sampleStr[-2]);                 // undefined
console.log(sampleStr.charCodeAt(-2));      // NaN
console.log(sampleStr.at(-45));              // undefined
console.log(sampleStr.charAt(-45));          // ''
console.log(sampleStr[-45]);                 // undefined
console.log(sampleStr.charCodeAt(-45));      // NaN

// startIndex >= sampleStr.length ==> 알 수 없음
console.log(sampleStr.at(45));              // undefined
console.log(sampleStr.charAt(45));          // ''
console.log(sampleStr[45]);                 // undefined
console.log(sampleStr.charCodeAt(45));      // NaN

console.log("a" < "b");                     // true
console.log("a" < "aa");                    // true
```

## 2. includes(str[, startIndex])
- return boolean
- 문자열의 존재 여부, ES6
- 정규 표현식 사용 불가, 변수, 특수문자 사용 가능
- 꼭 필요한 경우가 아니라면 index를 반환해주는 메소드를 먼저 고려
```js
let sampleStr = 'To be, or not to be, that is the question.' // 42

// Default str ==> undefined
console.log(sampleStr.includes());                  // false
console.log("undefined".includes());                // true

// str = '' ==> 항상 존재
console.log(sampleStr.includes(''));                // true

// Default startIndex ==> 0
console.log(sampleStr.includes('nottobe'));         // false
console.log(sampleStr.includes('not to be'));       // true
console.log(sampleStr.includes('not to be', ));     // true

// startIndex < 0 ==> 0
console.log(sampleStr.includes('not to be', -2));   // true
console.log(sampleStr.includes('not to be', -100)); // true

// startIndex >= sampleStr.length ==> sampleStr.length
console.log(sampleStr.includes('.', 50));           // false
```

## 3. endsWith(str[, endIndex]), startsWith(str [, startIndex]) ES6
- return boolean 
- str로 시작 혹은 종료 여부
- 정규 표현식을 사용 불가, 변수, 특수문자 사용 가능
- 꼭 필요한 경우가 아니라면 index를 반환해주는 메소드를 먼저 고려
```js
let sampleStr = 'To be, or not to be, that is the question.'; // 42

// Default str ==> undefined
console.log(sampleStr.endsWith());                    // false
console.log("undefined".endsWith());                  // true
console.log(sampleStr.startsWith());                  // false
console.log("undefined".startsWith());                // true

// str = '' ==> 항상 존재
console.log(sampleStr.endsWith(''));                  // true
console.log(sampleStr.startsWith(''));                // true

// Default startIndex, startIndex < 0 ==> 0
console.log(sampleStr.startsWith('To be'));           // true
console.log(sampleStr.startsWith('To be',));          // true
console.log(sampleStr.startsWith('To be', -1));       // true
console.log(sampleStr.startsWith('To be', -50));      // true

// Default endIndex, endIndex >= sampleStr.length ==> sampleStr.length
console.log(sampleStr.endsWith('question.'));         // true
console.log(sampleStr.endsWith('question.',));        // true
console.log(sampleStr.endsWith('question.', 43));     // true
console.log(sampleStr.endsWith('question.', 45));     // true

// endIndex < 0 ==> 알 수 없음
console.log(sampleStr.endsWith('question', -1));      // false
console.log(sampleStr.endsWith('question.', -1));     // false
console.log(sampleStr.endsWith('question.', -50));    // false

// startIndex >= sampleStr.length ==> 알 수 없음
console.log(sampleStr.startsWith('To be', 43));       // false
console.log(sampleStr.startsWith('To be', 45));       // false
```

## 4. *indexOf(str[, startIndex])
- return index
- 존재하는 경우 첫 index, 존재하지 않는 경우 -1
```js
let sampleStr = 'To be, or not to be, that is the question.'; // 42

// Default str ==> undefined
console.log(sampleStr.indexOf());                   // -1
console.log("- undefined".indexOf());               // 2

// str = '' ==> 항상 존재
console.log(sampleStr.indexOf(''));                 // 0
console.log(sampleStr.indexOf('', 3));              // 3

// Default startIndex, startIndex < 0 ==> 0
console.log(sampleStr.indexOf('nottobe'));          // -1
console.log(sampleStr.indexOf('not to be'));        // 10
console.log(sampleStr.indexOf('not to be', ));      // 10
console.log(sampleStr.indexOf('not to be', -2));    // 10
console.log(sampleStr.indexOf('not to be', -100));  // 10

// startIndex >= sampleStr.length ==> sampleStr.length, 알 수 없음
console.log(sampleStr.indexOf('.', 42));            // -1
console.log(sampleStr.indexOf('.', 50));            // -1
```
- 문자열에서 str 갯수 확인하는 방법
```js
let sampleStr = 'To be, or not to be, that is the question.'
let count = 0
let position = sampleStr.indexOf('e')

while (position !== -1) {
  count++
  position = sampleStr.indexOf('e', position + 1)
}
console.log(count)  // displays 4
```

## 5. lastIndexOf(str[, fromindex])
searchValue
A string representing the value to search for. If searchValue is an empty string, then fromIndex is returned.

fromIndex Optional
The index of the last character in the string to be considered as the beginning of a match. The default value is +Infinity. If fromIndex >= str.length, the whole string is searched. If fromIndex < 0, the behavior will be the same as if it would be 0.

String.indexOf("찾을 문자", index) // 찾을 문자와 일치하는 최초의 문자의 Index를 반환하는 함수, 두 번째 인자 지정 시 검색하는 시작 Index지정
String.lastIndexOf("찾을 문자") // 찾을 문자를 문자열 오른쪽에서부터 찾는 함수, 
// 두 함수 모두 일치하는 문자를 찾지 못하면 -1을 반환합니다.

## 6. match(regexp)
- return Array, immutable
- regexp이 정규식인 아닌 경우, 암묵적으로 변경 됨
- sampleStr.match() // ['']

## 7. matchAll(regexp)

## 8. concat(str[, ...strN])
- return String
- 문자열 병합 메소드 concat이 있지만 되도록 +, += 연산자 사용
```js
let sampleStr = "To be, or not to be, that is the question.";

var temp = sampleStr.concat("--a");
console.log(temp); // To be, or not to be, that is the question.--a

temp = sampleStr.concat(123);// 강제 타입 변환
console.log(temp); // To be, or not to be, that is the question.123

temp = sampleStr.concat(...[" "," A"," "," B"]);// 배열 스프레드
console.log(temp); // To be, or not to be, that is the question.  A  B

// Default str ==> ''
temp = sampleStr.concat();
console.log(temp); // To be, or not to be, that is the question.
console.log(temp === sampleStr); // true

console.log(sampleStr); // To be, or not to be, that is the question.
```

## 9. padEnd(targetLength[, padString]), padStart(targetLength[, padString])
- return String
- sampleStr의 길이가 targetLength의 길이가 되게끔 padString(default = ' ')을 각각 앞, 뒤에 붙여줌
- padString은 분리되어 붙여질 수 있음, foo => f로 붙여질 수 있음, 이때 sampleStr는 그대로 유지됨
```js
var temp = 'abc';
console.log(temp.padStart(10));         // "       abc"
console.log(temp.padStart(10, "foo"));  // "foofoofabc"
console.log(temp.padStart(6,"123465")); // "123abc"
console.log(temp.padStart(8, "0"));     // "00000abc"
console.log(temp.padStart(1));          // "abc"
console.log(temp);                      // "abc"

console.log(temp.padEnd(10));           // "abc       "
console.log(temp.padEnd(10, "foo"));    // "abcfoofoof"
console.log(temp.padEnd(6, "123456"));  // "abc123"
console.log(temp.padEnd(1));            // "abc"
console.log(temp);                      // "abc"
```

## 10. repeat(count)
- return String
- count 만큼 반복, 0 <= count < +Infinity (else RangeError)
```js
var temp = 'abc';

//console.log(temp.repeat(-1));   // RangeError
console.log(temp.repeat(0));      // ''
console.log(temp.repeat(1));      // 'abc'
console.log(temp.repeat(2));      // 'abcabc'
console.log(temp.repeat(3.5));    // 'abcabcabc' (count will be converted to integer)
//console.log(temp.repeat(1/0));  // RangeError
console.log(temp);                // "abc"
```

## 11. replace
```
replace(regexp, newSubstr)
replace(regexp, replacerFunction)

replace(substr, newSubstr)
replace(substr, replacerFunction)
```

## 12. replaceAll
```
replaceAll(regexp, newSubstr)
replaceAll(regexp, replacerFunction)

replaceAll(substr, newSubstr)
replaceAll(substr, replacerFunction)
```

String.replace("찾을 문자", "치환할 문자") // 최초로 발견된 일치하는 문자열에 대해서만 치환
String.replaceAll("찾을 문자", "치환할 문자") // 일치하는 모든 문자열에 대해서 치환

## 13. *slice(startIndex[, endIndex])
- return String
- default endIndex = sampleStr.length
- indexStart > endIndex 시, 빈 문자열
- index < 0 => Index + sampleStr.length와 같음
- index 가 검색할 문자열의 길이보다 큰 경우 길이로 치환
```js
let sampleStr = 'To be, or not to be, that is the question.' // 42
// Default startIndex ==> 0, 오류
// Default endIndex ==> sampleStr.length
console.log()
// Index < 0 ==> 0, Index, 알 수 없음
// Index >= sampleStr.length ==> sampleStr.length, 알 수 없음

```

## 14. *substring(startIndex [, endIndex])
- return String
- default endIndex = sampleStr.length
- startIndex > endIndex 시, 자동으로 스왑됨
- index < 0 => 0
- index 가 검색할 문자열의 길이보다 큰 경우 길이로 치환
- substr은 폐기
```js
let sampleStr = 'To be, or not to be, that is the question.' // 42
// Default startIndex ==> 0, 오류
// Default endIndex ==> sampleStr.length
// Index < 0 ==> 0, Index, 알 수 없음
// Index >= sampleStr.length ==> sampleStr.length, 알 수 없음
```

## 15. split([sep [, limit] ])
String.split("문자")// 첫 번째 인자 문자를 기준으로 문자열을 잘라 각 배열 요소에 담은 뒤에 해당 배열 객체를 반환해주는 함수

String.substring(startIndex, endIndex) // endIndex 미 포함
String.substr(startIndex, 문자개수)

## 16. search(regexp)
- Index return, immutable
- regexp이 정규식인 아닌 경우, 암묵적으로 변경 됨
- RegExp.prototype.test(sampleStr)로 대체될 수 있음
```js
let str = "hey JudE"
let re = /[A-Z]/g
let reDot = /[.]/g
console.log(str.search(re))    // returns 4, which is the index of the first capital letter "J"
console.log(str.search(reDot)) // returns -1 cannot find '.' dot punctuation
console.log(str); // hey JudE
```

## 17. toLowerCase(), toUpperCase()
- return String
- 대소문자 변경, null, undefined => TypeError
```js
var ALPHABET = "ALPHABET";
var alphabet = "alphabet";

console.log(ALPHABET.toLowerCase());  // alphabet
console.log(ALPHABET);                // ALPHABET
//console.log(null.toLowerCase());      // TypeError
//console.log(undefined.toLowerCase()); // TypeError

console.log(alphabet.toUpperCase());  // ALPHABET
console.log(alphabet);                // alphabet
//console.log(null.toUpperCase());      // TypeError
//console.log(undefined.toUpperCase()); // TypeError
```

## 18. trim() ES5
- return String
- trimStart(), trimLeft() : 앞의 공백 제거
- trimEnd(), trimRight() : 뒤의 공백 제거
```js
const greeting = '   Hello world!   ';

console.log(greeting.trim());         // "Hello world!";
console.log(greeting);                // "   Hello world!   ";
```

## 19. toString()
- return String
- Returns a string representing the specified object. Overrides the Object.prototype.toString() method.
```js
const stringObj = new String('foo');
console.log(stringObj); // String { "foo" }
console.log(stringObj.toString()); // "foo"
```

## 20. valueOf()
- The valueOf() method of String returns the primitive value of a String object as a string data type.
- This value is equivalent to String.prototype.toString().
```js
var x = new String('Hello world');
console.log(x.valueOf()); // Displays 'Hello world'
```

## 21. @@iterator()

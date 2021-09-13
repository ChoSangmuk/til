# Baekjoon

## Node.js 입/출력
### 터미널 입력
```js
var input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  console.log(input); // [...]
  // Logic
  process.exit();
})
```
### 파일 읽기
```js
const input = require('fs').readFileSync("/dev/stdin").toString().trim().split("\n");

console.log(input); // [...]
// Logic
```

-----

Math.ceil
Math.floor
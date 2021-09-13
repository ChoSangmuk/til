const readline = require('readline');

let input = [];
var myArray = [];// 에라토스테네스의 체

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  var max = 10000 * 2;
  myArray = Array.from({ length: max }, () => true);
  var pos = 0;
  myArray[pos++] = false;
  myArray[pos++] = false;
  while (pos < Math.sqrt(max)) {
    for (var i = pos + 1; i <= max; i++)if (i % pos === 0) myArray[i] = false;
    for (var i = pos + 1; i <= max; i++) {
      if (myArray[i] === true) {
        pos = i;
        break;
      } else if (i === max) pos = max;
    }
  }
  for (var i = 0; i < Number(input[0]); i++) {
    console.log(solution(Number(input[i + 1])));
  }
});

function solution(inputNumber) {
  var A = inputNumber / 2;
  var B = inputNumber / 2;
  while (true) {
    if (myArray[A] && myArray[B]) break;
    else {
      A--;
      B++;
    }
  }
  return A + " " + B;
}
const readline = require('readline');

let input = [];
var myArray = [];
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  if (line === "0") rl.close();
  else input.push(line);
}).on('close', function () {
  var max = 123456 * 2;
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

  for (var i = 0; i < input.length; i++) {
    console.log(solution(Number(input[i])));
  }
});

function solution(inputNumber) {
  var answer = 0;
  for (var i = inputNumber + 1; i <= inputNumber * 2; i++) if (myArray[i]) answer++;
  return answer;
}
const readline = require('readline');

let input = 0;
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = Number(line);
}).on('close', function () {
  function solution(number) {
    if (number <= 1) return number
    return solution(number - 1) + solution(number - 2);
  }
  console.log(solution(input));
});
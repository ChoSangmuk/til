let input = 0;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = Number(line);
}).on('close', function () {
  function solution(number) {
    if (number <= 1) return 1;
    return solution(number - 1) * number;
  }
  console.log(solution(input));
});
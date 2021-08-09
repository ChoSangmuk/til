const readline = require('readline');

let input = 0;
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = Number(line);
}).on('close', function () {
  function soultion(number) {
    if (number <= 1) return 1;
    return soultion(number - 1) * number;
  }
  console.log(soultion(input));
});
const readline = require('readline');

let input = [];

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line.split(" ");
}).on('close', function () {
  var x = Number(input[2]) - Number(input[0]) < Number(input[0]) ? Number(input[2]) - Number(input[0]) : Number(input[0]);
  var y = Number(input[3]) - Number(input[1]) < Number(input[1]) ? Number(input[3]) - Number(input[1]) : Number(input[1]);
  console.log(x < y ? x : y);
  process.exit();
});
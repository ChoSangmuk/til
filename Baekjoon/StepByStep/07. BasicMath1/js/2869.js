let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line.trim().split(" ");
}).on('close', function () {
  console.log(Math.ceil((Number(input[2]) - Number(input[0])) / (Number(input[0]) - Number(input[1]))) + 1);
});
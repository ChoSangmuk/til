let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line.split(" ").map(v => +v);
}).on('close', function () {
  let result = 0;
  input.sort((a, b) => a - b).forEach((v, i) => result += (input.length - i) * v)
  console.log(result);
  process.exit();
});
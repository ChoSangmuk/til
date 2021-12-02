let input = "";
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line;
}).on('close', function () {
  console.log(input.split("").map(v => +v).reduce((a, b) => a + b));
  process.exit();
});
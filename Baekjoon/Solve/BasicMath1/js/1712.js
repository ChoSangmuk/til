let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line.trim().split(" ");
}).on('close', function () {
  var result = Number(input[2]) - Number(input[1]);
  if (result <= 0) result = -1;
  else result = Math.floor(Number(input[0]) / result) + 1;
  console.log(result);
  process.exit();
});
let input;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = parseInt(line);
}).on('close', function () {
  for (i = 1; i <= 9; i++) console.log(input + " * " + i + " = " + input * i);
  process.exit();
});
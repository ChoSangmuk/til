let input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  for (i = 2; i >= 0; i--)  console.log(input[0] * input[1][i]);
  console.log(input[0] * input[1]);
  process.exit();
});
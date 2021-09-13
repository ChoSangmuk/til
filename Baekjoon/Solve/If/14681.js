let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  if (input[0] > 0 && input[1] > 0) console.log(1);
  else if (input[0] > 0 && input[1] < 0) console.log(4);
  else if (input[0] < 0 && input[1] > 0) console.log(2);
  else if (input[0] < 0 && input[1] < 0) console.log(3);
  process.exit();
});
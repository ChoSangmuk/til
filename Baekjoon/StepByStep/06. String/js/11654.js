let input;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line;
}).on('close', function () {
  console.log(input.charCodeAt(0));
  process.exit();
});
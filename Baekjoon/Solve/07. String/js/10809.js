let input = "";
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line;
}).on('close', function () {
  let result = "";
  for (i = 97; i <= 122; i++) result += input.indexOf(String.fromCharCode(i), 0) + " ";
  console.log(result);
  process.exit();
});
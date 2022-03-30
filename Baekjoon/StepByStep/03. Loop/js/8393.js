let input;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = parseInt(line);
  let result = 0;
  for (i = 1; i <= input; i++) result += i;
  console.log(result);
  process.exit();
});
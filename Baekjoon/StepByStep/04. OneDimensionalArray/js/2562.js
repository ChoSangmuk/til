let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  input = input.map(v => +v);
  var max = 0;
  for (i = 0; i < input.length; i++) if (input[max] < input[i]) max = i;
  console.log(input[max] + "\n" + (max + 1));
  process.exit();
});
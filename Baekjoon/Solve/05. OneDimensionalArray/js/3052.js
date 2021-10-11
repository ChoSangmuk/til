let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  var output = Array.from({ length: 42 }, v => 0);
  for (i = 0; i < input.length; i++) output[parseInt(input[i]) % 42]++;
  console.log(output.filter(v => v != 0).length);
  process.exit();
});
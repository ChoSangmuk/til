let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  var temp = input[1].split(' ');
  var min = parseInt(temp[0]), max = parseInt(temp[0]);
  for (i = 0; i < input[0]; i++) {
    min = min >= parseInt(temp[i]) ? parseInt(temp[i]) : min;
    max = max <= parseInt(temp[i]) ? parseInt(temp[i]) : max;
  }
  console.log(min + " " + max);
  process.exit();
});
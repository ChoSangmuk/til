let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  var i = 0;
  while (i < input.length) {
    var temp = input[i++].split(' ');
    console.log((parseInt(temp[0]) + parseInt(temp[1])));
  }
  process.exit();
});
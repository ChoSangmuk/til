let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  var temp = input[0].split(' ');
  if (parseInt(temp[0]) > parseInt(temp[1])) console.log('>');
  else if (parseInt(temp[0]) < parseInt(temp[1])) console.log('<');
  else console.log('==');
  process.exit();
});
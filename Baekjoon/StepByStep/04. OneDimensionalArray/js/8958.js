let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  for (i = 0; i < parseInt(input[0]); i++) {
    var temp = input[i + 1].split("X");
    var score = 0;
    for (j = 0; j < temp.length; j++) score += ((temp[j].length + 1) * temp[j].length) / 2;
    console.log(score);
  }
  process.exit();
});
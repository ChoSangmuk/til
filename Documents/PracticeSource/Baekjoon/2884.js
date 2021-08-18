const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  input.push(line)
})
  .on('close', function () {
    var temp = input[0].split(' ');
    var temp_m = temp[1] < 45 ? 15 + parseInt(temp[1]) : parseInt(temp[1]) - 45;
    var temp_h = temp[1] < 45 ? parseInt(temp[0]) - 1 : temp[0];
    temp_h = temp_h < 0 ? 23 : temp_h;
    console.log(temp_h + " " + temp_m)
    process.exit();
  });
const readline = require('readline');

let input = [];

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  for (var i = 0; i < Number(input[0]); i++) {
    console.log(problem(input[i + 1]));
  }
});

function problem(input) {
  var temp = input.split(" ");
  var answer = Number(temp[0])%10;
  for (var j = 0; j < Number(temp[1])-1; j++) {
    answer = (answer * Number(temp[0])%10)%10;
  }
  return answer===0?10:answer;
}
const readline = require('readline');

let input = "";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line;
}).on('close', function () {
  console.log(problem(input));
});

function problem(input) {
  let answer = input.length;
  for (i = 0; i < input.length; i++) {
    var temp = input.charAt(i).charCodeAt(0) - 65; //A=0, B=1, ...
    if (temp < 18) answer += (parseInt(temp / 3) + 2);
    else if (temp === 18) answer += 7;
    else if (temp < 22) answer += 8;
    else answer += 9;
  }
  return answer;
}
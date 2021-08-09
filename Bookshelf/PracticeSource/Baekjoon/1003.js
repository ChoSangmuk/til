let result = [];
let input = []
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  input.shift();
  input.forEach(element => {
    console.log(solution(Number(element)).join(" "));
  });
});

function solution(initInput) {
  if (result[initInput] === undefined) {
    if (initInput === 0) result[initInput] = [1, 0];
    else if (initInput === 1) result[initInput] = [0, 1];
    else {
      var n_1 = solution(initInput - 1);
      var n_2 = solution(initInput - 2);
      result[initInput] = [n_1[0] + n_2[0], n_1[1] + n_2[1]];
    }
  }
  return result[initInput];
}
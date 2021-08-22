let input = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  var kinds = [];
  var target = Number(input[0].split(" ")[1]);
  for (var i = 0; i < Number(input[0].split(" ")[0]); i++)kinds.push(input[i + 1]);
  console.log(solution(kinds, target));
  process.exit();
});

function solution(kinds, target) {
  var result = 0;
  var targetCopy = target;
  for (var i = kinds.length - 1; i >= 0; i--) {
    var temp = Math.floor(targetCopy / kinds[i]);
    if (temp >= 1) {
      targetCopy -= (temp * kinds[i]);
      result += temp;
    }
  }
  return result;
}
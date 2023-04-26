let input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  let target = parseInt(input.shift().split(" ")[1]);
  console.log(solution(input.map(v => +v), target));
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
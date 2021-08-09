let input = require('fs').readFileSync('./dev/stdin').toString().replace('\r', '').split('\n');
var testCase = input.shift();

for (var i = 0; i < testCase; i++) {
  var trainCount = input.shift().replace('\r', '');
  var trains = input.shift().split(" ").map(value => Number(value.replace('\r', '')));
  console.log("Scenario #" + Number(i + 1) + "\n" + solution(trainCount, trains.sort((a, b) => a - b)));
}

function solution(trainCount, trains) {
  console.log(trainCount, trains);
  return 0;
}
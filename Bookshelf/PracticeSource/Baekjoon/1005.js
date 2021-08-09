const readline = require('readline');

let input = [];

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  var temp = 1;
  for (var i = 0; i < Number(input[0]); i++) {
    var K = Number(input[temp].split(" ")[1]);
    console.log(problem(input.slice(temp, temp + K + 3)));
    temp += K + 3;
  }
});

function problem(input) {
  const N = Number(input[0].split(" ")[0]);// 숫자의 갯수
  const ruleCount = Number(input[0].split(" ")[1]);// 규칙의 갯수
  const target = Number(input[ruleCount + 2]);// 최종 목적지
  const costs = input[1].split(" ");// 코스트
  // 규칙 정리
  const preRules = Array.from({ length: N }, () => []);
  for (var j = 0; j < ruleCount; j++) {
    var rule = input[2 + j].split(" ");
    preRules[Number(rule[1]) - 1].push(rule[0]);
  }
  let myArray = Array.from({ length: N }, () => -1);

  function solution(_target, _pre) {
    if (myArray[_target - 1] != -1) {
      // nothing 
    } else if (_pre.length === 0) {
      myArray[_target - 1] = Number(costs[_target - 1]);
    } else {
      var max = 0;
      for (var i = 0; i < _pre.length; i++) {
        var temp = solution(_pre[i], preRules[_pre[i] - 1]) + Number(costs[_target - 1]);
        if (max < temp) max = temp;
      }
      myArray[_target - 1] = max;
    }
    return myArray[_target - 1];
  }
  return solution(target, preRules[target - 1]);
}
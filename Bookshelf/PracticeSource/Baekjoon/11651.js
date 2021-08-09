let input = require('fs').readFileSync('./dev/stdin').toString().split('\n');
input.shift();
input.sort(function (a, b) {
  var tempA = a.split(" ").map(value => Number(value));
  var tempB = b.split(" ").map(value => Number(value));
  if (tempA[1] !== tempB[1]) return tempA[1] - tempB[1];
  else return tempA[0] - tempB[0];
})

console.log(input.join("\n"));
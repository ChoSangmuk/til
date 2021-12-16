let input = require('fs').readFileSync('./dev/stdin').toString().trim().split('\n');
input.shift();
input.sort((a, b) => {
  let tempA = a.split(" ").map(value => +value);
  let tempB = b.split(" ").map(value => +value);
  if (tempA[0] !== tempB[0]) return tempA[0] - tempB[0];
  else return tempA[1] - tempB[1];
})

console.log(input.join("\n"));
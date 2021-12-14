let input = [];
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  input.shift();
  input.sort((a, b) => {
    let tempA = a.split(" ").map(value => +value);
    let tempB = b.split(" ").map(value => +value);
    if (tempA[0] !== tempB[0]) return tempA[0] - tempB[0];
    else return tempA[1] - tempB[1];
  })
  console.log(input.join("\n"));
});
let input = [];
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(Number(line));
}).on('close', function () {
  input.map(value => Number(value));
  input.shift();
  input.sort((a, b) => a - b);
  console.log(input.join("\n"));
});
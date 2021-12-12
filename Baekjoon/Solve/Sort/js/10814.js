let input = [];
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line.split(" "));
}).on('close', function () {
  input.shift();
  input.sort((a, b) => +a[0] === +b[0] ? 1 : a[0] - b[0]);
  console.log(input.map(v => v.join(" ")).join("\n"));
});
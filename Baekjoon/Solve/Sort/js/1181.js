let input = [];
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  input.shift();
  input.sort((a, b) => a.length === b.length ? a > b ? 1 : -1 : a.length - b.length);
  console.log(input.filter((element, index) => input.indexOf(element) === index).join("\n"));
});
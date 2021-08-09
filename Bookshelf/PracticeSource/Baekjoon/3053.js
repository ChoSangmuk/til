const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = Number(line);
  console.log(input * input * Math.PI);
  console.log(input * input * 2);
  process.exit();
});
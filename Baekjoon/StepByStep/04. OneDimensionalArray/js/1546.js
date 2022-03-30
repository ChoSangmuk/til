let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  let max = 0;
  let sum = 0;
  input.shift();
  input = input.shift().split(" ");
  input.forEach(v => {
    sum += parseInt(v);
    max = max < parseInt(v) ? parseInt(v) : max;
  });
  console.log((sum * 100) / (input.length * max));
});
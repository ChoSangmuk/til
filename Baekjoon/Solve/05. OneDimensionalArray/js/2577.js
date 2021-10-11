let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  let temp = 1;
  let result = Array.from({ length: 10 }, v => 0);
  input.forEach(v => temp *= +v);
  (temp + "").split("").forEach(v => result[v]++);
  result.forEach(v => console.log(v));
  process.exit();
});
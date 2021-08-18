let input = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  var cost = input[2].split(" ");
  var distance = input[1].split(" ");
  var result = BigInt(0);
  var min = BigInt(cost[0]);
  for (var i = 0; i < Number(input[0]) - 1; i++) {
    if (BigInt(cost[i]) < min) min = BigInt(cost[i]);
    result += BigInt(min * BigInt(distance[i]));
  }
  console.log(result.toString());
  process.exit();
});
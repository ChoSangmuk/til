let input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  input.shift();
  let distance = input.shift().split(" ").map(v => BigInt(v));
  let cost = input.shift().split(" ").map(v => BigInt(v));
  let result = BigInt(0);
  let min = cost[0];
  for (let i = 0; i < distance.length; i++) {
    if (cost[i] < min) min = cost[i];
    result += min * BigInt(distance[i]);
  }
  console.log(result.toString());
  process.exit();
});
var input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  var N = BigInt(input[0]);
  var NArray = input[1].split(" ").map(v => BigInt(v));
  NArray.unshift(BigInt(0));
  var K = BigInt(input[2]);
  var result = "T";
  for (var i = BigInt(1); i <= N; i = i + BigInt(1)) {
    var fby = NArray[i - BigInt(1)];
    var fy = NArray[i];
    var by = K * (i - BigInt(1));
    var y = K * i;
    if ((fby < by && y <= fy) || (fby > by && y >= fy) || y == fy) break;
    else if (i === N) result = "F";
  }
  console.log(result);
  process.exit();
})
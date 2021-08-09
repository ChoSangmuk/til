const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = Number(line);
  var result = 40320;// 8!
  for (var i = 9; i <= input; i++) {
    result *= i;
    result %= 10000000000000;
    while (result % 10 === 0) result /= 10;
  }
  if (result > 100000) result %= 100000;
  while (String(result).length !== 5) result = "0" + result;
  console.log(result);
  result = 40320;// 8!
  for (var i = 9; i <= input; i++) result *= i;
  while (result % 10 === 0) result /= 10;
  console.log(result%100000);
  // process.exit();
});
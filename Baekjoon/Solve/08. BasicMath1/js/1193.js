let input;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = parseInt(line);
}).on('close', function () {
  let sum = 0;
  let flag1, flag2;
  for (let i = 1; i <= input; i++) {
    sum += i;
    if (sum >= input) {
      flag1 = i;
      flag2 = sum - i;
      break;
    }
  }
  if (flag1 % 2 == 1) console.log((sum - input + 1) + "/" + (input - sum + flag1));
  else console.log((input - sum + flag1) + "/" + (sum - input + 1));
});
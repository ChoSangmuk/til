let input;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = parseInt(line);
}).on('close', function () {
  let a = Math.floor((input - 1) / 6);
  let b = (input - 1) % 6;
  if (b > 0) a++;
  let sum = 0;
  for (let i = 0; i <= a; i++) {
    sum += i;
    if (sum >= a) {
      console.log(i + 1);
      break;
    }
  }
});
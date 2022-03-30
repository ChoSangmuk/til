let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  var result = 0;
  var isFirst = 0;
  for (var i = Number(input[0]); i <= Number(input[1]); i++) {
    if (isPrime(i)) {
      result += i;
      if (isFirst === 0) isFirst = i;
    }
  }
  if (isFirst === 0) console.log(-1);
  else {
    console.log(result);
    console.log(isFirst);
  }
});

function isPrime(inputNumber) {
  if (inputNumber === 1) return false;
  for (var i = 2; i < inputNumber; i++) {
    if (inputNumber % i === 0) return false;
  }
  return true;
}
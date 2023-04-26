let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  var temp = parseInt(input[0]);
  while (temp != 1) {
    for (i = 2; i <= temp; i++) {
      if (temp % i === 0) {
        console.log(i);
        temp /= i;
        break;
      }
    }
  }
  process.exit();
});
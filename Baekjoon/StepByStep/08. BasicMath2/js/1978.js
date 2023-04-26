let input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {

  var temp = input[1].split(' ');
  var result = 0;
  for (i = 0; i < temp.length; i++) {
    var isPrime = true;
    for (j = 1; j <= parseInt(temp[i]) / 2; j++) {
      if (j == 1) continue;
      else if (parseInt(temp[i]) % j == 0) {
        isPrime = false;
        break;
      }
    }
    if (parseInt(temp[i]) != 1 && isPrime) result++;
  }
  console.log(result)
  process.exit();
});
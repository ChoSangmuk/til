let input;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = parseInt(line);
}).on('close', function () {
  let a = Math.floor(input / 5);
  let b = Math.floor(input % 5);
  if (b == 0) console.log(a);
  else if (b == 1) {
    if (a >= 1) console.log(a + 1);
    else console.log(- 1);
  }
  else if (b == 2) {
    if (a < 2) console.log(- 1);
    else console.log(a + 2);
  }
  else if (b == 3) console.log(a + 1);
  else if (b == 4) {
    if (a == 0) console.log(- 1);
    else console.log(a + 2);
  }
});
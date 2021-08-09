const readline = require('readline');

let input = [];
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line.split(' ');
}).on('close', function () {
  var max = Number(input[1]);
  var myArray = Array.from({ length: max + 1 }, () => true);
  var pos = 0;
  myArray[pos++] = false;
  myArray[pos++] = false;
  while (pos < Math.sqrt(max)) {
    for (var i = pos + 1; i <= max; i++) {
      if (i % pos === 0) myArray[i] = false;
    }
    for (var i = pos + 1; i <= max; i++) {
      if (myArray[i] === true) {
        pos = i;
        break;
      } else if (i === max) pos = max;
    }
  }
  for (var i = Number(input[0]); i < max + 1; i++) if (myArray[i]) console.log(i);
});
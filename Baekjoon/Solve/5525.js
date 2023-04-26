let input = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  var S = input[2];
  var N = +input[0];
  var Pn = Array.from({ length: N }, v => "IO").concat("I").join("");

  var position = 0;
  var count = 0;
  while (true) {
    position = S.indexOf(Pn, position);
    if (position === -1) break;
    else {
      count++;
      position++;
    }
  }
  console.log(count);
  process.exit();
});
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  if (line === "0 0 0") rl.close();
  input.push(line)
})
  .on('close', function () {
    var i = 0;
    while (i < input.length) {
      var temp = input[i++].split(' ');
      var A = Math.pow(temp[0], 2);
      var B = Math.pow(temp[1], 2);
      var C = Math.pow(temp[2], 2);

      if (A + B == C || A + C == B || B + C == A) console.log("right");
      else console.log("wrong");
    }
    process.exit();
  });
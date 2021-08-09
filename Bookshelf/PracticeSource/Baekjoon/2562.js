const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  input.push(line)
})
  .on('close', function () {
    var max = 0;
    for (i = 0; i < input.length; i++) {
      if (parseInt(input[max]) < parseInt(input[i])) max = i;
    }
    console.log(input[max] + "\n" + (max+1));
    process.exit();
  });
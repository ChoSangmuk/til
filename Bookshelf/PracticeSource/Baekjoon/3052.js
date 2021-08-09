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
    var output = new Array(42);
    var result = 0;
    for (i = 0; i < output.length; i++)output[i] = 0;
    for (i = 0; i < input.length; i++)  output[parseInt(input[i]) % 42]++;
    for (i = 0; i < output.length; i++)if (output[i] != 0) result++;
    console.log(result);
    process.exit();
  });
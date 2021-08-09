const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = "";

rl.on('line', function (line) {
  input = line;
})
  .on('close', function () {
    var result = 0;
    var temp = input.trim().split(" ");
    temp.forEach(element => {
      if (element.length >= 1) result++;
    });
    console.log(result);
    process.exit();
  });
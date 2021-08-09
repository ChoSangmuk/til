const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  input.push(line);
})
  .on('close', function () {
    for (var i = 0; i < input[0]; i++) {
      var temp = input[i + 1].split(' ');
      var result = "";
      for (var j = 0; j < temp[1].length; j++) {
        for (var k = 0; k < Number(temp[0]); k++) result = result.concat(temp[1].charAt(j));
      }
      console.log(result);
    }
    process.exit();
  });
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
    var temp = input.trim().split(" ");
    if (reversInt(temp[0]) < reversInt(temp[1])) console.log(reversInt(temp[1]));
    else console.log(reversInt(temp[0]));
    process.exit();
  });

function reversInt(input) {
  var output = "";
  for (i = input.length - 1; i >= 0; i--) {
    output = output.concat(input.charAt(i));
  }
  return Number(output);
}
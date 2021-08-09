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
    for(i=0;i<input[0];i++){
      var temp = input[i+1].split(' ');
      console.log((parseInt(temp[0])+parseInt(temp[1])))
    }
    process.exit();
  });
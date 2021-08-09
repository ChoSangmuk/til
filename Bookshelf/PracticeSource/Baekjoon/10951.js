const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  //if(line ==="0 0") rl.close();
  input.push(line)
})
  .on('close', function () {
    var i=0;
    while (i <input.length) {
      var temp = input[i++].split(' ');
      console.log((parseInt(temp[0]) + parseInt(temp[1])));
    }
    process.exit();
  });
let initInput = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  initInput.push(line);
}).on('close', function () {
  var length = Number(initInput.shift());
  var result = bubbleSort(length, initInput.map(value => Number(value)));
  for(var i=0;i<length;i++)console.log(result[i]);
});

function bubbleSort(length, input) {
  for (var j = length - 1; j >= 1; j--) {
    for (var i = 0; i < j; i++) {
      if (input[i] > input[i + 1]) {
        var temp = input[i + 1];
        input[i + 1] = input[i];
        input[i] = temp;
      }
    }
  }
  return input;
}
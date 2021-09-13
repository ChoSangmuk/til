let initInput = "";

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  initInput = line;
}).on('close', function () {
  var length = initInput.length;
  console.log(countingSort(length, initInput));
});

function countingSort(length, input) {
  var temp = Array.from({ length: 10 }, () => 0);
  for (var i = 0; i < length; i++) temp[input.charAt(i)] = temp[input.charAt(i)] + 1;
  input = "";
  for (var i = 9; i >= 0; i--) {
    for (var j = 0; j < temp[i]; j++) input = input.concat(i);
  }
  return input;
}
let initInput = [];
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  initInput.push(+line);
}).on('close', function () {
  initInput.shift();
  console.log(bubbleSort(initInput).join("\n"));
  console.log(insertionSort(initInput).join("\n"));
  console.log(selectionSort(initInput).join("\n"));
});

function bubbleSort(input) {
  for (var j = input.length - 1; j >= 1; j--) {
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

function insertionSort(input) {
  for (var j = 1; j < input.length; j++) {
    var temp = input[j];
    for (var i = 0; i < j; i++) {
      if (temp <= input[i]) {
        for (var k = j; k >= i + 1; k--) input[k] = input[k - 1];
        input[i] = temp;
        break;
      }
    }
  }
  return input;
}

function selectionSort(input) {
  for (var j = 0; j < input.length - 1; j++) {
    var min = j;
    for (var i = j + 1; i < input.length; i++) {
      if (input[min] > input[i]) min = i;
    }
    var temp = input[min];
    input[min] = input[j];
    input[j] = temp;
  }
  return input;
}
let initInput = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  initInput.push(line);
}).on('close', function () {
  var length = Number(initInput.shift());
  initInput = initInput.map(value => Number(value));

  console.log("Bubble Sort Result : ", bubbleSort(length, initInput.slice()), "\n");
  console.log("Selection Sort Result : ", selectionSort(length, initInput.slice()), "\n");
  console.log("Insertion Sort Result : ", insertionSort(length, initInput.slice()), "\n");
  console.log("Merge Sort Result : ", mergeSort(0, length, initInput.slice()), "\n");
  console.log("Quick Sort Result : ", quickSort(length, initInput.slice()), "\n");
  console.log("Counting Sort Result : ", countingSort(length, initInput.slice()), "\n");
});

function bubbleSort(length, input) {
  var count = 0;
  console.log("Bubble Sort Start");
  console.log("\t", count++, input);
  for (var j = length - 1; j >= 1; j--) {
    for (var i = 0; i < j; i++) {
      if (input[i] > input[i + 1]) {
        var temp = input[i + 1];
        input[i + 1] = input[i];
        input[i] = temp;
        console.log("\t", count++, input);
      }
    }
  }
  return input;
}

function selectionSort(length, input) {
  var count = 0;
  console.log("Selection Sort Start");
  console.log("\t", count++, input);
  for (var j = 0; j < length - 1; j++) {
    var min = j;
    for (var i = j + 1; i < length; i++) {
      if (input[min] > input[i]) min = i;
    }
    var temp = input[min];
    input[min] = input[j];
    input[j] = temp;
    console.log("\t", count++, input);
  }
  return input;
}

function insertionSort(length, input) {
  var count = 0;
  console.log("Insertion Sort Start");
  console.log("\t", count++, input);
  for (var j = 1; j < length; j++) {
    var temp = input[j];
    for (var i = 0; i < j; i++) {
      if (temp <= input[i]) {
        for (var k = j; k >= i + 1; k--) input[k] = input[k - 1];
        input[i] = temp;
        console.log("\t", count++, input);
        break;
      }
    }
  }
  return input;
}

function mergeSort(depth, length, input) {
  var depthSpace = "";
  for (var i = 0; i < depth; i++)depthSpace = depthSpace.concat("  ");
  if (depth === 0) console.log("Merge Sort Start");
  if (length >= 2) {
    var tempLeft = input.slice(0, Math.ceil(length / 2));
    var tempRight = input.slice(Math.ceil(length / 2), length);
    var tempStr = "[" + tempLeft + "], [" + tempRight + "]";
    console.log(depthSpace, depth, "Divide", input, "->", tempStr);
    var tempLeftSorted = mergeSort(depth + 1, tempLeft.length, tempLeft);
    var tempRightSorted = mergeSort(depth + 1, tempRight.length, tempRight);
    var tempStrSorted = "[" + tempLeftSorted + "], [" + tempRightSorted + "]";
    input = [];
    while (tempLeftSorted.length !== 0 && tempRightSorted.length !== 0) {
      if (tempLeftSorted[0] <= tempRightSorted[0]) input.push(tempLeftSorted.shift());
      else input.push(tempRightSorted.shift());
    }
    if (tempLeftSorted.length !== 0) input = input.concat(tempLeftSorted);
    else input = input.concat(tempRightSorted);
    console.log(depthSpace, depth, "Sort & Merge", tempStr, "->", tempStrSorted, "->", input);
  }
  return input;
}

function quickSort(length, input) {
  console.log("Quick Sort Start");
  return input;
}

function countingSort(length, input) {
  console.log("Counting Sort Start");
  var temp = [];
  for (var i = 0; i < length; i++) {
    if (temp[input[i]] === undefined) temp[input[i]] = 1;
    else temp[input[i]] = temp[input[i]] + 1;
  }
  console.log("Counting Array : ", temp);
  input = [];
  for (var i = 0; i < temp.length; i++) {
    if (temp[i] !== undefined) {
      for (var j = 0; j < temp[i]; j++) input.push(i);
    }
  }
  return input;
}
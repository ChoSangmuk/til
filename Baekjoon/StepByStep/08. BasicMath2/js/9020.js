let max = (10000 * 2) + 1;
let myArray = Array.from({ length: max }, () => true);
myArray[0] = false;
myArray[1] = false;
let pointer = 2;
while (pointer != max) {
  if (myArray[pointer] === true)
    for (let i = 2; pointer * i <= max; i++)myArray[pointer * i] = false;
  pointer++;
}

let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  for (var i = 0; i < parseInt(input[0]); i++) {
    console.log(solution(parseInt(input[i + 1])));
  }
});

function solution(inputNumber) {
  var A = inputNumber / 2;
  var B = inputNumber / 2;
  while (true) {
    if (myArray[A] && myArray[B]) break;
    else {
      A--;
      B++;
    }
  }
  return A + " " + B;
}
let input = require('fs').readFileSync('./dev/stdin').toString().split('\n');
let length = input.shift();
let initInput = input.shift().split(" ").map(value => Number(value));
let initOperation = input.shift().split(" ").map(value => Number(value));// + - * /

var result = [];

function solution(input, operation) {
  if (input.length === 1) result.push(input[0]);
  else {
    const A = input.shift();
    const B = input.shift();
    for (var i = 0; i < 4; i++) {
      var tempInput = input.slice();
      var tempOperation = operation.slice();
      if (operation[i] !== 0) {
        tempOperation[i] = tempOperation[i] - 1;
        if (i === 0) tempInput.unshift(A + B);
        else if (i === 1) tempInput.unshift(A - B);
        else if (i === 2) tempInput.unshift(A * B);
        else if (i === 3) {
          var temp;
          if (A < 0) var temp = Math.floor((-1 * A) / B) * -1;
          else temp = Math.floor(A / B);
          tempInput.unshift(temp);
        }
        solution(tempInput, tempOperation);
      }
    }
  }
}

solution(initInput, initOperation);
result.sort((a, b) => a - b);
console.log(result[result.length - 1] + "\n" + result[0]);
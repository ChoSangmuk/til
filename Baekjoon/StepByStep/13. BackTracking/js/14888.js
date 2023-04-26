let [N, initInput, initOperation] = require('fs').readFileSync('./dev/stdin').toString().split('\n').map(v => v.split(" ").map(_v => +_v));
let result = [];
function solution(input, operation) {
  if (input.length === 1) result.push(input[0]);
  else {
    const A = input.shift();
    const B = input[0];
    for (let i = 0; i < 4; i++) {
      if (operation[i] !== 0) {
        let tempInput = input.slice();
        let tempOperation = operation.slice();
        tempOperation[i] = tempOperation[i] - 1;
        let temp;
        if (i === 0) temp = A + B;
        else if (i === 1) temp = A - B;
        else if (i === 2) temp = A * B;
        else if (i === 3 && A < 0) temp = Math.floor((-1 * A) / B) * -1;
        else if (i === 3) temp = Math.floor(A / B);
        tempInput[0] = temp;
        solution(tempInput, tempOperation);
      }
    }
  }
}
solution(initInput, initOperation);
console.log(Math.max(...result) + "\n" + Math.min(...result));
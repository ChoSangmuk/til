let input = require('fs').readFileSync('./dev/stdin').toString().split('\n');
input.shift();
console.log(countingSort(input).join("\n"));

function countingSort(input) {
  let temp = [];
  for (let i = 0; i < input.length; i++) {
    if (temp[input[i]] === undefined) temp[input[i]] = 1;
    else temp[input[i]] = temp[input[i]] + 1;
  }
  for (let i = 1; i < temp.length; i++) {
    if (temp[i - 1] === undefined) temp[i - 1] = 0;
    if (temp[i] === undefined) temp[i] = 0;
    temp[i] = temp[i] + temp[i - 1];
  }
  let result = Array.from({ length: input.length }, v => 0);
  for (var i = 0; i < input.length; i++) {
    result[temp[input[i]] - 1] = input[i];
    temp[input[i]]--;
  }
  return result;
}
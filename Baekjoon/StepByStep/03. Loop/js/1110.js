const input = require('fs').readFileSync("./dev/stdin").toString().trim();
let copy = input;
let result = 0;
do {
  let tempSum = 0;
  copy.split("").forEach(v => tempSum += +v);
  copy = (copy % 10) + "" + (tempSum % 10) + "";
  result++;
} while (parseInt(input) != parseInt(copy))
console.log(result);
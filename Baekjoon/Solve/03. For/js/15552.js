const input = require('fs').readFileSync("./dev/stdin").toString().trim().split("\n");
input.shift();

let result = "";
input.forEach(v => {
  let temp = v.split(" ").map(_v => +_v);
  result += ((temp[0] + temp[1]) + "\n");
});
console.log(result);
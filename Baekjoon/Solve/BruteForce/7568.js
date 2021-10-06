const input = require('fs').readFileSync("./dev/stdin").toString().trim().split("\n");

input.shift();
let M = input.map(v => v.split(' ').map(_v => +_v));
console.log(M.map(v => M.filter(_v => v[0] < _v[0] && v[1] < _v[1]).length + 1).join(" "));
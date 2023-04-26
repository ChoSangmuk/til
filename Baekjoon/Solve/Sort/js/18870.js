let input = require('fs').readFileSync('./dev/stdin').toString().split('\n');
[N, X] = input;
X = X.split(" ").map(v => +v);
let myMap = new Map();
Array.from(new Set(X)).sort((a, b) => a - b).forEach((v, i) => myMap.set(v, i));
console.log(X.map(v => myMap.get(v)).join(" "));
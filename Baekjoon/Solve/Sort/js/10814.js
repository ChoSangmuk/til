let input = require('fs').readFileSync('./dev/stdin').toString().trim().split('\n').map(v => v.split(" "));
[N, ...X] = input;
X.sort((a, b) => +a[0] === +b[0] ? 1 : a[0] - b[0]);
console.log(X.map(v => v.join(" ")).join("\n"));
let input = require('fs').readFileSync('./dev/stdin').toString().trim().split('\n');
[N, ...X] = input;
X.sort((a, b) => a.length === b.length ? a > b ? 1 : -1 : a.length - b.length);
console.log(X.filter((element, index) => X.indexOf(element) === index).join("\n"));
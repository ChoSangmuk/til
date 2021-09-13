let input = require('fs').readFileSync('./dev/stdin').toString().split('\n');
input.shift();
input.map(v => +v).sort((a, b) => a - b).forEach(v => console.log(v));
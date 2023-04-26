let [AB, C] = require('fs').readFileSync('./dev/stdin').toString().split('\n');
AB = AB.split(" ").map(v => +v);
let temp = AB[1] + (+C);
AB[0] += Math.floor(temp / 60)
AB[0] = AB[0] % 24;
AB[1] = temp % 60
console.log(AB.join(" "));
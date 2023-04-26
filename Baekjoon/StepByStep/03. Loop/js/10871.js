const input = require('fs').readFileSync("./dev/stdin").toString().trim().split("\n");
let X = (input.shift()).split(" ")[1];
console.log(input.shift().split(" ").filter(v => +v < +X).join(" "));
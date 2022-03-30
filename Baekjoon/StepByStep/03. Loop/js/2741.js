const input = parseInt(require('fs').readFileSync("./dev/stdin").toString().trim().split("\n"));

let result = "";
for (let i = 1; i <= input; i++)result += (i + "\n");
console.log(result);
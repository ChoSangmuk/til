const input = parseInt(require('fs').readFileSync("./dev/stdin").toString().trim().split("\n"));

let result = "";
for (let i = 0; i < input; i++) {
  for (let j = 0; j < input; j++) {
    result += (j < input - 1 - i ? " " : "*");
  }
  result += "\n";
}
console.log(result);
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = line.split(" ").map(v => +v);
  console.log(solution(input[0], input[1]).join("\n"));
  process.exit();
});

function solution(value, length) {
  if (length === 1) return Array.from({ length: value }, (v, i) => String(i + 1));
  else {
    let result = [];
    Array.from({ length: value }, (v, i) => solution(value, length - 1).forEach(_v => result.push(String(i + 1) + " " + _v)))
    return result;
  }
}
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = line.split(" ").map(v => +v);
  console.log(solution(input[0], input[1]).join("\n"));
  process.exit();
});

function solution(inputNumber, length) {
  if (length === 1) return Array.from({ length: inputNumber }, (v, i) => String(i + 1));
  else {
    var _solution = solution(inputNumber, length - 1);
    var result = [];
    for (var i = 1; i <= inputNumber; i++) {
      _solution.forEach(v => parseInt(v.split(" ")[0]) >= i ? result.push(i + " " + v) : {});
    }
  }
  return result;
}
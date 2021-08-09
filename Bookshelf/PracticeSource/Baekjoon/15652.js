const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = line.split(" ");
  array = solution(Number(input[0]), Number(input[1]));
  console.log(array.join("\n"));

  function solution(inputNumber, length) {
    if (length === 1) return Array.from({ length: inputNumber }, (v, i) => String(i + 1));
    else {
      var _solution = solution(inputNumber, length - 1);
      var result = [];
      for (var i = 1; i <= inputNumber; i++) {
        for (var j = 0; j < _solution.length; j++) {
          if (Number(_solution[j].split(" ")[0]) >= i) result.push(i + " " + _solution[j]);
        }
      }
    }
    return result;
  }
  process.exit();
});
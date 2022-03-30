require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = Number(line);
  var temp = 1;
  for (var i = 0; i < input - 1; i++) temp = temp * 2 + 1;
  console.log(temp + "\n" + solution(input, 1, 2, 3));
  process.exit();
});

function solution(number, start, middle, target) {
  if (number === 1) return start + " " + target + "\n";
  return solution(number - 1, start, target, middle) + start + " " + target + "\n" + solution(number - 1, middle, start, target);
}
// console.log()는 느리다
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  console.log(solution(Number(line)));
  process.exit();
});
function solution(input) {
  for (let i = 1; i < input; i++) {
    let temp = i;
    (i + "").split('').forEach(v => temp += Number(v));
    if (temp === input) return i;
  }
  return 0;
}
let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line.split(' ');
}).on('close', function () {
  let result = solution(input[1]);
  result.forEach((v, i) => {
    if (i >= input[0] && i <= input[1] && v) console.log(i);
  })
})

function solution(n) {
  let answer = Array.from({ length: n + 1 }, v => true);
  answer[0] = false;
  answer[1] = false;
  let pointer = 2;
  while (pointer != n) {
    if (answer[pointer] === true)
      for (let i = 2; pointer * i <= n; i++)answer[pointer * i] = false;
    pointer++;
  }
  return answer;
}
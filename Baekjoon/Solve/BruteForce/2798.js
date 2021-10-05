let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line.split(" "));
}).on('close', function () {
  const N = Number(input[0][0]);
  const M = Number(input[0][1]);

  function solution(tempArray) {
    var answer = 0;
    for (var f = 0; f < N - 2; f++) {
      for (var s = f + 1; s < N - 1; s++) {
        for (var t = s + 1; t < N; t++) {
          var temp = Number(tempArray[f]) + Number(tempArray[s]) + Number(tempArray[t]);
          if (temp === M) return M;
          else if (temp < M && temp > answer) answer = temp;
        }
      }
    }
    return answer;
  }
  console.log(solution(input[1]));
});
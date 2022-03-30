let [N, ...score] = require('fs').readFileSync('./dev/stdin').toString().split('\n').map(v => v.split(" "));

let min = -1;
function add(i, j) {
  return +score[i][j] + +score[j][i];
}
(function solution(input, use, pos) {
  if (pos === 0) {
    input[pos] = true;
    solution(input, use - 1, pos + 1);
  } else if (use === 0) {
    let teamA = input.map((v, i) => v ? i : -1).filter(v => v != -1);
    let teamB = input.map((v, i) => !v ? i : -1).filter(v => v != -1);
    let diff = 0;
    for (let j = 0; j < teamA.length; j++)  for (let k = j + 1; k < teamA.length; k++)
      diff = diff + add(teamA[j], teamA[k]) - add(teamB[j], teamB[k]);
    if (min === -1) min = Math.abs(diff);
    else if (min > Math.abs(diff)) min = Math.abs(diff);
  } else {
    let arrCopy = input.slice();
    arrCopy[pos] = true;
    solution(arrCopy, use - 1, pos + 1);
    if (input.length >= use + pos + 1) solution(input, use, pos + 1);
  }
})(Array.from({ length: N }).fill(false), N / 2, 0);
console.log(min);
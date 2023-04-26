let input = require('fs').readFileSync('./dev/stdin').toString().split("\n");
input = input.map(v => v.split(" ").map(v => +v));

let empty = [];
for (let i = 0; i < 9; i++)for (let j = 0; j < 9; j++) if (input[i][j] === 0) empty.push([i, j]);

const solution = (pos) => {
  if (pos === empty.length) {
    for (let i = 0; i < 9; i++) console.log(input[i].join(" "));
    process.exit(0);
  } else {
    let x = empty[pos][0];
    let y = empty[pos][1];
    let sqr_start = [Math.floor(x / 3) * 3, Math.floor(y / 3) * 3];

    for (let i = 1; i <= 9; i++) {
      if (!(check(x, y, sqr_start, i))) continue;
      input[x][y] = i;
      solution(pos + 1);
      input[x][y] = 0;
    }
  }
}

const check = (x, y, sqr_start, i) => {
  for (let k = 0; k < 9; k++) if (input[x][k] === i) return false;
  for (let k = 0; k < 9; k++) if (input[k][y] === i) return false;
  for (let k = 0; k < 3; k++) {
    for (let q = 0; q < 3; q++) {
      if (input[sqr_start[0] + k][sqr_start[1] + q] === i) return false;
    }
  }
  return true;
}

solution(0);
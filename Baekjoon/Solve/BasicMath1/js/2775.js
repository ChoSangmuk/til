let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(parseInt(line));
}).on('close', function () {
  let table = Array.from({ length: 15 }, v => Array.from({ length: 15 }, _v => 0));
  for (let i = 0; i < 15; i++) {
    table[i][0] = 1;
    table[0][i] = i + 1;
  }
  for (let i = 1; i < 15; i++) {
    for (let j = 1; j < 15; j++) {
      table[i][j] = table[i - 1][j] + table[i][j - 1];
    }
  }
  let T = input.shift();
  for (let i = 0; i < T; i++) {
    let k = input.shift();
    let n = input.shift();
    console.log(table[k][n - 1]);
  }
});
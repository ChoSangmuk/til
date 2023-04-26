let input;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = parseInt(line);
}).on('close', function () {
  console.log(solution(0, Array.from({ length: input }, () => -1)));
  process.exit();
});

function solution(position, row) {
  if (position === row.length) return 1;
  let row_copy = row.slice();
  let result = 0;
  for (let i = 0; i < row_copy.length; i++) {
    if (row_copy.indexOf(i) === -1) {
      row_copy[position] = i;
      if (check(position, row_copy)) result += solution(position + 1, row_copy);
    }
  }
  return result;
}

function check(position, row) {
  for (let i = 0; i < position; i++)
    if (row[i] - position + i === row[position] || row[i] + position - i === row[position]) return false;
  return true;
}
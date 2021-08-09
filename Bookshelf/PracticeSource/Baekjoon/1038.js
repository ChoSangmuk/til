let result = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = Number(line);
  semiSoution("", 10);
  result.sort((a, b) => Number(a) - Number(b));
  if (input >= result.length) console.log(-1);
  else console.log(result[input]);
  process.exit();
});

function semiSoution(pre, len) {
  for (var a = 0; a < len; a++) {
    result.push(pre + "" + a);
    semiSoution(pre + "" + a, a);
  }
}
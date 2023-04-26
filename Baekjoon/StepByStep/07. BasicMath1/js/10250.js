let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line.trim().split(" "));
}).on('close', function () {
  input.shift();
  input.forEach(v => {
    let a = v[2] % v[0];
    let b = Math.floor(v[2] / v[0]) + 1;
    if (a == 0) {
      a = v[0];
      b -= 1;
    }
    console.log((a * 100) + b);
  });
});
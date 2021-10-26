let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line.split(" ").map(v => +v));
}).on('close', function () {
  input.shift();
  input.forEach(v => {
    let temp = 1;
    while (temp % 2 === 1 ? ((temp + 1) / 2) ** 2 < v[1] - v[0] : (temp / 2) * ((temp / 2) + 1) < v[1] - v[0]) temp++;
    console.log(temp);
  });
});
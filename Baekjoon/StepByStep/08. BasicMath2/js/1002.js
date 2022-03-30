let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line.split(" ").map(v => +v));
}).on('close', function () {
  input.shift();
  input.forEach(v => {
    let distance = Math.sqrt((v[0] - v[3]) ** 2 + (v[1] - v[4]) ** 2);
    if (v[0] === v[3] && v[1] === v[4] && v[2] === v[5])
      console.log(-1);
    else if (distance === v[2] + v[5] || v[2] === v[5] + distance || v[5] === v[2] + distance)
      console.log(1);
    else if (distance < v[2] + v[5] && v[2] < v[5] + distance && v[5] < v[2] + distance)
      console.log(2);
    else console.log(0);
  });
  process.exit();
});
let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  input.shift();
  input.forEach(v => {
    let temp = v.split(" ");
    let count = temp.shift();
    let avg = 0;
    temp.forEach(_v => avg += +_v);
    avg /= count;
    console.log(((temp.filter(_v => _v > avg).length / count) * 100).toFixed(3) + "%");
  })
  process.exit();
});
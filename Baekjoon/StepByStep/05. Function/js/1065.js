let input;
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = parseInt(line);
}).on('close', function () {
  let result = 0;
  for (let i = 1; i <= input; i++) {
    let temp = String(i).split("").map(v => +v);
    let temp_interval = temp.map((v, i) => i === 0 ? 0 : v - temp[i - 1]);
    temp_interval.shift();
    temp_interval = temp_interval.filter((element, index) => temp_interval.indexOf(element) === index);
    if (temp_interval.length <= 1) result++
  }
  console.log(result);
  process.exit();
});
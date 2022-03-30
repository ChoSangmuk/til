let input = "";
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line;
}).on('close', function () {
  let temp = input.trim().split(" ");
  let temp_a = parseInt(temp[0].split("").reverse().join(""));
  let temp_b = parseInt(temp[1].split("").reverse().join(""));
  console.log(temp_a > temp_b ? temp_a : temp_b);
  process.exit();
});

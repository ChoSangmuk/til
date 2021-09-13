require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = line;
  input = input.split(' ').map(v => +v);
  console.log(input[0] - input[1]);
  process.exit();
});
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = line;
  let output = 0;
  input.split(' ').forEach(v => output += Number(v));
  console.log(output);
  process.exit();
});
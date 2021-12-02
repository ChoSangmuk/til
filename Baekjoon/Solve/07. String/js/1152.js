require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  console.log(line.trim().split(" ").filter(v => v.length >= 1).length);
  process.exit();
});
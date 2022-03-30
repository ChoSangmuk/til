require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  console.log(+line - 543);
  process.exit();
});
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  if (line === "0 0") process.exit();
  var temp = line.split(' ');
  console.log((parseInt(temp[0]) + parseInt(temp[1])));
});
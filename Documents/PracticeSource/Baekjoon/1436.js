const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = Number(line);
  var result = 665;
  while (input!==0) {
    if(String(result).indexOf("666")!==-1) input--;
    result++;
  }
  console.log(result-1);
  process.exit();
});

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  var input = BigInt(line);
  if (input == BigInt(0)) process.exit();
  else {
    while (input >= BigInt(10)) {
      var new_temp = BigInt(0);
      String(input + '').split('').map(value => BigInt(value)).map(_value => new_temp += BigInt(_value));
      input = new_temp;
    }
    console.log(Number(input));
  }
});
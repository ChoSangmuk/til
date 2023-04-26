let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  for (let i = 0; i < input[0]; i++) {
    let temp = input[i + 1].split(' ');
    let result = "";
    for (let j = 0; j < temp[1].length; j++) {
      for (let k = 0; k < Number(temp[0]); k++) result = result.concat(temp[1].charAt(j));
    }
    console.log(result);
  }
  process.exit();
});
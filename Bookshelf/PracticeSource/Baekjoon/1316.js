const readline = require('readline');

let input = [];

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  var result = 0;
  for (var i = 0; i < Number(input[0]); i++) if (problem(input[i + 1])) result++;
  console.log(result);
});

function problem(input) {
  var result = true;
  var temp = [String(input.charAt(0))];
  var tempLength = temp.length;
  for (var i = 1; i < input.length; i++) {
    if (String(input.charAt(i)) !== temp[tempLength - 1]) {
      if ((temp.slice(0, tempLength - 1)).toString().indexOf(String(input.charAt(i))) === -1) {
        temp.push(String(input.charAt(i)));
        tempLength++;
      } else {
        result = false;
        break;
      }
    }
  }
  return result;
}
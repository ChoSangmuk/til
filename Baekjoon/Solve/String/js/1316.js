let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  let result = 0;
  for (let i = 0; i < Number(input[0]); i++) if (problem(input[i + 1])) result++;
  console.log(result);
});

function problem(input) {
  let result = true;
  let temp = [String(input.charAt(0))];
  let tempLength = temp.length;
  for (let i = 1; i < input.length; i++) {
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
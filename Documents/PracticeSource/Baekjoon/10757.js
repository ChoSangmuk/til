const readline = require('readline');

let input = [];
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line.trim().split(" ");
}).on('close', function () {
  var A = input[0].split("");
  var B = input[1].split("");
  let result = [];
  var temp = 0;
  while (true) {
    if (A.length === 0 && B.length === 0) break;
    var temp_a = A.pop();
    var temp_b = B.pop();
    if(temp_a === undefined) temp_a=0;
    if(temp_b === undefined) temp_b=0;
    var temp_sum = Number(temp_a) + Number(temp_b) + temp;
    if (temp_sum >= 10) temp = 1;
    else temp = 0;
    result.unshift(temp_sum % 10);
  }
  if(temp === 1)result.unshift(1);
  console.log(result.join(''));
});
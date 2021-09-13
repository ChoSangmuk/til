let input = require('fs').readFileSync('./dev/stdin').toString().split('\n');
input.shift();
input = input.shift().split(" ");
var result = [];

input.forEach(element => {
  var temp = 0;
  input.forEach(_element => {
    if (element > _element) temp++;
  });
  result.push(temp);
});

console.log(result.join(" "));
let input = [];
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  input.shift();
  input.sort(function (a, b) {
    if (a.length === b.length) return a > b ? 1 : -1;
    else return a.length - b.length;
  });
  const uniqueArr = input.filter((element, index) => {
    return input.indexOf(element) === index;
  });

  uniqueArr.forEach((element) => {
    console.log(element);
  });
});
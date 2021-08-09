const readline = require('readline');

let input = "";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line;
}).on('close', function () {
  console.log(problem(input));
});

function problem(input) {
  let answer = 0;
  var inputCopy = input;

  while (inputCopy.indexOf("dz=") !== -1) inputCopy = inputCopy.replace("dz=", "!");
  while (inputCopy.indexOf("z=") !== -1) inputCopy = inputCopy.replace("z=", "!");
  while (inputCopy.indexOf("s=") !== -1) inputCopy = inputCopy.replace("s=", "!");
  while (inputCopy.indexOf("d-") !== -1) inputCopy = inputCopy.replace("d-", "!");
  while (inputCopy.indexOf("c=") !== -1) inputCopy = inputCopy.replace("c=", "!");
  while (inputCopy.indexOf("c-") !== -1) inputCopy = inputCopy.replace("c-", "!");
  while (inputCopy.indexOf("lj") !== -1) inputCopy = inputCopy.replace("lj", "!");
  while (inputCopy.indexOf("nj") !== -1) inputCopy = inputCopy.replace("nj", "!");

  return inputCopy.length;
}
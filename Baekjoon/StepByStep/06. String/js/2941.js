let input = "";
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line;
}).on('close', function () {
  console.log(input
    .replace(/dz=/g, "!")
    .replace(/z=/g, "!")
    .replace(/s=/g, "!")
    .replace(/d-/g, "!")
    .replace(/c=/g, "!")
    .replace(/c-/g, "!")
    .replace(/lj/g, "!")
    .replace(/nj/g, "!")
    .length);
});
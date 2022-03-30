let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  if (line === "0 0 0") process.exit();
  else {
    let temp = line.split(' ');
    let A = temp[0] ** 2;
    let B = temp[1] ** 2;
    let C = temp[2] ** 2;

    if (A + B == C || A + C == B || B + C == A) console.log("right");
    else console.log("wrong");
  }
});
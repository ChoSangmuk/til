let input = [];
let myMap = new Map();
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  input.pop();
  for (var i = 0; i < input.length; i++) {
    let temp = input[i].split(' ').map(value => Number(value));
    if (temp[0] === -1 && temp[1] === -1 && temp[2] === -1) break;
    console.log("w(" + temp[0] + ", " + temp[1] + ", " + temp[2] + ") = " + solution(temp));
  }
});

function solution(array) {
  var a = array[0];
  var b = array[1];
  var c = array[2];
  let result = 0;
  if (myMap.get(array) !== undefined) return myMap.get(array);
  else if (a <= 0 || b <= 0 || c <= 0) return 1;
  else if (a > 20 || b > 20 || c > 20) return solution(20, 20, 20);
  else if (a < b && b < c) {
    let B, C, F;
    if (myMap.get([a, b, c - 1]) !== undefined) C = myMap.get([a, b, c - 1]);
    else C = solution([a - 1, b, c]);
    if (myMap.get([a, b - 1, c - 1]) !== undefined) F = myMap.get([a, b - 1, c - 1]);
    else F = solution([a - 1, b, c]);
    if (myMap.get([a, b - 1, c]) !== undefined) B = myMap.get([a, b - 1, c]);
    else B = solution([a - 1, b, c]);
    result = C + F - B;
  } else {
    let A, D, E, G;
    if (myMap.get([a - 1, b, c]) !== undefined) A = myMap.get([a - 1, b, c]);
    else A = solution([a - 1, b, c]);
    if (myMap.get([a - 1, b - 1, c]) !== undefined) D = myMap.get([a - 1, b - 1, c]);
    else D = solution([a - 1, b, c]);
    if (myMap.get([a - 1, b, c - 1]) !== undefined) E = myMap.get([a - 1, b, c - 1]);
    else E = solution([a - 1, b, c]);
    if (myMap.get([a - 1, b - 1, c - 1]) !== undefined) G = myMap.get([a - 1, b - 1, c - 1]);
    else G = solution([a - 1, b, c]);
    result = A + D + E - G;
  }
  myMap.set(array, result);
  return result;
}
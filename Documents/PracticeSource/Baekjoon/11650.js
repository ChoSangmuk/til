var count = 0;
let myMap = new Map();
var keys = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  if (count === 0) count = Number(line);
  else {
    var point = line.split(" ");
    var point_x = Number(point[0]);
    var point_y = Number(point[1]);
    if (keys.length === 0) keys.push(point_x);
    else keys = insertArray(point_x, keys);
    var myMapTemp = myMap.get(point_x);
    if (myMapTemp === undefined) myMapTemp = [point_y];
    else myMapTemp = insertArray(point_y, myMapTemp);
    myMap.set(point_x, myMapTemp);
  }
}).on('close', function () {
  var result = "";
  for (var i = 0; i < keys.length; i++) {
    var temp = myMap.get(keys[i]);
    for (var j = 0; j < temp.length; j++) result = result.concat(keys[i] + " " + temp[j] + "\n");
  }
  console.log(result);
});

function insertArray(input, array) {
  for (var i = 0; i < array.length; i++) {
    if (input === array[i]) break;
    if (input < array[i]) {
      array.splice(i, 0, input);
      break;
    }
    if (i === array.length - 1) {
      array.push(input);
      break;
    }
  }
  return array;
}
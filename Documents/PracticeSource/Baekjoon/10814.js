var count = 0;
let myMap = new Map();
var keys = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  if (count === 0) count = Number(line);
  else {
    var row = line.split(" ");
    var age = Number(row[0]);
    var name = row[1];
    if (keys.length === 0) keys.push(age);
    else keys = insertArray(age, keys);
    var myMapTemp = myMap.get(age);
    if (myMapTemp === undefined) myMapTemp = [name];
    else myMapTemp.push(name);
    myMap.set(age, myMapTemp);
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
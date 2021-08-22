var length = 0;
let myMap = new Map();
var avg = 0;
var min = 4001;
var max = -4001;

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  var temp = Number(line);
  if (length === 0) length = temp;
  else {
    if (min === 4001 && max === -4001) {
      max = temp;
      min = temp;
    }
    avg += temp;
    if (temp < min) min = temp;
    else if (temp > max) max = temp;

    var mtMapTemp = myMap.get(temp);
    if (mtMapTemp === undefined) myMap.set(temp, 1);
    else myMap.set(temp, mtMapTemp + 1);
  }
}).on('close', function () {
  var many = 0;
  var count = 1;
  var temp = [];
  var tempLength = Math.floor(length / 2);
  var tempValue = -4001;
  for (var i = min; i <= max; i++) {
    value = myMap.get(i);
    if (value !== undefined) {
      tempLength -= value;
      if (tempLength < 0 && tempValue === -4001) tempValue = i;
      if (many < value) {
        many = value;
        count = 1;
        temp = [];
        temp.push(i);
      } else if (many === value) {
        count++;
        temp.push(i);
      }
    }
  }
  console.log(Math.round(avg / length) + "\n" + tempValue + "\n" + (count === 1 ? temp[0] : temp[1]) + "\n" + Number(max - min));
});
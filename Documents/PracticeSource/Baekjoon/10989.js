let myMap = new Map();
var input = 0;
var max = 0;

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  if (input === 0) input++;
  else {
    var temp = Number(line);
    if (max < temp) max = temp;
    var mtMapTemp = myMap.get(temp);
    if (mtMapTemp === undefined) myMap.set(temp, 1);
    else myMap.set(temp, mtMapTemp + 1);
  }
}).on('close', function () {
  for (var i = 0; i <= max; i++) {
    var temp = myMap.get(i);
    if (temp === undefined) temp = 0;
    for (var j = 0; j < temp; j++) console.log(i);
  }
});
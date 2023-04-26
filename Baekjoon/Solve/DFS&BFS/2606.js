const input = require('fs').readFileSync("./dev/stdin").toString().trim().split("\n");

var N = +input.shift();
var M = +input.shift();

var myMap = new Map();
for (var i = 0; i < N; i++) myMap.set(i + 1, []);
input.forEach(element => {
  element = element.split(" ").map(v => +v);
  myMap.set(element[0], (myMap.get(element[0])).concat(element[1]));
  myMap.set(element[1], (myMap.get(element[1])).concat(element[0]));
});

myMap.forEach((value, key) => myMap.set(key, value.sort((a, b) => +a - +b)));
var tempArray = [1,];
var BFS = [];
while (tempArray.length != 0) {
  var current = tempArray.shift();
  myMap.get(current).forEach(element => BFS.indexOf(element) === -1 && tempArray.indexOf(element) === -1 ? tempArray.push(element) : {});
  BFS.push(current);
}

console.log(BFS.length - 1);
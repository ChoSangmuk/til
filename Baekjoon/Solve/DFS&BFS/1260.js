const input = require('fs').readFileSync("./dev/stdin").toString().trim().split("\n");

var [N, M, V] = input.shift().split(" ").map(v => +v);

var myMap = new Map();
for (var i = 0; i < N; i++) myMap.set(i + 1, []);
input.forEach(element => {
  element = element.split(" ").map(v => +v);
  myMap.set(element[0], myMap.get(element[0]).concat(element[1]));
  myMap.set(element[1], myMap.get(element[1]).concat(element[0]));
});

myMap.forEach((value, key) => myMap.set(key, value.sort((a, b) => +b - +a)));
var tempArray = [V,];
var DFS = [];
while (tempArray.length != 0) {
  var current = tempArray.pop();
  if (DFS.indexOf(current) === -1) {
    myMap.get(current).forEach(element => DFS.indexOf(element) === -1 ? tempArray.push(element) : {});
    DFS.push(current);
  }
}

myMap.forEach((value, key) => myMap.set(key, value.sort((a, b) => +a - +b)));
tempArray = [V,];
var BFS = [];
while (tempArray.length != 0) {
  var current = tempArray.shift();
  myMap.get(current).forEach(element => BFS.indexOf(element) === -1 && tempArray.indexOf(element) === -1 ? tempArray.push(element) : {});
  BFS.push(current);
}

console.log(DFS.join(" ") + "\n" + BFS.join(" "));
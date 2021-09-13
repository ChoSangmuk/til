const input = require('fs').readFileSync("/Users/chosangmuk/Documents/twil/Baekjoon/NodsjsInput/fsstdin").toString().trim().split("\n");
//const input = require('fs').readFileSync("/dev/stdin").toString().trim().split("\n");

let [V, E] = input.shift().split(" ").map(v => +v); // 정점 V, 간선 E
let K = +input.shift(); // 시작 정점 K
let wArray = Array.from({ length: V + 1 }, () => Array.from({ length: V + 1 }, () => Infinity));
input.forEach(element => {
  element = element.split(" ").map(v => +v);
  wArray[element[0]][element[0]] = 0;
  wArray[element[1]][element[1]] = 0;
  wArray[element[0]][element[1]] = element[2];
});

let result = Array.from(wArray[K]);
let visitedCount = 1;
let visited = Array.from({ length: V + 1 }, (v, i) => i === K ? visitedCount : 0);

do {
  let pos = 0;
  let min = Infinity;
  result.forEach((v, i) => {
    if (visited[i] === 0 && v < min) {
      min = v;
      pos = i;
    }
  });
  let direct = Array.from(wArray[pos]).map(v => v + min);
  result = result.map((v, i) => direct[i] < v ? direct[i] : v);
  visited[pos] = ++visitedCount;
} while (visitedCount < V);

console.log(result.map((v) => v === Infinity ? 'INF' : v).slice(1,).join("\n"));
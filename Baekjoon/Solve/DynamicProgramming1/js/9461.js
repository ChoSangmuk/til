let input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");
let dp = [0, 1, 1, 1, 2, 2];
input.shift();
input.forEach(v => console.log(solution(v)));

function solution(t) {
  if (dp[t] == undefined) dp[t] = solution(t - 1) + solution(t - 5);
  return dp[t];
}
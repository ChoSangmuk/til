let input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");
let dp = Array.from({ length: 21 }, v => Array.from({ length: 21 }, v => Array.from({ length: 21 })));

for (let a = 0; a < 21; a++) {
  for (let b = 0; b < 21; b++) {
    for (let c = 0; c < 21; c++) {
      let temp_a = a - 1 <= 0 ? 0 : a - 1, temp_b = b - 1 <= 0 ? 0 : b - 1, temp_c = c - 1 <= 0 ? 0 : c - 1;
      if (a <= 0 || b <= 0 || c <= 0) dp[a][b][c] = 1;
      else if (a < b && b < c) dp[a][b][c] = dp[a][b][temp_c] + dp[a][temp_b][temp_c] - dp[a][temp_b][c];
      else dp[a][b][c] = dp[temp_a][b][c] + dp[temp_a][temp_b][c] + dp[temp_a][b][temp_c] - dp[temp_a][temp_b][temp_c];
    }
  }
}
input.forEach(v => {
  if (v === "-1 -1 -1") process.exit();
  let temp = v.split(" ");
  let answer = "w(" + temp[0] + ", " + temp[1] + ", " + temp[2] + ") = ";
  if (temp[0] <= 0 || temp[1] <= 0 || temp[2] <= 0) console.log(answer + dp[0][0][0]);
  else if (temp[0] > 20 || temp[1] > 20 || temp[2] > 20) console.log(answer + dp[20][20][20]);
  else console.log(answer + dp[temp[0]][temp[1]][temp[2]]);
})
let input = +require("fs").readFileSync("./dev/stdin");
let dp = [0, 1, 2];
while (dp[input] === undefined) dp[dp.length] = (dp[dp.length - 1] + dp[dp.length - 2]) % 15746;
console.log(dp[input]);
let temp = Array.from({ length: 10001 }, v => 0);
for (let i = 1; i <= 10000; i++) {
  if (temp[i] === 0) console.log(i);
  temp[String(i).split("").map(v => +v).reduce((a, b) => a + b) + i] = i;
}
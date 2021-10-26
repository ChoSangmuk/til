require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let numbers = line.split(/[+|-]/).map(v => +v);
  let operations = line.split(/[0-9]/).filter(v => v != "");
  for (let i = 0; i < operations.length; i++) {
    if (operations[i] === "+") {
      numbers[i] += numbers[i + 1];
      operations.splice(i, 1);
      numbers.splice(i + 1, 1);
      i--;
    }
  }
  for (let i = 0; i < operations.length; i++) {
    numbers[i] -= numbers[i + 1];
    operations.splice(i, 1);
    numbers.splice(i + 1, 1);
    i--;
  }
  console.log(numbers[0]);
  process.exit();
});
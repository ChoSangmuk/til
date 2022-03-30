let input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line.split(" ").map(v => BigInt(+v)));
}).on('close', function () {
  input.shift();
  input.sort((a, b) => {
    if (a[1] > b[1]) return 1;
    else if (a[1] < b[1]) return -1;
    else {
      if (a[0] > b[0]) return 1;
      else if (a[0] < b[0]) return -1;
    }
  });
  let result = [];
  let position = 0;
  for (let i = 0; i < input.length; i++) {
    if (i == 0) result.push(input[i]);
    else if (input[position][1] <= input[i][0]) {
      result.push(input[i]);
      position = i;
    }
  }
  console.log(result.length);
  process.exit();
});
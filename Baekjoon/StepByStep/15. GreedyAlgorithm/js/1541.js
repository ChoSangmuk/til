require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let separate = line.split(/[-]/).map(v => {
    let total = 0;
    v.split(/[+]/).forEach(element => total += +element);
    return total;
  })
  let result = +separate[0];
  for (let i = 1; i < separate.length; i++) result -= separate[i];
  console.log(result);
  process.exit();
});
var input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  input.shift();
  input.map(value => {
    var temp = value.split(" ");
    var temp_1 = temp.shift();
    var temp_2 = temp.shift();
    console.log(temp.concat(temp_1, temp_2).join(" "));
  });
  process.exit();
})
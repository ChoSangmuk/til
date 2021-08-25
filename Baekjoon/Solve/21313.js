require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  var input = Number(line);
  var output = "";
  for (var i = 0; i < parseInt(input / 2); i++) output = output.concat("1 2 ");
  if (input % 2 === 1) output = output.concat("3");
  else output = output.trim();
  console.log(output);
  process.exit();
});
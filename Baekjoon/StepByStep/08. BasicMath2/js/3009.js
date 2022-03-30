let input = [];
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line)
}).on('close', function () {
  var temp_x = [0, 0, 0, 0];
  var guess_x = 0, guess_y = 0;
  var temp_y = [0, 0, 0, 0];
  for (i = 0; i < input.length; i++) {
    var temp = input[i].split(" ");
    temp_x[i] = temp[0];
    temp_y[i] = temp[1];
  }
  if (temp_x[0] == temp_x[1]) guess_x = temp_x[2];
  else if (temp_x[0] == temp_x[2]) guess_x = temp_x[1];
  else if (temp_x[1] == temp_x[2]) guess_x = temp_x[0];
  if (temp_y[0] == temp_y[1]) guess_y = temp_y[2];
  else if (temp_y[0] == temp_y[2]) guess_y = temp_y[1];
  else if (temp_y[1] == temp_y[2]) guess_y = temp_y[0];
  console.log(guess_x + " " + guess_y);
  process.exit();
});
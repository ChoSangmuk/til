let input = "";
require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input = line.toUpperCase();
}).on('close', function () {
  let temp = Array.from({ length: 26 }, () => 0);
  for (i = 0; i < input.length; i++) temp[input.charAt(i).charCodeAt(0) - 65]++;
  let max_pos = 0, double = false;
  for (i = 0; i < 26; i++) if (temp[i] >= temp[max_pos]) max_pos = i;
  for (i = 0; i < 26; i++) {
    if (i != max_pos && temp[i] >= temp[max_pos]) {
      double = true;
      break;
    }
  }
  if (double) console.log("?");
  else console.log(String.fromCharCode(max_pos + 65));
  process.exit();
});
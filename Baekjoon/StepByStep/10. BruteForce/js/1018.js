let input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  console.log(problem(input));
  process.exit();
});

function problem(input) {
  var input_NM = input[0].split(" ");
  var min = 65;
  for (var x = 0; x <= input_NM[0] - 8; x++) {
    for (var y = 0; y <= input_NM[1] - 8; y++) {
      var tempStr = "";
      for (var i = x + 1; i <= x + 8; i++) tempStr = tempStr.concat(input[i].substr(y, 8));
      var temp = solution(tempStr);
      if (min > temp) min = temp;
    }
  }
  return min;
}

function solution(board) {
  var A_count = 0;
  var B_count = 0;
  var temp_A = "WBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBW";
  var temp_B = "BWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWB";
  for (var i = 0; i < 64; i++) {
    if (temp_A.charAt(i) !== board.charAt(i)) A_count++;
    if (temp_B.charAt(i) !== board.charAt(i)) B_count++;
  }
  return A_count < B_count ? A_count : B_count;
}
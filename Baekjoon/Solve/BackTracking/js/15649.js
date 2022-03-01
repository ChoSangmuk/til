require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = line.split(" ").map(v => +v);
  let array = Array.from({ length: input[0] }, v => false);
  console.log(solution(array, input[1]).join("\n"));
  process.exit();
});

function solution(arr, length) {
  var result = [];
  if (length === 1) arr.forEach((v, i) => !v ? result.push(String(i + 1)) : {})
  else {
    for (var i = 0; i < arr.length; i++) {
      if (!arr[i]) {
        var arrCopy = arr.slice();
        arrCopy[i] = true;
        solution(arrCopy, length - 1).forEach(v => result.push(String(i + 1) + " " + v));
      }
    }
  }
  return result;
}
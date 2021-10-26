require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  let input = Number(line);
  var result = solution(input);
  for (var i = 0; i < input; i++) console.log(result[i].join(''));
  process.exit();
});

function solution(input) {
  var result = new Array();
  if (input === 3) result = [["***"], ["* *"], ["***"]];
  else {
    var preInput = input / 3;
    var preSolution = solution(preInput);
    for (var i = 0; i < input; i++) {
      var tempInt = i % preInput;
      if (Math.floor(i / preInput) === 1) result.push([preSolution[tempInt] + emptySpace(preInput) + preSolution[tempInt]]);
      else result.push([preSolution[tempInt] + preSolution[tempInt] + preSolution[tempInt]]);
    }
  }
  return result;
}

function emptySpace(input) {
  return Array.from({ length: input }, v => " ").join("");
}
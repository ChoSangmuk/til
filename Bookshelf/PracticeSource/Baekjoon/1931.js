let input = [];

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  var result = 0;

  for (var i = 1; i < input.length; i++) {
    for (var j = 1; j < input.length; j++) {
      if (j === i) continue;
      var temp_S = input[i].split(" ");
      var temp_C = input[j].split(" ");
      if ((BigInt(temp_C[0]) <= BigInt(temp_S[0]) && BigInt(temp_S[1]) <= BigInt(temp_C[1]) && BigInt(temp_S[0]) !== BigInt(temp_S[1]))
        || (BigInt(temp_C[0]) < BigInt(temp_S[0]) && BigInt(temp_S[1]) < BigInt(temp_C[1]) && BigInt(temp_S[0]) === BigInt(temp_S[1]))) {
        input.splice(j, 1);
        j--;
        if (j < i) i--;
      }
    }
  }
  for (var i = 1; i < input.length; i++) {
    var temp_S = input[i].split(" ");
    if (BigInt(temp_S[1]) - BigInt(temp_S[0]) <= 1) {
      result++;
      input.splice(i--, 1);
    } else {
      var temp = true;
      for (var j = 1; j < input.length; j++) {
        if (j === i) continue;
        var temp_C = input[j].split(" ");
        if (!(BigInt(temp_C[1]) <= BigInt(temp_S[0]) || BigInt(temp_S[1]) <= BigInt(temp_C[0]))){
          temp = !temp;
          break;
        } 
      }
      if(temp){
        result++;
        input.splice(i--, 1);
      }
    }
  }
  console.log(input.toString());


  console.log(result.toString());
  process.exit();
});
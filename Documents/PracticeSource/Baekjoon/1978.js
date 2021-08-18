const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
  input.push(line)
})
  .on('close', function () {

    var temp = input[1].split(' ');
    var result=0;
    for(i=0;i<temp.length;i++){
      var isprime = true;
      for(j=1;j<=parseInt(temp[i])/2;j++){
        if(j==1)continue;
        else if(parseInt(temp[i])%j==0){
          isprime=false;
          break;
        }
      }
      if(parseInt(temp[i])!=1 && isprime) result++;
    }
    console.log(result)
    process.exit();
  });
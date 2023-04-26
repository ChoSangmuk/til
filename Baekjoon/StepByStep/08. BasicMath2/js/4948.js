let max = (123456 * 2) + 1;
let myArray = Array.from({ length: max }, () => true);
myArray[0] = false;
myArray[1] = false;
let pointer = 2;
while (pointer != max) {
  if (myArray[pointer] === true)
    for (let i = 2; pointer * i <= max; i++)myArray[pointer * i] = false;
  pointer++;
}

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  if (line === "0") process.exit();
  console.log(myArray.slice(parseInt(line) + 1, parseInt(line) * 2 + 1).filter(v => v).length);
});

let input = require('fs').readFileSync('./dev/stdin').toString().split('\n');
input = input.map(value => value.split(" "));

console.log(input.join("\n"));

// let array = Array.from({ length: Number(length) }, () => false);
// array = solution(array, Number(length / 2));

// var result = 0;

// for (var i = 0; i < array.length / 2; i++) {
//   var teamA = array[i];
//   var teamB = array[array.length - i - 1];
//   var teamACount = 0;
//   var teamBCount = 0;

//   for (var j = 0; j < teamA.length; j++) {
//     for (var k = 0; k < teamA.length; k++) {
//       teamACount += Number(input[teamA[j] - 1][teamA[k] - 1]);
//       teamBCount += Number(input[teamB[j] - 1][teamB[k] - 1]);
//     }
//   }
//   var tempResult = teamACount > teamBCount ? teamACount - teamBCount : teamBCount - teamACount;
//   if (i === 0) result = tempResult;
//   else if (result > tempResult) result = tempResult;
// }

// console.log(result);

// function solution(arr, length) {
//   var result = [];
//   if (length === 1) {
//     for (var i = 0; i < arr.length; i++) {
//       if (!arr[i]) result.push([Number(i + 1)]);
//     }
//   } else {
//     var arrCopy = arr.slice();
//     for (var i = 0; i < arrCopy.length; i++) {
//       if (!arr[i]) {
//         arrCopy[i] = true;
//         var _solution = solution(arrCopy, length - 1);
//         for (var j = 0; j < _solution.length; j++) {
//           result.push([Number(i + 1)].concat(_solution[j]));
//         }
//       }
//     }
//   }
//   return result;
// }
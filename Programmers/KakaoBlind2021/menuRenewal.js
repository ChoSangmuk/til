// https://programmers.co.kr/learn/courses/30/lessons/72411
console.log(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]));
console.log(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]));
console.log(solution(["XYZ", "XWY", "WXA"], [2, 3, 4]));

function solution(orders, course) {
  var ascOrders = orders.map(v => v.split('').sort().join(''));
  var subResult = [];
  var subAnswer = new Map();
  var courseMax = new Map();
  var answer = [];

  ascOrders.forEach(v => course.forEach((c, i) => { subResult = subResult.concat(make(v, c, '')) }));
  subResult.forEach(value => subAnswer.set(value, subAnswer.has(value) ? subAnswer.get(value) + 1 : 1));
  subAnswer.forEach((value, key) => {
    if (value === 1) subAnswer.delete(key);
    else if ((courseMax.has(key.length) && courseMax.get(key.length) < value) || (!courseMax.has(key.length))) courseMax.set(key.length, value);
  });
  courseMax.forEach((value, key) => { subAnswer.forEach((_value, _key) => { if (_key.length === key && value === _value) answer.push(_key) }) });
  return answer.sort();
}

function make(inputS, inputC, inputT) {
  if (inputS.length < inputC) return [];
  else if (inputC == 1) return inputS.split('').map(v => inputT.concat(v));
  else {
    var result = [];
    inputS.split('').map((v, i) => {
      var temp = inputS.slice().split('');
      temp.splice(0, i + 1);
      result = result.concat(make(temp.join(""), inputC - 1, inputT.concat(v)));
    })
    return result;
  }
}
function solution(new_id) {
  var answer = new_id.slice();
  answer = answer.toLowerCase()
    .replace(/[^a-z0-9\.\-\_]/g, '')
    .replace(/\.+/g, '.')
    .replace(/^\./, '')
    .replace(/\.$/, '');
  if (answer === '') answer = 'a';
  if (answer.length >= 16) answer = answer.slice(0, 15);
  answer = answer.replace(/\.$/, '');
  if (answer.length <= 2) {
    while (answer.length < 3) {
      answer = answer.concat(answer[answer.length - 1]);
    }
  }
  return answer;
}
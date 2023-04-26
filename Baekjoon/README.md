# Baekjoon

## Node.js 입/출력
- new Line을 기준으로 전체 입력을 배열로 저장
### 터미널 입력
```js
var input = [];

require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
}).on('line', function (line) {
  input.push(line);
}).on('close', function () {
  console.log(input); // [...]
  // Logic
  process.exit();
})
```
### 파일 읽기
```js
const input = require('fs').readFileSync("./dev/stdin").toString().trim().split("\n");

console.log(input); // [...]
// Logic
```

-----

## JAVA 입/출력
- new Line을 기준으로 전체 입력을 배열로 저장
- Class 명을 Main으로 변경하여 제출
### 터미널 입력
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 전체 입력을 List<String>로 저장
    List<String> inputList = new ArrayList<String>();
    String temp = "";
    while ((temp = br.readLine()) != null) {
      inputList.add(temp);
    }
    System.out.println(inputList); // [...]

    // 전체 입력을 하나의 문자열로 저장
    String input = "";
    temp = "";
    while ((temp = br.readLine()) != null) {
      input += temp + "\n";
      // 혹은 한 줄씩 처리
    }
    System.out.println(input);

    // Logic
  }
}
```
### StringTokenizer VS split
https://library1008.tistory.com/16

-----

## 복습 List
- 1149
- 1436
- 1931
- 2447
- 2580
- 9663
- 11729
- 14888
- 14889
- 18870
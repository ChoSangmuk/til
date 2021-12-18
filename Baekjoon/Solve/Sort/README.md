# Sort

##  O(n²)
- 2750, 수 정렬하기 ([js](js/2750.js), [java](java/J2750.java))
### 버블 정렬(Bubble Sort)
- 인접한 두 원소를 반복하여 비교해가며 자신의 위치를 찾는 정렬
- https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html
1. 서로 인접한 두 원소를 검사, 크기가 순서대로 되어 있지 않으면 서로 교환한다.
2. 처음 실행한 후에는 가장 큰 수가 수열의 맨 뒤로 이동된다.
3. 1-2의 과정을 수열의 길이 만큼 반복하면 뒤에서부터 하나씩 정렬이 완료된다.
```js
function bubbleSort(input) {
  var count = 0;
  // console.log(count++, input);
  for (var j = input.length - 1; j >= 1; j--) {
    for (var i = 0; i < j; i++) {
      if (input[i] > input[i + 1]) {
        var temp = input[i + 1];
        input[i + 1] = input[i];
        input[i] = temp;
        // console.log(count++, input);
      }
    }
  }
  return input;
}
```

### 삽입 정렬(Insertion Sort)
- 맨 앞부터 N-1까지의 수열이 정렬된 상태라 가정하고, N번째 원소를 적절한 위치에 삽입하여 정렬
- https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html
1. 두번째 원소부터 시작하여 수열의 이전 원소들과 비교하여 자신이 삽입될 위치를 찾는다.
2. 즉, N번째 원소의 차례라면, 첫 번째부터 N-1까지의 수열은 정령이 완료된 상태로 볼 수 있다. 
```js
function insertionSort(input) {
  var count = 0;
  // console.log(count++, input);
  for (var j = 1; j < input.length; j++) {
    var temp = input[j];
    for (var i = 0; i < j; i++) {
      if (temp <= input[i]) {
        for (var k = j; k >= i + 1; k--) input[k] = input[k - 1];
        input[i] = temp;
        // console.log(count++, input);
        break;
      }
    }
  }
  return input;
}
```

### 선택 정렬(Selection Sort)
- 최솟값 혹은 최댓값을 찾아 값의 정해진 위치로 이동시키는 정렬
- https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html
1. 주어진 수열에서 최솟값을 찾아 맨 앞에 위치한 값과 교체한다.
2. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
3. 하나의 원소만 남을 때까지 위의 1~2 과정을 반복한다.
```js
function selectionSort(input) {
  var count = 0;
  // console.log(count++, input);
  for (var j = 0; j < input.length - 1; j++) {
    var min = j;
    for (var i = j + 1; i < input.length; i++) {
      if (input[min] > input[i]) min = i;
    }
    var temp = input[min];
    input[min] = input[j];
    input[j] = temp;
    // console.log(count++, input);
  }
  return input;
}
```

## O(n + k)
- 10989, 수 정렬하기 3
  - [~~Node.js~~](js/10989.js)는 별도의 로직 없이 입력만으로 메모리 초과가 발생하여 해결이 불가능
  - [java](java/J10989.java)는 메모리 초과 문제로 입력 즉시 카운팅 되게끔 로직을 변경
### 계수 정렬(Counting Sort)
- 숫자의 값 자체를 인덱스로 활용하자는 개념으로 원소간 비교 연산은 없음
- 누산을 하지 않는 경우, stable을 보장할 수 없음
1. Counting배열\[원소\] ++ 를 통해 각 원소의 갯수를 계산
2. 누산을 이용하여 원소가 지정되어야할 위치를 명시 - 생략 가능
3. Counting배열\[원소\]에는 원소가 위치해야할 위치를 안내해줌 
```js
function countingSort(input) {
  let temp = Array.from({ length: max + 1 }, v => 0); // 범위 최대값 max
  let result = Array.from({ length: input.length }, v => 0);
  for (let i = 0; i < input.length; i++) temp[input[i]] ++;
  for (let i = 1; i < temp.length; i++) temp[i] += temp[i - 1];
  for (var i = 0; i < input.length; i++) result[temp[input[i]]-- - 1] = input[i];
  return result;
}
```

## 내장 Sort
- 1427, 소트인사이드 ([js](js/1427.js), [java](java/J1427.java))
- 11650, 좌표 정렬하기 ([js](js/11650.js), [java](java/J11650.java))
- 11651, 좌표 정렬하기 2 ([js](js/11651.js), [java](java/J11651.java))
- 1181, 단어 정렬 ([js](js/1181.js), [java](java/J1181.java))
- 10814, 나이순 정렬 ([js](js/10814.js), [java](java/J10814.java))
- 18870, 좌표 압축 ([js](js/18870.js))

### JavaScript
- 매개변수
  - compareFunction Optional : 정렬 순서를 정의하는 함수. 생략 시, 문자의 유니 코드 코드 포인트 값에 따라 정렬
- 반환 값
  - 정렬한 배열. 원 배열이 정렬되는 것에 유의하세요. 복사본이 만들어지는 것이 아닙니다.
- https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/sort
```js
arr.sort([compareFunction])

const months = ['March', 'Jan', 'Feb', 'Dec'];
months.sort();
console.log(months);
// expected output: Array ["Dec", "Feb", "Jan", "March"]

const array1 = [1, 30, 4, 21, 100000];
array1.sort((a, b) => a - b);
console.log(array1);
// expected output: Array [1, 4, 21, 30, 100000]
```

### Java
- java.util.Comparator 인터페이스를 직접 사용하거나 필요한 내용을 inner class로 구현하여 사용
```java
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    // Type[] input

    Arrays.sort(input, Comparator.reverseOrder()); // Comparator 기본 내장, 역순 정렬
    Arrays.sort(input, new CustomComparator()); // Custom Comparator, 직접 구현

    String[] resultArr = Arrays.stream(input).distinct().toArray(String[]::new); // 중복제거
  }

  static class CustomComparator implements Comparator<String> { // 예시 1
    @Override
    public int compare(String a, String b) {
      return a.length() == b.length() ? a.compareTo(b) > 0 ? 1 : -1 : a.length() - b.length();
    }
  }

  static class CustomComparator implements Comparator<String> { // 예시 2
    @Override
    public int compare(String a, String b) {
      String[] tempA = a.split(" ");
      String[] tempB = b.split(" ");
      if (Integer.parseInt(tempA[0]) == Integer.parseInt(tempB[0])) return 0;
      else return Integer.parseInt(tempA[0]) - Integer.parseInt(tempB[0]);
    }
  }

  static class CustomComparator implements Comparator<String> { // 예시 3
    @Override
    public int compare(String a, String b) {
      int[] tempA = Arrays.asList(a.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
      int[] tempB = Arrays.asList(b.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
      if (tempA[0] != tempB[0]) return tempA[0] - tempB[0];
      else return tempA[1] - tempB[1];
    }
  }
}
```
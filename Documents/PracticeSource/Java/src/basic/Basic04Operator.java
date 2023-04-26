package basic;

public class Basic04Operator {
  // 기본 연산자
  public static void main(String[] args) {
    // 1. 산술 (+, -, *, /, %)
    System.out.println("1. 산술 (+, -, *, /, %)");
    System.out.println("10 + 3 => " + (10 + 3)); // 13
    System.out.println("10 - 3 => " + (10 - 3)); // 7
    System.out.println("10 * 3 => " + (10 * 3)); // 30
    System.out.println("10 / 3 => " + (10 / 3)); // 나누기 몫 3
    System.out.println("10 % 3 => " + (10 % 3) + "\n"); // 나누기 나머지 1

    System.out.println("10.0 / 3 => " + (10.0 / 3)); // 3.3333333333333335
    System.out.println("10.0f / 3 => " + (10.0f / 3) + "\n"); // 3.3.3333333

    // 2. 대입, 할당 (=, +=, -=, *=, /=, %=, &=, |=, ^=)
    System.out.println("2. 대입, 할당 (=, +=, -=, *=, /=, %=, &=, |=, ^=)");
    int temp = 10;
    temp += 3; // temp = temp + 3;
    System.out.println("temp += 3 => " + temp); // 13
    temp -= 5; // temp = temp - 5;
    System.out.println("temp -= 5 => " + temp + "\n"); // 8

    // 3. bit 연산 (&, |, ^)
    System.out.println("3. bit 연산 (&, |, ^)");
    System.out.println("2 & 8 => " + (2 & 8)); // 0
    System.out.println("2 | 8 => " + (2 | 8)); // 10
    System.out.println("4 ^ 8 => " + (4 ^ 8)); // 12

    temp = 4; // 재할당
    System.out.println(temp); // 4
    temp &= 8;
    System.out.println(temp); // 0
    temp |= 8;
    System.out.println(temp); // 8
    temp ^= 1;
    System.out.println(temp + "\n"); // 9

    // 4. 논리 연산 (&, &&, |, ||)
    System.out.println("4. 논리 연산 (&, &&, |, ||)");
    System.out.println("true & true => " + (true & true)); // true
    System.out.println("true & false => " + (true & false)); // false
    System.out.println("false & false => " + (false & false)); // false

    System.out.println("true && true => " + (true && true)); // true
    System.out.println("true && false => " + (true && false)); // false
    System.out.println("false && false => " + (false && false)); // false

    System.out.println("true | true => " + (true | true)); // true
    System.out.println("true | false => " + (true | false)); // true
    System.out.println("false | false => " + (false | false)); // false

    System.out.println("true || true => " + (true || true)); // true
    System.out.println("true || false => " + (true || false)); // true
    System.out.println("false || false => " + (false || false)); // false

    System.out.println("true ^ false => " + (true ^ false) + "\n"); // true

    // 5.비교 연산 (==, !=, >, <, >=, <=) => true or false
    System.out.println("5.비교 연산");
    int aaa = 55;
    int bbb = 5;
    System.out.println("55 == 5 => " + (aaa == bbb)); // false
    System.out.println("55 != 5 => " + (aaa != bbb) + "\n"); // true

    // 6.쉬프트 (>>, <<, >>>)
    System.out.println("6.쉬프트 (>>, <<, >>>)");
    System.out.println("8 >> 2 => " + (8 >> 2)); // 0010 2
    System.out.println("2 << 2 => " + (2 << 2)); // 1000 8
    System.out.println("(byte) -8 >>> 2 => " + ((byte) -8 >>> 2) + "\n");// 1073741822

    // 7.삼항 연산 (Statement: true? false )
    System.out.println("7.삼항 연산 (Statement: true? false )");
    System.out.println(aaa == bbb ? "A" : "B"); // B
    System.out.println(aaa != bbb & aaa == bbb ? "A" : "B"); // B
    System.out.println(aaa == bbb ? "A" : "B"); // B
    System.out.println((aaa == bbb | aaa != bbb ? "A" : "B") + "\n"); // A

    // 예시
    int avg = 85;
    String grade = 
      avg <= 100 && avg >= 90 ? "A" : 
      avg <= 89 && avg >= 80 ? "B" : 
      avg <= 79 && avg >= 70 ? "C" : "F";
    System.out.println(grade);

    // 8. ++ -- 증감연산자
    int x = 10;
    System.out.println("8. ++ -- 증감연산자");
    System.out.println("before " + x + "  ++X = " + ++x + " after " + x); // 11
    System.out.println("before " + x + "  X++ = " + x++ + " after " + x); // 11
    System.out.println("before " + x + "  --X = " + --x + " after " + x); // 11
    System.out.println("before " + x + "  X-- = " + x-- + " after " + x); // 11
  }
}

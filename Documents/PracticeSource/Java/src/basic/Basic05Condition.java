package basic;

public class Basic05Condition {
  // 조건문 : 특정 조건인 경우에만 실행하고 싶은 경우
  public static void main(String[] args) {
    System.out.println("\nif~else");
    if (true) {
      System.out.println("true"); // O
    }

    if (!"A".equals("B"))
      System.out.println("!\"A\".equals(\"B\""); // O

    if (false) {
      System.out.println("false"); // X
    }

    if (5 != 4 && 5 < 0) System.out.println("5!=4 && 5>0"); // X

    int score = 99;
    if (score >= 90) {
      System.out.println("A");
    } else if (score >= 80)
      System.out.println("B");
    else if (score >= 70) System.out.println("C");
    else {
      System.out.println("F");
    }

    System.out.println("\nswitch~case");
    String name = "kim";
    switch (name) {
      case "kim":
        System.out.println("kim");
        break;
      case "lee":
        System.out.println("lee");
        break;
      default:
        System.out.println("other");
        break;
    }

    // 성적 처리 프로그램 switch case
    // A,B,C,F
    int kor = 80; // 국어
    int eng = 70; // 영어
    int math = 90; // 수학
    int total = kor + eng + math; // 총점
    double avg = total / 3.0; // 평균
    String grade = null; // 등급

    switch ((int) avg / 10) {
      case 10:
      case 9:
        grade = "A";
        break;
      case 8:
        grade = "B";
        break;
      case 7:
        grade = "C";
        break;
      default:
        grade = "F";
        break;
    }

    System.out.println(grade);
  }
}

package object;

public class Student {

  // 객체의 정의
  // 제원, 속성, 멤버필드, 멤버변수, 전역변수, 인스턴스변수
  int num; // 0
  String name; // null
  int kor;
  int eng;
  int math;
  int total;
  double avg;
  String grade;

  // 기본 생성자(매개변수 없음, 생략 가능)
  // 메소드 오버로딩을 통해 다양한 생성자 정의 가능
  public Student() {
    System.out.println("Student()");
    this.num = 0;
    this.name = "Cho Sang Muk";
    this.kor = 80;
    this.eng = 75;
    this.math = 95;
  }

  public Student(int num) {
    this.num = num;
  }

  public Student(int num, String name) {
    this.num = num;
    this.name = name;
  }

  public static void main(String[] args) {
    // 객체의 생성 className objectName = new 생성자();
    Student student0 = new Student();
    System.out.println("student0.num " + student0.num);
    System.out.println("student0.name " + student0.name);
    System.out.println("student0.kor " + student0.kor);
    System.out.println();

    Student student1 = new Student(1, "Kim");
    System.out.println("student1 " + student1);
    System.out.println("student1.num " + student1.num);
    System.out.println("student1.name " + student1.name);
    student1.num = 8;
    System.out.println("student1.num " + student1.num);
    System.out.println();

    Student student2 = new Student(2, "An");
    System.out.println("student2.num " + student2.num);
    System.out.println("student2.name " + student2.name);
    System.out.println("student2.kor " + student2.kor);
  }
}

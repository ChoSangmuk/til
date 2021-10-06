package method;

public class methodBasic {
  // 전역변수, 멤버필드, 인스턴스변수, 멤버변수
  int num;
  String name;

  // 생성자(Constructor)
  public methodBasic() {
    System.out.println("methodBasic()...");
  }

  public methodBasic(int num, String name) {
    this.num = num;
    this.name = name;
  }

  // 함수(method)
  // [접근 제한] [정의 제한] type 함수명(){}

  // A. 매개변수 무, return 무(void)
  public void method1() {
    System.out.println("method1()");
  }

  // B. 매개변수 유, return 무(void)
  public void method2(int x) {
    System.out.println("method2() " + (x + 10));
  }

  // C. 매개변수 무, return 유(반환값에 대한 해당타입)
  public int method3() {
    System.out.println("method3()");
    return 999;
  }

  // D. 매개변수 유, return 유(반환값에 대한 해당타입)
  public String method4(String x) {
    System.out.println("method4() " + x);
    return "method4() " + x;
  }

  public static void main(String[] args) {
    // method, 함수(function), 오퍼레이터(Operator)
    methodBasic tm = new methodBasic();
    System.out.println();

    tm.method1();
    System.out.println();

    tm.method2(1000);
    System.out.println();

    System.out.println(tm.method3());
    System.out.println();

    System.out.println(tm.method4("good!!!!"));
    System.out.println();
  }
}

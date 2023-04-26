import java.util.Scanner;

public class J2525 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int H = sc.nextInt();
    int M = sc.nextInt();
    int A = sc.nextInt();

    M = M + A;
    H = (H + M / 60) % 24;
    M = M % 60;

    System.out.println(H + " " + M);
  }
}
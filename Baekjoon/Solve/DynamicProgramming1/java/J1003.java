import java.util.Scanner;

public class J1003 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numberOfTests = sc.nextInt();
    for (int k = 0; k < numberOfTests; k++) {
      int N = sc.nextInt();
      int result[] = new int[2];
      result = solution(N);
      for (int i : result)
        System.out.print(i + " ");
    }
    sc.close();
  }

  public static int[] solution(int N) {
    int output[][] = { { 1, 0 }, { 0, 1 }, { 0, 0 } };
    for (int i = 2; i <= N; i++) {
      output[i % 3][0] = output[(i - 1) % 3][0] + output[(i - 2) % 3][0];
      output[i % 3][1] = output[(i - 1) % 3][1] + output[(i - 2) % 3][1];
    }
    return output[N % 3];
  }

}
import java.util.Scanner;

import java.io.IOException;

public class J14888 {
  static int N;
  static int[] input;
  static int[] operation = new int[4];
  static int max = -1_000_000_000;
  static int min = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    input = new int[N];
    for (int i = 0; i < N; i++) input[i] = sc.nextInt();
    for (int i = 0; i < 4; i++) operation[i] = sc.nextInt();
    solution(0);
    System.out.println(max + " " + min);
  }

  static void solution(int pos) {
    if (pos == N - 1) {
      if (input[N - 1] > max) max = input[N - 1];
      if (input[N - 1] < min) min = input[N - 1];
    } else {
      int A = input[pos];
      int B = input[pos + 1];
      for (int i = 0; i < 4; i++) {
        if (operation[i] != 0) {
          operation[i]--;
          int temp = 0;
          if (i == 0) temp = A + B;
          else if (i == 1) temp = A - B;
          else if (i == 2) temp = A * B;
          else if (i == 3 && A < 0) temp = (int) Math.floor((-1 * A) / B) * -1;
          else if (i == 3) temp = (int) Math.floor(A / B);
          input[pos + 1] = temp;
          solution(pos + 1);
          operation[i]++;
          input[pos + 1] = B;
        }
      }
    }
  }
}
import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;

public class J15650 {
  static boolean[] temp;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    temp = new boolean[N];
    Arrays.fill(temp, false);
    solution(0, 0);
  }

  static void solution(int pos, int depth) {
    if (depth == M) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < N; j++) if (temp[j]) sb.append((j + 1) + " ");
      System.out.println(sb.toString().trim());
    } else {
      for (int i = pos; i < N; i++) {
        if (!temp[i]) {
          temp[i] = true;
          solution(i + 1, depth + 1);
          temp[i] = false;
        }
      }
    }
  }
}
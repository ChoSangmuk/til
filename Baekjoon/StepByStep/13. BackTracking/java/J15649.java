import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;

public class J15649 {
  static int[] temp;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    temp = new int[N];
    Arrays.fill(temp, -1);
    solution(0);
  }

  static void solution(int depth) {
    if (depth == M) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < M; i++) for (int j = 0; j < N; j++) if (temp[j] == i) sb.append((j + 1) + " ");
      System.out.println(sb.toString().trim());
    } else {
      for (int i = 0; i < N; i++) {
        if (temp[i] == -1) {
          temp[i] = depth;
          solution(depth + 1);
          temp[i] = -1;
        }
      }
    }
  }
}
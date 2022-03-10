import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;

public class J15651 {
  static int N;
  static int M;
  static int[] result;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    result = new int[M];
    sb = new StringBuilder();
    solution(0);
    System.out.println(sb.toString().trim());
  }

  static void solution(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(result[i]);
        if (i != M - 1) sb.append(" ");
      }
      sb.append("\n");
    } else {
      for (int i = 0; i < N; i++) {
        result[depth] = i + 1;
        solution(depth + 1);
      }
    }
  }
}
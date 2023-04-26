import java.util.Scanner;
import java.io.IOException;

public class J2580 {
  static int[] row = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
  static int[] col = new int[] { 0, 9, 18, 27, 36, 45, 54, 63, 72 };
  static int[] sqr = new int[] { 0, 1, 2, 9, 10, 11, 18, 19, 20 };
  static int[] input = new int[81];
  static int[] empty = new int[81];
  static int count = 0;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < input.length; i++) {
      input[i] = sc.nextInt();
      if (input[i] == 0) empty[count++] = i;
    }
    solution(0);
  }

  static void solution(int position) {
    if (position == count) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 81; i++) {
        if (i != 0 && i % 9 == 0) sb.append("\n");
        sb.append(input[i] + " ");
      }
      System.out.println(sb);
      System.exit(0);
    } else {
      int index = (int) empty[position];
      int x = (int) Math.floor(index / 9);
      int y = index % 9;
      int sqr_start = ((int) Math.floor(index / 27) * 27) + (((int) Math.floor(index / 3) % 3) * 3);

      for (int i = 1; i <= 9; i++) {
        if (!(check(x, y, sqr_start, i))) continue;
        input[index] = i;
        solution(position + 1);
        input[index] = 0;
      }
    }
  }

  static boolean check(int x, int y, int sqr_start, int i) {
    for (int j : row) if (input[j + x * 9] == i) return false;
    for (int j : col) if (input[j + y] == i) return false;
    for (int j : sqr) if (input[j + sqr_start] == i) return false;
    return true;
  }
}
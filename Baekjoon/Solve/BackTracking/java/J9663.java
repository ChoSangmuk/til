import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;

public class J9663 {
  static int N;
  static int[] board;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    board = new int[N];
    Arrays.fill(board, -1);
    System.out.println(solution(0));
  }

  static int solution(int position) {
    if (position == board.length) return 1;
    int result = 0;
    for (Integer i = 0; i < board.length; i++) {
      boolean temp = true;
      for (int k = 0; k < position; k++) if (board[k] == i) temp = false;

      if (temp) {
        board[position] = i;
        if (check(position)) result += solution(position + 1);
        board[position] = -1;
      }
    }
    return result;
  }

  static boolean check(int position) {
    for (int i = 0; i < position; i++)
      if (board[i] - position + i == board[position] || board[i] + position - i == board[position]) return false;
    return true;
  }
}
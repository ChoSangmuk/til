import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;

public class J14889 {
  static int N;
  static int[][] score;
  static boolean[] team;
  static int min = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    score = new int[N][N];
    team = new boolean[N];
    Arrays.fill(team, false);
    for (int i = 0; i < N; i++)for (int j = 0; j < N; j++) score[i][j] = sc.nextInt();

    solution(N / 2, 0);
    System.out.println(min);
  }

  static int add(int i, int j) {
    return score[i][j] + score[j][i];
  }

  static void solution(int use, int pos) {
    if (pos == 0) {
      team[pos] = true;
      solution(use - 1, pos + 1);
    } else if (use == 0) {
      int[] teamA = new int[N / 2];
      int teamAPos = 0;
      int[] teamB = new int[N / 2];
      int teamBPos = 0;
      for (int i = 0; i < team.length; i++) {
        if (team[i]) teamA[teamAPos++] = i;
        else teamB[teamBPos++] = i;
      }
      int diff = 0;
      for (int j = 0; j < teamA.length; j++) for (int k = j + 1; k < teamA.length; k++) diff = diff + add(teamA[j], teamA[k]) - add(teamB[j], teamB[k]);
      if (min == -1) min = Math.abs(diff);
      else if (min > Math.abs(diff)) min = Math.abs(diff);
    } else {
      team[pos] = true;
      solution(use - 1, pos + 1);
      team[pos] = false;
      if (team.length >= use + pos + 1) solution(use, pos + 1);
    }
  }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J9020 {
  static int max = (10000 * 2) + 1;
  static boolean[] myArray = new boolean[max];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Arrays.fill(myArray, true);
    myArray[0] = false;
    myArray[1] = false;
    int pointer = 2;
    while (pointer != max) {
      if (myArray[pointer])
        for (int i = 2; pointer * i < max; i++) myArray[pointer * i] = false;
      pointer++;
    }

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) System.out.println(solution(Integer.parseInt(br.readLine())));
  }

  public static String solution(int input) {
    int A = input / 2;
    int B = input / 2;
    while (true) {
      if (myArray[A] && myArray[B]) break;
      else {
        A--;
        B++;
      }
    }
    return A + " " + B;
  }
}
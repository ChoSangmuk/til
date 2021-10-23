import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J1065 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    int result = 0;
    for (int i = 1; i <= input; i++) {
      String[] tempArray = (i + "").split("");
      int[] temp = new int[tempArray.length];
      for (int k = 0; k < tempArray.length; k++) {
        if (k == 0) temp[0] = 0;
        else temp[k] = Integer.parseInt(tempArray[k]) - Integer.parseInt(tempArray[k - 1]);
      }
      boolean hansu = true;
      for (int k = 1; k < temp.length - 1; k++) {
        if (temp[k] != temp[k + 1]) {
          hansu = false;
          break;
        }
      }
      if (hansu) result++;
    }
    System.out.println(result);
  }
}
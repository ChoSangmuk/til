import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class J1316 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int result = 0;
    for (int i = 0; i < N; i++) if (problem(br.readLine())) result++;
    System.out.println(result);
  }

  public static boolean problem(String input) {
    boolean result = true;
    ArrayList<Character> temp = new ArrayList<Character>();
    temp.add(input.charAt(0));
    int tempLength = temp.size();
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) != temp.get(tempLength - 1)) {
        if (temp.indexOf(input.charAt(i)) == -1) {
          temp.add(input.charAt(i));
          tempLength++;
        } else {
          result = false;
          break;
        }
      }
    }
    return result;
  }
}
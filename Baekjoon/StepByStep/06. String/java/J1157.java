import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class J1157 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine().toUpperCase();
    int[] alphabetCount = new int[26];
    Arrays.fill(alphabetCount, 0);
    for (int i = 0; i < input.length(); i++) alphabetCount[input.charAt(i) - 65]++;

    int max_pos = 0;
    boolean doubleCheck = false;

    for (int i = 0; i < 26; i++) if (alphabetCount[i] >= alphabetCount[max_pos]) max_pos = i;
    for (int i = 0; i < 26; i++) {
      if (i != max_pos && alphabetCount[i] >= alphabetCount[max_pos]) {
        doubleCheck = true;
        break;
      }
    }
    if (doubleCheck) System.out.println("?");
    else System.out.println((char) (max_pos + 65));
  }
}
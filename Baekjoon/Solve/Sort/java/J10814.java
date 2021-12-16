import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class J10814 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] input = new String[N];
    for (int i = 0; i < N; i++) input[i] = br.readLine();

    Arrays.sort(input, new CustomComparator());
    for (String value : input) bufferedWriter.append(value + "\n");
    bufferedWriter.flush();
  }

  static class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
      String[] tempA = a.split(" ");
      String[] tempB = b.split(" ");
      if (Integer.parseInt(tempA[0]) == Integer.parseInt(tempB[0])) return 0;
      else return Integer.parseInt(tempA[0]) - Integer.parseInt(tempB[0]);
    }
  }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class J11650 {
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
      int[] tempA = Arrays.asList(a.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
      int[] tempB = Arrays.asList(b.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
      if (tempA[0] != tempB[0]) return tempA[0] - tempB[0];
      else return tempA[1] - tempB[1];
    }
  }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class J1181 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] input = new String[N];
    for (int i = 0; i < N; i++) input[i] = br.readLine();

    Arrays.sort(input, new CustomComparator());
    String[] resultArr = Arrays.stream(input).distinct().toArray(String[]::new);

    for (String value : resultArr) bufferedWriter.append(value + "\n");
    bufferedWriter.flush();
  }

  static class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
      return a.length() == b.length() ? a.compareTo(b) > 0 ? 1 : -1 : a.length() - b.length();
    }
  }
}
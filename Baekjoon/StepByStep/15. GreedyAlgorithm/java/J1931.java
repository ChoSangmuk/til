import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.io.IOException;

public class J1931 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] input = new int[N][2];
    for (int i = 0; i < N; i++)
      input[i] = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

    Arrays.sort(input, new CustomComparator());
    LinkedList<int[]> result = new LinkedList<>();
    int position = 0;
    for (int i = 0; i < input.length; i++) {
      if (i == 0) result.add(input[i]);
      else if (input[position][1] <= input[i][0]) {
        result.add(input[i]);
        position = i;
      }
    }
    System.out.println(result.size());
  }

  static class CustomComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
      if (a[1] > b[1]) return 1;
      else if (a[1] < b[1]) return -1;
      else {
        if (a[0] > b[0]) return 1;
        else if (a[0] < b[0]) return -1;
      }
      return 1;
    }
  }
}
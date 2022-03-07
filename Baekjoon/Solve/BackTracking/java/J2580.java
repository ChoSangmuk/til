import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class J2580 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String inputString = "";
    for (int i = 0; i < 9; i++) inputString += " " + br.readLine();
    int[] input = Arrays.asList(inputString.trim().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

    ArrayList<Integer> empty = new ArrayList<>();
    for (int i = 0; i < input.length; i++) if (input[i] == 0) empty.add(i);
    
    solution(input, empty);
  }

  static void solution(int[] input, ArrayList<Integer> empty) {
    if (empty.size() == 0) {
      String answer = "";
      for (int i = 0; i < 81; i++) {
        if (i != 0 && i % 9 == 0) answer = answer.trim() + "\n";
        answer += input[i] + " ";
      }
      System.out.println(answer.trim());
      System.exit(0);
    } else {
      int index = (int) empty.remove(0);

      List<Integer> row = new ArrayList<>();
      for (int i = ((int) Math.floor(index / 9)) * 9; i < ((int) Math.floor(index / 9) + 1) * 9; i++) row.add(input[i]);
      List<Integer> row_possible = new ArrayList<>();
      for (int i : new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }) if (!row.contains(i)) row_possible.add(i);

      List<Integer> col = new ArrayList<>();
      for (int i : new int[] { 0, 9, 18, 27, 36, 45, 54, 63, 72 }) col.add(input[i + (index % 9)]);

      int sqr_start = ((int) Math.floor(index / 27) * 27) + (((int) Math.floor(index / 3) % 3) * 3);
      List<Integer> sqr = new ArrayList<>();
      for (int i : new int[] { 0, 1, 2, 9, 10, 11, 18, 19, 20 }) sqr.add(input[i + sqr_start]);

      for (int i = 0; i < row_possible.size(); i++) {
        if (col.contains(row_possible.get(i)) || sqr.contains(row_possible.get(i))) continue;
        input[index] = row_possible.get(i);
        solution(input, new ArrayList<>(empty));
        input[index] = 0;
      }
    }
  }
}
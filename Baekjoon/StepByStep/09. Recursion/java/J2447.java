import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

public class J2447 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    LinkedList<String> result = solution(input);
    for (var i = 0; i < input; i++)
      System.out.println(result.get(i));
  }

  public static LinkedList<String> solution(int input) {
    LinkedList<String> result = new LinkedList<String>();
    if (input == 3) {
      result.add("***");
      result.add("* *");
      result.add("***");
    } else {
      int preInput = input / 3;
      LinkedList<String> preSolution = solution(preInput);
      for (int i = 0; i < input; i++) {
        int tempInt = i % preInput;
        if (Math.floor(i / preInput) == 1)
          result.add(preSolution.get(tempInt) + emptySpace(preInput) + preSolution.get(tempInt));
        else
          result.add(preSolution.get(tempInt) + preSolution.get(tempInt) + preSolution.get(tempInt));
      }
    }
    return result;
  }

  public static String emptySpace(int input) {
    String result = "";
    for (int i = 0; i < input; i++)
      result = result.concat(" ");
    return result;
  }
}
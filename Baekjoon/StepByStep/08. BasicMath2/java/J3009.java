import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J3009 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input1 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
    int[] input2 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
    int[] input3 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
    System.out.println((input1[0] == input2[0] ? input3[0] : input1[0] == input3[0] ? input2[0] : input1[0]) + " "
        + (input1[1] == input2[1] ? input3[1] : input1[1] == input3[1] ? input2[1] : input1[1]));
  }
}
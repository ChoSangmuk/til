import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J4948 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int max = (123456 * 2) + 1;
    boolean[] myArray = new boolean[max];
    Arrays.fill(myArray, true);
    myArray[0] = false;
    myArray[1] = false;
    int pointer = 2;
    while (pointer != max) {
      if (myArray[pointer])
        for (int i = 2; pointer * i <= max; i++) myArray[pointer * i] = false;
      pointer++;
    }

    while (true) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0) break;
      else {
        boolean[] myArrayCopy = Arrays.copyOfRange(myArray, input + 1, input * 2 + 1);
        int count = 0;
        for (int i = 0; i < myArrayCopy.length; i++)
          if (myArrayCopy[i]) count++;
        System.out.println(count);
      }
    }
  }
}
import java.io.IOException;

public class J4673 {
  public static void main(String[] args) throws IOException {
    int[] temp = new int[10001];
    for (int i = 1; i <= 10000; i++) {
      if (temp[i] == 0) System.out.println(i);
      String[] tempArray = (i + "").split("");
      int tempInt = i;
      for (String k : tempArray) tempInt += Integer.parseInt(k);
      if (tempInt <= 10000) temp[tempInt] = i;
    }
  }
}
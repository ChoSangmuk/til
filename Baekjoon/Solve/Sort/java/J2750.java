import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2750 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] input = new int[N];
    for (int i = 0; i < N; i++) input[i] = Integer.parseInt(br.readLine());
    int[] result = selectionSort(input);
    for (int i = 0; i < N; i++) System.out.println(result[i]);
  }

  public static int[] bubbleSort(int[] input) {
    for (int j = input.length - 1; j >= 1; j--) {
      for (int i = 0; i < j; i++) {
        if (input[i] > input[i + 1]) {
          int temp = input[i + 1];
          input[i + 1] = input[i];
          input[i] = temp;
        }
      }
    }
    return input;
  }

  public static int[] insertionSort(int[] input) {
    for (int j = 1; j < input.length; j++) {
      int temp = input[j];
      for (int i = 0; i < j; i++) {
        if (temp <= input[i]) {
          for (int k = j; k >= i + 1; k--) input[k] = input[k - 1];
          input[i] = temp;
          break;
        }
      }
    }
    return input;
  }

  public static int[] selectionSort(int[] input) {
    for (int j = 0; j < input.length - 1; j++) {
      int min = j;
      for (int i = j + 1; i < input.length; i++) {
        if (input[min] > input[i]) min = i;
      }
      int temp = input[min];
      input[min] = input[j];
      input[j] = temp;
    }
    return input;
  }
}
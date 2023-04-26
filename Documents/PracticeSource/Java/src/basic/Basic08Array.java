package basic;

// import java.util.Arrays;

public class Basic08Array {
  // 배열 : 동일한 타입의 데이터를 하나의 변수로
  public static void main(String[] args) {
    System.out.println("\nInt Array");
    int[] temps = new int[3];
    // 배열의 주소를 모두 같은 값으로 초기화
    // Arrays.fill(temps, 1); // temps의 모든 index값을 1로 초기화
    for (int i = 0; i < temps.length; i++)
      temps[i] = 10 * (i + 1);
    // or int[] temps = new int[] { 10, 20, 30 };
    for (int i = 0; i < temps.length; i++)
      System.out.print(temps[i]);
    // or for (int temp : temps) System.out.print(temp);
    System.out.println();

    System.out.println("\nString array");
    String[] strings = new String[3];
    strings[0] = "Aaa";
    strings[1] = "Bbb";
    strings[2] = "Ccc";
    // or String[] strings = new String[] { "Aaa", "Bbb", "Ccc" };
    for (int i = 0; i < strings.length; i++)
      System.out.print(strings[i]);
    // or for (String string : strings) System.out.print(string);
    System.out.println();

    System.out.println("\narray array");
    int[][] doubleTemp = new int[2][temps.length];
    doubleTemp[0] = temps;
    doubleTemp[1] = new int[temps.length];
    for (int i = 0; i < doubleTemp[1].length; i++)
      doubleTemp[1][i] = doubleTemp[0][i] + 1;

    for (int x = 0; x < doubleTemp.length; x++) {
      for (int i = 0; i < doubleTemp[x].length; i++)
        System.out.print(doubleTemp[x][i] + " ");
      System.out.println();
    }
    System.out.println();

    doubleTemp = new int[][] { new int[3], new int[] { 11, 12 }, { 21, 22, 23, 24 } };
    doubleTemp[1] = new int[] { 31, 32, 33 };
    doubleTemp[0][2] = 41;
    doubleTemp[1][1] = 51;
    doubleTemp[1][2] = 61;
    for (int x = 0; x < doubleTemp.length; x++) {
      for (int i = 0; i < doubleTemp[x].length; i++)
        System.out.print(doubleTemp[x][i] + " ");
      System.out.println();
    }
  }
}

package basic;

public class Basic06For {
  // 반복문 : for
  public static void main(String[] args) {
    System.out.print("\nfor\n");
    for (int i = 0; i < 10; i++) {
      System.out.print(i);
    }

    System.out.print("\n\nfor if\n");
    for (int i = 0; i < 10; i += 2)
      if (i % 3 != 0)
        System.out.print(i);

    System.out.print("\n\nfor char\n");
    for (char i = 'a'; i <= 'd'; i++)
      System.out.println(i + ", " + (int) i);

    System.out.print("\n\nfor for\n");
    for (int x = 0; x < 5; x++) {
      System.out.print("[" + x + "] ");
      for (int i = 0; i < 5; i++)
        System.out.print(i + " ");
      System.out.println();
    }

    System.out.print("\n\nfor continue, break\n");
    for (int x = 0; x < 5; x++) {
      if (x == 0)
        continue;
      if (x == 3)
        break;
      System.out.print("[" + x + "] ");
      for (int i = 0; i < 5; i++)
        System.out.print(i + " ");
      System.out.println();
    }

    System.out.print("\n\narray\n");
    for (int i : new int[5])
      System.out.print(i);
    System.out.println();
  }
}

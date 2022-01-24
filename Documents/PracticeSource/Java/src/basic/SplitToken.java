package basic;

import java.util.StringTokenizer;

public class SplitToken {
  public static void main(String[] args) {
    // 90:80:70
    String date = "90:80:70";

    String[] dates = date.split(":");
    int total = 0;
    for (String data : dates) total += Integer.parseInt(data);
    System.out.println("date.split(\":\") sum : " + total);

    StringTokenizer st = new StringTokenizer(date);
    total = 0;
    while (st.hasMoreTokens()) total += Integer.parseInt(st.nextToken(":"));
    System.out.println("new StringTokenizer(date) sum : " + total);
  }
}
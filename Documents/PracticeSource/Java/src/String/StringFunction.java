public class StringFunction {
  public static void main(String[] args) {
    // String Function
    String str = "kiMiss";
    System.out.println("\nstr - " + str);
    System.out.println("str.equals(\"Kim\") - " + str.equals("Kim"));
    System.out.println("str.equalsIgnoreCase(\"Kim\") - " + str.equalsIgnoreCase("Kim"));
    System.out.println("str.compareTo(\"kiM\") - " + str.compareTo("kiM"));
    System.out.println("str.compareTo(\"kiM\") == 0 - " + (str.compareTo("kiM") == 0));

    String str2 = "Hello java";
    System.out.println("\nstr2 - " + str2);
    System.out.println("str2.startsWith(\"Hel\") - " + str2.startsWith("Hel"));
    System.out.println("str2.endsWith(\"va\") - " + str2.endsWith("va"));
    str2 = "http://www.java.com/aaa/bbb/test.jpg";
    System.out.println("str2 " + str2);
    System.out.println("str2.startsWith(\"http://\") - " + str2.startsWith("http://"));
    System.out.println("str2.endsWith(\".jpg\") - " + str2.endsWith(".jpg"));

    String str3 = "무궁화 꽃이 피었습니다.";
    System.out.println("\nstr3 - " + str3);
    System.out.println("str3.charAt(0) - " + str3.charAt(0));
    System.out.println("str3.charAt(5) - " + str3.charAt(5));
    System.out.println("str3.indexOf(\"무\") - " + str3.indexOf("무"));
    System.out.println("str3.indexOf(\"궁\") - " + str3.indexOf("궁"));
    System.out.println("str3.indexOf(\" \") - " + str3.indexOf(" "));
    System.out.println("str3.indexOf(\".\") - " + str3.indexOf("."));
    System.out.println("str3.substring(5) - " + str3.substring(5));
    System.out.println("str3.substring(5, 8) - " + str3.substring(5, 8));
    System.out.println("str3.concat(\"<<<<\") - " + str3.concat("<<<<"));
    str3 = str3.concat("<<<<");
    System.out.println("str3 = str3.concat(\"<<<<\") - " + str3);
    str3 += "aaaa";
    System.out.println("str3 += \"aaaa\" - " + str3);

    String str4 = "A";
    System.out.println("\nstr4 - " + str4);
    System.out.println("str4.hashCode() - " + str4.hashCode());
    str4 = "http://aaa.com/test.png";
    System.out.println("str4 - " + str4);
    System.out.println("str4.lastIndexOf(\"/\") - " + str4.lastIndexOf("/"));
    System.out.println("str4.substring(str2.lastIndexOf(\"/\")) - " + str4.substring(str4.lastIndexOf("/")));
    System.out.println("str4.length() - " + str4.length());
    System.out.println("str4.replace('a', 'b') - " + str4.replace('a', 'b'));
    System.out.println("str4.replace(\"test\", \"java\") - " + str4.replace("test", "java"));
    System.out.print("str4.toCharArray() for : - ");
    for (char x : str4.toCharArray()) System.out.print(x + " ");
    System.out.println();
    System.out.println("new String(str4.toCharArray()) - " + new String(str4.toCharArray()));

    System.out.println("\nString.valueOf(99) - " + String.valueOf(99));
    System.out.println("Integer.toString() - " + new Integer(99).toString());

    CharSequence st = "aaa";
    System.out.println("CharSequence st.length() - " + st.length());
  }
}
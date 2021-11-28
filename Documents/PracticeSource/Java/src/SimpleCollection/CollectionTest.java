import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class CollectionTest {
  public static void main(String[] args) {
    // 1.List - 배열과 유사하며, 공백을 허용하지 않음
    System.out.println("\nList Declaration");
    List<String> list = new ArrayList<String>();
    // LinkedList<String> list = new LinkedList<String>();
    // List<String> list = new Vector<String>();
    System.out.println("list.size():" + list.size() + " - " + list.toString());

    System.out.println("\nList Add");
    list.add("ABC");
    list.add("DEF");
    list.add(String.valueOf(100));
    list.add(new String(new char[] { 'a', 'b' }));
    System.out.println("list.size():" + list.size() + " - " + list.toString());

    System.out.println("\nList Remove");
    list.remove(0);
    System.out.println("list.size():" + list.size() + " - " + list.toString());

    System.out.println("\nList Set");
    list.set(2, "kim");
    System.out.println("list.size():" + list.size() + " - " + list.toString());

    System.out.println("\nList for(get)");
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");

    System.out.println("\n\nList for : ");
    for (String x : list)
      System.out.print(x + " ");

    // 2.Set - 순서가 없으며, 중복이 불가능, 수학의 집합과 유사
    System.out.println("\nSet Declaration");
    Set<Integer> set = new HashSet<Integer>();
    System.out.println("set.size():" + set.size() + " - " + set.toString());

    System.out.println("\nSet Add");
    set.add(1000);
    set.add(10001);
    set.add(10002);
    set.add(10003);
    set.add(10001);
    System.out.println("set.size():" + set.size() + " - " + set.toString());

    System.out.println("\nSet Remove");
    set.remove(10001);
    set.remove(10004);
    System.out.println("set.size():" + set.size() + " - " + set.toString());

    System.out.println("\nSet Iterator");
    Iterator<Integer> it = set.iterator();
    while (it.hasNext())
      System.out.print(it.next() + " ");

    System.out.println("\n\nSet for : ");
    for (Integer x : set)
      System.out.print(x + " ");

    // 3.Map - 사전과 유사
    System.out.println("\nMap Declaration");
    Map<String, String> map = new Hashtable<String, String>();
    System.out.println("map.size():" + map.size() + " - " + map.toString());

    System.out.println("\nMap put");
    map.put("key1", "kim1");
    map.put("key11", "kim2");
    map.put("key111", "kim3");
    map.put("key1111", "kim4");
    System.out.println("map.size():" + map.size() + " - " + map.toString());

    System.out.println("\nMap get");
    System.out.println(map.get("key1"));

    System.out.println("\nMap for keySet : ");
    for (String key : map.keySet())
      System.out.print(key + ":" + map.get(key) + " ");
  }
}
package frame;

public class BoardMain {
  public static void main(String[] args) {
    BoardDAO dao = new BoardDAO();
    int result = 0;

    // 1. insert
    BoardVO vo1 = new BoardVO();
    vo1.setNum(1);
    vo1.setTitle("1");
    vo1.setContent("1");
    vo1.setName("1");
    result = dao.insert(vo1);
    System.out.println("insert result : " + result + "\n");

    // 2. update
    BoardVO vo2 = new BoardVO();
    vo2.setNum(2);
    vo2.setTitle("2");
    vo2.setContent("2");
    vo2.setName("2");
    result = dao.update(vo2);
    System.out.println("update result : " + result + "\n");

    // 3. delete
    BoardVO vo3 = new BoardVO();
    vo3.setNum(3);
    vo3.setTitle("3");
    vo3.setContent("3");
    vo3.setName("3");
    result = dao.delete(vo3);
    System.out.println("delete result : " + result + "\n");

    // 4. selectOne
    BoardVO vo4 = new BoardVO();
    vo4.setNum(4);
    vo4.setTitle("4");
    vo4.setContent("4");
    vo4.setName("4");
    BoardVO resultVO = dao.selectOne(vo4);
    System.out.println("selectOne result : " + dao.VOtoString(resultVO));

    // 5. selectAll
    BoardVO[] vos = dao.selectAll();
    System.out.println("selectAll result : " + vos.length);
    for (BoardVO board : vos)
      System.out.print(dao.VOtoString(board));
  }
}

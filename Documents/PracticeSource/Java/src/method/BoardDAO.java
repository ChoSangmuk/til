package method;

public class BoardDAO {
  Aaa a;
  Bbb b;

  public String VOtoString(BoardVO vo) {
    String result = vo + " " + vo.getNum() + " " + vo.getTitle() + " " + vo.getContent() + " " + vo.getName() + "\n";
    return result;
  }

  public int insert(BoardVO vo) {
    System.out.println("insert(BoardVO vo)");
    System.out.println("\t" + VOtoString(vo));
    return 1;
  }

  public int update(BoardVO vo) {
    System.out.println("update(BoardVO vo)");
    System.out.println("\t" + VOtoString(vo));
    return 1;
  }

  public int delete(BoardVO vo) {
    System.out.println("delete(BoardVO vo)");
    System.out.println("\t" + VOtoString(vo));
    return 1;
  }

  public BoardVO selectOne(BoardVO vo) {
    System.out.println("selectOne(BoardVO vo)");
    System.out.println("\t" + VOtoString(vo));

    BoardVO resultVO = new BoardVO();
    resultVO.setNum(5);
    resultVO.setTitle("5");
    resultVO.setContent("5");
    resultVO.setName("5");
    return resultVO;
  }

  public BoardVO[] selectAll() {
    System.out.println("selectAll()");
    BoardVO vo1 = new BoardVO();
    vo1.setNum(10);
    vo1.setTitle("title10");
    vo1.setContent("content10");
    vo1.setName("name10");

    BoardVO vo2 = new BoardVO();
    vo2.setNum(20);
    vo2.setTitle("title20");
    vo2.setContent("content20");
    vo2.setName("name20");

    BoardVO vo3 = new BoardVO();
    vo3.setNum(30);
    vo3.setTitle("title30");
    vo3.setContent("content30");
    vo3.setName("name30");
    return new BoardVO[] { vo1, vo2, vo3 };
  }
}
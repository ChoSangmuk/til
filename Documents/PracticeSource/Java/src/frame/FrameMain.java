package frame;

public class FrameMain {

  public static void main(String[] args) {
    System.out.println("Member...");

    MemberDAO dao = new MemberDAOimpl();
    System.out.println(dao);

    // 1.insert
    MemberVO vo = new MemberVO();
    vo.setNum(111);
    vo.setId("admin11");
    vo.setPw("123411");
    vo.setName("kim11");
    vo.setTel("01011");
    int result = dao.insert(vo);
    System.out.println("result:" + result + "\n");

    // 2.update
    MemberVO vo2 = new MemberVO();
    vo2.setNum(222);
    vo2.setId("admin22");
    vo2.setPw("123422");
    vo2.setName("kim22");
    vo2.setTel("01022");
    int result2 = dao.update(vo2);
    System.out.println("result2:" + result2 + "\n");

    // 3.delete
    MemberVO vo3 = new MemberVO();
    vo3.setNum(333);
    int result3 = dao.delete(vo3);
    System.out.println("result3:" + result3 + "\n");

    // 4.selectOne
    MemberVO vo4 = new MemberVO();
    vo4.setNum(444);
    vo4.setId("admin44");
    vo4.setPw("123444");
    vo4.setName("kim44");
    vo4.setTel("01044");
    MemberVO result4 = dao.selectOne(vo4);
    System.out.println("result4:" + result4);
    System.out.println(result4.getNum());
    System.out.println(result4.getId());
    System.out.println(result4.getPw());
    System.out.println(result4.getName());
    System.out.println(result4.getTel() + "\n");

    // 5.selectAll
    MemberVO[] result5 = dao.selectAll();
    System.out.println("result5.length:" + result5.length);
    for (MemberVO x : result5) {
      System.out.print(x.getNum() + " ");
      System.out.print(x.getId() + " ");
      System.out.print(x.getPw() + " ");
      System.out.print(x.getName() + " ");
      System.out.println(x.getTel());
    }
  }

}

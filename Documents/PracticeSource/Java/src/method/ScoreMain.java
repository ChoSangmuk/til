package method;

public class ScoreMain {
  public static void main(String[] args) {
    ScoreDAO dao = new ScoreDAO();
    int result = 0;

    // 1. insert(ScoreVO vo):int
    ScoreVO vo = new ScoreVO();
    vo.setNum(1);
    vo.setName("kim");
    vo.setKor(100);
    vo.setEng(90);
    vo.setMath(80);
    vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
    vo.setAvg(vo.getTotal() / 3.0);
    vo.setGrade(vo.getAvg() <= 100 && vo.getAvg() >= 90 ? "A"
        : vo.getAvg() <= 89 && vo.getAvg() >= 80 ? "B" : vo.getAvg() <= 79 && vo.getAvg() >= 70 ? "C" : "F");
    result = dao.insert(vo);
    System.out.println("insert result : " + result + "\n");

    // 2. update(ScoreVO vo):int
    ScoreVO vo2 = new ScoreVO();
    vo2.setNum(11);
    vo2.setName("kim11");
    vo2.setKor(88);
    vo2.setEng(88);
    vo2.setMath(88);
    vo2.setTotal(vo2.getKor() + vo2.getEng() + vo2.getMath());
    vo2.setAvg(vo2.getTotal() / 3.0);
    vo2.setGrade(vo2.getAvg() <= 100 && vo2.getAvg() >= 90 ? "A"
        : vo2.getAvg() <= 89 && vo2.getAvg() >= 80 ? "B" : vo2.getAvg() <= 79 && vo2.getAvg() >= 70 ? "C" : "F");
    result = dao.update(vo2);
    System.out.println("update result : " + result + "\n");

    // 3. delete(ScoreVO vo):int
    ScoreVO vo3 = new ScoreVO();
    vo3.setNum(33);
    result = dao.delete(vo3);
    System.out.println("delete result :" + result + "\n");

    // 4. selectOne(ScoreVO vo):ScoreVO
    ScoreVO vo4 = new ScoreVO();
    vo4.setNum(44);
    vo4.setName("kim44");
    vo4.setKor(44);
    vo4.setEng(44);
    vo4.setMath(44);
    vo4.setTotal(vo4.getKor() + vo4.getEng() + vo4.getMath());
    vo4.setGrade(vo4.getAvg() <= 100 && vo4.getAvg() >= 90 ? "A"
        : vo4.getAvg() <= 89 && vo4.getAvg() >= 80 ? "B" : vo4.getAvg() <= 79 && vo4.getAvg() >= 70 ? "C" : "F");
    ScoreVO resultVO = dao.selectOne(vo4);
    System.out.println("selectOne result : " + resultVO);
    System.out.println(resultVO.getNum());
    System.out.println(resultVO.getName());
    System.out.println(resultVO.getKor());
    System.out.println(resultVO.getEng());
    System.out.println(resultVO.getMath());
    System.out.println(resultVO.getTotal());
    System.out.println(resultVO.getAvg());
    System.out.println(resultVO.getGrade());
    System.out.println();

    // 5. selectAll():ScoreVO[]
    ScoreVO[] resultVOs = dao.selectAll();
    System.out.println("resultVOs :" + resultVOs);
    System.out.println("resultVOs.length :" + resultVOs.length);
    System.out.println();
    System.out.println(resultVOs[0]);
    System.out.println(resultVOs[0].getNum());
    System.out.println(resultVOs[0].getName());
    System.out.println(resultVOs[0].getKor());
    System.out.println(resultVOs[0].getEng());
    System.out.println(resultVOs[0].getMath());
    System.out.println(resultVOs[0].getTotal());
    System.out.println(resultVOs[0].getAvg());
    System.out.println(resultVOs[0].getGrade());
    System.out.println();
    System.out.println(resultVOs[1]);
    System.out.println(resultVOs[1].getNum());
    System.out.println(resultVOs[1].getName());
    System.out.println(resultVOs[1].getKor());
    System.out.println(resultVOs[1].getEng());
    System.out.println(resultVOs[1].getMath());
    System.out.println(resultVOs[1].getTotal());
    System.out.println(resultVOs[1].getAvg());
    System.out.println(resultVOs[1].getGrade());
  }
}
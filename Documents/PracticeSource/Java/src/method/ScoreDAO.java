package method;

public class ScoreDAO {

  // 1.insert
  public int insert(ScoreVO vo) {
    System.out.println("insert()....");
    System.out.println(vo.getNum());
    System.out.println(vo.getName());
    System.out.println(vo.getKor());
    System.out.println(vo.getEng());
    System.out.println(vo.getMath());
    System.out.println(vo.getTotal());
    System.out.println(vo.getAvg());
    System.out.println(vo.getGrade());
    return 0;
  }

  // 2.update
  public int update(ScoreVO vo) {
    System.out.println("update()....");
    System.out.println(vo.getNum());
    System.out.println(vo.getName());
    System.out.println(vo.getKor());
    System.out.println(vo.getEng());
    System.out.println(vo.getMath());
    System.out.println(vo.getTotal());
    System.out.println(vo.getAvg());
    System.out.println(vo.getGrade());
    return 0;
  }

  // 3.delete
  public int delete(ScoreVO vo) {
    System.out.println("delete()....");
    System.out.println(vo.getNum());
    return 0;
  }

  // 4.selectOne
  public ScoreVO selectOne(ScoreVO vo) {
    System.out.println("selectOne()....");
    System.out.println(vo.getNum());
    System.out.println(vo.getName());
    System.out.println(vo.getKor());
    System.out.println(vo.getEng());
    System.out.println(vo.getMath());
    System.out.println(vo.getTotal());
    System.out.println(vo.getAvg());
    System.out.println(vo.getGrade());

    ScoreVO newVO = new ScoreVO();
    newVO.setNum(33);
    newVO.setName("kim33");
    newVO.setKor(33);
    newVO.setEng(33);
    newVO.setMath(33);
    newVO.setTotal(newVO.getKor() + newVO.getEng() + newVO.getMath());
    newVO.setAvg(newVO.getTotal() / 3.0);
    String grade = 
      newVO.getAvg() <= 100 && newVO.getAvg() >= 90 ? "A" : 
      newVO.getAvg() <= 89 && newVO.getAvg() >= 80 ? "B" : 
      newVO.getAvg() <= 79 && newVO.getAvg() >= 70 ? "C" : "F";
    newVO.setGrade(grade);
    return newVO;
  }

  // 5.selectAll
  public ScoreVO[] selectAll() {
    System.out.println("selectAll()...");
    ScoreVO[] vos = new ScoreVO[2];
    vos[0] = new ScoreVO();
    vos[0].setNum(1);
    vos[0].setName("kim");
    vos[0].setKor(100);
    vos[0].setEng(90);
    vos[0].setMath(80);
    vos[0].setTotal(vos[0].getKor() + vos[0].getEng() + vos[0].getMath());
    vos[0].setAvg(vos[0].getTotal() / 3.0);
    String grade = 
      vos[0].getAvg() <= 100 && vos[0].getAvg() >= 90 ? "A" : 
      vos[0].getAvg() <= 89 && vos[0].getAvg() >= 80 ? "B" : 
      vos[0].getAvg() <= 79 && vos[0].getAvg() >= 70 ? "C" : "F";
    vos[0].setGrade(grade);

    vos[1] = new ScoreVO();
    vos[1].setNum(77);
    vos[1].setName("kim77");
    vos[1].setKor(77);
    vos[1].setEng(77);
    vos[1].setMath(77);
    vos[1].setTotal(vos[1].getKor() + vos[1].getEng() + vos[1].getMath());
    vos[1].setAvg(vos[1].getTotal() / 3.0);
    grade = 
      vos[1].getAvg() <= 100 && vos[1].getAvg() >= 90 ? "A" : 
      vos[1].getAvg() <= 89 && vos[1].getAvg() >= 80 ? "B" : 
      vos[1].getAvg() <= 79 && vos[1].getAvg() >= 70 ? "C" : "F";
    vos[1].setGrade(grade);
    return vos;
  }
}

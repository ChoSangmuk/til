package frame;

public interface MemberDAO {
  String NAME = "kim";

  public int insert(MemberVO vo);

  public int update(MemberVO vo);

  public int delete(MemberVO vo);

  public MemberVO selectOne(MemberVO vo);

  public MemberVO[] selectAll();

}

package object;

public class BoardSave {
  Board board;
  Board[] boards;
  int[] temps;

  public BoardSave() {
  }

  public BoardSave(Board board) {
    this.board = board;
  }

  public BoardSave(Board[] boards) {
    this.boards = boards;
  }

  public int sum() {
    int result = 0;
    for (int temp : temps)
      result += temp;
    return result;
  }
}

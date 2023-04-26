package object;

public class BoardMain {

  public static void main(String[] args) {
    BoardSave boardSave1 = new BoardSave();
    boardSave1.temps = new int[] { 11, 22, 33, 44, 55, 66 };
    int sumTemps = 0;
    for (int temp : boardSave1.temps)
      sumTemps += temp;
    System.out.println("sumTemps " + sumTemps + ", boardSave1.sum() " + boardSave1.sum());
    System.out.println();

    Board board = new Board();
    board.num = 1;
    board.title = "java";
    board.content = "object study";
    board.name = "kim";

    Board[] boards = { board };
    BoardSave boardSave2 = new BoardSave(boards);
    System.out.println("boardSave2.boards[0] " + boardSave2.boards[0] + ", board " + board);
    System.out.println();

    System.out.println(boardSave2.boards[0]);
    System.out.println(boardSave2.boards[0].num);
    System.out.println(boardSave2.boards[0].title);
    System.out.println(boardSave2.boards[0].content);
    System.out.println(boardSave2.boards[0].name);
    System.out.println();

    boardSave2.boards[0].num = 2;
    boardSave2.boards[0].title = "javaScript";
    boardSave2.boards[0].content = "object study22";
    boardSave2.boards[0].name = "Cho";
    System.out.println("board " + board);
    System.out.println("board.num " + board.num);
    System.out.println("board.title " + board.title);
    System.out.println("board.content " + board.content);
    System.out.println("board.name " + board.name);
  }
}

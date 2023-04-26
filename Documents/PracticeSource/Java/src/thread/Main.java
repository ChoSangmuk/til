package thread;

public class Main {

  public static void main(String[] args) {
    System.out.println("start Thread~~~Runnable");

    // 1.Thread
    Thread t1 = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++)
          System.out.println("Main run " + i);
      }
    };
    t1.start();

    // 2.extends Thread
    ThreadEx t2 = new ThreadEx();
    t2.start();

    // 3.implements Runnable
    new Thread(new RunnableImpl()).start();

    System.out.println("end Thread~~~Runnable");
  }

}

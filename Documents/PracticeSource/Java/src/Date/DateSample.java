import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateSample {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    System.out.println("\nSystem.currentTimeMillis() = " + startTime);
    System.out.println("new java.util.Date() = " + new java.util.Date());
    System.out.println("new java.sql.Date(System.currentTimeMillis()) = " + new java.sql.Date(System.currentTimeMillis()));
    System.out.println("new Timestamp(System.currentTimeMillis()) = " + new Timestamp(System.currentTimeMillis()).getTime());

    Calendar calendar = Calendar.getInstance();
    System.out.println("\nCalendar");
    System.out.println("calendar.get(Calendar.YEAR) = " + calendar.get(Calendar.YEAR));
    System.out.println("calendar.get(Calendar.MONTH) + 1 = " + (calendar.get(Calendar.MONTH) + 1));
    System.out.println("calendar.get(Calendar.DAY_OF_MONTH) = " + calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println("calendar.get(Calendar.AM) = " + calendar.get(Calendar.AM));
    System.out.println("calendar.get(Calendar.DAY_OF_WEEK) = " + calendar.get(Calendar.DAY_OF_WEEK));
    System.out.println("calendar.get(Calendar.HOUR_OF_DAY) = " + calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("calendar.get(Calendar.MINUTE) = " + calendar.get(Calendar.MINUTE));
    System.out.println("calendar.get(Calendar.SECOND) = " + calendar.get(Calendar.SECOND));

    GregorianCalendar gCalendar = new GregorianCalendar(2018, 12, 25, 10, 15, 40);
    System.out.println("\nGregorianCalendar");
    System.out.println("gCalendar.get(Calendar.YEAR) = " + gCalendar.get(Calendar.YEAR));
    System.out.println("gCalendar.get(Calendar.MONTH) + 1 = " + (gCalendar.get(Calendar.MONTH) + 1));
    System.out.println("gCalendar.get(Calendar.DAY_OF_MONTH) = " + gCalendar.get(Calendar.DAY_OF_MONTH));
    System.out.println("gCalendar.get(Calendar.AM) = " + gCalendar.get(Calendar.AM));
    System.out.println("gCalendar.get(Calendar.DAY_OF_WEEK) = " + gCalendar.get(Calendar.DAY_OF_WEEK));
    System.out.println("gCalendar.get(Calendar.HOUR_OF_DAY) = " + gCalendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("gCalendar.get(Calendar.MINUTE) = " + gCalendar.get(Calendar.MINUTE));
    System.out.println("gCalendar.get(Calendar.SECOND) = " + gCalendar.get(Calendar.SECOND));

    System.out.println("\nSimpleDateFormat");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    System.out.println(new Date());
    System.out.println(sdf.format(new Date()));

    System.out.println("\nSystem.currentTimeMillis() - startTime = " + (System.currentTimeMillis() - startTime));
  }
}
import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {

    var dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    executor.scheduleAtFixedRate(() -> {
      System.out.println(ZonedDateTime.now().format(dtf) + " Generating report...");
    }, 0, 10, TimeUnit.SECONDS);

    try {
      Thread.sleep(11000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();
    }

    try {
      if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
        executor.shutdownNow();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

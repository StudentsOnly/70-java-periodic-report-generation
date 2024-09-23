import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ReportGenerator {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        ReportTask reportTask = new ReportTask();

        scheduler.scheduleAtFixedRate(reportTask, 0, 10, TimeUnit.SECONDS);

        try {
            Thread.sleep(60000); //1 minute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();

        try {
            scheduler.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.println("Report generation stopped.");

    }
}


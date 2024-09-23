import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable report = new Runnable() {
            @Override
            public void run() {
                System.out.println("Generating report");
                System.out.printf("New Report:\n\tTime: %s\n", LocalTime.now());
            }
        };

        service.scheduleAtFixedRate(report, 0, 10, TimeUnit.SECONDS);

        /*
        Waiting 21 second for 3 reports and then terminate shutdown program
         */
        try {
            service.awaitTermination(21, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        service.shutdown();
    }
}


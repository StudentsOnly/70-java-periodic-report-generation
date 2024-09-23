import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class ReportTask implements Runnable {
    @Override
    public void run() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String report = generateReport();
        System.out.println("Generating report... " + timestamp);
        System.out.println(report);
    }

    // Simulate report generation with random data
    private String generateReport() {
       Random random = new Random();

        String[] metrics = {"Online Sales", "Offline Sales", "Visitors"};
        StringBuilder reportBuilder = new StringBuilder();

        reportBuilder.append("Report Summary:\n");
        for (String metric : metrics) {
            int value = random.nextInt(100); // Random value for each metric
            reportBuilder.append(metric).append(": ").append(value).append("\n");
        }

        return reportBuilder.toString();
    }
}
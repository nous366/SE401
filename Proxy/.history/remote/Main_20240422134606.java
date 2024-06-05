interface ReportGenerator {
    void generateReport();
}
class RemoteReportGenerator implements ReportGenerator {
    public void generateReport() {
        System.out.println("Report generated remotely.");
    }
}
class ReportGeneratorProxy implements ReportGenerator {
    private ReportGenerator reportGenerator;

    public ReportGeneratorProxy() {
        
        this.reportGenerator = new RemoteReportGenerator(); 
    }

    public void generateReport() {
        System.out.println("Proxy in action. Now calling the remote method...");
        reportGenerator.generateReport();
    }
}
public class Main {
    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGeneratorProxy();
        reportGenerator.generateReport();  // Gọi dịch vụ từ xa thông qua proxy
    }
}

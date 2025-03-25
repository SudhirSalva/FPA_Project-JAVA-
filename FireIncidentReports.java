package fpatips;

public class FireIncidentReports {
    public void stringBufferOperations(String incident) {
        StringBuffer report = new StringBuffer(incident);
        System.out.println("Original Report: " + report);

        report.append(" | Status: Under Investigation.");
        System.out.println("After Append: " + report);

        report.reverse();
        System.out.println("After Reverse: " + report);

        report.reverse();
        report.replace(0, 10, "URGENT:");
        System.out.println("After Replace: " + report);
    }
}

package fpatips;

public class FPAMain {
    public static void main(String[] args) {
        FireSafetyTips safetyTips = new FireSafetyTips();
        FireIncidentReports incidentReports = new FireIncidentReports();

        String tip = "Keep Fire Extinguishers Accessible And Regularly Maintained.";
        String incident = "Fire broke out at a warehouse. Estimated damage: $1M";

        System.out.println("Fire Safety Tips Operations:");
        safetyTips.stringOperations(tip);

        System.out.println("\nFire Incident Reports Operations:");
        incidentReports.stringBufferOperations(incident);
    }
}

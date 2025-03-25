package fpaExceptionalHandling;

public class FireSafety {
    public static void checkSafety(int scenario) throws FireException {
        if (scenario == 1) {
            throw new FireException("Fire detected in the kitchen! Use a fire extinguisher.");
        } else if (scenario == 2) {
            throw new FireException("Fire alarm malfunction! Check the wiring.");
        } else if (scenario == 3) {
            throw new FireException("Smoke detected! Evacuate immediately.");
        } else if (scenario == 4) {
            System.out.println("No fire hazard detected. Safe environment.");
        } else {
            throw new FireException("Invalid scenario! Choose a valid fire safety check.");
        }
    }
}





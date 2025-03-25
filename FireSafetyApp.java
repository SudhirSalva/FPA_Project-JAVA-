package fpaExceptionalHandling;

import java.util.Scanner;

public class FireSafetyApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Fire Protection Awareness System");
        System.out.println("Choose a scenario to check:");
        System.out.println("1: Kitchen Fire");
        System.out.println("2: Alarm Malfunction");
        System.out.println("3: Smoke Detection");
        System.out.println("4: Safe Environment");

        try {
            System.out.print("Enter your choice: ");
            int scenario = sc.nextInt();
            FireSafety.checkSafety(scenario);
        } catch (FireException e) {
            System.out.println("Alert: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getClass().getSimpleName());
        }

        sc.close();
    }
}

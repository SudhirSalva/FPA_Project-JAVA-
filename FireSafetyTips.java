package fpatips;

public class FireSafetyTips {
    public void stringOperations(String tip) {
        System.out.println("Fire Safety Tip: " + tip);
        System.out.println("Length of Tip: " + tip.length());
        System.out.println("Uppercase Tip: " + tip.toUpperCase());
        System.out.println("First 10 Characters: " + tip.substring(0, 10));
    }
}

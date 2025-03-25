lass FireSafetyTask implements Runnable {  
    private String taskName;
    private String threadColor;
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[32m";

    public FireSafetyTask(String taskName, String threadColor) {
        this.taskName = taskName;
        this.threadColor = threadColor;
    }

    public void run() {
        for (int i = 1; i <= 2; i++) {  
            System.out.println(threadColor + Thread.currentThread().getName() + " is performing: " + taskName + " (Thread " + i + ")" + RESET);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
        
       
        System.out.println(GREEN + Thread.currentThread().getName() + " has completed " + taskName + RESET);
    }
}

public class FireProtectionMultithreading {
    public static void main(String[] args) {
        String RED = "\033[31m";
        String BLUE = "\033[34m";
        String RESET = "\033[0m";
        String GREEN = "\033[32m";
        String ORANGE = "\033[38;5;214m";


        System.out.println("Fire Protection Awareness Multithreading Started...\n");

        FireSafetyTask alertTask = new FireSafetyTask("Sending Fire Safety Alerts", RED);
        FireSafetyTask checkTask = new FireSafetyTask("Checking Emergency Equipment", ORANGE);

        Thread thread1 = new Thread(alertTask, "Fire Alert Thread");
        Thread thread2 = new Thread(checkTask, "Equipment Check Thread");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        } 

        System.out.println(GREEN + "\nAll Fire Protection tasks are completed." + RESET);
    }
}

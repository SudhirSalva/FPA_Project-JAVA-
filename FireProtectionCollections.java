import java.util.*;

class FireSafetyTask {
    private String taskName;

    public FireSafetyTask(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}

public class FireProtectionCollections {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ORANGE = "\033[38;5;214m";
        String GREEN = "\033[32m";
        String RESET = "\033[0m";

        System.out.println("Fire Protection Awareness Program Started...\n");

        List<FireSafetyTask> taskList = new ArrayList<>();
        taskList.add(new FireSafetyTask("Inspecting Fire Extinguishers"));
        taskList.add(new FireSafetyTask("Checking Emergency Exits"));
        taskList.add(new FireSafetyTask("Conducting Fire Drills"));
        taskList.add(new FireSafetyTask("Updating Fire Safety Protocols"));

        Map<String, List<String>> teamTasks = new HashMap<>();
        teamTasks.put("A", Arrays.asList("Inspecting Fire Extinguishers", "Checking Emergency Exits"));
        teamTasks.put("B", Arrays.asList("Conducting Fire Drills", "Updating Fire Safety Protocols"));

        System.out.print("Enter team (A or B): ");
        String userInput = scanner.next().toUpperCase();

        if (teamTasks.containsKey(userInput)) {
            System.out.println(ORANGE + "Fire Safety Team " + userInput + RESET + " is assigned the following tasks:");
            for (String task : teamTasks.get(userInput)) {
                System.out.println("   - " + task);
            }
        } else {
            System.out.println("Invalid team selection. Please enter A or B.");
        }

        Queue<FireSafetyTask> taskQueue = new LinkedList<>(taskList);
        System.out.println("\nExecuting Fire Safety Tasks...\n");
        while (!taskQueue.isEmpty()) {
            FireSafetyTask task = taskQueue.poll();
            System.out.println(GREEN + "Task Completed: " + task.getTaskName() + RESET);
        }

        System.out.println(GREEN + "\nAll Fire Protection Tasks are Successfully Completed!" + RESET);
        scanner.close();
    }
}

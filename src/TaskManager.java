import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();

    // Add Task
    public void addTask(String title, String priority, String deadline, long duration) {
        Task task = new Task(title, priority, deadline, duration);
        tasks.add(task);
        System.out.println("✅ Task added!");
    }

    // View All Tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n==== TASK LIST ====");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // Mark Task as Completed
    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).isCompleted = true;
            System.out.println("✅ Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Delete Task
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("🗑 Task deleted!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Show only pending tasks
    public void showPendingTasks() {
        System.out.println("\n==== PENDING TASKS ====");
        boolean found = false;

        for (int i = 0; i < tasks.size(); i++) {
            if (!tasks.get(i).isCompleted) {
                System.out.println((i + 1) + ". " + tasks.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No pending tasks 🎉");
        }
    }
}
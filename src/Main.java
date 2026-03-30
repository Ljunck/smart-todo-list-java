import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n==== SMART TO-DO LIST ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Show Pending Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    System.out.print("Enter deadline: ");
                    String deadline = sc.nextLine();

                    System.out.print("Enter duration (in minutes): ");
                    long minutes = sc.nextLong();
                    sc.nextLine();

                    long duration = minutes * 60 * 1000; // convert to ms

                    manager.addTask(title, priority, deadline, duration);
                    break;

                case 2:
                    manager.viewTasks();
                    break;

                case 3:
                    manager.viewTasks();
                    System.out.print("Enter task number to complete: ");
                    int compIndex = sc.nextInt() - 1;
                    manager.completeTask(compIndex);
                    break;

                case 4:
                    manager.viewTasks();
                    System.out.print("Enter task number to delete: ");
                    int delIndex = sc.nextInt() - 1;
                    manager.deleteTask(delIndex);
                    break;

                case 5:
                    manager.showPendingTasks();
                    break;

                case 6:
                    System.out.println("Exiting... 👋");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

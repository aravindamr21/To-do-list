import java.util.ArrayList;
import java.util.Scanner;


class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return description + " [ " + (isCompleted ? "Completed" : "Pending") + " ]";
    }
}

class ToDoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added: " + description);
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void removeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.remove(taskIndex);
            System.out.println("Task removed: " + task.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
public class ToDoListApp {
    private static ToDoList toDoList = new ToDoList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View All Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
 

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsCompleted();
                    break;
                case 3:
                    viewAllTasks();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        toDoList.addTask(description);
    }

    private static void markTaskAsCompleted() {
        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        toDoList.markTaskAsCompleted(taskNumber - 1);
    }

    private static void viewAllTasks() {
        toDoList.displayTasks();
    }

    private static void removeTask() {
        System.out.print("Enter task number to remove: ");
        int taskNumber = scanner.nextInt();
        toDoList.removeTask(taskNumber - 1);
    }
}

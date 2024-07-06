import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Bug {
    int id;
    String summary;
    String description;
    String reproSteps;
    String expectedResult;
    String actualResult;
    String priority;
    String severity;
    String status;
    String assignee;
    String dueDate;
    List<String> tags;

    public Bug(int id, String summary, String description, String reproSteps, String expectedResult, String actualResult, String priority, String severity, String status, String assignee, String dueDate, List<String> tags) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.reproSteps = reproSteps;
        this.expectedResult = expectedResult;
        this.actualResult = actualResult;
        this.priority = priority;
        this.severity = severity;
        this.status = status;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.tags = tags;
    }
}

public class BugTracker {
    private List<Bug> bugs;
    private int nextId;

    public BugTracker() {
        bugs = new ArrayList<>();
        nextId = 1;
    }

    public void addBug(String summary, String description, String reproSteps, String expectedResult, String actualResult, String priority, String severity, String status, String assignee, String dueDate, List<String> tags) {
        Bug bug = new Bug(nextId, summary, description, reproSteps, expectedResult, actualResult, priority, severity, status, assignee, dueDate, tags);
        bugs.add(bug);
        System.out.println("Bug added with ID: " + nextId);
        nextId++;
    }

    public void removeBug(int id) {
        boolean removed = false;
        for (int i = 0; i < bugs.size(); i++) {
            if (bugs.get(i).id == id) {
                bugs.remove(i);
                System.out.println("Bug with ID " + id + " removed.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Bug with ID " + id + " not found.");
        }
    }

    public Bug getBug(int id) {
        for (Bug bug : bugs) {
            if (bug.id == id) {
                return bug;
            }
        }
        return null;
    }

    public void updateBug(int id, String summary, String description, String reproSteps, String expectedResult, String actualResult, String priority, String severity, String status, String assignee, String dueDate, List<String> tags) {
        boolean updated = false;
        for (Bug bug : bugs) {
            if (bug.id == id) {
                bug.summary = summary;
                bug.description = description;
                bug.reproSteps = reproSteps;
                bug.expectedResult = expectedResult;
                bug.actualResult = actualResult;
                bug.priority = priority;
                bug.severity = severity;
                bug.status = status;
                bug.assignee = assignee;
                bug.dueDate = dueDate;
                bug.tags = tags;
                System.out.println("Bug with ID " + id + " updated.");
                updated = true;
                break;
            }
        }
        if (!updated) {
            System.out.println("Bug with ID " + id + " not found.");
        }
    }

    public void displayBugs() {
        if (bugs.isEmpty()) {
            System.out.println("No bugs found.");
        } else {
            for (Bug bug : bugs) {
                System.out.println("ID: " + bug.id); // Added bug ID to the output
                System.out.println("Summary: " + bug.summary);
                System.out.println("Description: " + bug.description);
                System.out.println("Repro Steps: " + bug.reproSteps);
                System.out.println("Expected Result: " + bug.expectedResult);
                System.out.println("Actual Result: " + bug.actualResult);
                System.out.println("Priority: " + bug.priority);
                System.out.println("Severity: " + bug.severity);
                System.out.println("Status: " + bug.status);
                System.out.println("Assignee: " + bug.assignee);
                System.out.println("Due Date: " + bug.dueDate);
                System.out.println("Tags: " + String.join(", ", bug.tags));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        BugTracker bugTracker = new BugTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add bug");
            System.out.println("2. Remove bug");
            System.out.println("3. Update bug");
            System.out.println("4. Display bugs");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int option;
            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline character after reading integer input
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Enter summary: ");
                    String summary = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter repro steps: ");
                    String reproSteps = scanner.nextLine();
                    System.out.print("Enter expected result: ");
                    String expectedResult = scanner.nextLine();
                    System.out.print("Enter actual result: ");
                    String actualResult = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter severity: ");
                    String severity = scanner.nextLine();
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    System.out.print("Enter assignee: ");
                    String assignee = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Enter tags (comma separated): ");
                    String tagsStr = scanner.nextLine();
                    List<String> tags = Arrays.asList(tagsStr.split("\\s*,\\s*"));
                    bugTracker.addBug(summary, description, reproSteps, expectedResult, actualResult, priority, severity, status, assignee, dueDate, tags);
                    break;
                case 2:
                    System.out.print("Enter bug ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after reading integer input
                    bugTracker.removeBug(idToRemove);
                    break;
                case 3:
                    System.out.print("Enter bug ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after reading integer input
                    Bug bugToUpdate = bugTracker.getBug(idToUpdate);
                    if (bugToUpdate != null) {
                        System.out.print("Enter new summary: ");
                        String newSummary = scanner.nextLine();
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter new repro steps: ");
                        String newReproSteps = scanner.nextLine();
                        System.out.print("Enter new expected result: ");
                        String newExpectedResult = scanner.nextLine();
                        System.out.print("Enter new actual result: ");
                        String newActualResult = scanner.nextLine();
                        System.out.print("Enter new priority: ");
                        String newPriority = scanner.nextLine();
                        System.out.print("Enter new severity: ");
                        String newSeverity = scanner.nextLine();
                        System.out.print("Enter new status: ");
                        String newStatus = scanner.nextLine();
                        System.out.print("Enter new assignee: ");
                        String newAssignee = scanner.nextLine();
                        System.out.print("Enter new due date: ");
                        String newDueDate = scanner.nextLine();
                        System.out.print("Enter new tags (comma separated): ");
                        String newTagsStr = scanner.nextLine();
                        List<String> newTags = Arrays.asList(newTagsStr.split("\\s*,\\s*"));
                        bugTracker.updateBug(idToUpdate, newSummary, newDescription, newReproSteps, newExpectedResult, newActualResult, newPriority, newSeverity, newStatus, newAssignee, newDueDate, newTags);
                    } else {
                        System.out.println("Bug not found");
                    }
                    break;
                case 4:
                    bugTracker.displayBugs();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
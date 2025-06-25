// StudentManagement.java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("--- Student List ---");
            for (Student s : students) {
                s.display();
            }
        }
    }

   private static void updateStudent() {
    System.out.print("Enter student ID to update: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // clear the input buffer
    boolean found = false;

    for (Student s : students) {
        if (s.getId() == id) {
            found = true;
            System.out.println("What do you want to update?");
            System.out.println("1. Name");
            System.out.println("2. Marks");
            System.out.println("3. Both");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // clear buffer again

            switch (option) {
                case 1:
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    s.setName(newName);
                    System.out.println("Name updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    s.setMarks(newMarks);
                    System.out.println("Marks updated successfully.");
                    break;

                case 3:
                    System.out.print("Enter new name: ");
                    String bothName = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    double bothMarks = scanner.nextDouble();
                    s.setName(bothName);
                    s.setMarks(bothMarks);
                    System.out.println("Name and marks updated successfully.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
            break; // exit the loop once student is updated
        }
    }

    if (!found) {
        System.out.println("Student not found.");
    }
}


    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}

package app;

import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1": addStudent(); break;
                    case "2": listStudents(); break;
                    case "3": deleteStudent(); break;
                    case "4": findStudent(); break;
                    case "5": System.out.println("Goodbye!"); return;
                    default: System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- College Management System ---");
        System.out.println("1) Add Student");
        System.out.println("2) List Students");
        System.out.println("3) Delete Student by ID");
        System.out.println("4) Find Student by Roll No");
        System.out.println("5) Exit");
        System.out.print("Enter choice: ");
    }

    private static void addStudent() throws Exception {
        System.out.print("Roll No: ");
        String roll = sc.nextLine().trim();

        System.out.print("Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        Student s = new Student(roll, name, age, email);
        studentDAO.add(s);

        System.out.println("Added Successfully: " + s);
    }

    private static void listStudents() throws Exception {
        List<Student> students = studentDAO.listAll();
        if (students.isEmpty()) System.out.println("No students found.");
        else students.forEach(System.out::println);
    }

    private static void deleteStudent() throws Exception {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        boolean removed = studentDAO.deleteById(id);

        System.out.println(removed ? "Deleted successfully." : "ID not found.");
    }

    private static void findStudent() throws Exception {
        System.out.print("Enter Roll No: ");
        String roll = sc.nextLine().trim();

        Student s = studentDAO.findByRoll(roll);
        System.out.println(s == null ? "Student not found." : s);
    }
}

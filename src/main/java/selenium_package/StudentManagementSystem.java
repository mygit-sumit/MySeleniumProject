package selenium_package;
import java.util.Scanner;

class Student {
    // Attributes of the Student class /Student Management System
    String firstName;
    String lastName;
    String studentID;
    String email;
    String[] courses; // Array to store course names

    // Constructor to initialize the student object
    public Student(String firstName, String lastName, String studentID, String email, String[] courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.email = email;
        this.courses = courses;
    }

    // Getter methods to access the attributes

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getEmail() {
        return email;
    }

    public String[] getCourses() {
        return courses;
    }

    // Method to display student information
    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.print("Courses Enrolled: ");
        for (int i = 0; i < courses.length; i++) {
            System.out.print(courses[i]);
            if (i < courses.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // New line after courses
        System.out.println("---------------------------");
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user how many students to store
        System.out.print("Enter the number of students you want to store: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Create an array to store Student objects
        Student[] students = new Student[numberOfStudents];

        // Loop to input student information
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter details for student #" + (i + 1));

            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Student ID: ");
            String studentID = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            // Ask how many courses the student is enrolled in
            System.out.print("How many courses is the student enrolled in? ");
            int numberOfCourses = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Create an array to store course names
            String[] courses = new String[numberOfCourses];

            // Input course names
            for (int j = 0; j < numberOfCourses; j++) {
                System.out.print("Enter course #" + (j + 1) + ": ");
                courses[j] = scanner.nextLine();
            }

            // Create a new Student object and add it to the array
            students[i] = new Student(firstName, lastName, studentID, email, courses);

            System.out.println(); // Blank line for readability
        }

        // Display all students
        System.out.println("All students information:");
        displayAllStudents(students);

        // Search for a student by student ID
        System.out.print("Enter a student ID to search: ");
        String searchID = scanner.nextLine();

        Student foundStudent = findStudentByID(students, searchID);

        if (foundStudent != null) {
            System.out.println("Student found:");
            foundStudent.displayInfo();
        } else {
            System.out.println("Student with ID " + searchID + " not found.");
        }

        scanner.close();
    }

    // Method to display information of all students
    public static void displayAllStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            students[i].displayInfo();
        }
    }

    // Method to find a student by their student ID
    public static Student findStudentByID(Student[] students, String studentID) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentID().equals(studentID)) {
                return students[i]; // Return the student object if found
            }
        }
        return null; // Return null if not found
    }
}

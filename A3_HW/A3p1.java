import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    char sex;
    int age;

    Student(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}

public class A3p1 {
    public static void main(String[] args) {
        // Check if the number of students is provided as a command line argument
        if (args.length < 1) {
            System.out.println("Please provide the number of students as a command line argument.");
            return;
        }

        // Get the number of students from the command line argument
        int numStudents = Integer.parseInt(args[0]);

        // Create a list to store the students
        List<Student> students = new ArrayList<>();

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter information for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter information for student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Sex('F' or 'M'): ");
            char sex = scanner.nextLine().charAt(0);
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println();

            // Create a new Student object and add it to the list
            students.add(new Student(name, sex, age));
        }

        // Display the information of the entered students
        System.out.println("The students you entered are:");
        for (Student student : students) {
            System.out.println(student.name + " is a " + (student.sex == 'F' ? "female" : "male") +
                    " student of age " + student.age + ".");
        }

        // Find the oldest female students and youngest male students
        int minMaleAge = Integer.MAX_VALUE;
        int maxFemaleAge = Integer.MIN_VALUE;
        List<String> youngestMales = new ArrayList<>();
        List<String> oldestFemales = new ArrayList<>();

        for (Student student : students) {
            if (student.sex == 'M' && student.age < minMaleAge) {
                // Update the minimum male age and clear the previous list of youngest males
                minMaleAge = student.age;
                youngestMales.clear();
                youngestMales.add(student.name + " (age " + student.age + ")");
            } else if (student.sex == 'F' && student.age > maxFemaleAge) {
                // Update the maximum female age and clear the previous list of oldest females
                maxFemaleAge = student.age;
                oldestFemales.clear();
                oldestFemales.add(student.name + " (age " + student.age + ")");
            } else if (student.sex == 'M' && student.age == minMaleAge) {
                // Add the student to the list of youngest males (ties)
                youngestMales.add(student.name + " (age " + student.age + ")");
            } else if (student.sex == 'F' && student.age == maxFemaleAge) {
                // Add the student to the list of oldest females (ties)
                oldestFemales.add(student.name + " (age " + student.age + ")");
            }
        }

        // Display the oldest female students
        System.out.println("\nThe oldest female students are:");
        for (String name : oldestFemales) {
            System.out.println(name + ".");
        }

        // Display the youngest male students
        System.out.println("\nThe youngest male students are:");
        for (String name : youngestMales) {
            System.out.println(name + ".");
        }
    }
}


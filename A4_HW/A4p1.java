import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private String sex;
    private int age;
    private String type;

    public Person(String name, String sex, int age, String type) {
        this.name = name;
        this.sex = ((sex.equals("M")) ? "male" : (sex.equals("F")) ? "female" : "n/a");
        this.age = age;
        this.type = type;
    }

    @Override
    public String toString() {
	return name + " is a " + sex + " " + type + " of " + age + " years old";
    }
}

class Singer extends Person {
    private String favorite;

    public Singer(String name, String sex, int age, String type, String favorite) {
        super(name, sex, age, type);
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return super.toString() + " with favorite song " + favorite + ".";
    }
}

class Dancer extends Person {
    private String favorite;

    public Dancer(String name, String sex, int age, String type, String favorite) {
        super(name, sex, age, type);
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return super.toString() + " with favorite dance " + favorite + ".";
    }
}

public class A4p1 {
    public static void main(String[] args) {
        // Check if the number of persons is provided as a command line argument
        if (args.length < 1) {
            System.out.println("Please provide the number of persons as a command line argument.");
            return;
        }

        // Get the number of persons from the command line argument
        int numPersons = Integer.parseInt(args[0]);

        // Create a list to store the persons
        List<Person> persons = new ArrayList<>();

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter information for each person
        for (int i = 0; i < numPersons; i++) {
	    System.out.println("Enter information for person " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Sex('F' or 'M'): ");
            String sex = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Singer or Dancer('S' or 'D'): ");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("S")) {
		type = "singer";
                System.out.print("Favorite song: ");
                String favoriteSong = scanner.nextLine();
                persons.add(new Singer(name, sex, age, type, favoriteSong));
            } else if (type.equalsIgnoreCase("D")) {
		type = "dancer";
                System.out.print("Favorite dance: ");
                String favoriteDance = scanner.nextLine();
                persons.add(new Dancer(name, sex, age, type, favoriteDance));
            }
            System.out.println();
        }

        // Display the information of the entered persons
        System.out.println("The persons you entered are:");
        for (Person person : persons) {
            if (person != null) {
                System.out.println(person.toString());
            }
        }
    }
}

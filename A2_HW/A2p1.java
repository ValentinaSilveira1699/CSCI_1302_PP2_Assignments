import java.util.Scanner;

public class A2p1 {
    public static void main(String[] args) {
        // Check if a command-line argument is provided
        if (args.length < 1) {
            System.out.println("Please provide a positive integer as a command-line argument.");
            return;
        }

        // Parse the command-line argument as an integer
        int n = Integer.parseInt(args[0]);

        // Create an array to store the strings
        String[] strings = new String[n];

        // Read the strings from stdin
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        scanner.close();

        // Find the longest and shortest strings
        String[] longestStrings = findLongestStrings(strings);
        String[] shortestStrings = findShortestStrings(strings);

        // Print the results
        System.out.println("The longest input strings are:");
        for (String s : longestStrings) {
            System.out.println(s);
        }
        System.out.println("The shortest input strings are:");
        for (String s : shortestStrings) {
            System.out.println(s);
        }
    }

    // Method to find the longest strings in an array
    public static String[] findLongestStrings(String[] arr) {
        int maxLength = 0;
        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        int count = 0;
        for (String s : arr) {
            if (s.length() == maxLength) {
                count++;
            }
        }

        String[] longestStrings = new String[count];
        int index = 0;
        for (String s : arr) {
            if (s.length() == maxLength) {
                longestStrings[index++] = s;
            }
        }

        return longestStrings;
    }

    // Method to find the shortest strings in an array
    public static String[] findShortestStrings(String[] arr) {
        int minLength = Integer.MAX_VALUE;
        for (String s : arr) {
            if (s.length() < minLength) {
                minLength = s.length();
            }
        }

        int count = 0;
        for (String s : arr) {
            if (s.length() == minLength) {
                count++;
            }
        }

        String[] shortestStrings = new String[count];
        int index = 0;
        for (String s : arr) {
            if (s.length() == minLength) {
                shortestStrings[index++] = s;
            }
        }

        return shortestStrings;
    }
}

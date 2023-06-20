import java.util.Scanner;

public class A1p2 {
    public static void main(String[] args) {
        // Check if a command-line argument is provided
        if (args.length < 1) {
            System.out.println("Please provide a positive integer as a command-line argument.");
            return;
        }

        // Parse the command-line argument as an integer
        int n = Integer.parseInt(args[0]);

        // Create an array to store the integers
        int[] numbers = new int[n];

        // Read the integers from stdin
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        // Find the largest odd and smallest even integers
        int largestOdd = findLargestOdd(numbers);
        int smallestEven = findSmallestEven(numbers);

        // Print the results
        System.out.println("The largest odd input integer is " + largestOdd + ".");
        System.out.println("The smallest even input integer is " + smallestEven + ".");
    }

    // Method to find the largest odd integer in an array
    public static int findLargestOdd(int[] arr) {
        int largestOdd = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] > largestOdd) {
                largestOdd = arr[i];
            }
        }
        return largestOdd;
    }

    // Method to find the smallest even integer in an array
    public static int findSmallestEven(int[] arr) {
        int smallestEven = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] < smallestEven) {
                smallestEven = arr[i];
            }
        }
        return smallestEven;
    }
}


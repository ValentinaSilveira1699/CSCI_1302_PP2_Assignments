import java.util.Scanner;

public class A1p1 {
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

        // Print the original integers in the array
        System.out.println("The original integers are:");
        printArray(numbers);

        // Update the array to store the triples in reverse order
        updateArray(numbers);

        // Print the triples in the array
        System.out.println("The triples in reverse order are:");
        printArray(numbers);
    }

    // Method to print an array of integers
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    // Method to update the array to store the triples in reverse order
    public static void updateArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 3;
        }
        reverseArray(arr);
    }

    // Method to reverse the elements in an array
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}


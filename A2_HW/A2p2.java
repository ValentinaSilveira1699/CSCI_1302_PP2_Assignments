import java.util.Scanner;

public class A2p2 {
    public static void main(String[] args) {
        // Check if a command-line argument is provided
        if (args.length < 1) {
            System.out.println("Please provide a positive integer as a command-line argument.");
            return;
        }

        // Parse the command-line argument as an integer
        int n = Integer.parseInt(args[0]);

        // Create an array to store the integers
        int[] integers = new int[n];

        // Read the integers from stdin
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            integers[i] = scanner.nextInt();
        }
        scanner.close();

        // Print the original integers
        System.out.println("The original integers are:");
        printIntArray(integers);

        // Reverse the triplets in the array
        reverseTriplets(integers);

        // Print the updated integers
        System.out.println("The triplets reversed integers are:");
        printIntArray(integers);
    }


    // Method to print an array of integers
    public static void printIntArray(int[] arr) {
	  StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
    
    // Method to reverse the triplets in the array
    public static void reverseTriplets(int[] arr) {
        for (int i = 0; i < arr.length - 2; i += 3) {
            int temp = arr[i];
            arr[i] = arr[i + 2];
            arr[i + 2] = temp;
            
        }
    }
}


import java.util.HashMap;
import java.util.Scanner;

public class studentmap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Add entries to the HashMap
        for (int i = 0; i < count; i++) {
            System.out.print("Enter student ID for student " + (i + 1) + ": ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            studentMap.put(id, name);
        }

        // Retrieve by ID
        System.out.print("\nEnter a student ID to look up the name: ");
        int searchId = scanner.nextInt();

        if (studentMap.containsKey(searchId)) {
            System.out.println("Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class studentlist {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            studentNames.add(name);
        }

        System.out.println("\nList of Students:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}

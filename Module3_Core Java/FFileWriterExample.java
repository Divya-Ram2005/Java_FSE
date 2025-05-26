import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FFileWriterExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a string to write to the file: ");
        String userInput = scanner.nextLine();

        // Try writing to the file
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(userInput);
            writer.close();  // Close the writer
            System.out.println("Data has been successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();  // Close the scanner
    }
}

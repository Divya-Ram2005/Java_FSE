import java.sql.*;
import java.util.Scanner;

public class StudentDAO {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/divya";
        final String USER = "root";
        final String PASSWORD = "Gowri@3659";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            // ===== INSERT NEW STUDENT =====
            System.out.println("Insert New Student:");
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume leftover newline
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter department: ");
            String department = scanner.nextLine();

            String insertSQL = "INSERT INTO students (student_id, name, department) VALUES (?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                insertStmt.setInt(1, id);
                insertStmt.setString(2, name);
                insertStmt.setString(3, department);

                int rowsInserted = insertStmt.executeUpdate();
                System.out.println(rowsInserted > 0 ? "Insert successful!" : "Insert failed.");
            }

            // ===== UPDATE STUDENT NAME BY ID =====
            System.out.print("\nDo you want to update a student name? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.print("Enter student ID to update: ");
                int updateId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();

                String updateSQL = "UPDATE students SET name = ? WHERE student_id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
                    updateStmt.setString(1, newName);
                    updateStmt.setInt(2, updateId);

                    int rowsUpdated = updateStmt.executeUpdate();
                    System.out.println(rowsUpdated > 0 ? "Update successful!" : "No student found with that ID.");
                }
            }

            // ===== DISPLAY ALL STUDENTS =====
            System.out.println("\nCurrent Student Records:");
            String selectSQL = "SELECT * FROM students";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {

                while (rs.next()) {
                    System.out.println(
                        rs.getInt("student_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("department")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.*;

public class Basicjdbcconnection {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/divya"; // Change if your DB name is different
        final String USER = "root";
        final String PASSWORD = "Gowri@3659";

        try {
            // Load JDBC driver (optional for modern versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = connection.createStatement();

            // Create the students table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT, " +
                    "department VARCHAR(50), " +
                    "admission_date DATE)";
            stmt.executeUpdate(createTableSQL);

            // Insert data (insert or update if already exists)
            String insertSQL = "INSERT INTO students (student_id, name, age, department, admission_date) VALUES " +
                    "(101, 'Divya', 20, 'CSE', '2023-08-01'), " +
                    "(102, 'Abi', 21, 'ECE', '2022-06-15'), " +
                    "(103, 'Priya', 22, 'IT', '2021-07-10') " +
                    "ON DUPLICATE KEY UPDATE " +
                    "name = VALUES(name), age = VALUES(age), " +
                    "department = VALUES(department), admission_date = VALUES(admission_date)";
            stmt.executeUpdate(insertSQL);

            // Retrieve and display the data
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM students");

            System.out.println("Student Records:");
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String department = resultSet.getString("department");
                Date admissionDate = resultSet.getDate("admission_date");

                System.out.println(id + " | " + name + " | " + age + " | " + department + " | " + admissionDate);
            }

            // Close everything
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.sql.*;

public class TransactionExample {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/divya";
    private static final String USER = "root";
    private static final String PASSWORD = "Gowri@3659";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Step 1: Create accounts table if it does not exist
            createAccountsTable(conn);

            // Step 2: Insert sample data if table is empty
            insertSampleDataIfEmpty(conn);

            // Step 3: Perform money transfer: debit from account 1 and credit to account 2
            transferMoney(conn, 1, 2, 200.00);

            // Step 4: Display account balances after transfer
            printAccountBalances(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createAccountsTable(Connection conn) throws SQLException {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS accounts (
                account_id INT PRIMARY KEY,
                holder_name VARCHAR(100),
                balance DECIMAL(15,2)
            )
            """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Checked/Created accounts table.");
        }
    }

    private static void insertSampleDataIfEmpty(Connection conn) throws SQLException {
        String countSQL = "SELECT COUNT(*) FROM accounts";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(countSQL)) {
            rs.next();
            int count = rs.getInt(1);
            if (count == 0) {
                String insertSQL = """
                    INSERT INTO accounts (account_id, holder_name, balance) VALUES
                    (1, 'Alice', 1000.00),
                    (2, 'Bob', 500.00)
                    """;
                stmt.executeUpdate(insertSQL);
                System.out.println("Inserted sample data into accounts.");
            } else {
                System.out.println("Accounts table already has data.");
            }
        }
    }

    private static void transferMoney(Connection conn, int fromAccountId, int toAccountId, double amount) throws SQLException {
        try {
            conn.setAutoCommit(false); // Start transaction

            // Check balance of fromAccount
            double fromBalance = getBalance(conn, fromAccountId);
            if (fromBalance < amount) {
                throw new SQLException("Insufficient balance in account " + fromAccountId);
            }

            // Debit from fromAccount
            String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                debitStmt.executeUpdate();
            }

            // Credit to toAccount
            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                creditStmt.executeUpdate();
            }

            conn.commit();
            System.out.println("Transferred $" + amount + " from account " + fromAccountId + " to account " + toAccountId);

        } catch (SQLException e) {
            conn.rollback();
            System.err.println("Transfer failed. Transaction rolled back.");
            throw e;
        } finally {
            conn.setAutoCommit(true); // Restore default auto-commit behavior
        }
    }

    private static double getBalance(Connection conn, int accountId) throws SQLException {
        String balanceSQL = "SELECT balance FROM accounts WHERE account_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(balanceSQL)) {
            stmt.setInt(1, accountId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("balance");
                } else {
                    throw new SQLException("Account " + accountId + " not found.");
                }
            }
        }
    }

    private static void printAccountBalances(Connection conn) throws SQLException {
        String query = "SELECT * FROM accounts";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Account Balances:");
            while (rs.next()) {
                int id = rs.getInt("account_id");
                String name = rs.getString("holder_name");
                double balance = rs.getDouble("balance");
                System.out.println(id + " | " + name + " | $" + balance);
            }
        }
    }
}

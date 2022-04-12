package transactional;

import java.sql.*;

/**
 * По дефолту PostgreSQL использует Read Commited транзакцию. Поэтому проблему ReadUncomitted не показать.
 */

public class ReadCommited {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws SQLException, InterruptedException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = connection.createStatement()) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            stmt.execute("update pupils set name = 'other' where id = 1");
            new OtherTransactional().start();
            Thread.sleep(2000);
            connection.rollback();
        }
    }

    static class OtherTransactional extends Thread {
        @Override
        public void run() {
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 Statement stmt = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                ResultSet resultSet = stmt.executeQuery("select * from pupils");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



package transactional;

import java.sql.*;

/**
 * Демонстрация повторного чтения. Для фикса использовать Repeatable_READ Транзакцию
 */

public class RepeateableRead {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws SQLException, InterruptedException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = connection.createStatement()) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ResultSet resultSet = stmt.executeQuery("select * from pupils");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            new OtherTransactional().start();
            Thread.sleep(2000);

            ResultSet resultSet2 = stmt.executeQuery("select * from pupils");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("name"));
            }
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
                stmt.executeUpdate("update pupils set name = 'other' where id = 1");
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

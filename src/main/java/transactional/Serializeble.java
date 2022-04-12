package transactional;

import java.sql.*;

/**
 * Демонстрация фантомного чтения. Для фикса использовать Serializeble Транзакцию
 */

public class Serializeble {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws SQLException, InterruptedException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = connection.createStatement()) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            ResultSet resultSet = stmt.executeQuery("select count(*) from pupils");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }

            new OtherTransactional().start();
            Thread.sleep(2000);

            ResultSet resultSet2 = stmt.executeQuery("select count(*) from pupils");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt(1));
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
                connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                stmt.executeUpdate("insert into pupils(id, name) values (5, 'Other')");
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

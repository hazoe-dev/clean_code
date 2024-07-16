package org.example.proxyJDBC;

// Main.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Establishing connection
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            connection.createStatement().execute("CREATE TABLE users (id BIGINT PRIMARY KEY, name VARCHAR(255))");

            // Create DAO and proxy
            UserDao userDao = new UserDaoImpl(connection);
            UserDao proxyUserDao = LoggingTransactionProxy.createProxy(userDao, connection, UserDao.class);

            // Use the proxy to interact with the database
            User user = new User();
            user.setId(1L);
            user.setName("John Doe");
            proxyUserDao.save(user);

            User retrievedUser = proxyUserDao.findById(1L);
            System.out.println("Retrieved User: " + retrievedUser.getName());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


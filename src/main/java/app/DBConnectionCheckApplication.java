package app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionCheckApplication {

    private static final String DB_DRIVER = "org.h2.driver";
    private static final String CONNECTION_URL ="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    public static final String CREATE_TABLE_USER = "CREATE TABLE USER(Id int primary key, name varchar(255))";

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE_USER);
        connection.close();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL);
    }
}

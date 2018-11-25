package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/wap_project_db";

    static final String USER = "amjad";
    static final String PASS = "test";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connected..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
// src/main/java/util/DBUtil.java
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/baseball_quiz_db";
    private static final String USER = "postgres"; // 自分のDBユーザー名
    private static final String PASSWORD = "password"; // 自分のパスワード

    static {
        try {
            Class.forName("org.postgresql.Driver"); // PostgreSQLドライバのロード
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

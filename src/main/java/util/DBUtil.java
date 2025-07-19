// src/main/java/util/DBUtil.java
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://ep-empty-dust-a1h0gkvx-pooler.ap-southeast-1.aws.neon.tech/baseball_quiz_db?sslmode=require&channelBinding=require";
    private static final String USER = "baseballquiz_owner";
    private static final String PASSWORD = "npg_UjpnmZEq10KX";

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

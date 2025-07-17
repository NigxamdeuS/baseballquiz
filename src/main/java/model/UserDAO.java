// src/main/java/model/UserDAO.java
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

public class UserDAO {

    // ログインチェック（ユーザー名とパスワードハッシュが一致するか）
    public User findUser(String username, String passwordHash) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password_hash = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, passwordHash);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password_hash")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // 新規登録
    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (username, password_hash) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPasswordHash());
            int result = pstmt.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
 
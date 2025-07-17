// src/main/java/model/QuestionDAO.java
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class QuestionDAO {

    // 全問題を取得（例）
    public List<Question> findAll() {
        List<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM questions ORDER BY RAND() LIMIT 10"; // ランダム10問

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Question q = new Question(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("question_text"),
                    rs.getString("choice1"),
                    rs.getString("choice2"),
                    rs.getString("choice3"),
                    rs.getString("choice4"),
                    rs.getInt("correct_choice"),
                    rs.getInt("created_by")
                );
                list.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 問題登録
    public boolean insertQuestion(Question question) {
        String sql = "INSERT INTO questions "
            + "(title, question_text, choice1, choice2, choice3, choice4, correct_choice, created_by) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, question.getTitle());
            pstmt.setString(2, question.getQuestionText());
            pstmt.setString(3, question.getChoice1());
            pstmt.setString(4, question.getChoice2());
            pstmt.setString(5, question.getChoice3());
            pstmt.setString(6, question.getChoice4());
            pstmt.setInt(7, question.getCorrectChoice());
            pstmt.setInt(8, question.getCreatedBy());
            int result = pstmt.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Question findById(int id) {
        Question question = null;
        String sql = "SELECT * FROM questions WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    question = new Question(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("question_text"),
                        rs.getString("choice1"),
                        rs.getString("choice2"),
                        rs.getString("choice3"),
                        rs.getString("choice4"),
                        rs.getInt("correct_choice"),
                        rs.getInt("created_by")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return question;
    }
}

// AnswerCheckServlet.java
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import model.QuestionDAO;

public class AnswerCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // フォームから取得
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        int selectedAnswer = Integer.parseInt(request.getParameter("answer"));

        // 正解をDBから取得
        QuestionDAO dao = new QuestionDAO();
        Question question = dao.findById(questionId);

        boolean isCorrect = (question.getCorrectChoice() == selectedAnswer);

        // JSPに渡す
        request.setAttribute("question", question);
        request.setAttribute("selectedAnswer", selectedAnswer);
        request.setAttribute("isCorrect", isCorrect);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}

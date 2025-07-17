// QuizServlet.java
package controller;

import model.Question;
import model.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QuestionDAO dao = new QuestionDAO();
        List<Question> questions = dao.findAll(); // ランダム取得

        request.setAttribute("questions", questions);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
}

 // CreateQuestionServlet.java
package controller;

import model.Question;
import model.QuestionDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/createQuestion")
public class CreateQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String questionText = request.getParameter("question_text");
        String choice1 = request.getParameter("choice1");
        String choice2 = request.getParameter("choice2");
        String choice3 = request.getParameter("choice3");
        String choice4 = request.getParameter("choice4");
        int correctChoice = Integer.parseInt(request.getParameter("correct_choice"));

        // ログインユーザー取得
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        int createdBy = loginUser.getId();

        Question question = new Question(
                0, title, questionText, choice1, choice2, choice3, choice4, correctChoice, createdBy);

        QuestionDAO dao = new QuestionDAO();
        boolean result = dao.insertQuestion(question);

        if (result) {
            response.sendRedirect("mypage.jsp");
        } else {
            request.setAttribute("errorMsg", "問題の登録に失敗しました");
            request.getRequestDispatcher("create_question.jsp").forward(request, response);
        }
    }
}

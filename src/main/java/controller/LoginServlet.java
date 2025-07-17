 // LoginServlet.java
package controller;

import model.User;
import model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // フォームからの値取得
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // パスワードはハッシュ化して比較する（例としてそのまま）
        String passwordHash = password; // 本当はハッシュ化する

        UserDAO dao = new UserDAO();
        User loginUser = dao.findUser(username, passwordHash);

        if (loginUser != null) {
            // ユーザーが存在したらSessionに保存してマイページへ
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", loginUser);
            response.sendRedirect("mypage.jsp");
        } else {
            // 失敗時はエラーメッセージを設定して戻す
            request.setAttribute("errorMsg", "IDまたはパスワードが違います");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

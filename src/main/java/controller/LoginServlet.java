package controller;

import model.User;
import model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 本来はパスワードをハッシュ化するべきだが、現状は平文
        String passwordHash = password;

        UserDAO dao = new UserDAO();
        User user = dao.findUser(username, passwordHash);

        if (user != null) {
            // 認証成功
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            response.sendRedirect("mypage.jsp");
        } else {
            // 認証失敗
            request.setAttribute("errorMsg", "ユーザー名またはパスワードが違います");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GETはログイン画面へ
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
} 
 // RegisterServlet.java
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String passwordHash = password; // 本当はハッシュ化する

        User user = new User(0, username, passwordHash);

        UserDAO dao = new UserDAO();
        boolean result = dao.insertUser(user);

        if (result) {
            // 登録成功 → ログイン画面へ
            response.sendRedirect("login.jsp");
        } else {
            // 登録失敗
            request.setAttribute("errorMsg", "登録に失敗しました（ID重複など）");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
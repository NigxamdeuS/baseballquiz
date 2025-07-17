 <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ログイン - 野球クイズ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .login-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .btn {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .error {
            color: #dc3545;
            margin-bottom: 15px;
            text-align: center;
        }
        .links {
            text-align: center;
            margin-top: 20px;
        }
        .links a {
            color: #007bff;
            text-decoration: none;
        }
        .links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>⚾ ログイン</h1>

        <!-- エラーメッセージ表示 -->
        <c:if test="${not empty errorMsg}">
            <p class="error">${errorMsg}</p>
        </c:if>

        <form action="login" method="post">
            <div class="form-group">
                <label>ユーザー名:</label>
                <input type="text" name="username" required>
            </div>
            <div class="form-group">
                <label>パスワード:</label>
                <input type="password" name="password" required>
            </div>
            <button type="submit" class="btn">ログイン</button>
        </form>

        <div class="links">
            <p>新規登録は <a href="register.jsp">こちら</a></p>
            <p><a href="index.jsp">ホームに戻る</a></p>
        </div>
    </div>
</body>
</html>
 
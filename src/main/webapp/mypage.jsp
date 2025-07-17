<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>マイページ</title>
</head>
<body>
<%
    User loginUser = (User) session.getAttribute("loginUser");
    if (loginUser == null) {
%>
    <p>ログインしてください</p>
    <a href="login.jsp">ログインページへ</a>
<%
    } else {
%>
    <h1>マイページ</h1>
    <p>ようこそ ${loginUser.username} さん</p>
    <ul>
        <li><a href="quiz">問題に挑戦する</a></li>
        <li><a href="create_question.jsp">問題を作成する</a></li>
        <li><a href="logout">ログアウト</a></li>
    </ul>
<%
    }
%>
</body>
</html>

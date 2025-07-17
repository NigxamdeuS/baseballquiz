 <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>新規登録</title>
</head>
<body>
    <h1>新規登録</h1>

    <c:if test="${not empty errorMsg}">
        <p style="color:red;">${errorMsg}</p>
    </c:if>

    <form action="register" method="post">
        <label>ID: <input type="text" name="username" required></label><br>
        <label>パスワード: <input type="password" name="password" required></label><br>
        <button type="submit">登録</button>
    </form>

    <p><a href="login.jsp">ログインページに戻る</a></p>
</body>
</html>
 
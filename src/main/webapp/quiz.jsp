<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.Question" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>野球クイズ</title>
</head>
<body>
    <h1>野球クイズ</h1>

    <c:forEach var="q" items="${questions}">
        <h2>${q.title}</h2>
        <p>${q.questionText}</p>

        <form action="checkAnswer" method="post">
            <input type="hidden" name="questionId" value="${q.id}" />
            <label><input type="radio" name="answer" value="1" required /> ${q.choice1}</label><br>
            <label><input type="radio" name="answer" value="2" /> ${q.choice2}</label><br>
            <label><input type="radio" name="answer" value="3" /> ${q.choice3}</label><br>
            <label><input type="radio" name="answer" value="4" /> ${q.choice4}</label><br>
            <button type="submit">回答する</button>
        </form>
    </c:forEach>

    <p><a href="mypage.jsp">マイページに戻る</a></p>
</body>
</html>
 
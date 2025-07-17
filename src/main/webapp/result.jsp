<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>回答結果</title>
</head>
<body>
    <h1>回答結果</h1>

    <h2>${question.title}</h2>
    <p>${question.questionText}</p>

    <p>あなたの答え：
        <c:choose>
            <c:when test="${selectedAnswer == 1}">${question.choice1}</c:when>
            <c:when test="${selectedAnswer == 2}">${question.choice2}</c:when>
            <c:when test="${selectedAnswer == 3}">${question.choice3}</c:when>
            <c:when test="${selectedAnswer == 4}">${question.choice4}</c:when>
        </c:choose>
    </p>

    <p>正解：
        <c:choose>
            <c:when test="${question.correctChoice == 1}">${question.choice1}</c:when>
            <c:when test="${question.correctChoice == 2}">${question.choice2}</c:when>
            <c:when test="${question.correctChoice == 3}">${question.choice3}</c:when>
            <c:when test="${question.correctChoice == 4}">${question.choice4}</c:when>
        </c:choose>
    </p>

    <h3 style="color: ${isCorrect ? 'green' : 'red'};">
        <c:if test='${isCorrect}'>正解！おめでとう！</c:if>
        <c:if test='${!isCorrect}'>不正解です。頑張って！</c:if>
    </h3>

    <p><a href="quiz">もう一問挑戦する</a></p>
    <p><a href="mypage.jsp">マイページに戻る</a></p>
</body>
</html>

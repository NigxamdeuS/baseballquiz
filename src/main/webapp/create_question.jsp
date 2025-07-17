<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>問題作成</title>
</head>
<body>
    <h1>新しい問題を作る</h1>

    <c:if test="${not empty errorMsg}">
        <p style="color:red;">${errorMsg}</p>
    </c:if>

    <form action="createQuestion" method="post">
        <label>タイトル: <input type="text" name="title" required></label><br>
        <label>問題文: <textarea name="question_text" required></textarea></label><br>
        <label>選択肢1: <input type="text" name="choice1" required></label><br>
        <label>選択肢2: <input type="text" name="choice2" required></label><br>
        <label>選択肢3: <input type="text" name="choice3" required></label><br>
        <label>選択肢4: <input type="text" name="choice4" required></label><br>
        <label>正解番号（1〜4）: <input type="number" name="correct_choice" min="1" max="4" required></label><br>
        <button type="submit">登録</button>
    </form>

    <p><a href="mypage.jsp">マイページに戻る</a></p>
</body>
</html>
 
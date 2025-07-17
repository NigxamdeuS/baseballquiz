<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>エラー - 野球クイズ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .error-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        h1 {
            color: #dc3545;
        }
        .error-message {
            color: #666;
            margin: 20px 0;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>⚠️ エラーが発生しました</h1>
        <div class="error-message">
            <p>申し訳ございませんが、エラーが発生しました。</p>
            <c:if test="${not empty errorMsg}">
                <p><strong>エラー内容:</strong> ${errorMsg}</p>
            </c:if>
            <c:if test="${not empty exception}">
                <p><strong>例外:</strong> ${exception.message}</p>
            </c:if>
        </div>
        <div>
            <a href="index.jsp" class="btn">ホームに戻る</a>
            <a href="javascript:history.back()" class="btn">前のページに戻る</a>
        </div>
    </div>
</body>
</html> 
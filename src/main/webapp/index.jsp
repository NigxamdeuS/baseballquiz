<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>野球クイズ - ホーム</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .welcome-text {
            text-align: center;
            margin-bottom: 30px;
            color: #666;
        }
        .button-container {
            text-align: center;
        }
        .btn {
            display: inline-block;
            padding: 12px 24px;
            margin: 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .btn-secondary {
            background-color: #6c757d;
        }
        .btn-secondary:hover {
            background-color: #545b62;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>⚾ 野球クイズ</h1>
        <div class="welcome-text">
            <p>野球に関するクイズに挑戦してみましょう！</p>
            <p>ログインして問題に挑戦したり、新しい問題を作成したりできます。</p>
        </div>
        
        <div class="button-container">
            <a href="login.jsp" class="btn">ログイン</a>
            <a href="register.jsp" class="btn btn-secondary">新規登録</a>
        </div>
    </div>
</body>
</html> 
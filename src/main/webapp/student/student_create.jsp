<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>学生登録</title>

</head>

<body>

<!-- 画面タイトル -->
<h2>学生登録</h2>

<!-- 学生登録フォーム -->
<form
    action="/scoremanager/StudentCreateExecute.action"
    method="post">

    <!-- 学生番号入力 -->
    番号：
    <input
        type="text"
        name="no">
    <br>

    <!-- 学生名入力 -->
    名前：
    <input
        type="text"
        name="name">
    <br>

    <!-- 入学年度入力 -->
    年度：
    <input
        type="text"
        name="entYear">
    <br>

    <!-- クラス番号入力 -->
    クラス：
    <input
        type="text"
        name="classNum">
    <br>

    <!-- 登録ボタン -->
    <input
        type="submit"
        value="登録">

</form>

<!-- 学生一覧画面へ戻る -->
<p>
    <a href="/scoremanager/StudentList.action">
        一覧に戻る
    </a>
</p>

</body>
</html>
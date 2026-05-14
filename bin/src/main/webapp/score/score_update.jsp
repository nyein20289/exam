<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>成績変更</title>

</head>

<body>

<!-- 画面タイトル -->
<h2>成績変更</h2>

<!-- 成績変更フォーム -->
<form
    action="/scoremanager/ScoreUpdateExecute.action"
    method="post">

    <!-- 学生番号入力 -->
    学生番号：
    <input
        type="text"
        name="studentNo">
    <br>

    <!-- 科目コード入力 -->
    科目コード：
    <input
        type="text"
        name="subjectCd">
    <br>

    <!-- 点数入力 -->
    点数：
    <input
        type="text"
        name="point">
    <br>

    <!-- 更新ボタン -->
    <input
        type="submit"
        value="更新">

</form>

<!-- 一覧画面へ戻る -->
<p>
    <a href="/scoremanager/StudentList.action">
        学生一覧へ戻る
    </a>
</p>

</body>
</html>
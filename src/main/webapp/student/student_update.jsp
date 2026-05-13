<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="bean.Student" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>学生変更</title>

</head>

<body>

<!-- 画面タイトル -->
<h2>学生変更</h2>

<%
Student student =
    (Student)
        request.getAttribute("student");
%>

<!-- 学生変更フォーム -->
<form
    action="/scoremanager/StudentUpdateExecute.action"
    method="post">

    <!-- 学生番号 -->
    番号：
    <input
        type="text"
        name="no"
        value="<%= student.getNo() %>"
        readonly>

    <br>

    <!-- 学生名 -->
    名前：
    <input
        type="text"
        name="name"
        value="<%= student.getName() %>">

    <br>

    <!-- クラス番号 -->
    クラス：
    <input
        type="text"
        name="classNum"
        value="<%= student.getClassNum() %>">

    <br>

    <!-- 変更ボタン -->
    <input
        type="submit"
        value="変更">

</form>

<!-- 学生一覧画面へ戻る -->
<p>
    <a href="/scoremanager/StudentList.action">
        一覧に戻る
    </a>
</p>

</body>
</html>

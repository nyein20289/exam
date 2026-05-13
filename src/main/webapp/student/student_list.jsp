<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>学生管理一覧</title>

</head>

<body>

<!-- 画面タイトル -->
<h2>学生管理一覧</h2>

<!-- 新規登録画面へのリンク -->
<p>
    <a href="/scoremanager/StudentCreate.action">
        新規登録
    </a>
</p>

<!-- 学生一覧テーブル -->
<table border="1">

<tr>

    <th>番号</th>
    <th>名前</th>
    <th>年度</th>
    <th>クラス</th>
    <th>変更</th>

</tr>

<%
/*
 * Actionクラスから受け取った
 * 学生一覧データを取得
 */
List<Student> list =
    (List<Student>)
        request.getAttribute("list");

/*
 * 学生一覧を1件ずつ表示
 */
for (Student s : list) {
%>

<tr>

    <!-- 学生番号 -->
    <td>
        <%= s.getNo() %>
    </td>

    <!-- 学生名 -->
    <td>
        <%= s.getName() %>
    </td>

    <!-- 入学年度 -->
    <td>
        <%= s.getEntYear() %>
    </td>

    <!-- クラス番号 -->
    <td>
        <%= s.getClassNum() %>
    </td>

    <!-- 変更リンク -->
    <td>
        <a href=
            "/scoremanager/StudentUpdate.action?no=<%= s.getNo() %>">
            変更
        </a>
    </td>

</tr>

<%
}
%>

</table>

</body>
</html>
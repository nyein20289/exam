<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="bean.StudentScoreList" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>学生別成績一覧</title>

</head>

<body>

<!-- 画面タイトル -->
<h2>学生別成績一覧</h2>

<!-- 学生番号検索フォーム -->
<form action="/scoremanager/ScoreList.action" method="get">

    学生番号：

    <!-- 入力欄 -->
    <input
        type="text"
        name="studentNo"
        value="<%= request.getAttribute(\"studentNo\") != null
                ? request.getAttribute(\"studentNo\")
                : \"\" %>">

    <!-- 検索ボタン -->
    <input type="submit" value="検索">

</form>

<%
/*
 * Actionクラスから受け取った
 * 成績一覧データを取得
 */
List<StudentScoreList> list =
    (List<StudentScoreList>)
        request.getAttribute("list");

/*
 * データ存在確認
 */
if (list != null && !list.isEmpty()) {
%>

<!-- 成績一覧テーブル -->
<table border="1">

<tr>
    <th>学生番号</th>
    <th>名前</th>
    <th>科目名</th>
    <th>点数</th>
</tr>

<%
/*
 * 成績一覧を1件ずつ表示
 */
for (StudentScoreList item : list) {
%>

<tr>

    <!-- 学生番号 -->
    <td>
        <%= item.getStudentNo() %>
    </td>

    <!-- 学生名 -->
    <td>
        <%= item.getStudentName() %>
    </td>

    <!-- 科目名 -->
    <td>
        <%= item.getSubjectName() %>
    </td>

    <!-- 点数 -->
    <td>
        <%= item.getPoint() %>
    </td>

</tr>

<%
}
%>

</table>

<%
/*
 * データが存在しない場合
 */
} else if (list != null) {
%>

<p>
    該当するデータがありません。
</p>

<%
}
%>

</body>
</html>
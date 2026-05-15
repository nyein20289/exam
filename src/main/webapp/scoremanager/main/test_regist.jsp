<!-- test_regist.jsp -->

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成績登録</title>
</head>

<body>

<h2>成績登録</h2>

<form action="TestRegistAction" method="post">

    学生番号<br>
    <input type="text" name="studentNo"><br><br>

    科目コード<br>
    <input type="text" name="subjectCd"><br><br>

    点数<br>
    <input type="number" name="point"><br><br>

    <input type="submit" value="登録">

</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>훈련사 등록</title>
</head>
<body>
	<h3>훈련사 등록</h3>
	<form action="trainerInsert.wd" method="post">
			아이디<input type="text" name="trId"><br>
			이메일<input type="text" name="trEmail" size="20"><br>
			전화번호<input type="text" name="trTel" size="50"><br>
			이름<input type="text" name="trName" size="50"><br>
			등록날짜<input type="text" name="trDate" size="50"><br>
			삭제날짜<input type="text" name="trDelDate" size="50"><br>
			등록관리자아이디<input type="text" name="adminID" size="50"><br>
			<input type="submit" value="확인">&nbsp;&nbsp;&nbsp;<a href="admin.wd">돌아가기</a>
	</form>

</body>
</html>
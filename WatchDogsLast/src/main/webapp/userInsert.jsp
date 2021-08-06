<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<h3>회원 등록</h3>
	<form action="userInsert.wd" method="post">
			아이디<input type="text" name="userId"><br>
			비밀번호<input type="text" name="userPw" size="20"><br>
			전화번호<input type="text" name="userTel" size="50"><br>
			이메일<input type="text" name="userEmail" size="50"><br>
			이름<input type="text" name="userName" size="50"><br>
			등록관리자아이디<input type="text" name="adminID" size="50"><br>
			<input type="submit" value="확인">&nbsp;&nbsp;&nbsp;<a href="admin.wd">돌아가기</a>
	</form>

</body>
</html>
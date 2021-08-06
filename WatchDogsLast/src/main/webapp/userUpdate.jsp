<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<h3>회원 정보</h3>
		<form action="userUpdate.wd" method="post">
			<input type="hidden" name="userId" value="${detail.userId }">
				아이디<input type="text" name="userId" readonly="readonly" value="${detail.userId }"><br>
				비밀번호<input type="text" name="userPw" size="20" value="${detail.userPw}"><br>
				이메일<input type="text" name="userTel" size="50" value="${detail.userTel}"><br>
				전화번호<input type="text" name="userEmail" size="50" value="${detail.userEmail}"><br>
				이름<input type="text" name="userName" size="50" value="${detail.userName}"><br>
				등록날짜<input type="text" name="userDate" size="50" value="${detail.userDate}"><br>
				삭제날짜<input type="text" name="userDelDate" size="50" value="${detail.userDelDate}"><br>
				등록관리자아이디<input type="text" name="adminID" size="50" value="${detail.adminID}"><br>
				<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="admin.wd">돌아가기</a>
				&nbsp;&nbsp;&nbsp;<a href="userDelete.wd?userId=${detail.userId }">삭제</a>
		</form>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>훈련사 정보</title>
</head>
<body>
	<h3>훈련사 정보</h3>
		<form action="trainerUpdate.wd" method="post">
			<input type="hidden" name="trId" value="${detail.trId }">
				아이디<input type="text" name="trId" readonly="readonly" value="${detail.trId }"><br>
				이메일<input type="text" name="trEmail" size="20" value="${detail.trEmail}"><br>
				전화번호<input type="text" name="trTel" size="50" value="${detail.trTel}"><br>
				이름<input type="text" name="trName" size="50" value="${detail.trName}"><br>
				등록날짜<input type="text" name="trDate" size="50" value="${detail.trDate}"><br>
				삭제날짜<input type="text" name="trDelDate" size="50" value="${detail.trDelDate}"><br>
				등록관리자아이디<input type="text" name="adminID" size="50" value="${detail.adminID}"><br>
				<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="admin.wd">돌아가기</a>
				&nbsp;&nbsp;&nbsp;<a href="trainerDelete.wd?trId=${detail.trId }">삭제</a>
		</form>
	
</body>
</html>
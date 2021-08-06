<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서 정보</title>
</head>
<body>
	<h3>문서 정보</h3>
		<form action="documentUpdate.wd" method="post">
			<input type="hidden" name="docId" value="${detail.docId }">
				번호<input type="text" name="docId" readonly="readonly" value="${detail.docId }"><br>
				제목<input type="text" name="docTitle" size="20" value="${detail.docTitle}"><br>
				내용<input type="text" name="docContent" size="50" value="${detail.docContent}"><br>
				구분<input type="text" name="docType" size="50" value="${detail.docType}"><br>
				작성날짜<input type="text" name="docDate" size="50" value="${detail.docDate}"><br>
				삭제날짜<input type="text" name="docDelDate" size="50" value="${detail.docDelDate}"><br>
				작성자아이디<input type="text" name="userID" size="50" value="${detail.userID}"><br>
				관리자아이디<input type="text" name="adminID" size="50" value="${detail.adminID}"><br>
				<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="admin.wd">돌아가기</a>
				&nbsp;&nbsp;&nbsp;<a href="documentDelete.wd?docId=${detail.docId }">삭제</a>
		</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서 등록</title>
</head>
<body>
	<h3>문서 등록</h3>
	<form action="documentInsert.wd" method="post"  enctype="multipart/form-data">
			제목<input type="text" name="docTitle" size="20"><br>
			내용<input type="text" name="docContent" size="20"><br>
			구분<input type="text" name="docType" size="20"><br>
			작성자아이디<input type="text" name="userID" size="50"><br>
			관리자아이디<input type="text" name="adminID" size="50"><br>
			파일 첨부 : <input type="file" name="file"> <br>  
			<input type="submit" value="확인" accept="image*">&nbsp;&nbsp;&nbsp;<a href="admin.wd">돌아가기</a>
	
	
	</form>
 	<form action="fileupload.jsp" target="_blank" method="post" enctype="multipart/form-data">
			파일 첨부 : <input type="file" name="file"> <br>  
		<!-- 사용자가 전송한(업로드한) 파일이 name명 대로 (file) 전송됨 -->
		<input type="submit" value="파일첨부" accept="image*" ><br>
	</form>
	
	
	
</body>
</html>
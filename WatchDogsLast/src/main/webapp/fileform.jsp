<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file form</title>
<script type="text/javascript">

</script>
</head>
<body>
	사용자 : <input name="user" value="사용자"><br/> 
	문서제목 : <input name="title" value="문서 제목"><br/>

	<form action="fileupload.jsp"  method="post" enctype="multipart/form-data">
		파일 첨부 : <input type="file" name="file"> <br>  
		<!-- 사용자가 전송한(업로드한) 파일이 name명 대로 (file) 전송됨 -->
		<input type="submit"  value="파일첨부" accept="image*" ><br>
	</form>
	<!-- <a href ="fileDownload.jsp"	>파일 다운로드 페이지</a> -->
</body>
</html> 
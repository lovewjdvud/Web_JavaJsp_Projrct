<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="com.oreilly.servlet.MultipartRequest" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//2021.05.19 권효은 파일 업로드 작업
	
    // 파일이 저장되는 경로
    String path = request.getSession().getServletContext().getRealPath("fileFolder"); 
	System.out.println("path");
  // String path = request.getRealPath("fileUpload");
  //String path = request.getRealPath("save");
  	
  	System.out.println("fileFolder 접근 완료");
  	
    int size = 1024 * 1024 * 10; // 업로드 할 최대 파일 크기 (몇 메가바이트까지인지)
    String file = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
    String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름 (옛날께 이름바꿨다고 삭제 되지 않게)

    // 실제 파일 업로드하는 과정
    try{
        MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		//실제 path, max size, defaulFileRenamePolicy : 오리지날파일 어떻게 하겠느냐 : 파일뒤에 1,2 3 붙음 (덮어씌우기 방지 )
		//값 받아와보기
		String docid = multi.getParameter("docid") ;
		String doctitle = multi.getParameter("doctitle");
		String doccontent = request.getParameter("doccontent");
		
		
		//파일 이름 가져오기
        Enumeration<String> files = multi.getFileNames();
        String str = (String)files.nextElement(); // 파일 이름을 받아와 string으로 저장

        file = multi.getFilesystemName(str); // 업로드 된 파일 이름 가져옴
        originalFile = multi.getOriginalFileName(str); // 원래의 파일이름 가져옴
		session.setAttribute("file", file);

    } catch (Exception e) {
        e.printStackTrace();
    }
    
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function WinClose()
	 {
	   window.open('','_self').close();     
	}
</script>
<body>

	
	<h3>파일 업로드 성공</h3>
	번호 : <input name="user" value="사용자"><br/> 
	제목 : 

	<form action="fileupload.jsp"  method="post" enctype="multipart/form-data">
		파일 첨부 : <input type="file" name="file"> <br>  
		<!-- 사용자가 전송한(업로드한) 파일이 name명 대로 (file) 전송됨 -->
		<input type="submit"  value="파일첨부" ><br>
	</form>
	<input type="button" value="확인" onclick="window.close()">
</body>
</html>
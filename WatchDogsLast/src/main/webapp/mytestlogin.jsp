<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 
 
 
 <script type = "text/javascript">
      
 
      
      
      function CheckLogin(){
     var form = document.loginForm
	 
	  if(form.id.value=="") {
		alert("아이디를 입력해 주세요!");  
	    form.id.focus();
		return false;
			  
	  }
        form.submit();
  }
 
 
 </script>
<body>
     <form name="loginForm" action = "adopt.wd">
    
     <p>아이디 : <input type="text" name="id" ></p>
     
     <p><input type ="submit" value="전송" onclick="CheckLogin()"> 
 
     </form>
</body>
</html>
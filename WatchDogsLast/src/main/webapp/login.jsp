<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>로그인 / 회원가입 폼 템플릿</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <%
    	String Id = "";
		request.setAttribute("Id", Id);
    %>
    
    <body>
        <div class="wrap">
            <div class="form-wrap">
                <div class="button-wrap">
                    <div id="btn"></div>
                    <button type="button" class="togglebtn" onclick="login()">로그인</button>
                    <button type="button" class="togglebtn" onclick="register()">회원가입</button>
                </div>
                <div class="icon">
                    <img src="iamges/logo.png" width="50px" height="50px" alt="WatchDogs">
                </div>
                <form id="login" action="logincheck.wd" class="input-group">
                    <input type="id" class="input-field" placeholder="아이디" required>
                    <input type="password" class="input-field" placeholder="비밀번호" required>
                    <input type="checkbox" class="checkbox"><span>아이디 기억하기</span>
                    <button class="submit">로그인</button>
                </form>
                <form id="register" action="signup.wd" class="input-group">
                    <input type="id" class="input-field" placeholder="아이디" required>
                    <input type="password" class="input-field" placeholder="비밀번호" required>
                    <input type="phone" class="input-field" placeholder="핸드폰 번호" required>
                    <input type="mail" class="input-field" placeholder="메일" required>
                    <input type="username" class="input-field" placeholder="사용자 이름" required>
                    <button class="submit">등록하기</button>         
                    <a href="lookupid.wd" class="abc">아이디 찾기</a> | <a href="lookuppw.wd" class="abc">비밀번호 찾기</a>          
                </form>
                
            </div>
        </div>
        <script>
            var x = document.getElementById("login");
            
            
            var y = document.getElementById("register");
            var z = document.getElementById("btn");
            
            
            function login(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }

            function register(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }
        </script>
    </body>
</html> 


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

 <%

    int pageNum;     // 현재 클릭한 페이지 
    int pageCount ; // 총 페이지 수
    int startPage ;    // 시작페이지
    int endPage ;     //끝페이지
     // 게시물 총 갯수가 동일할 때를 위함 
    int count = (int)session.getAttribute("count");
    
     startPage = (int)session.getAttribute("startPage");
     pageCount = (int)session.getAttribute("pageCount");
     endPage = (int)session.getAttribute("endPage");
  
%>
<html>
<head>
<meta charset="UTF-8">
<title>입양 카테고리</title>
 <link href="category.css" rel="stylesheet" type="text/css">
 <style type="text/css"> a { text-decoration:none } 
</style> 
 </head>
 <body>
 <h1>입양 완료 카테고리</h1>

 <nav> 
    <ul> 
      <li><a href="adoptproceeding.wd" style="color: black">입양 진행</a></li>
      <li><a href="adopt.wd" style="color: black">입양 가능</a></li> 
      <li><a href="adoptcomplete.wd" style="color: black">입양 완료</a></li>
      <li><a href="adopttraining.wd" style="color: black">훈련 중</a></li>
    </ul>
  </nav>
 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 
 <form action="adoptcompleteSearch.wd">
    <br>
    <br>
         <select name = "searchtype">
            <option value = "dogmf">성별</option>
            <option value = "dogtype" selected = "dogtype">견종</option>
         </select>  
         
         <input type="search" name = "search">
         <input type="submit" value = "검색">
         
         
          <input type = "hidden" name = "dogadopttst" value="입양완료">
         
         
    <br>
    <br>
    </form>     
    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   


        <table border="1">
        <tr>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
        <th>견종</th>
        <th>등록 날짜</th>
        <th>상태</th>
         <th>사진</th>
        </tr>
        <c:forEach items="${adopt}" var="dto">
        <tr>
         <td><a href="adoptcomplete_02.wd?dogid=${dto.dogid}">${dto.dogname}</a></td>        
           <td>${dto.dogmf} </td>
         <td>${dto.dogage} </td>
         <td>${dto.dogtype} </td>
         <td>${dto.dogdate} </td>
         <td>${dto.dogadopttst} </td>
         <td><img width="300" height="200" src="dog/${dto.dogfilepath}"></td>
         </tr>
         </c:forEach>
        </table>
          
          <%for(int i = startPage; i<=endPage; i++){ %>
	      
	      <td><a href="adoptcomplete.wd?pageNum=<%=i%>">[<%=i%>]</a></td>   
	       
	           	           
	        <% } %>
        
</body>
</html>
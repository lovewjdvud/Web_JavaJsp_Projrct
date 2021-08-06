
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>후기 목록</title>

</head>
<body>
<%-- 	<%@ include file="inc/header.jsp" %>
 
	<div style="height: 500px">
	    <%
	        String subpage = "reviewlist";
	        if(request.getParameter("subpage") != null){
	            subpage = request.getParameter("subpage");
	        }
	        subpage = "subpage/" + subpage + ".jsp";
	    %>
	    <jsp:include page="<%=subpage %>"></jsp:include>
	</div> --%>
		<nav > 
			<ul class="nav-container" > 
			<li class="nav-item"> <a href="noticelist.wd">공지</a></li>
			<li class="nav-item"> <a href="reviewlist.wd">후기</a></li>	
			</ul>
			
		</nav>
		
		<section><p>후기</p></section>
	

 

	<div style="width: 510px; height: 50px; background-color: orange;"></div>

	<h3>후기 목록</h3>
	
	<table border="1" class="table"> 
<%-- 		<colgroup>
			<col width ="10%">
			<col width ="50%">
			<col width ="50%">
			<col width ="20%">
			<col width ="10%">
		</colgroup> --%>
		<thead class="thead-light">
			<tr>
				<th scope="col">No.</th>
				<th scope="col">제목</th>
				<th scope="col">내용</th>
				<th scope="col">날짜</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${reviewlist }" var="ReviewDto" >
				<tr>
					<td>${ReviewDto.docid}</td>
					<td>${ReviewDto.doctitle}</td>
					<td><a href="reviewdetail.wd?docid=${ReviewDto.docid}" >${ReviewDto.doccontent}</a></td>
					<td><fmt:formatDate value="${ReviewDto.docdate}" pattern="yyyy.MM.dd" /></td>
					<td>${ReviewDto.docviews}</td>
			
				</tr>

			</c:forEach>
		
<!-- 		 <tr>
			<td colspan="5" align="right"> <a href="review.wd">후기작성</a></td>
		</tr>  -->
		
		<!-- 2021.05.19 페이징 구현 -->
			<tr>
				<td colspan="5" align="center">
					<!-- 페이징 부분 -->
					<c:forEach items="${pagelist }" var="page">
						<a href="reviewlist.wd?page=${page }">${page}</a>
					</c:forEach>
				</td>
	   		</tr>
	</tbody>			
	</table>
	
	<button type="button"  onClick="location.href='review.wd'" >후기작성</button>
	 
<% /* <style type="Review/css">
	.page{
		color : red;
	}
	</style>  */      %>
	
	
	<!-- 2021.05.19 페이징 구현 -->
<!-- 	<div class="page">
		<a href="reviewlist?page=1">1</a>
		<a href="reviewlist?page=2">2</a>
		<a href="reviewlist?page=3">3</a>
	</div> -->
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 목록</title>
</head>
<body>
	<nav > 
		<ul class="nav-container" > 
		<li class="nav-item"> <a href="noticelist.wd">공지</a></li>
		<li class="nav-item"> <a href="reviewlist.wd">후기</a></li>	
		</ul>
		
	</nav>	
	<section><p>공지</p></section>
	
	
	
	<div class="search-form margin-top first align-right">
		<h3 class="hidden">공지사항 검색폼</h3>
			<form class="table-form">
				<fieldset>
					<legend class="hidden">공지사항 검색</legend>
					<label class="hidden">검색분류</label>
					<select name="f">
						<option  value="title">제목</option>
						<option  value="writerId">내용</option>
					</select> 
					<label class="hidden">검색어</label>
					<input type="text" name="q" value=""/>
					<input class="btn btn-search" type="submit" value="검색" />
				</fieldset>
			</form>
	</div>
	
	
	
	
	
	
	<div style="width: 510px; height: 50px; background-color: orange;"></div>
	<h3>공지 목록</h3>
	
	<table border="1" class="table"> 
		<thead class="thead-light">
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">내용</th>
				<th scope="col">날짜</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${noticelist }" var="noticelist" >
				<tr>
					<td>${noticelist.noticeid}</td>
					<td>${noticelist.noticetitle}</td>
					<td><a href="noticedetail.wd?noticeid=${noticelist.noticeid}" >${noticelist.noticecontent}</a></td>
					<td>${noticelist.noticedate}</td>
					<td>${noticelist.noticeviews}</td>
			
				</tr>

			</c:forEach>
		

		<!-- 2021.05.19 페이징 구현 -->
			<tr>
				<td colspan="5" align="center">
					<!-- 페이징 부분 -->
					<c:forEach items="${pagelist }" var="page">
						<a href="noticelist.wd?page=${page }">${page}</a>
					</c:forEach>
				</td>
	   		</tr>
	</tbody>			
	</table>
	

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WatchDogs</title>
</head>
<body>
	<a href="home.wd">홈으로</a>
	<h3>훈련사</h3>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>이름</th>
			<th>등록날짜</th>
			<th>삭제날짜</th>
			<th>등록관리자아이디</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.trId}</td>
			<td>${dto.trEmail}</td>
			<td>${dto.trTel}</td>
			<td>${dto.trName}</td>
			<td>${dto.trDate}</td>
			<td>${dto.trDelDate}</td>
			<td>${dto.adminID}</td>
		</tr>
		</c:forEach>
			
	</table>
</body>
</html>
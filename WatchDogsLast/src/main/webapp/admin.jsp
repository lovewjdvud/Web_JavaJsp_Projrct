<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 사용시 필용한 import --> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
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
		<c:forEach items="${listTrainer}" var="dto">
		<tr>
			<td>${dto.trId}</td>
			<td>${dto.trEmail}</td>
			<td>${dto.trTel}</td>
			<td><a href = "trainerUpdateOpen.wd?trId=${dto.trId }">${dto.trName}</a></td>
			<td>${dto.trDate}</td>
			<td>${dto.trDelDate}</td>
			<td>${dto.adminID}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="7"><a href="trainerInsertOpen.wd">훈련사 등록</a></td>
		</tr>
		
	</table>
	<h3>강아지</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>훈련상태</th>
			<th>입양상태</th>
			<th>등록날짜</th>
			<th>입양날짜</th>
			<th>훈련내용</th>
			<th>등록관리자아이디</th>
			<th>훈련사아이디</th>
		</tr>
		<c:forEach items="${listDog}" var="dto">
		<tr>
			<td>${dto.dogId}</td>
			<td><a href = "dogUpdateOpen.wd?dogId=${dto.dogId }">${dto.dogName}</a></td>
			<td>${dto.dogTrainSt}</td>
			<td>${dto.dogAdoptSt}</td>
			<td>${dto.dogDate}</td>
			<td>${dto.dogAdoptDate}</td>
			<td>${dto.dogTrainComm}</td>
			<td>${dto.adminID}</td>
			<td>${dto.trainerID}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="9"><a href="dogInsertOpen.wd">강아지 등록</a></td>
		</tr>
			
	</table>
	<h3>문서</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>구분</th>
			<th>작성날짜</th>
			<th>삭제날짜</th>
			<th>작성자아이디</th>
			<th>관리자아이디</th>
		</tr>
		<c:forEach items="${listDocument}" var="dto">
		<tr>
			<td>${dto.docId}</td>
			<td><a href = "documentUpdateOpen.wd?docId=${dto.docId }">${dto.docTitle}</a></td>
			<td>${dto.docContent}</td>
			<td>${dto.docType}</td>
			<td>${dto.docDate}</td>
			<td>${dto.docDelDate}</td>
			<td>${dto.userID}</td>
			<td>${dto.adminID}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="8"><a href="documentInsertOpen.wd">문서 등록</a></td>
		</tr>
			
	</table>
	<h3>회원</h3>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>이름</th>
			<th>등록날짜</th>
			<th>탈퇴날짜</th>
			<th>등록관리자아이디</th>
		</tr>
		<c:forEach items="${listUser}" var="dto">
		<tr>
			<td>${dto.userId}</td>
			<td>${dto.userPw}</td>
			<td>${dto.userTel}</td>
			<td>${dto.userEmail}</td>
			<td><a href = "userUpdateOpen.wd?userId=${dto.userId }">${dto.userName}</a></td>
			<td>${dto.userDate}</td>
			<td>${dto.userDelDate}</td>
			<td>${dto.adminID}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="8"><a href="userInsertOpen.wd">회원 등록</a></td>
		</tr>
			
	</table>
</body>
</html>
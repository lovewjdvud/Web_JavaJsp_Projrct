<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
  
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>공지 상세 페이지</title>
</head>
<body>

	<div style="width: 680px; height: 50px; background-color: orange;"></div>

	 <table  border="0" style="background-color: #eeeeee; text-align: center;">
	 	<input type="hidden" name="docid" value="${noticedetail.noticeid}">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #FFEBCD; text-align: center;">공지 상세 페이지</th>
				</tr>
			</thead>
			<tr>
				<td>No.</td>
				<td><input type="text" name="userid" size="80" readonly="readonly" value="${noticedetail.noticeid}"></td>
			
			</tr> 
			<tr>
				<td>관리자</td>
				<td><input type="text" name="userid" size="80" readonly="readonly" value="${noticedetail.adid}"></td>
			
			</tr> 
			<tr>
				<td>조회수</td>
				<td><input type="text" name="userid" size="80" readonly="readonly" value="${noticedetail.noticeviews}"></td>
			
			</tr> 
				
			<tr>
				<td>제목</td>
				<td><input type="text" name="doctitle" size="80" value="${noticedetail.noticetitle}"></td>
			
			</tr>
			<tr>
				<td>날짜</td>
				<td><input type="text" name="docdate" size="80" readonly="readonly"  value="${noticedetail.noticedate}"></td>
			
			</tr>
		
			<tr>
				<td>내용</td>
				<td><input type="text" name="doccontent" size="80" value="${noticedetail.noticecontent}"></td>
			
			</tr>
			<tr>
				<td></td>			
				<input type="button" onclick="location.href='noticelist.wd" value="확인"></td>
			</tr>
				
			
			<!-- 입력이 안됐을때 첫 화면으로 돌아가게 하기 위해서 하이퍼 링크 달아주기 -->

			<tr>
				<td><a href = "noticelist.wd">목록으로</a></td>
			</tr>	
		</form>
	</table> 


</body>
</html>
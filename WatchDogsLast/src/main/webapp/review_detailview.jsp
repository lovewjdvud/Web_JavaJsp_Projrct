<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
  
<!DOCTYPE html>
<html>
<script> 
function btn(){ alert('게시글이 삭제되었습니다'); } 


</script>
<head>
<meta charset="UTF-8">
<title>후기 상세 페이지</title>
</head>
<body>

<div style="width: 680px; height: 50px; background-color: orange;"></div>

	 <table  border="0" style="background-color: #eeeeee; text-align: center;">
	 <form action="reviewmodify.wd" method="post" name="reviewForm" enctype="multipart/form-data">
	 	<input type="hidden" name="docid" value="${reviewdetail.docid}">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #FFEBCD; text-align: center;">후기 상세 페이지</th>
				</tr>
			</thead>
			<tr>
				<td>No.</td>
				<td><input type="text" name="userid" size="80" readonly="readonly" value="${reviewdetail.docid}"></td>
			
			</tr> 
			<tr>
				<td>작성자</td>
				<td><input type="text" name="userid" size="80" readonly="readonly" value="${reviewdetail.user_userid}"></td>
			
			</tr> 
			<tr>
				<td>조회수</td>
				<td><input type="text" name="userid" size="80" readonly="readonly" value="${reviewdetail.docviews}"></td>
			
			</tr> 
				
			<tr>
				<td>제목</td>
				<td><input type="text" name="doctitle" size="80" value="${reviewdetail.doctitle}"></td>
			
			</tr>
			<tr>
				<td>날짜</td>
				<td><input type="text" name="docdate" size="80" readonly="readonly"  value="${reviewdetail.docdate}"></td>
			
			</tr>
				<td>사진</td>
				<td><input type="text" name="docimage" size="100"  readonly="readonly" value="${reviewdetail.docimage}"></td>
			
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="doccontent" size="80" value="${reviewdetail.doccontent}"></td>
			
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"  value="수정">
					 oneclick 2개 처리 아직 못함
					<input type="button" onclick="location.href='reviewdelete.wd?docid=${reviewdetail.docid}; javascript:btn();" value="삭제"></td>
			</tr>
				
				<%-- &nbsp;&nbsp;&nbsp;<a href = "reviewdelete.wd?docid=${reviewdetail.docid}">삭제</a></td> --%>
			
			<!-- 입력이 안됐을때 첫 화면으로 돌아가게 하기 위해서 하이퍼 링크 달아주기 -->

			<tr>
				<td><a href = "reviewlist.wd">목록으로</a></td>
			</tr>	
		</form>
	</table> 


</body>
</html>
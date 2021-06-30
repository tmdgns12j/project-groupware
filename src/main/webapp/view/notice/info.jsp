<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시물 상세보기</title>
<style type="text/css">
.wrap{
	width : 70%;
	margin : 0 auto;
}
</style>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
<br>
	<div class="wrap">
		<h3>게시물 ${notice.num }</h3>
		<table class="table"> 
			<caption>게시물 상세 보기</caption>
			<tr class="infotable">
				<td width="5%" style="border-right:1px #d3d3d3">작성자</td>
				<td width="4%" style="text-align: left;">${notice.name}</td>
				<td width="5%">제목</td>
				<td width="10%" style="text-align: left">${notice.subject}</td>
				<td width="5%">첨부파일</td>
				<td width="15%" style="text-align: left;"><c:if
						test="${ notice.file1 == null || notice.file1.trim() eq ''}">
				&nbsp; </c:if> <c:if
						test="${ notice.file1 != null && notice.file1.trim() ne ''}">
						<a href="<%=request.getContextPath() %>/upfile/${notice.file1}">${notice.file1}</a>
					</c:if></td>
			</tr>
			<tr>
				<td style="height:250px;">내용</td>
					<td colspan="5" style="text-align: left;">
					<div>${notice.content}</div> </td>
			</tr>
			<tr>
				<td colspan="6"><a href="replyForm?num=${num}">[답변]</a> <a
					href="updateForm?num=${num}">[수정]</a> <a
					href="deleteForm?num=${num}">[삭제]</a> <a href="list">[목록]</a></td>
			</tr>
		</table>
</div>
</body>
</html>
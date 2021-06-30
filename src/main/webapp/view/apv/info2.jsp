<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.form{
	width : 50%;
	height : 500px;
	margin : 0 auto;
}
table{
   border-collapse: collapse;
   width : 100%;
   height : 100px;
   text-align: center;
   table-layout: fixed;
}
td{
   border: solid 1px grey;
}
.button{
	float : right;
}
</style>
</head>
<body>
<br><br><br><br><br>
<div class="form">
	<div class="list">
		<h2>결재완료서류</h2>
      	<table class="w3-table-all">
	      	<tr><td rowspan="4" style="text-align: center; vertical-align:middle;"><h3>결재내역</h3></td><td colspan="2" style="text-align: center;">결재</td></tr>
	      	<tr><td style="text-align: center;">중간승인</td><td style="text-align: center;">최종승인</td></tr>
	      	<tr><td>${apv.STF_MID_ID }</td><td>${apv.STF_FNL_ID }</td></tr>
	      	<tr>
	      		<c:if test="${apv.APV_NO.substring(0,1) == 'X' }">
				<td>${apv.APV_NO.replaceAll('X:','') }</td>
				</c:if>
				<c:if test="${apv.APV_NO.substring(0,1) == 'O' }">
				<td>${apv.APV_NO }</td>
				</c:if>
				<c:if test="${apv.APV_NO1.substring(0,1) == 'X' }">
				<td>${apv.APV_NO1.replaceAll('X:','') }</td>
				</c:if>
				<c:if test="${apv.APV_NO1.substring(0,1) == 'O' }">
				<td>${apv.APV_NO1 }</td>
				</c:if>
			</tr>
	      	<tr><td style="text-align: center;">결재번호</td><td colspan="2">${apv.APV_SQ}</td></tr>
	      	<tr><td style="text-align: center;">사원</td><td colspan="2">${apv.STF_ID}</td></tr>
	      	<tr><td style="text-align: center;">제목</td><td colspan="2">${apv.APV_NM}</td></tr>
	      	<tr><td style="text-align: center;">내용</td><td colspan="2" style="word-break:break-all;">${apv.APV_CON}</td></tr>
      </table>
	</div>
	<input type="button" class="button" onclick="location.href='list'" value="목록"/>
</div>
</body>
</html>
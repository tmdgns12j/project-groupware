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
	margin : 0 auto;
}
.text{
	width : 90%;
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
<div class="form">
<form action="memupdate" method="post" name="f">
	<h3>사원수정</h3>
	<table class="w3-table-all table table-hover">
		<caption>수정</caption>
		<tr>
			<td>부서</td>
			<td><input type="text" class="text" name="STF_DPT" value=${mem.STF_DPT }></td>
		</tr>
		<tr>
			<td>직급</td>
			<td><input type="text" class="text" name="STF_ADMN" value=${mem.STF_DPT }></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" class="text" name="STF_NM" value=${mem.STF_NM }></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" class="text" name="STF_ID" value=${mem.STF_ID } readonly></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" class="text" name="STF_PW" value=${mem.STF_PW }></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" class="text" name="STF_PH" value=${mem.STF_PH }></td>
		</tr>
		<tr>
			<td>공통주소</td>
			<td><input type="text" class="text" name="STF_CM_ADD" value=${mem.STF_CM_ADD }></td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td><input type="text" class="text" name="STF_DT_ADD" value=${mem.STF_DT_ADD }></td>
		</tr>
		<tr>
			<td>회사전화번호</td>
			<td><input type="text" class="text" name="STF_BS_PH" value=${mem.STF_BS_PH }></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" class="text" name="STF_EML" value=${mem.STF_EML }></td>
		</tr>
		<tr>
			<td>입사일</td>
			<td><input type="text" class="text" name="STF_ENT" value=${mem.STF_ENT }></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><input type="text" class="text" name="STF_REG" value=${mem.STF_REG }></td>
		</tr>
		<tr>
			<td>생일</td>
			<td><input type="text" class="text" name="BIRTH" value=${mem.BIRTH }></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="사원수정" style="float : right;"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
<script type="text/javascript">
	function win_upload() {
		var op = "width=500, height=150, left=50, top=150";
		open("pictureimgForm", "", op);
	}
	function submit() {
		   var f = document.f;
		   f.submit();
		}
</script>
</head>
<body>
<br><br><br><br><br><br>
<form action="join" method="post" name="f">
	<table>
		<caption>등록</caption>
		<tr>
			<td>부서번호</td>
			<td><input type="text" name="STF_DPT"></td>
		</tr>
		<tr>
			<td>직급번호</td>
			<td><input type="text" name="STF_ADMN"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="STF_NM"></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="STF_ID"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="STF_PW"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="STF_PH"></td>
		</tr>
		<tr>
			<td>공통주소</td>
			<td><input type="text" name="STF_CM_ADD"></td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td><input type="text" name="STF_DT_ADD"></td>
		</tr>
		<tr>
			<td>회사전화번호</td>
			<td><input type="text" name="STF_BS_PH"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="STF_EML"></td>
		</tr>
		<tr>
			<td>입사일</td>
			<td><input type="text" name="STF_ENT"></td>
		</tr>
		<tr>
			<td>생일</td>
			<td><input type="text" name="BIRTH"></td>
		</tr>
	</table>
	<a href="javascript:submit()">[작성]</a>
</form>
</body>
</html>
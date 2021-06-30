<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/loginform.css" />
</head>
<body>
<br> <br> <br> <br>
	<!-- stf_tb /stf_sq, stf_pw -->
	<div class="wrap">
		<form action="login" method="post" class="loginForm">
			<h2 class="title">L O G I N</h2>
			<br>
			<div class="idForm">
				<input type="text" class="id" placeholder="ID" name="STF_ID">
			</div>
			<br>
			<div class="passForm">
				<input type="password" class="pw" placeholder="PW" name="STF_PW">
			</div>
			<button type="submit" class="btn">LOG IN</button>
			<br><br><br><br><br><br><br><br><br>
		</form>
	</div>
</body>
</html>
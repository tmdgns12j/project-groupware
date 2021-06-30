<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<br>
<br>
	<form action="letterlogin" method="post" class="loginForm">
		<h2>Login</h2>
		<div class="idForm">
			<input type="text" class="id" placeholder="ID" name="STF_SQ">
		</div>
		<div class="passForm">
			<input type="password" class="pw" placeholder="PW" name="STF_PW">
		</div>
		<button type="submit" class="btn" onclick="button()">LOG IN</button>
	</form>

</body>
</html>
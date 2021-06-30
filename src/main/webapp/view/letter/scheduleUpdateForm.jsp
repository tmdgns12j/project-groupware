<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.form{
	width : 50%;
	height : 600px;
	margin : 0 auto;
}
input{
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

<script type="text/javascript">
	function submit() {
		   var f = document.f;
		   f.submit();
		}
</script>
</head>
<body>
<br>
<div class="form">
<h3>일정 수정</h3>
<form action="scheduleUpdate" method="post" name="f">
<input type="hidden" name="schedule_sq" value="${schedule.schedule_sq}">
	<table class="w3-table-all table table-hover">
		<caption>일정수정</caption>
		<tr>
			<td>일정이름</td>
			<td><input type="text" name="schedule_name" value="${schedule.schedule_name }"></td>
		</tr>
		<tr>
			<td>날짜</td>
			<td><input type="text" name="schedule_date" value="${schedule.schedule_date }"></td>
		</tr>
		<tr><td colspan="2" style="text-align:right;">
			<button onclick="location.href='javascript:submit()'">수정</button></td></tr>
	</table>
</form>
</div>
</body>
</html>
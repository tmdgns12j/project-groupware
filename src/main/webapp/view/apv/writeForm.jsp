<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.form{
	width : 500px;
	height : 700px;
	display: flex;
	justify-content: center;
	align-items: center;
}
.write{
	width : 400px;
	height : 600px;
	margin : 0 auto;
}
.button{
	float : right;
}
.choose{
	width : 90%;
}
.text{
	width : 90%;
}
tr, td{
	padding-top : 10px;
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
<script>
function submit() {
   var f = document.f;
   f.submit();
   
}
</script>
</head>
<body>
<div class="form">
	<div class="write">
		<form action="write" method="post" name="f">
		<h3>결재서류작성</h3>
		<table class="w3-table-all table table-hover">
		<caption>결재서류작성</caption>
			<tr><td>사원아이디</td><td><input type="text" class="text" name="STF_ID" value=${login } readonly></td></tr>
			<tr><td>승인자</td><td><input type="text" class="text" name="STF_MID_ID"></td></tr>
			<tr><td>승인자</td><td><input type="text" class="text" name="STF_FNL_ID"></td></tr>
			<tr><td>결재</td>
				<td>
				<select name="DIV_APV_SQ" class="choose">
					<option value="1">월차/연차</option>
					<option value="2">휴가</option>
					<option value="3">업무보고</option>
				</select>
				</td>
			</tr>
			<tr><td>제목</td><td><input type="text" class="text" name="APV_NM"></td></tr>
			<tr><td>내용</td><td><textarea rows="15" class="text" name="APV_CON"></textarea></td></tr>
		<tr><td colspan="2">
     		<input type="button" value="작성" class="button"
         				onclick="location.href='javascript:submit()'"></td></tr>
		</table>
		</form>
	</div>
	
</div>
</body>
</html>
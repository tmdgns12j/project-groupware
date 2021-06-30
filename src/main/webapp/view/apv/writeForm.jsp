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
		<h3>���缭���ۼ�</h3>
		<table class="w3-table-all table table-hover">
		<caption>���缭���ۼ�</caption>
			<tr><td>������̵�</td><td><input type="text" class="text" name="STF_ID" value=${login } readonly></td></tr>
			<tr><td>������</td><td><input type="text" class="text" name="STF_MID_ID"></td></tr>
			<tr><td>������</td><td><input type="text" class="text" name="STF_FNL_ID"></td></tr>
			<tr><td>����</td>
				<td>
				<select name="DIV_APV_SQ" class="choose">
					<option value="1">����/����</option>
					<option value="2">�ް�</option>
					<option value="3">��������</option>
				</select>
				</td>
			</tr>
			<tr><td>����</td><td><input type="text" class="text" name="APV_NM"></td></tr>
			<tr><td>����</td><td><textarea rows="15" class="text" name="APV_CON"></textarea></td></tr>
		<tr><td colspan="2">
     		<input type="button" value="�ۼ�" class="button"
         				onclick="location.href='javascript:submit()'"></td></tr>
		</table>
		</form>
	</div>
	
</div>
</body>
</html>
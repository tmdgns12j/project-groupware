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
	margin : 0 auto;
}
input{
	width : 90%;
}
.button{
	float : right;
	width : 70px;
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
<br>
<div class="form">
<form action="join" method="post" name="f">
	<h3>������</h3>
	<table class="w3-table-all table">
		<caption>���</caption>
		<tr>
			<td>�μ�</td>
			<td><input type="text" name="STF_DPT"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="STF_ADMN"></td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><input type="text" name="STF_NM"></td>
		</tr>
		<tr>
			<td>���̵�</td>
			<td><input type="text" name="STF_ID"></td>
		</tr>
		<tr>
			<td>��й�ȣ</td>
			<td><input type="text" name="STF_PW"></td>
		</tr>
		<tr>
			<td>��ȭ��ȣ</td>
			<td><input type="text" name="STF_PH"></td>
		</tr>
		<tr>
			<td>�����ּ�</td>
			<td><input type="text" name="STF_CM_ADD"></td>
		</tr>
		<tr>
			<td>���ּ�</td>
			<td><input type="text" name="STF_DT_ADD"></td>
		</tr>
		<tr>
			<td>ȸ����ȭ��ȣ</td>
			<td><input type="text" name="STF_BS_PH"></td>
		</tr>
		<tr>
			<td>�̸���</td>
			<td><input type="text" name="STF_EML"></td>
		</tr>
		<tr>
			<td>�Ի���</td>
			<td><input type="text" name="STF_ENT"></td>
		</tr>
		<tr>
			<td>�����</td>
			<td><input type="text" name="STF_REG"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="BIRTH"></td>
		</tr>
		<tr><td colspan="2"><button onclick="location.href='javascript:submit()'" class="button">�ۼ�</button></td></tr>
	</table>
</form>
</div>
</body>
</html>
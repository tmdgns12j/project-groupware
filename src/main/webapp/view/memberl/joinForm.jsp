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
		<caption>���</caption>
		<tr>
			<td>�μ���ȣ</td>
			<td><input type="text" name="STF_DPT"></td>
		</tr>
		<tr>
			<td>���޹�ȣ</td>
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
			<td>����</td>
			<td><input type="text" name="BIRTH"></td>
		</tr>
	</table>
	<a href="javascript:submit()">[�ۼ�]</a>
</form>
</body>
</html>
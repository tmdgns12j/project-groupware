<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ���� ȭ��</title>
<style type="text/css">
.form{
	width : 70%;
	margin : 0 auto;
}
input, textarea{
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
<script src="js/bootstrap.js"></script><script>
	function file_delete() {
		file_desc = document.getElementById("file_desc")
		document.f.file2.value = "";
		file_desc.style.display = "none";
	}
</script>
</head>
<body>
<br>
<div class="form">
	<form action="update" method="post" enctype="multipart/form-data"
		name="f">
		<input type="hidden" name="num" value="${notice.num}">
		<input type="hidden" name="file2"  	value="${notice.file1}">
		<h3>�Խù� ����</h3>
		<table class="table table-hover">
			<caption>MODEL1 �Խ��� ���� ȭ��</caption>
			<tr>
				<td>�۾���</td>
				<td><input type="text" name="name" value="${notice.name}"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="subject"
					value="${notice.subject}"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea rows="15" name="content">${notice.content}</textarea></td>
			</tr>
			<tr>
				<td>÷������</td>
				<td style="text-align: left">
				<c:if test="${notice.file1 != null && notice.file1 ne ''}">
					
					<div id="file_desc">${notice.file1}
						<a href="javascript:file_delete()">[÷������ ����]</a>
					</div> </c:if>
				<input type="file" name="uploadfile">
				</td>
			</tr>
			<tr>
				<td colspan="2"><a href="javascript:document.f.submit()">[�Խù�����]</a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ���� ȭ��</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/main.css">
<script>
	function file_delete() {
		file_desc = document.getElementById("file_desc")
		document.f.file2.value = "";
		file_desc.style.display = "none";
	}
</script>
</head>
<body>
	<form action="update" method="post" enctype="multipart/form-data"
		name="f">
		<input type="hidden" name="num" value="${board.num}">
		<input type="hidden" name="file2"  	value="${board.file1}">
		<table>
			<caption>MODEL1 �Խ��� ���� ȭ��</caption>
			<tr>
				<td>�۾���</td>
				<td><input type="text" name="name" value="${board.name}"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="subject"
					value="${board.subject}"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea rows="15" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td>÷������</td>
				<td style="text-align: left">
				<c:if test="${board.file1 != null && board.file1 ne ''}">
					
					<div id="file_desc">${board.file1}
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
</body>
</html>
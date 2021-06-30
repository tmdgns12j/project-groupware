<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model1/board/writeForm.jsp --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� �۾���</title>
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
<script src="js/bootstrap.js"></script>
<script>
function notice_submit() {
	var f = document.f;
	if (f.name.value=="") {
		alert("�̸��� �Է��ϼ���")
		f.name.focus();
		return ;
	}
	if (f.pass.value=="") {
		alert("��й�ȣ�� �Է��ϼ���")
		f.pass.focus();
		return ;
	}
	
	if (f.subject.value=="") {
		alert("������ �Է��ϼ���")
		f.subject.focus();
		return ;
	}
	
	if (f.content.value=="") {
		alert("������ �Է��ϼ���")
		f.content.focus();
		return ;
	}
	f.submit();
}


</script>
</head>
<body>
<br>
<div class="form">
<h3>�Խù�����</h3>
<form action="write" method="post" 
       enctype="multipart/form-data" name="f">
  <table class="table table-hover">
   <caption>MODEL1 �Խ��� �۾���</caption>
   <tr><td>�۾���</td><td><input type="text" name="name"></td></tr>
   <tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
   <tr><td>����</td><td><input type="text" name="subject"></td></tr>
   <tr><td>����</td><td><textarea rows="15" name="content"></textarea></td></tr>
   <tr><td>÷������</td><td><input type="file" name="uploadfile"></td></tr>
   <tr><td colspan="2" style="text-align : right;">
     <a href="javascript:notice_submit()">[�Խù����]</a></td></tr>
  </table></form>
</div>  
</body></html>
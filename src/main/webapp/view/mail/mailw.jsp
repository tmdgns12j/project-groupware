<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ������</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mailcss2.css" />
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

<script type="text/javascript" src="http://cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
<script type="text/javascript">
   function naveridchk(f) {
	   if(f.naverid.value == "") {
		   alert("���̹� ���̵� �Է��ϼ���");
		   f.naverid.focus();
		   return false;
	   }
	   if(f.naverpw.value == "") {
		   alert("���̹� ��й�ȣ�� �Է��ϼ���");
		   f.naverpw.focus();
		   return false;
	   }
	   
   }
   
 
   
</script>

<style type="text/css">
.input, textarea{
	width : 90%;
}
.textarea{
	display : flex;
	justify-content: center;
}
.button{
	float: right;
}
</style>
</head>
<body>
<h2>���Ϻ�����</h2>
<form name="mailform" method="post" action="mailw"
    onsubmit="return naveridchk(this)">
   <table border="1" style="border-collapse: collapse; width:100%" class="table table-hover">
   	 
   	 <tr><td>���̹������ּ�</td><td><input class="input" type="text" name="naverid" ></td></tr>
     <tr><td>���̹����Ϻ�й�ȣ</td><td><input class="input" type="password" name="naverpw" ></td></tr>
     <tr><td>������ ���</td><td>${loginUser.email}</td></tr>
     <tr><td>�޴»��</td>
     <td><input class="input" type="text" name="recipient" />

</td></tr>
    <tr><td>����</td><td><input class="input" type="text" name="title" /></td></tr>
   
    <tr><td colspan="2">
    	<div class="textarea">
       <textarea name="contents" cols="120" ></textarea></div>
      
    </td></tr>
    <tr><td colspan="2" align="center">
       <input class="button" type="submit" value="���Ϻ�����">
    </td></tr>
   </table>
</form>   
</body>
</html>
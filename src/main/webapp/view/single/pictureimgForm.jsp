<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/chap08_member/pictureimgForm.jsp --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ���</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" >
</head>
<body>  
<h3>���ε�</h3>
<form action="pictureimg" method="post"  enctype="multipart/form-data">
  <input type="file" name="picture">
  <input type="submit" value="�������">
</form>
</body>
</html>
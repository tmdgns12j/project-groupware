<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model1/board/deleteForm.jsp --%>    
<!DOCTYPE html><html><head><meta charset="EUC-KR"><title>게시판 삭제 화면</title>
<style type="text/css">
.form{
	width : 50%;
	margin : 0 auto;
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
</head><body>
<br>
<div class="form">
<form action="delete" name="f" method="post">
<input type="hidden" name="num"  value="${num}">
<h3>게시글 삭제</h3>
<table class="table table-hover">  <caption>MODEL1 게시글 삭제 화면</caption>
  <tr><td>게시글비밀번호</td>
      <td><input type="password" name="pass" style="width : 90%;"></td></tr>
  <tr><td colspan="2">
     <input type="submit" value="게시글삭제" style="float:right;"></td></tr>
</table></form>
</div>
</body></html>
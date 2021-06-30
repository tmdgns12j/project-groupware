<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html><head><meta charset="EUC-KR">
<title>게시판 답글 쓰기</title>
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
</head>
<body>
<br>
<div class="form">
<form action="reply" method="post" name="f">
<%-- 원글 정보 :num  ref reflevel  refstep--%>
  <input type="hidden" name="num" value="${notice.num}">
  <input type="hidden" name="ref" value="${notice.ref}" >
  <input type="hidden" name="reflevel" value="${notice.reflevel}" >
  <input type="hidden" name="refstep" value="${notice.refstep}" >
  <h3>답글 쓰기</h3>
  <table class="table table-hover"><caption>MODEL1 게시판 답글 등록</caption>
  <tr><td>글쓴이</td><td><input type="text" name="name"></td></tr>
  <tr><td>비밀번호</td><td><input type="password" name="pass"></td></tr>
  <tr><td>제목</td><td><input type="text" name="subject" 
      value="RE:${notice.subject}"></td></tr>
  <tr><td>내용</td>
      <td><textarea name="content" rows="15"></textarea></td></tr>
  <tr><td colspan="2">
  <a href="javascript:document.f.submit()">[답변글등록]</a></td></tr>    
  </table>
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
function letter_submit() {
   var f = document.f;
   f.submit();
   
   self.close();
   
}

</script> 
</head>
<body>
<form action="mailwrite" method="post" target="mail.jsp"
enctype="multipart/form-data" name="f"><!-- controller -->
<br>
<br>
<br>
  <table>
   <caption>writeForm 게시판 글쓰기</caption>
   
   <!-- <tr><td>편지번호</td><td><input type="text" name="EML_SQ"></td></tr> -->
   <tr><td>내용</td><td><textarea rows="text" name="MAIL_CONTENT"></textarea></td></tr>
   <tr><td>받는사원</td><td><input type="text" name="STF_RCV_ID"></td></tr>
   <tr><td>보낸사원</td><td><input type="text" name="STF_SND_ID" value=${login } readonly></td></tr>
   <tr><td>파일경로</td><td><input type="text" name="MAIL_PL_CRS"></td></tr>
   <tr><td>파일명</td><td><input type="file" name="uploadfile"></td></tr>
   <tr><td colspan="2">
     <a href="javascript:letter_submit()">[게시물등록]</a></td></tr>
  </table></form>


</body>
</html>
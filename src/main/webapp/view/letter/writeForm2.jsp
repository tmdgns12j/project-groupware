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
}
</script>
</head>
<body>

<form action="letterwrite" method="post" name="f"><!-- controller -->
<br>
<br>
<br>
  <table>
   <caption>MODEL1 게시판 글쓰기</caption>
   
   <tr><td>글쓴이</td><td><input type="text" name="EML_PL_NM"></td></tr>
   <tr><td>편지번호</td><td><input type="text" name="EML_SQ"></td></tr>
   <tr><td>비밀번호</td><td><input type="text" name="EML_PL_CRS"></td></tr>
   <tr><td>제목</td><td><input type="text" name="STF_SND_SQ"></td></tr>
   <tr><td>내용</td><td><textarea rows="text" name="EML_CNT"></textarea></td></tr>
   <tr><td>첨부파일</td><td><input type="text" name="STF_RCV_SQ"></td></tr>
   <tr><td colspan="2">
     <a href="javascript:letter_submit()">[게시물등록]</a></td></tr>
  </table></form>
</body>
</html>
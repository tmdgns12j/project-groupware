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
   <caption>MODEL1 �Խ��� �۾���</caption>
   
   <tr><td>�۾���</td><td><input type="text" name="EML_PL_NM"></td></tr>
   <tr><td>������ȣ</td><td><input type="text" name="EML_SQ"></td></tr>
   <tr><td>��й�ȣ</td><td><input type="text" name="EML_PL_CRS"></td></tr>
   <tr><td>����</td><td><input type="text" name="STF_SND_SQ"></td></tr>
   <tr><td>����</td><td><textarea rows="text" name="EML_CNT"></textarea></td></tr>
   <tr><td>÷������</td><td><input type="text" name="STF_RCV_SQ"></td></tr>
   <tr><td colspan="2">
     <a href="javascript:letter_submit()">[�Խù����]</a></td></tr>
  </table></form>
</body>
</html>
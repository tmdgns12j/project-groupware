<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html><head><meta charset="EUC-KR">
<title>�Խ��� ��� ����</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css"></head>
<body><form action="reply" method="post" name="f">
<%-- ���� ���� :num  ref reflevel  refstep--%>
  <input type="hidden" name="num" value="${board.num}">
  <input type="hidden" name="ref" value="${board.ref}" >
  <input type="hidden" name="reflevel" value="${board.reflevel}" >
  <input type="hidden" name="refstep" value="${board.refstep}" >
  <table><caption>MODEL1 �Խ��� ��� ���</caption>
  <tr><td>�۾���</td><td><input type="text" name="name"></td></tr>
  <tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
  <tr><td>����</td><td><input type="text" name="subject" 
      value="RE:${board.subject}"></td></tr>
  <tr><td>����</td>
      <td><textarea name="content" rows="15"></textarea></td></tr>
  <tr><td colspan="2">
  <a href="javascript:document.f.submit()">[�亯�۵��]</a></td></tr>    
  </table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>myletter</title> 

</head>
<body>








<br><br><br><br><br><br>
   <table>      
         <tr><td>���Ϲ�ȣ</td><td>${num}</td></tr>
         <tr><td>�������</td>  
             <td>${mail.STF_SND_ID}</td></tr>
         <tr><td>�������</td>
            <td>${mail.STF_RCV_ID}</td></tr> <!-- ���������ȣ -->
         <tr><td>����</td>
            <td>${mail.MAIL_CONTENT}</td></tr> <!-- ���� -->
         <tr><td>���ϸ�</td>
            <td>
            <c:if test="${ mail.MAIL_PL_NM == null || mail.MAIL_PL_NM.trim() eq ''}">
				&nbsp; </c:if> 
		<c:if test="${ mail.MAIL_PL_NM != null && mail.MAIL_PL_NM.trim() ne ''}">		
	 <a href="<%=request.getContextPath() %>/upfile/${mail.MAIL_PL_NM}">${mail.MAIL_PL_NM}</a>
				</c:if></td></tr> <!-- ���ϸ� -->
         <tr><td>���ϰ��</td>
            <td>${mail.MAIL_PL_CRS}</td></tr> <!-- ���ϰ�� -->
         <tr><td>���Žð�</td>
            <td>${mail.RCV_DT}  </td></tr>
         <tr><td>�߽Žð�</td> 
            <td>${mail.SND_DT}  </td></tr> <!-- �߽Žð� -->
            
   </table>
   <input type="button" value="�޽���" onclick="location.href='mail'">
   <!-- <button type="submit" class="btn">    </button> -->
</body>
</html>
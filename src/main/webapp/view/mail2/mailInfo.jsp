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
         <tr><td>메일번호</td><td>${num}</td></tr>
         <tr><td>보낸사원</td>  
             <td>${mail.STF_SND_ID}</td></tr>
         <tr><td>받은사원</td>
            <td>${mail.STF_RCV_ID}</td></tr> <!-- 받은사원번호 -->
         <tr><td>내용</td>
            <td>${mail.MAIL_CONTENT}</td></tr> <!-- 내용 -->
         <tr><td>파일명</td>
            <td>
            <c:if test="${ mail.MAIL_PL_NM == null || mail.MAIL_PL_NM.trim() eq ''}">
				&nbsp; </c:if> 
		<c:if test="${ mail.MAIL_PL_NM != null && mail.MAIL_PL_NM.trim() ne ''}">		
	 <a href="<%=request.getContextPath() %>/upfile/${mail.MAIL_PL_NM}">${mail.MAIL_PL_NM}</a>
				</c:if></td></tr> <!-- 파일명 -->
         <tr><td>파일경로</td>
            <td>${mail.MAIL_PL_CRS}</td></tr> <!-- 파일경로 -->
         <tr><td>수신시간</td>
            <td>${mail.RCV_DT}  </td></tr>
         <tr><td>발신시간</td> 
            <td>${mail.SND_DT}  </td></tr> <!-- 발신시간 -->
            
   </table>
   <input type="button" value="메시지" onclick="location.href='mail'">
   <!-- <button type="submit" class="btn">    </button> -->
</body>
</html>
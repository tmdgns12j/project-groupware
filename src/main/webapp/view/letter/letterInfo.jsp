<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>myletter</title>
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

<style type="text/css">
.info{
	width : 1000px;
	height : 550px;
	margin : 0 auto;
}
</style>
</head>
<body>
<div class="info">
	<h3>쪽지</h3>
   <table class="w3-table-all table table-hover">  
         <%-- <tr><td>편지번호</td><td>${num}</td></tr> --%>
         <tr><td>보낸사원</td>  
             <td>${letter.STF_SND_ID}</td></tr>
         <%-- <tr><td>받은사원번호</td>
            <td>${letter.STF_RCV_SQ}</td></tr> <!-- 받은사원번호 --> --%>
         <tr><td>내용</td>
            <td>${letter.EML_CNT}</td></tr> <!-- 내용 -->
         <tr><td>파일명</td>
            <td>
            <c:if test="${ letter.EML_PL_NM == null || letter.EML_PL_NM.trim() eq ''}">
				&nbsp; </c:if> 
		<c:if test="${ letter.EML_PL_NM != null && letter.EML_PL_NM.trim() ne ''}">		
	 <a href="<%=request.getContextPath() %>/upfile/${letter.EML_PL_NM}">${letter.EML_PL_NM}</a>
				</c:if></td></tr> <!-- 파일명 -->
         <tr><td>파일경로</td>
            <td>${letter.EML_PL_CRS}</td></tr> <!-- 파일경로 -->
         <tr><td>수신시간</td>
            <td>${letter.RCV_DT}  </td></tr>
         <tr><td>발신시간</td> 
            <td>${letter.SND_DT}  </td></tr> <!-- 발신시간 -->
   </table>
   <input type="button" value="목록" onclick="location.href='letter'">
   <input type="button" onclick="location.href='letterwriteForm?name=${letter.STF_SND_ID}'" value="답장">
   <!-- <button type="submit" class="btn">    </button> -->
</div>
</body>
</html>
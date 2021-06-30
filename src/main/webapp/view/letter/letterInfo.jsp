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
	<h3>����</h3>
   <table class="w3-table-all table table-hover">  
         <%-- <tr><td>������ȣ</td><td>${num}</td></tr> --%>
         <tr><td>�������</td>  
             <td>${letter.STF_SND_ID}</td></tr>
         <%-- <tr><td>���������ȣ</td>
            <td>${letter.STF_RCV_SQ}</td></tr> <!-- ���������ȣ --> --%>
         <tr><td>����</td>
            <td>${letter.EML_CNT}</td></tr> <!-- ���� -->
         <tr><td>���ϸ�</td>
            <td>
            <c:if test="${ letter.EML_PL_NM == null || letter.EML_PL_NM.trim() eq ''}">
				&nbsp; </c:if> 
		<c:if test="${ letter.EML_PL_NM != null && letter.EML_PL_NM.trim() ne ''}">		
	 <a href="<%=request.getContextPath() %>/upfile/${letter.EML_PL_NM}">${letter.EML_PL_NM}</a>
				</c:if></td></tr> <!-- ���ϸ� -->
         <tr><td>���ϰ��</td>
            <td>${letter.EML_PL_CRS}</td></tr> <!-- ���ϰ�� -->
         <tr><td>���Žð�</td>
            <td>${letter.RCV_DT}  </td></tr>
         <tr><td>�߽Žð�</td> 
            <td>${letter.SND_DT}  </td></tr> <!-- �߽Žð� -->
   </table>
   <input type="button" value="���" onclick="location.href='letter'">
   <input type="button" onclick="location.href='letterwriteForm?name=${letter.STF_SND_ID}'" value="����">
   <!-- <button type="submit" class="btn">    </button> -->
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mailcss.css" />
</head>
<body>

	<table>
		<caption>letter ���</caption>
		<tr>
			<th>��<input id="allCheck" type="checkbox" name="allCheck"/></th>		
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>�����</th>
			<th>��ȸ��</th>
			<th>��ȸ��</th>
		</tr>
		<c:forEach var="l" items="${list}">
			<tr>
				<td>${l.EML_SQ}</td>
				<td>${l.EML_CNT}</td>
				<td>${l.EML_PL_NM}</td>
				<td>${l.EML_PL_CRS}</td>
				<td>${l.STF_SND_SQ}</td>
				<td>${l.RCV_DT}</td>
				<td>${l.STF_RCV_SQ}</td>
				<td>${l.SND_DT}</td>
				<td><br> <br> ��ȣ 
				<c:if test="${l.STF_SND_SQ eq '5'}">
         			${l.STF_SND_SQ}��
         			${l.EML_SQ}
         			${l.EML_CNT}
         			${l.EML_PL_NM}
         			${l.EML_PL_CRS}
         			${l.STF_SND_SQ}
         			</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
 <input type="button" value="�۾���"
	     onclick="location.href='<%=request.getContextPath() %>/letter/letterwriteForm'"><!-- letterwriteForm�� �Լ� -->
<%-- <h3><a href="<%=request.getContextPath()%>/letter/?id=${login}">����������</a></h3> --%>
<input type="button" value="������ ����"
	     onclick="location.href='<%=request.getContextPath() %>/letter/myletterForm'">


<h3><a href="<%=request.getContextPath()%>/letter/myletterForm?id=${login}">����</a></h3>
<h3><a href="<%=request.getContextPath()%>/letter/myletterForm2?id=${login}">����</a></h3>

</body>
</html>
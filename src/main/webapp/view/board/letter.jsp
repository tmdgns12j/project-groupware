<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>letter 목록</caption>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
			<th>조회수</th>
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
				<td><br> <br> 번호 
				<c:if test="${l.STF_SND_SQ eq '5'}">
         			${l.STF_SND_SQ}번
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

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html><html><head><meta charset="EUC-KR"><title>�Խù� �󼼺���</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/main.css">
</head><body>	<table>
		<caption>MODEL1 �Խù� �� ����</caption>
		<tr>	<td width="20%">�۾���</td>
			<td width="80%" style="text-align: left">${board.name}</td>		</tr>
		<tr>
			<td>����</td>
			<td style="text-align: left">${board.subject}</td>
		</tr>		<tr>
			<td>����</td>
			<td>
				<table style="width: 100%; height: 250px;">
					<tr><td
							style="border-width: 0px; vertical-align: top; text-align: left;">
							${board.content}</td></tr>				</table>
			</td>		</tr>		<tr>
			<td>÷������</td>
			<td style="text-align: left;">
			<c:if test="${ board.file1 == null || board.file1.trim() eq ''}">
				&nbsp; </c:if> 
		<c:if test="${ board.file1 != null && board.file1.trim() ne ''}">		
	 <a href="<%=request.getContextPath() %>/upfile/${board.file1}">${board.file1}</a>
				</c:if>	</td></tr>		<tr>
			<td colspan="2"><a href="replyForm?num=${num}">[�亯]</a> <a
				href="updateForm?num=${num}">[����]</a> <a
				href="deleteForm?num=${num}">[����]</a> <a href="list">[���]</a>
			</td>		</tr>	</table></body></html>
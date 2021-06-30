<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խù� ��� ����</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/notice2.css">

</head>
<body>
	<br>
	<br>
	<br>
	<div class="wrap">
		<div class="body">
			<h3>�����Խ���</h3>
			<table>
				<caption>${noticename}</caption>
				<c:if test="${noticecount == 0 }">
					<tr>
						<td colspan="5">��ϵ� �Խñ��� �����ϴ�.</td>
					</tr>
				</c:if>
				<c:if test="${noticecount != 0 }">
					<tr>
						<td colspan="5" style="text-align: right">�۰���:${noticecount}</td>
					</tr>
					<tr>
						<th width="8%">��ȣ</th>
						<th width="50%">����</th>
						<th width="14%">�ۼ���</th>
						<th width="17%">�����</th>
						<th width="11%">��ȸ��</th>
					</tr>
					<c:forEach var="b" items="${list}">
						<tr>
							<td class="noticenum">${noticenum}</td>
							<td class="noticesubject"><c:set var="noticenum"
									value="${noticenum-1 }" /> <c:if
									test="${b.file1 != null && !b.file1.trim() eq ''}">
									<a href="upfile/${b.file1}" style="text-decoration: none;">@</a>
								</c:if> <c:if test="${b.file1 == null || b.file1.trim() eq ''}">
     &nbsp;&nbsp;&nbsp; </c:if> <c:if test="${b.reflevel > 0}">
									<c:forEach var="i" begin="1" end="${b.reflevel-1 }">
		  
	              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      
	      </c:forEach>	       
	  ��</c:if> <a href="info?num=${b.num}">${b.subject}</a></td>
							<td class="noticename">${b.name}</td>
							<td class="regdate"><c:if test="${b.today}">
									<fmt:formatDate type="time" value="${b.regdate}" />
								</c:if> <c:if test="${!b.today}">
									<fmt:formatDate type="date" value="${b.regdate}" />
								</c:if></td>
							<td class="readcnt">d${b.readcnt}</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>

			<div>
				<c:if test="${startpage <= bottomLine}">[����] </c:if>
				<c:if test="${startpage > bottomLine}">
					<a href="list?page=${startpage - bottomLine}">[����]</a>
				</c:if>

				<c:forEach var="a" begin="${startpage}" end="${endpage}">

					<c:if test="${a==pageNum }">[${a}] </c:if>
					<c:if test="${a!=pageNum }">

						<a href="list?page=${a}">[${a}]</a>
					</c:if>
				</c:forEach>
				<c:if test="${endpage >= maxpage}">  [����]</c:if>
				<c:if test="${endpage < maxpage}">
					<a href="list?page=${startpage + bottomLine}">[����]</a>
				</c:if>
			</div>
			<div>
				<a href="writeForm">[�۾���]</a>
			</div>
		</div>
	</div>
</body>
</html>






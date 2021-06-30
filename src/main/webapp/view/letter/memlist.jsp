<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.form{
	width : 50%;
	height : 600px;
	margin : 0 auto;
}
</style>
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
</head>
<body>
<br>
<div class="form">
	<h3>사원 정보</h3>
	<button onclick="location.href='joinForm'" style="float:right;">사원등록하기</button>
	<form method="post" name="memlist" class="memlist">
		<table class="w3-table-all table table-hover">
			<tr>
               <th>이름</th>
               <th>부서</th>
               <th>직급</th>
               <th></th><th></th>
            </tr>
            <c:set var="num"   value="${num}"/>
            <c:forEach var="m" items="${list}">
                  <tr>
                  <td>${m.STF_NM}</td>
                  <td>${m.STF_ADMN}</td>
                  <td>${m.STF_DPT}</td>
                  <td><a href="memupdateForm?id=${m.STF_ID}">[수정]</a></td>
                  <td><a href="memdelete?id=${m.STF_ID}">[탈퇴]</a></td>
                  </tr>
            </c:forEach>
		</table>
	</form>
</div>
</body>
</html>
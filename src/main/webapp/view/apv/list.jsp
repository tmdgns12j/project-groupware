<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.junja{
	width : 1000px;
	height : 500px;
	border : solid 2px black;
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mailcss4.css" />
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
<script>
function gconform(no) {
	location.href="info?num="+no
}

function gconform1(no) {
	location.href="info2?num="+no
}


</script>
<body>
<br><br><br>
<div class="apv">

	<div class="apv-detail">
         <!-- Nav tabs -->
         <ul class="nav nav-pills flex-column" role="tablist">
         <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#home">결재진행</a></li>

         <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu1">결재완료</a></li>

         <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">결재목록</a></li>
         </ul>      
               
	</div>
	
	<div class="apvlist">
		<div class="tab-content">
			<div id="home" class="container tab-pane active">
				<div class="mail-send">
				<div class="apvheader">
					<h1>결재진행</h1>
					<form method="post" class="apv1" name="apv">
						<input type="button" value="쓰기" class="button"
         				onclick="location.href='<%=request.getContextPath()%>/apv/writeForm'">
				</div>
					<div class="tablescroll">
						<table   class="w3-table-all table-hover" style="cursor:pointer">
							<tr>
								<th>사원</th>
								<th>제목</th>
								<th>내용</th>
								<th>중간승인</th>
								<th>결재구분</th>
							</tr>

							<c:set var="num"   value="${num}"/> 
							<c:forEach var="j" items="${list}">
								<c:if test="${j.STF_ID==login || j.STF_MID_ID == login || j.STF_FNL_ID == login }">
								<c:if test="${j.APV_NO == null || j.APV_NO1 == null && j.APV_NO.substring(0,1) != 'X'}">
								<tr   
							
									<c:if test="${j.STF_MID_ID == login && j.APV_NO == null}">
										
											 onclick="gconform('${j.APV_SQ }')"
									</c:if>
								
										<c:if test="${j.APV_NO == 'O'}">
									<c:if test="${j.STF_FNL_ID == login}">
										<c:if test="${j.APV_NO1 == null}">
											onclick="gconform('${j.APV_SQ }')"
										</c:if>
									</c:if>
									</c:if>
									
									>
									<!-- emi_tb -->
									<td>${j.STF_ID} </td>
									<td>${j.APV_NM}</td>
									<td>${j.APV_CON}</td>
									<td>${j.APV_NO}</td>
									<td>${j.DIV_APV_SQ == 1?"월차,연차":(j.DIV_APV_SQ == 2?"휴가":"업무보고")}</td>
									
									
										<c:if test="${j.STF_MID_ID == login && j.APV_NO == null}">
									</c:if>
											<c:if test="${j.APV_NO == 'O'}">
									<c:if test="${j.STF_FNL_ID == login}">
										<c:if test="${j.APV_NO1 == null}">
										</c:if>
									</c:if>
									</c:if>
									
									</tr>
									
									
									</c:if>
								</c:if>
							</c:forEach>
						</table>
					</div>
				</form>
				</div>
			</div>
			
			<div id="menu1" class="container tab-pane fade">
				<div class="mail-send">
				<div class="apvheader">
					<h1>결재완료</h1>
					<form method="post" class="apv1" name="apv">
						<input type="button" value="쓰기" class="button"
         				onclick="location.href='<%=request.getContextPath()%>/apv/writeForm'">
				</div>
					<div class="tablescroll">
						<table class="w3-table-all table-hover" style="cursor:pointer">
							<tr>
								<th>사원</th>
								<th>최종승인자</th>
								<th>중간승인자</th>
								<th>제목</th>
								<th>중간승인</th>
								<th>최종승인</th>
								<th>결재구분</th>
								<th>최종승인</th>
							</tr>

							<c:set var="num"   value="${num}"/> 
							<c:forEach var="j" items="${list}">
								<c:if test="${j.STF_ID==login || j.STF_MID_ID == login || j.STF_FNL_ID == login }">
								<c:if test="${j.APV_NO != null && j.APV_NO1 != null || j.APV_NO.substring(0,1) == 'X'}">
									<tr onclick="gconform1('${j.APV_SQ }')"><td>${j.STF_ID} </td>
									<td>${j.STF_FNL_ID}</td> 
									<td>${j.STF_MID_ID}</td> 
									<td>${j.APV_NM}</td>
									<td>${j.APV_NO}</td>
									<td>${j.APV_NO1}</td>
									<td>${j.DIV_APV_SQ == 1?"월차,연차":(j.DIV_APV_SQ == 2?"휴가":"업무보고")}</td>
									<c:if test="${j.APV_NO == 'O' && j.APV_NO1 == 'O' }">
										<td>최종승인완료</td>
									</c:if>
									<c:if test="${j.APV_NO.substring(0,1) == 'X' || j.APV_NO1.substring(0,1) == 'X' }">
										<td>승인거부</td>
									</c:if>

									<c:if test="${j.STF_MID_ID == login && j.APV_NO == null}">
									</c:if>
											<c:if test="${j.APV_NO == 'O'}">
									<c:if test="${j.STF_FNL_ID == login}">
										<c:if test="${j.APV_NO1 == null}">
										</c:if>
									</c:if>
									</c:if>
									</tr>
									</c:if>
								</c:if>
							</c:forEach>
						</table>
					</div>
				</form>
				</div>
			</div>
			
			<div id="menu2" class="container tab-pane fade">
				<div class="mail-send">
				<div class="apvheader">
					<h1>결재목록</h1>
					<form method="post" class="apv1" name="apv">
						<input type="button" value="쓰기" class="button"
         				onclick="location.href='<%=request.getContextPath()%>/apv/writeForm'">
				</div>
					<div class="tablescroll">
						<table class="w3-table-all table-hover" style="cursor:pointer">
							<tr>
								<th>사원</th>
								<th>최종승인자</th>
								<th>중간승인자</th>
								<th>제목</th>
								<th>내용</th>
								<th>중간승인</th>
								<th>최종승인</th>
								<th>결재구분</th>
								<th>승인여부</th>
							</tr>

							<c:set var="num"   value="${num}"/> 
							<c:forEach var="j" items="${list}">
								<c:if test="${j.STF_MID_ID == login || j.STF_FNL_ID == login }">
									<tr   
									<c:if test="${j.STF_MID_ID == login && j.APV_NO == null}">
											 onclick="gconform('${j.APV_SQ }')"
									</c:if>
									<c:if test="${j.APV_NO == 'O'}">
									<c:if test="${j.STF_FNL_ID == login}">
										<c:if test="${j.APV_NO1 == null}">
											onclick="gconform('${j.APV_SQ }')"
										</c:if>
									</c:if>
									</c:if>
									
									>
									<td>${j.STF_ID} </td>
									<td>${j.STF_FNL_ID}</td> 
									<td>${j.STF_MID_ID}</td> 
									<td>${j.APV_NM}</td>
									<td>${j.APV_CON}</td>
									<td>${j.APV_NO}</td>
									<td>${j.APV_NO1}</td>
									<td>${j.DIV_APV_SQ == 1?"월차,연차":(j.DIV_APV_SQ == 2?"휴가":"업무보고")}</td>
									
									<c:if test="${j.APV_NO == 'O' && j.APV_NO1 == 'O' }">
										<td>최종승인완료</td>
									</c:if>
									<c:if test="${j.APV_NO.substring(0,1) == 'X' || j.APV_NO1.substring(0,1) == 'X' }">
										<td>승인거부</td>
									</c:if>
									<c:if test="${j.APV_NO == null || j.APV_NO1 == null && j.APV_NO.substring(0,1) != 'X'}">
										<td></td>
									</c:if>
									
									

									<c:if test="${j.STF_MID_ID == login && j.APV_NO == null}">
									</c:if>
									<c:if test="${j.APV_NO == 'O'}">
									<c:if test="${j.STF_FNL_ID == login}">
										<c:if test="${j.APV_NO1 == null}">
										</c:if>
									</c:if>
									</c:if>
									</tr>
									</c:if>
							</c:forEach>
						</table>
					</div>
				</form>
			</div>
			</div>
		</div>
</div>
</div>




</body>
</html>
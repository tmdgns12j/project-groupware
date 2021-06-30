<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
.button{
   float : right;
}
table{
   border-collapse: collapse;
   width : 100%;
   height : 100px;
   text-align: center;
   table-layout: fixed;
}
td{
   border: solid 1px grey;
}
.sign{
	width : 50%;
	height : 500px;
	margin : 0 auto;
}
</style>
<script>
function reject(no) {
   var rej = document.getElementById("freject");
   rej.style.display="block"
   document.f.num.value=no
   
   $("#button").hide();
}



</script>
</head>
<body>
<br><br><br><br><br>
<div class="w3-container" >
<div class="sign">
   <div class="list">
   	<h2>결재서류</h2>
      <table class="w3-table-all">
      	<tr><td rowspan="3" style="text-align: center; vertical-align:middle;"><h3>결재내역</h3></td><td colspan="2" style="text-align: center;">결재</td></tr>
      	<tr><td style="text-align: center;">중간승인</td><td style="text-align: center;">최종승인</td></tr>
      	<tr><td>${apv.STF_MID_ID }</td><td>${apv.STF_FNL_ID }</td></tr>
      	<tr><td style="text-align: center;">결재번호</td><td colspan="2">${apv.APV_SQ}</td></tr>
      	<tr><td style="text-align: center;">사원</td><td colspan="2">${apv.STF_ID}</td></tr>
      	<tr><td style="text-align: center;">제목</td><td colspan="2">${apv.APV_NM}</td></tr>
      	<tr><td style="text-align: center;">내용</td><td colspan="2" style="word-break:break-all;">${apv.APV_CON}</td></tr>
      </table>
   
   <div class="button">
   <c:if test="${apv.APV_NO == null }">
      <form action="update1" method="post" name = "f"  id="freject"  style="display:none">
      거절사유 : <input type="text"  name="reject"/>
              <input type="hidden"  name="num" />
      <input type="submit" value="확인"/>
      </form>
   <input type="button" onclick="location.href='update?num=${apv.APV_SQ}'" value="승인">
   <input type="button" id="button" onclick="reject('${apv.APV_SQ}')" value="거절">
   </c:if>
   <c:if test="${apv.APV_NO != null }">
      <form action="fnlupdate1" method="post" name = "f"  id="freject"  style="display:none">
      거절사유 : <input type="text"  name="reject"/>
              <input type="hidden"  name="num" />
      <input type="submit" value="확인"/>
      </form>
   <input type="button" onclick="location.href='fnlupdate?num=${apv.APV_SQ}'" value="승인">
   <input type="button" id="button" onclick="reject('${apv.APV_SQ}')" value="거절">
   </c:if>
   </div>
   </div>
   </div>
</div>
</body>
</html>
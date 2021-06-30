<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mailcss2.css" />
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
<script>
function letter_submit() {
   var f = document.f;
   f.submit();
   
   self.close();
   
}
</script>
<style type="text/css">
.write{
	width : 700px;
	height : 550px;
	margin : 0 auto;
}
.text{
	width : 90%;
}
.button{
	float: right;
}
</style>
</head>
<body>
<div class="write">
<form action="letterwrite" method="post" target="letter.jsp"
enctype="multipart/form-data" name="f"><!-- controller -->
  <h3>쪽지쓰기</h3>
  <table class="w3-table-all table table-hover">
   <caption>writeForm 게시판 글쓰기</caption>
   
   <!-- <tr><td>편지번호</td><td><input type="text" name="EML_SQ"></td></tr> -->
   <tr><td>받는사원</td><td><input type="text" class="text" name="STF_RCV_ID" value=${letter.STF_RCV_ID }></td></tr>
   <tr><td>보낸사원</td><td><input type="text" class="text" name="STF_SND_ID" value=${login } readonly></td></tr>
   <tr><td>내용</td><td><textarea rows="10" class="text" name="EML_CNT"></textarea></td></tr>
   <tr><td>파일경로</td><td><input type="text" class="text" name="EML_PL_CRS"></td></tr>
   <tr><td>파일명</td><td><input type="file" class="text" name="uploadfile"></td></tr>
   <tr><td colspan="2">
     <input type="button" value="작성완료" class="button"
         				onclick="location.href='javascript:letter_submit()'"></td></tr>
  </table></form>

</div>
</body>
</html>
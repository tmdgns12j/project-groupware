<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css"/>
<style>

</style>
<body>
<!-- Navbar -->
  <div class="hheader">
  <div class="blank"></div>
  	<c:if test="${login != null }">
    <div class="hhome" onclick="location.href='<%=request.getContextPath() %>/main/main'">HOME</div>
    <div class="hcalendar" onclick="location.href='<%=request.getContextPath() %>/calendar/calendar?id=${login}'">일정보기</div>
    <div class="hapv" onclick="location.href='<%=request.getContextPath() %>/apv/list?id=${login}'">전자결재</div>
    <div class="hmail" onclick="location.href='<%=request.getContextPath() %>/mail/mail?id=${login}'">메일</div>
    <div class="hnotice" onclick="location.href='<%=request.getContextPath() %>/notice/list?id=${login}'">공지사항</div>
    <div class="hletter" onclick="location.href='<%=request.getContextPath() %>/letter/letter'">쪽지함</div>
    <div class="blank" onclick="location.href='<%=request.getContextPath()%>/main/logout'">로그아웃</div>
    </c:if>
    <!-- <div class="w3-dropdown-hover w3-hide-small">
      <button class="w3-padding-large w3-button" title="More">MORE <i class="fa fa-caret-down"></i></button>     
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="#" class="w3-bar-item w3-button">Merchandise</a>
        <a href="#" class="w3-bar-item w3-button">Extras</a>
        <a href="#" class="w3-bar-item w3-button">Media</a>
      </div>
    </div> -->
    <!-- <a href="javascript:void(0)" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i class="fa fa-search"></i></a> -->
  </div>
</body>
</html>

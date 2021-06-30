<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR" />
<title>치킨의민족</title>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mailcss.css" />
</head>
<body>

<!-- 1번째 줄 -->
<nav id="navbar">
      <div class="navbar__logo">
         <i class="fab fa-diaspora"></i>치킨의 민족
      </div>
      <ul class="navbar__menu">
         <li class="navbar__menu__item active" onclick="">전자결재</li>
         <li class="navbar__menu__item" onclick="">전자우편</li>
         <li class="navbar__menu__item" onclick="">일정관리</li>
         <li class="navbar__menu__item" onclick="">자원관리</li>
         <li class="navbar__menu__item" onclick="">통합메시지</li>
         <li class="navbar__menu__item" onclick="">문서관리</li>
         <li class="navbar__menu__item" onclick="">게시판</li>
         
         </ul>
     </nav>
     <!-- 2번째줄 -->
     <div class="container1">
		<div class="category" onclick="">정보수정</div>
		<div class="category" onclick="">로그아웃</div>
	</div>
	
       <div class="mail">
		  <div class="mail1">
		   <div class="mail1-detail">
		    <div class="mail1-detail1">메일쓰기</div>
		     <div class="mail1-detail2">이름</div>
		      <div class="mail1-detail3">전체편지함
		           <li class="detail3-click">받은편지함</li>
		           <li class="detail3-click" >보낸편지함</li>
		           <li class="detail3-click" >임시보관함</li>
		           <li class="detail3-click">지운편지함</li>
		           <li class="detail3-click" >예약편지함</li>
		           </div>
		           <div class="mail1-detail4">
		           <li class="detail3-click">새 메일함 추가</li>
		            </div>
		   </div>
		  </div>
		  
			<div class="mail2">
			 <div class="mail-send"> 받은편지함	</div>
		
			 <div class="mail-button"> 삭제	</div>
			  <div class="mail-detail">
		        <div class="mail-detail1"></div>
		        <div class="mail-detail2">
		        <div class="detail2-button"> 답장</div>
		        </div>
		        
			</div>
	        
	     </div>
	  </div>
     
     

</body>
</html>
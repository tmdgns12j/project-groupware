<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR" />
<title>ġŲ�ǹ���</title>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mailcss.css" />
</head>
<body>

<!-- 1��° �� -->
<nav id="navbar">
      <div class="navbar__logo">
         <i class="fab fa-diaspora"></i>ġŲ�� ����
      </div>
      <ul class="navbar__menu">
         <li class="navbar__menu__item active" onclick="">���ڰ���</li>
         <li class="navbar__menu__item" onclick="">���ڿ���</li>
         <li class="navbar__menu__item" onclick="">��������</li>
         <li class="navbar__menu__item" onclick="">�ڿ�����</li>
         <li class="navbar__menu__item" onclick="">���ո޽���</li>
         <li class="navbar__menu__item" onclick="">��������</li>
         <li class="navbar__menu__item" onclick="">�Խ���</li>
         
         </ul>
     </nav>
     <!-- 2��°�� -->
     <div class="container1">
		<div class="category" onclick="">��������</div>
		<div class="category" onclick="">�α׾ƿ�</div>
	</div>
	
       <div class="mail">
		  <div class="mail1">
		   <div class="mail1-detail">
		    <div class="mail1-detail1">���Ͼ���</div>
		     <div class="mail1-detail2">�̸�</div>
		      <div class="mail1-detail3">��ü������
		           <li class="detail3-click">����������</li>
		           <li class="detail3-click" >����������</li>
		           <li class="detail3-click" >�ӽú�����</li>
		           <li class="detail3-click">����������</li>
		           <li class="detail3-click" >����������</li>
		           </div>
		           <div class="mail1-detail4">
		           <li class="detail3-click">�� ������ �߰�</li>
		            </div>
		   </div>
		  </div>
		  
			<div class="mail2">
			 <div class="mail-send"> ����������	</div>
		
			 <div class="mail-button"> ����	</div>
			  <div class="mail-detail">
		        <div class="mail-detail1"></div>
		        <div class="mail-detail2">
		        <div class="detail2-button"> ����</div>
		        </div>
		        
			</div>
	        
	     </div>
	  </div>
     
     

</body>
</html>
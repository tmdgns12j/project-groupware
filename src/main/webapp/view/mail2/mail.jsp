<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 }


function checkSelectAll()  {
 
  var chkObj = document.getElementsByName("RowCheck");
  var rowCnt = chkObj.length;

   // ��ü üũ�ڽ�
   const checkboxes 
     = document.querySelectorAll('input[name="RowCheck"]');
   // ���õ� üũ�ڽ�
   const checked 
     = document.querySelectorAll('input[name="RowCheck"]:checked');
   // select all üũ�ڽ�
   const selectAll 
     = document.querySelector('input[name="selectall"]');
   
   if(checkboxes.length === checked.length)  {
     selectAll.checked = true;
   }else {
     selectAll.checked = false;
   }

 }

 function selectAll(selectAll)  {
   const checkboxes 
      = document.getElementsByName('RowCheck');
   
   checkboxes.forEach((checkbox) => {
     checkbox.checked = selectAll.checked
   })
 }

function checkSelectAll1()  {
    
   var chkObj = document.getElementsByName("RowCheck1");
   var rowCnt = chkObj.length;
   // ��ü üũ�ڽ�
   const checkboxes 
      = document.querySelectorAll('input[name="RowCheck1"]');
   // ���õ� üũ�ڽ�
   const checked 
      = document.querySelectorAll('input[name="RowCheck1"]:checked');
   // select all üũ�ڽ�
   const selectAll1
      = document.querySelector('input[name="selectall1"]');
      
   if(checkboxes.length === checked.length)  {
      selectAll1.checked = true;
   }else {
      selectAll1.checked = false;
   }
}

function selectAll1(selectAll1)  {
   const checkboxes 
      = document.getElementsByName('RowCheck1');
  
   checkboxes.forEach((checkbox) => {
   checkbox.checked = selectAll1.checked
   })
}

</script>
</head>
<body>
<br><br><br>

<div class="mail">
   <div class="mail1">
<!-- left box -->
      <div class="mail1-detail">    
         

         <!-- Nav tabs -->
         <ul class="nav nav-pills flex-column" role="tablist">
         <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#home">����������</a></li>

         <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu1">����������</a></li>

         <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">����</a></li>
         </ul>      
               
      </div>
   </div>
   <!-- left box end -->
    <div class="mail2">
    
    <div class="mail-detail">
    <div class="mail-detail1">          
     <div class="tab-content">
   <div id="home" class="container tab-pane active">
   <div class="mail-send"><h1>����������</h1><br>
      <div class="letterwrap">
         <div class="letter">
         <form method="post" class="letter" name="mail">
         <input type="button" value="���Ͼ���" class="button"
         onclick="window.open('<%=request.getContextPath()%>/mail/mailwriteForm','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');"> 
         
            <input type="submit" value="��ü����" onclick="location.href='maildelete'">
            <input type="submit" value="����" onclick="mail.action='delete';">
            </div>
            <br> 
            <div class="table1">
            <table class="table table-hover">
               <tr>
               <th><input name="selectall" value="selectall" type="checkbox" onclick="selectAll(this)"/></th>
               <th>���Ϲ�ȣ</th>
               <th>�����ȣ</th>
               <th>�����»��</th>
               <th>�޴»��</th>
               <th>����</th>
               <th>�����ð�</th>
               <th>Ȯ��</th>
               <th>��ȸ��</th>
               </tr>
               <c:set var="num"   value="${num}"/> 
               <c:forEach var="l" items="${list}">
                  <c:if test="${l.STF_RCV_ID eq login}"><!-- id -->
                   <c:if test="${l.hidden != 'x' }">
                     <tr><!-- emi_tb -->
                     <td><input type="checkbox" name="RowCheck" value="${l.MAIL_NUM}" onclick="checkSelectAll()"/></td>
                     <td>${num}  </td>
                     <c:set var="num"  value="${num-1 }"/> <!-- ������ȣ �������� -->
                     <td>${l.MAIL_NUM} </td>
                     <td>${l.STF_SND_ID}</td> <!-- ���������ȣ -->
                     <td>${l.STF_RCV_ID}</td> <!-- ���������ȣ -->
                     <td>${l.MAIL_CONTENT}</td> <!-- ���� -->
                     <td >${l.RCV_DT}   </td> <!-- ���Žð� -->
                     
                     <c:if test="${l.MAIL_READ > 0}">
                        <td>����</td>
                     </c:if>
                      
                     <td><br> <br>
                     </td>
                     <td><a href="info?num=${l.MAIL_NUM}" >${l.MAIL_NUM}-go</a></td><!-- num�� �Խù� ��ȣ -->
                     <td>${l.hidden }</td>
                     <td>${l.hidden1 }</td>
                     </tr>
                  </c:if>
                  </c:if>
               </c:forEach>
            </table>
            
            <!-- <button type="submit" class="btn">    </button> -->
            </form>
            </div>
         </div>
      </div>
   </div>
   
   <div id="menu1" class="container tab-pane fade">
   <div class="mail-send"><h1>����������</h1><br>
      <div class="letterwrap">
         <div class="letter">
         <form method="post" class="letter1" name="mail1">
         <input type="button" value="���Ͼ���" class="button"
         onclick="window.open('<%=request.getContextPath()%>/mail/mailwriteForm','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');"> 
         
            <input type="submit" value="��ü����" onclick="location.href='maildelete'">
            <input type="submit" value="����" onclick="mail1.action='delete1';">
            </div>
            <br> 
            <div class="table1">
            <table class="table table-hover" >
               <tr>
               <th><input name="selectall1" value="selectall1" type="checkbox" onclick="selectAll1(this)"/></th>
               <th>���Ϲ�ȣ</th>
               <th>�����ȣ</th>
               <th>�����»��</th>
               <th>�޴»��</th>
               <th>����</th>
               <th>�����ð�</th>
               <th>Ȯ��</th>
               <th>��ȸ��</th>
               </tr>
               <c:set var="num"   value="${num}"/> 
               <c:forEach var="l" items="${list}">
                  <c:if test="${l.STF_SND_ID eq login}"><!-- id -->
                  <c:if test="${l.hidden1 != 'x' }">
                     <tr><!-- emi_tb -->
                     <td><input type="checkbox" name="RowCheck1" value="${l.MAIL_NUM}" onclick="checkSelectAll1()"/></td>
                     <td>${num}  </td>
                     <c:set var="num"  value="${num-1 }"/> <!-- ������ȣ �������� -->
                     <td>${l.MAIL_NUM} </td>
                     <td>${l.STF_SND_ID}</td> <!-- ���������ȣ -->
                     <td>${l.STF_RCV_ID}</td> <!-- ���������ȣ -->
                     <td>${l.MAIL_CONTENT}</td> <!-- ���� -->
                     <td >${l.RCV_DT}   </td> <!-- ���Žð� -->
                     <c:if test="${l.MAIL_READ > 0}">
                        <td>����</td>
                     </c:if>
                     
                     <td><br> <br>
                     </td>
                     <td><a href="info?num=${l.MAIL_NUM}" >${l.MAIL_NUM}-go</a></td><!-- num�� �Խù� ��ȣ -->
                     <td>${l.hidden }</td>
                     <td>${l.hidden1 }</td>
                     
                     </tr>
                     </c:if>
                  </c:if>
               </c:forEach>
            </table>
            
            <!-- <button type="submit" class="btn">    </button> -->
            </form>
            </div>
         </div>
      </div>      
   </div>
   </div>
</div>
              
         </div>
           
        </div>
        
             
  </div>

</body>
</html>
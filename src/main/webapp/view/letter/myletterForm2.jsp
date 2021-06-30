<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/Mcss.css"></head>
<title>myletter</title> 
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
   
   function deleteValue(){      
         alert("deleteValue()����");
         var url="delete";
         var valueArr = new Array();
         var list = $("input[name = 'RowCheck']");
         for(var i=0; i<list.length; i++){
            if(list[i].checked){
               alert("dsfs")
               valueArr.push(list[i].value);
            }
         }
         if(valueArr.length==0){
            alert("���õ� �� ����!");
         }
         else{
            var chk=confirm("��¥ �����Ҳ���?�̤�");
            $.ajax({
               url : url,
               type : 'POST',
               traditional: true,
               data : {
                  valueArr : valueArr
               },
               sucess : function(jdata){
                  if(jdata=1){
                     alert("��������");
                     location.replace("list")
                  }
                  else{
                     alert("��������");
                  }
               }
            });
         }
      }

   
   
</script>
</head>
<body>
<br><br><br><br><br><br>
<div class="letterwrap">
<div class="letter">
<form method="post" class="letter" name="letter">
   <table>
      <tr>
         <th><input name="selectall" value="selectall" type="checkbox" onclick="selectAll(this)"/></th>
         <th>num</th>
         <th>eml_sq</th>
         <th>send</th>
         <th>receive</th>
         <th>content</th>
         <th>file</th>
         <th>flocat</th>
         <th>rtime</th>
         <th>stime</th>
         <th>my</th>
         <th>read</th>
         
      </tr>
      <c:set var="num"   value="${num}"/> 
      <c:forEach var="l" items="${list}">
      <c:if test="${l.STF_SND_SQ eq login}"><!-- id -->
         <tr><!-- emi_tb -->
            <td><input type="checkbox" name="RowCheck" value="${l.EML_SQ}" onclick="checkSelectAll()"/></td>
            <td>${num}  </td>
            <c:set var="num"  value="${num-1 }"/> <!-- ������ȣ �������� -->
            <td>${l.EML_SQ} ������ȣ</td>
            <td>${l.STF_SND_SQ}send</td> <!-- ���������ȣ -->
            <td>${l.STF_RCV_SQ}receive</td> <!-- ���������ȣ -->
            <td>${l.EML_CNT}contet</td> <!-- ���� -->
            <td>${l.EML_PL_NM}file</td> <!-- ���ϸ� -->
            <td>${l.EML_PL_CRS}locat</td> <!-- ���ϰ�� -->
            <td class="rcv_dt">${l.RCV_DT} rectime  </td> <!-- ���Žð� -->
            <td>${l.SND_DT} sendtime </td> <!-- �߽Žð� -->
            
            <td><br> <br>
            </td>
            <%-- <td><a href="info?num=${l.readcnt}" >${l.readcnt}����</a></td> --%>
            <td><a href="info?num=${l.EML_SQ}" >${l.EML_SQ}-go</a></td><!-- num�� �Խù� ��ȣ -->
         </tr>
         </c:if>
      </c:forEach>
   </table>
   <input type="submit" value="�Խù�����" onclick="javascript:letter.action='letterdelete';">
   <input type="submit" value="���û���" onclick="javascript:letter.action='delete';">
   <!-- <button type="submit" class="btn">    </button> -->
   </form>
</div>
</div>
</body>
</html>
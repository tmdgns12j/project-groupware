<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ko">
<head>
   <title>Ķ���� </title>
   <meta http-equiv="content-type" content="text/html; charset=utf-8">
   <script type="text/javaScript" language="javascript">


   
   </script>
   <style TYPE="text/css">
      body {
      scrollbar-face-color: #F6F6F6;
      scrollbar-highlight-color: #bbbbbb;
      scrollbar-3dlight-color: #FFFFFF;
      scrollbar-shadow-color: #bbbbbb;
      scrollbar-darkshadow-color: #FFFFFF;
      scrollbar-track-color: #FFFFFF;
      scrollbar-arrow-color: #bbbbbb;
      margin-left:"0px"; margin-right:"0px"; margin-top:"0px"; margin-bottom:"0px";
      }

      td {font-family: "����"; font-size: 9pt; color:#595959;}
      th {font-family: "����"; font-size: 9pt; color:#000000;}
      select {font-family: "����"; font-size: 9pt; color:#595959;}


      .divDotText {
      overflow:hidden;
      text-overflow:ellipsis;
      }

      A:link { font-size:9pt; font-family:"����";color:#000000; text-decoration:none; }
      A:visited { font-size:9pt; font-family:"����";color:#000000; text-decoration:none; }
      A:active { font-size:9pt; font-family:"����";color:red; text-decoration:none; }
      A:hover { font-size:9pt; font-family:"����";color:red;text-decoration:none;}
      .day{
         width:100px; 
         height:30px;
         font-weight: bold;
         font-size:15px;
         font-weight:bold;
         text-align: center;
      }
      .sat{
         color:#529dbc;
      }
      .sun{
         color:red;
      }
      .today_button_div{
         float: right;
      }
      .today_button{
         width: 100px; 
         height:30px;
      }
      .calendar{
         width:80%;
         margin:auto;
      }
      .navigation{
         margin-top:100px;
         margin-bottom:30px;
         text-align: center;
         font-size: 25px;
         vertical-align: middle;
      }
      .calendar_body{
         width:100%;
         background-color: #FFFFFF;
         border:1px solid white;
         margin-bottom: 50px;
         border-collapse: collapse;
      }
      .calendar_body .today{
         border:1px solid white;
         height:120px;
         background-color:#c9c9c9;
         text-align: left;
         vertical-align: top;
      }
      .calendar_body .date{
         font-weight: bold;
         font-size: 15px;
         padding-left: 3px;
         padding-top: 3px;
      }
      .calendar_body .sat_day{
         border:1px solid white;
         height:120px;
         background-color:#EFEFEF;
         text-align:left;
         vertical-align: top;
      }
      .calendar_body .sat_day .sat{
         color: #529dbc; 
         font-weight: bold;
         font-size: 15px;
         padding-left: 3px;
         padding-top: 3px;
      }
      .calendar_body .sun_day{
         border:1px solid white;
         height:120px;
         background-color:#EFEFEF;
         text-align: left;
         vertical-align: top;
      }
      .calendar_body .sun_day .sun{
         color: red; 
         font-weight: bold;
         font-size: 15px;
         padding-left: 3px;
         padding-top: 3px;
      }
      .calendar_body .normal_day{
         border:1px solid white;
         height:120px;
         background-color:#EFEFEF;
         vertical-align: top;
         text-align: left;
      }
      .before_after_month{
         margin: 10px;
         font-weight: bold;
      }
      .before_after_year{
         font-weight: bold;
      }
      .this_month{
         margin: 10px;
      }
   </style>
</head>
<body>
<form name="calendarFrm" id="calendarFrm" action="" method="GET">

<div class="calendar" >

   <!--��¥ �׺���̼�  -->
   <div class="navigation">
      <a class="before_after_year" href="./calendar?year=${today_info.search_year-1}&month=${today_info.search_month-1}&id=${id}">
         &lt;&lt;
      <!-- ������ -->
      </a> 
      <a class="before_after_month" href="./calendar?year=${today_info.before_year}&month=${today_info.before_month}&id=${id}">
         &lt;
      <!-- ������ -->
      </a> 
      <span class="this_month">
         &nbsp;${today_info.search_year}. 
         <c:if test="${today_info.search_month<10}">0</c:if>${today_info.search_month}
      </span>
      <a class="before_after_month" href="./calendar?year=${today_info.after_year}&month=${today_info.after_month}&id=${id}">
      <!-- ������ -->
         &gt;
      </a> 
      <a class="before_after_year" href="./calendar?year=${today_info.search_year+1}&month=${today_info.search_month-1}&id=${id}">
         <!-- ������ -->
         &gt;&gt;
      </a>
   </div>

<!-- <div class="today_button_div"> -->
<!-- <input type="button" class="today_button" onclick="javascript:location.href='/calendar.do'" value="go today"/> -->
<!-- </div> -->
<table class="calendar_body">

<thead>
   <tr bgcolor="#CECECE">
      <td class="day sun" >
         ��
      </td>
      <td class="day" >
         ��
      </td>
      <td class="day" >
         ȭ
      </td>
      <td class="day" >
         ��
      </td>
      <td class="day" >
         ��
      </td>
      <td class="day" >
         ��
      </td>
      <td class="day sat" >
         ��
      </td>
   </tr>
</thead>
<tbody>
<c:forEach var="birthM" items="${birthM}" varStatus="status">
<c:set var="birthD" value="${birthD}" />
<c:set var="birthName" value="${birthName}" />
  ${birthM}�� ${birthD[status.index]}�� ${birthName[status.index]}��
</c:forEach>

   <tr>
      <c:forEach var="dateList" items="${dateList}" varStatus="date_status"> 
         <c:choose>
            <c:when test="${dateList.value=='today'}">
               <td class="today">
                  <div class="date">
                     ${dateList.date}<br>
           <c:forEach var="birthM" items="${birthM}" varStatus="status">
           <c:set var="birthD" value="${birthD}"/>
             <c:if test="${dateList.month==birthM-1 && dateList.date==birthD[status.index]}">
                   ${birthName[status.index]}�� ���� �Դϴ�
                   </c:if> 
                   </c:forEach>
                  </div>
                  <div>
                  </div>
               </td>
            </c:when>
            <c:when test="${date_status.index%7==6}">
               <td class="sat_day">
                  <div class="sat">
                     ${dateList.date}<br>
           <c:forEach var="birthM" items="${birthM}" varStatus="status">
           <c:set var="birthD" value="${birthD}"/>
             <c:if test="${dateList.month==birthM-1 && dateList.date==birthD[status.index]}">
                   ${birthName[status.index]}�� ���� �Դϴ�
                   </c:if> 
                   </c:forEach>
                  </div>
                  <div>
                  </div>
               </td>
            </c:when>
            <c:when test="${date_status.index%7==0}">
   </tr>
   <tr>   
      <td class="sun_day">
         <div class="sun">
           ${dateList.date}<br>
           <c:forEach var="birthM" items="${birthM}" varStatus="status">
           <c:set var="birthD" value="${birthD}"/>
             <c:if test="${dateList.month==birthM-1 && dateList.date==birthD[status.index]}">
                   ${birthName[status.index]}�� ���� �Դϴ�
                   </c:if> 
                   </c:forEach>     
         </div>
         <div>
         </div>
      </td>
            </c:when>
            <c:otherwise>
      <td class="normal_day">
         <div class="date">
        
            ${dateList.date}<br>
           <c:forEach var="birthM" items="${birthM}" varStatus="status">
           <c:set var="birthD" value="${birthD}"/>
             <c:if test="${dateList.month==birthM-1 && dateList.date==birthD[status.index]}">
                   ${birthName[status.index]}�� ���� �Դϴ�
                   </c:if> 
                   </c:forEach>
         </div>
         <div>
         
         </div>
      </td>
            </c:otherwise>
         </c:choose>
      </c:forEach>
</tbody>

</table>
</div>
</form>
</body>
</html>
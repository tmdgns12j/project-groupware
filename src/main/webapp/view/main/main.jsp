<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/Mcss6.css" />
<!-- <meta charset="EUC-KR"> -->
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javaScript" language="javascript">
   </script>
<title>main</title>
</head>
<body>
	<div class="bodywrap">
		<div class="body">
			<div class="leftwrap">
				<div class="leftcard1">
				<div class="leftcardI1">
				</div>
				<div class="leftcardI2">
				<input type="button" value="출근" onclick="location.href='<%=request.getContextPath()%>/commute/start'">
				
				
				<input type="button" value="퇴근" onclick="location.href='<%=request.getContextPath()%>/commute/end'">
				
				</div>
				<div>${aaa}</div>
				</div>
				<div class="leftcard2">
				<c:if test="${login eq 'admin'}">
					<h3><a href="<%=request.getContextPath()%>/letter/memlist">회원조회하기</a></h3>
				</c:if>
				</div>
			</div>
			<div class="midbody">
				<div class="card1">
					<div class="letter">받은쪽지</div>
					<div class="lcontent">
					<div class="table1">
            <table class="mletter">
               <tr>
               
               <th>보낸사람</th>
               
               <th>내용</th>
               <th>받은날짜</th>
               <th>확인</th>
               </tr>
               <c:set var="num"   value="${num}"/> 
               <c:forEach var="l" items="${list}">
                  <c:if test="${l.STF_RCV_ID eq login}"><!-- id -->
                  	<c:if test="${l.hidden != 'x' }">
                     <tr><!-- emi_tb -->
                     
                     <c:set var="num"  value="${num-1 }"/> <!-- 편지번호 내림차순 -->
                     <td>${l.STF_SND_ID}</td> <!-- 보낸사원번호 -->
                     
                     <td><a href="info?num=${l.EML_SQ}">${l.EML_CNT}</a></td> <!-- 내용 -->
                     <td ><fmt:formatDate type="date" value="${l.RCV_DT}"/></td> <!-- 수신시간 -->
                     <c:if test="${l.EML_READ > 0}">
                        <td>읽음</td>
                     </c:if>
                     <c:if test="${l.EML_READ <= 0}">
                        <td>안읽음</td>
                     </c:if>
                     
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
				<div class="card2">
					<div class="recent">최근공지</div>
					<div class="rcontent">
					<div class="not">
					<table class="not">
				<caption>${noticename}</caption>
				<c:if test="${noticecount == 0 }">
					<tr>
						<td colspan="5">등록된 게시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${noticecount != 0 }">
					<tr>
						<th width="10%">번호</th>
						<th width="45%">제목</th>
						<th width="15%">작성자</th>
						<th width="15%">등록일</th>
						<th width="15%">조회수</th>
					</tr>
					<c:forEach var="b" items="${nlist}">
						<tr>
							<td class="noticenum">${noticenum}</td>
							<td class="noticesubject"><c:set var="noticenum"
									value="${noticenum-1 }" /> <c:if
									test="${b.file1 != null && !b.file1.trim() eq ''}">
									<a href="upfile/${b.file1}" style="text-decoration: none;">@</a>
								</c:if> <c:if test="${b.file1 == null || b.file1.trim() eq ''}">
     &nbsp;&nbsp;&nbsp; </c:if> <c:if test="${b.reflevel > 0}">
									<c:forEach var="i" begin="1" end="${b.reflevel-1 }">
		  
	              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      
	      </c:forEach>	       
	  └</c:if> <a href="info?num=${b.num}">${b.subject}</a></td>
							<td class="noticename">${b.name}</td>
							<td class="regdate"><c:if test="${b.today}">
									<fmt:formatDate type="time" value="${b.regdate}" />
								</c:if> <c:if test="${!b.today}">
									<fmt:formatDate type="date" value="${b.regdate}" />
								</c:if></td>
							<td class="readcnt">${b.readcnt}</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			</div>
					</div>
				</div>
			</div>
			<div class="rightwrap">
			<div class="calender">
			<form name="calendarFrm" id="calendarFrm" action="" method="GET">

<div class="cal">
   <!--날짜 네비게이션  -->
   <div class="navigation">
      <a class="before_after_year" href="./main?year=${today_info.search_year-1}&month=${today_info.search_month-1}&id=${id}">
         &lt;&lt;
      <!-- 이전해 -->
      </a> 
      <a class="before_after_month" href="./main?year=${today_info.before_year}&month=${today_info.before_month}&id=${id}">
         &lt;
      <!-- 이전달 -->
      </a> 
      <span class="this_month">
         &nbsp;${today_info.search_year}. 
         <c:if test="${today_info.search_month<10}">0</c:if>${today_info.search_month}
      </span>
      <a class="before_after_month" href="./main?year=${today_info.after_year}&month=${today_info.after_month}&id=${id}">
      <!-- 다음달 -->
         &gt;
      </a> 
      <a class="before_after_year" href="./main?year=${today_info.search_year+1}&month=${today_info.search_month-1}&id=${id}">
         <!-- 다음해 -->
         &gt;&gt;
      </a>
   </div>

<!-- <div class="today_button_div"> -->
<!-- <input type="button" class="today_button" onclick="javascript:location.href='/calendar.do'" value="go today"/> -->
<!-- </div> -->
<table class="calendar_body">
<tbody>
   <tr>
      <td class="day sun" >
         일
      </td>
      <td class="day" >
         월
      </td>
      <td class="day" >
         화
      </td>
      <td class="day" >
         수
      </td>
      <td class="day" >
         목
      </td>
      <td class="day" >
         금
      </td>
      <td class="day sat" >
         토
      </td>
   </tr>
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
                   생일 입니다
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
                   생일 입니다
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
                   생일 입니다
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
                   생일 입니다
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
</div>
</div>
</div>
</div>
</body>
</html>
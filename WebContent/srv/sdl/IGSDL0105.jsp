<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.*"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<html:html>
<base target="_self" >
<bean:define id="id" value="IGSDL0105" toScope="request" />
<bean:define id="title" value="日期选择画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
<title>增加任务</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/calendar.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
function back(year,month){
	var form = document.getElementById("submitForm");
	form.action="IGSDL0105_Disp.do?forward=back&year=" + year + "&month=" + month;
	form.submit();
}

function next(year,month){
	var form = document.getElementById("submitForm");
	form.action="IGSDL0105_Disp.do?forward=next&year=" + year + "&month=" + month;
	form.submit();
}

function goPage(date){
	var form = document.getElementById("submitForm");
	if(!checkDateByContent("<%=IGStringUtils.getCurrentDate() %>",date)){
		alert("请选择‘<%=IGStringUtils.getCurrentDate() %>’之后的日期！");
	}else{
		form.action="IGSDL0106_Disp.do?date=" + date; 
		form.submit();
	}
	
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<div id="container">
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>      
<%!String days[];%>
<%
	days = new String[42];
	for (int i = 0; i < 42; i++) {
		days[i] = "";
	}
%>
<%
	GregorianCalendar currentDay = new GregorianCalendar();
	int today = currentDay.get(Calendar.DAY_OF_MONTH);
	int month = currentDay.get(Calendar.MONTH);
	int year = currentDay.get(Calendar.YEAR);
	
	Integer showYear = (Integer) request.getAttribute("year");
	Integer showMonth = (Integer) request.getAttribute("month");
	
	int calendarYear = (showYear == null)?year:showYear;
	int calendarMonth = (showMonth == null)?month:showMonth;

	Calendar thisMonth = Calendar.getInstance();
	thisMonth.set(Calendar.MONTH, calendarMonth);
	thisMonth.set(Calendar.YEAR, calendarYear);
	thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
	thisMonth.set(Calendar.DAY_OF_MONTH, 1);
	int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
	int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
	for (int i = 0; i < maxIndex; i++) {
		days[firstIndex + i] = String.valueOf(i + 1);
	}
%>
<form id="submitForm" method="post" >
<div id="calendar">
<table>
	<div class="change_month">
		<span style="float: right;"><%=year%>年<%=month + 1%>月<%=today%>日</span>
		<span><a href="#" onclick="back(<%=calendarYear%>,<%=calendarMonth%>);"><img src="images/up.gif" alt="上月" border="0" /></a></span>
		<span><a href="#" onclick="next(<%=calendarYear%>,<%=calendarMonth%>);"><img src="images/next.gif" alt="下月" border="0" /></a></span>
		<%=calendarYear%>年<%=calendarMonth + 1%>月
	</div>
	<ul class="week_name">
		<li style="background: #D0E1FF;">星期日</li>
		<li>星期一</li>
		<li>星期二</li>
		<li>星期三</li>
		<li>星期四</li>
		<li>星期五</li>
		<li style="background: #EAFDC1;">星期六</li>
	</ul>
	<ul class="week_day">
		<%
			for (int j = 0; j < 6; j++) {
		%>
		<%
				String todayYMD = year + "/" + month + "/" + today;
				for (int i = j * 7; i < (j + 1) * 7; i++) {
				String day = calendarYear + "/" + calendarMonth + "/" + (i - firstIndex + 1);
		%>
		<li
			<%String month_split="/";
		if((calendarMonth+1)<10){
			month_split="/0";
		}
		String day_split="/";
		if(((i - firstIndex + 1))<10){
			day_split="/0";
		} %>
		<%if(!"".equals(days[i])){ %>
		onclick="goPage('<%=calendarYear + month_split + (calendarMonth+1) + day_split + (i - firstIndex + 1) %>')" 
		style="cursor: hand"
		<%} %>
		<%if (todayYMD.equals(day)) {%> 
			class="today" 
		<%}%> <%if (i == j * 7) {%>
			class="sunday" 
		<%}%> <%if (i == (j + 1) * 7 - 1) {%> 
			class="saturday" 
		<%}%>>
		
		<%=days[i]%></li>
		<%
				}
			}
		%>
	</ul>
</table>
</div>
</form>
</div>
</div>
</div>
</div>
</body>
</html:html>
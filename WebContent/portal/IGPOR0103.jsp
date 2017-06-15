<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.vo.IGCOM03041VO"%>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG677Info"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.ArrayList"%>
<%
	Integer showYear = (Integer) request.getAttribute("year");
	Integer showMonth = (Integer) request.getAttribute("month");
	IGCOM03041VO igcom03041VO = (IGCOM03041VO)request.getAttribute("igcom03041VO");

	int num = 0;//我的工作已显示的条数
	int groupnum = 0;//相关工作已显示的条数
	String contextPath = request.getContextPath();
	String page_width = null;
	if(null!=request.getAttribute("page_width")){
		page_width = request.getAttribute("page_width").toString();
	}
	
	String screen=(request.getParameter("screen_width")==null?"1280":request.getParameter("screen_width"));
	if(page_width!=null){
		screen = page_width;
	}
	int screen_width=Integer.parseInt(screen);
	
%>
<html:html>
<bean:define id="id" value="IGPOR0103" toScope="request" />
<bean:define id="title" toScope="request" >
<bean:message bundle="comResources" key="ietitle.IGPOR0103"/>
</bean:define>
<script src="<html:rewrite forward='common.js'/>"></script>
<script src="<html:rewrite forward='FusionCharts.js'/>"></script>
<link type="text/css" href="css/portal.css" rel="stylesheet" />

<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script> 

<script type="text/javascript">
function backMonth(year,month){
	
	var curmonth = month;
	var curyear = year;
    if(curmonth < 1){
    	curmonth = 12;
    	curyear = year - 1;
    }
	if(curmonth < 10){
		curmonth = "0" + curmonth;
	}
	 window.location="IGPOR0103_DW.do?forward=back&year=" + year + "&month=" + month + "&curmonth=" + curmonth + "&curyear=" + curyear;
}

function nextMonth(year,month){
	var curmonth = month + 2;
	var curyear = year;
	if(curmonth > 12){
		curmonth = 1;
		curyear = year + 1;
	}
	if(curmonth < 10){
		curmonth = "0" + curmonth;
	}
    window.location="IGPOR0103_DW.do?forward=next&year=" + year + "&month=" + month + "&curmonth=" + curmonth + "&curyear=" + curyear;
}

function goPage(year,month,date){
	if(month.length < 2){
		month = "0" + month;
	}
	if(date < 10){
		date = "0" + date;
	}
	//window.showModalDialog("IGSDL0110_SOC.do?date=" + year + "/" + month + "/" + date,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");	
	window.showModalDialog(getAppRootUrl() + "/IGCOM0401.do?prtype=WA&ptid=7&path=IGSDL0110_SOC&date="+ + year + "/" + month + "/" + date,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");
    window.location="IGPOR0103_DW.do?forward=now&year=" + year + "&month=" + month + "&curmonth=" + month + "&curyear=" + year;;
}

//没有计划的日期跳转到服务策略登记页面
function goPageSDL(year,month,date){
	
	var form = document.getElementById("submitForm");
	if(month.length < 2){
		month = "0" + month;
	}
	if(date < 10){
		date = "0" + date;
	}
	//window.showModalDialog("IGMTP0103_Disp_SOC.do?date=" + year + "/" + month + "/" + date,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");
	window.showModalDialog(getAppRootUrl() + "/IGCOM0401.do?prtype=WA&ptid=7&path=IGMTP0103_Disp_SOC&date="+ + year + "/" + month + "/" + date,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");
	window.location="IGPOR0103_DW.do?forward=now&year=" + year + "&month=" + month + "&curmonth=" + month + "&curyear=" + year;;
}

</script>
<body style="margin:0px;font-family: Arial, Helvetica, sans-serif;">
   <div id="portal_main" style="width:315px;height:160px;float:left;margin-left:0px;margin-top:0px;">
        <div id="box2">
        <h1><bean:message bundle="comResources" key="legend.IGPOR0103.001"/></h1>
           <html:form styleId="submitForm" method="get">
			<%!String days[];%> <%
				days = new String[42];
				for (int i = 0; i < 42; i++) {
					days[i] = "";
				}
			%> <%
			
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				boolean isafterDeate = false;
				GregorianCalendar currentDay = new GregorianCalendar();
				int today = currentDay.get(Calendar.DAY_OF_MONTH);
				int month = currentDay.get(Calendar.MONTH);
				int year = currentDay.get(Calendar.YEAR);
				
				
				
				int calendarYear = (showYear == null)?year:showYear;
				int calendarMonth = (showMonth == null)?month:showMonth;
			
				Calendar thisMonth = Calendar.getInstance();
				thisMonth.set(Calendar.MONTH, calendarMonth);
				thisMonth.set(Calendar.YEAR, calendarYear);
				thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
				thisMonth.set(Calendar.DAY_OF_MONTH, 1);
				
				
				int thistoday = thisMonth.get(Calendar.DAY_OF_MONTH);
				int thismonth = thisMonth.get(Calendar.MONTH);
				int thisyear = thisMonth.get(Calendar.YEAR);
				
				Calendar backCal = Calendar.getInstance();
				backCal.set(Calendar.MONTH, calendarMonth);
				backCal.set(Calendar.YEAR, calendarYear);
				backCal.setFirstDayOfWeek(Calendar.SUNDAY);
				backCal.set(Calendar.DAY_OF_MONTH, 1);
				
				Calendar nextCal = Calendar.getInstance();
				nextCal.set(Calendar.MONTH, calendarMonth);
				nextCal.set(Calendar.YEAR, calendarYear);
				nextCal.setFirstDayOfWeek(Calendar.SUNDAY);
				nextCal.set(Calendar.DAY_OF_MONTH, 1);
				
				backCal.set(Calendar.MONDAY,backCal.get(Calendar.MONDAY)-1);  
				nextCal.set(Calendar.MONDAY,backCal.get(Calendar.MONDAY)+1);  
				
				int backCalMaxDay = backCal.getActualMaximum(Calendar.DAY_OF_MONTH);
				int nextCalMaxDay = backCal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				
				int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
				int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

				int linkIndex = maxIndex+firstIndex;
				for(int i = 0; i < days.length-linkIndex; i++){
					days[(linkIndex)+i] = "<span class=\"gray\">"+String.valueOf(i+1)+"</span>";
				}
				
				for(int i = 0; i < firstIndex; i++){
					days[(firstIndex-1)-i] = "<span class=\"gray\">"+String.valueOf(backCalMaxDay-i)+"</span>";
				}
				
				for (int i = 0; i < maxIndex; i++) {
					days[firstIndex + i] = String.valueOf(i + 1);
				}
			%>
	<table width="244" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top: 10px;">
	<tr>
		<td>
		<table width="90" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<tr>
				<td width="15"><a href="javascript:backMonth(<%=calendarYear%>,<%=calendarMonth%>)"><img
					src="images/8.gif" alt='<bean:message bundle="comResources" key="img.IGPOR0103.backmonth"/>' border="0" /></a></td>
				<td width="60" align="center"><%=calendarYear%><bean:message bundle="comResources" key="label.IGPOR0103.year"/><%=calendarMonth + 1%><bean:message bundle="comResources" key="label.IGPOR0103.month"/></td>
				<td width="15"><a href="javascript:nextMonth(<%=calendarYear%>,<%=calendarMonth%>);"><img
					src="images/9.gif" alt='<bean:message bundle="comResources" key="img.IGPOR0103.nextmonth"/>' border="0" /></a></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<table width="294" border="0" cellpadding="0" cellspacing="1"
			class="change_date" style="margin-top: 5px;">
			<tr>
				<th><bean:message bundle="comResources" key="title.IGPOR0103.sun"/></th>
				<th><bean:message bundle="comResources" key="title.IGPOR0103.one"/></th>
				<th><bean:message bundle="comResources" key="title.IGPOR0103.two"/></th>
				<th><bean:message bundle="comResources" key="title.IGPOR0103.three"/></th>
				<th><bean:message bundle="comResources" key="title.IGPOR0103.four"/></th>
				<th><bean:message bundle="comResources" key="title.IGPOR0103.five"/></th>
				<th><bean:message bundle="comResources" key="title.IGPOR0103.six"/></th>
			</tr>

			<%
						for (int j = 0; j < 6; j++) {
					%>
			<tr>
				<%
							String todayYMD = year + "-" + month + "-" + today;

				

				
							for (int i = j * 7; i < (j + 1) * 7; i++) {
							String day = calendarYear + "/" + calendarMonth + "/" + (i - firstIndex + 1);
							String month_split="/";
							if((calendarMonth+1)<10){
								month_split="/0";
							}
							String day_split="/";
							if(((i - firstIndex + 1))<10){
								day_split="/0";
								
							
					}

					String thistodayYMD= thisyear + "-" + thismonth + "-" + days[i];
					String sfdate= thisyear + "-" + (thismonth+1) + "-" + days[i];
					String mapDay = days[i];
					String mapMonth = String.valueOf(thismonth+1);
					
					if(days[i].length()<2){
						mapDay = "0"+days[i];
					}
					if(mapMonth.length() <2){
						mapMonth = "0"+mapMonth;
					}
					String mapDate = thisyear + "/" + mapMonth + "/" + mapDay;
					if(thistodayYMD.length() >10){
						isafterDeate = false;
					}else{
						Date sdate = sf.parse(sfdate);
						isafterDeate = sdate.before(new Date());
					}
					if(!thistodayYMD.equals(todayYMD)){
					%>
				<td bgcolor="#FFFFFF" 
				
				<%if((days[i].length()<3) && isafterDeate){ %>
					onclick="goPage('<%=calendarYear%>', '<%= (calendarMonth+1)%>', <%= (i - firstIndex + 1)%>)"
					style="cursor: hand"
					
					<%}else{
						if((days[i].length()<3)  && ("red".equals(((HashMap)request.getAttribute("dwmap")).get(mapDate)))){  %>
							onclick="goPage('<%=calendarYear%>', '<%= (calendarMonth+1)%>', <%= (i - firstIndex + 1)%>)"
							style="cursor: hand" 
					<%}else if((days[i].length()<3)  && (!"red".equals(((HashMap)request.getAttribute("dwmap")).get(mapDate)))){%>
							onclick="goPageSDL('<%=calendarYear%>', '<%= (calendarMonth+1)%>', <%= (i - firstIndex + 1)%>)"
							style="cursor: hand" 

					<%}} %>
					
					
					>
				<% }else{%>
				<td bgcolor="#e3efff" <%if((days[i].length()<3) && ("red".equals(((HashMap)request.getAttribute("dwmap")).get(mapDate)))){ %>
					onclick="goPage('<%=calendarYear%>', '<%= (calendarMonth+1)%>', <%= (i - firstIndex + 1)%>)"
					style="cursor: hand"
					
					<%}else if((days[i].length()<3) && (!"red".equals(((HashMap)request.getAttribute("dwmap")).get(mapDate)))){  %>
					onclick="goPageSDL('<%=calendarYear%>', '<%= (calendarMonth+1)%>', <%= (i - firstIndex + 1)%>)"
					style="cursor: hand"  <%} %>>
					<%}%>
				<%if ("red".equals(((HashMap)request.getAttribute("dwmap")).get(mapDate))) {%>
				<span style="color: red"> <%}else{%> 
				<span> <%}%><%=days[i]%></span>&nbsp;</td>
				<%}%>
			</tr>
			<% } %>
		</table>
		</td>
	</tr>
</table>
</html:form>
</div>
         <div id="box5">
        		<h1><bean:message bundle="comResources" key="legend.IGPOR0103.002"/></h1>
	            <div id="chartdiv5" align="center" style="margin-top:20px;">
	            <div id="socchartdiv" align="center" style="margin-top: 1px">
					<script type="text/javascript">
					   	var socxml="";
					   	function getSocXmlInfo(){
					 	  var temp = "<%=igcom03041VO.getSocxml() %>";
					 	  
					 	  if(null!=temp && temp!=""){
					 		 socxml=temp;
					 	  }
					   	}
					   	getSocXmlInfo();
					   	if(null!=socxml && socxml!=""){
					       var socChart = new FusionCharts("images/Column2D.swf", "ChartId", "300", "160", "0", "0");
					       socChart.setDataXML(socxml);		   
					       socChart.render("socchartdiv");
					   	}
				 	</script>
			 	</div>
	        	</div>
         </div>
     </div>    
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.scheduling.vo.IGSCH01011VO"%>
<%@ page import="com.deliverik.infogovernor.scheduling.model.QuartzJobs"%>
<html:html>
<!--javascript-->
<script type="text/javascript">



function checkForm(){
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}

function showCustomDate(){
	var periodTypes = document.getElementsByName("periodType");
	var flag = false;
	for(var i = 0; i < periodTypes.length; i++){
		if(periodTypes[i].checked && periodTypes[i].value == "custom"){
			flag = true;
			break;
		}
	}
	if(flag){
		document.getElementById("customDate").disabled = ""; 
	}else{
		document.getElementById("customDate").disabled = "disabled"; 
		document.getElementById("customDate").value = "";
	}
	
}
</script>
<bean:define id="id" value="IGSDL0113" toScope="request" />
<bean:define id="title" value="修改定时任务" toScope="request" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<%
IGSCH01011VO vo = (IGSCH01011VO)request.getAttribute("vo");
QuartzJobs quartzJobs = vo.getQuartzJobs();
String cron = quartzJobs.getQjtricron();

String hour = cron.split(" ")[2];
String minute = cron.split(" ")[1];
int iHour = Integer.valueOf(hour);
int iMinute = Integer.valueOf(minute);

%>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<div id="container">
<!--container 左菜单 右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
          <div class="back"><a href="IGSDL0110_BACK.do" target="_self">返回</a></div>
    </div>
        <div id="formwrapper">
		<html:form action="/IGSDL0111_ModifyOk" onsubmit="return checkSubmit(this);">
		<ig:message />
       <fieldset>
        <legend>任务信息</legend>
       <div>
            <label for="Name"><strong>执行日期</strong>：</label>
             <html:text property="qjcrttime" value="<%=quartzJobs.getQjcrttime().trim() %>" 
             errorStyleClass="inputError imeDisabled" size="16"  readonly="true"/>
             <img src="images/date.gif" align="middle" onclick="calendar($('qjcrttime'))"
				border="0" style="cursor: hand" />
          <br />
       </div>
       
        <div>
            <label for="Name"><strong>执行时间</strong>：</label>
            <select name="exeHour">
            <%for(int i = 0; i < 24; i++){ 
            	if(i<10){%>
            	<option value='<%="0"+String.valueOf(i) %>' <%=i==iHour?"selected=\"selected\"":"" %>><%="0"+String.valueOf(i) %></option>
            <%} else{%>
            	<option value="<%=String.valueOf(i) %>" <%=i==iHour?"selected=\"selected\"":"" %>><%=String.valueOf(i) %></option>
            <%}}%>
            
          </select>时
           <select name="exeMinute">
           <%for(int i = 0; i < 60; i++){
            	if(i<10){%>
            	<option value='<%="0"+String.valueOf(i) %>' <%=i==iMinute?"selected=\"selected\"":"" %>><%="0"+String.valueOf(i) %></option>
            <%} else{%>
            	<option value="<%=String.valueOf(i) %>" <%=i==iMinute?"selected=\"selected\"":"" %>><%=String.valueOf(i) %></option>
            <%}}%>
          </select>分
          <br />
       </div>
       
    </fieldset>
    
    <div class="enter">
    
    <html:hidden property="qjid" value="<%=String.valueOf(quartzJobs.getQjid()) %>"/>
    <html:hidden property="periodType" value="once"/>
    <html:hidden property="qjendtime" value=""/>
    
    <html:submit styleClass="button" value="提交" onclick="return checkForm();" />
	<html:reset styleClass="button" value="重置" /></div>
    </html:form>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>
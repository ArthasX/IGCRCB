<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.mtp.vo.IGMTP01051VO"%>
<%@ page import="com.deliverik.infogovernor.scheduling.model.QuartzJobs"%>
<%@ page import="com.deliverik.infogovernor.mtp.form.IGMTP0106Form"%>
<html:html>
<base target="_self" >
<!--javascript-->
<script type="text/javascript">


function checkForm(){
	if($F('qjendtime')==""){
		alert("请选择结束时间！");
		return false;
	}
	if(!checkDateByContent($F('qjcrttime'),$F('qjendtime'))){
		alert("结束时间必须晚于开始时间！");
		return false;
	}
	if(confirm("您是否确认提交?")){
		return true;
	}
	return false;
}
/*
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
	
}*/

</script>
<bean:define id="id" value="IGMTP0105" toScope="request" />
<bean:define id="title" value="修改定时任务" toScope="request" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<%
IGMTP01051VO vo = (IGMTP01051VO)request.getAttribute("vo");
QuartzJobs quartzJobs = vo.getQuartzJobs();
String cron = quartzJobs.getQjtricron();
String hour = cron.split(" ")[2];
int qjhour = Integer.valueOf(hour);
String minute = cron.split(" ")[1];
int qjminute = Integer.valueOf(minute);
String day = null;
String quarterChecked = "";
String temp_periodType="";
if(cron.contains("/")){
	quarterChecked = "checked=\"checked\"";
	day = cron.split("/")[1].split(" ")[0];
}else{
	day = cron.split(" ")[3];
}
String dayChecked = "";
String weekChecked = "";
String monthChecked = "";
if(!"?".equals(day) && "*".equals(day)){
	dayChecked = "checked=\"checked\"";
	temp_periodType = "day";
}else if("?".equals(day)){
	weekChecked = "checked=\"checked\"";
	temp_periodType = "week";
}else {
	if("".equals(quarterChecked)){
		monthChecked = "checked=\"checked\"";
		temp_periodType = "month";
	}
}

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
        <p class="fonts1">日常工作计划修改</p>
          <div class="back"><a href="IGSDL0110_BACK_SOC.do">返回</a></div>
    </div>
        <div id="formwrapper">
		<html:form action="/IGMTP0106_SOC" onsubmit="return checkSubmit(this);">
		<ig:message />
       <fieldset>
        <legend>任务信息</legend>
         <div>
            <label for="Name"><strong>任务名称</strong>：</label>
            <p class="p2" >
            	 &nbsp;&nbsp;<bean:write name="vo" property="quartzJobs.qjname" />
            </p>
            <input type="hidden" name="qjname" value="${vo.quartzJobs.qjname }"/>
            
          <br />
       </div>
        <div>
            <label for="Name"><strong>任务类型</strong>：</label>
            <input type="hidden" name="qjtype" value="${vo.quartzJobs.qjtype }"/>
            <logic:equal name="vo" property="quartzJobs.qjtype" value="W">
            		<p class="p2" >
            			&nbsp;&nbsp;工作
            		</p>
            </logic:equal>
            <logic:notEqual name="vo" property="quartzJobs.qjtype" value="W">
            		<p class="p2" >
            			&nbsp;&nbsp;短信
            		</p>
            </logic:notEqual>
          <br />
       </div>
        <div>
            <label for="Name"><strong>任务描述</strong>：</label>
            <p class="p2" >
            	 &nbsp;&nbsp;<bean:write name="vo" property="quartzJobs.qjdesc" />
            </p>
           
            <input type="hidden" name="qjtype" value="${vo.quartzJobs.qjdesc }"/>
            
          <br />
       </div>
       <div>
            <label for="Name"><strong>开始时间</strong>：</label>
             <p class="p2" >
             	&nbsp;&nbsp;<bean:write name="vo" property="quartzJobs.qjcrttime" />
             </p>
            <input type="hidden" name="qjcrttime" value="${vo.quartzJobs.qjcrttime }"/>
            
          <br />
       </div>
       
       <div>
            <label for="Name"><span class="red">*</span><strong>结束时间</strong>：</label>
            <html:text property="qjendtime" styleId="qjendtime" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" value="<%=quartzJobs.getQjendtime() %>"/>
			<img src="images/date.gif" align="middle" onclick="calendar($('qjendtime'))"
			border="0" style="cursor: hand" /><br />
       </div>
       
        <div>
            <label for="Name"><strong>执行时间</strong>：</label>
            <select name="qjhour">
            <%for(int i = 0; i < 24; i++){ 
            	if(i<10){%>
            	<option value='<%="0"+String.valueOf(i) %>' <%=i==qjhour?"selected=\"selected\"":"" %>><%="0"+String.valueOf(i) %></option>
            <%} else{%>
            	<option value="<%=String.valueOf(i) %>" <%=i==qjhour?"selected=\"selected\"":"" %>><%=String.valueOf(i) %></option>
            <%}}%>
            
          </select>时
           <select name="qjminute">
           <%for(int i = 0; i < 60; i++){
            	if(i<10){%>
            	<option value='<%="0"+String.valueOf(i) %>' <%=i==qjminute?"selected=\"selected\"":"" %>><%="0"+String.valueOf(i) %></option>
            <%} else{%>
            	<option value="<%=String.valueOf(i) %>" <%=i==qjminute?"selected=\"selected\"":"" %>><%=String.valueOf(i) %></option>
            <%}}%>
          </select>分
          <br />
       </div>
       
       <html:hidden property="qjperiodinfo" value="${vo.quartzJobs.qjperiodinfo }"/>
<!--       <div>-->
<!--          <label for="Name"><strong>周期类型</strong>：</label>-->
<!--          <input name="periodType" type="radio" id="week" value="day" <%=dayChecked %>  />日-->
<!--           <input name="periodType" type="radio" id="week" value="week" <%=weekChecked %>  />周-->
<!--           <input name="periodType" type="radio" id="month" value="month" <%=monthChecked %>  />月-->
<!--           <input name="periodType" type="radio" id="month" value="month" <%=quarterChecked %>  />季度-->
<!--       </div>-->
    </fieldset>
    
    <div class="enter">
 	<html:hidden property="periodType" value="<%=temp_periodType %>"/>
 	<html:hidden property="qjtype" value="${vo.quartzJobs.qjtype}"/>
    <html:hidden property="qjid" value="<%=String.valueOf(quartzJobs.getQjid()) %>"/>
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
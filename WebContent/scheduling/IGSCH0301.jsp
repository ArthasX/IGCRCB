<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<!--javascript-->
<script type="text/javascript">


function showDiv(obj){ 
	if(obj.value == "S"){
		document.getElementById("SMSInfo").style.display = "";
		document.getElementById("workType").style.display = "none";
	} else if (obj.value == "W"){
		document.getElementById("SMSInfo").style.display = "none";
		document.getElementById("workType").style.display = "";
	}
}

function checkForm(){
	if($F('qjname').trim()==""){
		alert("请输入任务名称！");
		return false;
	}
	if($F('qjdesc').trim()==""){
		alert("请输入任务描述！");
		return false;
	}
	if($F('qjimplusername').trim()==""){
		alert("请选择执行人！");
		return false;
	}
	if($F('qjtype').trim()==""){
		alert("请选择提醒方式！");
		return false;
	}
	if($F('qjhour').trim()==""){
		alert("请选择小时！");
		return false;
	}
	if($F('qjminute').trim()==""){
		alert("请选择分钟！");
		return false;
	}
	if($F('qjtype').trim()=="W"){
		if($F('pdname').trim()==""){
			alert("请选择工作类型！");
			return false;
		}
	}
	if($F('qjtype').trim()=="S"){
		if($F('qjinfo').trim()==""){
			alert("请输入短信内容！");
			return false;
		}
	}
	var periodTypes = document.getElementsByName("periodType");
	var checkEndTime = true;
	for(var i = 0; i < periodTypes.length; i++){
		if(periodTypes[i].checked && periodTypes[i].value == "once"){
			checkEndTime = false;
			break;
		}
	}
	if(checkEndTime){
		if($F('qjendtime').trim()==""){
			alert("请输入结束时间！");
			return false;
		}
	}

	if($F('qjendtime').trim()!=""){
		var start = document.getElementById("qjcrttime").value;
		var end = document.getElementById("qjendtime").value;
		if(start >= end){
			alert("结束时间必须大于开始时间！");
			return false;
		}
	}
	if($F('qjhour').trim()!="" && $F('qjminute').trim()!=""){
		var D = new Date();
		var yy=D.getYear();
		var mm=D.getMonth()+1;
		var dd=D.getDate();
		var hours = D.getHours();
		var minute = D.getMinutes();
		if(mm < 10){
			mm = "0" + mm.toString();
		}
		if(dd < 10){
			dd = "0" + dd.toString();
		}
		if(hours < 10){
			hours = "0" + hours.toString();
		}
		if(minute < 10){
			minute = "0" + minute.toString();
		}

		var selectHour = $F('qjhour').trim();
		var selectMinute = $F('qjminute').trim();
		if(selectHour < 10){
			selectHour = "0" + selectHour.toString();
		}
		if(selectMinute < 10){
			selectMinute = "0" + selectMinute.toString();
		}
		
		var nowTime = yy + "/" + mm + "/" + dd + " " + hours + ":" + minute;
		var selectDate = $F('qjcrttime').trim() + " " + selectHour + ":" + selectMinute;
		if(selectDate < nowTime){
			alert("发生时间必须在当前时间之后！");
			return false;
		}
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}
function selectRoleUser(){
	if(document.getElementById("qjimplrole").value==""){
		alert("请选择角色！");
		return;
	}
	var roleIdValue = document.getElementById("qjimplroleid").value;
	openSubWindow('/IGSYM0405.do?path=strategy&roleida='+roleIdValue , 'newpage', '800', '600');
}
function setParamRoleUser(userid,username,roleid,orgid,orgname){
	document.getElementById("qjimplusername").value = username;
  	document.getElementById("qjimpluser").value = userid;
	document.getElementById("qjorgid").value = orgid;
  	document.getElementById("qjorgname").value = orgname;
}

function showCustomDate(){
	var periodTypes = document.getElementsByName("periodType");
	var showEndTimeDIV = true;
	for(var i = 0; i < periodTypes.length; i++){
		if(periodTypes[i].checked && periodTypes[i].value == "once"){
			showEndTimeDIV = false;
			break;
		}
	}
	if(showEndTimeDIV){
		document.getElementById("endTimeDIV").style.display = ""; 
	}else{
		document.getElementById("endTimeDIV").style.display = "none"; 
	}
}
function openDialog(url){
	var obj = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if(obj != null && obj.split("|").length>1){
		var ptsavepg = obj.split("|")[0].split(",")[1];
		if(ptsavepg.indexOf("/") != 0){
			ptsavepg = "/"+ptsavepg;
		}
		document.forms[0].ptsavepg.value = ptsavepg;
		document.forms[0].qprpdid.value = obj.split("|")[1];
		document.forms[0].pdname.value = obj.split("|")[2];
	}
	
}
</script>
<bean:define id="id" value="IGSCH0301" toScope="request" />
<bean:define id="title" value="企业定时任务" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">
<!--container 左菜单 右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">流程管理 &gt;&gt; 任务调度 &gt;&gt; 指派任务</p>
          <div class="back"><a href="IGSCH0001_Disp.do?type=WE" target="_self">返回</a></div>
    </div>
        <div id="formwrapper">
		<html:form action="/IGSCH0301" onsubmit="return checkSubmit(this);">
		 <ig:message />
       <fieldset>
        <legend>任务信息</legend>
        <div><label for="Name"><strong><span class="red">*</span>任务名称</strong>：</label> 
          <html:text property="qjname" size="50" errorStyleClass="inputError imeActive"/> <br />
		 </div>
          <div><label for="Name"><strong><span class="red">*</span>任务描述</strong>：</label> 
          <html:text property="qjdesc" size="50" errorStyleClass="inputError imeActive"/> <br />
		 </div>
       	<div><label><strong><span class="red">*</span>执行人员</strong>：</label>
       	 <html:select property="qjimplrole" style="width:100px;"
		errorStyleClass="inputError imeActive" tabindex="2" onchange="changeImplRole()">
		<html:options collection="roleList" property="value" name=""  labelProperty="label" />
		</html:select> 
	    <html:hidden property="qjimplrolename"/>
		<html:hidden property="qjimplroleid"/>
		<html:hidden property="qjorgid"/>
		<html:hidden property="qjorgname"/>
		<html:text property="qjimplusername" size="8" readonly="true" errorStyleClass="inputError imeActive"/>
		<a href="javascript:void(0)" onclick="selectRoleUser();"><img src="images/seek.gif" width="16" height="16" border="0" alt="查询"/></a>
		<html:hidden property="qjimpluser"/>
		<html:hidden property="qjimplusername"/>
		<br />
       	</div>
       <div>
            <label for="Name"><strong>开始时间</strong>：</label>
             <p class="p2">
             	<bean:write name="IGSCH03011VO" property="beginDate" />
             	<html:hidden property="qjcrttime" value="${IGSCH03011VO.beginDate}" />
             	
             </p>      
          <br />
       </div>
      
       <div>
            <label for="Name"><strong><span class="red">*</span>调度方式</strong>：</label>
				<html:select property="qjtype" onchange="showDiv(this)">
		<ig:optionsCollection ccid="STRATEGY_WORK_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>
            <br />
       </div>
       
       <div id="SMSInfo" style="display:none">    
            <label for="Name"><strong><span class="red">*</span>短信内容</strong>：</label>
				<html:textarea errorStyleClass="inputError imeActive" property="qjinfo" rows="6" cols="38">  
					
				</html:textarea>
            <br />
       </div>
          <div id="workType" style="display:none"> 
            <label for="Name"><strong>工作类型</strong>：</label>
             <html:text property="pdname" errorStyleClass="inputError imeActive"/>
            <a href="#" onclick="openDialog('IGPRM0002.do?ptqrtzflag=${IGSCH02011VO.type}')"><input type="button" value="查询" class="button" ></a>
         <br />
         <html:hidden property="ptsavepg"/>
         <html:hidden property="qprpdid"/>
       </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>执行时间</strong>：</label>
            <html:select property="qjhour">
           	<html:option value=""></html:option>
             <%for(int i = 0; i < 24; i++){ 
            	if(i<10){%>
            	<html:option value="<%=String.valueOf(i) %>"><%="0"+String.valueOf(i) %></html:option>
            <%} else{%>
            	<html:option value="<%=String.valueOf(i) %>"><%=String.valueOf(i) %></html:option>
            <%}}%>
            
          </html:select>时
           <html:select property="qjminute">
           	<html:option value=""></html:option>
           <%for(int i = 0; i < 60; i++){
            	if(i<10){%>
            	<html:option value="<%=String.valueOf(i) %>"><%="0"+String.valueOf(i) %></html:option>
            <%} else{%>
            	<html:option value="<%=String.valueOf(i) %>"><%=String.valueOf(i) %></html:option>
            <%}}%>
          </html:select>分
          <br />
       </div>
       <div>
          <label for="Name"><span class="red">*</span><strong>周期类型</strong>：</label>
           <input name="periodType" type="radio" value="once" checked="checked" onclick="showCustomDate();" />仅一次
           <input name="periodType" type="radio" value="week" onclick="showCustomDate();" />周
           <input name="periodType" type="radio" value="month" onclick="showCustomDate();" />月
       </div> 
       <div id="endTimeDIV" style="display:none">
            <label for="Name"><span class="red">*</span><strong>结束时间</strong>：</label>
            <html:text property="qjendtime" styleId="qjendtime" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true"/>
			<img src="images/date.gif" align="middle" onclick="calendar($('qjendtime'))"
			border="0" style="cursor: hand" /><br />
       </div>
    </fieldset>
    <div class="enter">
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
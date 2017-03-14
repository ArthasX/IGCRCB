<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<base target="_self" >
<!--javascript-->
<script type="text/javascript">
function checkForm(){
	if($F('qjname').trim()==""){
		alert("请输入任务名称！");
		return false;
	}
	if($F('qjdesc').trim()==""){
		alert("请输入任务描述！");
		return false;
	}
	if($F('pdname').trim()==""){
		alert("请选择工作类型！");
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
		
		var nowTime = yy + "/" + mm + "/" + dd + " " + hours + ":" + minute;
		var selectDate = $F('qjcrttime').trim() + " " + selectHour + ":" + selectMinute;
		//alert(selectDate);
		if(selectDate < nowTime){
			alert("执行时间必须在当前时间之后！");
			return false;
		}
	}

	if($F('qjname').strlen()>128){
		alert("名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('qjdesc').strlen()>256){
		alert("描述不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		return false;
	}
	
	if(confirm("您是否确认提交?")){
		var submitForm = document.forms[0];
		submitForm.action = document.getElementById("ptsavepg").value;
		return true;
	}
	return false;
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
		document.getElementById("qjendtime").value = "";
	}
}

function openDialog(url){
	var obj = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if(obj != null && obj.split("|").length>1){
		var ptsavepg = obj.split("|")[0].split(",")[0];
		document.forms[0].ptsavepg.value = ptsavepg;
		document.forms[0].qprpdid.value = obj.split("|")[1];
		document.forms[0].pdname.value = obj.split("|")[2];
	}
}

function selectEntity(){
	openSubIGCOM0302();
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
    $("qjassetid").value = eiid;
	//$("qjassetname").value = eilabel;
	$("qjassetname").value = einame;
}
function showIncident(){

	var ccid = "116";
	var cid = "";
	var syscode = "";
	if(null==syscode || ""==syscode){
		syscode = ccid;
	}else{
		ccid = syscode.substring(0,3);
	}

	url = "IGSYM1202_TREE_BY_STATUS.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("qjassettypeid").value="";
		$("qjassettypename").value="";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treeccid;
		var treecid;
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}

		$("qjassettypeid").value=treesyscode;
		$("qjassettypename").value=name;
		
	}		
	
}
</script>
<bean:define id="id" value="IGMTP0103" toScope="request" />
<bean:define id="title" value="日常工作计划登记" toScope="request" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<div id="container">
<!--container 左菜单 右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">日常工作计划登记</p>
          <div class="back"><a href="IGSDL0110_SOC.do?date=<bean:write name="IGMTP01011VO" property="beginDate"/>">返回</a></div>
    </div>
        <div id="formwrapper">
		<html:form>
        <ig:message />
        <fieldset>
        <legend>任务信息</legend>
        <div><label for="Name"><strong><span class="red">*</span>任务名称</strong>：</label> 
          <html:text property="qjname" size="50" errorStyleClass="inputError imeActive"/> <br />
		 </div>
          <div><label for="Name"><strong><span class="red">*</span>任务描述</strong>：</label> 
          <html:text property="qjdesc" size="50" errorStyleClass="inputError imeActive"/> <br />
		 </div>
       <div>
            <label for="Name"><strong>开始日期</strong>：</label>
             <p class="p2">
             	<bean:write name="IGMTP01011VO" property="beginDate" />
             	<html:hidden property="qjcrttime" value="${IGMTP01011VO.beginDate}" />
             </p>      
          <br />
       </div>
       
       <div> 
            <label for="Name"><strong><span class="red">*</span>工作类型</strong>：</label>
             <html:text property="pdname" readonly="true" errorStyleClass="inputError imeActive"/>
         <img src="images/tree.gif" width="16" height="16" onclick="openDialog('IGPRM0002.do?ptqrtzflag=W&type=3');" style="cursor: hand" alt="查询"/>
         <br />
         <html:hidden property="ptsavepg"/>
         <html:hidden property="qprpdid"/>
       </div>
		
		<div><label for="Name"><strong>工单类型</strong>：</label> 
	        <html:text property="qjassettypename" readonly="true" /> 
			<img src="images/tree.gif" width="16" height="16" onclick="showIncident();" style="cursor: hand" alt="查询"/>
			<html:hidden property="qjassettypeid" />
			<br />
		</div>
        
        <div>
            <label for="Name"><span class="red">*</span><strong>执行时间</strong>：</label>
            <html:select property="qjhour">
           	<html:option value=""></html:option>
            <%for(int i = 0; i < 24; i++){ 
            	if(i<10){%>
            	<html:option value='<%="0"+String.valueOf(i) %>'><%="0"+String.valueOf(i) %></html:option>
            <%} else{%>
            	<html:option value='<%=String.valueOf(i) %>'><%=String.valueOf(i) %></html:option>
            <%}}%>
            
          </html:select>时
           <html:select property="qjminute">
           	<html:option value=""></html:option>
           <%for(int i = 0; i < 60; i++){
            	if(i<10){%>
            	<html:option value='<%="0"+String.valueOf(i) %>'><%="0"+String.valueOf(i) %></html:option>
            <%} else{%>
            	<html:option value='<%=String.valueOf(i) %>'><%=String.valueOf(i) %></html:option>
            <%}}%>
          </html:select>分
          <br />
       </div>
        <div>
          <label for="Name"><span class="red">*</span><strong>周期类型</strong>：</label>
           <input name="periodType" type="radio" value="once" checked="checked" onclick="showCustomDate();" />仅一次
           <input name="periodType" type="radio" value="day" onclick="showCustomDate();" />日
           <input name="periodType" type="radio" value="week" onclick="showCustomDate();" />周
           <input name="periodType" type="radio" value="month" onclick="showCustomDate();" />月
<!--           <input name="periodType" type="radio" value="quarter" onclick="showCustomDate();" />季度-->
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
    <html:hidden property="qjtype" value="W" />
    <html:submit property="submit" styleClass="button" value="提交" onclick="return checkForm();" />
	<html:reset styleClass="button" value="重置" /></div>
	<html:hidden property="qjassetname" />
	<html:hidden property="qjassetid" />
    </html:form>
     </div>

</div>
</div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0202" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0202" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var arg0= '<bean:message bundle="asmResources" key="message.IGCIM0202.001"/>';
	var alertName = '<bean:message bundle="asmResources" key="message.IGCIM0202.002"/>';
	var alertDescription = '<bean:message bundle="asmResources" key="message.IGCIM0202.003"/>';
	var argName  = '<bean:message bundle="asmResources" key="message.IGCIM0202.004"/>';
    var argNameCount  = '<bean:message bundle="asmResources" key="message.IGCIM0202.005"/>';
    var argDescription   = '<bean:message bundle="asmResources" key="message.IGCIM0202.006"/>';
    var argDescriptionCount  = '<bean:message bundle="asmResources" key="message.IGCIM0202.007"/>';
    if($F('name').trim()==""){
        alert(alertName);
        return false;
    }
    if($F('description').trim()==""){
        alert(alertDescription);
        return false;
    }
    if($F('name').strlen()>64){
		alert(argName+Math.floor(64/strByteFlag)+argNameCount);
		return false;
	}
    if($F('description').strlen()>512){
		alert(argDescription+Math.floor(512/strByteFlag)+argDescriptionCount);
		return false;
	}else{
		var message = '<bean:message key="IGCO10000.W001" arg0="'+arg0+'" />';
		if( window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}
}
function toback(){
	if($F('mode')==0){
		form.action = getAppRootUrl() + "/IGAIM0203_Disp.do";
	}
	if($F('mode')==1){
		form.action = getAppRootUrl() + "/IGAIM0203_back.do";
	}	
	form.submit();
}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">
	<logic:equal name="IGCIM0202Form" property="mode" value="0">
		<ig:navigation extname1="${urlable}"/> &gt;&gt;Domain登记
	</logic:equal>
	<logic:equal name="IGCIM0202Form" property="mode" value="1">
		<ig:navigation extname1="${urlable}"/> &gt;&gt;Domain修改
	</logic:equal>
	
	</p>
	<div class="back"><a href="javascript:toback();" target="_self"><bean:message
		bundle="asmResources" key="label.IGCIM0202.back" /></a>
	</div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGAIM0202" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<div class="txMessageInf"></div>
	<!--  /message -->
	<fieldset>
	<logic:equal name="IGCIM0202Form" property="mode" value="0">
		<legend><bean:message bundle="asmResources" key="label.IGCIM0202.AddEiDDInfo" /></legend>
	</logic:equal> <logic:equal name="IGCIM0202Form" property="mode" value="1">
		<legend><bean:message bundle="asmResources" key="label.IGCIM0202.UpdateEiDDInfo" /></legend>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span><bean:message
		bundle="asmResources" key="label.IGCIM0202.Name" /></strong>：
		</label> 
		<html:text property="name" tabindex="2" style="width: 200px;" name="IGCIM0202Form" styleId="name"/>
	<br>
	</div>
	<div><label for="Name"><strong><span class="red">*</span><bean:message
		bundle="asmResources" key="label.IGCIM0202.Description" /></strong>：
		</label> 
		<html:textarea property="description" rows="4" style="width: 450px;" name="IGCIM0202Form" styleId="description"/>
		 <br>
	</div>

	</fieldset>
	<div class="enter"><html:submit property="btn_insert"
		styleClass="button" onclick="return checkForm();" styleId="btn_insert">
		<bean:message bundle="asmResources" key="button.IGCIM0202.btn_commit"/>
	</html:submit></div>
	<html:hidden property="eiddid" styleId="eiddid" name="IGCIM0202Form"/>
	<html:hidden property="version" styleId="version" name="IGCIM0202Form"/>
	<html:hidden property="mode" styleId="mode" name="IGCIM0202Form"/>
	<html:hidden property="createtime" styleId="createtime" name="IGCIM0202Form"/>
	<html:hidden property="updatetime" styleId="updatetime" name="IGCIM0202Form"/>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
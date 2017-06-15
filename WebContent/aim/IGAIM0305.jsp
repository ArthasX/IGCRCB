<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0305" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0305" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var alertAutdesce = '<bean:message bundle="asmResources" key="message.IGCIM0305.001"/>';
	var argAutdesce='<bean:message bundle="asmResources" key="message.IGCIM0305.002"/>';
	var argAutdesceCount='<bean:message bundle="asmResources" key="message.IGCIM0305.003"/>';
	var alertAutstatus='<bean:message bundle="asmResources" key="message.IGCIM0305.004"/>';
    if($F('autdesc').trim()==""){
        alert(alertAutdesce);
        return false;
    }
   
    if($F('autdesc').strlen()>256){
		alert(argAutdesce+Math.floor(256/strByteFlag)+argAutdesceCount);
		return false;
	}
	if($F('mode')==0){
   		var autstatus=getStatus();
    	if(autstatus=="0"){
   			if(confirm(alertAutstatus)){
				return true;
   			}else{
				return false;
    		}
    	}
	}
}
function getStatus(){
	var res="";
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=autstatus',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}
		    }
		});
	return res;
}
function toback(){
	if($F('mode')==0){
	form.action = getAppRootUrl() + "/IGAIM0307_Disp.do";
	}
	if($F('mode')==1){
	form.action = getAppRootUrl() + "/IGAIM0307.do";
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
	<logic:equal name="IGCIM0305Form" property="mode" value="0">
		<ig:navigation extname1="${urlable}"/> &gt;&gt;审计任务信息登记
	</logic:equal>	
	<logic:equal name="IGCIM0305Form" property="mode" value="1">
		<ig:navigation extname1="${urlable}"/> &gt;&gt;审计任务信息修改
	</logic:equal>
	
</p>
	<div class="back"><a href="javascript:toback();" target="_self"><bean:message
		bundle="asmResources" key="label.IGCIM0305.back" /></a>
	</div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGAIM0305" onsubmit="return checkSubmit(this);">
	<div class="message"><ig:message/></div>
	<fieldset>
	<logic:equal name="IGCIM0305Form" property="mode" value="0">
		<legend><bean:message bundle="asmResources" key="label.IGCIM0305.AddAuditTaskInfo" /></legend>
	</logic:equal> <logic:equal name="IGCIM0305Form" property="mode" value="1">
		<legend><bean:message bundle="asmResources" key="label.IGCIM0305.UpdateAuditTaskInfo" /></legend>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span><bean:message
		bundle="asmResources" key="label.IGCIM0305.Autdesc" /></strong>：
		</label> 
		<html:text property="autdesc" tabindex="2" style="width: 200px;" name="IGCIM0305Form" styleId="autdesc"/>
	<br>
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_insert"
		styleClass="button" onclick="return checkForm();" styleId="btn_insert">
		<bean:message bundle="asmResources" key="button.IGCIM0305.btn_commit"/>
	</html:submit>
	<html:reset property="btn_clear" styleClass="button" >
			<bean:message bundle="asmResources" key="button.IGCIM0305.btn_reset"/>
		</html:reset>
	</div>
	<html:hidden property="autid" name="IGCIM0305Form" styleId="autid"/>
	<html:hidden property="auttime" name="IGCIM0305Form" styleId="auttime"/>
	<html:hidden property="autstatus" name="IGCIM0305Form" styleId="autstatus"/>
	<html:hidden property="mode" styleId="mode" name="IGCIM0305Form"/>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
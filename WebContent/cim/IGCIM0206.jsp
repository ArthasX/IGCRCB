<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0206" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0206" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var arg0= '<bean:message bundle="asmResources" key="message.IGCIM0206.001"/>';
	var alertImpnameRestrict= '<bean:message bundle="asmResources" key="message.IGCIM0206.006"/>';
	var alertImpeiname = '<bean:message bundle="asmResources" key="message.IGCIM0206.002"/>';
	var alertImpcitype = '<bean:message bundle="asmResources" key="message.IGCIM0206.003"/>';
	var argImpeiname='<bean:message bundle="asmResources" key="message.IGCIM0206.004"/>';
	var argImpeinameCount='<bean:message bundle="asmResources" key="message.IGCIM0206.005"/>';
    if($F('impeiname').trim()==""){
        alert(alertImpeiname);
        return false;
    }
    if($F('impcitype').trim()==""){
        alert(alertImpcitype);
        return false;
    }
   
    if(checkUserid(document.IGCIM0206Form.impeiname.value)){
        alert(alertImpnameRestrict);
        return false;
    }
    if($F('impeiname').strlen()>128){
		alert(argImpeiname+Math.floor(128/strByteFlag)+argImpeinameCount);
		return false;
	}

}
function checkUserid(str){      
	var patrn=/^([a-zA-Z0-9]|[._-]){1,128}$/;    
	if (!patrn.test(str)){
		return true;
	}else{
		return false;  
	}  
}
function toback(){

		form.action = getAppRootUrl() + "/IGCIM0207_Disp.do";
			
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
	<bean:define id="urlable">
		<bean:message bundle="asmResources" key="navigation.IGASM.AddObject" />
	</bean:define>
	<ig:navigation extname1="${urlable}" />
	</p>
	<div class="back"><a href="javascript:toback();" target="_self"><bean:message
		bundle="asmResources" key="label.IGCIM0206.back" /></a>
	</div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGCIM0206" onsubmit="return checkSubmit(this);">
	<div class="message"><ig:message/></div>
	<fieldset>
	<logic:equal name="IGCIM0206Form" property="mode" value="0">
		<legend><bean:message bundle="asmResources" key="label.IGCIM0206.AddImportVersionInfo" /></legend>
	</logic:equal> <logic:equal name="IGCIM0206Form" property="mode" value="1">
		<legend><bean:message bundle="asmResources" key="label.IGCIM0206.UpdateImportVersionInfo" /></legend>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span><bean:message
		bundle="asmResources" key="label.IGCIM0206.Impeiname" /></strong>：
		</label> 
		<html:text property="impeiname" tabindex="2" style="width: 200px;" name="IGCIM0206Form" styleId="impeiname"/>
	<br>
	</div>
	<div><label for="Name"><strong><span class="red">*</span><bean:message
		bundle="asmResources" key="label.IGCIM0206.Impcitype" /></strong>：
		</label> 
		 <html:select name="IGCIM0206Form" styleId="impcitype" property="impcitype" style="width: 130px;" errorStyleClass="inputError">
	 		<html:options collection="ADImpTypeList" property="value" name="" labelProperty="label"/>
	 	</html:select>
		 <br>
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_insert"
		styleClass="button" onclick="return checkForm();" styleId="btn_insert">
		<bean:message bundle="asmResources" key="button.IGCIM0206.btn_commit"/>
	</html:submit>
	<html:reset property="btn_clear" styleClass="button" >
			<bean:message bundle="asmResources" key="button.IGCIM0206.btn_reset"/>
		</html:reset>
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
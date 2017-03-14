<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2002" toScope="request" />
<bean:define id="title" toScope="request" value="Domain信息登记界面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var arg0= "Domain基本信息";
	var alertName = "请输入Domain名称！";
	var alertDescription = "请输入Domain描述信息！";
	var argName  = "名称不能大于";
    var argNameCount  = "个汉字！";
    var argDescription   = "描述信息不能大于";
    var argDescriptionCount  = "个汉字！";
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
		var message = "请确认是否要进行"+arg0+"登记处理?";
		if( window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}
}
function toback(){
	form.action = getAppRootUrl() + "/IGASM2003.do";
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
<p class="fonts1">资产管理 &gt;&gt; Domain管理 &gt;&gt;Domain登记</p>
	<div class="back">
	<a href="javascript:toback();" target="_self">返回</a>
	</div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGASM2002" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<div class="txMessageInf"></div>
	<!--  /message -->
	<fieldset>
	<logic:equal name="IGASM2002Form" property="mode" value="0">
		<legend>Domain信息添加</legend>
	</logic:equal> <logic:equal name="IGASM2002Form" property="mode" value="1">
		<legend>修改Domain信息</legend>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span>Domain名称</strong>：
		</label> 
		<html:text property="name" tabindex="2" style="width: 200px;" name="IGASM2002Form" styleId="name"/>
	<br>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>Domain描述</strong>：
		</label> 
		<html:textarea property="description" rows="4" style="width: 450px;" name="IGASM2002Form" styleId="description"/>
		 <br>
	</div>

	</fieldset>
	<div class="enter"><html:submit property="btn_insert"
		styleClass="button" onclick="return checkForm();" styleId="btn_insert" value="提交"/>
	</div>
	<html:hidden property="eiddid" styleId="eiddid" name="IGASM2002Form"/>
	<html:hidden property="version" styleId="version" name="IGASM2002Form"/>
	<html:hidden property="mode" styleId="mode" name="IGASM2002Form"/>
	<html:hidden property="createtime" styleId="createtime" name="IGASM2002Form"/>
	<html:hidden property="updatetime" styleId="updatetime" name="IGASM2002Form"/>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
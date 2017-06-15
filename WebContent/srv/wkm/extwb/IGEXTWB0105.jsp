<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<base target="_self">
<bean:define id="id" value="IGEXTWB0105" toScope="request" />
<bean:define id="title"  toScope="request" >
个人工作确认页面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
<!--
<%-- 弹出变更历史纪录--%>
var gid='IGEXTWB0105'; 
function checkForm(){
	if($F('rlcomment').strlen()>3000){
		alert("备注信息不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
		return false;
		
	}
	if( window.confirm("您是否确认提交？")){
		return true;
	} else {
		return false;
	}
}
//-->
    function show(url){
		document.forms[0].action = url;
		document.forms[0].submit();
	}
</script>
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	background-color: #FFFFFF;
}
</style>
<body onload="changeRolename();">
<div id="maincontent" style="background-color: #FFFFFF; background-image: none;">
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGEXTWB0105_SOC" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<%-- 变更编号--%>
	<html:hidden property="prid" />
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">确认</p>
	<div class="back">
	<a href="javascript:show('IGEXTWB0103_Disp_SOC.do?prid=<bean:write name="IGEXTWB0105Form" property="prid" />')" >返回</a></div> 
	</div>
	<jsp:include page="/include/IGEXTWB.jsp">
		<jsp:param name="vo" value="IGEXTWB01031VO"/>
	</jsp:include>
	<div class="title">
	<div class="name">处理记录</div>
	</div>
	<div id="formwrapper">
	<fieldset>
	<div><strong><span class="red">*</span>角色</strong>： <html:select
		property="roleid"
		errorStyleClass="inputError imeActive" tabindex="2"
		onchange="changeRolename()">
		<html:options collection="roleList" property="value" name=""
			labelProperty="label" />
	</html:select> <html:hidden property="rlrolename"/><br />
	</div>
	<div>
	<html:hidden property="verifyResult" value="S" />
	</div>
	<div><html:textarea property="rlcomment" cols="80" errorStyleClass="inputError imeActive"
		rows="8"></html:textarea> <br />
	</div>
	<div style="padding-left: 50px"><img src="images/attachment.gif" /><a
		href="javascript:addFile();" id="aAddAttach">添加附件</a>
	<table id="tb">
	</table>
	</div>
	</fieldset>
	<div class="enter"><html:submit styleClass="button"  onclick="return checkForm();">
	提交
	</html:submit>
	<html:reset styleClass="button"  >
	重置
	</html:reset>
	</div>
	<div class="Placeholder"></div>
	</div>
</html:form></div>
</div>


</div>
</div>
</body>
</html:html>
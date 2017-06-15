<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM1301" toScope="request" />
<bean:define id="title" value="短信测试画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function submitForm(){
	if($("smsnumber").value.trim()==""){
		alert("请输入手机号码！");
		return false;
	}
	if($("smsnumber").value.trim()!=""&&isMobile($("smsnumber").value.trim())){
		alert("输入的手机格式不正确！");
		return false;
	}
	if(window.confirm("您是否确认发送？")){
    	return true
	}
	return false;
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="formwrapper">
<html:form styleId="form" action="/IGSYM1301" onsubmit="return submitForm();">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
		<legend>短信测试信息</legend>
	<div>
		<label for="Name">
			<strong><span class="red">*</span>接收手机号</strong>：
		</label> 
		<html:text property="smsnumber" size="50" errorStyleClass="inputError imeActive" tabindex="1" />
		<br />
	</div>
	
	<div>
		<label for="Name">
			<strong>短信内容</strong>：
		</label> 
		<html:textarea property="smscontent" cols="60" rows="6" tabindex="2" errorStyleClass="inputError imeActive"/> 
		<br />
	</div>
	</fieldset>
	<div class="enter">
		<html:hidden property="mode" value="0"/>
		<html:submit property="btn_insert" value="发送" styleClass="button" /> 
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
</html:form>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>
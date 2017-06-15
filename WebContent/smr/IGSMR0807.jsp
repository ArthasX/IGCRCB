<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0502" toScope="request" />
<bean:define id="title" value="通知基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
function backValue(){
	var val = document.getElementById("comment").value;
	if(val.strlen() > 3000){
		alert("审批意见不能大于1000个汉字！");
	}else{
		returnValue = val;
		window.close();
	}
}
</script>
<body>
<div id="maincontent">
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">审批意见</p>
</div>
<div id="formwrapper">
<html:form styleId="form" action="/IGSYM0502">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
		<br/>
		<textarea rows="10" cols="63" id="comment"></textarea>
	</fieldset>
	<div class="enter">
		<html:button property="btn_insert" value="提交" styleClass="button" onclick="backValue();"/> 
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
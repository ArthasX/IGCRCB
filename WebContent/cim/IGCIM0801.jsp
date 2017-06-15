<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0801" toScope="request" />
<bean:define id="title" value="监控管理" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
	function IGCIM0801_init() {
		IGCIM0801Form.submit();
	}
</script>
<body onload="IGCIM0801_init()">
	<div id="maincontent">
		<jsp:include page="/include/header2.jsp" />
		<div id="container"
			style="margin-top: 10px; background-color: transparent">
			<!--content  右侧内容-->
			<iframe id="JK" name="JK" width="100%" height="100%" frameborder="0"  onload="SetCwinHeight(this)" scrolling="auto"></iframe>
			<form name="IGCIM0801Form" action="${IGCIM0801Form.url}/j_spring_security_check" method="post" target="JK">
				<input type="hidden" name="j_username" value="${IGCIM0801Form.j_username}"/>
				<input type="hidden" name="j_password" value="${IGCIM0801Form.j_password}"/>
				<input type="hidden" name="goPage" value="${IGCIM0801Form.goPage}"/></form>
		</div>
		<div class="zishiying"></div>
	</div>
</body>
</html:html>
<script type="text/javascript">
	function SetCwinHeight(obj) {
		obj.height = window.screen.height - 200;
	}
	function SetCwinHeight_bak(obj) {
		try{
			obj.height = JK.document.body.scrollHeight + 10;
		} catch(e) {
			obj.height = window.screen.height - 200;
		}
	}
</script>
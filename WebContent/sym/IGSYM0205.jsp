<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<link rel="stylesheet" href="<html:rewrite forward='master.css'/>" type="text/css">
<bean:define id="id" value="IGSYM0205" toScope="request" />
<bean:define id="title" value="信息提示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<body style="background-color: #FFFFFF; background-image: none;">
<div id="maincontent">
<div id="container">
<div class="msg_box"><html:form styleId="form" 
	onsubmit="return checkSubmit(this);">
	<div class="msg_img"><img src="images/Round_Icon_09.gif"
		border="0" /></div>
	<div class="msgcontent"><ig:message /></div>
	<div class="msgbtn">
		<input type="button" name="button" id="button" title="确定" Class="button" value="确定" onclick="window.close();"/>
	</div>
</html:form></div>
</div>
</div>
</body>
</html:html>
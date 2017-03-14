<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0303" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0303" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
html,body {
   margin-top:0;
   padding:0;
   height:100%;
   font-size: 12px;
   overflow-x:hidden;
   overflow-y:hidden;
   background-image: url(images/maincontent.jpg);
	background-repeat: repeat-x;
}
</style>
<body>
<div id="maincontent">
<div id="container" >
<div id="location">
<div class="image"></div>
<p class="fonts1"><bean:message bundle="asmResources"
		key="navigation.IGCIM0303.title" /></p>
</div>
<div id="results_list">
<table cellspacing="2" class="table_style1">
	<tr>
		<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0303.auwtparsestart"/>：</th>
		<td width="35%">${IGCIM03031VO.auditWaitTask.auwtparsestart}</td>
		<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0303.auwtparseend"/>：</th>
		<td width="35%">${IGCIM03031VO.auditWaitTask.auwtparseend}</td>
	</tr>
	<tr>
		<th><bean:message bundle="asmResources" key="label.IGCIM0303.auwtcistart"/>：</th>
		<td>${IGCIM03031VO.auditWaitTask.auwtcistart}</td>
		<th><bean:message bundle="asmResources" key="label.IGCIM0303.auwtciend"/>：</th>
		<td>${IGCIM03031VO.auditWaitTask.auwtciend}</td>
	</tr>
</table>
</div>
<div id="operate">
<div class="content">
<div class="enter"><input type="button" name="btn_close"
	value='<bean:message bundle="asmResources" key="button.IGCIM0303.btn_close"/>'
	onclick="window.close()" class="button"></div>
</div>
</div>
</div>
<!--footer 底部--></div>
</body>
</html:html>
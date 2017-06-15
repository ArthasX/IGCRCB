<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2203" toScope="request" />
<bean:define id="title" toScope="request">
	任务日志信息
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
<p class="fonts1">任务日志信息</p>
</div>
<div id="results_list">
<table cellspacing="2" class="table_style1">
	<tr>
		<th width="15%">解析开始时间：</th>
		<td width="35%">${IGASM22031VO.ciWaitTask.ciwtparsestart}</td>
		<th width="15%">解析结束时间：</th>
		<td width="35%">${IGASM22031VO.ciWaitTask.ciwtparseend}</td>
	</tr>
	<tr>
		<th>CI实体生成开始时间：</th>
		<td>${IGASM22031VO.ciWaitTask.ciwtcistart}</td>
		<th>CI实体生成结束时间：</th>
		<td>${IGASM22031VO.ciWaitTask.ciwtciend}</td>
	</tr>
</table>
</div>
<div id="operate">
<div class="content">
<div class="enter"><input type="button" name="btn_close"
	value='关闭'
	onclick="window.close()" class="button"></div>
</div>
</div>
</div>
<!--footer 底部--></div>
</body>
</html:html>
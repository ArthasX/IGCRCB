<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR1000" toScope="request" />
<bean:define id="title" value="模板列表" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<div id="contentainer">
<div id="location">
<div class="image"></div>
<p class="fonts1">模板列表</p>
</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="40%">模板名称</th>
			<th width="20%">CPU数量</th>
			<th width="20%">内存(GB)</th>
			<th width="20%">硬盘(GB)</th>
		</tr>
		<logic:present name="IGVIR10001VO" property="templateList">
			<logic:iterate id="bean" name="IGVIR10001VO" property="templateList">
				<tr>
					<td align="center">${bean.name }</td>
					<td align="center">${bean.numCPU }</td>
					<td align="center">${bean.memoryGB }</td>
					<td align="center">${bean.diskGB }</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</div>
</div>
</body>
</html:html>
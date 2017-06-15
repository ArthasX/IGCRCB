<%@page import="com.deliverik.framework.utility.IGStringUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html:html>
<bean:define id="id" value="IGPRR0123" toScope="request" />
<bean:define id="title" value="表单日志" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<body>
<div id="maincontent">
<div id="container">
<html:form action="/IGPRR0123.do" styleId="form" onsubmit="return checkSubmit(this);">
<div id="location" style="margin-top: 10px">
<div class="image"></div>
<p class="fonts1">表单日志</p>
</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">序号</th>
			<th width="20%">表单名称</th>
			<th width="30%">表单值</th>
			<th width="20%">修改人</th>
			<th width="20%">修改时间</th>
		</tr>
		<logic:present name="IGPRR01231VO" property="varLogList">
			<logic:iterate id="bean" name="IGPRR01231VO" property="varLogList" indexId="idx" type="com.deliverik.framework.workflow.prr.model.entity.IG113TB">
				<tr>
					<td>${idx+1 }</td>
					<td>${bean.pivarname }</td>
					<logic:empty name="bean" property="pishowvarname">
					<td>
					<%
						if(StringUtils.isNotEmpty(bean.getPivarvalue())){
							out.print(bean.getPivarvalue().replace("cv_cev_", ""));
						}
					%>
					</td>
					</logic:empty>
					<logic:notEmpty name="bean" property="pishowvarname">
					<td>${bean.pishowvarname }</td>
					</logic:notEmpty>
					<td>${bean.recordLog.rlusername }</td>
					<td>${bean.fingerPrint }</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</html:form></div>
</div>
</body>
</html:html>

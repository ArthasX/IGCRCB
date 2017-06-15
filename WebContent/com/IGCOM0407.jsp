<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCOM0407" toScope="request"/>
<bean:define id="title" value="计划中工作" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<body>
<div id="maincontent">
<jsp:include page="/include/header2.jsp" />
<div id="container">
    <html:form styleId="form" action="/IGCOM0302_SUBMIT" onsubmit="return checkSubmit(this);">
    <div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="8%">编号</th>
			<th width="23%">名称</th>
			<th width="11%">类型</th>
			<th width="7%">发起者</th>
			<th width="11%">发起时间</th>
			<th width="11%">发生时间</th>
			<th width="11%">关闭时间</th>
			<th width="8%">状态</th>
			<th width="7%">影响程度</th>
		</tr>
		<logic:present name="IGSVC03011VO" property="processList">
			<logic:iterate id="bean" name="IGSVC03011VO" property="processList"
				indexId="index">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('<bean:write name="IGSVC03011VO" property="detailPgMap(${bean.prtype})"/><bean:write name="bean" property="prid" />');">
					
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td>
					<bean:write name="bean" property="prtitle" /></td>
					<td><bean:write name="bean" property="prpdname" /></td>
					<td><bean:write name="bean" property="prusername" /></td>
					<td><bean:write name="bean" property="propentime" /></td>
					<td><bean:write name="bean" property="prplantime" /></td>
					<td><bean:write name="bean" property="prclosetime" /></td>
					<td><ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
					</td>
					<td><ig:codeValue ccid="IMPACT_GRADE_CODE"
						cid="${bean.primpact}" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
    </html:form>
</div>
	<div class="zishiying"></div>
</div>

</body>
</html:html>
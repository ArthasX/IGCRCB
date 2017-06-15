<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSVC0106" toScope="request" />
<bean:define id="title" value="通用查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGSVC0106" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span>编号：</span><span><html:text
		property="prserialnum" errorStyleClass="inputError imeActive" size="12" /></span>
	<span>&nbsp;&nbsp;名称：</span><span><html:text
		property="prtitle" /></span>
		<span>&nbsp;&nbsp;发起者：</span><span><html:text
		property="prusername" /></span>
	</div>
	<div><span>时间：从</span><span><html:text
		property="propentime" styleId="propentime"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
	 </span><span>&nbsp;&nbsp;到</span><span><html:text
		property="prclosetime" styleId="prclosetime"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" /></span>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>流程类型:</span>
	<html:select property="prtype">
	<html:option value=""></html:option>
	<html:options collection="prtypeList" property="value" name="" labelProperty="label" />
	</html:select>
	<span><html:submit
		styleClass="button" value="查询" /></span></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="3%"></th>
			<th width="8%">编号</th>
			<th width="22%">名称</th>
			<th width="15%">类型</th>
			<th width="8%">发起者</th>
			<th width="12%">发起时间</th>
			<th width="12%">关闭时间</th>
			<th width="12%">状态</th>
			<th width="8%">影响程度</th>
		</tr>
		<logic:present name="IGSVC01061VO" property="processRecordList">
			<logic:iterate id="bean" name="IGSVC01061VO" property="processRecordList"
				indexId="index" type="com.deliverik.framework.workflow.prr.model.IG500Info">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('<bean:write name="IGSVC01061VO" property="detailPgMap(${bean.prtype})"/><bean:write name="bean" property="prid" />');">
					<td>
					<c:if test="${bean.prurgency != null and bean.prurgency > ' '}">
						 <img
							src="images/<bean:write name="bean" property="prurgency" />.gif" alt="紧急程度：<ig:codeValue ccid="${bean.prtype}URGENCY_GRADE_CODE"
							cid="${bean.prurgency}" />"
							border="0" />
					</c:if>
					</td>
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td>
					<bean:write name="bean" property="prtitle" /></td>
					<td><!--<img src="images/svc/<%=bean.getPrtype().substring(0,1)%>.gif" border="0" />  --><bean:write name="bean" property="prpdname" /></td>
					<td><bean:write name="bean" property="prusername" /></td>
					<td><bean:write name="bean" property="propentime" /></td>
					<td><bean:write name="bean" property="prclosetime" /></td>
					<td>
					<logic:notEqual value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />（<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>）
					</logic:notEqual>
					<logic:equal value="" property="prsubstatus" name="bean">
						<logic:equal value="WD" name="bean" property="prtype">
						<ig:processDefineTypeValue prid="${bean.prid}"/>
						</logic:equal>
						<logic:notEqual value="WD" name="bean" property="prtype">
						<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
						</logic:notEqual>
					</logic:equal>				
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
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>

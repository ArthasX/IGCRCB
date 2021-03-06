<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSVC0105" toScope="request" />
<bean:define id="title" value="工作监督" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>

<div id="TabbedPanels1" class="TabbedPanels">
<ul class="TabbedPanelsTabGroup">
	<logic:present name="IGSVC01011VO" property="processRecordMap">
		<logic:iterate id="map" name="IGSVC01011VO"
			property="processRecordMap" indexId="number">
			<li class="TabbedPanelsTab" tabindex="0"><bean:write name="map"
				property="key" /></li>
		</logic:iterate>
	</logic:present>
</ul>
<div class="TabbedPanelsContentGroup"><logic:present
	name="IGSVC01011VO" property="processRecordMap">
	<logic:iterate id="map" name="IGSVC01011VO" property="processRecordMap"
		indexId="number">
		<bean:define id="list" name="map" property="value"
			type="java.util.ArrayList" />
		<div class="TabbedPanelsContent">
		<div class="record_list">
		<table class="table_style">
			<tr>
				<th width="2%"></th>
				<th width="2%"></th>
				<th width="15%">编号</th>
				<th width="15%">名称</th>
				<!-- <th width="10%">类型</th> -->
				<th width="15%">发起人</th>
				<th width="10%">状态</th>
				<!-- <th width="7%">影响程度</th> -->
				<th width="10%">当前处理人</th>
				<th width="15%">发起时间</th>
				<th width="15%">关闭时间</th>
			</tr>
			<logic:iterate id="bean" name="list" indexId="index">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('<bean:write name="IGSVC01011VO" property="detailPgs[${number}]"/><bean:write name="bean" property="prid" />&prstatus=${bean.prstatus}&jump=124');">
					<td><ig:processWarningImg beginTime="${bean.propentime}" processType="${bean.prtype}" prStrategyVersion="${bean.prStrategyVersion}" prPdid="${bean.prpdid}" prUrgency="${bean.prurgency}"/></td>
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
					<!-- <td><bean:write name="bean" property="prpdname" /></td> -->
					<td><bean:write name="bean" property="prusername" /></td>
					<td>
						<logic:equal value="WD" name="bean" property="prtype">
						<ig:processDefineTypeValue prid="${bean.prid}"/>
						</logic:equal>
						<logic:notEqual value="WD" name="bean" property="prtype">
						<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
						</logic:notEqual>
					</td>
					<!-- <td><ig:codeValue ccid="IMPACT_GRADE_CODE"
						cid="${bean.primpact}" /></td> -->
					<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
						</ig:SubstringShowEllipsisWriteTag>
					</td>
					<td><bean:write name="bean" property="propentime" /></td>
					<td><bean:write name="bean" property="prclosetime" /></td>
				</tr>
			</logic:iterate>

		</table>
		</div>
		</div>
	</logic:iterate>
</logic:present></div>
</div>
<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script></div>
<div class="zishiying"></div>
</div>
</div>
</div>
</body>
</html:html>
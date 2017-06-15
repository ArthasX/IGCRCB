<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSVC0102" toScope="request" />
<bean:define id="title" value="相关工作" toScope="request" />
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
<p class="fonts1"><ig:navigation/></p>
</div>
<logic:present name="IGSVC01011VO" property="workMap">
<bean:size id="num" name="IGSVC01011VO" property="workMap"/>
<c:if test="${num > 0}">
<div id="TabbedPanels1" class="TabbedPanels">
<ul class="TabbedPanelsTabGroup">
	<logic:iterate id="map" name="IGSVC01011VO" property="workMap" indexId="number">
		<li class="TabbedPanelsTab" tabindex="0"><bean:write name="map" property="key" /></li>
	</logic:iterate>
</ul>
<div class="TabbedPanelsContentGroup">
	<logic:present name="IGSVC01011VO" property="workMap">
	<logic:iterate id="map" name="IGSVC01011VO" property="workMap" indexId="number">
		<div class="TabbedPanelsContent">
		<div class="record_list">
		<table class="table_style">
			<tr>
				<th width="10%">编号</th>
				<th width="20%">名称</th>
				<th width="10%">类型</th>
				<th width="10%">发起者</th>
				<th width="10%">状态</th>
				<th width="10%">执行人</th>
				<th width="15%">发起时间</th>
				<th width="15%">关闭时间</th>
			</tr>
			<logic:iterate id="bean" name="map" property="value" indexId="index">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('${bean.showurl}${bean.prid }&jump=122');">
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td><bean:write name="bean" property="prtitle" /></td>
					<td><bean:write name="bean" property="prpdname" /></td>
					<td><bean:write name="bean" property="prusername" /></td>
					<td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
					<td>
						<logic:empty name="bean" property="ppusername">
							<img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/>
						</logic:empty>
						<logic:notEmpty name="bean" property="ppusername">
							${bean.ppusername}
						</logic:notEmpty>
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
</script>
</c:if>
</logic:present>
</div>
<div class="zishiying"></div>
</div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGPRR0122" toScope="request"/>
<bean:define id="title" value="参与人信息" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent">
<div id="container">
<div id="location">
	<div class="image"></div>
	<p class="fonts1">处理记录</p>
</div>
<logic:present name="IGPRR01021VO">
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<logic:notEqual value="#" name="IGPRR01021VO" property="status">
		<div class="record_list" style="margin-left: 10px">
			<table cellspacing="2">
				<tr>
					<td><bean:write name="personinfo" filter="false"/></td>
				</tr>
			</table>
		</div>
	</logic:notEqual>
	</logic:notEqual>
</logic:present>
<logic:present name="IGPRR01021VO" property="recordLogMap">
<logic:equal name="IGPRR01021VO" property="hasCLRecord" value="1">
<div id="TabbedPanels1" class="TabbedPanels">
	<ul class="TabbedPanelsTabGroup">
		<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
			<c:if test="${map.key=='处理类日志'}">
				<li class="TabbedPanelsTab" tabindex="0" id="${map.key}" >
					${map.key}
				</li>
			</c:if>
		</logic:iterate>
	</ul>
	<div class="TabbedPanelsContentGroup">
	    <logic:present name="IGPRR01021VO">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
				<c:if test="${map.key=='处理类日志'}">
				<bean:define id="logList" name="map" property="value" type="java.util.List" />
				<div class="TabbedPanelsContent">
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<tr>
						<th width="15%">状态</th>
						<th width="15%">部门</th>
						<th width="40%">内容</th>
						<th width="10%">处理人</th>
						<th width="10%">操作</th>
						<th width="10%">处理时间</th>
					</tr>
				</table>
				</div>
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<logic:iterate id="recordLog" name="logList" indexId="index" >	
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<td width="15%">${recordLog.psname}</td>
							<td width="15%">${recordLog.rlorgname}</td>
							<td width="40%" align="left">
							<pre><bean:write name="recordLog" property="rlcomment" filter="false" /></pre>
							<c:if test="${recordLog.psname != '提交'}">
							<logic:present name="recordLog" property="attachmentList">
									<logic:notEmpty	name="recordLog" property="attachmentList">
										<bean:define id="attachmentList" name="recordLog" property="attachmentList" type="java.util.List" />
										<logic:iterate id="attachment" name="attachmentList" indexId="number">
											<html:link
												action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
												<bean:define id="attname" name="attachment" property="attname" />
												<%= attname.toString().substring(attname.toString().indexOf("_")+1) %>
											</html:link>
											<br />
										</logic:iterate>
									</logic:notEmpty>
							</logic:present>
							</c:if>
							</td>
							<td width="10%">${recordLog.rlusername}</td>
							<td width="10%">${recordLog.rldesc}</td>
							<td width="10%"><SPAN class="red">${recordLog.rltime}</SPAN></td>
						</tr>
					</logic:iterate>
				</table>
				</div>
			</div>
			</c:if>
			</logic:iterate>
			</logic:present>
		</div>
		</div>
		<script type="text/javascript">
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			//-->
		</script>
	</logic:equal>
	</logic:present>
</div>
</div>
</body>
</html:html>
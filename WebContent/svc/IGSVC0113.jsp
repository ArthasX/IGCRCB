<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSVC0113" toScope="request" />
<bean:define id="title" value="中止工作" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
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
<logic:present
	name="IGSVC01011VO" property="processRecordMap">
	<logic:iterate id="map" name="IGSVC01011VO"
		property="processRecordMap" indexId="number">
		<bean:define id="list" name="map" property="value"
			type="java.util.ArrayList" />
		<div id="results_list">
		<table class="table_style2">
			<tr>
				<th width="8%">编号</th>
				<th width="40%">标题</th>
				<th width="15%">类型</th>
				<th width="10%">发起者</th>
				<th width="12%">发起时间</th>
				<th width="12%">状态</th>
			</tr>
			<logic:iterate id="bean" name="list" indexId="index" type="com.deliverik.framework.workflow.prr.model.IG500Info">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('<bean:write name="IGSVC01011VO" property="detailPgMap(${bean.prtype})"/><bean:write name="bean" property="prid" />');">
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td><bean:write name="bean" property="prtitle" /></td>
					<td><!--<img src="images/svc/<%=bean.getPrtype().substring(0,1)%>.gif" border="0" />  --><bean:write name="bean" property="prpdname" /></td>
					<td><bean:write name="bean" property="prusername" /></td>
					<td><bean:write name="bean" property="propentime" /></td>
					<td>
						<%if(bean.getPrtype().equals("WA") || bean.getPrtype().equals("WB")){ %>
							<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
						<%}else{%>
							<ig:processDefineTypeValue prid="${bean.prid}"/>
						<%}%>
						
					</td>
				</tr>
			</logic:iterate>
		</table>
		</div>
	</logic:iterate>
</logic:present>
</div>
<div class="zishiying"></div>
</div>
</div>
</div>
</body>
</html:html>
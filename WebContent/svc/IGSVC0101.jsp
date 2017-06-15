<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSVC0101" toScope="request" />
<bean:define id="title" value="我的工作" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation/></p>
</div>
<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="2%"></th>
			<th width="10%">编号</th>
			<th width="20%">名称</th>
			<th width="10%">类型</th>
			<th width="10%">发起人</th>
			<th width="10%">状态</th>
			<th width="12%">当前处理人</th>
			<th width="13%">发起时间</th>
			<th width="13%">关闭时间</th>
		</tr>
		<logic:present name="IGSVC01011VO" property="workList">
			<logic:iterate id="bean" name="IGSVC01011VO" property="workList">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('${bean.showurl}${bean.prid }&jump=121');">
					<td>
						<!-- 这里先判断是否为变更然后自定义标签再查是否为紧急变更 --> 
						<c:if test="${bean.prpdname =='变更'}">
							<bean:define id="changeType"><ig:publicProcessInfoValue pidname="变更类别" prid="${bean.prid}"/></bean:define>		
							<c:if test="${changeType == '紧急变更'}">
								<img src="images/flag_red.gif" alt="紧急变更" border="0" align="middle"/>
							</c:if>
						</c:if>
					</td>
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td><bean:write name="bean" property="prtitle" /></td>
					<td><bean:write name="bean" property="prpdname" /></td>
					<td><bean:write name="bean" property="prusername" /></td>
					<td><bean:write name="bean" property="orderstatus" /></td>
					<bean:define id="participant">
						<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }"/>&nbsp;
					</bean:define>
					<td title="${participant }">
						<ig:SubstringShowEllipsisWriteTag len="9" showEllipsis="true">
							${participant }
						</ig:SubstringShowEllipsisWriteTag>
					</td>
					<td><bean:write name="bean" property="propentime" /></td>
					<td><bean:write name="bean" property="prclosetime" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</div>
</body>
</html:html>
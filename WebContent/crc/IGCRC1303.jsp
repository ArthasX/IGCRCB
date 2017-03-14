<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGCRC1303" toScope="request" />
<bean:define id="title" value="我的借阅" toScope="request" />
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
	<div id="results_list">
		<table class="table_style">
			<tr>
				<th width="10%">编号</th>
				<th width="15%">名称</th>
				<th width="10%">发起者</th>				
				<th width="15%">发起时间</th>
				<th width="15%">关闭时间</th>
				<th width="10%">当前处理人</th>
				<th width="10%">状态</th>
			</tr>
			<logic:present name="IGCRC1302VO" property="ig500InfoList">
				<logic:iterate id="bean" name="IGCRC1302VO" property="ig500InfoList" indexId="index" type="com.deliverik.framework.workflow.prr.model.IG500Info">
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=83');">
						<td><bean:write name="bean" property="prserialnum" /></td>
						<td><bean:write name="bean" property="prtitle" /></td>
						<td><bean:write name="bean" property="prusername" /></td>
						<td><bean:write name="bean" property="propentime" /></td>
						<td><bean:write name="bean" property="prclosetime" /></td>
						<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />">
							<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
								<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
							</ig:SubstringShowEllipsisWriteTag>
						</td>
						<td>
							<logic:equal value="WD" name="bean" property="prtype">
							<ig:processDefineTypeValue prid="${bean.prid}"/>
							</logic:equal>
							<logic:notEqual value="WD" name="bean" property="prtype">
							<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
							</logic:notEqual>
						</td>
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
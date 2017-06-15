<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.iam.vo.IGIAM050301VO"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<html:html>
<bean:define id="id" value="IGIAM0506" toScope="request" />
<bean:define id="title" value="项目相关问题列表页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单--> 
<div id="contentWrap">
<div id="content"><html:form action="/IGIAM0503" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<logic:equal name="IGIAM0503Form" property="bkmode" value="2">
	<p class="fonts1">审计管理 &gt;&gt; 内审项目管理 &gt;&gt; 相关问题列表</p>
	<div class="back">
		<a href="IGIAM0101_SEARCH.do" target="_self">返回</a>
	</div>
	</logic:equal>
	<logic:equal name="IGIAM0503Form" property="bkmode" value="3">
	<p class="fonts1">审计管理 &gt;&gt; 外审项目管理 &gt;&gt; 相关问题列表</p>
	<div class="back">
		<a href="IGIAM0301_SEARCH.do" target="_self">返回</a>
	</div>
	</logic:equal>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="8%">编号</th>
			<th width="12%">检查项类别</th>
			<th width="10%">问题名称</th>
			<th width="17%">问题描述</th>
			<th width="7%">发起者</th>
			<th width="11%">登记时间</th>
			<th width="11%">计划完成时间</th>
			<th width="11%">实际完成时间</th>
			<th width="13%">状态</th>
		</tr>
		<logic:present name="IGIAM050301VO" property="processList">
			<logic:iterate id="bean" name="IGIAM050301VO" property="processList"
				indexId="index">			
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this);"	onclick="doLook('IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=100');">
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td>
						<ig:publicProcessInfoValue pidname="检查项类别" prid="${bean.prid}"/>
					</td>
					<td><bean:write name="bean" property="prtitle" /></td>
					<td><bean:write name="bean" property="prdesc" /></td>
					<td>
						<bean:write name="bean" property="prusername" />
					</td>					
					<td>
						<bean:write name="bean" property="propentime" />
					</td>
					<td>
						<ig:publicProcessInfoValue pidname="计划完成时间" prid="${bean.prid}"/>
					</td>
					<td>
						<ig:publicProcessInfoValue pidname="实际完成时间" prid="${bean.prid}"/>
					</td>
					<td>
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
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

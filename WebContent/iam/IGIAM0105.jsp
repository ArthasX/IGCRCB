<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGIAM0105" toScope="request" />
<bean:define id="title" value="内审项目确认画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGIAM0104_SEARCH"
	onsubmit="return checkSubmit(this);">
	
<div id="location">
<div class="image"></div>
<p class="fonts1">审计管理 &gt;&gt; 内审项目管理 &gt;&gt; 内审项目确认</p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	&nbsp;&nbsp;<span>年度：</span>
	<html:select property="iapYear">
		<ig:optionsCollection ccid="YEAR_CODE"/>
	</html:select>&nbsp;&nbsp;&nbsp;
	<span>&nbsp;&nbsp;内审项目名称：</span><html:text property="iapName"></html:text>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>状态：</span>
	<html:select property="iapStatus" name="IGIAM0102Form">
		<html:option value="a">&nbsp;</html:option>
		<html:option value="1">未确认</html:option>
		<html:option value="2">已确认</html:option>
	</html:select><br>
	<span>&nbsp;&nbsp;审计时间： </span><span><html:text property="iapOpenTimeFrom" name="IGIAM0102Form" readonly="true"/></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapOpenTimeFrom'))" border="0" />&nbsp;&nbsp;&nbsp;
	<span><html:text property="iapOpenTimeTo" name="IGIAM0102Form" readonly="true" /></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapOpenTimeTo'))" border="0" />&nbsp;&nbsp;
	<html:hidden property="iapType" name="IGIAM0102Form" value="0"/>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">年度</th>
				<th width="15%">内审项目名称</th>
				<th width="15%">审计对象</th>
				<th width="8%">审计方式</th>
				<th width="10%">审计人员</th>
				<th width="15%">状态</th>
				<th width="5%">详细</th>
			</tr>
			<logic:present name="IGIAM01011VO" property="internalauditprjInfoList">
				<logic:iterate id="bean" name="IGIAM01011VO"
					property="internalauditprjInfoList" indexId="index">
					<c:if test="${bean.iapStatus != 0}">
					<tr>
						<td>${bean.iapYear}</td>
						<td>${bean.iapName}</td>
						<td>${bean.iapObject}</td>
						<td>${bean.iapWay}</td>
						<td>${bean.iapUserName}</td>
						<td><ig:codeValue ccid="IAPSTATUS" cid="${bean.iapStatus}"/></td>
						<c:if test="${bean.iapStatus == 1}">
						<td><a href="IGIAM0104_ToConfirm.do?iapId=${bean.iapId}" ><img src="images/edit.gif" border="0" alt="详细" /></a></td>
						</c:if>
						<c:if test="${bean.iapStatus == 2}">
						<td><a href="IGIAM0104_ToConfirm.do?iapId=${bean.iapId}" ><img src="images/xx.gif" border="0" alt="详细" /></a></td>
						</c:if>
					</tr>
					</c:if>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
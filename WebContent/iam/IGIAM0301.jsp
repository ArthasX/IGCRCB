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
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.GregorianCalendar"%>
<%
	//获取当前年
	Calendar cal = new GregorianCalendar();
	String cYear =String.valueOf(cal.get(Calendar.YEAR));
%>
<html:html>
<bean:define id="currentYear" value="<%= cYear%>" toScope="request" />
<bean:define id="id" value="IGIAM0301" toScope="request" />
<bean:define id="title" value="外审项目管理画面" toScope="request" />
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
<html:form styleId="form" action="/IGIAM0301_SEARCH"
	onsubmit="return checkSubmit(this);">

<div id="location">
<div class="image"></div>
<p class="fonts1">审计管理 &gt;&gt; 外审项目管理 &gt;&gt; 外审项目管理</p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	&nbsp;&nbsp;<span>年度：</span>
	<html:select property="iapYear">
		<ig:optionsCollection ccid="YEAR_CODE"/>
	</html:select>&nbsp;&nbsp;&nbsp;
	<span>&nbsp;&nbsp;检查项目名称：</span><html:text property="iapName"></html:text><br>
	<span>&nbsp;&nbsp;检查时间：从</span>
	<span><html:text property="iapOpenTimeFrom" name="IGIAM0102Form" readonly="true"/></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapOpenTimeFrom'))" border="0" /> &nbsp;&nbsp;
	<span>&nbsp;&nbsp;到</span><span><html:text property="iapOpenTimeTo" name="IGIAM0102Form" readonly="true" /></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapOpenTimeTo'))" border="0" />&nbsp;&nbsp;
	<html:hidden property="iapType" name="IGIAM0102Form" value="1"/>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">年度</th>
				<th width="15%">项目名称</th>
				<th width="15%">检查来源</th>
				<th width="8%">检查开始时间</th>
				<th width="10%">审计方式</th>
				<th width="15%">审计人员</th>
				<th width="5%">详细</th>
				<th width="5%">问题</th>
			</tr>
			<logic:present name="IGIAM01011VO" property="internalauditprjInfoList">
				<logic:iterate id="bean" name="IGIAM01011VO"
					property="internalauditprjInfoList" indexId="index">
					<tr>
						<td>${bean.iapYear}</td>
						<td>${bean.iapName}</td>
						<td><ig:codeValue ccid="IAPSOURCE" cid="${bean.iapSource}"/></td>
						<td>${bean.iapOpenTime}</td>
						<td>${bean.iapWay}</td>
						<td>${bean.iapUserName}</td>
						<td>
							<c:if test="${bean.iapYear == currentYear}">
								<a href="IGIAM0302_DetailedToUpdate.do?iapId=${bean.iapId}" ><img src="images/xx.gif" border="0" alt="详细" /></a>
							</c:if>
							<c:if test="${bean.iapYear != currentYear}">
								<a href="IGIAM0302_DetailedSearch.do?iapId=${bean.iapId}" ><img src="images/xx.gif" border="0" alt="详细" /></a>
							</c:if>
						</td>
						<td>
							<c:if test="${bean.hasProblem == 'Y'}">
								<a href="IGIAM0503.do?prcorid=${bean.iapId}&bkmode=3" ><img src="images/d1.gif" border="0" alt="问题" /></a>
							</c:if>
							<c:if test="${bean.hasProblem == 'N'}">
								<a href="#" ><img src="images/d1g.gif" border="0" alt="问题" /></a>
							</c:if>
						</td>
					</tr>
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
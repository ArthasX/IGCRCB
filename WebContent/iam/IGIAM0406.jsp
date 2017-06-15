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
<bean:define id="id" value="IGIAM0406" toScope="request" />
<bean:define id="title" value="项目查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
</head>
<script type="text/javascript">
function setValue(iapid, iapName,iapstatus){
	if(!window.opener.closed){
        window.opener.setPrjParams(iapid, iapName,iapstatus);
     }
    window.close();
}
</script>
<body>
<div id="maincontent">
<div id="content">
<html:form styleId="form" action="/IGIAM0301_HELPSEARCH"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">项目查询</p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
<!-- 	&nbsp;&nbsp;<span>年度：</span> -->
<%-- 	<html:select property="iapYear"> --%>
<%-- 		<ig:optionsCollection ccid="YEAR_CODE"/> --%>
<%-- 	</html:select>&nbsp;&nbsp;&nbsp; --%>
	<span>&nbsp;&nbsp;项目名称：</span><html:text property="iapName"></html:text>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>&nbsp;&nbsp;审计时间： </span><span><html:text property="iapOpenTimeFrom" name="IGIAM0102Form" readonly="true"/></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapOpenTimeFrom'))" border="0" />&nbsp;&nbsp;&nbsp;
	<span><html:text property="iapOpenTimeTo" name="IGIAM0102Form" readonly="true" /></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapOpenTimeTo'))" border="0" />&nbsp;&nbsp;
<%-- 	<html:hidden property="iapType" name="IGIAM0102Form" value="0"/> --%>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">年度</th>
				<th width="10%">项目名称</th>
				<th width="5%">状态</th>
				<th width="10%">审计对象</th>
				<th width="8%">审计方式</th>
				<th width="10%">审计人员</th>
			</tr>
			<logic:present name="IGIAM01011VO" property="helpSearchList">
			<logic:notEmpty name="IGIAM01011VO" property="helpSearchList">
				<logic:iterate id="bean" name="IGIAM01011VO" property="helpSearchList" indexId="index">
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="setValue('${bean.iapId}','${bean.iapName}','${bean.iapStatus}');">
						<td>${bean.iapYear}</td>
						<td>${bean.iapName}</td>
						<td>
						<c:if test="${bean.iapStatus == 0}">草稿</c:if>
						<c:if test="${bean.iapStatus == 1}">未确认</c:if>
						<c:if test="${bean.iapStatus == 2}">已确认</c:if>
						</td>
						<td>${bean.iapObject}</td>
						<td>${bean.iapWay}</td>
						<td>${bean.iapUserName}</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>
			</logic:present>
	</table>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
	</div>
	</html:form>
</div>
<div class="zishiying"></div>

</div>
</body>
</html:html>
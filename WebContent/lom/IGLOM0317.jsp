<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0317" toScope="request" />
<bean:define id="title" value="预支明细统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间
	function exportExcel() {
		if(!checkDate("date_from","date_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		}
		document.forms[0].action = getAppRootUrl() + "/IGLOM0317_Export.do";
		document.forms[0].submit();

}
	function search() {
		if(!checkDate("date_from","date_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		}
		document.forms[0].action = getAppRootUrl() + "/IGLOM0317.do";
		document.forms[0].submit();

}
	</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0317"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 预支明细</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions"><label>交易日期：从</label> <html:text
		property="date_from" styleId="date_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('date_from'))" border="0" />&nbsp;&nbsp; <label>到</label>
	<html:text property="date_to" styleId="date_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('date_to'))" border="0" /> <html:button
		property="btn_search" value="查询" styleClass="button" onclick="search()"/><html:button
		property="btn_export" value="导出" styleClass="button"  onclick="exportExcel()"/></div>
	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="15%">交易日期</th>
			<th width="15%">交易类型</th>
			<th width="15%">人员</th>
			<th width="15%">金额</th>
			<th width="15%">发票金额</th>
			<th width="15%">库存金额</th>
			<th width="10%">状态</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGLOM03171VO" property="advanceDetailList">
			<logic:iterate id="bean" name="IGLOM03171VO"
				property="advanceDetailList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!-- 交易日期 -->
					<td>
					<div class="nowrapDiv">${bean.date}</div>
					</td>
					<!-- 交易类型 -->
					<td>
					<div class="nowrapDiv"><ig:cseCodeValue
						codeIndex="<%=CodeUtils.ADVANCEDETAIL_TYPE%>"
						codeValue="${bean.type}" /></div>
					</td>
					<!-- 人员 -->
					<td>
					<div class="nowrapDiv">${bean.username}</div>
					</td>
					<!-- 金额 -->
					<td>
					<div class="nowrapDiv">
					<c:if test="${bean.amount > 0 || bean.amount < 0}">${bean.amount}</c:if>
					<c:if test="${!(bean.amount > 0 || bean.amount < 0) == true}">-</c:if>
					</div>
					</td>
					<!-- 发票金额 -->
					<td>
					<div class="nowrapDiv">
					<c:if test="${bean.invoiceamount > 0}">${bean.invoiceamount}</c:if>
					<c:if test="${!(bean.invoiceamount > 0 || bean.invoiceamount < 0) == true}">-</c:if>
					</div>
					</td>
					<!-- 库存金额 -->
					<td>
					<div class="nowrapDiv">${bean.stockamount}</div>
					</td>
					<!-- 状态 -->
					<td>
					<div class="nowrapDiv">
					<c:if test="${bean.status != ''}">${bean.status}</c:if>
					<c:if test="${bean.status == ''}">-</c:if>
					</div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><jsp:include page="/include/paging.jsp" /> <!-- /paging --></div>
</html:form></div>
</div>
<div class="zishiying"></div>

</div>

</div>
</body>
</html:html>
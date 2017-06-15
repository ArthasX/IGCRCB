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
<bean:define id="id" value="IGLOM0311" toScope="request" />
<bean:define id="title" value="人员借款明细统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间

	function exportExcel() {
		if($("username").value.trim() == ""){
			alert("请输入借款人！");
			return false;
		}
		if(!checkDate("date_from","date_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		}
		document.forms[0].action = getAppRootUrl() + "/IGLOM0311_Export.do";
		document.forms[0].submit();
	}
	function search() {
		if($("username").value.trim() == ""){
			alert("请输入借款人！");
			return false;
		}
		if(!checkDate("date_from","date_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		}
		document.forms[0].action = getAppRootUrl() + "/IGLOM0311.do";
		document.forms[0].submit();
	}

	function setRoleDomain(url){
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].goreqorg.value = "";
			document.forms[0].goorgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].goreqorg.value = temp.split("|")[0];
			document.forms[0].goorgname.value = temp.split("|")[1];
		}		

	}
	</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0311"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 人员借还款明细</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions"><label><span class="red">*</span>借款人：</label><html:text
		property="username" styleId="username"
		errorStyleClass="inputError imeDisabled" size="12" /> 
	<label>部门：</label> <html:text property="goorgname"
	readonly="true"></html:text> <img src="images/tree.gif"
	style="cursor: hand;" alt="部门" width="16" height="16" border="0"
	onclick="setRoleDomain('IGSYM0101_TREE.do');" /> <html:hidden
	property="goreqorg" />
	<label>交易日期：从</label>
	<html:text property="date_from" styleId="date_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('date_from'))" border="0" />&nbsp;&nbsp; <label>到</label>
	<html:text property="date_to" styleId="date_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('date_to'))" border="0" /> <html:button
		property="btn_search" value="查询" styleClass="button"
		onclick="search()" /><html:button property="btn_export" value="导出"
		styleClass="button" onclick="exportExcel()" /></div>
	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="15%">交易日期</th>
			<th width="10%">交易类型</th>
			<th width="15%">部门</th>
			<th width="10%">金额</th>
			<th width="10%">发票金额</th>
			<th width="30%">用途</th>
			<th width="10%">状态</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGLOM03111VO" property="personLoanDetailList">
			<logic:iterate id="bean" name="IGLOM03111VO"
				property="personLoanDetailList" indexId="index">
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
					<td>
					<div class="nowrapDiv">${bean.organizationTB.orgname}</div>
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
					<!-- 用途 -->
					<td>
					<div class="nowrapDiv">${bean.comment}</div>
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
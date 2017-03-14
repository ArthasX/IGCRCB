<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0308" toScope="request" />
<bean:define id="title" value="预支人员统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间
	function setOrg(url){
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].lpduserorg.value = "";
			document.forms[0].lpduserorgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].lpduserorg.value = temp.split("|")[0];
			document.forms[0].lpduserorgname.value = temp.split("|")[1];
		}		

	}
	function exportExcel() {
		if(!checkDate("lpddate_from","lpddate_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		}
		document.forms[0].action = getAppRootUrl() + "/IGLOM0308_Export.do";
		document.forms[0].submit();

}
	function search() {
		if(!checkDate("lpddate_from","lpddate_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		}
		document.forms[0].action = getAppRootUrl() + "/IGLOM0308.do";
		document.forms[0].submit();

}
	</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0308"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 预支人员统计</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions"><label>所属部门：</label><html:text
		property="lpduserorgname" readonly="true"></html:text> <img
		src="images/tree.gif" style="cursor: hand;" alt="所属部门" width="16"
		height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" /> <html:hidden
		property="lpduserorg" /><label>借款日期：从</label> <html:text
		property="lpddate_from" styleId="lpddate_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('lpddate_from'))" border="0" />&nbsp;&nbsp; <label>到</label>
	<html:text property="lpddate_to" styleId="lpddate_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('lpddate_to'))" border="0" /> <html:button
		property="btn_search" value="查询" styleClass="button" onclick="search()"/><html:button
		property="btn_export" value="导出" styleClass="button"  onclick="exportExcel()"/></div>
	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="10%">姓名</th>
			<th width="15%">借款人机构</th>
			<th width="12%">借款金额</th>
			<th width="13%">还款发票金额</th>
			<th width="15%">还款现金</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGLOM03081VO" property="personLoanSummaryList">
			<logic:iterate id="bean" name="IGLOM03081VO"
				property="personLoanSummaryList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!-- 姓名 -->
					<td>
					<div class="nowrapDiv">${bean.lpduser}</div>
					</td>
					<td>
                    <div class="nowrapDiv">${bean.organizationTB.orgname}</div>
                    </td>
					<!-- 借款金额 -->
					<td>
					<div class="nowrapDiv">${bean.loanamount}</div>
					</td>
					<!-- 还款发票金额 -->
					<td>
					<div class="nowrapDiv">${bean.invoiceamount}</div>
					</td>
					<!-- 还款现金 -->
					<td>
					<div class="nowrapDiv">${bean.payamount}</div>
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
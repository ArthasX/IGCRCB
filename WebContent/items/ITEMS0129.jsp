<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils" %>
<html:html>
<bean:define id="id" value="ITEMS0129" toScope="request" />
<bean:define id="title" value="出库统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">

function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].outstockorg_q.value = "";
		document.forms[0].outstockorg_qname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].outstockorg_q.value = temp.split("|")[0];
		document.forms[0].outstockorg_qname.value = temp.split("|")[1];
	}		

}

function check() {
	var outstockorg_qname = document.forms[0].outstockorg_qname.value;
	if(outstockorg_qname==""){
		return false;
	}else{
		return true;
	}
}
function exportExcel() {
	//if(check()){
		
		
			document.forms[0].action = getAppRootUrl() + "/ITEMS0129.do?report=1";
			document.forms[0].submit();
		
	//}else{
	//	alert("请选择所属机构!");
	//	return false;
	//}
		
}
function search() {
	
		document.forms[0].action = getAppRootUrl() + "/ITEMS0129.do";
		document.forms[0].submit();
	
	//if(check()){
		
	//}else{
	//	alert("请选择所属机构!");
	//	return false;
	//}
	
}
</script>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
<html:form action="/ITEMS0129">
<div class="img"></div>
<div class="conditions">
<div>
<label>使用机构：</label>

<logic:equal name="selectOrg"  value="Y">
<html:text property="outstockorg_qname" readonly="true"></html:text>
<img src="images/tree.gif" style="cursor: hand;" alt="选择使用机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>
<html:hidden property="outstockorg_q"/>
</logic:equal>
<logic:equal name="selectOrg"  value="N">
<html:text property="outstockorg_qname" readonly="true" value="${LOGIN_USER.orgname}"></html:text>
<html:hidden property="outstockorg_q" value="${LOGIN_USER.orgid}"/>
</logic:equal>
&nbsp;&nbsp;

<span>出库时间：从</span><html:text property="outtime_f" styleId="outtime_f" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('outtime_f'))"
			border="0" style="cursor: hand" />
<span>&nbsp;&nbsp;到</span><html:text property="outtime_t" styleId="outtime_t" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('outtime_t'))"
			border="0" style="cursor: hand" />&nbsp;&nbsp;
<span>结账状态：</span><html:select property="accountstatus_q" errorStyleClass="inputError imeActive" >
	<html:option value=""></html:option>
   <html:options collection="accountstatusList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
<br />
<span>物品编号：</span><html:text property="seqcode_q" size="16" maxlength="32"/>&nbsp;&nbsp;
<span>物品名称：</span><html:text property="itemsname_q" size="16" maxlength="32"/>&nbsp;&nbsp;
<span>出库类型：</span><html:select property="outtype">
 <html:option value=""> </html:option>
	<html:option value="1">支行申领</html:option>
	<html:option value="2">总行下拨</html:option>
	<html:option value="3">使用</html:option>
	<html:option value="4">损耗</html:option>
	<html:option value="5">销毁</html:option>
</html:select>&nbsp;&nbsp; 

<span>接收状态：</span><html:select property="reqstatus" errorStyleClass="inputError imeActive" >
   <html:options collection="reqstatusList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;

 <html:button property="btn_search" styleClass="button" value="查看出库明细" onclick="search()"/>
    <html:button property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th width="8%">物品编号</th>
		<th width="18%">物品名称</th>
		<th width="10%">物品型号</th>
		<th width="10%">使用机构</th>
		<th width="8%">结账状态</th>
		<th width="8%">接收状态</th>
		<th width="10%">出库数量</th>
		<th width="10%">出库时间</th>
		<th width="8%">出库单价</th>
		<th width="8%">出库金额</th>
	</tr>

	<logic:present name="ITEMS01011VO" property="outStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="outStockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td><ig:cseOrgValue orgsyscoding="${bean.reqorg}"/></td>
				<td><ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS%>" codeValue="${bean.accountstatus}" /></td>
				<td><ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS%>" codeValue="${bean.reqstatus}" /></td>
				<td>${bean.outnum}</td>
				<td>${bean.outtime}</td>
				<td>${bean.outprice}</td>
				<c:if test="${bean.outtype == '4' or bean.outtype == '5'}">
				<td>0.0</td>
				</c:if>
				<c:if test="${bean.outtype != '4' and bean.outtype != '5'}">
				<td>${bean.outamount}</td>
				</c:if>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>
<div id="operate">
	<div class="operate_btn">
		<jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils" %>
<html:html>
<bean:define id="id" value="ITEMS0130" toScope="request" />
<bean:define id="title" value="库存统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].stockorg_q.value = "";
		document.forms[0].stockorg_qname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].stockorg_q.value = temp.split("|")[0];
		document.forms[0].stockorg_qname.value = temp.split("|")[1];
	}		

}
function check() {
	var stockorg_qname = document.forms[0].stockorg_qname.value;
	if(stockorg_qname==""){
		return false;
	}else{
		return true;
	}
}
function exportExcel() {
	//if(check()){
		
		if($F('stockorg_qname').trim()==""){
			alert("请选择所属机构！");
			return false;
		}else{
			document.forms[0].action = getAppRootUrl() + "/ITEMS0130.do?report=1";
			document.forms[0].submit();	
		}
	//}else{
	//	alert("请选择所属机构!");
	//	return false;
	//}
	
}
function search() {
	//if(check()){
	if($F('stockorg_qname').trim()==""){
		alert("请选择所属机构！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/ITEMS0130.do";
		document.forms[0].submit();
	}
		
	//}else{
	//	alert("请选择所属机构!");
	//	return false;
	//}
	
}
</script>
<body>
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
<html:form action="/ITEMS0130">
<div class="img"></div>
<div class="conditions">
<div>
<label><span class="red">*</span>所属机构：</label>

<logic:equal name="selectOrg"  value="Y">
<html:text property="stockorg_qname" readonly="true"></html:text>
<img src="images/tree.gif" style="cursor: hand;" alt="选择所属机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>
<html:hidden property="stockorg_q"/>
</logic:equal>
<logic:equal name="selectOrg"  value="N">
<html:text property="stockorg_qname" readonly="true" value="${LOGIN_USER.orgname}"></html:text>
<html:hidden property="stockorg_q" value="${LOGIN_USER.orgid}"/>
</logic:equal>
&nbsp;&nbsp;

<span>物品种类：</span><html:select property="category" errorStyleClass="inputError imeActive">
<html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
<span>物品编号：</span><html:text property="seqcode_q" size="16" maxlength="32"/>&nbsp;&nbsp;<br/>
<span>物品名称：</span><html:text property="itemsname_q" size="16" maxlength="32"/>&nbsp;&nbsp;
 <html:button property="btn_search" styleClass="button" value="查看库存清单" onclick="search()"/>
    <html:button property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th width="10%">物品种类</th>
		<th width="10%">物品编号</th>
		<th width="10%">物品型号</th>
		<th width="22%">物品名称</th>
		<th width="8%">物品类型</th>
		<th width="8%">库存数量</th>
		<th width="8%">损毁数量</th>
		<th width="8%">待出库数量</th>
		<th width="8%">单价</th>
		<th width="8%">金额合计</th>
	</tr>

	<logic:present name="ITEMS01011VO" property="stockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="stockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td><ig:cseCodeValue codeIndex="1" codeValue="${bean.category}" /></td>
				<td>${bean.seqcode}</td>
				<td>${bean.typecode}</td>
				<td>${bean.itemsname}</td>
				<td><ig:cseCodeValue codeIndex="2" codeValue="${bean.type}" /></td>
				<td>${bean.stocknum}</td>
				<td>${bean.lostnum}</td>
				<td><logic:iterate id="bean1" name="chknumList" length="1" offset="${index}">${bean1}</logic:iterate></td>
				<td>${bean.price}</td>
				<td>${bean.amount}</td>
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
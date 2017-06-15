<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils" %>
<html:html>
<bean:define id="id" value="ITEMS0128" toScope="request" />
<bean:define id="title" value="入库统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">

function check() {
	var instockorg_name = document.forms[0].instockorg_name.value;
	if(instockorg_name==""){
		return false;
	}else{
		return true;
	}
}
function exportExcel() {
	//if(check()){
		if($F('instockorg').trim()==""){
		alert("请选择所属机构！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/ITEMS0128.do?report=1";
		document.forms[0].submit();	
	}
		
	//}else{
	///	alert("请选择所属机构!");
	//	return false;
	//}
}
function search() {

	if($F('instockorg').trim()==""){
		alert("请选择所属机构！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/ITEMS0128.do";
		document.forms[0].submit();
	}
	
	//if(check()){
		
	//}else{
	//	alert("请选择所属机构!");
	//	return false;
	//}
}


function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].instockorg.value = "";
		document.forms[0].instockorg_name.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].instockorg.value = temp.split("|")[0];
		document.forms[0].instockorg_name.value = temp.split("|")[1];
	}		

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
<html:form action="/ITEMS0128.do">
<div class="img"></div>
<div class="conditions">
<div>
<label><span class="red">*</span>所属机构：</label>
<logic:equal name="selectOrg"  value="Y">
<html:text property="instockorg_name" readonly="true"></html:text>
<html:hidden property="instockorg"/>
</logic:equal>
<logic:equal name="selectOrg"  value="N">
<html:text property="instockorg_name" readonly="true" value="${LOGIN_USER.orgname}"></html:text>
<html:hidden property="instockorg" value="${LOGIN_USER.orgid}"/>
</logic:equal>
&nbsp;&nbsp;
<span>入库时间：从</span><html:text property="intime_f" styleId="intime_f" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('intime_f'))"
			border="0" style="cursor: hand" />
<span>&nbsp;&nbsp;到</span><html:text property="intime_t" styleId="intime_t" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('intime_t'))"
			border="0" style="cursor: hand" />&nbsp;&nbsp;
<br />
<span>物品编号：</span><html:text property="seqcode_q" size="16" maxlength="32"/>&nbsp;&nbsp;
<span>物品名称：</span><html:text property="itemsname_q" size="16" maxlength="32"/>&nbsp;&nbsp;
    <html:button property="btn_search" styleClass="button" value="查看入库清单" onclick="search()"/>
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
		<th width="24%">物品名称</th>
		<th width="10%">物品类型</th>
		<th width="12%">入库时间</th>
		<th width="8%">入库数量</th>
		<th width="8%">入库单价</th>
		<th width="8%">入库金额</th>
		<th width="8%">出库数量</th>
		<th width="7%">损耗数量</th>
		<th width="7%">销毁数量</th>
	</tr>
	
	<logic:present name="ITEMS01011VO" property="inStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="inStockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td><ig:cseCodeValue codeIndex="2" codeValue="${bean.type}" /></td>
				<td>${bean.intime}</td>
				<td>${bean.innum}</td>
				<td>${bean.inprice}</td>
				<td>${bean.inamount}</td>
				<td>${bean.outnum}</td>
				<td>${bean.lossnum}</td>
				<td>${bean.havocnum}</td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>
<html:html>
<bean:define id="id" value="ITEMS0123" toScope="request" />
<bean:define id="title" value="损毁查询页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body onload="init()">
<script type="text/javascript">
function showDiv(obj){
	if(obj.value == 5 || obj.value == 0){
		document.getElementById("outtype").style.display = ""; 
	} else {
		document.getElementById("outtype").style.display = "none"; 
	}
}
function init(){
	var obj = document.forms[0].reqstatus;
	if(obj.value == 5 || obj.value == 0){
		document.getElementById("outtype").style.display = ""; 
	} else {
		document.getElementById("outtype").style.display = "none"; 
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
<html:form action="/ITEMS0123.do">
<div class="img"></div>
<div class="conditions">
<span>物品种类:</span><html:select property="category" errorStyleClass="inputError imeActive">
<html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
<span>状态:</span><html:select property="reqstatus" onchange="showDiv(this);">
	<html:option value="<%=DefineUtils.ITEMSCODES_REQSTATUS_SHDSP %>">损耗待审批</html:option>
	<html:option value="<%=DefineUtils.ITEMSCODES_REQSTATUS_XHDSP %>">销毁待审批</html:option>
	<html:option value="<%=DefineUtils.ITEMSCODES_REQSTATUS_SPWTG %>">审批未通过</html:option>
	<html:option value="<%=DefineUtils.ITEMSCODES_REQSTATUS_CKWC %>">审批已完成</html:option>
</html:select>&nbsp;&nbsp; 
<span id="outtype" style="display:none">
<span>出库类型:</span><html:select property="outtype">
	<html:option value="<%=DefineUtils.ITEMSCODES_OUTTYPE_SH %>">损耗</html:option>
	<html:option value="<%=DefineUtils.ITEMSCODES_OUTTYPE_XH %>">销毁</html:option>
</html:select>
</span>&nbsp;&nbsp;
<html:submit value="查询" styleClass="button" />
</div>
</html:form>
</div>
<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="15%">物品种类</th>
        <th width="13%">物品编号</th>
		<th width="15%">物品名称</th>
        <th width="13%">物品型号</th>
        <th width="14%">损毁数量</th>
        <th width="15%">状态</th>
        <th width="15%">说明</th>
	</tr>

	<logic:present name="ITEMS01011VO" property="outStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="outStockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>
					<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
				</td>
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td>${bean.reqnum}</td>
				<td><ig:cseCodeValue codeIndex="6" codeValue="${bean.reqstatus}" /></td>
				<td>${bean.pakreason}</td>
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
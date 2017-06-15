<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0115" toScope="request" />
<bean:define id="title" value="出库明细记录" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<style>
html{
	overflow-x:auto;
	overflow-y:auto;
}
body{
	overflow-x:hidden;
	overflow-y:hidden;
}
</style>
<body>
<div id="maincontent">
<div id="container">
<html:form styleId="form" action="/IGLOM0115_Disp" onsubmit="return checkSubmit(this);">
<div id="location" style="margin-top: 10px">
<div class="image"></div>
<p class="fonts1">出库明细</p>
</div>
	<div id="results_list">
	<table class="table_style">
	<tr>
		<th width="14%">物品编号</th>
		<th width="10%">物品名称</th>
		<th width="12%">物品型号</th>
		<th width="10%">使用机构</th>
		<th width="10%">出库时间</th>
		<th width="10%">出库数量</th>
		<th width="10%">出库单价</th>
		<th width="10%">出库类型</th>
		<th width="14%">说明</th>
	</tr>
	
	<logic:present name="ITEMS01011VO" property="outStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="outStockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td><ig:cseOrgValue orgsyscoding="${bean.reqorg}"/></td>
				<td>${bean.outtime}</td>
				<td>${bean.outnum}</td>
				<td>${bean.outprice}</td>
				<td><ig:cseCodeValue codeIndex="5" codeValue="${bean.outtype}" /></td>
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
	<div style="margin-top: 50px;" align="center"><input
		type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	<html:hidden property="seqcode" styleId="seqcode" name="ITEMS0115Form"/>
	<html:hidden property="category" styleId="category" name="ITEMS0115Form"/>
	<html:hidden property="outstockorg" styleId="outstockorg" name="ITEMS0115Form"/>
            </html:form>
</div>
</div>
</body>
</html:html>

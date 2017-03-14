<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0114" toScope="request" />
<bean:define id="title" value="入库明细记录" toScope="request" />
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
<html:form styleId="form" action="/IGLOM0114_Disp" onsubmit="return checkSubmit(this);">
<div id="location" style="margin-top: 10px">
<div class="image"></div>
<p class="fonts1">入库明细</p>
</div>
	<div id="results_list">
	<table class="table_style">
	<tr>
		<th width="11%">物品编号</th>
		<th width="11%">物品名称</th>
		<th width="11%">物品型号</th>
		<th width="11%">物品类型</th>
		<th width="11%">包装大小</th>
		<th width="11%">印制部门</th>
		<th width="12%">入库时间</th>
		<th width="11%">入库数量</th>
		<th width="11%">入库单价</th>
	</tr>
	
	<logic:present name="ITEMS01011VO" property="inStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="inStockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td><ig:cseCodeValue codeIndex="2" codeValue="${bean.type}" /></td>
				<td>${bean.packnum}</td>
				<td>${bean.printinside}</td>
				<td>${bean.intime}</td>
				<td>${bean.innum}</td>
				<td>${bean.inprice}</td>
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
	<html:hidden property="seqcode" styleId="seqcode" name="ITEMS0114Form"/>
	<html:hidden property="category" styleId="category" name="ITEMS0114Form"/>
            </html:form>
</div>
</div>
</body>
</html:html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0216" toScope="request" />
<bean:define id="title" value="入出库明细查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGLOM0216';
function exportExcel() {
	document.forms[0].action = "IGLOM0216.do?report=0";
	document.forms[0].submit();
}
</script>
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
<!--content  右侧内容-->
<div id="location">
<div class="image"></div>
<p class="fonts1">出入库明细</p>
</div>
<div id="results_list">
物品名称：${IGLOM02161VO.gname}
<table class="table_style">
	<tr>
		<th width="10%">序号</th>
		<th width="15%">日期</th>
		<th width="15%">入库数量</th>
		<th width="10%">出库数量</th>
		<th width="10%">类型</th>
		<th width="15%">领用机构</th>
		<th width="15%">领用人</th>
		<th width="10%">库存数量</th>
	</tr>
	
	<logic:present name="IGLOM02161VO" property="giostockdetailList">
		<bean:define id="totalStockNum" name="IGLOM02161VO" property="totalStockNum" />
		<logic:iterate id="bean" name="IGLOM02161VO" property="giostockdetailList" indexId="index">
			<tr>
				<td>${1+index}</td>
				<td>${bean.giodtime}</td>
				<td>
					<logic:equal name="bean" property="giodtype" value="0">
						${bean.giodinnum}
					</logic:equal>
				</td>
				<td>
					<logic:notEqual name="bean" property="giodtype" value="0">
						${bean.giodinnum}
					</logic:notEqual>
				</td>
				<td>
					<ig:cseCodeValue codeIndex="<%=CodeUtils.INOUTSTOCK_TYPE %>" codeValue="${bean.giodtype}" />
				</td>
				<td>
					<logic:present name="bean" property="giodreqorg">
						<ig:cseOrgValue orgsyscoding="${bean.giodreqorg}"/>
					</logic:present>
				</td>
				<td>${bean.giodrequsername}</td>
				<td>${totalStockNum[index]}</td>
			</tr>
		</logic:iterate>
	</logic:present>
</table>
</div>
<html:form action="/IGLOM0216">
</html:form>
<div class="enter">
	<input type="button" class="button" value="导出" onclick="exportExcel();">
	<input type="button" class="button" value="关闭" onclick="window.close();">
</div>
</div>
</div>
</body>
</html:html>
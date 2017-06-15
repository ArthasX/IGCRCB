<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.LOMHelper" %>
<%@ page import="java.math.BigDecimal" %>
<html:html>
<bean:define id="id" value="IGLOM0521" toScope="request" />
<bean:define id="title" value="食堂接待部门汇总明细" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>
function toback(){
	form.action = getAppRootUrl() + "/IGLOM0520.do";
	form.submit();
}

function exportExcel() {
	form.action = getAppRootUrl() + "/IGLOM0508d_Report.do";
	form.submit();
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGLOM0508" onsubmit="return checkSubmit(this)">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 部门招待汇总 &gt;&gt; 部门招待汇总明细</p>
	<div class="back"><a href="javascript:toback();" target="_self">返回</a></div> 
	</div>
	
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="5%">序号</th>
			<th width="8%">日期</th>
			<th width="15%">招待活动</th>
			<th width="15%">所属机构</th>
			<th width="8%">主陪人</th>
			<th width="8%">每桌菜价格</th>
			<th width="5%">桌数</th>
			<th width="8%">酒价</th>
			<th width="8%">烟价</th>
			<th width="10%">其他用品价格</th>
			<th width="10%">费用合计</th>
		</tr>
		<logic:present name="IGLOM05071VO" property="eentertainmentList">
			<logic:iterate id="bean" name="IGLOM05071VO" property="eentertainmentList"
				indexId="index">
				<bean:define id="tableprice" name="bean" property="eetableprice" ></bean:define>
				<bean:define id="tablenum"  name="bean" property="eetablenum"></bean:define>
				<bean:define id="drinkprice"  name="bean" property="eedrinkprice"></bean:define>
				<bean:define id="smokeprice"  name="bean" property="eesmokeprice"></bean:define>
				<bean:define id="otherprice"  name="bean" property="eeotherprice"></bean:define>
				<tr>
					<td>${PagingDTO.viewStartCount+index}</td>
					<td><bean:write name="bean" property="eedate" /></td>
					<td><bean:write name="bean" property="rname" /></td>
					<td><bean:write name="bean" property="orgname" /></td>
					<td><bean:write name="bean" property="eeuser" /></td>
					<td><bean:write name="bean" property="eetableprice" /></td>
					<td><bean:write name="bean" property="eetablenum" /></td>
					<td><bean:write name="bean" property="eedrinkprice" /></td>
					<td><bean:write name="bean" property="eesmokeprice" /></td>
					<td><bean:write name="bean" property="eeotherprice" /></td>
					<td><% BigDecimal table =LOMHelper.getMultiply(String.valueOf(tableprice),String.valueOf(tablenum));
					       BigDecimal other = LOMHelper.getAdd(String.valueOf(
				    		                  LOMHelper.getAdd(String.valueOf(drinkprice),String.valueOf(smokeprice))),
				    		                                   String.valueOf(otherprice)); %>
					    <%=LOMHelper.getAdd(table,other)%>
					 </td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	
	</html:form>

	</div>
	</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>

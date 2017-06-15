<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0220" toScope="request" />
<bean:define id="title" value="月盘存查询信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	function check(){
		
		document.forms[0].action=getAppRootUrl() + "/IGLOM0220.do";
		document.forms[0].submit();
	}
	function Excel(){
		document.forms[0].action=getAppRootUrl() + "/IGLOM0220.do?report=1";
		document.forms[0].submit();
	}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 月盘存查询</p>
</div>
<div id="search">
<html:form action="/IGLOM0220">
<div class="img"></div>
<div class="conditions">
<div>


<span>年：</span>
	<html:select property="year" name="IGLOM0220Form">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select>&nbsp;&nbsp; 
<span>月: </span> 
	<html:select property="month" name="IGLOM0220Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select>
 
<html:button property="btn_search" styleClass="button" value="查询" onclick="check();"/>
 <html:button property="btn_excel" styleClass="button" value="导出"  onclick="Excel();"/>
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th width="10%">物品种类</th>
		<th width="12%">物品名称</th>
		<th width="14%">上月结存数量/金额</th>
		<th width="11%">购入数量/金额</th>
		<th width="8%">平均价</th>
		<th width="11%">领用数量/金额</th>
		<th width="11%">调剂数量/金额</th>
		<th width="11%">核销数量/金额</th>
		<th width="12%">结存数量/金额</th>
		
	</tr>

	<logic:present name="IGLOM02201VO" property="inventoryList">
		<logic:iterate id="bean" name="IGLOM02201VO" property="inventoryList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
<!--				<td>${PagingDTO.viewStartCount+index}</td>-->
				<td>
					<ig:projectTypeValue ptype="${bean.goodscategory}" />
				</td>
				<td>${bean.goodsname}</td>
				<td>${bean.lminventoryamount}<strong>/</strong>${bean.lminventorymoney}</td>
				<td>${bean.cminputamount}<strong>/</strong>${bean.cminputmoney}</td>
				<td>${bean.average}</td>
				<td>${bean.cmoutamount}<strong>/</strong>${bean.cmoutmoney}</td>
				<td>${bean.cmregamount}<strong>/</strong>${bean.cmregmoney}</td>
				<td>${bean.cmhavoamount}<strong>/</strong>${bean.cmhavomoney}</td>
				<td>${bean.cmsurplusamount}<strong>/</strong>${bean.cmsurplusmoney}</td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>

<div id="operate">
<!-- paging  <jsp:include page="/include/paging.jsp" />-->
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>
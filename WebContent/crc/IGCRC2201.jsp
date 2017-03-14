<%@page import="com.deliverik.infogovernor.crc.form.IGCRC2201Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.crc.vo.IGCRC2201VO"%>

<html:html>
<bean:define id="id" value="IGCRC2201" toScope="request"/>
<bean:define id="title" value="变更总体统计查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function onSearch(){
	//查询校验
	if(isYear()){
		form.action = "IGCRC2201.do";
		form.submit();
	}
}
function onExcel(){
	if(isYear()){
		form.action = "IGCRC2201_Excel.do";
		form.submit();
	}
}
//如果选择月份但是没有年份提示需要选择年份
function isYear(){
	var selectYear = jQuery("select[name=year] option:selected").text();
	var selectMonth = jQuery("select[name=month] option:selected").text();
	if(selectYear =='' && selectMonth != ''){
		alert("请选择需要查询的年份!");
		return false;
	}
	return true;
}



function modify(typeId,flag){
	var year=document.getElementById("year").value;
	var month=document.getElementById("month").value;
	window.openSubWindow("/IGCRC2202.do?year="+year+"&month="+month+"&syscoding="+typeId+"&flag="+flag,
			'_blank', '1000', '600');
}

function modify1(typeId){
	var year=document.getElementById("year").value;
	var month=document.getElementById("month").value;
	window.openSubWindow("/IGCRC2202_SEARCH.do?year="+year+"&month="+month+"&flag=1&syscoding="+typeId,
			'_blank', '1000', '600');
}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCRC2201" styleId="form">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div style="margin-top:12px;">
		<span class="subscribe">年份：</span>
		<html:select property="year" styleId="year" >
			<html:options collection="yearList" property="value" labelProperty="label"/>
		</html:select>
		<span class="subscribe">月份：</span>
		<html:select property="month" styleId="month" >
			<html:options collection="monthList" property="value" labelProperty="label"/>
		</html:select>
		<input type="button" value="查询" class="button" onclick="onSearch()">
		<input type="button" value="导出" class="button" onclick="onExcel()">
	</div>

	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style" >
		<tr>
			<th width="25%" >分类</th>
			<th width="15%">总数</th>
			<th width="15%">评审通过数量</th>
			<th width="15%">评审通过率</th>
			<th width="15%">成功数量</th>
			<th width="15%">成功率</th>
		</tr>
		<logic:present name="IGCRC2201VO" property="igcrc2202voList">
			<logic:iterate id="bean" name="IGCRC2201VO" property="igcrc2202voList" indexId="index">
				<tr>
					<td>${bean.typeName}</td>
					<td><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="typeId" />','');">${bean.totalnum}</a></td>
					<td><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="typeId" />','1');">${bean.passnum}</a></td>
					<td>${bean.passrate}</td>
					<td><a style='cursor:hand' onclick="modify1('<bean:write name="bean" property="typeId" />');">${bean.successnum}</a></td>
					<td>${bean.successrate}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>

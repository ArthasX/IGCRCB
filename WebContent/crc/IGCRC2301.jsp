<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC2301" toScope="request" />
<bean:define id="title" value="程序开发统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<script type="text/javascript">
function onSearch(){
	if(isYear()){
		form.action = "IGCRC2301.do";
		form.submit();
	}
}
function onExcel(){
	if(isYear()){
		form.action = "IGCRC2301_Excel.do";
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

function modify(userID,flag){
	var year=document.getElementById("year").value;
	var month=document.getElementById("month").value;
	window.openSubWindow("/IGCRC2302.do?userID="+userID+"&flag="+flag+"&year="+year+"&month="+month,
			'_blank', '1000', '600');
}
</script>
<!-- /header1 -->
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
	<html:form action="/IGCRC2301" styleId="form" onsubmit="">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>统计条件</strong></span>
	</div>

	<div style="margin-top:12px;">
		<span class="subscribe">年份：</span>
		<html:select property="year" style="width: 100px;">
    		<html:options collection="yearBeanList" property="value" labelProperty="label"/>
    	</html:select>
		<span class="subscribe">月份：</span>
		<html:select property="month" style="width: 100px;">
    		<html:options collection="monthBeanList" property="value" labelProperty="label"/>
    	</html:select>
		<input type="button" value="查询" class="button" onclick="onSearch()">
		<input type="button" value="导出" class="button" onclick="onExcel()">
	</div>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="20%">人员</th>
			<th width="20%">处理工单数</th>
			<th width="25%">测试更新驳回次数</th>
			<th width="20%">测试驳回次数</th>
			<th width="25%">确认驳回次数</th>
       	</tr>
		<logic:present name="IGCRC2301VO" property="igcrc2301VWList">
			<logic:iterate id="bean" name="IGCRC2301VO"
				property="igcrc2301VWList" indexId="index">
				<tr class="alarmcolor_level" >
					<td style="text-align:center;">${bean.userName}</td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID" />',0);">${bean.disposeNum}</a></td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID" />',1);">${bean.testUpdateRejectNum}</a></td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID" />',2);">${bean.testRejectNum}</a></td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID" />',3);">${bean.confirmRejectNum}</a></td> 
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



﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0215" toScope="request" />
<bean:define id="title" value="统计分析画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	overflow-y: auto;
	background-color: #FFFFFF;
}

.table_style {
	width: 732px;
	margin: 10px 10px;
	border-collapse: collapse;
	text-align: center;
	table-layout: fixed;
}

.table_style th {
	color: #000000;
	border-top: 1px solid #CCCCCC;
	border-bottom: 1px solid #CCCCCC;
	background-color: #EEEEEE;
	height: 20px;
}

.table_style td {
	border-bottom: 1px solid #D3D3D3;
	height: 18px;
	word-break: break-all;
	word-wrap: break-word;
}
.table_style td a:link{
   color:#0066CC;
   text-decoration:none;
}
.table_style td a:visited{
   color:#0066CC;
   text-decoration:none;
}
.table_style td a:hover{
   color:#0066CC;
   text-decoration:underline;
}
.table_style td a:active{
   color:#0066CC;
   text-decoration:none;
}
</style>
<script type="text/javascript">	
<!--
	//设置节点完整名称
	function setCompleteNodeName(){
		parent.rfdtypename.innerHTML = "${IGCOM02151VO.completeNodeName}";
	}
	//查看版本列表
	function showVersion(rfdid){
		openSubWindow('/IGSYM1405_Disp.do?rfdid=' + rfdid, '_blank','1000','600');
	}
//-->
	</script>
<body onload="setCompleteNodeName()">
<div style="margin-top:4px;margin-left:10px">
<ig:message />
</div>
<table class="table_style">
	<tr>
		<th width="100">序号</th>
		<th width="260">报表名称</th>
		<th width="372">报表说明</th>
	</tr>
	<logic:present name="IGCOM02151VO" property="reportFileDefinitionList">
		<logic:iterate id="bean" name="IGCOM02151VO"
			property="reportFileDefinitionList" indexId="index">
			<tr>
				<td>${index + 1}</td>
				<td align="left"><logic:empty name="bean" property="rfdtitle">&nbsp;</logic:empty><html:link
					href="javascript:preview_report('${bean.rfdfilename}','${bean.rfdversion}','${bean.rfdid}')">${bean.rfdtitle}</html:link></td>
				<td><logic:empty name="bean" property="rfddesc">&nbsp;</logic:empty>${bean.rfddesc}</td>
			</tr>
		</logic:iterate>
	</logic:present>
</table>
</body>
</html:html>
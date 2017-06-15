<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>

<%@page import="com.deliverik.infogovernor.smr.bl.IGSMR08BLType"%><html:html>
<bean:define id="id" value="IGSMR0805" toScope="request" />
<bean:define id="title" value="网上银行系统运行情况页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<style type="text/css">

	html,body {
	
	   margin:0;
	
	   padding:0;
	
	   /*height:100%;*/
	
	   font-size: 12px;
	
	   overflow-x:hidden;
	
	   background-color: #FFFFFF;
	
	}
	
	#maincontent{
	
	    height:100%;
	
	    position: relative;
	
	    /*min-width:1002px;*/
	
	}
	
	#container {
	
	margin: 0 auto;
	
	width: 1002px;
	
	}
	
	table {
	
	display: table;
	
	
	
	border-color: #808080;
	
	}
	
	#contentWrap {
	
	margin-right: 0px;
	
	float: right;
	
	width: 100%;
	
	margin-top: 10px;
	
	}
	
	.table_style_rep {
	
	width: 100%;
	
	margin: 0 auto;
	
	border-collapse: collapse;
	
	text-align: center;
	
	table-layout: fixed;
	
	}
	
	
	
	tr {
	
	display: table-row;
	
	vertical-align: inherit;
	
	border-color: inherit;
	
	}
	
	.table_style_rep th {
	
		color: #000;
	
		border-top: 1px solid #CCC;
	
		border-bottom: 1px solid #CCC;
	
		height: 20px;
	
	}
	
	.table_style_rep td {
	
		border-bottom: 1px solid #D3D3D3;
	
		height: 18px;
	
		word-break: break-all;
	
		word-wrap: break-word;
	
	}


</style>

<script type="text/javascript">

function goTo(){
	var size = document.getElementById("pagesize").value;
	var res_list = document.getElementById("results_list");
	var countall_val = document.getElementById("countall").value;
	var year = document.getElementById("year_flag").value;
	var result;
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
		 parameters: '&year='+year+'&pagesize='+ (parseInt(size)-1 < 0?0:parseInt(size)-1) + '&type=getBankLinePage',
		 onSuccess:  function(req, json){
			 result=req.responseText;
			 res_list.innerHTML= result.split("#_#")[0];				
	     }
	});
	countall_val = result.split("#_#")[1];
	document.getElementById("pagesize").value = parseInt(size)-1 < 0? 0 : parseInt(size)-1;
// 	if(size != 0){
// 		form.action = getAppRootUrl() + "/IGSMR0805_SEARCH.do?pagesize=" + (size-1);
// 		form.submit();
// 	}
}

function backTo(){
	
	var size = document.getElementById("pagesize").value;
	var countall_val = document.getElementById("countall").value;
	var res_list = document.getElementById("results_list");
	var year = document.getElementById("year_flag").value;
	var result;
	if((size+1)*4 <= countall_val){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			 parameters: '&year='+year+'&pagesize='+parseInt(size)+1+'&type=getBankLinePage',
			 onSuccess:  function(req, json){
				 result=req.responseText;
				 res_list.innerHTML= result.split("#_#")[0];				
		     }
		});
		countall_val = result.split("#_#")[1];
		document.getElementById("pagesize").value = parseInt(size)+1;
	}
	
// 	var size = document.getElementById("pagesize").value;
// 	var countall = document.getElementById("countall").value;
// 	if((size+1)*4 < countall){
// 		form.action = getAppRootUrl() + "/IGSMR0805_SEARCH.do?pagesize=" + (size+1);
// 		form.submit();
// 	}
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> 
	<jsp:include page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /></p>
	</div>
	</div>
<br/>

<div id="search">
<html:form action="/IGSMR0805_SEARCH" styleId="form">
	<div class="img"></div>
	<div class="conditions">
	<span>起始年份</span>：
	<html:select  property="year" styleId="year" style="width:100px;" errorStyleClass="inputError" tabindex="1">
	<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="true" isCodeLabel="true" />    
	</html:select>
	<html:hidden property="pagesize"/>
	<html:hidden property="countall"/>
	<html:hidden property="year_flag"/>
	<html:hidden property="select_flag" value="0"/>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
</html:form>
</div>
<div id="results_list">
	<table width="98%" border="0" align="center" cellspacing="0">
		<tr align="center">
			<th width="3%">&nbsp;</th>
			<th width="90%" colspan="<%= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE %>" 
			style="font-size:18px; line-height:24px; color:#003399; font-family:'宋体'; background-image: url('images/tilbg_rep.gif'); 
			background-repeat : repeat-x; border: 1px solid #D3D3D3;">网上银行系统运行情况</th>
			<th width="3%">&nbsp;</th>
		</tr>
		<logic:present name="IGSMR08041VO" property="map_report">
		<!-- 二级表头 -->
		<tr align="center">
			<td width="3%" ><img src="images/8.gif" width="16" height="16" style="cursor: hand;" onclick="return backTo();" /></td>
			<logic:iterate id="map" name="IGSMR08041VO" property="map_report" indexId="index">
				<bean:define id="reportname" name="map" property="key"/>
				<bean:define id="list_ji" name="map" property="value"/>
				<c:if test="${index == 0 }">
					<td width="34%"  style="border-left: 1px solid #D3D3D3; border-right: 1px solid #D3D3D3;">
				</c:if>
				<c:if test="${index != 0 }">
					<td width="20%" style="border-left: 1px solid #D3D3D3;">
				</c:if>
					<table border="0" cellspacing="0" class="table_style_rep">
						<tr>
							<c:choose>
							<c:when test="${index == 0 }">
								<th width="8%"  bgcolor="#E8F3FF">&nbsp;</th>
								<th width="12%" colspan="2" style="font-size: 14px;" bgcolor="#E8F3FF">
									<c:if test="${reportname!='tab0' && reportname!='tab1' && reportname!='tab2' && reportname!='tab3'}">
										${reportname}
									</c:if>
									<c:if test="${reportname=='tab0' || reportname=='tab1' || reportname=='tab2' || reportname=='tab3'}">
										无
									</c:if>
								</th>
							</c:when>
							<c:otherwise>
							<th width="15%" colspan="2" style="font-size: 14px;" bgcolor="#E8F3FF">
								<c:if test="${reportname!='tab0' && reportname!='tab1' && reportname!='tab2' && reportname!='tab3'}">
									${reportname}
								</c:if>
								<c:if test="${reportname=='tab0' || reportname=='tab1' || reportname=='tab2' || reportname=='tab3'}">
									无
								</c:if>
							</th>
							</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<c:choose>
								<c:when test="${index == 0 }">
									<th width="80%" bgcolor="#E8F3FF">指标描述</th>
									<th width="10%" bgcolor="#E8F3FF">运行情况</th>
									<th width="10%" bgcolor="#E8F3FF">比上季</th>
								</c:when>
								<c:otherwise>
									<th width="60%" bgcolor="#E8F3FF">运行情况</th>
									<th width="40%" bgcolor="#E8F3FF">比上季</th>
								</c:otherwise>
							</c:choose>
						</tr>
						<logic:iterate id="bean" name="list_ji" >
							<tr style="height: 38px;">
								<c:choose>
								<c:when test="${index == 0 }">
									<th  bgcolor="#E8F3FF">${bean[0]}</th>
									<td >${bean[1]}</td>
									<td >
									<bean:define id="bean1" value="${bean[2]}" />
									<logic:equal name="bean1" value="1">
										<img src="images/report_down.png" width="16" height="16"/>
									</logic:equal>
									<logic:equal name="bean1" value="2">
										<img src="images/report_up.png" width="16" height="16"/>
									</logic:equal>
									<logic:equal name="bean1" value="3">
										上季度没有信息
									</logic:equal>
									<logic:equal name="bean1" value="0">
										持平
									</logic:equal>
									</td>
								</c:when>
								<c:otherwise>
									<td >${bean[1]}</td>
									<td >
									<bean:define id="bean1" value="${bean[2]}" />
									<logic:equal name="bean1" value="1">
										<img src="images/report_down.png" width="16" height="16"/>
									</logic:equal>
									<logic:equal name="bean1" value="2">
										<img src="images/report_up.png" width="16" height="16"/>
									</logic:equal>
									<logic:equal name="bean1" value="3">
										上季度没有信息
									</logic:equal>
									<logic:equal name="bean1" value="0">
										持平
									</logic:equal>
									</td>
								</c:otherwise>
							</c:choose>
							</tr>
						</logic:iterate>
					</table>
				</td>
			</logic:iterate>
			<td width="3%" style="border-left: 1px solid #D3D3D3;"><img src="images/9.gif" width="16" height="16" style="cursor: hand;" onclick="goTo()"/></td>
		</tr>
		</logic:present>
	</table>
	
	</div>
	</div> 
</div>
</div>
<div class="zishiying"></div>
</body>
</html:html>

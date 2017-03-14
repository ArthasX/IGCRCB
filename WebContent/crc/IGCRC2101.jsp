<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC2101" toScope="request" />
<bean:define id="title" value="人员工作统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<script type="text/javascript">
function modify(ppuserid,prpdid,ppstatus){
	var year=document.getElementById("year").value;
	var month=document.getElementById("month").value;
	var propentime_like=year+"/"+month;
	window.openSubWindow("/IGDBM1200.do?propentime_like="+propentime_like+"&"+"prpdid="+prpdid
			+"&"+"ppuserid="+ppuserid+"&ppstatus="+ppstatus,
			"_blank", 1100, 600);
}

function onSearch(){
	//查询校验
	if(isDepartment() && isYear()){
		form.action = "IGCRC2101.do"; 
		form.submit();
	}
}
function onExcel(){
	//导出校验
	if(isDepartment() && isYear()){
		form.action = "IGCRC2101_Excel.do";
		form.submit();
	}
}
//如果选择月份但是没有年份提示需要选择年份
function isYear(){
	var selectYear = jQuery("select[name=year] option:selected").text();
	var selectMonth = jQuery("select[name=month] option:selected").text();
	if(selectYear ==''){
		alert("请选择需要查询的年份!");
		return false;
	}
	if(selectMonth == ''){
		alert("请选择需要查询的月份!");
		return false;
	}
	return true;
}

//部门必填校验 有值返回true
function isDepartment(){
	var selectDepartment = jQuery("select[name=department] option:selected").text();
	if(selectDepartment == ''){
		alert("请选择需要查询的部门！");
		return false;
	}
	return true;
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
	<html:form action="/IGCRC2101" styleId="form" onsubmit="">
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
		<span class="subscribe"><span class="red">*</span>年份：</span>
		<html:select property="year" style="width: 100px;" styleId="year">
    		<html:options collection="yearBeanList" property="value" labelProperty="label"/>
    	</html:select>
		<span class="subscribe"><span class="red">*</span>月份：</span>
		<html:select property="month" style="width: 100px;" styleId="month">
    		<html:options collection="monthBeanList" property="value" labelProperty="label"/>
    	</html:select>
		<span class="subscribe"><span class="red">*</span>部门：</span>
		<html:select property="department" style="width: 130px;">
    		<html:options collection="departmentBeanList" property="value" labelProperty="label"/>
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
			<th width="12%" style="display: none">工号</th>
			<th width="12%">人员</th>
			<th width="11%">事件(个)</th>
			<th width="11%">问题(个)</th>
			<th width="11%">变更(个)</th>
			<th width="11%">服务请求(个)</th>
			<th width="11%">程序开发(个)</th>
			<th width="17%">合计(个)</th>
       	</tr>
		<logic:present name="IGCRC2101VO" property="igcrc2102VOList">
			<logic:iterate id="bean" name="IGCRC2101VO"
				property="igcrc2102VOList" indexId="index">
				<tr class="alarmcolor_level" >
					<td style="text-align:center;" style="display: none">${bean.userID}</td> 
					<td style="text-align:center;">${bean.userName}</td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID"/>','01080','W');">${bean.incidentNum}</a></td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID"/>','01083','W');">${bean.problemNum}</a></td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID"/>','01084','Q');">${bean.changeNum}</a></td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID"/>','01101','U');">${bean.serviceNum}</a></td> 
					<td style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="userID"/>','01102','Y');">${bean.developNum}</a></td> 
					<td style="text-align:center;">${bean.total}</td> 
				</tr>
			</logic:iterate>
		</logic:present>
		<logic:present name="IGCRC2101VO" property="listSum">
		<tr>
			<td style="padding-left: 0px" colspan="1">合计：</td>
			<logic:iterate id="sum" name="IGCRC2101VO" property="listSum" indexId="index">
				<td>${sum}</td>
			</logic:iterate>
		</tr>
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



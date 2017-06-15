<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC2001" toScope="request" />
<bean:define id="title" value="年度工作统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">


function modify(month,prpdid){
	var year=document.getElementById("year").value;
	if(month<10){
		month="0"+month;
	}
	window.openSubWindow("/IGDBM1200.do?prclosetime_like="+year+"/"+month+"&"+"prpdid="+prpdid+"&"+"prstatus="+"C",
			"_blank", 1100, 600);
}


function selectTree(ccidinfo,selecedlast){
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selecedlast=" + selecedlast;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if("_resetall"==temp){
		$("pivartreename").value = "";
	}else if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treeccid;
		var treecid;
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}

		if(treesyscode!=null && name!=null && treesyscode != ''){
			$("pivartreename").value = name;
		}else{
			$("pivartreename").value = '';
		}
		
	}		
	if($("pivartreename").onchange){
		$("pivartreename").onchange();
	}
}
function onSearch(){
	form.action = "IGCRC2001.do";
	form.submit();
}
function onExcel(){
	form.action = "IGCRC2001_Excel.do";
	form.submit();
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
	<html:form action="/IGCRC2001" styleId="form">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>年度工作统计</strong></span>
	</div>
	<div style="margin-top:12px;">
		<span class="subscribe">年份：</span>
			 <html:select property="year" >
				    <html:options collection="Yearlist" property="value" labelProperty="label"/>
			 </html:select>
		&nbsp;&nbsp;<input type="button" value="查询" class="button" onclick="onSearch()" />
		&nbsp;&nbsp;<input type="button" value="导出" class="button" onclick="onExcel()" />
	</div>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
		
			<th width="14%">月份</th>
			<th width="14%">事件(个)</th>
			<th width="14%">问题(个)</th>
			<th width="14%">变更(个)</th>
			<th width="14%">科技服务请求(个)</th>
			<th width="14%">程序开发(个)</th>
			<th width="16%">合计(个)</th>
       	</tr>
 		<logic:present name="IGCRC2001VO" property="igcrc2002voList">
			<logic:iterate id="bean" name="IGCRC2001VO"
				property="igcrc2002voList" indexId="index">
				<tr>
					<td>${bean.propentime}月</td>
					<td><a style='cursor:hand' onclick="modify(${bean.propentime},'01080');">${bean.incidentnum}</a></td>
					<td><a style='cursor:hand' onclick="modify(${bean.propentime},'01083');">${bean.problemnum}</a></td>
					<td><a style='cursor:hand' onclick="modify(${bean.propentime},'01084');">${bean.changenum}</a></td>
					<td><a style='cursor:hand' onclick="modify(${bean.propentime},'01100');">${bean.servicenum}</a></td>
					<td><a style='cursor:hand' onclick="modify(${bean.propentime},'01102');">${bean.sfnum}</a></td>
					<td>${bean.sum}</td>
				</tr>
			</logic:iterate>
		</logic:present>
		<logic:present name="IGCRC2001VO" property="sumList">
		<td>合计：</td>
			<logic:iterate id="beans" name="IGCRC2001VO"
				property="sumList" indexId="index">
				<td>${beans }</td>
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
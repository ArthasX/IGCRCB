<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGIAM0201" toScope="request" />
<bean:define id="title" value="内审工作管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var iajid = "";
function selectAll(){
	var checkboxList = document.getElementsByName('checkbox_one');
	for(var i=0; i<checkboxList.length;i++){
		var checkbox = checkboxList[i];
		var temp = checkbox.value + ",";
		var index = iajid.indexOf(temp);
		if(index < 0){
			iajid += temp;
			checkbox.checked = true;
		}else{
			iajid = iajid.replace(temp,"");
			checkbox.checked = false;
		}
	}
}
function selectone(checkbox){
	if(checkbox.checked){
		iajid += checkbox.value+ ",";
	}else{
		var toCut = checkbox.value + ",";
		var index = iajid.indexOf(toCut);
		iajid = iajid.replace(index,index+toCut.length, "");
	}
}
function remove(){
	var checks = document.getElementsByName("checkbox_one");
	if(null==checks||checks.length==0){
		return;
	}
	var flag = true;
	for(var i=0;i<checks.length;i++){
		if(checks[i].checked){
			flag = false;
			break;
		}
	}
	if(flag){
		alert('请选择要删除的记录！');
		return;
	}else{
		if (window.confirm("是否删除所选信息？")) {
			document.forms[0].action = getAppRootUrl() + "/IGIAM0203_Delete.do?iajids="+iajid;
			document.forms[0].submit();
		}
	}
}
function setprj(){
	url = "/IGIAM0101_HELPSEARCH.do" + "?iapStatus=2";
	openSubWindow(url,'_blank','850','400');
}
function setPrjParams(iapid, iapName, iapstatus){
	document.forms[0].iajIapId_q.value = iapid;
	document.forms[0].iajiapname.value = iapName;
}
function clearPrjParams(){
	document.forms[0].iajIapId_q.value = "";
	document.forms[0].iajiapname.value = "";
}
function laodbtn(){
	var checks = document.getElementsByName("checkbox_one");
	if(null==checks||checks.length==0){
		document.getElementById("btn_delete").style.display='none';
	}else{
		document.getElementById("btn_delete").style.display='';
	}
}
</script>
<body onload="laodbtn();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单--> 
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGIAM0201">
	
<div id="location">
<div class="image"></div>
<p class="fonts1">审计管理 &gt;&gt; 内审工作管理 &gt;&gt; 内审工作管理</p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>年度计划：</span>
	<html:select property="iajYear_q">
		<ig:optionsCollection ccid="YEAR_CODE"/>
	</html:select>
	<span>&nbsp;&nbsp;内审项目：</span>
	<html:text property="iajiapname" readonly="true" />
	<img src="images/tree.gif" style="cursor: hand;" alt="选择内审项目" width="16" height="16" border="0" onclick="setprj();"/>
	<html:hidden property="iajIapId_q"/><br/>
	<span>&nbsp;&nbsp;工作名称：</span><html:text property="iajName_like" size="45"></html:text>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">
					<input type="checkbox" name="checkbox_all" id="checkbox_all" onclick="selectAll()" />
				</th>
				<th width="5%">年度计划</th>
				<th width="15%">内审项目名称</th>
				<th width="15%">内审工作名称</th>
				<th width="8%">审计方式</th>
				<th width="10%">审计人</th>
				<th width="5%">详细</th>
			</tr>
			<logic:present name="IGIAM02011VO" property="internalauditJobList">
				<logic:iterate id="bean" name="IGIAM02011VO"
					property="internalauditJobList" indexId="index">
					<tr>
						<td>
							<input type="checkbox" name="checkbox_one" id="checkbox_one" onclick="selectone(this)" value="${bean.iajid}"/>
						</td>
						<!-- 计划年度 -->
						<td>${bean.iajyear}</td>
						<!-- 内审项目名称 -->
						<td>${bean.internalauditprjTB.iapName}</td>
						<!-- 内审工作名称 -->
						<td>${bean.iajname}</td>
						<!-- 审计方式 -->
						<td>${bean.internalauditprjTB.iapWay}</td>
						<!-- 审计人 -->
						<td>${bean.internalauditprjTB.iapUserName}</td>
						<!-- 详细 -->
						<td>
						<a href="IGIAM0203_Edit.do?iajid=${bean.iajid }"><img alt="详细" src="images/xx.gif" border="0"></a>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	 <html:button property="btn_delete" value="删除" styleClass="button" onclick="remove()"/>
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
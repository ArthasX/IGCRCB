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
<bean:define id="id" value="IGIAM0401" toScope="request" />
<bean:define id="title" value="审计报告管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>
var apid = "";
function selectAll(){
	var checkboxList = document.getElementsByName('checkbox_one');
	for(var i=0; i<checkboxList.length;i++){
		var checkbox = checkboxList[i];
		var temp = checkbox.value + ",";
		var index = apid.indexOf(temp);
		if(index < 0){
			apid += temp;
			checkbox.checked = true;
		}else{
			apid = apid.replace(temp,"");
			checkbox.checked = false;
		}
	}
}
function selectone(checkbox){
	if(checkbox.checked){
		apid += checkbox.value+ ",";
	}else{
		var toCut = checkbox.value + ",";
		var index = iajid.indexOf(toCut);
		apid = apid.replace(index,index+toCut.length, "");
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
		document.forms[0].action = getAppRootUrl() + "/IGIAM0403_Delete.do?apids="+apid;
		document.forms[0].submit();
	}
}
</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单--> 
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGIAM0401_SEARCH"
	onsubmit="return checkSubmit(this);">
	
<div id="location">
<div class="image"></div>
<p class="fonts1">审计管理 &gt;&gt; 审计报告管理 &gt;&gt; 审计报告管理</p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>&nbsp;&nbsp;审计年度：</span>
	<html:select property="approjectyear" style="width:130px;">
		<ig:optionsCollection ccid="YEAR_CODE"/>
	</html:select>
	&nbsp;&nbsp;<span>项目名称：</span><html:text property="approjectname"></html:text>
<%-- 	<html:select property="iapYear"> --%>
<%-- 		<ig:optionsCollection ccid="YEAR_CODE"/> --%>
<%-- 	</html:select>&nbsp;&nbsp;&nbsp; --%>
	<span>&nbsp;&nbsp;审计报告类型：</span>
	<html:select property="apreporttype">
		<ig:optionsCollection ccid="AUDITREPORTTYPE"/>
	</html:select>&nbsp;&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
		<table class="table_style">
			<tr>
				<td width="5%" style="color:#000000;border-top:1px solid #CCCCCC;border-bottom:1px solid #CCCCCC; background-color:#EEEEEE;height:20px;">
					<input type="checkbox" name="checkbox_all" id="checkbox_all" onclick="selectAll()" />
				</td>
				<th width="5%">审计年度</th>
				<th width="15%">审计报告类型</th>
				<th width="15%">项目名称</th>
				<th width="15%">问题数量</th>
				<th width="8%">详细信息</th>
			</tr>
			<logic:present name="IGIAM03011VO" property="auditProjectInfoList">
				<logic:iterate id="bean" name="IGIAM03011VO" property="auditProjectInfoList" indexId="index">
					<tr>
						<td>
							<input type="checkbox" name="checkbox_one" id="checkbox_one" onclick="selectone(this)" value="${bean.apid}"/>
						</td>
						<td>${bean.approjectyear}</td>
						<td><ig:codeValue ccid="AUDITREPORTTYPE" cid="${bean.apreporttype}"/></td>
						<td>${bean.approjectname}</td>
						<td>${bean.fingerPrint }</td>
						<td><a href="IGIAM0403_DetailedToUpdate.do?apid=${bean.apid}" ><img src="images/xx.gif" border="0" alt="详细" /></a></td>
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
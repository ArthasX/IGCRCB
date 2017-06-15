<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0219" toScope="request" />
<bean:define id="title" value="领用调剂查询页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

function createHiddenInput(name,value){
    var inputElement=document.createElement("input");   
    inputElement.name=name;   
    inputElement.value=value;     
    inputElement.type="hidden";
    inputElement.id=name;
    document.forms[0].appendChild(inputElement);   
}
function checkSearch(){
	if(!checkDateByContent("giotime_f","giotime_t")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}else{
		return true;
	}

}

function exportExcel() {
	document.forms[0].action = getAppRootUrl() + "/IGLOM0219_Export.do";
	document.forms[0].submit();
	document.forms[0].action = getAppRootUrl() + "/IGLOM0219.do";
}

function setRoleDomain(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].goreqorg.value = "";
		document.forms[0].goorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].goreqorg.value = temp.split("|")[0];
		document.forms[0].goorgname.value = temp.split("|")[1];
	}		

}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGLOM0219">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 领用调剂查询</p>
</div>
<div id="search">
<div class="img"></div>
<div class="conditions">
<div><span>出库类型：</span>
		<html:select property="gotype" errorStyleClass="inputError">
		 	<html:options collection="outstock_type" property="value" labelProperty="label" />
		</html:select>
<span>出库日期从：</span><html:text property="gotime_f" readonly="true"/>
<img src="images/date.gif" align="middle" onclick="calendar($('gotime_f'))" border="0" style="cursor: hand" />

<span>到：</span><html:text property="gotime_t" readonly="true"/>
<img src="images/date.gif" align="middle" onclick="calendar($('gotime_t'))" border="0" style="cursor: hand" />

<span>物品名称：</span><html:text property="goname"/><br/>
<span>领用机构：</span>
	<html:text property="goorgname" readonly="true"></html:text> 
		<img src="images/tree.gif" style="cursor: hand;" alt="领用机构" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');" /> 
		<html:hidden property="goreqorg" />
<span>领用/调剂人：</span><html:text property="gorequsername"/>
<input type="submit" value="查询" class="button" onclick="return checkSearch();" />
<input type="button" value="导出" class="button" onclick="exportExcel();"/>
</div>
</div>

</div>

	<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="5%">序号</th>
		<th width="14%">物品种类</th>
		<th width="14%">物品名称</th>
		<th width="14%">出库时间</th>
		<th width="13%">出库数量</th>
		<th width="15%">领用机构</th>
		<th width="14%">领用/调剂人员</th>
		<th width="15%">出库类型</th>
	</tr>
	<logic:present name="IGLOM02191VO" property="goutstockList">
		<logic:iterate id="bean" name="IGLOM02191VO" property="goutstockList" indexId="index">
		<tr class="bgRow<%=index%2 %>">
				<td>${PagingDTO.viewStartCount+index}</td>
				<td><ig:projectTypeValue ptype="${bean.gocategory}" /></td>
				<td>${bean.goname}</td>
				<td>${bean.gotime}</td>
				<td>${bean.goinnum}</td>
				<td><ig:cseOrgValue orgsyscoding="${bean.goreqorg}"/></td>
				<td>${bean.gorequsername}</td>
				<td><ig:cseCodeValue codeIndex="<%=CodeUtils.OUTSTOCK_TYPE %>" codeValue="${bean.gotype}" /></td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>
<div id="operate">
<!-- paging --> <jsp:include page="/include/paging.jsp" />
</div>
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
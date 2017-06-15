<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>
<%@ page import="com.csebank.items.util.CSEHelper"%>

<html:html>
<bean:define id="id" value="ITEMS0169" toScope="request" />
<bean:define id="title" value="仓库收益画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
function checkForm(name){
	if($F('outtime_f').trim()==""){
		alert("请选择开始时间！");
		return false;
	}
	if($F('outtime_t').trim()==""){
		alert("请选择结束时间！");
		return false;
	}
	if(!checkDate("outtime_f","outtime_t")){
		alert("开始时间不能晚于结束时间！");
		return false;
	}
	if(name=="search"){
		document.forms[0].action=getAppRootUrl() + "/ITEMS0169.do";
		document.forms[0].submit();

	}else if(name=="excel"){

		document.forms[0].action = getAppRootUrl() + "/ITEMS0169_Excel.do";
		document.forms[0].submit();

	}
}

function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].reqorg.value = "";
		document.forms[0].reqorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].reqorg.value = temp.split("|")[0];
		document.forms[0].reqorgname.value = temp.split("|")[1];
	}		

}


	
//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form"
	action="/ITEMS0169_Disp">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><label>&nbsp;&nbsp;领用机构：</label><html:text property="reqorgname" readonly="true"></html:text>
	<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围"
		width="16" height="16" border="0"
		onclick="setOrg('IGSYM0101_TREE.do');" /> <html:hidden
		property="reqorg" />&nbsp;&nbsp;<span>物品种类：</span> <span> <html:select
		property="category" style="width: 100px;"
		errorStyleClass="inputError imeActive">
		<html:options collection="ADcategory_options" property="value" name=""
			labelProperty="label" />
	</html:select></span>&nbsp;&nbsp;<span>
	<br><span class="red">*</span>出库时间：从</span><span><html:text
		property="outtime_f" styleId="outtime_f"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('outtime_f'))" border="0" style="cursor: hand" />
	</span> <span>&nbsp;&nbsp;到</span><span><html:text property="outtime_t"
		styleId="outtime_t" errorStyleClass="inputError imeDisabled" size="16"
		readonly="true" /> <img src="images/date.gif" align="middle"
		onclick="calendar($('outtime_t'))" border="0" style="cursor: hand" /></span>
	<html:button property="btn_button" styleClass="button" value="查询"
		onclick="checkForm('search');" /> <html:button property="btn_button"
		styleClass="button" value="导出" onclick="checkForm('excel');" /></div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
		<tr>
			<th width="8%">机构名称</th>
			<th width="7%">出库类型</th>
			<th width="9%">出库时间</th>
			<th width="10%">物品编号</th>
			<th width="10%">物品名称</th>
			<th width="8%">物品型号</th>
			<th width="7%">物品种类</th>
			<th width="6%">数量</th>
			<th width="7%">入库单价</th>
			<th width="7%">入库金额</th>
			<th width="7%">出库单价</th>
			<th width="8%">出库金额</th>
			<th width="6%">收益</th>

		</tr>
		<logic:present name="ITEMS01691VO" property="items01692VOList">
			<logic:iterate id="vo" name="ITEMS01691VO"
				property="items01692VOList" indexId="index">
				<bean:define id="p" name="vo" property="inPrice"/>
				<bean:define id="c" name="vo" property="count"/>
				<tr class="<ig:rowcss index="${index}"/>">
					<td><ig:cseOrgValue orgsyscoding="${vo.outStock.reqorg}" /></td>
					<td><ig:cseCodeValue codeIndex="5" codeValue="${vo.outStock.outtype}" /></td>
					<td>${vo.outStock.reqtime}</td>
					<td>${vo.outStock.seqcode}</td>
					<td>${vo.outStock.itemsname}</td>
					<td>${vo.outStock.typecode}</td>
					<td><ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${vo.outStock.category}" /></td>
					<td>${vo.count}</td>
					<td>${vo.inPrice}</td>
					<td><%=CSEHelper.getMultiply(String.valueOf(p),String.valueOf(c)) %></td>
					<td>${vo.outPrice}</td>
					<td>${vo.countPrice}</td>
					<td>${vo.income}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
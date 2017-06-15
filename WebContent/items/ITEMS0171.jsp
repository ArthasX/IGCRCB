<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>

<html:html>
<bean:define id="id" value="ITEMS0171" toScope="request" />
<bean:define id="title" value="物品收益画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
WebCalendar.timeShow = false;	
function checkForm(name){
	if(document.getElementById("category").value==""){
		alert("请选择物品种类！");
		return;
	}
	if(document.getElementById("seqcode").value==""){
		alert("请选择物品名称！");
		return;
	}
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
		document.forms[0].action=getAppRootUrl() + "/ITEMS0171.do";
		document.forms[0].submit();

	}else if(name=="excel"){

		document.forms[0].action = getAppRootUrl() + "/ITEMS0171_Excel.do";
		document.forms[0].submit();

	}
}

function selectSeqCode(){
	if(document.getElementById("category").value==""){
		alert("请选择物品种类！");
		return;
	}
	var categoryValue = document.getElementById("category").value;
	openSubWindow("/ITEMS0101.do?status=1&path=instock&category="+categoryValue , "_blank", "800", "600");
}

function setParamItems0106(seqcode, typecode, type) {
    $("seqcode").value = seqcode;
	$("itemsname").value = typecode;
	$("typecode").value = type;
}

function clearText(){
	$("seqcode").value = "";
	$("itemsname").value = "";
	$("typecode").value = "";
}

//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form"
	action="/ITEMS0171_Disp">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span class="red">*</span><span>物品种类：</span> <span> <html:select
		property="category" style="width: 100px;"
		errorStyleClass="inputError imeActive">
		<html:options collection="ADcategory_options" property="value" name=""
			labelProperty="label" />
	</html:select></span> <span class="red">*</span><span>物品名称：</span> <span> <html:text
		property="itemsname" size="20" readonly="true"
		styleClass="inputDisable"/>
		<img src="images/seek.gif" style="cursor: hand;" alt="物品名称" width="16" height="16" onclick="selectSeqCode();" /> 
		<html:hidden property="seqcode" styleId="seqcode"/><html:hidden property="typecode" styleId="typecode"/></span> 
		&nbsp;&nbsp;<span><br><span
		class="red">*</span>时间：从</span><span><html:text property="outtime_f"
		styleId="outtime_f" errorStyleClass="inputError imeDisabled" size="16"
		readonly="true" /> <img src="images/date.gif" align="middle"
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
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="7%">交易日期</th>
			<th width="7%">交易类型</th>
			<th width="7%">使用机构</th>
			<th width="7%">物品编号</th>
			<th width="11%">物品名称</th>
			
			<th width="7%">物品种类</th>
			<th width="7%">入库数量</th>
			<th width="7%">入库单价</th>
			<th width="7%">入库金额</th>
			<th width="7%">出库数量</th>
			<th width="7%">出库单价</th>
			<th width="7%">出库金额</th>
			<th width="5%">收益</th>
			<th width="7%">库存数量</th>

		</tr>
		<logic:present name="ITEMS01711VO" property="items01712VOList">
			<logic:iterate id="vo" name="ITEMS01711VO"
				property="items01712VOList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td>${vo.date}</td>
					<td><ig:cseCodeValue codeIndex="5"
						codeValue="${vo.outStockDetail.outtype}" /></td>
					<td><ig:cseOrgValue orgsyscoding="${vo.outStockDetail.reqorg}" /></td>
					<td>${vo.outStockDetail.seqcode}</td>
					<td>${vo.outStockDetail.itemsname}</td>
					
					<td><ig:cseCodeValue
						codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>"
						codeValue="${vo.outStockDetail.category}" /></td>

					<td>${vo.inNum}</td>
					<td>${vo.inPrice}</td>
					<td>${vo.inCountPrice}</td>
					<td>${vo.outNum}</td>
					<td>${vo.outPrice}</td>
					<td>${vo.outCountPrice}</td>
					<td>${vo.income}</td>
					<td>${vo.stockNum}</td>
				</tr>
			</logic:iterate>
			<logic:iterate id="vo" name="ITEMS01711VO"
				property="items01712VOList" length="1">
				 <tr>
                    <td><b>合计</b></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>${ITEMS01711VO.total}</td>
                    <td></td>
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
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
<bean:define id="id" value="ITEMS0147" toScope="request" />
<bean:define id="title" value="下拨查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	function operation(name,id){
		if(name=="search"){
			document.forms[0].action=getAppRootUrl() + "/ITEMS0147.do";
			document.forms[0].submit();
		}else if(name=="read"){
			document.forms[0].sid.value=id;
			document.forms[0].action=getAppRootUrl() + "/ITEMS0147_READ.do";
			document.forms[0].submit();
		}
	}

	function setOrg(url){
		 
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

		if("_resetall"==temp){
			document.forms[0].reqorg_q.value = "";
			document.forms[0].reqorg_name.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].reqorg_q.value = temp.split("|")[0];
			document.forms[0].reqorg_name.value = temp.split("|")[1];
		}
		
	}
//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/ITEMS0147_Disp">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<input type="hidden" name="sid" >
<span>接收机构：</span><span><html:text property="reqorg_name" readonly="true"></html:text>
<img src="images/tree.gif" style="cursor: hand;" alt="选择接收机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_ROLETREE.do');"/>
<html:hidden property="reqorg_q"/></span>&nbsp;&nbsp; 
<span>物品种类：</span><span><html:select property="category_q" style="width: 100px;" errorStyleClass="inputError imeActive" >
<html:options collection="category_options" property="value" name="" labelProperty="label" />
</html:select> </span>&nbsp;&nbsp; 
<span>状态：</span><span> <html:select property="reqstatus_q" style="width: 100px;" errorStyleClass="inputError imeActive" >
<html:options collection="reqstatus_options" property="value" name="" labelProperty="label" />
</html:select></span><br />
<span>
下拨开始日期:
</span><html:text property="reqtime_f" styleId="reqtime_f" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('reqtime_f'))"
			border="0" style="cursor: hand" />
<span>&nbsp;&nbsp;下拨结束日期:
</span><html:text property="reqtime_t" styleId="reqtime_t" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('reqtime_t'))"
			border="0" style="cursor: hand" />&nbsp;&nbsp; 
<html:button property="btn_search" styleClass="button" value="查询" onclick="operation('search')"/>
	</div>
	
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="14%">物品种类</th>
				<th width="8%">物品编号</th>
				<th width="13%">物品名称</th>
				<th width="10%">物品型号</th>
				<th width="13%">接收机构</th>
				<th width="12%">下拨时间</th>
				<th width="8%">库存数量</th>
				<th width="8%">下拨数量</th>
				<th width="8%">出库数量</th>
				<th width="6%">状态</th>
			</tr>
			<logic:present name="ITEMS01081VO" property="outStockList">
				<logic:iterate id="bean" name="ITEMS01081VO"
					property="outStockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
						</td>
						<td>${bean.seqcode}</td>
						<td>${bean.itemsname}</td>
						<td>${bean.typecode}</td>
						<td>
							<ig:cseOrgValue orgsyscoding="${bean.reqorg}"/>
						</td>
						<td>${bean.reqtime}</td>
						<td>${bean.stocknum}</td>
						<td>${bean.chknum}</td>
						<td>${bean.outnum}</td>
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS%>" codeValue="${bean.reqstatus}" />
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<div class="operate_btn">
	 <!-- paging --> <jsp:include page="/include/paging.jsp" /></div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0127" toScope="request" />
<bean:define id="title" value="结账管理查询页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">
function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].reqorg.value = "";
		document.forms[0].reqorg_name.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].reqorg.value = temp.split("|")[0];
		document.forms[0].reqorg_name.value = temp.split("|")[1];
	}
}
function exportExcel() {
	document.forms[0].action = getAppRootUrl() + "/ITEMS0126.do?report=1";
	document.forms[0].submit();
}
function search() {
	document.forms[0].action = getAppRootUrl() + "/ITEMS0126.do";
	document.forms[0].submit();
}
</script>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
<html:form action="/ITEMS0126.do">
<div class="img"></div>
<div class="conditions">
<div>
<span>申领机构：</span><span><html:text property="reqorg_name" readonly="true"></html:text>
<img src="images/tree.gif" style="cursor: hand;" alt="选择申领机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_ROLETREE.do');"/>
<html:hidden property="reqorg"/>
</span>&nbsp;&nbsp; 
<span>物品种类：</span><html:select property="category" errorStyleClass="inputError imeActive" >
   <html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp; 

<span>接收时间：从</span><html:text property="intime_f" styleId="intime_f" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('intime_f'))"
			border="0" style="cursor: hand" />
<span>&nbsp;&nbsp;到</span><html:text property="intime_t" styleId="intime_t" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('intime_t'))"
			border="0" style="cursor: hand" />&nbsp;&nbsp;
<br />
<span>结账状态：</span> <html:select property="accountstatus" errorStyleClass="inputError imeActive" >
   <html:options collection="accountstatusList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
<input type="button" value="查询"  class="button" onclick="search();" />
<input type="button" value="导出"  class="button" onclick="exportExcel();" />
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th width="12%">所属机构</th>
		<th width="9%">使用人</th>
		<th width="9%">物品编号</th>
		<th width="9%">物品名称</th>
		<th width="10%">物品型号</th>
		<th width="8%">出库数量</th>
		<th width="8%">出库价格</th>
		<th width="8%">出库金额</th>
		<th width="12%">接收时间</th>
		<th width="8%">出库类型</th>
		<th width="7%">结账状态</th>
	</tr>

	<logic:present name="ITEMS01011VO" property="outStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="outStockList" indexId="index">
			<bean:define id="map" name="ITEMS01011VO" property="editMap" type="java.util.Map"/>
			<bean:define id="inid" value="${bean.outstockid}"/>
			<tr class="bgRow<%=index%2 %>">
				<td>
					<ig:cseOrgValue orgsyscoding="${bean.reqorg}"/>
				</td>
				<td>
					${bean.rcvname}
				</td>
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td>${bean.outnum}</td>
				<td>${bean.outprice}</td>
				<td>${bean.outamount}</td>
				<td>${bean.rcvtime}</td>
				<td><ig:cseCodeValue codeIndex="5" codeValue="${bean.outtype}" /></td>
				<td><ig:cseCodeValue codeIndex="7" codeValue="${bean.accountstatus}" /></td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>
<div id="operate">
	<div class="operate_btn">
		<jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>
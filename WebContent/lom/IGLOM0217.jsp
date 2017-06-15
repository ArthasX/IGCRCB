<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.LOMHelper"%>
<html:html>
<bean:define id="id" value="IGLOM0217" toScope="request" />
<bean:define id="title" value="机构领用统计" toScope="request" />
<!-- header1 -->
<script type="text/javascript">
var gid='IGLOM0217';
function exportExcel() {
	document.forms[0].action = "IGLOM0217.do?report=1";
	document.forms[0].submit();	
}
function search() {
	if(!checkDateByContent("gotime_f","gotime_t")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}
	document.forms[0].action = "IGLOM0217.do?report=0";
	document.forms[0].submit();	
}
function checkSearch(){
	if(!checkDateByContent("gotime_f","gotime_t")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}else{
		return true;
	}

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
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 机构领用统计</p>
</div>
<div id="search">
<html:form action="/IGLOM0217">
<div class="img"></div>
<div class="conditions">
<div><label>领用机构：</label> <html:text property="goorgname"
		readonly="true"></html:text> <img src="images/tree.gif"
		style="cursor: hand;" alt="领用机构" width="16" height="16" border="0"
		onclick="setRoleDomain('IGSYM0101_TREE.do');" /> <html:hidden
		property="goreqorg" />
<span>领用开始时间</span>
<html:text property="gotime_f" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
<img src="images/date.gif" align="middle" onclick="calendar($('gotime_f'))" border="0" style="cursor: hand" />
<span>&nbsp;&nbsp;领用结束时间</span>
<html:text property="gotime_t" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
<img src="images/date.gif" align="middle" onclick="calendar($('gotime_t'))" border="0" style="cursor: hand" />
&nbsp;&nbsp;
<br><input type="button" value="查询" class="button" onclick="search();"/>
<input type="button" value="导出" class="button" onclick="exportExcel();"/>
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="5%">序号</th>
		<th width="15%">领用日期</th>
		<th width="10%">物品名称</th>
		<th width="10%">数量</th>
		<th width="10%">单价</th>
		<th width="10%">金额</th>
		<th width="15%">领用机构</th>
		<th width="10%">领用人</th>
		<th width="15%">接待工作名称</th>
	</tr>
	<logic:present name="IGLOM02171VO" property="goutstockList">
		<logic:iterate id="bean" name="IGLOM02171VO" property="goutstockList" indexId="index" type="com.csebank.lom.model.Goutstock">
			<tr>
				<td>${PagingDTO.viewStartCount+index}</td>
				<td>${bean.gotime}</td>
				<td>${bean.goname}</td>
				<td>${bean.goinnum}</td>
				<td>${bean.gooutprice}</td>
				<td>
					<%=LOMHelper.getMultiply(String.valueOf(bean.getGoinnum()),String.valueOf(bean.getGooutprice())) %>
				</td>
				<td><ig:cseOrgValue orgsyscoding="${bean.goreqorg}"/></td>
				<td>${bean.gorequsername}</td>
				<td>${bean.recptionTB.rname}</td>
			</tr>
		</logic:iterate>
	</logic:present>
</table>
</div>

<div id="operate">
	<div class="operate_btn">
		<span>
			<jsp:include page="/include/paging.jsp" />
		</span>
	</div>
</div>

</div>
</div>
</div>
</div>
</body>
</html:html>
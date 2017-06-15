<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0214" toScope="request" />
<bean:define id="title" value="库存统计信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function check(){
		
		document.forms[0].action=getAppRootUrl() + "/IGLOM0214.do";
		document.forms[0].submit();
	}
	function Excel(){
		document.forms[0].action=getAppRootUrl() + "/IGLOM0214_Excel.do";
		document.forms[0].submit();
	}
	
//-->
	function showIncident(){
	
	var ccid = "216";
	var cid = "";
	var syscode = "";
	if(null==syscode || ""==syscode){
		syscode = ccid;
	}else{
		ccid = syscode.substring(0,3);
	}

	url = "IGSYM1202_TREE_BY_STATUS.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("gscategory").value="";
		$("gcategoryname").value="";
			return false;
		}
	if(null!=temp && temp.split("|").length>1){
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

		
		$("gscategory").value=treesyscode;
		$("gcategoryname").value=name;
		
		
	}		
	
}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 库存统计</p>
</div>
<div id="search">
<html:form action="/IGLOM0214">
<div class="img"></div>
<div class="conditions">
<div>

<span>物品种类：</span> <span> 
	<html:text property="gcategoryname" size="18" readonly="true"/> 
	<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
	<html:hidden property="gscategory" />
</span>&nbsp;&nbsp;
 
<html:button property="btn_search" styleClass="button" value="查询" onclick="check();"/>
 <html:button property="btn_excel" styleClass="button" value="导出"  onclick="Excel();"/>
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th width="5%">序号</th>
		<th width="25%">物品种类</th>
		<th width="25%">物品名称</th>
		<th width="25%">物品编号</th>
		<th width="10%">最新库存数量</th>
		<th width="10%">冻结数量</th>
		
	</tr>

	<logic:present name="IGLOM02141VO" property="gstockList">
		<logic:iterate id="bean" name="IGLOM02141VO" property="gstockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>${PagingDTO.viewStartCount+index}</td>
				<td><ig:projectTypeValue ptype="${bean.gscategory}" /></td>
				<td>${bean.gsname}</td>
				<td>${bean.gscode}</td>
				<td>${bean.gsnum}</td>
				<td>${bean.gsfreezenum}</td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>

<div id="operate">
<!-- paging --> <jsp:include page="/include/paging.jsp" />
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>
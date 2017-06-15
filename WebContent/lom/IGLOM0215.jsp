<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0215" toScope="request" />
<bean:define id="title" value="出入库汇总查询" toScope="request" />
<!-- header1 -->
<script type="text/javascript">
var gid='IGLOM0215';
function viewDetail(category,code,reqnum){
	openSubWindow("/IGLOM0216.do?giodcategory=" + category + "&giodcode=" + code + "&giodreqnum=" + reqnum, "_blank", "800", "600");
}
function exportExcel() {
	document.forms[0].action = "IGLOM0215.do?report=1";
	document.forms[0].submit();	
}
function search() {
	document.forms[0].action = "IGLOM0215.do?report=0";
	document.forms[0].submit();	
}

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
		$("category").value="";
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

		
		$("category").value=treesyscode;
		$("gcategoryname").value=name;
		
		
	}		
	
}

</script>
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 出入库汇总查询</p>
</div>
<div id="search">
<html:form action="/IGLOM0215">
<div class="img"></div>
<div class="conditions">
<div><span>物品种类：</span>
	<html:text property="gcategoryname" size="18" readonly="true"/> 
	<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
	<html:hidden property="category" />&nbsp;&nbsp;
<input type="hidden" name="report" value="0" />
<input type="button" value="查询" class="button" onclick="search();"/>
<input type="button" value="导出" class="button" onclick="exportExcel();"/>
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="10%">序号</th>
		<th width="15%">物品种类</th>
		<th width="20%">物品名称</th>
		<th width="15%">单位</th>
		<th width="20%">入库数量</th>
		<th width="20%">出库数量</th>
	</tr>
	<logic:present name="IGLOM02151VO" property="ginoutStockDetailVWList">
		<logic:iterate id="bean" name="IGLOM02151VO" property="ginoutStockDetailVWList" indexId="index">
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');"
				 onclick="viewDetail('${bean.giodcategory}','${bean.giodcode}','${bean.giodreqnum}');">
				<td>${PagingDTO.viewStartCount+index}</td>
				<td>
					<ig:projectTypeValue ptype="${bean.giodcategory}" />
				</td>
				<td>${bean.giodname}</td>
				<td>${bean.giodunit}</td>
				<td>${bean.giodinnum}</td>
				<td>${bean.giodreliefnum + bean.giodoutnum + bean.giodhavocnum}</td>

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
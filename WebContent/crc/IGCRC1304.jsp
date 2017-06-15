<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC1304" toScope="request" />
<bean:define id="title" value="文档存量统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">

function modify(type){

	window.showModalDialog("IGCRC1303_Disp.do?type=" + type,
            null,"dialogWidth:1000px;dialogHeight:650px;status:no;help:no;resizable:no");
}

function selectTree(ccidinfo,selecedlast){
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selecedlast=" + selecedlast;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	
	if("_resetall"==temp){
		$("pivartreename").value = "";
	}else if(null!=temp && temp.split("|").length>1){
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

		if(treesyscode!=null && name!=null && treesyscode != ''){
			$("pivartreename").value = name;
		}else{
			$("pivartreename").value = '';
		}
		
	}		
	if($("pivartreename").onchange){
		$("pivartreename").onchange();
	}
}
function onSearch(){
	form.action = "IGCRC1303.do";
	form.submit();
}
function onExcel(){
	form.action = "IGCRC1305.do";
	form.submit();
}
</script>
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCRC1303" styleId="form" onsubmit="">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>统计条件</strong></span>
	</div>

	<div style="margin-top:12px;">
		<span class="subscribe">文档分类：</span>
		<html:text property="eiSort" styleId="pivartreename"  readonly="true"  size="32" style="width:200px"/>
		<input type="hidden" id="riskoperatordept" name="riskoperatordept" >
		<!-- <img src="images/seek.gif" style="cursor: hand;" alt="选择应对部门" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_ROLETREE.do');"/> -->
		<img style="cursor: hand;" onclick="selectTree('124_tree_文档分类','1');" alt="查询" src="images/seek.gif" complete="complete"/>
		<input type="button" value="查询" class="button" onclick="onSearch()">
		<input type="button" value="导出" class="button" onclick="onExcel()">
	</div>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="50%">文档类别</th>
			<th width="50%">文档总数</th>
       	</tr>
		<logic:present name="IGCRC1303VO" property="igcrc1303VWList">
			<logic:iterate id="bean" name="IGCRC1303VO"
				property="listVM" indexId="index">
				<tr class="alarmcolor_level" style='cursor:hand' onclick="modify('<bean:write name="bean" property="typeid" />');">
					<td  width="50%" style="text-align:center;">${bean.type}</td>
					<td  width="50%" style="text-align:center;">${bean.wordSum}</td> 
				</tr>
			</logic:iterate>
		</logic:present>
		<tr class="alarmcolor_level" style='cursor:hand' onclick="modify('');">
			<td>合计：</td>
			<logic:iterate id="sum" name="IGCRC1303VO" property="listSum" indexId="index">
				<td>${sum}</td>
			</logic:iterate>
		</tr>
	</table>
	</div>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
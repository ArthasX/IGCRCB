<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSYA0101" toScope="request" />
<bean:define id="title" value="制度查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function setTree(){
	var temp = window.showModalDialog("IGSYM1505_TREE.do?ccid=300&selecedlast=0",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("tree_show_value").value = "";
		document.getElementById("tree_value").value = "";
	}else if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
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
			document.getElementById("tree_show_value").value = name;
			document.getElementById("tree_value").value =treesyscode + "_tree_" + name;
		}else{
			document.getElementById("tree_show_value").value = "";
			document.getElementById("tree_value").value = "";
		}
		
	}	
}
jQuery(document).ready(function() {
	var typeValue ='${IGSYA0101Form.intype}';
	if(typeValue != ''){
		var typeName = typeValue.split("_tree_")[1];
		jQuery("#tree_show_value").val(typeName);
	}
});
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGSYA0101" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">制度汇编 &gt;&gt; 制度汇编 &gt;&gt;制度查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span>&nbsp;&nbsp;制度名称：</span><span>
		<html:text property="inname"/></span>
		&nbsp;&nbsp;
		<span>&nbsp;&nbsp;制度分类：</span>
		<span>
			<input type="text" name="show_tree" id="tree_show_value" readonly="readonly"/>
			<img src="images/seek.gif" align="middle" alt="查询" onclick="setTree();" style="cursor: hand;" border="0"/>
			<input type="hidden" name="varnames" id="tree_name" value="制度分类"/>
			<input type="hidden" name="intype" id="tree_value" value="${IGSYA0101Form.intype }"/>
		</span>
		<%-- 
		<span>制度内容：</span>
		<span><html:text errorStyleClass="inputError imeActive"
		property="painfo"/></span>&nbsp;&nbsp;<span> 
		<span>&nbsp;&nbsp;时间：从</span><span><html:text
		property="time_from" styleId="time_from"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('time_from'))"
		border="0" style="cursor: hand" />  </span> 
	<span>&nbsp;&nbsp;到</span><span><html:text property="time_to" styleId="time_to"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('time_to'))"
		border="0" style="cursor: hand" /></span>&nbsp;&nbsp; --%>
		
	<html:submit styleClass="button" value="查询" /></span></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="20%">制度分类</th>
			<th width="20%">制度名称</th>
			<th width="30%">制度内容</th>
			<th width="10%">发起者</th>
			<th width="12%">发起时间</th>
			<th width="8%">查看</th>
		</tr>
		<logic:present name="IGSYA0101VO" property="institutionList">
			<logic:iterate id="bean" name="IGSYA0101VO" property="institutionList" indexId="index">
					<tr>
					<td><bean:write name="bean" property="intype" /></td>
					<td><bean:write name="bean" property="inname" /></td>
					<td><bean:write name="bean" property="indesc" /></td>
					<td><bean:write name="bean" property="inusername" /></td>
					<td><bean:write name="bean" property="createtime" /></td>
					<td>
						<html:link action="/IGSYA0105.do?inid=${bean.inid}"> 
							<img src="images/look.gif" width="16" height="16" border="0"/>
						</html:link>			
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>

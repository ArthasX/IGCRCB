<%@page import="com.deliverik.infogovernor.crc.form.IGCRC0401Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.wkm.vo.IGWKM01011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<html:html>
<bean:define id="id" value="IGCRC0401C" toScope="request" />
<bean:define id="title" value="变更批量处理查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">
function submit_action(){
	var objs = document.getElementsByName("prid");
	var count = 0;
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(objs[i].checked){
				count ++;
			}				
		}
	}
	if(count > 0){
		if(window.confirm("是否确认提交？")){
			form.action = "IGCRC0402_Disp.do";
			form.submit();
		}
	}else{
		alert("请选择处理流程！");
	}
}
function setTree(obj){
	var temp = window.showModalDialog("IGSYM1505_TREE.do?ccid="+obj,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("tree_show_value").value = "";
		document.getElementById("tree_value").value = "";
		document.getElementById("tree_value2").value = "";
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
			if(110==obj){
			document.getElementById("tree_show_value").value = name;
			document.getElementById("tree_value").value =treesyscode + "_tree_" + name;
			}else{
			document.getElementById("tree_show_value2").value = name;
			document.getElementById("tree_value2").value =treesyscode + "_tree_" + name;
			}
		}else{
			if(110==obj){
			document.getElementById("tree_show_value").value = "";
			document.getElementById("tree_value").value = "";
			}else{
			document.getElementById("tree_show_value2").value = "";
			document.getElementById("tree_value2").value = "";
			}
		}
	}		
}
function init(){
	var value = "";
	var value2 = "";
	<%
	IGCRC0401Form form = (IGCRC0401Form)request.getSession().getAttribute("IGCRC0401Form");
	if(form != null){
		String[] varnames = form.getVarnames();
		String[] varvalues = form.getVarvalues();
		if(varnames != null && varnames.length > 0 && varvalues != null && varvalues.length > 0){
			for(int i=0;i<varnames.length;i++){
				if("变更类型".equals(varnames[i])){
					if(varvalues.length >= i){
						%>
						value = '<%=varvalues[i]%>';
						<%
					}
				} 
				if("涉及的业务系统".equals(varnames[i])){
					if(varvalues.length >= 0){
						%>
						value2 = '<%=varvalues[i]%>';
						<%
						break;
					}
				}
		}
	}
	}
%>
	if(value != ""){
		document.getElementById("tree_show_value").value = value.split("_tree_")[1];
		document.getElementById("tree_value").value = value;
	}
	if(value2 != ""){
		document.getElementById("tree_show_value2").value = value2.split("_tree_")[1];
		document.getElementById("tree_value2").value = value2;
	}
	var objs = document.getElementsByName("varvalues");
	for(var i=0;i<objs.length;i++){
		if(objs[i].nodeName == 'SELECT'){
			objs[i].style.width = 105;
		}
	}

	onHidden();
}

function onShow(){
	document.getElementById("moreDiv").style.display="";
	document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
}

function onHidden(){
	document.getElementById("moreDiv").style.display="none";
	document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";

}
</script>
<body onload="init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
<html:form action="/IGCRC0401" styleId="form" onsubmit="return checkSubmit(this);">
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
		<label id="label_img" style="margin-left:736px;margin-top:-1px;">
    		<img src="images/moreSearch.gif" align="middle" alt="更多搜索条件" onclick="onShow()" style="cursor: hand;" border="0"/>
   	    </label>
	</div>
	<div>
		<span class="subscribe">工单号：</span>
		<html:text property="prserialnum" size="12" />
		<span class="subscribe">变更名称：</span>
		<html:text property="prtitle"/>
		<span class="subscribe">变更类型：</span>
		<input type="text" name="show_tree" id="tree_show_value" readonly="readonly"/>
		<input type="hidden" name="varnames" id="tree_name" value="变更类型"/>
		<input type="hidden" name="varvalues" id="tree_value" />
		<img src="images/seek.gif" alt="查询" onclick="setTree(110);" style="cursor: hand"/>
		<span class="subscribe" style="width:58px;">处理人：</span>
		<html:text property="ppusername_like"/>
		<html:submit styleClass="button" value="查询" />
	</div>
	<div style="margin-top:8px;">
		<logic:present name="AD_ProcessInfoQueryMap" scope="session">
		<logic:iterate id="map" name="AD_ProcessInfoQueryMap" scope="session" indexId="index">
			<c:if test="${index == 2 }">
				<span class="subscribe">发起时间：</span>
				<html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
				<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
				<span>&nbsp;--&nbsp;</span>
				<html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
				<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
				<input type="hidden" name="varnames" id="tree_name" value="涉及的业务系统"/>
				<input type="hidden" name="varvalues" id="tree_value2" />
				</div>
				<div id="moreDiv" style="margin-top:7px;">
			</c:if>
			<bean:define id="bean" name="map" property="value"/>
			<ig:processInfoQuery pdid="${bean.pdid }" pidname="${bean.pidname }" name="IGCRC0401Form" property="varvalues[${index }]" style="margin-left:6px;margin-top:8px;" styleClassTagName="subscribe"/>
		</logic:iterate> 
	</logic:present>
	</div>
	<div style="margin-top:8px;"></div>
	</div>
</div>
</div>
	<html:hidden property="pdid"/>
	<html:hidden property="prstatus"/>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
		<table class="table_style">
			<tr>
				<th width="10%">
					<input type="checkbox" name="prids" id="prids" onclick="selectAll('prids','prid')" style="border:none;"/>
				</th>
				<th width="10%">工单号</th>
				<th width="25%">变更名称</th>
				<th width="10%">变更类型</th>
				<th width="10%">发起人</th>
				<th width="15%">工单状态</th>
				<th width="15%">发起时间</th>
			</tr>
			<logic:present name="IGCRC04011VO" property="prList">
				<logic:iterate id="bean" name="IGCRC04011VO" property="prList">
					<tr>
						<td>
							<input type="checkbox" name="prid" value="${bean.prid }" style="border:none;"/>
						</td>
						<td>
							<a href="javascript:void(0);" onclick="openRelatedProcess(${bean.prid},'WD');">
								${bean.prserialnum }
							</a>
						</td>
						<td>${bean.prtitle }</td>
						<td><ig:publicProcessInfoValue pidname="变更类型" prid="${bean.prid}"/></td>
						<td>${bean.prusername }</td>
						<td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
						<td>${bean.propentime }</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<input type="button" class="button" value="批量处理" onclick="submit_action();"/>
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>

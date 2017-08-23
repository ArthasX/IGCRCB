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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html:html>
<bean:define id="id" value="IGCRC4001" toScope="request" />
<bean:define id="title" value="生产事件汇总" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<style>
div span{
overflow:hidden;text-overflow:ellipsis；
}

</style>
<script>
//表单配置的查询条件加样式 
	function setTree(){
		var temp = window.showModalDialog("IGSYM1505_TREE.do?ccid=101&selecedlast=0",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
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
	
	function onShow(){
		document.getElementById("showFlag").value = 1;
		document.getElementById("div_0.0").style.display="";
		document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	function onHidden(){
		document.getElementById("showFlag").value = 0;
		document.getElementById("div_0.0").style.display="none";
		document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	
	function setTree(){
		var temp = window.showModalDialog("IGSYM1505_TREE.do?ccid=101&selecedlast=0",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
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
	
	function init(){
		var flag = document.getElementById("showFlag").value;
		if(flag!=1){
			onHidden();
		}
		else{
			onShow();	
		}

		
		var objs = document.getElementsByName("varvalues");
		for(var i=0;i<objs.length;i++){
			if(objs[i].nodeName == 'SELECT'){
				objs[i].style.width = 105;
			}
		}
		
		
		
		
	}
	
	function sortDeal(){
		var obj = document.getElementById("table_list");
		for(var i=1;i<obj.rows.length;i++){
			var cell_sort = obj.rows[i].cells[2];
			var value = cell_sort.innerHTML;
			cell_sort.innerHTML = "<a href=\"javascript:void(0)\" style=\"text-decoration:none;color:#000000;\" title=\""+value+"\">"+value.split("-")[value.split("-").length-1]+"</a>";
		}
	}
	
	function onExcel(){
		form.action = "IGCRC4001_Export.do";
		form.submit();
	}
	
	function onSearch(){
		form.action = "IGCRC4001.do";
		form.submit();
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
	<html:form action="/IGCRC4001" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span style="font-size: 15px;"><strong>查询条件</strong></span> <label id="label_img" style="margin-left: 736px; margin-top: -1px;"> <img src="images/moreSearch.gif" align="middle" alt="更多搜索条件" onclick="onShow()" style="cursor: hand;" border="0" />
	</label>
	</div>
	<div>
	<span class="subscribe">事件工单号：</span>
	<html:text property="eventNum" size="12" />
	<span class="subscribe">事件名称：</span>
	<html:text property="eventTitle" />
	<span class="subscribe">事件发起人：</span>
	<html:text property="eventusername"/>
	<span class="subscribe" style="width: 80px">事件状态：</span>
	<html:select property="eventstatus">
	<html:option value=""></html:option>
	<logic:iterate id="bean" name="IGCRC4001VO" property="eslist"
				indexId="index">
	<html:option value="${bean}">${bean}</html:option>
	</logic:iterate>

	</html:select>
	
</div>
		<div id="div_0.0" style="margin-top: 12px;">
	<div>
		<span class="subscribe" >事件来源：</span>
		<html:select property="eventSource">
        <html:option value=""></html:option>
	      <logic:iterate id="bean" name="IGCRC4001VO" property="sourcelist"
				indexId="index">
	    <html:option value="${bean}">${bean}</html:option>
	    </logic:iterate>
	    </html:select>						
		
		<span class="subscribe"  style="width: 110px;">事件涉及应用系统：</span>
	    <html:text property="involveSystem"/>					
		
		<span class="subscribe">事件影响范围：</span>
		<html:select property="influenceRange">
		 <html:option value=""></html:option>
	      <logic:iterate id="bean" name="IGCRC4001VO" property="affectlist"
				indexId="index">
	    <html:option value="${bean}">${bean}</html:option>
	    </logic:iterate>
<%-- 		<html:options collection="statusBeanList" property="value" labelProperty="label" /> --%>
	    </html:select>										       
		</div>
		
		<div style="margin-top: 8px;">
		 <span class="subscribe">问题工单号：</span>
		<html:text property="problemNum" size="12" />
		<span class="subscribe">问题名称：</span>
		<html:text property="problemTitle" />				
		<span class="subscribe">问题发起人：</span>
		<html:text property="problemusername" />
		</div>
		<div style="margin-top: 8px;">
		<span class="subscribe" style="width: 80px">问题状态：</span>
		<html:select property="problemstatus">
		 <html:option value=""></html:option>
	      <logic:iterate id="bean" name="IGCRC4001VO" property="pslist"
				indexId="index">
	    <html:option value="${bean}">${bean}</html:option>
	    </logic:iterate>
<%-- 		<html:options collection="statusBeanList" property="value" labelProperty="label" /> --%>
		</html:select>								
		<span class="subscribe">问题描述：</span>
		<html:text property="problemcontent" />
		<span class="subscribe">问题发起时间从：</span>
		<html:text property="problemopentime_from" styleId="problemopentime_from" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;" />
		<img src="images/date.gif" align="middle" onclick="calendar($('problemopentime_from'))" border="0" style="cursor: hand" /> <span>&nbsp;--&nbsp;</span>
		<html:text property="problemopentime_to" styleId="problemopentime_to" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;" />
		<img src="images/date.gif" align="middle" onclick="calendar($('problemopentime_to'))" border="0" style="cursor: hand" /> 
		</div>
		</div>
		<span class="subscribe">事件分类：</span> <input type="text" name="show_tree" id="tree_show_value" readonly="readonly" /> 
		<img src="images/seek.gif" align="middle" alt="查询" onclick="setTree();" style="cursor: hand;" border="0" />
	    <input type="hidden" name="varnames" id="tree_name" value="事件分类"/> 
		<input type="hidden" name="varvalues" id="tree_value"/> 
		<span class="subscribe">事件发起时间从：</span>
		<html:text property="happenTime_from" styleId="happenTime_from" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;" />
		<img src="images/date.gif" align="middle" onclick="calendar($('happenTime_from'))" border="0" style="cursor: hand" /> <span>&nbsp;--&nbsp;</span>
		<html:text property="happenTime_to" styleId="happenTime_to" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;" />
		<img src="images/date.gif" align="middle" onclick="calendar($('happenTime_to'))" border="0" style="cursor: hand" /> 
		<html:submit styleClass="button" value="查询" onclick="onSearch();"/>
		<input type="button" value="导出" class="button" onclick="onExcel()">
	

		</div>
</div>
	<div id="results_list" style="overflow-x:scroll; overflow-y:hidden;width:980px;"> <ig:message /> <!--  /message -->
	<table class="table_style" style="width:2000px;">
		<tr>
			<th width="100px;">事件单号</th>
			<th width="100px;">发生时间</th>
			<th width="100px;">是否已关闭</th>
			<th width="100px;">事件来源</th>			
			<th width="150px;">事件名称</th>
			<th width="200px;">事件分类</th>
			<th width="150px;">涉及应用系统</th>			
			<th width="100px;">影响范围</th>
			<th width="200px;">影响范围备注</th>
			<th width="100px;">事件等级</th>
			<th width="100px;">事件原因</th>
			<th width="150px;">应急解决方案</th>
			<th width="100px;">问题单号</th>
			<th width="150px;">后续优化方案</th>
			<th width="100px;">计划解决时间</th>
			<th width="100px;">责任人</th>
		</tr>
		<logic:present name="IGCRC4001VO" property="listep">
			<logic:iterate id="bean" name="IGCRC4001VO" property="listep"
				indexId="index">
				
					<tr>
					<bean:define id="eventprid" value="${fn:split(bean.id,'_sp_')[0]}"/>
					<td>				
					<c:if test="${eventprid!='0' }">
					<a href="###" onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=${eventprid}&jump=478');">
					${bean.eventNum}
					</a>
					</c:if>
					</td>
					<td>
					${bean.happenTime}	
					</td>
					<td>
					${bean.isClosed}
					</td>
					<td>
					${bean.eventSource}
					</td>
					<td>
					${bean.eventTitle}
					</td>
					<td>
					${bean.eventType}
					</td>
					<td>
					${bean.involveSystem}
					</td>					
					<td>
					${bean.influenceRange}						
					</td>
					<td>	
					${bean.influenceRangeRemarks}
					</td>
					<td>	
					${bean.eventLevel}
					</td>
					<td>	
					${bean.eventCause}
					</td>
					<td>	
					${bean.emergencySolution}
					</td>
					<td>	
					<bean:define id="problemprid" value="${fn:split(bean.id,'_sp_')[1]}"/>
					<c:if test="${problemprid!='0' }">
					<a href="###" onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=${problemprid}&jump=478');">
					${bean.problemNum}
					</a>
					</c:if>					
					</td>
					<td>	
					${bean.pptimizationScheme}
					</td>
					<td>	
					${bean.plannedSolutionTime}
					</td>
					<td>	
					${bean.personLiable}
					</td>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<input type="hidden" name="showFlag" id="showFlag" value="${showFlag}">
	</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>

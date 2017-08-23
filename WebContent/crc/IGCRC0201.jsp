<%@page import="com.deliverik.infogovernor.wkm.form.IGWKM0101Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.crc.model.vo.IGCRC0208VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<%
	IGCRC0208VO vo = (IGCRC0208VO) request.getAttribute("vo");
	Map<String, String> nameURLMap = null;
	List<IG259Info> processTemplateList = null;
	List<IG380Info> processDefinitionList = null;
	if (vo != null) {
		nameURLMap = vo.getNameURLMap();
		processTemplateList = vo.getProcessTemplateList();
		processDefinitionList = vo.getProcessDefinitionList();
	}
%>
<html:html>
<bean:define id="id" value="IGCRC0201" toScope="request" />
<bean:define id="type" name="IGWKM0101Form" property="prtype" />
<bean:define id="title" value="${IGCRC0208VO.actlabel}" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
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
		
		
		sortDeal();
		
		
	}
	jQuery(function(){
		var parameter = jQuery("#param").val();
	 	if(parameter == 1){
	 		//告警事件
	 		jQuery("option[value='监控告警']").parents().children("option").each(function(){
	 			var obj = jQuery(this);
				if(obj.val() != '监控告警'){
					jQuery(this).remove();					
				} 			
	 		});
	 	}else if(parameter == ''){
	 		//其他事件
	 		jQuery("option[value='监控告警']").remove();
	 	}
	 	
	 	var sjfl = jQuery("#tree_value").val();
	 	if(sjfl!=""&&sjfl!=null){
	 		jQuery("#tree_show_value").val(sjfl.split("_tree_")[1]);
	 	}
	});
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
	function sortDeal(){
		var obj = document.getElementById("table_list");
		for(var i=1;i<obj.rows.length;i++){
			var cell_sort = obj.rows[i].cells[2];
			var value = cell_sort.innerHTML;
			cell_sort.innerHTML = "<a href=\"javascript:void(0)\" style=\"text-decoration:none;color:#000000;\" title=\""+value+"\">"+value.split("-")[value.split("-").length-1]+"</a>";
		}
	}
	
	function onExcel(){
		form.action = "IGCRC0204.do";
		form.submit();
		return false;
	}
	function onSearch(){
		form.action = "IGCRC0208.do";
		form.submit();
	}
	function checkSubmit(obj){
		return true;
	}
	
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body onload="init();">
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<html:form action="/IGCRC0208.do" styleId="form" onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								<ig:navigation />
							</p>
						</div>
						<div id="search">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span style="font-size: 15px;"><strong>查询条件</strong></span> <label id="label_img" style="margin-left: 736px; margin-top: -1px;"> <img src="images/moreSearch.gif" align="middle" alt="更多搜索条件" onclick="onShow()" style="cursor: hand;" border="0" />
									</label>
								</div>
								<div>
									<span class="subscribe">工单号：</span>
									<html:text property="prserialnum" size="12" />
									<span class="subscribe">事件名称：</span>
									<html:text property="prtitle" />
									<span class="subscribe">发起人：</span>
									<html:text property="prusername" />
									<span class="subscribe" style="width: 80px">状态：</span>
									<html:select property="prstatus">
										<html:options collection="statusBeanList" property="value" labelProperty="label" />
									</html:select>
									<html:submit styleClass="button" value="查询" onclick="onSearch()" />
									<html:hidden property="selectstatus" name="selectstatus" value="1" />
								</div>
								<div style="margin-top: 12px;">
									<span class="subscribe">事件分类：</span> <input type="text" name="show_tree" id="tree_show_value" readonly="readonly" /> <img src="images/seek.gif" align="middle" alt="查询" onclick="setTree();" style="cursor: hand;" border="0" /> <input type="hidden" name="varnames" id="tree_name" value="事件分类" /> <input type="hidden" name="varvalues" id="tree_value" value="${IGWKM0101Form.varvalues[0]}" /> <span class="subscribe" style="width: 58px;">处理人：</span>
									<html:text property="ppusername_like" />
									<span class="subscribe">发起时间：</span>
									<html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;" />
									<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" /> <span>&nbsp;--&nbsp;</span>
									<html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;" />
									<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
									 <input type="button" value="导出" class="button" onclick="onExcel()">
								</div>
								<logic:present name="AD_ProcessInfoQueryMap" scope="session">
									<logic:iterate id="map" name="AD_ProcessInfoQueryMap" scope="session" indexId="index">
										<c:if test="${(index)%4==0 }">
											<div id="div_${index/4}" style="margin-top: 7px; display: none;">
										</c:if>

										<bean:define id="bean" name="map" property="value" />
										<ig:processInfoQuery pdid="${bean.pdid }" pidname="${bean.pidname }" name="IGWKM0101Form" property="varvalues[${index+1 }]" style="margin-left:6px;margin-top:8px;" styleClassTagName="subscribe" />
									</logic:iterate>
								</logic:present>							
							</div>
							<div style="margin-top: 8px;"></div>
						</div>
				</div>
				<div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
					<table id="table_list" class="table_style">
						<tr>
							<th width="8%">
							<a href="#">工单号</a>
							</th>
							<th width="9%">
							<a href="#">发生时间</a>
							</th>
							<th width="7%">
							<a href="#">是否已关闭</a>
							</th>
							<th width="8%">事件来源</th>
							<th width="8%">
							<a href="#">事件名称</a>
							</th>
							<th width="10%">
							<a href="#">事件分类</a>
							</th>
							<th width="9%">
							<a href="#">涉及应用系统</a>
							</th>
							<th width="8%">
							<a href="#">影响范围</a>
							</th>
							<th width="10%">
							<a href="#">影响范围备注</a>
							</th>
							<th width="7%">
							<a href="#">事件等级</a>
							</th>
							<th width="8%">
							<a href="#">事件原因</a>
							</th>
							<th width="8%">
							<a href="#">应急解决方案</a>
							</th>
<!-- 							<th width="6%">严重程度</th> -->
<!-- 							<th width="6%">紧急程度</th> -->
							
						</tr>
						<logic:present name="IGCRC0208VO" property="processList">
							<logic:iterate id="bean" name="IGCRC0208VO" property="processList" indexId="index">
								<bean:define id="prtype" name="bean" property="prtype" />
								<logic:equal name="bean" property="prtype" value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE%>">
									<tr style='cursor: hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=476');">
								</logic:equal>
								<logic:notEqual name="bean" property="prtype" value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE%>">
									<tr style='cursor: hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" onclick="doLook('<%=nameURLMap.get(prtype) %><bean:write name="bean" property="prid" />');">
								</logic:notEqual>
								<td><bean:write name="bean" property="prserialnum" /></td>
								<td><bean:write name="bean" property="happenTime" /></td>
								<td><bean:write name="bean" property="isClosed" /></td>
								<td><bean:write name="bean" property="eventSource" /></td>
								<td><bean:write name="bean" property="prtitle" /></td>
								<td><bean:write name="bean" property="eventType" /></td>
								<td><bean:write name="bean" property="involveSystem" /></td>
								<td><bean:write name="bean" property="influenceRange" /></td>
								<td><bean:write name="bean" property="influenceRangeRemarks" /></td>
								<td><bean:write name="bean" property="eventLevel" /></td>
								<td><bean:write name="bean" property="eventCause" /></td>
								<td><bean:write name="bean" property="emergencySolution" /></td>
								
							</logic:iterate>
						</logic:present>
					</table>
				</div>
				<div id="operate">
					<jsp:include page="/include/paging.jsp" />
				</div>
				<input type="hidden" name="showFlag" id="showFlag" value="${showFlag}">
				<html:hidden property="prtype" styleId="prtype" />
				<html:hidden property="param" styleId="param" />
				<html:hidden property="prpdid" styleId="prpdid" />
				<html:hidden property="actname" styleId="actname" />
				<html:hidden property="type" />
				</html:form>
			</div>
		</div>
	</div>


	</div>
</body>
</html:html>

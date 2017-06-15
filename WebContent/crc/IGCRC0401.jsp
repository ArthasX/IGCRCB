<%@page import="com.deliverik.infogovernor.wkm.form.IGWKM0101Form"%>
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
<%
IGWKM01011VO vo = (IGWKM01011VO) request.getAttribute("vo");
Map<String,String> nameURLMap = null;
List<IG259Info> processTemplateList = null;
List<IG380Info> processDefinitionList = null;
if(vo != null){
	nameURLMap = vo.getNameURLMap();
	processTemplateList = vo.getProcessTemplateList();
	processDefinitionList = vo.getProcessDefinitionList();
}
%>
<html:html>
<bean:define id="id" value="IGCRC0401" toScope="request" />
<bean:define id="type" name="IGWKM0101Form" property="prtype" />
<bean:define id="title" value="${IGWKM01011VO.actlabel}" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- <script src="js/jquery-1.9.1.min.js"></script> -->
<!-- /header1 -->
<script type="text/javascript">
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
				
				document.getElementById("tree_show_value").value = name.split("-")[name.split("-").length-1];
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
		var value3 = "";
		<%
		IGWKM0101Form form = (IGWKM0101Form)request.getSession().getAttribute("IGWKM0101Form");
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
					if("更新平台".equals(varnames[i])){
						if(varvalues.length >=0){
							%>
							value3 = '<%=varvalues[i]%>';
							<%
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
		if(value3 != ""){
			document.getElementById("platform_value").value = value3;
		}
		var objs = document.getElementsByName("varvalues");
		for(var i=0;i<objs.length;i++){
			if(objs[i].nodeName == 'SELECT'){
				objs[i].style.width = 105;
			}
		}
	
		var flag = document.getElementById("showFlag").value;
		if(flag!=1){
			onHidden();
		}
		else{
			onShow();	
		}
		
		sortDeal();
	}


	function onShow(){
		document.getElementById("showFlag").value = 1;
		document.getElementById("div_0.25").style.display="";
		document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	
	function onHidden(){
		document.getElementById("showFlag").value = 0;
		document.getElementById("div_0.25").style.display="none";
		document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";
	
	}
	function onExcel(){
		form.action = "IGCRC0404.do";
		form.submit();
	}
	function onSubmit(){
		form.action = "IGWKM0103.do";
		form.submit();
	}
	
	function sortDeal(){
		var obj = document.getElementById("table_list");
		for(var i=1;i<obj.rows.length;i++){
			var cell_sort = obj.rows[i].cells[4];
			var value = cell_sort.innerHTML;
			cell_sort.innerHTML = "<a href=\"javascript:void(0)\" style=\"text-decoration:none;color:#000000;\" title=\""+value+"\">"+value.split("-")[value.split("-").length-1]+"</a>";
		}
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
	<html:form action="/IGWKM0103" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
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
		<html:button property="btn_search" value="查询" onclick="onSubmit();" styleClass="button"/>
		<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	<div style="margin-top:8px;">
		<span class="subscribe">工单状态：</span>
		<html:select property="prstatus">
    		<html:options collection="statusBeanList" property="value" labelProperty="label"/>
    	</html:select>
	<logic:present name="AD_ProcessInfoQueryMap" scope="session">
		<logic:iterate id="map" name="AD_ProcessInfoQueryMap" scope="session" indexId="index">
			<c:if test="${(index)%4==1 }">
					<span class="subscribe">发起时间：</span>
					<html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
					<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
					<span>&nbsp;--&nbsp;</span>
					<html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
					<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
					<input type="button" value="导出" class="button" onclick="onExcel()">
				</div>
				<div id="div_${index/4}" style="margin-top:7px;display:none;">
			</c:if>
			<bean:define id="bean" name="map" property="value"/>
			<ig:processInfoQuery pdid="${bean.pdid }" pidname="${bean.pidname }" name="IGWKM0101Form" property="varvalues[${index + 1 }]" style="margin-left:6px;margin-top:8px;" styleClassTagName="subscribe"/>			
		</logic:iterate> 
	</logic:present><br />
	<span class="subscribe">更新平台：</span>
		<input type="text" name="varvalues" id="platform_value" />
		<input type="hidden" name="varnames" id="platform_name" value="更新平台"/>
	<span class="subscribe">内容：</span>
	<html:text  property="content"/>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="table_list" class="table_style">
		<tr>
			<th width="2%"></th>
			<th width="2%"></th>
			<th width="8%"><a href="IGWKM0103.do?orderVal=prserialnum">工单号
			<logic:equal name="IGWKM0101Form" property="order" value="prserialnum">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="18%"><a href="IGWKM0103.do?orderVal=prtitle">变更名称			
			<logic:equal name="IGWKM0101Form" property="order" value="prtitle">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="8%"><a href="IGWKM0103.do?orderVal=prtype">变更类型
			<logic:equal name="IGWKM0101Form" property="order" value="prusername">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="8%"><a href="IGWKM0103.do?orderVal=prtype">变更分类
			<logic:equal name="IGWKM0101Form" property="order" value="prusername">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="8%"><a href="IGWKM0103.do?orderVal=prtype">更新平台
			<logic:equal name="IGWKM0101Form" property="order" value="prusername">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="8%"><a href="IGWKM0103.do?orderVal=prusername">发起人
			<logic:equal name="IGWKM0101Form" property="order" value="prusername">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="12%">当前处理人</th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=prstatus">工单状态
			<logic:equal name="IGWKM0101Form" property="order" value="prstatus">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=propentime">发起时间
			<logic:equal name="IGWKM0101Form" property="order" value="propentime">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=prclosetime">关闭时间
			<logic:equal name="IGWKM0101Form" property="order" value="prclosetime">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
		</tr>
		<logic:present name="IGWKM01011VO" property="processList">
			<logic:iterate id="bean" name="IGWKM01011VO" property="processList"
				indexId="index">
				<bean:define id="prtype" name="bean" property="prtype" />
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
					<td>
					<ig:ProcessInfoValueLevelImgTag pdname="${bean.prpdname}"  prid="${bean.prid}" />
					</td>
					<td>
					</td>
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td><bean:write name="bean" property="prtitle" />
					</td>
					<td>
					<ig:publicProcessInfoValue pidname="变更类型" prid="${bean.prid}"/>
					</td>
					<td>	
						<ig:publicProcessInfoValue pidname="变更分类" prid="${bean.prid}"/>
					</td>
					<td>
						<ig:publicProcessInfoValue pidname="更新平台" prid="${bean.prid}"/>
					</td>
					<td><bean:write name="bean"
						property="prusername" />
					</td>
					<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
						</ig:SubstringShowEllipsisWriteTag>
						
					</td>
					<td>	
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
					<td><bean:write name="bean"
						property="propentime" />
					</td>
					<td><bean:write name="bean"
						property="prclosetime" />
					</td>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<input type="hidden" name="showFlag" id="showFlag" value="${showFlag}" > 
    <html:hidden property="prtype" styleId="prtype"/>
    <html:hidden property="prpdid" styleId="prpdid"/>
    <html:hidden property="actname" styleId="actname"/>
	</html:form>
</div>
</div>
</body>
</html:html>

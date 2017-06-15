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
<bean:define id="id" value="IGCRC2302" toScope="request" />

<bean:define id="title" value="程序开发查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script src="js/jquery-1.9.1.min.js"></script>
<!-- /header1 -->
<script type="text/javascript">
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
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
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
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="table_list" class="table_style">
		<tr>
			<th width="2%"></th>
			<th width="2%"></th>
			<th width="8%">工单号
			<logic:equal name="IGWKM0101Form" property="order" value="prserialnum">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></th>
			<th width="18%">名称			
			<logic:equal name="IGWKM0101Form" property="order" value="prtitle">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></th>
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
			<th width="10%">工单状态
			<logic:equal name="IGWKM0101Form" property="order" value="prstatus">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></th>
			<th width="10%">发起时间
			<logic:equal name="IGWKM0101Form" property="order" value="propentime">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></th>
			<th width="10%">关闭时间
			<logic:equal name="IGWKM0101Form" property="order" value="prclosetime">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></th>
		</tr>
		<logic:present name="IGCRC2301VO" property="processList">
			<logic:iterate id="bean" name="IGCRC2301VO" property="processList"
				indexId="index">
				<bean:define id="prtype" name="bean" property="prtype" />
				
				<logic:equal name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="javascript:openRelatedProcess('${bean.prid}','${bean.prtype}');">
				</logic:equal>
				<logic:notEqual name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="javascript:openRelatedProcess('${bean.prid}','${bean.prtype}');">
				</logic:notEqual>
					<td>
					<ig:ProcessInfoValueLevelImgTag pdname="${bean.prpdname}"  prid="${bean.prid}" />
					</td>
					<td>
						<ig:ProcessOverdueLevelImgTag prstatus="${bean.prstatus}" prid="${bean.prid}" />
					</td>
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td><bean:write name="bean"
						property="prtitle" />
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
						<logic:equal value="WD" name="bean" property="prtype">
						<ig:processDefineTypeValue prid="${bean.prid}"/>
						<logic:equal value="C" property="prsubstatus" name="bean">(中止)</logic:equal>
						</logic:equal>
						<logic:notEqual value="WD" name="bean" property="prtype">
						    <logic:notEqual value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
							</logic:notEqual>
							<logic:equal value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
							</logic:equal>
						</logic:notEqual>
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
	<div class="enter">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	</div> 
    <html:hidden property="prtype" styleId="prtype"/>
    <html:hidden property="prpdid" styleId="prpdid"/>
    <html:hidden property="actname" styleId="actname"/>
	</html:form>
</div>
</div>
</body>
</html:html>

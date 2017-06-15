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
<bean:define id="id" value="IGVIR0203" toScope="request" />
<bean:define id="type" name="IGWKM0101Form" property="prtype" />
<bean:define id="title" value="${IGWKM01011VO.actlabel}查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function ope(prid){
		window.showModalDialog("IGVIR0203.do?prid="+prid,null,"dialogWidth:800px;dialogHeight:400px;status:no;help:no;resizable:yes");
	}
	
	function setOrg(url){
		 
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].prorgid_like.value = "";
			document.forms[0].orgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].prorgid_like.value = temp.split("|")[0];
			document.forms[0].orgname.value = temp.split("|")[1];
		}		

	}
</script>	
<body >
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
	<div><span>编号：&nbsp;&nbsp;</span><html:text property="prserialnum" size="12" />
	<span>&nbsp;&nbsp;名称：</span><html:text property="prtitle"/>
	<span>&nbsp;&nbsp;时间：从</span><html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
	<span>&nbsp;&nbsp;到</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
	</div>
	<div>
	<span>发起者：</span><html:text property="prusername" style="width:90px"/>
	<span>&nbsp;&nbsp;内容：</span>
	<span><html:text errorStyleClass="inputError imeActive"
		property="prdesc" size="40" /></span>&nbsp;&nbsp;
	<span>&nbsp;&nbsp;流程状态：</span>
	<html:select property="prstatus" style="width: 100px;">
    	<html:options collection="statusBeanList" property="value" labelProperty="label"/>
    </html:select>
    <br>
   	<span>所属机构：</span><html:text property="orgname" readonly="true" name="IGWKM0101Form"/>
	<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>&nbsp;&nbsp;
	<html:hidden property="prorgid_like" name="IGWKM0101Form"/>
	<logic:present name="AD_ProcessInfoQueryMap" scope="session">
		<logic:iterate id="map" name="AD_ProcessInfoQueryMap" scope="session" indexId="index">
			<bean:define id="bean" name="map" property="value"/>
			<ig:processInfoQuery pdid="${bean.pdid }" pidname="${bean.pidname }" name="IGWKM0101Form" property="varvalues[${index }]"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${(index+1)%4==0 }">
				<br />
			</c:if>
		</logic:iterate> 
	</logic:present>
	<html:submit styleClass="button" value="查询" /></div>
	<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="2%"></th>
			<th width="2%"></th>
			<th width="8%"><a href="IGWKM0103.do?orderVal=prserialnum">编号
			<logic:equal name="IGWKM0101Form" property="order" value="prserialnum">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="18%"><a href="IGWKM0103.do?orderVal=prtitle">名称			
			<logic:equal name="IGWKM0101Form" property="order" value="prtitle">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="8%"><a href="IGWKM0103.do?orderVal=prusername">发起者
			<logic:equal name="IGWKM0101Form" property="order" value="prusername">
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
			
			<th width="12%">当前处理人</th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=prstatus">状态
			<logic:equal name="IGWKM0101Form" property="order" value="prstatus">
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
				
				<logic:equal name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					>
				</logic:equal>
				<logic:notEqual name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);"
					onclick="doLook('<%=nameURLMap.get(prtype) %><bean:write name="bean" property="prid" />');">
				</logic:notEqual>
					<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
					<ig:ProcessInfoValueLevelImgTag pdname="${bean.prpdname}"  prid="${bean.prid}" />
					</td>
					<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
						<ig:ProcessOverdueLevelImgTag prstatus="${bean.prstatus}" prid="${bean.prid}" />
					</td>
					<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
						<bean:write name="bean" property="prserialnum" />
					</td>
					<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
						<bean:write name="bean" property="prtitle" />
					</td>
					<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
						<bean:write name="bean" property="prusername" />
					</td>
					<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
						<bean:write name="bean" property="propentime" />
					</td>
					<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
						<bean:write name="bean" property="prclosetime" />
					</td>
					
					<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />" onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
						</ig:SubstringShowEllipsisWriteTag>
						
					</td>
					<logic:equal value="WD" name="bean" property="prtype">
						<logic:notEqual value="W" property="prstatus" name="bean">
							<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
								<ig:processDefineTypeValue prid="${bean.prid}"/>
							</td>
						</logic:notEqual>
						<logic:equal value="W" property="prstatus" name="bean">
							<td>
								<a href="javascript:ope(${bean.prid});"><ig:processDefineTypeValue prid="${bean.prid}"/></a>
							</td>
						</logic:equal>
					<logic:equal value="C" property="prsubstatus" name="bean">
						<td>(中止)</td>
					</logic:equal>
					</logic:equal>
					<logic:notEqual value="WD" name="bean" property="prtype">
						<td onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
						    <logic:notEqual value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
							</logic:notEqual>
							<logic:equal value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
							</logic:equal>
						</td>
					</logic:notEqual>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
    <html:hidden property="prtype" styleId="prtype"/>
    <html:hidden property="prpdid" styleId="prpdid"/>
    <html:hidden property="actname" styleId="actname"/>
	</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>

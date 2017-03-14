<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM09031VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<%
IGDRM09031VO vo = (IGDRM09031VO) request.getAttribute("IGDRM09031VO");
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
<bean:define id="id" value="IGDRM0903" toScope="request" />
<%-- <bean:define id="type" name="IGDRM0903Form" property="prtype" /> --%>
<bean:define id="title" value="指挥流程查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGDRM0903" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	<ig:ProcessBackUrlTag jump="${jump}"/>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
		<html:hidden property="prtype" value="WDC"/>
		<html:hidden property="prurgency" value="0"/>
		<div><span>编号：&nbsp;&nbsp;</span><html:text property="prserialnum" size="12" />
					<span>&nbsp;&nbsp;事件名称：</span><html:text property="prtitle"/>
					<span>&nbsp;&nbsp;时间：从</span><html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
					<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
					<span>&nbsp;&nbsp;到</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
					<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
					</div>
					<div>
					<span>发起者：</span><html:text property="prusername" style="width:90px"/>
					<span>&nbsp;&nbsp;流程状态：</span>
					<html:select property="prstatus" style="width: 100px;">
				    	<html:optionsCollection name="statusBeanList" value="value" label="label"/>
				    </html:select>
					&nbsp;&nbsp;<html:submit property="btn_search" value="查询" styleClass="button" />
				</div>
			</div>
<%-- 	&nbsp;&nbsp;<html:submit styleClass="button" value="查询" /></div> --%>
	<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="2%"></th>
			<th width="2%"></th>
			<th width="8%">编号</th>
			<th width="18%">事件名称</a></th>
			
			<th width="8%">发起者</th>
			<th width="10%">发起时间</th>
			<th width="10%">关闭时间</th>
			
			<th width="12%">当前处理人</th>
			<th width="10%">状态</th>
			<th width="12%">指挥图</th>
		</tr>
		<logic:present name="IGDRM09031VO" property="processList">
			<logic:iterate id="bean" name="IGDRM09031VO" property="processList"	indexId="index">
				<bean:define id="prtype" name="bean" property="prtype" />
				<logic:equal name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
				</logic:equal>
				<logic:notEqual name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);"
					onclick="doLook('<%=nameURLMap.get(prtype) %><bean:write name="bean" property="prid" />&jump=381');">
				</logic:notEqual>
					<td>
						<ig:ProcessInfoValueLevelImgTag pdname="${bean.prpdname}"  prid="${bean.prid}" />
					</td>
					<td>
						<ig:ProcessOverdueLevelImgTag prstatus="${bean.prstatus}" prid="${bean.prid}" />
					</td>
					<td>
						<bean:write name="bean" property="prserialnum" />
					</td>
					<td>
						<bean:write name="bean"	property="prtitle" />
					</td>
					<td>
						<bean:write name="bean"	property="prusername" />
					</td>
					<td>
						<bean:write name="bean"	property="propentime" />
					</td>
					<td>
						<bean:write name="bean"	property="prclosetime" />
					</td>
					
					<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
						</ig:SubstringShowEllipsisWriteTag>
						
					</td>
					<td>
					<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
					<td>
					<img src="images/drmEmy.png" alt="进入指挥图" width="16" height="16" border="0" style="cursor:hand" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" onclick="enterFigure('${bean.prid}');" />
					
					</td>
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
<script type="text/javascript">

//弹出流程图
function enterFigure(prid){
		window.open('IGDRM0911_Disp.do?prid='+prid, '应急指挥图', 'width=1024, height=768, scrollbars=no, resizable=no, status=no, top=0, left=0').focus();
		(window.event)&&(window.event.cancelBubble=true); 
// 		e&&e.stopPropagation();
}
</script>
</body>
</html:html>

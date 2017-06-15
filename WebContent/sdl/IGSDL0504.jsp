<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0504" toScope="request" />
<bean:define id="title" value="统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0504";

	//选择资产
	function selectEntity(){
		openSubIGCOM0302PARAM("?ecategory=SDL");
	}

	function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	    $("eiid").value = eiid;
		$("einame").value = einame;
	}

	function confirmDisp(){
		if($F('year').trim()==""){
			alert("年度不能为空！");
			return false;
		}
		return true;
	}

//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGSDL0504"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span class="red">*</span><span>年度：</span><html:select property="year" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true" />
	</html:select>
	<span>&nbsp;&nbsp;相关资产：</span><html:text property="einame" size="18" readonly="true" errorStyleClass="inputError imeActive" />
	<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntity()" style="cursor: hand" />&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" onclick="return confirmDisp();" /></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th rowspan="2" width="16%">资产</th>
			<th colspan="4" width="38%">业务连续性(实际/目标)</th>
			<th colspan="2" width="15%">安全(实际/目标)</th>
			<th width="16%">风险(实际/目标)</th>
			<th colspan="2" width="15%">容量(实际/目标)</th>
		</tr>
		<tr>
			<th width="10%">中断时间(分钟)</th>
			<th width="10%">连续百分比(%)</th>
			<th width="10%">受影响时间(分钟)</th>
			<th width="10%">稳定百分比(%)</th>
			<th width="8%">安全事件数</th>
			<th width="8%">安全评分</th>
			<th width="10%">风险评分</th>
			<th width="8%">容量事件数</th>
			<th width="8%">容量评分</th>
		</tr>
		<logic:present name="IGSDL05041VO" property="sdlYearSummaryList">
			<logic:iterate id="bean" name="IGSDL05041VO"
				property="sdlYearSummaryList" indexId="index">
				<bean:define id="sdlDefineInfo" name="bean" property="sdlDefineInfo" type="com.deliverik.infogovernor.sdl.model.SdlDefineInfo"></bean:define>
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" 
				onclick="doLook('IGSDL0501.do?eiid=${bean.sieiid}&year=${IGSDL0504Form.year}&menutype=entity')">
					<td>${bean.sieiname}</td>
					<td><logic:empty name="bean" property="breakm">－</logic:empty>${bean.breakm}/<span class="red"><logic:empty name="sdlDefineInfo" property="sdibreaky">－</logic:empty>${sdlDefineInfo.sdibreaky}</span></td>
					<td><logic:empty name="bean" property="continuousm">－</logic:empty>${bean.continuousm}/<span class="red"><logic:empty name="sdlDefineInfo" property="sdicontinuousy">－</logic:empty>${sdlDefineInfo.sdicontinuousy}</span></td>
					<td><logic:empty name="bean" property="impactm">－</logic:empty>${bean.impactm}/<span class="red"><logic:empty name="sdlDefineInfo" property="sdiimpacty">－</logic:empty>${sdlDefineInfo.sdiimpacty}</span></td>
					<td><logic:empty name="bean" property="steadym">－</logic:empty>${bean.steadym}/<span class="red"><logic:empty name="sdlDefineInfo" property="sdisteadyy">－</logic:empty>${sdlDefineInfo.sdisteadyy}</span></td>
					<td><logic:empty name="bean" property="safecasem">－</logic:empty>${bean.safecasem}/<span class="red"><logic:empty name="sdlDefineInfo" property="sdisafecasey">－</logic:empty>${sdlDefineInfo.sdisafecasey}</span></td>
					<td><logic:empty name="bean" property="safemarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.safemarkm}" />/<span class="red"><logic:empty name="sdlDefineInfo" property="sdisafemarky">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${sdlDefineInfo.sdisafemarky}" /></span></td>
					<td><logic:empty name="bean" property="riskmarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.riskmarkm}" />/<span class="red"><logic:empty name="sdlDefineInfo" property="sdiriskmarky">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${sdlDefineInfo.sdiriskmarky}" /></span></td>
					<td><logic:empty name="bean" property="capacitycasem">－</logic:empty>${bean.capacitycasem}/<span class="red"><logic:empty name="sdlDefineInfo" property="sdicapacitycasey">－</logic:empty>${sdlDefineInfo.sdicapacitycasey}</span></td>
					<td><logic:empty name="bean" property="capacitymarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.capacitymarkm}" />/<span class="red"><logic:empty name="sdlDefineInfo" property="sdicapacitymarky">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${sdlDefineInfo.sdicapacitymarky}" /></span></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<html:hidden property="eiid" styleId="eiid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
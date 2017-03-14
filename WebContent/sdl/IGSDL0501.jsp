<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0501" toScope="request" />
<bean:define id="title" value="统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0501";

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
		if($F('eiid').trim()=="" && $F('einame').trim()==""){
			alert("相关资产不能为空！");
			return false;
		}
		return true;
	}
	function changeDiv(){ 
		if('${IGSDL0501Form.menutype}'=='entity'){
			document.getElementById("search").style.display = "none";
		} else{
			document.getElementById("search").style.display = "";
		}
	}

//-->
	</script>
<body onload="changeDiv();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGSDL0501"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	<logic:equal name="IGSDL0501Form" property="menutype" value="entity">
	<div class="back"><a href="IGSDL0504.do" target="_self">返回</a></div>
	</logic:equal>
	</div>
	<div id="search" style="display: none;">
	<div class="img"></div>
	<div class="conditions">
	<div ><span class="red">*</span><span>年度：</span> <span> <html:select
		property="year" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true" />
	</html:select> </span>&nbsp;&nbsp;<span class="red">*</span><span>相关资产：</span> <span> <html:text
		property="einame" size="18" readonly="true"
		errorStyleClass="inputError imeActive" /> <img src="images/seek.gif"
		border="0" width="16" height="16" alt="查询" onclick="selectEntity()"
		style="cursor: hand" /> </span> <html:submit property="btn_search"
		styleClass="button" value="查询" onclick="return confirmDisp();" /></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th rowspan="2" width="8%">月份</th>
			<th colspan="4" width="38%">业务连续性</th>
			<th colspan="2" width="22%">安全</th>
			<th width="10%">风险</th>
			<th colspan="2" width="22%">容量</th>
		</tr>
		<tr>
			<th width="10%">中断时间(分钟)</th>
			<th width="10%">连续百分比(%)</th>
			<th width="10%">受影响时间(分钟)</th>
			<th width="10%">稳定百分比(%)</th>
			<th width="10%">安全事件数</th>
			<th width="10%">安全评分</th>
			<th width="10%">风险评分</th>
			<th width="10%">容量事件数</th>
			<th width="10%">容量评分</th>
		</tr>
		<logic:present name="IGSDL05011VO" property="sdlDefineInfo">
		<bean:define id="m" name="IGSDL05011VO" property="sdlDefineInfo"/>
			<tr>
                   <td bgcolor="#EEEEEE">定义标准(月)</td>
                   <td><logic:empty name="m" property="sdibreakm">－</logic:empty>${m.sdibreakm}</td>
                   <td><logic:empty name="m" property="sdicontinuousm">－</logic:empty>${m.sdicontinuousm}</td>
                   <td><logic:empty name="m" property="sdiimpactm">－</logic:empty>${m.sdiimpactm}</td>
                   <td><logic:empty name="m" property="sdisteadym">－</logic:empty>${m.sdisteadym}</td>
                   <td><logic:empty name="m" property="sdisafecasem">－</logic:empty>${m.sdisafecasem}</td>
                   <td><logic:empty name="m" property="sdisafemarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${m.sdisafemarkm}" /></td>
                   <td><logic:empty name="m" property="sdiriskmarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${m.sdiriskmarkm}" /></td>
                   <td><logic:empty name="m" property="sdicapacitycasem">－</logic:empty>${m.sdicapacitycasem}</td>
                   <td><logic:empty name="m" property="sdicapacitymarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${m.sdicapacitymarkm}" /></td>
            </tr>
		<logic:present name="IGSDL05011VO" property="sdlSummaryList">
			<logic:iterate id="bean" name="IGSDL05011VO"
				property="sdlSummaryList" indexId="index" length="12">
				<tr>
					<td>${bean.month}</td>
					<td><logic:empty name="bean" property="breakm">－</logic:empty><html:link action="/IGSDL0502_Disp.do?year=${IGSDL0501Form.year}&sieiid=${IGSDL0501Form.eiid}&month=${bean.month}&sitype=I">${bean.breakm}</html:link></td>
					<td><logic:empty name="bean" property="continuousm">－</logic:empty>${bean.continuousm}</td>
					<td><logic:empty name="bean" property="impactm">－</logic:empty><html:link action="/IGSDL0502_Disp.do?year=${IGSDL0501Form.year}&sieiid=${IGSDL0501Form.eiid}&month=${bean.month}&sitype=E">${bean.impactm}</html:link></td>
					<td><logic:empty name="bean" property="steadym">－</logic:empty>${bean.steadym}</td>
					<td><logic:empty name="bean" property="safecasem">－</logic:empty><html:link action="/IGSDL0502_Disp.do?year=${IGSDL0501Form.year}&sieiid=${IGSDL0501Form.eiid}&month=${bean.month}&sitype=P">${bean.safecasem}</html:link></td>
					<td><logic:empty name="bean" property="safemarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.safemarkm}" /></td>
					<td><logic:empty name="bean" property="riskmarkm">－</logic:empty><html:link action="/IGSDL0502_Disp.do?year=${IGSDL0501Form.year}&sieiid=${IGSDL0501Form.eiid}&month=${bean.month}&sitype=D"><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.riskmarkm}" /></html:link></td>
					<td><logic:empty name="bean" property="capacitycasem">－</logic:empty><html:link action="/IGSDL0502_Disp.do?year=${IGSDL0501Form.year}&sieiid=${IGSDL0501Form.eiid}&month=${bean.month}&sitype=C">${bean.capacitycasem}</html:link></td>
					<td><logic:empty name="bean" property="capacitymarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.capacitymarkm}" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
		<logic:present name="IGSDL05011VO" property="sdlSummaryList">
			<logic:iterate id="bean" name="IGSDL05011VO"
				property="sdlSummaryList" indexId="index" offset="12">
				<tr>
					<td bgcolor="#EEEEEE">年份汇总</td>
					<td><font color="red"><logic:empty name="bean" property="breakm">－</logic:empty>${bean.breakm}</font></td>
					<td><font color="red"><logic:empty name="bean" property="continuousm">－</logic:empty>${bean.continuousm}</font></td>
					<td><font color="red"><logic:empty name="bean" property="impactm">－</logic:empty>${bean.impactm}</font></td>
					<td><font color="red"><logic:empty name="bean" property="steadym">－</logic:empty>${bean.steadym}</font></td>
					<td><font color="red"><logic:empty name="bean" property="safecasem">－</logic:empty>${bean.safecasem}</font></td>
					<td><font color="red"><logic:empty name="bean" property="safemarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.safemarkm}" /></font></td>
					<td><font color="red"><logic:empty name="bean" property="riskmarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.riskmarkm}" /></font></td>
					<td><font color="red"><logic:empty name="bean" property="capacitycasem">－</logic:empty>${bean.capacitycasem}</font></td>
					<td><font color="red"><logic:empty name="bean" property="capacitymarkm">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.capacitymarkm}" /></font></td>
				</tr>
			</logic:iterate>
		</logic:present>
			 <tr>
                   <td bgcolor="#EEEEEE">定义标准(年)</td>
                   <td><logic:empty name="m" property="sdibreaky">－</logic:empty>${m.sdibreaky}</td>
                   <td><logic:empty name="m" property="sdicontinuousy">－</logic:empty>${m.sdicontinuousy}</td>
                   <td><logic:empty name="m" property="sdiimpacty">－</logic:empty>${m.sdiimpacty}</td>
                   <td><logic:empty name="m" property="sdisteadyy">－</logic:empty>${m.sdisteadyy}</td>
                   <td><logic:empty name="m" property="sdisafecasey">－</logic:empty>${m.sdisafecasey}</td>
                   <td><logic:empty name="m" property="sdisafemarky">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${m.sdisafemarky}" /></td>
                   <td><logic:empty name="m" property="sdiriskmarky">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${m.sdiriskmarky}" /></td>
                   <td><logic:empty name="m" property="sdicapacitycasey">－</logic:empty>${m.sdicapacitycasey}</td>
                   <td><logic:empty name="m" property="sdicapacitymarky">－</logic:empty><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${m.sdicapacitymarky}" /></td>
               </tr>
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
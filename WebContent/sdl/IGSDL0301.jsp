<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0301" toScope="request" />
<bean:define id="title" value="目标查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0301";
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="目标基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSDL0301_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}

	//选择资产
	function selectEntity(){
		openSubIGCOM0302PARAM("?ecategory=SDL");
	}

	function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	    $("sdieiid").value = eiid;
		$("sdieiname").value = einame;
	}

//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGSDL0301"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>年度：</span><html:select property="sdiyear"  errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	</html:select> 
	<span>&nbsp;&nbsp;相关资产：</span><html:text property="sdieiname" size="18" readonly="true" errorStyleClass="inputError imeActive" />
	<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntity()" style="cursor: hand" />&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" /></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th rowspan="2" width="3%"><label> <input
				type="checkbox" name="checkbox" id="checkbox"
				onclick="selectAll('checkbox','deleteSdlDefineInfoid')" /></label></th>
			<th rowspan="2" width="4%">年度</th>
			<th rowspan="2" width="12%">相关资产</th>
			<th colspan="4" width="35%">业务连续性(月／年)</th>
			<th colspan="2" width="16%">安全(月／年)</th>
			<th width="10%">风险(月／年)</th>
			<th colspan="2" width="16%">容量(月／年)</th>
			<th rowspan="2" width="4%">修改</th>
		</tr>

		<tr>
			<th>中断时间</th>
			<th>连续百分比</th>
			<th>受影响时间</th>
			<th>稳定百分比</th>
			<th>安全事件数</th>
			<th>安全评分</th>
			<th>风险评分</th>
			<th>容量事件数</th>
			<th>容量评分</th>
		</tr>
		<logic:present name="IGSDL03011VO" property="sdlDefineInfoList">
			<logic:iterate id="bean" name="IGSDL03011VO"
				property="sdlDefineInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:checkbox
						property="deleteSdlDefineInfoid" value="${bean.sdiid}" /> </label></td>
					<td>${bean.sdiyear}</td>
					<td><a href="javascript:void(0)" onclick="openSubIGCOM0303('${bean.sdieiid}','')">
					${bean.sdieiname}</a></td>
					<td><logic:empty name="bean" property="sdibreakm">－</logic:empty>${bean.sdibreakm}／<logic:empty
						name="bean" property="sdibreaky">－</logic:empty>${bean.sdibreaky}</td>
					<td><logic:empty name="bean" property="sdicontinuousm">－</logic:empty>${bean.sdicontinuousm}／<logic:empty
						name="bean" property="sdicontinuousy">－</logic:empty>${bean.sdicontinuousy}</td>
					<td><logic:empty name="bean" property="sdiimpactm">－</logic:empty>${bean.sdiimpactm}／<logic:empty
						name="bean" property="sdiimpacty">－</logic:empty>${bean.sdiimpacty}</td>
					<td><logic:empty name="bean" property="sdisteadym">－</logic:empty>${bean.sdisteadym}／<logic:empty
						name="bean" property="sdisteadyy">－</logic:empty>${bean.sdisteadyy}</td>
					<td><logic:empty name="bean" property="sdisafecasem">－</logic:empty>${bean.sdisafecasem}／<logic:empty
						name="bean" property="sdisafecasey">－</logic:empty>${bean.sdisafecasey}</td>
					<td><logic:empty name="bean" property="sdisafemarkm">－</logic:empty>${bean.sdisafemarkm}／<logic:empty
						name="bean" property="sdisafemarky">－</logic:empty>${bean.sdisafemarky}</td>
					<td><logic:empty name="bean" property="sdiriskmarkm">－</logic:empty>${bean.sdiriskmarkm}／<logic:empty
						name="bean" property="sdiriskmarky">－</logic:empty>${bean.sdiriskmarky}</td>
					<td><logic:empty name="bean" property="sdicapacitycasem">－</logic:empty>${bean.sdicapacitycasem}／<logic:empty
						name="bean" property="sdicapacitycasey">－</logic:empty>${bean.sdicapacitycasey}</td>
					<td><logic:empty name="bean" property="sdicapacitymarkm">－</logic:empty>${bean.sdicapacitymarkm}／<logic:empty
						name="bean" property="sdicapacitymarky">－</logic:empty>${bean.sdicapacitymarky}</td>
					<td><html:link
						action="/IGSDL0302_Edit_Disp.do?sdiid=${bean.sdiid}">
						<img src="images/edit.gif" width="16" height="16" border="0" />
					</html:link></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSDL03011VO"
		property="sdlDefineInfoList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button"
			onclick="return deleteRec('deleteSdlDefineInfoid');" /></span>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
	<html:hidden property="sdieiid" styleId="sdieiid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
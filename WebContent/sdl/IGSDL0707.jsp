<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0707" toScope="request" />
<bean:define id="title" value="统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0707";

	function confirmDisp(){
		if($F('kpiYear').trim()==""){
			alert("年度不能为空！");
			return false;
		}
		return true;
	}

//-->
	</script>
<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGSDL0705"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">事件KPI</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span class="red">*</span><span>年度：</span><html:select property="kpiYear" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true" />
	</html:select>
	<span>&nbsp;&nbsp;月份：</span><html:select property="kpiMonth">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	</html:select>&nbsp;&nbsp; 
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	<div><span>显示方式：</span> <span> <html:radio
		property="radioValue" styleId="radioValue" value="A">事件类别</html:radio>
	<html:radio property="radioValue" styleId="radioValue" value="B">紧急程度</html:radio>
	<html:radio property="radioValue" styleId="radioValue" value="C">事件类别+紧急程度</html:radio>
	<html:radio property="radioValue" styleId="radioValue" value="D">紧急程度+事件类别</html:radio>
	</span></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		align="left" class="table_style4">
		<tr>
			<th width="40%" align="center" valign="middle">事件类别</th>
			<th width="30%" align="center" valign="middle">紧急程度</th>
			<th width="30%" align="center" valign="middle">平均解决时间</th>
		</tr>
		<logic:present name="IGSDL07011VO" property="incidentKpiMap">
			<logic:iterate id="map" name="IGSDL07011VO" property="incidentKpiMap">
				<bean:define id="key" name="map" property="key" />
				<bean:define id="list" name="map" property="value"
					type="java.util.List" />
				<logic:iterate id="bean" name="list" indexId="index">
					<tr>
						<logic:equal name="index" value="0">
							<td rowspan="<%=list.size()%>">${key}</td>
						</logic:equal>
						<td>${bean.urgencyName}</td>
						<td><logic:empty name="bean" property="resolve">0</logic:empty>${bean.resolve}</td>
					</tr>
				</logic:iterate>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
</html:form></div>

<div class="zishiying"></div>


<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</div>
</body>
</html:html>
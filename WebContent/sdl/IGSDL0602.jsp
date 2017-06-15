<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0602" toScope="request" />
<bean:define id="title" value="统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0602";

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
<html:form styleId="form" action="/IGSDL0602"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">变更KPI</p>
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
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="25%">变更类型</th>
			<th width="25%">成功</th>
			<th width="25%">存在问题</th>
			<th width="25%">失败</th>
		</tr>
		<logic:present name="IGSDL06011VO" property="changeKpiList">
		<logic:iterate id="bean" name="IGSDL06011VO" property="changeKpiList">
			<tr>
                   <td>${bean.typeName}</td>
                   <td><logic:empty name="bean" property="success">0</logic:empty>${bean.success}</td>
                   <td><logic:empty name="bean" property="problem">0</logic:empty>${bean.problem}</td>
                   <td><logic:empty name="bean" property="fail">0</logic:empty>${bean.fail}</td>
            </tr>	
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
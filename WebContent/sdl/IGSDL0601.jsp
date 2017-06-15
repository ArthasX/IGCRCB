<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0601" toScope="request" />
<bean:define id="title" value="统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0601";

	function confirmDisp(){
		if($F('kpiYear').trim()==""){
			alert("年度不能为空！");
			return false;
		}
		return true;
	}

	function checkSub(prpdid, year, month){
		doLook('IGSVC0401D.do?prpdid='+prpdid+'&year='+year+'&month='+month+'&prstatus=C');
	}

//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGSDL0601"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
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
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="checkSub('${bean.typeId}', $F('kpiYear'), $F('kpiMonth'));">
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
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
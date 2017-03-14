<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0702" toScope="request" />
<bean:define id="title" value="统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0702";

	function confirmDisp(){
		if($F('kpiYear').trim()==""){
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
<div id="content"><html:form styleId="form" action="/IGSDL0701"
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
	<div><span>显示方式：</span>
	<span>
	<html:radio property="radioValue" styleId="radioValue" value="A">事件类别</html:radio>
	<html:radio property="radioValue" styleId="radioValue" value="B">紧急程度</html:radio>
	<html:radio property="radioValue" styleId="radioValue" value="C">事件类别+紧急程度</html:radio>
	<html:radio property="radioValue" styleId="radioValue" value="D">紧急程度+事件类别</html:radio>
	</span>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style4" align="left">
		<tr>
			<th width="50%">紧急程度</th>
			<th width="50%">平均解决时间</th>
		</tr>
		<logic:present name="IGSDL07011VO" property="incidentKpiList">
		<logic:iterate id="bean" name="IGSDL07011VO" property="incidentKpiList">
			<tr>
                   <td>${bean.urgencyName}</td>
                   <td>
                   <c:if test="${bean.resolve==null}">0</c:if>
                   <c:if test="${bean.resolve!=null}"><logic:empty name="bean" property="resolve">0</logic:empty>${bean.resolve}</c:if>
                   </td>
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
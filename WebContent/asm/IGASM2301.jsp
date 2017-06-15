<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2301" toScope="request" />
<bean:define id="title" value="控制台画面" toScope="request">
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function collect(){
	if(checkNum("collectIds") == 0){
		alert('请选择要采集的对象！');
        return false;
	}
    if(window.confirm('请确认是否执行采集操作？')){
        form.action = getAppRootUrl() + "/IGASM2301_Collect.do";
        return true;
    } else {
        return false;
    }
}
</script>
<body>
<c:set var="collectFlag" value="0"/>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGASM2301"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div><label>&nbsp;&nbsp; 实体名称： </label> <html:text
		property="impeiname_like" styleId="impeiname_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21"
		name="IGASM2301Form" /> &nbsp;&nbsp; <html:submit
		property="btn_search" styleClass="button">
		查询
	</html:submit></div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="4%"><label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','collectIds')"/> </label></th>
			<th width="35%">实体名称</th>
			<th width="21%">顶级CI类型</th>	
			<th width="20%">IP地址</th>	
			<th width="20%">状态</th>	
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM23011VO" property="importVersionInfoList">
			<logic:iterate id="bean" name="IGASM23011VO"
				property="importVersionInfoList" indexId="index">
				<c:if test="${collectFlag == '0' && bean.impstatus == '1'}"><c:set var="collectFlag" value="1"/></c:if>
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="collectIds" value="${bean.impeiname}#${bean.impversion}" />
					</td>
					<!-- 实体名称 -->
					<td>${bean.impeiname}</td>
					<!-- 顶级CI类型 -->
					<td>${bean.eiImportProgrammeTB.impTypename}</td>
					<!-- IP-->
					<td>${bean.impip}</td>
					<!-- 状态-->
					<td><ig:codeValue ccid="CI_COLLECT_STATUS" cid="${bean.impstatus}" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<logic:present name="IGASM23011VO" property="importVersionInfoList">
		<c:if test="${collectFlag == '0'}">
			<div id="operate">
				<html:submit property="btn_collect" styleClass="button"
					onclick="return collect();">
					采集
				</html:submit>
			</div>
		</c:if>
	</logic:present> 
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
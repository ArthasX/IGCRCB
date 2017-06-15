<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGCIC0201" toScope="request" />
<bean:define id="title" value="比对执行情况画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	function execute() {
		window.location ="IGCIC0201_Execute.do";
	}
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGCIC0201"
	onsubmit="return checkSubmit(this);">
	
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>执行时间：</span>
	<html:text property="cpstarttime_form" styleId="cpstarttime_form" size="16" maxlength="32"  tabindex="1"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('cpstarttime_form'))" border="0" style="cursor: hand" />
	<span>&nbsp; &macr; &nbsp;</span><html:text property="cpstarttime_to"  size="16" maxlength="32"  tabindex="2"></html:text>
	<img src="images/date.gif" align="middle" onclick="calendar($('cpstarttime_to'))" border="0" style="cursor: hand" />
	<html:submit property="btn_search" styleClass="button" value="查询" />
	<html:button property="btn_search" styleClass="button" value="执行比对任务"  onclick="execute()"/>
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<!--<th width="6%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteOrgid')"/> </label>
				</th>
				-->
				<th width="5%">序号</th>
				<th width="15%">任务开始时间</th>
				<th width="15%">任务结束时间</th>
				<th width="10%">任务执行状态</th>
				<th width="10%">执行结果</th>
				<th width="35%">错误日志信息</th>
				<th width="10%">操作</th>
			</tr>
			<logic:present name="IGCIC02011VO" property="compareprocessList">
				<logic:iterate id="bean" name="IGCIC02011VO"
					property="compareprocessList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td>
							<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
						</td>
						<td>${bean.cpstarttime}</td>
						<td>${bean.cpendtime}</td>
						<td >${bean.cpschedule}</td>
						<td >${bean.cpresulttype}</td>
						<td>${bean.errorcaption}</td>
						<td>
							<a href="IGCIC0202.do?cpid=${bean.cpid }"><img alt="详细" src="images/xx.gif" border="0"></a>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSYM01011VO"
		property="organizationcondList">
		<!--<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('deleteOrgid');" /></span>
	--></logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
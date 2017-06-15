<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.soc.alarm.vo.IGALM01021VO"%>
<html:html>
<bean:define id="id" value="IGALM0402" toScope="request" />
<bean:define id="title" toScope="request">
	告警信息详细
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
WebCalendar.timeShow   = true;          //是否返回时间
</script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGALM0102" >
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<p class="fonts1">配置管理 &gt;&gt; 告警管理 &gt;&gt; 告警信息查询&gt;&gt; 告警信息详细</p>
	</p>
	</div>
	
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<!-- 文件名 -->
	<span>文件名：</span>
	<span> <html:text
		property="filename_like" styleId="filename_like"
		errorStyleClass="inputError imeDisabled" size="30" maxlength="255"
		tabindex="2"></html:text>
	</span>
	<!--开始,结束时间-->
	 <span>开始时间：</span> <span><html:text
		property="uploadtime_begin" readonly="true" /></span> <img
		src="images/date.gif" align="middle" style="cursor: pointer;"
		onClick="calendar($('uploadtime_begin'))" border="0" />
	 <span>&nbsp;&nbsp;结束时间：</span><span><html:text
		property="uploadtime_end" readonly="true" /></span> 
		<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('uploadtime_end'));" />
	<span><html:submit property="btn_search" styleClass="button" >查询</html:submit></span>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style" >
		<tr>
			<th width="40%">文件名</th>
			<th width="40%">上传路径</th>
			<th width="20%">上传时间</th>
		</tr>
		<logic:present name="IGALM01021VO" property="igalm0102List">
			<logic:iterate id="bean" name="IGALM01021VO"
				property="igalm0102List" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td>${bean.filename}</td>
					<td>${bean.filepath}</td>
					<td>${bean.uploadtime}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
		<!-- paging --> 
		<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGKGM0229" toScope="request" />
<bean:define id="title" value="知识日志" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<body>
<div id="maincontent">
<div id="container">

<div id="location" style="margin-top: 10px">
<div class="image"></div>
<p class="fonts1">知识日志</p>
</div>
<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="15%">更新时间</th>
			<th width="30%">用户名称</th>
			<th width="55%">日志描述</th>
		</tr>
		<logic:present name="IGKGM02291VO" property="recordList">
			<logic:iterate id="log" name="IGKGM02291VO" property="recordList"
				indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><SPAN class="red">${log.kltime}</SPAN></td>
					<td>${log.klusername}</td>
					<td>${log.kldesc}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<!-- 
	<table width="100%">
		<tr>
			<td width="80%"></td>
			<td width="20%" align="left">
			<div class="record_list"><a href="javascript:openHistoryPage('/IGSVC1624.do?prid=${IGSVC1611Form.prid}');">查看状态日志</a></div>
			</td>
		</tr>
	</table>
	 -->
	<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</div>
</div>
</body>
</html:html>

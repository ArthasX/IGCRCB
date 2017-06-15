<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGEXTWA0111" toScope="request" />
<bean:define id="title" value="历史记录" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<body>
<div id="maincontent">
<div id="container">
<html:form action="/IGEXTWA0111" styleId="form"
	onsubmit="return checkSubmit(this);">
<div id="location" style="margin-top: 10px">
<div class="image"></div>
<p class="fonts1">历史记录</p>
</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">时间</th>
			<th width="8%">相关人员</th>
			<th width="10%">部门</th>
			<th width="13%">角色</th>
			<th width="24%">内容</th>
			<th width="20%">日志</th>
			<th width="15%">附件</th>
		</tr>
		<logic:present name="IGEXTWA01111VO" property="recordLogMap">
			<logic:iterate id="map" name="IGEXTWA01111VO" property="recordLogMap"
				indexId="index">
				<bean:define id="recordLog" name="map" property="key" />
				<bean:define id="attachmentList" name="map" property="value" />

				<tr class="<ig:rowcss index="${index}"/>">
					<td><SPAN class="red"><bean:write name="recordLog"
						property="rltime" /></SPAN></td>
					<td><bean:write name="recordLog" property="rlusername" /></td>
					<td><bean:write name="recordLog" property="rlorgname" /></td>
					<td><bean:write name="recordLog" property="rlrolename" /></td>
					<td align="left"><pre><bean:write name="recordLog"
						property="rlcomment" filter="false" /></pre></td>
					<td><bean:write name="recordLog" property="rldesc"
						filter="false" /></td>
					<td><logic:iterate id="attachment" name="attachmentList"
						indexId="number">
						<html:link
							action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
							<bean:define id="attname" name="attachment" property="attname" />
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
						</html:link>
						<br />

					</logic:iterate></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<table width="100%">
		<tr>
			<td width="80%"></td>
			<td width="20%" align="left">
			<div class="record_list"><a href="javascript:openHistoryPage('/IGEXTWA0113.do?prid=${IGEXTWA0111Form.prid}');">查看状态日志</a></div>
			</td>
		</tr>
	</table>
	<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</html:form></div>
</div>
</body>
</html:html>

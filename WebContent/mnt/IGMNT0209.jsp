<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.soc.mnt.vo.IGMNT02081VO"%>
<html:html>
<bean:define id="id" value="IGMNT0209" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="mntResources" key="ietitle.IGMNT0209" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function toback(){
	window.location = getAppRootUrl() + "/IGMNT0206_SEARCH1.do";
}
</script>
<body>
<c:set var="collectFlag" value="0" />
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
	<ig:navigation extname1="${urlable}"/>
	&gt;&gt;
	<bean:message bundle="mntResources" key="navigation.IGMNT0209.details"/>
	</p>
	<div class="back">
	<logic:equal value="0" name="IGMNT0206Form" property="flag">
	<a href="javascript:toback();" target="_self"><bean:message
		bundle="mntResources" key="label.IGMNT0209.back" /></a>
	</logic:equal>
	<logic:equal value="1" name="IGMNT0206Form" property="flag">
	<a href="IGCOM0202.do?linkID=IGMNT0206&actname=ACT06MNT0201" target="_self"><bean:message
		bundle="mntResources" key="label.IGMNT0209.back" /></a>
	</logic:equal>
	</div>
	</div>
	<div id="results_list">
	<fieldset>
	<legend><bean:message bundle="mntResources" key="label.IGMNT0209.detail" /></legend>
	<table cellspacing="2" class="table_style1">
	<!-- 事件告警 -->
	<logic:equal name="IGMNT0206Form" property="alarmType" value="1">
		<logic:equal name="IGMNT0206Form" property="impcitype" value="5">
			<tr>
			<th width="20%"><bean:message bundle="mntResources" key="label.IGMNT0209.Eirootmark" />：</th>
		    <td width="80%">${IGMNT02081VO.soc0305Info.eirootmark}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Impcitype" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.eiImportProgrammeTB.impTypename}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.IP" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.ip}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.DetectionTime" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.detectiontime}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Src" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.src}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.ErrorNum" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.errornum}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.LparName" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.lparnam}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.errorDesc" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.errordesc}</td>
			</tr>
		</logic:equal>
		<logic:equal name="IGMNT0206Form" property="impcitype" value="3">
			<tr>
			<th width="20%"><bean:message bundle="mntResources" key="label.IGMNT0209.Eirootmark" />：</th>
		    <td width="80%">${IGMNT02081VO.soc0305Info.eirootmark}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Impcitype" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.eiImportProgrammeTB.impTypename}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.DetectionTime" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.detectiontime}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Src" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.src}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.ErrorNum" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.errornum}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Dir" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.dir}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Category" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.category}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Severity" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.severity}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.errorDesc" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.errordesc}</td>
			</tr>
		</logic:equal>
		<logic:equal name="IGMNT0206Form" property="impcitype" value="2">
			<tr>
			<th width="20%"><bean:message bundle="mntResources" key="label.IGMNT0209.Eirootmark" />：</th>
		    <td width="80%">${IGMNT02081VO.soc0305Info.eirootmark}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.IP" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.ip}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Impcitype" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.eiImportProgrammeTB.impTypename}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.DetectionTime" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.detectiontime}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Severity" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.severity}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.errorDesc" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.errordesc}</td>
			</tr>
		</logic:equal>
		<logic:equal name="IGMNT0206Form" property="impcitype" value="9">
			<tr>
			<th width="20%"><bean:message bundle="mntResources" key="label.IGMNT0209.Eirootmark" />：</th>
		    <td width="80%">${IGMNT02081VO.soc0305Info.eirootmark}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.IP" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.ip}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Impcitype" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.eiImportProgrammeTB.impTypename}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.DetectionTime" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.detectiontime}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.Severity" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.severity}</td>
			</tr>
			<tr>
			<th><bean:message bundle="mntResources" key="label.IGMNT0209.errorDesc" />：</th>
		    <td>${IGMNT02081VO.soc0305Info.errordesc}</td>
			</tr>
		</logic:equal>
	</logic:equal>
	<!-- 性能告警 -->
	<logic:equal name="IGMNT0206Form" property="alarmType" value="2">
		<tr>
		<th width="20%"><bean:message bundle="mntResources" key="label.IGMNT0209.Eirootmark" />：</th>
	    <td width="80%">${IGMNT02081VO.soc0305Info.eirootmark}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.Impcitype" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.eiImportProgrammeTB.impTypename}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.DetectionTime" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.detectiontime}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.Severity" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.severity}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.errorDesc" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.errordesc}</td>
		</tr>
	</logic:equal>
	<!-- 容量告警 -->
	<logic:equal name="IGMNT0206Form" property="alarmType" value="3">
		<tr>
		<th width="20%"><bean:message bundle="mntResources" key="label.IGMNT0209.Eirootmark" />：</th>
	    <td width="80%">${IGMNT02081VO.soc0305Info.eirootmark}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.Dir" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.dir}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.Impcitype" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.eiImportProgrammeTB.impTypename}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.DetectionTime" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.detectiontime}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.Severity" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.severity}</td>
		</tr>
		<tr>
		<th><bean:message bundle="mntResources" key="label.IGMNT0209.errorDesc" />：</th>
	    <td>${IGMNT02081VO.soc0305Info.errordesc}</td>
		</tr>
	</logic:equal>
	</table>
	</fieldset>
	<!-- 
	<table class="table_style" >
		<logic:present name="IGASM25011VO" property="storageEventInfoList">
			<logic:equal name="IGMNT0206Form" property="impcitype" value="5">
			<tr>
			<th width="15%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.Eirootmark" /></th>
			<th width="10%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.Impcitype" /></th>
			<th width="15%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.IP" /></th>
			<th width="15%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.DetectionTime" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0209.Src" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0209.ErrorNum" /></th>
			<th id="LparName"><bean:message bundle="mntResources"
				key="label.IGMNT0209.LparName" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0209.errorDesc" /></th>			
			</tr>
			</logic:equal>
			<logic:equal name="IGMNT0206Form" property="impcitype" value="3">
			<tr>
			<th width="15%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.Eirootmark" /></th>
			<th width="10%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.Impcitype" /></th>
			<th width="15%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.DetectionTime" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0209.Src" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0209.ErrorNum" /></th>
			<th id="Dir"><bean:message bundle="mntResources" 
				key="label.IGMNT0209.Dir"/></th>
			<th id="Category"><bean:message bundle="mntResources"
				key="label.IGMNT0209.Category" /></th>
			<th id="Severity"><bean:message bundle="mntResources"
				key="label.IGMNT0209.Severity" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0209.errorDesc" /></th>			
			</tr>	
			</logic:equal>
			
			<logic:equal name="IGMNT0206Form" property="impcitype" value="2">
				<tr>
			<th width="15%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.IP" /></th>
			<th width="10%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.Impcitype" /></th>
			<th width="15%"><bean:message bundle="mntResources"
				key="label.IGMNT0209.DetectionTime" /></th>
			<th id="Severity"><bean:message bundle="mntResources"
				key="label.IGMNT0209.Severity" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0209.errorDesc" /></th>	
			</tr>
			</logic:equal>
			
			<logic:iterate id="bean" name="IGASM25011VO"
				property="storageEventInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<logic:equal name="bean" property="imptypeid" value="5">
					<td>${bean.eirootmark}</td>
					<td>${bean.eiImportProgrammeTB.impTypename}</td>
					<td>${bean.ip}</td>
					<td>${bean.detectiontime}</td>
					<td>${bean.src}</td>
					<td>${bean.errornum}</td>
					<td>${bean.lparnam}</td>
					<td>${bean.errordesc}</td>
					</logic:equal>
					
					<logic:equal name="bean" property="imptypeid" value="3">
					<td>${bean.eirootmark}</td>
					<td>${bean.eiImportProgrammeTB.impTypename}</td>
					<td>${bean.detectiontime}</td>
					<td>${bean.src}</td>
					<td>${bean.errornum}</td>
					<td>${bean.dir}</td>
					<td>${bean.category}</td>
					<td>${bean.severity}</td>
					<td>${bean.errordesc}</td>
					</logic:equal>
					
					<logic:equal name="bean" property="imptypeid" value="2">
					<td>${bean.ip}</td>
					<td>${bean.eiImportProgrammeTB.impTypename}</td>
					<td>${bean.detectiontime}</td>
					<td>${bean.severity}</td>
					<td>${bean.errordesc}</td>
					</logic:equal>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	 -->
	</div>
	<div id="operate"><!-- paging --> <jsp:include
		page="/include/paging.jsp" /></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
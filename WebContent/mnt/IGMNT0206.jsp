<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.soc.mnt.vo.IGMNT02061VO"%>
<html:html>
<bean:define id="id" value="IGMNT0206" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="mntResources" key="ietitle.IGMNT0206" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
<!--	
function checkForm(){
	var alertTime= '<bean:message bundle="mntResources" key="message.IGMNT0206.002"/>';
	if(!checkDateWithTimeShow("detectiontime_from","detectiontime_to")){
		alert(alertTime);
		return false;
	}
}

function openSubIGASM2504(eiid){
	param = $H({eiid: eiid}).toQueryString();
	openSubWindow('/IGMNT0204_Disp.do?' + param, '_blank', '800', '600');
}

//删除所选
function updStatus(obj){

	var message = '<bean:message bundle="mntResources" key="message.IGMNT0206.003"/>';
    var confirmMsg = '<bean:message bundle="mntResources" key="message.IGMNT0206.004"/>';
	if(checkNum(obj)==0){
		alert(message);
        return false;
	}
    if(window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGMNT0206_Update.do";
        return true;
    } else {
        return false;
    }
}
function setText(){
	var value=document.getElementById("sel").value;
	document.getElementById("t").value=value;
}
//-->
WebCalendar.timeShow   = true;          //是否返回时间
</script>
<body onload="">
<c:set var="collectFlag" value="0" />
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGMNT0206" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<bean:message bundle="mntResources" key="label.IGMNT0206.navi"/>
	</p>
	</div>
	
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<!--告警类型--> 
	<label for="Name"><bean:message bundle="mntResources"
		key="label.IGMNT0206.alarmType" />： </label> <html:select
		name="IGMNT0206Form" styleId="alarmType" property="alarmType"
		style="width: 130px;" errorStyleClass="inputError">
		<ig:optionsCollection ccid="ALARM_TYPE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>
	<!--对象类型--> 
	<label for="Name"><bean:message bundle="mntResources"
		key="label.IGMNT0206.Impcitype" />： </label> <html:select
		name="IGMNT0206Form" styleId="impcitype" property="impcitype"
		style="width: 130px;" errorStyleClass="inputError">
		<logic:present name="ADImpTypeList">
			<html:options collection="ADImpTypeList" property="value" name="" labelProperty="label" />
		</logic:present>
	</html:select>
	
	<!--CI名称-->
	 <span><bean:message bundle="mntResources"  
		key="label.IGMNT0206.StorageEventCategory" name="eirootmarkMessage" />：</span>
		<!-- 
		<html:text property="eirootmark_eq" styleId="eirootmark_eq"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="32"
		tabindex="1"></html:text>
		-->
		<html:text property="eirootmark_eq" styleId="t"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="32" style="width: 100px;"
		tabindex="1"></html:text>
		<html:select name="IGMNT0206Form" property="eirootmark_eq" styleId="sel" onclick="setText()"
			style="width: 120px;position:absolute;margin-top:3px;margin-left:-110px;clip:rect(auto auto auto 100px);">
			<logic:present name="ciList">
				<html:options collection="ciList" property="value" name="" labelProperty="label" />
			</logic:present>
		</html:select>
	<!--告警等级-->
	<span style="margin-left: 20px"><bean:message bundle="mntResources"  
		key="label.IGMNT0206.Severity" />：</span>
		<html:select name="IGMNT0206Form" property="severity_eq"
			style="width: 130px;" errorStyleClass="inputError">
			<logic:present name="alarmSeverityList">
				<html:options collection="alarmSeverityList" property="value" name="" labelProperty="label" />
			</logic:present>
		</html:select>
	&nbsp;&nbsp;<BR />
	
	<!--处理状态--> 
	<label for="Name"><bean:message bundle="mntResources"
		key="label.IGMNT0206.status" />： </label> <html:select
		name="IGMNT0206Form" styleId="status" property="status"
		style="width: 130px;" errorStyleClass="inputError">
		<html:option value=""></html:option>
		<html:option value="0"><bean:message bundle="mntResources" key="label.IGMNT0206.status1" /></html:option>
		<html:option value="1"><bean:message bundle="mntResources" key="label.IGMNT0206.status2" /></html:option>
	</html:select>
	<!--事件描述-->
	<span><bean:message bundle="mntResources" key="label.IGMNT0206.errorDesc"/>：</span><span> <html:text
		property="errorDesc" styleId="errorDesc"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="32"
		tabindex="2"></html:text> </span>
	<!--发生时间-->	
	 <span><bean:message bundle="mntResources"
		key="label.IGMNT0206.StorageEventTime" /></span> <span><html:text
		property="detectiontime_from" readonly="true" /></span> <img
		src="images/date.gif" align="middle" style="cursor: pointer;"
		onClick="calendar($('detectiontime_from'))" border="0" /> <span>&nbsp;&nbsp;<bean:message
		bundle="mntResources" key="label.IGMNT0206.StorageEventTimeTo" /></span><span><html:text
		property="detectiontime_to" readonly="true" /></span> 
		<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('detectiontime_to'));" /> <span>
	<html:submit property="btn_search" styleClass="button"
		onclick="return checkForm();">
		<bean:message bundle="mntResources" key="button.IGMNT0206.btn_search" />
	</html:submit> </span>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style" >
		<tr>
			<th width="5%"><label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','ids')"/></label></th>
			<th width="12%"><bean:message bundle="mntResources"
				key="label.IGMNT0206.Eirootmark" /></th>
			<th width="12%"><bean:message bundle="mntResources"
				key="label.IGMNT0206.IP" /></th>
			<th width="10%"><bean:message bundle="mntResources"
				key="label.IGMNT0206.alarmType" /></th>	
			<th width="10%"><bean:message bundle="mntResources"
				key="label.IGMNT0206.Impcitype" /></th>	
			<th width="15%"><bean:message bundle="mntResources"
				key="label.IGMNT0206.DetectionTime" /></th>
			<th width="20%"><bean:message bundle="mntResources"
				key="label.IGMNT0206.errorDesc" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0206.Severity"/></th>	
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0206.Detail"/></th>
		</tr>
		<logic:present name="IGMNT02061VO" property="soc0307List">
			<logic:iterate id="bean" name="IGMNT02061VO"
				property="soc0307List" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="ids" value="${bean.id}" name="IGMNT0206Form" styleId="ids"/></td>
					<td>
					<c:if test="${bean.eiid!=null}">
					
					<a href="javascript:openSubIGASM2504('${bean.eiid}');">${bean.eirootmark}</a>
					</c:if>
					<c:if test="${bean.eiid==null}">
					${bean.eirootmark}
					</c:if>
					</td>
					<td>${bean.ip}</td>
					<td>
					<ig:codeValue ccid="ALARM_TYPE_CODE" cid="${bean.alarmType}"/>
					</td>
					<td>${bean.imptypename}</td>
					<bean:define id="detectiontime" name="bean" property="detectiontime" type="java.lang.String"></bean:define>
					<td><%=detectiontime.substring(0,16) %></td>
					<td>${bean.errordesc}</td>
					<td>${bean.severity}</td>
					<td>
					<div align="center">
               		<html:link action="/IGMNT0209_Disp.do?id=${bean.id}&impcitype=${bean.imptypeid}&alarmType=${bean.alarmType}&flag=0"><img src="images/look.gif" alt='<bean:message bundle="mntResources" key="img.IGMNT0206.detail.alt"/>' width="16" height="16"  border="0"/></html:link>
                	</div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
		<logic:present name="IGMNT02061VO" property="soc0307List">
		<logic:equal value="0" name="IGMNT0206Form" property="status">
		<span> 
			<html:submit property="btn_delete"  styleClass="button" onclick="return updStatus('ids');" >
				<bean:message bundle="mntResources" key="button.IGMNT0206.handle"/>
			</html:submit>
		</span>
		</logic:equal>
		</logic:present>
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
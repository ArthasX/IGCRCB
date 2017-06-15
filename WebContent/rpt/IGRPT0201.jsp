<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRPT0201" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="rptResources" key="ietitle.IGRPT0101" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
//是否确认删除
function checkdel(obj){
	var confirmMsg1='<bean:message bundle="rptResources" key="message.IGRPT0101.confirmMsg"/>';
	var message='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmMsg"/>';
	if(checkNum(obj)==0){
		alert(message);
        return false;
	}
	if(window.confirm(confirmMsg1)){
		form.action = getAppRootUrl() + "/IGRPT0201_Delete.do";
		return true;
	}else{
		return false;
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGRPT0201" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation extname1="${urlable}"/>
	</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div>
	<label>&nbsp;&nbsp; <bean:message bundle="rptResources" key="label.IGRPT0101.rtName" /> </label>
	<html:text property="rtname_like" styleId="rtname_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21" />
	&nbsp;&nbsp; <label> 
	<bean:message bundle="rptResources" key="label.IGRPT0101.rtDateType" /> </label>
	<html:select  name="IGRPT0202Form"  styleId="rtdatetype_eq" property="rtdatetype_eq" style="width: 120px;">
		<ig:optionsCollection ccid="REPORT_DATETYPE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>
	<html:submit property="btn_search" styleClass="button" onclick="">
		<bean:message bundle="rptResources" key="button.IGRPT0101.btn_search" />
	</html:submit>
	<html:button property="btn_add" styleClass="button" onclick="location.href='IGRPT0203_Disp.do'">
		<bean:message bundle="rptResources" key="button.IGRPT0101.btn_add" />
	</html:button>
	</div>
	</div>
	</div>
	</div>

	<div id="results_list">
	<ig:message />
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="4%"><input id="isSel" type="checkbox" onclick="selectAll('isSel','delid')" /> </th>
			<th width="4%"><label><bean:message bundle="rptResources" key="label.IGRPT0101.rtIdTable"/></label></th>
			<th width="10%"><label><bean:message bundle="rptResources" key="label.IGRPT0101.rtNameTable"/></label></th>
			<th width="10%"><bean:message bundle="rptResources" key="label.IGRPT0101.rtDateTypeTable"/></th>
			<th width="10%"><bean:message bundle="rptResources" key="label.IGRPT0101.rtRealNameTable"/></th>
			<th width="8%"><bean:message bundle="rptResources" key="label.IGRPT0101.rtUploadTimeTable"/></th>
			<!--  <th width="8%">模板类型</th>  -->
			<th width="8%"><bean:message bundle="rptResources" key="label.IGRPT0104.operate"/></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGRPT02011VO" property="reportTemplateList" >
		 <logic:iterate id="bean" name="IGRPT02011VO" property="reportTemplateList" indexId="index">
			<tr class="<ig:rowcss index="${index}"/>">
			<td><html:checkbox property="delid" value="${bean.rtId}" /></td>
			<td width="4%"><label>${bean.rtId}</label></td>
			<td width="10%"><label>${bean.rtName}</label></td>
			<td width="10%"><label>
			<c:if test="${bean.rtDateType==0}"><bean:message bundle="rptResources" key="select.IGRPT0301.month"/></c:if>
			<c:if test="${bean.rtDateType==1}"><bean:message bundle="rptResources" key="select.IGRPT0301.quarter"/></c:if>
			<c:if test="${bean.rtDateType==2}"><bean:message bundle="rptResources" key="select.IGRPT0301.year"/></c:if></label></td>
			<td width="10%"><label>${bean.rtRealName}</label></td>
			<td width="8%"><label>${bean.rtUploadTime}</label></td>
			<!--  <td width="8%"><label>${bean.rtType}</label></td> -->
			<td width="8%">
			<a href="IGRPT0203_UDisp.do?rtId=${bean.rtId}">
			 <img src="images/edit.gif" width="16" height="16" border="0" alt='<bean:message bundle="rptResources" key="alt.IGRPT0103.edit"/>'/> </a></td>
			</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<html:submit property="btn_delete" styleClass="button" onclick="return checkdel('delid');">
	<bean:message bundle="rptResources" key="button.IGRPT0101.btn_delete" />
	</html:submit>
<jsp:include page="/include/paging.jsp" />
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
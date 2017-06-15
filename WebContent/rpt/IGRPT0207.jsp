<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ0101VO"%>
<%@ page import="com.deliverik.infogovernor.prj.model.Project"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>

<script type="text/javascript">	
//是否确认删除
function checkdel(obj,flag){
	//1为生成，2为删除
	var message='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmMsg"/>';
	var confirmDel='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmDel"/>';
	var confirmCre='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmCre"/>';
	var confirmCre2='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmCre2"/>';
	if(checkNum(obj)==0){
		alert(message);
        return false;
	}
	if(flag==2){
		if(window.confirm(confirmDel)){
			form.action = getAppRootUrl() + "/IGRPT0207_Delete.do";
			return true;
		}else{
			return false;
		}
	}else {
		if(window.confirm(confirmCre)){
			//0为删除附加 1为不删除
			if(window.confirm(confirmCre2)){
				form.action = getAppRootUrl() + "/IGRPT0207_Create.do?isDel=0";
			}else{
				form.action = getAppRootUrl() + "/IGRPT0207_Create.do?isDel=1";
			}
			return true;
		}else{
			return false;
		}
	}
	
}
</script>

<html:html>
<bean:define id="id" value="IGRPT0207" toScope="request" />
<bean:define id="title"  toScope="request" >
<bean:message bundle='rptResources' key='ietitle.IGRPT0107' />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
	 <!--content  右侧内容-->

<div id="contentWrap">
<div id="location">
<div class="image"></div>
<p class="fonts1"><bean:message
		bundle='rptResources' key='navigation.IGRPT0107.statisticsAnalyse' /> &gt;&gt; <bean:message
		bundle='rptResources' key='navigation.IGRPT0107.autoReport' />&gt;&gt;
<bean:message bundle="rptResources" key="ietitle.IGRPT0104" />&gt;&gt;<bean:message
		bundle='rptResources' key='navigation.IGRPT0107.additionReport' />
</p>
<div class="back">  
	<a href="IGRPT0204.do" target="_self"><bean:message
		bundle="rptResources" key="button.IGRPT0103.btn_toback" /></a>
	</div>
</div>
<html:form styleId="form" action="/IGRPT0207_Disp" onsubmit="return checkSubmit(this);">
<div style="margin-left: 30px;width:25%"><ig:message /></div>
<div id="results_list" style="overflow-y: auto;height:400px;">
<table class="table_style" style="width:95%;">
	<!-- header部 -->
	<tr>
		<th width="4%"><input id="isSel" type="checkbox" onclick="selectAll('isSel','anIds')" /></th>
		<th width="10%"><bean:message bundle='rptResources' key='label.IGRPT0107.additionReportName' /></th>
		<th width="10%"><bean:message bundle='rptResources' key='label.IGRPT0107.ssne' /></th>
		<th width="8%"><bean:message bundle='rptResources' key='label.IGRPT0107.kpi' /></th>
		<th width="10%"><bean:message bundle='rptResources' key='label.IGRPT0107.userName' /></th>
		<th width="10%"><bean:message bundle='rptResources' key='label.IGRPT0107.createDate' /></th>
	</tr>
	<!-- body部 -->
	<logic:present name="IGRPT02071VO" property="reportAnnexationList">
		<logic:iterate id="bean" name="IGRPT02071VO"
			property="reportAnnexationList" indexId="index">
			<tr class="<ig:rowcss index="${index}"/>">
				<td><html:checkbox property="anIds" value="${bean.raId}" /></td>
				<td><label>${bean.raName}</label></td>
				<td><label>${bean.raSsn}</label></td>
				<td><label>${bean.raKpi}</label></td>
				<td><label>${bean.raUserName}</label></td>
				<td><label>${bean.raCreateDate}</label></td>
			</tr>
		</logic:iterate>
	</logic:present>
</table>
<html:submit property="btn_delete"  style="height:20px;"
	styleClass="button" onclick="return checkdel('anIds',1);">
	<bean:message bundle="rptResources" key="button.IGRPT0107.generate" />
</html:submit> <html:submit property="btn_delete" style="height:20px;" styleClass="button" 
	onclick="return checkdel('anIds',2);">
	<bean:message bundle="rptResources" key="button.IGRPT0101.btn_delete" />
</html:submit>
</div>

<html:hidden property="rmId"/>
</html:form>
</div>
</div>   
</div>
</body>
</html:html>
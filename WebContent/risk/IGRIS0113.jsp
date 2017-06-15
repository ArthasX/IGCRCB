<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGRIS0113" toScope="request" />
<bean:define id="title" value="审计评估画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGRIS0113';
function changeRaversion(){
	var obj = $("raiid");
	$("raicode").value = obj.options[obj.selectedIndex].text;
}
function selectRiskCheck(radid){
	openSubWindow('/IGRIS0115.do?radid='+radid, '_blank','1000','600');
}
function checkSubmit(){
	if($F('raiid').trim() == ""){
		alert("请选择审计编号！");
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
<html:form styleId="form" action="/IGRIS0113"
	onsubmit="return checkSubmit(this);">
	
<div id="location">
<div class="image"></div>
<p class="fonts1">服务管理 &gt;&gt; 风险审计 &gt;&gt; 审计评估</p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span><span class="red">*</span>审计编号：</span><logic:present name="labelList"><html:select property="raiid" errorStyleClass="inputError imeActive" name="IGRIS0113Form" styleId="raiid">
		<html:options collection="labelList" property="value" name="" labelProperty="label"/>
	</html:select> <html:hidden property="raicode" styleId="raversion" name="IGRIS0113Form"/>
	</logic:present>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	
	<table class="table_style">
		<tr>
			<th width="6%">序号</th>
            <th width="24%">审计项名称</th>
            <th width="16%">审计人</th>
            <th width="15%">审计发起日期</th>
            <th width="15%">审计结束日期</th>
            <th width="10%">查看检查项</th>
            <th width="10%">评估</th>
		</tr>
		<logic:present name="IGRIS01131VO" property="riskAuditResultList">
			<logic:iterate id="bean" name="IGRIS01131VO"
				property="riskAuditResultList" indexId="index">	
				<bean:define id="status" name="bean" property="riskAuditDefTB"></bean:define>	
				<logic:equal value="1" name="status" property="radstatus">	
				<tr class="<ig:rowcss index="${index}"/>">
					
					<td>${index+1}</td>
					<td>${bean.riskAuditDefTB.radname}</td>
					<td>${bean.rarusername}</td>
					<td>${bean.riskAuditInsTB.raistart}</td>
					<td>${bean.riskAuditInsTB.raiend}</td>
					<td>
					<img src="images/look.gif" alt="查看检查项" width="16" height="16" border="0" onclick="selectRiskCheck('${bean.riskAuditDefTB.radid}')" style="cursor: hand"/>
					</td>
					<td><div>
					<html:link action="/IGRIS0114_Disp.do?rarid=${bean.rarid}"> 
					<img src="images/evaluate.png" alt="评估" width="16" height="16" border="0" />
					</html:link></div>
					</td>
				</tr>
				</logic:equal>	
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>
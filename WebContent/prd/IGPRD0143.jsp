<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<%@ page import="com.deliverik.infogovernor.util.CodeDefine" %>

<%@page import="com.deliverik.framework.utility.ResourceUtility"%><html:html>
<bean:define id="id" value="IGPRD0143" toScope="request" />
<bean:define id="title" value="可被分派机构授权页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="机构" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择要添加的机构。';
			confirmMsg = '请确认是否要进行机构添加处理?';
			mode="1";
		}
        if(window.confirm(confirmMsg)){
			
			count=checkAndCreate(flag);
			if(count==0){
				alert(message);
	            return false;
			}
			IGPRD0143Form.action = getAppRootUrl() + "/IGPRD0143.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			count = checkNum("orgsyscodings");
		}else{
			count = checkNum("psodids");
		}
		return count;
	}	

//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0143" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 状态列表 &gt;&gt; 可被分派角色授权</p>
<div class="back">
	<a href="IGPRD0104_Back.do?pdid=${IGPRD0143Form.pdid}&ppsdid=${IGPRD0143Form.ppsdid}" target="_self">返回</a>
</div> 
</div>
	<div class="role_title">现有机构</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="10%">
					<label> 
						<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','psodids')"/>
					</label>
				</th>
				<th width="40%">机构</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01431VO" property="lst_ProcessStatusOrgDef">
				<logic:iterate id="bean" name="IGPRD01431VO" property="lst_ProcessStatusOrgDef" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<input type="checkbox" name="psodids" value="${bean.psodid}">
						 	</label>
						</td>
						<td>
							${bean.orgname}
						</td>
						<td>
							
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01431VO" property="lst_ProcessStatusOrgDef">
		<bean:size id="lst_ProcessStatusOrgDef_count" name="IGPRD01431VO" property="lst_ProcessStatusOrgDef"/>
		<logic:greaterThan name="lst_ProcessStatusOrgDef_count" value="0">
			<span>
			<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
			<html:submit property="btn_delete" value="删除所选"
				styleClass="button" onclick="return deleteRec('0');" />
			<%} %>	
			</span>
		</logic:greaterThan>
	</logic:present>
	</div>
	<div class="role_title">可选机构</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="10%">
					<label>
						<input type="checkbox" name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','orgsyscodings')"/> 
					</label>
				</th>
				<th width="40%">机构</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01431VO" property="lst_Org">
				<logic:iterate id="bean" name="IGPRD01431VO" property="lst_Org" indexId="index">
				<bean:define id="org_length" name="bean" property="orgsyscoding" />
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
							<%int level = Integer.valueOf(ResourceUtility.getString("ORGNATATION_LEVEL"));
							int length_level = 4 + (level-1)*3;
							if(org_length.toString().length() == length_level){	%>
								<input type="checkbox" name="orgsyscodings" value="${bean.orgsyscoding}">
							<%} %>
							</label>
						</td>
						<td align="left">
						<%int count = (org_length.toString().length() - 4) / 3;
						for(int i = 0;i < count;i++){
							%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%
						}
						if(org_length.toString().length() == length_level){	%>
							${bean.orgname}
						<%}else{%>
							<strong>${bean.orgname}</strong>
						<%}%>
							
						</td>
						<td>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01431VO" property="lst_Org">
		<bean:size id="lst_Org_count" name="IGPRD01431VO" property="lst_Org"/>
		<logic:greaterThan name="lst_Org_count" value="0">
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
			<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return deleteRec('1');"/>
		<%} %>
		</logic:greaterThan>
	</logic:present>
	</div>
	<html:hidden property="psdid" styleId="psdid" />
	<html:hidden property="pdid" styleId="pdid" />
	<html:hidden property="ppsdid" styleId="ppsdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>
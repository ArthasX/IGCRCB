<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<logic:notEqual name="disp" value="none">
	<logic:present name="IGPRR01021VO">
	<logic:empty name="IGPRR01021VO" property="status"/>
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<logic:present name="ADlst_status">
	<div class="title">
	<div class="name">当前状态</div>
	</div>
	<div class="record_list" style="margin-left: 10px">
		<html:select property="prstatus" errorStyleClass="inputError imeActive"
			tabindex="1" styleId = "prstatus" onchange="selectStatus(this);">
		<html:options collection="ADlst_status" property="value" name="" labelProperty="label"/>
		</html:select>
	</div>
	</logic:present>
	<logic:notPresent name="ADlst_status">
		<html:hidden property="prstatus" value="${IGPRR01021VO.status}"/>
	</logic:notPresent>
	<div class="title">
	<div class="name">处理人角色</div>
	</div>
	<div style="height:30px;">
		<logic:present name="IGPRR01021VO" property="disp">
				<logic:equal value="0" name="IGPRR01021VO" property="disp">
				<div class="record_list" style="margin-left: 10px">
					<html:select property="ppidstr" errorStyleClass="inputError imeActive"
						tabindex="2" styleId = "ppidstr" onchange="selectRole();">
					<html:options collection="ADroleList" property="value" name="" labelProperty="label"/>
					</html:select>
				</div>
				</logic:equal>
				<logic:notEqual value="0" name="IGPRR01021VO" property="disp">
				<div class="record_list" style="margin-left: 10px">
					${IGPRR0102Form.rolename}
					<html:hidden property="ppidstr" />
				</div>
				</logic:notEqual>
		</logic:present>	
	</div>
	</logic:notEqual>
	</logic:present>
</logic:notEqual>
	<logic:present name="IGPRR01021VO">
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<logic:notEqual value="#" name="IGPRR01021VO" property="status">
	<div class="title">
	<div class="name">参与人员</div>
	</div>
	<div class="record_list" style="margin-left: 10px">
	<table cellspacing="2">
		<tr>
			<td><bean:write name="personinfo" filter="false"/></td>
		</tr>
	</table>
	</div>
	</logic:notEqual>
	</logic:notEqual>
	</logic:present>
	<logic:present name="IGPRR01021VO">
	<script type="text/javascript">
	pdid = "${IGPRR01021VO.process.prpdid}";
	
	function ShowpProcessFlow(prid, pdid) {
		window
				.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?prid='
						+ prid, null,
						"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
	}
	
	</script>
	
	<div class="title">
	<div class="name">工单信息</div>
	<!--  
	<div style="margin-top:5px;margin-left:40px;float: right">
		<a href="javascript:ShowpProcessFlow();">查看流程图</a>
	</div>-->
	</div>
		
	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%">工单号：</th>
			<td width="35%">${IGPRR01021VO.process.prserialnum}</td>
			<th width="15%"><ig:ProcessOverdueLevelImgTag prstatus="${IGPRR01021VO.status}" prid="${IGPRR01021VO.process.prid}" />&nbsp;状态：</th>
			<td width="35%">
			<span title="<ig:ProcessStatusTitleShowTag prid="${IGPRR01021VO.process.prid}"/>">
				<ig:processDefineTypeValue prid="${IGPRR01021VO.process.prid}"/>
			</span>
			</td>
		</tr>
		<logic:present name="IGPRR01021VO" property="processTitleDefTB">
		<bean:define id="processTitleTB" name="IGPRR01021VO" property="processTitleDefTB" type="com.deliverik.framework.workflow.prd.model.IG243Info" />
		<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>" name="processTitleTB" property="ptitleaccess">
			<tr>
				<th>
					<logic:empty name="processTitleTB" property="ptitlename">
						主题简述：
					</logic:empty>
					<logic:notEmpty name="processTitleTB" property="ptitlename">
						<bean:write name="processTitleTB" property="ptitlename" />：
					</logic:notEmpty>
				</th>
				<td colspan="3">${IGPRR01021VO.process.prtitle}</td>
			</tr>
		</logic:equal>		
		<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>" name="processTitleTB" property="pdescaccess">
			<tr>
				<th>
					<logic:empty name="processTitleTB" property="pdescname">
						内容描述：
					</logic:empty>
					<logic:notEmpty name="processTitleTB" property="pdescname">
						<bean:write name="processTitleTB" property="pdescname" />：
					</logic:notEmpty>
				</th>
				<td colspan="3">
<%-- 				<pre>${IGPRR01021VO.process.prdesc}</pre> --%>
				<div class="editDiv" style="border:none;">${IGPRR01021VO.process.prdesc}</div>
			</td>
		</tr>
		</logic:equal>
	</logic:present>
		<tr>
			<th width="15%">发起者：</th>
			<td width="35%">${IGPRR01021VO.process.prusername}</td>
			<th width="15%">发起者角色：</th>
			<td width="35%">${IGPRR01021VO.process.prrolename}</td>
		</tr>
		<tr>
			<th>发起者部门：</th>
			<td>${IGPRR01021VO.process.prorgname}</td>
			<th>联系方式：</th>
			<td>${IGPRR01021VO.process.prinfo}</td>
		</tr>
		<tr>
			<th width="15%">发起时间：</th>
			<td>${IGPRR01021VO.process.propentime}</td>	
			<th width="15%">关闭时间：</th>
			<td>${IGPRR01021VO.process.prclosetime}</td>
		</tr>
		<!-- 
		<tr>
			<th width="15%">处理历时(小时)：</th>
			<td>${IGPRR01021VO.dealtime}</td>
		</tr>
		 -->
	</table></div>
	</logic:present>
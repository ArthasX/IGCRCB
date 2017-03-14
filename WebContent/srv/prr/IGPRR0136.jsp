<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%-- <logic:notEqual name="disp" value="none"> --%>
	<logic:present name="IGPRR01021VO">
	<logic:empty name="IGPRR01021VO" property="status"/>
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<div class="title">
	<div class="name">人员信息</div>
	</div>
		<logic:present name="IGPRR01021VO" property="disp">
		<div class="record_list">
		<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%">发起者：</th>
			<td width="35%">${IGPRR01021VO.process.prusername}</td>
			<th>联系方式：</th>
			<td>${IGPRR01021VO.process.prinfo}</td>
		</tr>
		<tr>
			<th width="15%">发起者角色：</th>
			<td width="35%">${IGPRR01021VO.process.prrolename}</td>
			<th>发起者部门：</th>
			<td>${IGPRR01021VO.process.prorgname}</td>
		</tr>
		<tr>
			<th width="15%">当前处理人：</th>
			<td colspan="3"><bean:write name="personinfo" filter="false"/></td>
			<%-- <td>${IGPRR01021VO.process.propentime}</td> --%>
		</tr>
		</table></div>
		</logic:present>	
	</logic:notEqual>
	</logic:present>
<%-- </logic:notEqual> --%>
	<logic:present name="IGPRR01021VO">
	<script type="text/javascript">
	pdid = "${IGPRR01021VO.process.prpdid}";
	</script>
	<div class="title">
	<div class="name">工单信息</div>
	</div>
	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%">工单号：</th>
			<td width="35%">${IGPRR01021VO.process.prserialnum}</td>
			<th width="15%">状态：</th>
			<td width="35%">
				<ig:processDefineTypeValue prid="${IGPRR01021VO.process.prid}"/>
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
				<td>${IGPRR01021VO.process.prtitle}</td>
				<th>
					流程类型：
				</th>
				<td>
					${IGPRR01021VO.process.prpdname}
				</td>
			</tr>
		</logic:equal>
		<tr>
			<th width="15%">发起时间：</th>
			<td>${IGPRR01021VO.process.propentime}</td>	
			<th>处理历时(分钟)：</th>
			<td>${IGPRR01021VO.process.prfacttime}</td>	
		</tr>	
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
				<td colspan="3"><pre>${IGPRR01021VO.process.prdesc}</pre>
					<%-- <logic:present name="IGPRR01021VO">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
			<bean:define id="logList" name="map" property="value" type="java.util.List" />
			<logic:iterate id="recordLog" name="logList" indexId="index" >
			<c:if test="${recordLog.psdcode == 'Z'}">
			<logic:present name="recordLog" property="attachmentList">
					<logic:notEmpty	name="recordLog" property="attachmentList">
						<bean:define id="attachmentList" name="recordLog" property="attachmentList" type="java.util.List" />
						<logic:iterate id="attachment" name="attachmentList" indexId="number">
							<html:link
								action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
								<bean:define id="attname" name="attachment" property="attname" />
								<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
							</html:link>
							<br />
						</logic:iterate>
					</logic:notEmpty>
			</logic:present>
			</c:if>
			</logic:iterate>
			</logic:iterate>
			</logic:present> --%>
			</td>
		</tr>
		</logic:equal>
	</logic:present>
	
	</table></div>
	</logic:present>
	<logic:present name="IGPRR01021VO">
	<div class="title">
	<div class="name">扩展信息</div>
	<div style="float:right">
	<table>
		<tr>
<!-- 			<td> -->
<%-- 				<a href="javascript:openHistoryPage('/IGPRR0110.do?prid=${IGPRR01021VO.process.prid}');"></a> --%>
<!-- 			</td> -->
<!-- 			<td> -->
<!-- 			</td> -->
			<td>
				<a href="javascript:ShowpProcessFlow('${IGPRR01021VO.process.prid}');">查看流程图</a>
			</td>
			<logic:equal name="IGPRR01021VO" property="isAdmin" value="true">
			<td>
				<a href="javascript:openHistoryPage('/IGPRR0110.do?prid=${IGPRR01021VO.process.prid}');">状态日志</a>
			</td>
			</logic:equal>
			<logic:equal name="knowledge" value="knowledge">
			<c:if test="${IGPRR01021VO.status=='C'}">
			<td>
				<a href="javascript:onclick()">知识库</a>
			</td>
			</c:if>
			</logic:equal>
		</tr>
	</table>
	</div>
	</div>
	</logic:present>
	<div class="record_list">	
	<logic:present name="IGPRR01021VO">
	<logic:equal  name="IGPRR01021VO" property="hid" value="0">
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
			<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
				<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
				<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
				<logic:present name="psid">
				<div>
					<logic:notEqual name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
						<logic:notEqual name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>">
							<input type="hidden" name="pivarvalue[${index}]" value="${psid.pidvalue}" /> 
						</logic:notEqual>
					</logic:notEqual>
					<html:hidden property="pivarname" value="${psid.pidname}" /> 
					<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
					<html:hidden property="pivartype" value="${psid.pidtype}" /> 
					<html:hidden property="pidid" value="${psid.pidid}" />
					<html:hidden property="pidaccess" value="${psid.pidaccess}" />
					<html:hidden property="piid" value="${psid.piid}" />
					<html:hidden property="pidmode" value="${psid.pidmode}" />
					<html:hidden property="privatescope" value="${psid.privatescope}" />
				</div>
				</logic:present>
			</logic:iterate>
	</logic:present>
	</logic:equal>
	</logic:present>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<bean:parameter name="vo" id="vo" value=""/>
<logic:present name="${vo}" property="process">
	<bean:define id="process" name="${vo}" property="process" />
	<div class="title" style="cursor: hand;">
	<div class="name"  onclick="toggleElement('baseMessage','baseMessageImg')">基本信息<img id="baseMessageImg" src="images/sub_1.jpg"></div>
	</div>
	<div class="record_list" id="baseMessage">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%">工单号：</th>
			<td width="35%"><bean:write name="process"
				property="prserialnum" /></td>
			<th width="15%">状态：</th>
			<td width="35%">
			<logic:notEqual value="" property="prsubstatus" name="process">
				<ig:codeValue ccid="${process.prtype}" cid="${process.prstatus}" />(<ig:codeValue ccid="${process.prtype}SUB" cid="${process.prsubstatus}"/>)
			</logic:notEqual>
			<logic:equal value="" property="prsubstatus" name="process">
				<ig:codeValue ccid="${process.prtype}" cid="${process.prstatus}" />
			</logic:equal>
			</td>
		</tr>
		<tr>
			<th>工作名称：</th>
			<td><bean:write name="process" property="prtitle" /></td>
			<th>工作类型：</th>
			<td><bean:write name="process" property="prpdname" /></td>
		</tr>
		<tr>
			<th>紧急程度：</th>
			<td><ig:codeValue ccid="WBURGENCY_GRADE_CODE"
				cid="${process.prurgency}" /></td>
			<th>影响程度：</th>
			<td><ig:codeValue ccid="IMPACT_GRADE_CODE"
				cid="${process.primpact}" /></td>
		</tr>
		<tr>
			<th>相关资产：</th>
			<td colspan="5">
				<logic:present name="${vo}" property="pieList">
				<logic:iterate id="entity" name="${vo}" property="pieList"
					indexId="index" type="com.deliverik.framework.workflow.prd.model.IG731Info">
				<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=entity.getEiid() %>',<%=entity.getEiversion() %>)">
				<%=entity.getEntityItemVWTB().getEiname() %> </a>&nbsp;&nbsp;
				</logic:iterate>
				</logic:present>
			</td>
		</tr>
		<tr>
			<th>工作描述：</th>
			<td colspan="5"><pre><bean:write name="process" property="prdesc" /></pre></td>
		</tr>
	</table>
	<table width="100%">
		<tr>
			<td width="80%"></td>
			<td width="20%" align="left"><a href="javascript:openHistoryPage('/IGEXTWB0108.do?prid=${process.prid}');">查看状态日志</a></td>
		</tr>
	</table>
	</div>
	<logic:present name="${vo}" property="processInfo">
		<logic:notEmpty name="${vo}" property="processInfo">
		<div class="title" style="cursor: hand;">
		<div class="name" onclick="toggleElement('expendMessage','expendMessageImg')">扩展信息<img id="expendMessageImg" src="images/sub_1.jpg"></div>
		</div>
		<div class="record_list" id="expendMessage">
		<table cellspacing="2" class="table_style1">
		<bean:define id="count" name="${vo}" property="processInfo" type="java.util.List"/>
			<logic:iterate id="info" name="${vo}"
				property="processInfo" indexId="index" type="com.deliverik.framework.workflow.prr.model.IG599Info">
				<%if(index.intValue()%2==0) {%>
				<tr>
					<%}%>
					<th width="15%">${info.pivarlabel}：</th>
					<%if(index.intValue() == count.size()-1 && count.size() % 2 != 0){%>
					<td colspan="3">
					<logic:notEmpty name="info" property="pivarvalue">
					<% if(info.getPivarvalue().contains("_prj_")){ %>
							<%=info.getPivarvalue().split("_prj_")[1] %>
						<% } else if(info.getPivarvalue().contains("N/A") 
								&& (!WorkFlowConstDefine.PROCESS_PIVRLABEL.equals(info.getPivarlabel()))
								&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype())){ %>

							<logic:present name="${vo}" property="processInfoEntityList">
								<logic:iterate id="entity" name="${vo}" property="processInfoEntityList"
									indexId="index1" type="com.deliverik.framework.workflow.prd.model.IG731Info">
									<% if(info.getPiid().equals(entity.getPiid())){ %>
										<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=entity.getEiid() %>','')">
										<%=entity.getEntityItemTB().getEiname() %> </a>&nbsp;&nbsp;
									<% } %>
							</logic:iterate>
							</logic:present>
						<% } else if(info.getPivarvalue().contains("_svc_")){ %>
							<a href="javascript:openRelatedProcess('<%=info.getPivarvalue().split("_svc_")[0] %>','<%=info.getPivarvalue().split("_svc_")[1].split("_name=")[0] %>')">
							<%=info.getPivarvalue().split("_svc_")[1].split("_name=")[1] %></a>
						<% } else {
							if((!info.getPivarvalue().contains("N/A"))
									&& (!WorkFlowConstDefine.PROCESS_PIVRLABEL.equals(info.getPivarlabel()))
									&& (!WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype()))){ %>
										${info.pivarvalue}
								<%	}
								} %>
					</logic:notEmpty>
					</td>
					</tr>
				<%}else{ %>
					<td width="35%">
						<% if(info.getPivarvalue().contains("_prj_")){ %>
							<%=info.getPivarvalue().split("_prj_")[1] %>
						<% } else if(info.getPivarvalue().contains("N/A") 
								&& (!WorkFlowConstDefine.PROCESS_PIVRLABEL.equals(info.getPivarlabel()))
								&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype())){%>

							<logic:present name="${vo}" property="processInfoEntityList">
								<logic:iterate id="entity" name="${vo}" property="processInfoEntityList"
									indexId="index2" type="com.deliverik.framework.workflow.prd.model.IG731Info">
										<% if(info.getPiid().equals(entity.getPiid())){%>
											<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=entity.getEiid() %>','')">
											<%=entity.getEntityItemTB().getEiname() %> </a>&nbsp;&nbsp;
										<% } %>
							</logic:iterate>
							</logic:present>
						<% } else if(info.getPivarvalue().contains("_svc_")){ %>
							<a href="javascript:openRelatedProcess('<%=info.getPivarvalue().split("_svc_")[0] %>','<%=info.getPivarvalue().split("_svc_")[1].split("_name=")[0] %>')">
							<%=info.getPivarvalue().split("_svc_")[1].split("_name=")[1] %></a>
						<% } else { 
								if((!info.getPivarvalue().contains("N/A"))&& (!WorkFlowConstDefine.PROCESS_PIVRLABEL.equals(info.getPivarlabel()))
										&& (!WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype()))){%>
											${info.pivarvalue}
									<%	}
									 } %>
					</td>
				<%} %>
					<%if(index.intValue()%2!=0){%>
				<%= "</tr>"%>
				<%}%>
			</logic:iterate>
		</table>
		</div>
		</logic:notEmpty>
	</logic:present>

	
		<div class="title" style="cursor: hand;">
		<div class="name" onclick="toggleElement('personMessage','personMessageImg')">人员信息<img id="personMessageImg" src="images/add_1.jpg"></div>
	</div>
	<div class="record_list" id="personMessage" style="display: none">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%">发起者：</th>
			<td width="35%"><bean:write name="process" property="prusername" /></td>
			<th width="15%">联系方式：</th>
			<td width="35%"><bean:write name="process" property="prinfo" /></td>
		</tr>
		<tr>
			<th>发起者角色：</th>
			<td><bean:write name="process" property="prrolename" /></td>
			<th>发起者部门：</th>
			<td><bean:write name="process" property="prorgname" /></td>
		</tr>
	</table>
	</div>
	<div class="title" style="cursor: hand;">
	<div class="name" onclick="toggleElement('timeMessage','timeMessageImg')">时间信息<img id="timeMessageImg" src="images/add_1.jpg"></div>
	</div>
	<div class="record_list" id="timeMessage" style="display: none">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%">发生时间：</th>
			<td><bean:write name="process" property="prplantime" /></td>
			</tr>
	</table>
	</div>
	<logic:present name="${vo}" property="attachmentMap">
	<bean:size id="attachmentSize" name="${vo}" property="attachmentMap"/>
	<c:if test="${attachmentSize > 0}">
	<div class="title" style="cursor: hand;">
	<div class="name" onclick="toggleElement('fileMessage','fileMessageImg')">附件信息<img id="fileMessageImg" src="images/add_1.jpg"></div>
	</div>
	<div class="record_list" id="fileMessage" style="display: none;">
	<table  class="table_style">
		<tr>
			<th width="10%">上传者</th>
			<th width="20%">上传时间</th>
			<th width="70%">附件</th>
		</tr>
		<logic:iterate id="bean" name="${vo}" property="attachmentMap" indexId="index">
			<bean:define id="keycode" name="bean" property="key" type="java.lang.String"/>
			<bean:define id="valuevo" name="bean" property="value" type="java.util.ArrayList"/>
			<tr>
			<td>
				<logic:iterate id="abean" name="valuevo" type="com.deliverik.framework.model.Attachment" length="1">
					<bean:write name="abean" property="attdesc" />
				</logic:iterate>
			</td>
				
			<td>
				<logic:iterate id="bbean" name="valuevo" type="com.deliverik.framework.model.Attachment" length="1">
					<bean:write name="bbean" property="atturl" />
				</logic:iterate>
			</td>
			<td>
				<logic:iterate id="attachment" name="valuevo" indexId="index">
					<html:link action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
						<bean:define id="attname" name="attachment" property="attname" />
						<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>&nbsp;&nbsp;
					</html:link>
				</logic:iterate>
<!--				<img src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}')" border="0" style="cursor: hand" alt="删除"/><br/>-->
			</td>
			</tr>
		</logic:iterate>
	</table>
	</div>
	</c:if>
	</logic:present>
</logic:present>


<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>

	<logic:present name="${vo}" property="recordLogMap">
	<div class="title" style="cursor: hand;">
	<div class="name" onclick="toggleElement('TabbedPanels1','logMessageImg')">
	 	日志信息<img id="logMessageImg" src="images/add_1.jpg">
	</div>
</div>
	
		<div id="TabbedPanels1" class="TabbedPanels" style="display: none;">
		<logic:notEmpty name="${vo}" property="recordLogMap">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="${vo}" property="recordLogMap" indexId="number">
				<bean:define id="nameBean" name="map" property="key" />
				<li class="TabbedPanelsTab" id="${map.key}" >
					${nameBean.prid}
				</li>
			</logic:iterate>
		</ul>
		<div class="TabbedPanelsContentGroup">
		    <logic:present name="${vo}">
			<logic:iterate id="map" name="${vo}" property="recordLogMap" indexId="number">
				<bean:define id="logList" name="map" property="value" type="java.util.List" />
				<div class="TabbedPanelsContent">
				<div style="width:960px;height:25px;overflow-y:auto;overflow-x:hidden; ">
				<table class="table_style" style="width:960px;overflow-y:auto;overflow-x:hidden;" border="1" bordercolor="#cccccc">
					<tr>
				        <th width="10%">时间</th>
						<th width="8%">相关人员</th>
						<th width="10%">部门</th>
						<th width="12%">角色</th>
						<th width="25%">内容</th>
						<th width="20%">日志</th>
						<th width="15%">附件</th>			
					</tr>
				</table>
				</div>
				<div style="width:960px;height:200px;overflow-y:auto;overflow-x:hidden; ">
				<table class="table_style" style="width:960px;" border="1" bordercolor="#cccccc">
					<logic:iterate id="recordLog" name="logList" indexId="index" >	
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
					       	<td width="10%"><SPAN class="red">${recordLog.rltime}</SPAN></td>
							<td width="8%">${recordLog.rlusername}</td>
							<td width="10%">${recordLog.rlorgname}</td>
							<td width="12%">${recordLog.rlrolename}</td>
							<td align="left" width="25%"><pre><bean:write name="recordLog" property="rlcomment" filter="false" /></pre></td>
							<td width="20%"><bean:write name="recordLog" property="rldesc" filter="false" /></td>
							<td width="15%">
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
							</td>						
						</tr>
						
					</logic:iterate>
				</table>
				</div>
				</div>
			</logic:iterate>
			</logic:present>
		</div>
			</logic:notEmpty>
		</div>
		
		
		<logic:notEmpty name="${vo}" property="recordLogMap">
		<script type="text/javascript">
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			//-->
		</script>
		</logic:notEmpty>
	</logic:present>
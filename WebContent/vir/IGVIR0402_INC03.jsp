<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>

<c:choose>
        <c:when test="${IGPRR01021VO.process.prstatus != 'C'}">
        <c:if test="${(IGPRR01021VO.lst_ParticipantVisibleButtonVWInfo != null && (IGPRR01021VO.process.prtype == 'ID' || IGPRR01021VO.process.prtype == 'PD' || IGPRR01021VO.process.prtype == 'WD')) || IGPRR01021VO.voList != null}">
        </c:if>
        <div class="record_list">
        <logic:present name="IGPRR01021VO" property="voList">
         <bean:size id="number" name="IGPRR01021VO" property="voList"/>
         <c:if test="${number > 0}">
        <div class="title">
        <div class="name">相关流程</div>
        </div> 
        </c:if>
        <table cellspacing="2" class="table_style">
            <logic:iterate id="element" name="IGPRR01021VO" property="voList">
                <logic:present name="element" property="ig500InfoList">
                    <bean:size id="num" name="element" property="ig500InfoList"/>
                    <c:if test="${num > 0}">
                        <tr>
                            <th width="15%">工单号</th>
                            <th width="15%">流程名称</th>
                            <th width="15%">发起时间</th>
                            <th width="15%">状态</th>
                            <th width="15%">处理人</th>
                        </tr>
                        <logic:present name="element" property="ig500InfoList">
                            <logic:iterate id="bean" name="element" property="ig500InfoList">
                                <tr>
                                    <td>
                                    <a href="javascript:void(0)" onclick="openRelatedProcess('${bean.prid}','${bean.prtype}')">
                                    ${bean.prserialnum} </a>
                                    </td>
                                    <td>${bean.prtitle}</td>
                                    <td>${bean.propentime}</td>
                                    <td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
                                    <td><ig:processDisposePersonValue prid="${bean.prid}" prstatus="${bean.prstatus}"/></td>
                                </tr>
                            </logic:iterate>
                        </logic:present>
                    </c:if>
                </logic:present>
            </logic:iterate>
        </table>
        </logic:present>
         
        </div>
        </c:when>
        <c:otherwise>
            <logic:present name="IGPRR01021VO" property="voList">
                <bean:size id="number" name="IGPRR01021VO" property="voList"/>
                <c:if test="${number > 0}">
                <div class="title">
                <div class="name">相关流程</div>
                </div>
                <div class="record_list">
                <table cellspacing="2" class="table_style">
                    <logic:iterate id="element" name="IGPRR01021VO" property="voList">
                        <logic:present name="element" property="ig500InfoList">
                            <bean:size id="num" name="element" property="ig500InfoList"/>
                            <c:if test="${num > 0}">
                                <tr>
                            <th width="15%">工单号</th>
                            <th width="15%">流程名称</th>
                            <th width="15%">发起时间</th>
                            <th width="15%">状态</th>
                            <th width="15%">处理人</th>
                        </tr>
                        <logic:present name="element" property="ig500InfoList">
                            <logic:iterate id="bean" name="element" property="ig500InfoList">
                                <tr>
                                    <td>
                                    <a href="javascript:void(0)" onclick="openRelatedProcess('${bean.prid}','${bean.prtype}')">
                                    ${bean.prserialnum} </a>
                                    </td>
                                    <td>${bean.prtitle}</td>
                                    <td>${bean.propentime}</td>
                                    <td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
                                    <td><ig:processDisposePersonValue prid="${bean.prid}" prstatus="${bean.prstatus}"/></td>
                                </tr>
                            </logic:iterate>
                        </logic:present>
                            </c:if>
                        </logic:present>
                    </logic:iterate>
                </table>
                </div>
                </c:if>
            </logic:present>
        </c:otherwise>
    </c:choose>
    <logic:present name="IGPRR01021VO" property="ig715InfoList">
        <bean:size id="num" name="IGPRR01021VO" property="ig715InfoList"/>
        <c:if test="${num > 0}">
        <div class="title">
        <div class="name">相关服务工单</div>
        </div>
        <div class="record_list">
        <table cellspacing="2" class="table_style1">
            <logic:iterate id="bean" name="IGPRR01021VO" property="ig715InfoList">
                <tr>
                    <th width="15%">工单名称：</th>
                    <td colspan="3">
                        <a href="javascript:void(0)" onClick="openRelatedProcess('${bean.serviceFormTB.sfid}','SF')">${bean.serviceFormTB.sftitle}</a><br/>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        </div>
        </c:if>
    </logic:present>
	<logic:present name="IGPRR01021VO" property="recordLogMap">
	<logic:equal name="IGPRR01021VO" property="hasCLRecord" value="1">
	<div class="title">
	<div class="name">日志信息</div>
	</div>
	<div style="margin-top:-30px;margin-right:45px!important;margin-right:25px;float: right;display:none;">
		<table>
			<tr>
				<td>
					<a href="IGPRR0102_Dispe.do?prid=${prid }&type=sys">处理日志导出</a>
				</td>
			</tr>
		</table>
	</div>
       <div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
			<c:if test="${map.key=='处理类日志'}">
				<li class="TabbedPanelsTab" tabindex="0" id="${map.key}" >
					${map.key}
				</li>
			</c:if>
			</logic:iterate>
			<li class="TabbedPanelsTab" tabindex="0" id="vmlog" >
				虚机部署日志
			</li>
		</ul>
		<div class="TabbedPanelsContentGroup">
		    <logic:present name="IGPRR01021VO">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
				<c:if test="${map.key=='处理类日志'}">
				<bean:define id="logList" name="map" property="value" type="java.util.List" />
				<div class="TabbedPanelsContent">
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<tr>
						<th width="15%">状态</th>
						<th width="15%">部门</th>
						<th width="40%">内容</th>
						<th width="10%">处理人</th>
						<th width="10%">操作</th>
						<th width="10%">处理时间</th>
					</tr>
				</table>
				</div>
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<logic:iterate id="recordLog" name="logList" indexId="index" >	
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<td width="15%">${recordLog.psname}</td>
							<td width="15%">${recordLog.rlorgname}</td>
							<td width="40%" align="left">
							<pre><bean:write name="recordLog" property="rlcomment" filter="false" /></pre>
							<c:if test="${recordLog.psname != '提交'}">
							<logic:present name="recordLog" property="attachmentList">
									<logic:notEmpty	name="recordLog" property="attachmentList">
										<bean:define id="attachmentList" name="recordLog" property="attachmentList" type="java.util.List" />
										<logic:iterate id="attachment" name="attachmentList" indexId="number">
											<html:link
												action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
												<bean:define id="attname" name="attachment" property="attname" />
												<%= attname.toString().substring(attname.toString().indexOf("_")+1) %>
											</html:link>
											<br />
										</logic:iterate>
									</logic:notEmpty>
							</logic:present>
							</c:if>
							</td>
							<td width="10%">${recordLog.rlusername}</td>
							<td width="10%">${recordLog.rldesc}</td>
							<td width="10%"><SPAN class="red">${recordLog.rltime}</SPAN></td>
						</tr>
					</logic:iterate>
				</table>
				</div>
			</div>
			</c:if>
			</logic:iterate>
			</logic:present>
			<div class="TabbedPanelsContent">
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<tr>
						<th width="15%">虚机名称</th>
						<th width="40%">日志内容</th>
						<th width="15%">部署结果</th>
						<th width="10%">完成时间</th>
					</tr>
				</table>
				<table id="logconTable" class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<tr style="display: none;">
						<td width="15%"></td>
						<td width="40%"></td>
						<td width="15%"></td>
						<td width="10%"></td>
					</tr>
				</table>
				</div>
				<div>
				</div>
			</div>
		</div>
		</div>
		<script type="text/javascript">
		
			jQuery(document).ready(function(){
				var pid = getFormObj("项目主键").value;
				jQuery.post(getAppRootUrl() + "/IGVIR0202_GetDeployLog.do", "pid=" + pid, function (data) {
// 					alert(data);
					var deployLog_json = eval("(" +data + ")");
					var table = jQuery('#logconTable');
					jQuery.each(deployLog_json, function (i, value) { 
						var row = jQuery("<tr></tr>"); 
						var td = jQuery("<td></td>");
						td.append(value.vmName);
						row.append(td);
						var td = jQuery("<td></td>");
						td.append(value.content);
						row.append(td);
						var td = jQuery("<td></td>");
						td.append(value.flag == "1" ? "成功" : "失败");
						row.append(td);
						var td = jQuery("<td></td>");
						td.append(value.updateTime);
						row.append(td);
						table.append(row);
					});
				});
			});
		
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			//-->
		</script>
	</logic:equal>
	</logic:present>
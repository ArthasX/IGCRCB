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
<html:html>
<bean:define id="id" value="IGPRD0158h" toScope="request" />
<bean:define id="title" value="流程策略页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<logic:present name="IGPRD01581VO" property="showMap" >
	<bean:define id="lst_ProcessNoticeStrategyDef"  name="IGPRD01581VO" property="showMap" scope="request" />
</logic:present>
<script type="text/javascript">	
<!--
function checkForm(){
	if($F('pidname') == ""){
		alert("请选择流程表单");
		return false;
	}
	
	<logic:iterate id="map" name="IGPRD01581VO" property="showMap" scope="request" indexId="index">
		<bean:define id="mapkey" name="map" property="key" type="com.deliverik.framework.workflow.prd.model.IG238Info" />
		<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
		<logic:iterate id="bean" name="list" indexId="number">
		
			var isnotify = false;
			if(parseInt($F('notifyd[${ADValueCount}]')) 
					+ parseInt($F('notifyh[${ADValueCount}]'))
					+ parseInt($F('notifym[${ADValueCount}]')) == 0 && $F('roleid[${ADValueCount}]') != ""){
				alert("请设定状态为${mapkey.psdname}表单值为${bean.pivalue}的超时提醒时间！");
				return false;
			} else {
				isnotify = true;
			}
			var rolemanager = document.getElementById('rolemanager[${ADValueCount}]').value;
			var processbl = document.getElementById('processbl[${ADValueCount}]').value;
			if((parseInt($F('reportd[${ADValueCount}]')) 
					+ parseInt($F('reporth[${ADValueCount}]'))
					+ parseInt($F('reportm[${ADValueCount}]')) == 0) && rolemanager != "") {
				alert("请设定状态为${mapkey.psdname}表单值为${bean.pivalue}的报告上级时间！");
				return false;
			}
			if((parseInt($F('reportd[${ADValueCount}]')) 
					+ parseInt($F('reporth[${ADValueCount}]'))
					+ parseInt($F('reportm[${ADValueCount}]')) > 0) && rolemanager == ""){
				alert("请设定状态为${mapkey.psdname}表单值为${bean.pivalue}的报告上级通知人！");
				return false;
			}
			if(!$('sms').checked && !$('email').checked) {
				if(rolemanager != ""){
					alert("请设定通知方式！");
					return false;
				}
				if(parseInt($F('notifyd[${ADValueCount}]')) 
						+ parseInt($F('notifyh[${ADValueCount}]'))
						+ parseInt($F('notifym[${ADValueCount}]'))  > 0){
					alert("请设定通知方式！");
					return false;
				}
			}
			if(rolemanager == "1" && $F('notifierids[${ADValueCount}]') == ""){
				alert("请设定状态为${mapkey.psdname}表单值为${bean.pivalue}的报告上级通知人！");
				return false;
			}
			
			//alert(processbl);
			if(((parseInt($F('notifyd[${ADValueCount}]')) 
					+ parseInt($F('notifyh[${ADValueCount}]'))
					+ parseInt($F('notifym[${ADValueCount}]'))) > 0  || rolemanager !="") && processbl == ""){
				alert("请设定状态为${mapkey.psdname}表单值为${bean.pivalue}的处理BL！");
				return false;
			}
			
			<c:set var="ADValueCount" value="${ADValueCount+1}"/>
		</logic:iterate>
	</logic:iterate>
	// 校验流程整体策略
	<logic:present name="IGPRD01581VO" property="processWholeTactic_list">
	<logic:iterate id="pwtbean" name="IGPRD01581VO" property="processWholeTactic_list" indexId="index">
		if(parseInt($F('notifyd_all[${index}]')) 
				+ parseInt($F('notifyh_all[${index}]'))
				+ parseInt($F('notifym_all[${index}]')) > 0 && $F('roleid_all[${index}]') == ""){
			alert("请设定流程整体的超时提醒通知人！");
			return false;
		}
		if(parseInt($F('notifyd_all[${index}]')) 
				+ parseInt($F('notifyh_all[${index}]'))
				+ parseInt($F('notifym_all[${index}]')) == 0 && $F('roleid_all[${index}]') != ""){
			alert("请设定流程整体的超时提醒时间！");
			return false;
		}
		
		if($F('roleid_all[${index}]') != "" && $F('processbl_all[${index}]') == ""){
			alert("请设定流程整体的处理BL！");
			return false;
		}
	</logic:iterate>
	</logic:present>
	
	if( window.confirm("请确认是否进行流程策略设定处理？")){
		return true;
	} else {
		return false;
	}
}

function selectUser(rowIndex){
	var obj = window.showModalDialog("<%=request.getContextPath()%>/IGPRD0160_Disp.do?rowIndex=" + rowIndex, new Array(window),"dialogWidth:560px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if(obj != null){ 
	}
}

function showUser(obj, index){
	if(obj.value == "1"){
		document.getElementById("user_a" + index).style.display="";
		document.getElementById("notifiernames_" + index).style.display="";
	} else {
		document.getElementById("user_a" + index).style.display="none";
		document.getElementById("notifiernames_" + index).style.display="none";
	}	
}

function selectVariable(){
	openSubWindow('/IGPRD0182_Disp.do?pidmode=0&pdid=${IGPRD0158Form.pdid}&tableColumn=N', 'newpage', '800', '600');
}

function setVariableLogic(id, type, name,option){
	document.getElementById("pidid").value = id;
	document.getElementById("pidname").value = name;
}

function setSubmit(){
	if($F('pidname') == ""){
		alert("请选择流程表单");
		return false;
	}
	
	if( window.confirm("请确认是否进行流程策略设定处理？")){
		IGPRD0158Form.action = getAppRootUrl() + "/IGPRD0158_Set.do";
		IGPRD0158Form.submit();
		IGPRD0158Form.action = getAppRootUrl() + "/IGPRD0158.do";
		return true;
	} else {
		return false;
	}
}
//-->
</script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0158" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation /> &gt;&gt; 历史版本 &gt;&gt; 流程策略</p>
<div class="back"><a href="IGPRD0140_Back.do?pdid=${IGPRD0158Form.pdid}" target="_self">返回</a></div> 
</div>
	<div id="search" align="left">
		<div class="img"></div>
		<div class="conditions">
		
		<table width="100%">
			<tr>
				<td width="10%" align="right">流程表单：</td>
				<td width="15%" align="left">
					<html:text styleId="pidname" property="pidname" style="width:100px;"></html:text>
					<img src="images/seek.gif" alt="选择表单" width="16" height="16" border="0" style="cursor: pointer;" onclick="selectVariable()"/>
					<html:hidden styleId="pidid" property="pidid"/>
				</td>
				<td width="10%" align="right">通知方式：</td>
				<td width="15%" align="left">
					<html:multibox property="sms" style="vertical-align:middle" value="1"/>
					<span style="vertical-align:middle">短信</span>  
					<html:multibox property="email" style="vertical-align:middle" value="1"/>
					<span style="vertical-align:middle">邮件</span></td>
				<td width="10%" align="right">
				</td>
				<td width="15%" align="left">
				</td>
				<td width="10%" align="right"></td>
				<td width="15%" align="left">
					<html:hidden property="pdid"/>
					<html:hidden property="pssize"/>
					<html:hidden property="pisize"/>
				</td>
			</tr>
		</table>
		</div>
		
	</div>
	<logic:present name="IGPRD01581VO" property="showMap">
		<div id="TabbedPanels1" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<logic:iterate id="map" name="IGPRD01581VO" property="showMap" indexId="number">
						<bean:define id="mapKey" name="map" property="key" type="com.deliverik.framework.workflow.prd.model.IG238Info"></bean:define>
						<li class="TabbedPanelsTab" tabindex="0">
							${mapKey.psdname }
						</li>
					</logic:iterate>
					<li class="TabbedPanelsTab" tabindex="0">
						流程整体
					</li>
				</ul>
			<div class="TabbedPanelsContentGroup">
			<logic:present name="lst_ProcessNoticeStrategyDef">
			<logic:iterate id="map" name="lst_ProcessNoticeStrategyDef" indexId="number">
				<bean:define id="mapkey" name="map" property="key" type="com.deliverik.framework.workflow.prd.model.IG238Info" />
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<fieldset>
					<div>
				<label for="Name" ><strong>新待办通知</strong>：</label>
					<p class="p2" style="width:250px;" >
					
						<input type="radio" name="isnotify[${number }]" value="0" style="vertical-align:middle"
							<c:if test="${mapkey.sms == '1' || mapkey.email == '1' }">
							 checked="checked"
							</c:if>
						 /><span style="vertical-align:middle">是</span>  
						
						
						<input type="radio" name="isnotify[${number }]" value="1" style="vertical-align:middle" 
							<c:if test="${mapkey.sms != '1' && mapkey.email != '1' }">
							 checked="checked"
							</c:if>
						/><span style="vertical-align:middle">否</span>
						<html:hidden name="IGPRD0158Form" property="psdid_s[${number }]" value="${mapkey.psdid}"/>
						<html:hidden name="IGPRD0158Form" property="psdconfirms_s[${number}]" value="${mapkey.psdconfirm}"/>
					</p>
				</div>
				</fieldset>
				<fieldset>
					<legend>超时通知</legend>
					<div id="results_list"><ig:message />
						<div>注：超时提醒默认通知当前处理人，如要通知其他人请在下面设置。</div>
						<table class="table_style2">
							<tr>
								<th width="10%" rowspan="2">${IGPRD0158Form.pidname }</th>
								<th width="25%" colspan="3">超时提醒时间</th>
								<th width="15%" rowspan="2">超时提醒<br/>通知人</th>
								<th width="25%" colspan="3">报告上级时间</th>
								<th width="15%" rowspan="2">报告上级<br/>通知人</th>
								<th width="10%" rowspan="2">处理BL</th>
							</tr>
							<tr>
								<th width="10%">天</th>
								<th width="10%">小时</th>
								<th width="10%">分</th>
								<th width="10%">天</th>
								<th width="10%">小时</th>
								<th width="10%">分</th>
							</tr>
							<logic:present name="lst_ProcessNoticeStrategyDef">
								<logic:empty name="list">
									没有设置超时通知的流程表单
								</logic:empty>
								
								<logic:iterate id="bean" name="list" indexId="index">
									<tr>
										<td>${bean.pivalue}</td>
										<td>
											<html:select styleId="notifyd[${ADcount}]" name="IGPRD0158Form" property="notifyd[${ADcount}]" value="${bean.notifyd}">
												<ig:optionsCollection ccid="DAYS_CODE" isMakeBlankRow="false" isCodeLabel="true" />
											</html:select>
											
											</td>
										<td><html:select styleId="notifyh[${ADcount}]" name="IGPRD0158Form" property="notifyh[${ADcount}]" value="${bean.notifyh}">
												<ig:optionsCollection ccid="HOURS_CODE" isMakeBlankRow="false" isCodeLabel="true" />
											</html:select></td>
										<td><html:select styleId="notifym[${ADcount}]" name="IGPRD0158Form" property="notifym[${ADcount}]" value="${bean.notifym}">
												<ig:optionsCollection ccid="MINUTES_CODE" isMakeBlankRow="false" isCodeLabel="true" />
											</html:select></td>
										<td>
											<html:select styleId="roleid[${ADcount}]" name="IGPRD0158Form" property="roleid[${ADcount}]" value="${bean.roleid }"  errorStyleClass="inputError" tabindex="5">
												<html:option value=""></html:option>
												<html:options collection="lvPsdassignListRO" property="value" labelProperty="label" />
											</html:select>
										</td>
										<td><html:select styleId="reportd[${ADcount}]" name="IGPRD0158Form" property="reportd[${ADcount}]" value="${bean.reportd}">
												<ig:optionsCollection ccid="DAYS_CODE" isMakeBlankRow="false" isCodeLabel="true" />
											</html:select></td>
										<td><html:select name="IGPRD0158Form" property="reporth[${ADcount}]" value="${bean.reporth}">
												<ig:optionsCollection ccid="HOURS_CODE" isMakeBlankRow="false" isCodeLabel="true" />
											</html:select></td>
										<td><html:select styleId="reportm[${ADcount}]" name="IGPRD0158Form" property="reportm[${ADcount}]" value="${bean.reportm}">
												<ig:optionsCollection ccid="MINUTES_CODE" isMakeBlankRow="false" isCodeLabel="true" />
											</html:select></td>
										<td><html:select styleId="rolemanager[${ADcount}]" name="IGPRD0158Form" property="rolemanager[${ADcount}]" value="${bean.rolemanager}" onchange="showUser(this, '${ADcount}')">
												<ig:optionsCollection ccid="PRSTRATEGY_NOTIFIER_TYPE_CODE" isMakeBlankRow="true" isCodeLabel="true" />
											</html:select>
											<a style="display:none" id="user_a${ADcount}" href="javascript:void(0)" onclick="selectUser('${ADcount}');"><img src="images/seek.gif" alt="指定通知人" width="16" height="16" border="0" /></a>
											<br/><span <c:if test="${bean.rolemanager != 1}"> style="display:none;" </c:if> id="notifiernames_${ADcount}">${bean.notifiernames}</span>
											
										</td>
										<td>
											<html:select styleId="processbl[${ADcount}]"  style="width:90px;" name="IGPRD0158Form" property="processbl[${ADcount}]" value="${bean.processbl }"  errorStyleClass="inputError" tabindex="5">
												<html:option value=""></html:option>
												<logic:present name="lvProcessBLList">
													<html:options collection="lvProcessBLList" property="value" labelProperty="label" />
												</logic:present>
											</html:select>
										</td>
										<html:hidden  name="IGPRD0158Form" property="psdid_i[${ADcount}]" value="${bean.psdid}"/>
										<html:hidden name="IGPRD0158Form" property="pidid_i[${ADcount}]" value="${bean.pidid}"/>
										<html:hidden name="IGPRD0158Form" property="pivalue[${ADcount}]" value="${bean.pivalue}"/>
										<html:hidden name="IGPRD0158Form" property="notifierids[${ADcount}]" value="${bean.notifierids}"/>
										<html:hidden name="IGPRD0158Form" property="notifiernames[${ADcount}]" value="${bean.notifierids}"/>
										<html:hidden name="IGPRD0158Form" property="psdconfirms[${ADcount}]" value="${mapkey.psdconfirm}"/>
									</tr>
								<c:set var="ADcount" value="${ADcount+1}"/>
								</logic:iterate>
							</logic:present>
						</table>
					</div>
					</fieldset>
				</div>
			</logic:iterate>
			<div class="TabbedPanelsContent">
				<fieldset>
					<legend>超时通知</legend>
					<div id="results_list"><ig:message />
						<table class="table_style2">
							<tr>
								<th width="10%" rowspan="2">${IGPRD0158Form.pidname }</th>
								<th width="25%" colspan="3">超时提醒时间</th>
								<th width="15%" rowspan="2">超时提醒<br/>通知人</th>
								<th width="10%" rowspan="2">处理BL</th>
							</tr>
							<tr>
								<th width="10%">天</th>
								<th width="10%">小时</th>
								<th width="10%">分</th>
							</tr>
							<logic:present name="IGPRD01581VO" property="processWholeTactic_list">
								<logic:iterate id="pwtbean" name="IGPRD01581VO" property="processWholeTactic_list" indexId="index">
										<tr>
											<td>${pwtbean.pivalue}</td>
											<td>
												<html:select name="pwtbean" property="notifyd_all[${index }]"  value="${pwtbean.notifyd}">
													<ig:optionsCollection ccid="DAYS_CODE" isMakeBlankRow="false" isCodeLabel="true" />
												</html:select>
												
												</td>
											<td><html:select name="pwtbean" property="notifyh_all[${index }]"   value="${pwtbean.notifyh}">
													<ig:optionsCollection ccid="HOURS_CODE" isMakeBlankRow="false" isCodeLabel="true" />
												</html:select></td>
											<td><html:select name="pwtbean" property="notifym_all[${index }]"  value="${pwtbean.notifym}">
													<ig:optionsCollection ccid="MINUTES_CODE" isMakeBlankRow="false" isCodeLabel="true" />
												</html:select></td>
											<td>
												<html:select name="pwtbean" property="roleid_all[${index }]" errorStyleClass="inputError" tabindex="5" value="${pwtbean.roleid }">
													<html:option value=""></html:option>
													<html:options collection="lvPsdassignListRO" property="value" labelProperty="label" />
												</html:select>
											</td>
											<td>
												<html:select styleId="processbl_all"  style="width:90px;" name="pwtbean" property="processbl_all[${index }]" value="${pwtbean.processbl }"  errorStyleClass="inputError" tabindex="5">
													<html:option value=""></html:option>
													<logic:present name="lvProcessAllBLList">
														<html:options collection="lvProcessAllBLList" property="value" labelProperty="label" />
													</logic:present>
												</html:select>
											</td>
										</tr>
										<html:hidden name="IGPRD0158Form" property="pidid_all[${index}]" value="${pwtbean.pidid}"/>
										<html:hidden name="IGPRD0158Form" property="pivalue_all[${index}]" value="${pwtbean.pivalue}"/>
								</logic:iterate>
							</logic:present>
						</table>
					</div>
					</fieldset>
				</div>
			</logic:present>
			</div>
		</div>
	</logic:present>
	
	<script type="text/javascript">
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			//-->
		</script>
	<div align="center">
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
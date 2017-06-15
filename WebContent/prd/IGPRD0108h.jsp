<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<%@ page import="com.deliverik.infogovernor.prd.vo.IGPRD01081VO" %>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG881Info" %>
<%@ page import="java.util.*" %>
<html:html>
<bean:define id="id" value="IGPRD0108h" toScope="request" />
<bean:define id="title" value="参与者授权页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

<!--
	//按钮操作提示
	function check(){
        if(window.confirm("您确定要提交吗？")){

			count=checkAndCreate();
// 			if(count==0){
// 				alert("请您至少为当前参与者选择一个动作！");
// 	            return false;
// 			}
			if(count==-1){
	            return false;
			}
			var isProcessDefinitionChoosed = false;
			var divDisplay = document.getElementById("processDefinitionDiv").style.display;
            var selectProcessDefinitionButtons = document.getElementsByName("selectProcessDefinitionButtons");
            for(var i=0;i<selectProcessDefinitionButtons.length;i++){
                if (divDisplay == "" && selectProcessDefinitionButtons[i].checked == true) {
                    document.getElementsByName("relevantPdid")[i].value=selectProcessDefinitionButtons[i].value;
                    isProcessDefinitionChoosed = true;
                }
            }
            if (divDisplay == "" && !isProcessDefinitionChoosed) {
                alert("请选择相关发起的流程类型！");
                return false;
            }
						
			var pikeys = document.getElementsByName("selectButtons");
			var ppbdauths = document.getElementsByName("selectAuth");
			var checkrequireds = document.getElementsByName("required");
			var checkrecords = document.getElementsByName("record");
			for(var i=0;i<pikeys.length;i++){
				if(pikeys[i].checked==true){
					document.getElementsByName("pbdid")[i].value=pikeys[i].value;
					if(ppbdauths.length > 0){
						document.getElementsByName("ppbdauth")[i].value=ppbdauths[i].value;
					}
					if(checkrequireds.length > 0){
						document.getElementsByName("checkrequired")[i].value=checkrequireds[i].value;
					}
					if(checkrecords.length > 0){
						document.getElementsByName("checkrecord")[i].value=checkrecords[i].value;
					}	
				}
			}
			pidaccessCreate();
			pidrequiredCreate();

            return true;
        } else {
            return false;
        }
	}
function checkAndCreate(){
	var count=0;
	var pikeys = document.getElementsByName("selectButtons");
	var pikeynames = document.getElementsByName("ppbdname");
	var pikeydecs = document.getElementsByName("ppbddesc");

	for(var i=0;i<pikeys.length;i++){
		if(pikeys[i].checked==true){
			if(pikeynames[i].value!=""){
				count=1;
			}else{
				count=-1;
				if(pikeynames[i].value == ""){
					alert("请填写选中按钮的名称");
				}
				break;
			}
			if(pikeydecs[i] != null){
				if(pikeydecs[i].value.strlen() > 32){
					count=-1;
					alert("提示不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
					break;
				}
			}

		}
	}
	return count;
}

function pidaccessCreate(){
	var accesses = document.getElementsByTagName("input");
	var pidids = document.getElementsByName("pidid");
	for(var i=0;i < accesses.length;i++){
		if(accesses[i].type=="radio"){
			if(accesses[i].name.indexOf("pidaccess") > -1) {
				if(accesses[i].checked==true){
					createHiddenInputForm("pidaccesses",accesses[i].value,IGPRD0108Form);
				}
			}
		}
		
	}
}

function pidrequiredCreate(){
	var requireds = document.getElementsByTagName("input");
	for(var i=0;i < requireds.length;i++){
		if(requireds[i].type=="radio"){
			if(requireds[i].name.indexOf("pidrequired") > -1) {
				if(requireds[i].checked==true){
					createHiddenInputForm("pidrequired",requireds[i].value,IGPRD0108Form);
				}
			}
		}
		
	}
}
	 function toback(){
		 IGPRD0108Form.action = getAppRootUrl() + "/IGPRD0107_Disp.do?psdid="+IGPRD0108Form.psdid.value+"&ppdid="+IGPRD0108Form.ppdid.value+"&pdid="+IGPRD0108Form.pdid.value;
		 IGPRD0108Form.submit();
	 }

function showDiv(obj,index){
	if(obj.value == "3"){
		document.getElementById("showRadio"+index).style.display = "";
		document.getElementById("showDefault"+index).style.display = "none";
	}else{
		document.getElementById("showRadio"+index).style.display = "none";
		document.getElementById("showDefault"+index).style.display = "";
		document.getElementsByName("pidrequired"+index)[0].checked="checked";
	}
}
function showRadioDiv(){
	<logic:present name="IGPRD01081VO" property="lst_processInfoParticipantDefVW">
		<logic:iterate id="bean1" name="IGPRD01081VO" property="lst_processInfoParticipantDefVW" indexId="index1">
			<logic:equal name="bean1" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
				document.getElementById("showRadio${index1}").style.display = "";
				document.getElementById("showDefault${index1}").style.display = "none";
			</logic:equal>
			<logic:notEqual name="bean1" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
				document.getElementById("showRadio${index1}").style.display = "none";
				document.getElementById("showDefault${index1}").style.display = "";
			</logic:notEqual>
		</logic:iterate>
	</logic:present>

	var pikeys = document.getElementsByName("selectButtons");
    for(var i=0;i<pikeys.length;i++){
        if(pikeys[i].value=='05' && pikeys[i].checked==true){
        	document.getElementById("processDefinitionDiv").style.display = "";
        }
    }
	
}

function selectButtonsClick(obj) {
	if (obj.value == '05' ){
		if (obj.checked) {
	        document.getElementById("processDefinitionDiv").style.display = "";
	    }else {
	        document.getElementById("processDefinitionDiv").style.display = "none";
	    }
	}
}
//-->
</script>
<body onload="showRadioDiv();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0108" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt;流程管理 &gt;&gt; 历史版本 &gt;&gt; 状态列表 &gt;&gt; 参与者 &gt;&gt; 权限</p>
<div class="back"><a href="javascript:toback();" target="_self">返回</a></div> 
</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<div class="role_title">当前状态：${IGPRD01071VO.processStatusDef.psdname}</div>
	<br/>
	<table id="tab_del" class="table_style13" align="left">
			<tr>

				<th width="15%">当前参与者</th>
				<th width="85%" >
				<c:if test="${IGPRD01081VO.processStatusDef.psdtype == '2'}">
					动作
				</c:if>
				<c:if test="${IGPRD01081VO.processStatusDef.psdtype != '2'}">
					<bean:define id="psdstatus" name="IGPRD01081VO" property="processStatusDef" type="com.deliverik.framework.workflow.prd.model.IG333Info"/>
					<logic:equal value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>" name="psdstatus" property="psdcode">
						动作
					</logic:equal>
					<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>" name="psdstatus" property="psdcode">
						<logic:equal name="psdstatus" property="psdtype" value="0">
							<table width="100%">
								<tr>
									<td width="35%" style="border:0px">
										动作
									</td>
									<td width="35%" style="border:0px">
									           按钮校验
								 	</td>	
 									<td width="10%" style="border:0px">
									           按钮调用js
									</td>								
									<td width="20%" style="border:0px">
										同角色多人处理规则
									</td>
								</tr>				
							</table>
						</logic:equal>
						<logic:notEqual name="psdstatus" property="psdtype" value="0">
							动作
						</logic:notEqual>
					</logic:notEqual>
				</c:if>
				 
				</th>
			</tr>
			<logic:present name="IGPRD01081VO" property="processStatusDef">
				<bean:define id="psd" name="IGPRD01081VO" property="processStatusDef" type="com.deliverik.framework.workflow.prd.model.IG333Info"/>
				<logic:present name="IGPRD01081VO" property="processParticipantDef">
				<bean:define id="bean" name="IGPRD01081VO" property="processParticipantDef"></bean:define>
				<html:hidden property="ppdid" styleId="ppdid" value="${bean.ppdid}"/>
				<tr>
					<td width="15%">
						${bean.role.rolename}
						<c:if test="${bean.user != null}">
						（${bean.user.username}）
						</c:if>
					</td>
					<td align="left" width="85%">
					<c:if test="${IGPRD01081VO.processStatusDef.psdtype != '2'}">
					<logic:equal name="psd" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
						<logic:present name="IGPRD01081VO" property="processParticipantButtonDefVWInfoList">
							<logic:iterate id="ppbdvw" name="IGPRD01081VO" property="processParticipantButtonDefVWInfoList">
								<logic:equal name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_SUBMIT %>">
									<span style="display:block; float:left; padding-top:8px;">${ppbdvw.pbdname}</span>
									<html:hidden property="ppbdid" value="${ppbdvw.ppbdid}"/>
									<html:hidden property="pbdid" value=""/>
									<html:hidden property="ppbdauth" value="0"/>
									<html:hidden property="checkrequired" value="0"/>
									<html:hidden property="checkrecord" value="0"/>									
									<logic:empty name="ppbdvw" property="ppbdid">
										<input type="checkbox" name="selectButtons" value="${ppbdvw.pbdid}" onclick="selectButtonsClick(this)"/>
										<html:text property="ppbdname" size="10" value="${ppbdvw.pbdname}" />
										提示信息：
										<html:text property="ppbddesc" size="10" value="${ppbdvw.pbdname}" />
										<br/>
									</logic:empty>
									<logic:notEmpty name="ppbdvw" property="ppbdid">
										<input type="checkbox" name="selectButtons"  value="${ppbdvw.pbdid}" checked="checked" onclick="selectButtonsClick(this)"/>
										<html:text property="ppbdname" size="10" value="${ppbdvw.ppbdname}" />
										提示信息：
										<html:text property="ppbddesc" size="10" value="${ppbdvw.ppbddesc}" />
										<br/>
									</logic:notEmpty>
								</logic:equal>
							</logic:iterate>						
						</logic:present>
					</logic:equal>
					<logic:notEqual name="psd" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
						<logic:present name="IGPRD01081VO" property="processParticipantButtonDefVWInfoList">
							<logic:iterate id="ppbdvw" name="IGPRD01081VO" property="processParticipantButtonDefVWInfoList">
								<logic:notEqual name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_CONFIRM %>">
								 <logic:notEqual name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_TERMINATE %>">
								 <span style="width:70px; display:block; float:left; padding-top:8px;">${ppbdvw.pbdname}</span>
								<html:hidden property="ppbdid" value="${ppbdvw.ppbdid}"/>
								<html:hidden property="pbdid" value=""/>
								<html:hidden property="ppbdauth" value="0"/>
								<html:hidden property="checkrequired" value="0"/>
								<html:hidden property="checkrecord" value="0"/>
								<logic:empty name="ppbdvw" property="ppbdid">
									<input type="checkbox" name="selectButtons" value="${ppbdvw.pbdid}" onclick="selectButtonsClick(this)"/>
									<html:text property="ppbdname" size="10" value="${ppbdvw.pbdname}" />
									提示信息：
									<html:text property="ppbddesc" size="10" value="${ppbdvw.pbdname}" />
									<logic:empty name="ppbdvw" property="checkrequired">
										<logic:notEqual name="ppbdvw" property="pbdflag" value="<%=IGPRDCONSTANTS.BUTTON_PBDFLAG_1 %>">
											<select name="required">
												<option value="0">不校验必填项</option>
												<option value="1" selected="selected">校验必填项</option>
											</select>
										</logic:notEqual>
										<logic:equal name="ppbdvw" property="pbdflag" value="<%=IGPRDCONSTANTS.BUTTON_PBDFLAG_1 %>">
										<logic:equal name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">
											<select name="required" style="visibility: hidden;">
												<option value="0" selected="selected">不校验必填项</option>
												<option value="1">校验必填项</option>
											</select>												
										</logic:equal>
										<logic:notEqual name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">
											<select name="required">
												<option value="0" selected="selected">不校验必填项</option>
												<option value="1">校验必填项</option>
											</select>											
										</logic:notEqual>
										</logic:equal>
									</logic:empty>
									<logic:notEmpty name="ppbdvw" property="checkrequired">
									<logic:notEqual name="ppbdvw" property="checkrequired" value="<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES %>" >
										<select name="required" >
											<option value="0" selected="selected">不校验必填项</option>
											<option value="1">校验必填项</option>
										</select>
									</logic:notEqual>
									<logic:equal name="ppbdvw" property="checkrequired" value="<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES %>">
										<select name="required" >
											<option value="0">不校验必填项</option>
											<option value="1" selected="selected">校验必填项</option>
										</select>									
									</logic:equal>	
									</logic:notEmpty>	
									<logic:equal name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">
										<select name="record" style="visibility: hidden;">
											<option value="0" selected="selected">处理记录不必填</option>
											<option value="1">处理记录必填</option>
										</select>											
									</logic:equal>	
									<logic:notEqual name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">																
									<logic:notEqual name="ppbdvw" property="checkrecord" value="<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_YES %>">
										<select name="record" >
											<option value="0" selected="selected">处理记录不必填</option>
											<option value="1">处理记录必填</option>
										</select>										
									</logic:notEqual>
									<logic:equal name="ppbdvw" property="checkrecord" value="<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_YES %>">
										<select name="record" >
											<option value="0">处理记录不必填</option>
											<option value="1" selected="selected">处理记录必填</option>
										</select>									
									</logic:equal>	
									</logic:notEqual>		
									<html:text property="acturl" size="15" value="${ppbdvw.acturl}" />							
									<logic:equal name="psd" property="psdtype" value="0">
										<logic:equal name="psd" property="psdmode" value="1">
											&nbsp;&nbsp;&nbsp;&nbsp;
											<!-- 不可跃迁的按钮不显示同角色多人处理规则信息 -->
											<logic:equal name="ppbdvw" property="pbdflag" value="<%=IGPRDCONSTANTS.BUTTON_PBDFLAG_1 %>">
											<select name="selectAuth" style="display:none">
												<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ANY %>">任意一人处理</option>
												<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ALL %>">全员处理</option>
											</select>
											</logic:equal>
											<!-- 可跃迁的按钮需要显示同角色多人处理规则信息 -->
											<logic:notEqual name="ppbdvw" property="pbdflag" value="<%=IGPRDCONSTANTS.BUTTON_PBDFLAG_1 %>">
											<select name="selectAuth">
												<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ANY %>">任意一人处理</option>
												<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ALL %>">全员处理</option>
											</select>
											</logic:notEqual>
										</logic:equal>
									</logic:equal>
									<br/>
								</logic:empty>
								<logic:notEmpty name="ppbdvw" property="ppbdid">
									<input type="checkbox" name="selectButtons"  value="${ppbdvw.pbdid}" checked="checked" onclick="selectButtonsClick(this)" />
									<html:text property="ppbdname" size="10" value="${ppbdvw.ppbdname}" />
									提示信息：
									<html:text property="ppbddesc" size="10" value="${ppbdvw.ppbddesc}" />
									<logic:empty name="ppbdvw" property="checkrequired">
										<logic:notEqual name="ppbdvw" property="pbdflag" value="<%=IGPRDCONSTANTS.BUTTON_PBDFLAG_1 %>">
											<select name="required">
												<option value="0">不校验必填项</option>
												<option value="1" selected="selected">校验必填项</option>
											</select>
										</logic:notEqual>
										<logic:equal name="ppbdvw" property="pbdflag" value="<%=IGPRDCONSTANTS.BUTTON_PBDFLAG_1 %>">
										<logic:equal name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">
											<select name="required" style="visibility:hidden;">
												<option value="0" selected="selected">不校验必填项</option>
												<option value="1">校验必填项</option>
											</select>												
										</logic:equal>
										<logic:notEqual name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">
											<select name="required">
												<option value="0" selected="selected">不校验必填项</option>
												<option value="1">校验必填项</option>
											</select>											
										</logic:notEqual>
										</logic:equal>
									</logic:empty>
									<logic:notEmpty name="ppbdvw" property="checkrequired">
									<logic:notEqual name="ppbdvw" property="checkrequired" value="<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES %>" >
										<select name="required" >
											<option value="0" selected="selected">不校验必填项</option>
											<option value="1">校验必填项</option>
										</select>
									</logic:notEqual>
									<logic:equal name="ppbdvw" property="checkrequired" value="<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES %>">
										<select name="required" >
											<option value="0">不校验必填项</option>
											<option value="1" selected="selected">校验必填项</option>
										</select>									
									</logic:equal>	
									</logic:notEmpty>	
									<logic:equal name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">
										<select name="record" style="visibility: hidden;">
											<option value="0" >处理记录不必填</option>
											<option value="1" selected="selected">处理记录必填</option>
										</select>											
									</logic:equal>
									<logic:notEqual name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">																	
									<logic:notEqual name="ppbdvw" property="checkrecord" value="<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_YES %>">
										<select name="record" >
											<option value="0" selected="selected">处理记录不必填</option>
											<option value="1">处理记录必填</option>
										</select>										
									</logic:notEqual>
									<logic:equal name="ppbdvw" property="checkrecord" value="<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_YES %>">
										<select name="record" >
											<option value="0">处理记录不必填</option>
											<option value="1" selected="selected">处理记录必填</option>
										</select>									
									</logic:equal>	
									</logic:notEqual>
									<html:text property="acturl" size="15" value="${ppbdvw.acturl}" />								
									<logic:equal name="psd" property="psdtype" value="0">
										<logic:equal name="psd" property="psdmode" value="1">
										&nbsp;&nbsp;&nbsp;&nbsp;
										<!-- 不可跃迁的按钮不显示同角色多人处理规则信息 -->
										<logic:equal name="ppbdvw" property="pbdflag" value="<%=IGPRDCONSTANTS.BUTTON_PBDFLAG_1 %>">
											<select name="selectAuth" style="display:none">
												<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ANY %>" selected="selected">任意一人处理</option>
												<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ALL %>">全员处理</option>
											</select>
										</logic:equal>
										<!-- 可跃迁的按钮需要显示同角色多人处理规则信息 -->
										<logic:notEqual name="ppbdvw" property="pbdflag" value="<%=IGPRDCONSTANTS.BUTTON_PBDFLAG_1 %>">
											<logic:equal name="ppbdvw" property="ppbdauth" value="<%=IGPRDCONSTANTS.UserCommitInRole_ANY %>">
												<select name="selectAuth">
													<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ANY %>" selected="selected">任意一人处理</option>
													<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ALL %>">全员处理</option>
												</select>
											</logic:equal>
											<logic:equal name="ppbdvw" property="ppbdauth" value="<%=IGPRDCONSTANTS.UserCommitInRole_ALL %>">
												<select name="selectAuth">
													<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ANY %>">任意一人处理</option>
													<option value="<%=IGPRDCONSTANTS.UserCommitInRole_ALL %>" selected="selected">全员处理</option>
												</select>
											</logic:equal>
										</logic:notEqual>
										</logic:equal>
									</logic:equal>
									<br/>
								</logic:notEmpty>
								</logic:notEqual>
								</logic:notEqual>
							</logic:iterate>						
						</logic:present>
					</logic:notEqual>
					</c:if>
					<c:if test="${IGPRD01081VO.processStatusDef.psdtype == '2'}">
						<logic:present name="IGPRD01081VO" property="processParticipantButtonDefVWInfoList">
							<logic:iterate id="ppbdvw" name="IGPRD01081VO" property="processParticipantButtonDefVWInfoList">
								<logic:equal name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_SUBMIT %>">
									<span style="width:70px; display:block; float:left; padding-top:8px;">${ppbdvw.pbdname}</span>
									<html:hidden property="ppbdid" value="${ppbdvw.ppbdid}"/>
									<html:hidden property="pbdid" value=""/>
									<logic:empty name="ppbdvw" property="ppbdid">
										<input type="checkbox" name="selectButtons" value="${ppbdvw.pbdid}" onclick="selectButtonsClick(this)"/>
										<html:text property="ppbdname" size="10" value="${ppbdvw.pbdname}" />
										提示信息：
										<html:text property="ppbddesc" size="10" value="${ppbdvw.pbdname}" />
										<html:hidden property="ppbdauth" value="0"/>
										<html:hidden property="checkrequired" value="0"/>
										<html:hidden property="checkrecord" value="0"/>										
										<br/>
									</logic:empty>
									<logic:notEmpty name="ppbdvw" property="ppbdid">
										<input type="checkbox" name="selectButtons"  value="${ppbdvw.pbdid}" checked="checked" onclick="selectButtonsClick(this)"/>
										<html:text property="ppbdname" size="10" value="${ppbdvw.ppbdname}" />
										提示信息：
										<html:text property="ppbddesc" size="10" value="${ppbdvw.ppbddesc}" />
										<html:hidden property="ppbdauth" value="0"/>
										<html:hidden property="checkrequired" value="0"/>
										<html:hidden property="checkrecord" value="0"/>										
										<br/>
									</logic:notEmpty>
								</logic:equal>
							</logic:iterate>
							<logic:iterate id="ppbdvw" name="IGPRD01081VO" property="processParticipantButtonDefVWInfoList">
								<logic:equal name="ppbdvw" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">
									<span style="width:70px; display:block; float:left; padding-top:8px;">${ppbdvw.pbdname}</span>
									<html:hidden property="ppbdid" value="${ppbdvw.ppbdid}"/>
									<html:hidden property="pbdid" value=""/>
									<html:hidden property="ppbdauth" value="0"/>
									<html:hidden property="checkrequired" value="0"/>
									<html:hidden property="checkrecord" value="0"/>									
									<logic:empty name="ppbdvw" property="ppbdid">
										<input type="checkbox" name="selectButtons" value="${ppbdvw.pbdid}"/>
										<html:text property="ppbdname" size="10" value="${ppbdvw.pbdname}" />
										提示信息：
										<html:text property="ppbddesc" size="10" value="${ppbdvw.pbdname}" />
										<br/>
									</logic:empty>
									<logic:notEmpty name="ppbdvw" property="ppbdid">
										<input type="checkbox" name="selectButtons"  value="${ppbdvw.pbdid}" checked="checked"/>
										<html:text property="ppbdname" size="10" value="${ppbdvw.ppbdname}" />
										提示信息：
										<html:text property="ppbddesc" size="10" value="${ppbdvw.ppbddesc}" />
										<br/>
									</logic:notEmpty>
								</logic:equal>
							</logic:iterate>						
						</logic:present>
					</c:if>
					</td>
				</tr>
				
				</logic:present>
			</logic:present>
	</table>
	</div>




<div id="processDefinitionDiv" style="width:98%;margin:5px auto 10px;display:none">
    <table class="table_style13" align="left" id="table">
            <tr>
                <th width="30%">流程类型名称</th>
                <th align="left">是否可发起</th>
            </tr>
            
            <logic:present name="IGPRD01081VO" property="lst_processDefinitionInfo">
                <logic:iterate id="bean" name="IGPRD01081VO" property="lst_processDefinitionInfo" indexId="index">
                        <tr class="<ig:rowcss index="${index}"/>">
                          <td width="30%">
                              <span>${bean.pdname}</span>
                          </td>
                          <td align="left">
                            <logic:present name="bean" property="psprpid">
                              <input type="checkbox" name="selectProcessDefinitionButtons" value="${bean.pdid}" checked="checked"/>
                            </logic:present>
                            <logic:notPresent name="bean" property="psprpid">
                              <input type="checkbox" name="selectProcessDefinitionButtons" value="${bean.pdid}"/>
                            </logic:notPresent>
                            <html:hidden property="relevantPdid" value=""/>
                            <html:hidden property="psprpid" name="bean"/>
                          </td>
                        </tr>
                </logic:iterate>
            </logic:present>
    </table>
    </div>
    
    
	<div id="results_list">
	<table class="table_style13" align="left" id="table">
			<tr>
				<th width="30%">表单名称</th>
				<th width="50%">权限</th>
				<th width="20%">必填</th>
			</tr>
			<logic:present name="IGPRD01081VO" property="lst_processInfoParticipantDefVW">
				<logic:iterate id="bean" name="IGPRD01081VO" property="lst_processInfoParticipantDefVW" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>" width="30%">
						<td>
							${bean.pidlabel}
						</td>
						<td  width="50%">
							<logic:equal name="bean" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_DEFAULT %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_DEFAULT %>" checked="checked" onclick="showDiv(this,${index})"/><span>缺省</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE %>" onclick="showDiv(this,${index})"/><span>不可见</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>" onclick="showDiv(this,${index})"/><span>只读</span>
       						    <input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>" onclick="showDiv(this,${index})"/><span>可写</span>
       						    <logic:equal  name="bean" property="pidmode" value="<%=IGPRDCONSTANTS.PIDMODE_PRIVATE %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL %>" onclick="showDiv(this,${index})"/><span>全部可见</span>
								</logic:equal>
							</logic:equal>
							<logic:equal name="bean" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_DEFAULT %>"  onclick="showDiv(this,${index})"/><span>缺省</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE %>" checked="checked" onclick="showDiv(this,${index})"/><span>不可见</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>" onclick="showDiv(this,${index})"/><span>只读</span>
       						    <input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>" onclick="showDiv(this,${index})"/><span>可写</span>
       						    <logic:equal  name="bean" property="pidmode" value="<%=IGPRDCONSTANTS.PIDMODE_PRIVATE %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL %>" onclick="showDiv(this,${index})"/><span>全部可见</span>
								</logic:equal>
							</logic:equal>
							<logic:equal name="bean" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_DEFAULT %>"  onclick="showDiv(this,${index})"/><span>缺省</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE %>"  onclick="showDiv(this,${index})"/><span>不可见</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>" checked="checked" onclick="showDiv(this,${index})"/><span>只读</span>
       						    <input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>" onclick="showDiv(this,${index})"/><span>可写</span>
       						    <logic:equal  name="bean" property="pidmode" value="<%=IGPRDCONSTANTS.PIDMODE_PRIVATE %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL %>" onclick="showDiv(this,${index})"/><span>全部可见</span>
								</logic:equal>
							</logic:equal>
							<logic:equal name="bean" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_DEFAULT %>"  onclick="showDiv(this,${index})"/><span>缺省</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE %>" onclick="showDiv(this,${index})" /><span>不可见</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>" onclick="showDiv(this,${index})"/><span>只读</span>
       						    <input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>" checked="checked" onclick="showDiv(this,${index})"/><span>可写</span>
       						    <logic:equal  name="bean" property="pidmode" value="<%=IGPRDCONSTANTS.PIDMODE_PRIVATE %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL %>" onclick="showDiv(this,${index})"/><span>全部可见</span>
								</logic:equal>
							</logic:equal>
							<logic:equal name="bean" property="pidaccess" value="<%=IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_DEFAULT %>"  onclick="showDiv(this,${index})"/><span>缺省</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE %>"  onclick="showDiv(this,${index})"/><span>不可见</span>
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>"  onclick="showDiv(this,${index})"/><span>只读</span>
       						    <input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>" onclick="showDiv(this,${index})"/><span>可写</span>
       						    <logic:equal  name="bean" property="pidmode" value="<%=IGPRDCONSTANTS.PIDMODE_PRIVATE %>">
								<input name="pidaccess${index}" type="radio" value="<%=IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL %>" checked="checked" onclick="showDiv(this,${index})"/><span>全部可见</span>
								</logic:equal>
							</logic:equal>
							<input name="pipdids" type="hidden" value="${bean.pipdid}" />
							<input name="pidids" type="hidden" value="${bean.pidid}" />
							<input name="types" type="hidden" value="${bean.type}" />
						</td>
						<td>
						<div id="showRadio${index}">
							<logic:equal name="bean" property="pidrequired" value="<%=IGPRDCONSTANTS.PID_REQUIRED_NO %>">
								<input name="pidrequired${index}" type="radio" value="<%=IGPRDCONSTANTS.PID_REQUIRED_NO %>"  checked="checked"/><span>否</span>
								<input name="pidrequired${index}" type="radio" value="<%=IGPRDCONSTANTS.PID_REQUIRED_YES %>" /><span>是</span>
							</logic:equal>
							<logic:equal name="bean" property="pidrequired" value="<%=IGPRDCONSTANTS.PID_REQUIRED_YES %>">
								<input name="pidrequired${index}" type="radio" value="<%=IGPRDCONSTANTS.PID_REQUIRED_NO %>"  /><span>否</span>
								<input name="pidrequired${index}" type="radio" value="<%=IGPRDCONSTANTS.PID_REQUIRED_YES %>" checked="checked"/><span>是</span>
							</logic:equal>
						</div>
						<div id="showDefault${index}" style="display:none">
							<input name="pidrequired${index}" type="radio" value="2"  disabled="disabled"/><span>否</span>
							<input name="pidrequired${index}" type="radio" value="3"  disabled="disabled"/><span>是</span>
						</div>
							
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<html:hidden property="psdid" styleId="psdid" value="${IGPRD0108Form.psdid}"/>
	<html:hidden property="pdid" styleId="pdid" value="${IGPRD0108Form.pdid}"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.vo.IGCOM03041VO"%>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG677Info"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.ArrayList"%>
<%
	IGCOM03041VO igcom03041VO = (IGCOM03041VO)request.getAttribute("igcom03041VO");
	List<IG677Info> processRecordInfoForMeList = igcom03041VO.getProcessRecordInfoForMeList();
	List<IG677Info> processRecordInfoForGroupList = igcom03041VO.getProcessRecordInfoForGroupList();
	List<IG677Info> processRecordInfoForWaList = igcom03041VO.getProcessRecordInfoForWAList();
	
	Map<String,String> varList = igcom03041VO.getVarList();
	Map<String,String> varAllList = igcom03041VO.getVarAllList();
	Map<String,String> urlMap = igcom03041VO.getUrlMap();
	Map<String,String> allurlMap = igcom03041VO.getAllurlMap();
	
	int num = 0;//我的工作已显示的条数
	int groupnum = 0;//相关工作已显示的条数
	String contextPath = request.getContextPath();
	String page_width = null;
	if(null!=request.getAttribute("page_width")){
		page_width = request.getAttribute("page_width").toString();
	}
	
	String screen=(request.getParameter("screen_width")==null?"1280":request.getParameter("screen_width"));
	if(page_width!=null){
		screen = page_width;
	}
	int screen_width=Integer.parseInt(screen);
	String processAdminRole = (String)request.getAttribute("isProcessAdminRole");
	boolean isProcessAdminRole = (processAdminRole == null?false:true);
	//boolean isProcessAdminRole = (processAdminRole == null?true:true);
%>
<html:html>
<bean:define id="id" value="IGPOR0102" toScope="request" />
<bean:define id="title" toScope="request" >
<bean:message bundle="comResources" key="ietitle.IGPOR0102"/>
</bean:define>
<jsp:include page="/include/header1.jsp" />
<script src="<html:rewrite forward='FusionCharts.js'/>"></script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css" />
<link type="text/css" href="css/portal.css" rel="stylesheet" />
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>

<script type="text/javascript">
function showGroupList(index){
	document.getElementById('group' + index).style.display='';
	document.getElementById('groupAsc' + index).style.display='none';
}
function showGroupListAsc(index){
	document.getElementById('group' + index).style.display='none';
	document.getElementById('groupAsc' + index).style.display='';
}
function searchprocessJC(prid,jc){
	if(prid!="" && prid !=null){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'prid='+ prid + '&type=searchprocessJC',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result!=null && result!=""){
					$(jc).title = result;
				}
		     }
			});
	}
}

function searchprocessOP(prid,op){
	if(prid!="" && prid !=null){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'prid='+ prid + '&type=searchprocessOP',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result!=null && result!=""){
					$(op).title = result;
				}
		     }
			});
	}
}
function setTabPanel(){
	var temp = document.getElementById("srname").value;
	if(temp!=null && temp!=""){
		TabbedPanels1.showPanel(temp);	
	}
}
function setSrname(srnameValue){	
	window.location = "IGPOR0102.do?srname="+srnameValue;
}

function doLookOpenTab(url,urlparent,name){
	var width = "1100";
	var height= "600";
	var iTop = (window.screen.availHeight-30-width)/2;       //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-height)/2;           //获得窗口的水平位置;
	url=url.replace(new RegExp('.do'),"_SOC.do");
	var obj=window.open(url, "_blank", 'width='+ width + ',height=' + height + ',scrollbars=yes,resizable=yes,status=yes,top='+iTop+',left='+iLeft+',').focus();
	//window.location = urlparent+'?srname='+name;
	//刷新父窗口的子窗口
	window.parent.resetPortal0103();
}
</script>
<style>
 html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	background-color: #FFFFFF;
	text-transform:capitalize;
 }
 #maincontent {
	min-height: 100%;
	_height: 100%;
	position: relative;
	min-width: 1002px;
	background-image: none;
 }
</style>
<body onload="setTabPanel();">
<div id="maincontent">
<div id="portal_main">
<div id="main_left">
<div id="self" style="margin-left:2px;"><logic:present name="IGCOM04033VO" property="voList">
	<html:hidden name="form" property="srname" />
	<div id="TabbedPanels1" class="TabbedPanels1" style="">
	<ul class="TabbedPanelsTabGroup">
		<logic:iterate id="bean" name="IGCOM04033VO" property="voList" indexId="number">
			<li class="TabbedPanelsTab" id="${number}" onclick="setSrname(${number})">${bean.name}</li>
		</logic:iterate>
	</ul>
	<div class="TabbedPanelsContentGroup"
		style="height: 488px; overflow-x: hidden; overflow-y: auto;"><logic:present
		name="IGCOM04033VO" property="voList">
		<logic:iterate id="bean" name="IGCOM04033VO" property="voList"
			indexId="number">
			<div class="TabbedPanelsContent">
			<div id="group${number}">
			<table width="642" border="0" cellspacing="0" cellpadding="0" style="margin-top: -6px;">
				<tr align="left">
					<th width="20" valign="bottom"></th>
					<th width="80" height="26" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.num"/></th>
					<th width="120" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.prtitle"/></th>
					<th width="70" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.prtype"/></th>
					<th width="90" valign="bottom"><a href="javascript:showGroupListAsc(${number});"><bean:message bundle="comResources" key="title.IGPOR0102.propentime"/><img src="images/timeup.gif" border="0"/></a></th>
					<th width="100" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.proendtime"/></th>
					<th width="50" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.ppusername"/></th>
					<th width="70" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.prstatus"/></th>
					<% 
						if(isProcessAdminRole){
							%>	
								<th width="60" valign="bottom" align="center"><bean:message bundle="comResources" key="title.IGPOR0102.facttime"/></th>
							<%						
						}
					%>
				</tr>
				<logic:iterate id="processRecordInfo" name="bean" indexId="index" property="processRecordInfoList" type="com.deliverik.framework.workflow.prr.model.IG677Info">
					<tr class="my_work" onmouseover="mouseOver(this, 'my_work');" 
						onmouseout="mouseOut(this,'my_work');"
						onclick="doLookOpenTab('<%=urlMap.get(String.valueOf(processRecordInfo.getPrid()))+processRecordInfo.getPrid() %>','IGPOR0102.do','${number}');">
						<td align="left">
							<%
								String prassetname = processRecordInfo.getPrassetname();
								if(prassetname!=null&& prassetname.split(":").length==2)
								{
									String isShow=prassetname.split(":")[1];
									if("1".equals(isShow))
									{
										%>
											<img src="images/full-time.gif" width="16" height="16" border="0" alt='<bean:message bundle="comResources" key="img.IGPOR0102.time.alt"/>' />
										<%
									}
								}
							%>
						</td>
						<td><%=String.valueOf(processRecordInfo.getPrserialnum())%></td>
						<td>
						<%
							String prtitle = processRecordInfo.getPrtitle();
							String showText = prtitle;
							if(prtitle.length() > 9){
								showText = showText.substring(0,8) + "...";
							}%>
						<span title="<%=prtitle %>"><%=showText %></span></td>
						<%
				    		String prpdname = processRecordInfo.getPrpdname();
				    		String showText1 = prpdname;
				    		if(prpdname.length() > 10){
				    			showText1 = showText1.substring(0,9) + "...";
				    		}
						%>
						<td style="text-align: left"><span title="<%=prpdname %>"><%=showText1 %></span></td>
						<td><%=processRecordInfo.getPropentime().substring(5)%></td>
						<%
				    		String rolename = processRecordInfo.getPprolename();
				    		if(rolename.length() > 5){
				    			rolename = rolename.substring(0,4) + "...";
				    		}
    					%>
						<td onmouseover="searchprocessJC('<%=processRecordInfo.getPrid()%>','jc3${index}');"
							id="jc3${index}"><%=varList.get(processRecordInfo.getPrid().toString())%>
						</td>

						<logic:equal name="processRecordInfo" property="ppusername" value="">
							<td>&nbsp;</td>
						</logic:equal>
						<logic:notEqual name="processRecordInfo" property="ppusername" value="">
							<td onmouseover="searchprocessOP('<%=processRecordInfo.getPrid()%>','op3${index}');"
								id="op3${index}"><bean:write name="processRecordInfo"
								property="ppusername" /></td>
						</logic:notEqual>
						<td>
						<%if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.INCIDENT_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.CHANGE_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.PROBLEM_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.DEPLOYMENT_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.SERVICE_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else {%> <ig:codeValue
							ccid="<%=processRecordInfo.getPrtype() %>"
							cid="<%=processRecordInfo.getPrstatus() %>" /> <%} %>
						</td>
						<% 
						if(isProcessAdminRole){
							%>	
								<td align="center">${processRecordInfo.prfacttime}</td>
							<%						
							}
						%>
					</tr>
					<tr>
					<% 
						if(isProcessAdminRole){
							%>	
							<td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
							<%						
						}else{
							%>	
							<td colspan="8"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
							<%		
						}
					%>
					</tr>
				</logic:iterate>
			</table>
			</div>

			<div id="groupAsc${number}" style="display: none">
			
			<table width="642" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: -6px;">
				<tr align="left">
					<th width="20" valign="bottom"></th>
					<th width="80" height="26" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.num"/></th>
					<th width="120" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.prtitle"/></th>
					<th width="70" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.prtype"/></th>
					<th width="90" valign="bottom"><a href="javascript:showGroupList(${number});"><bean:message bundle="comResources" key="title.IGPOR0102.propentime"/><img src="images/timedown.gif" border="0"/></a></th>
					<th width="100" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.proendtime"/></th>
					<th width="50" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.ppusername"/></th>
					<th width="70" valign="bottom"><bean:message bundle="comResources" key="title.IGPOR0102.prstatus"/></th>
					<% 
						if(isProcessAdminRole){
							%>	
								<th width="60" valign="bottom" align="center"><bean:message bundle="comResources" key="title.IGPOR0102.facttime"/></th>
							<%						
						}
					%>
				</tr>
				<logic:iterate id="processRecordInfo" name="bean" indexId="index" property="processRecordInfoListAsc" type="com.deliverik.framework.workflow.prr.model.IG677Info">
					<tr class="my_work" onmouseover="mouseOver(this, 'my_work');" onmouseout="mouseOut(this, 'my_work');" onclick="doLookOpenTab('<%=urlMap.get(String.valueOf(processRecordInfo.getPrid()))+processRecordInfo.getPrid() %>','IGPOR0102.do','${number}');">
						<td align="left">
							<%
								String prassetname = processRecordInfo.getPrassetname();
								if(prassetname!=null&& prassetname.split(":").length==2)
								{
									String isShow=prassetname.split(":")[1];
									if("1".equals(isShow))
									{
										%>
											<img src="images/full-time.gif" width="16" height="16" border="0" alt='<bean:message bundle="comResources" key="img.IGPOR0102.time.alt"/>' />
										<%
									}
								}
							%>
						</td>
						<td><%=String.valueOf(processRecordInfo.getPrserialnum())%></td>
						<td>
						<%
							String prtitle = processRecordInfo.getPrtitle();
							String showText = prtitle;
							if(prtitle.length() > 9){
								showText = showText.substring(0,8) + "...";
							}
						 %><span title="<%=prtitle %>"><%=showText%></span></td>
						<%
				    		String prpdname = processRecordInfo.getPrpdname();
				    		String showText1 = prpdname;
				    		if(prpdname.length() > 10){
				    			showText1 = showText1.substring(0,9) + "...";
				    		}
					    %>
						<td style="text-align: left"><span title="<%=prpdname %>"><%=showText1 %></span></td>
						<td><%=processRecordInfo.getPropentime().substring(5)%></td>
						<%
				    		String rolename = processRecordInfo.getPprolename();
				    		if(rolename.length() > 5){
				    			rolename = rolename.substring(0,4) + "...";
				    		}
					    %>
						<td onmouseover="searchprocessJC('<%=processRecordInfo.getPrid()%>','jc2${index}');" id="jc2${index}"><%=varList.get(processRecordInfo.getPrid().toString())%></td>
						<logic:equal name="processRecordInfo" property="ppusername" value="">
							<td>&nbsp;</td>
						</logic:equal>
						<logic:notEqual name="processRecordInfo" property="ppusername" value="">
							<td onmouseover="searchprocessOP('<%=processRecordInfo.getPrid()%>','op2${index}');" id="op2${index}"><bean:write name="processRecordInfo" property="ppusername" /></td>
						</logic:notEqual>
						<td>
						<%if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.INCIDENT_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.CHANGE_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.PROBLEM_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.DEPLOYMENT_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else if(IGPROCESSType.SERVICE_PRTYPE_D.equals(processRecordInfo.getPrtype())){ %>
						<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> <%} else {%> <ig:codeValue
							ccid="<%=processRecordInfo.getPrtype() %>"
							cid="<%=processRecordInfo.getPrstatus() %>" /> <%} %>
						</td>
						<% 
						if(isProcessAdminRole){
							%>	
								<td align="center">${processRecordInfo.prfacttime}</td>
							<%						
							}
						%>
					</tr>
					<tr>
						<% 
						if(isProcessAdminRole){
							%>	
							<td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
							<%						
						}else{
							%>	
							<td colspan="8"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
							<%		
						}
						%>
					</tr>
				</logic:iterate>
			</table>
			</div>
			</div>
		</logic:iterate>
	</logic:present></div>
	</div>
	<script type="text/javascript">
		var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	//-->
	</script>
</logic:present></div>
</div>
</div>
</div>
</body>
</html:html>
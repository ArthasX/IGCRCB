<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.vo.IGCOM03041VO" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG677Info" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG933Info" %>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<%@ page import="java.util.*"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%
	ArrayList noticeList = null;	
	boolean noticeFlag = false;
	Integer showYear = (Integer) request.getAttribute("year");
	Integer showMonth = (Integer) request.getAttribute("month");
	IGCOM03041VO igcom03041VO = (IGCOM03041VO)request.getAttribute("igcom03041VO");
	List<IG677Info> processRecordInfoForMeList = igcom03041VO.getProcessRecordInfoForMeList();
	List<IG677Info> processRecordInfoForGroupList = igcom03041VO.getProcessRecordInfoForGroupList();
	
	List<IG933Info> serviceFormInfoForMeList = igcom03041VO.getServiceFormInfoForMeList();
	List<IG933Info> serviceFormInfoForMeListAsc = igcom03041VO.getServiceFormInfoForMeListAsc();
	List<IG933Info> serviceFormInfoForGroupList = igcom03041VO.getServiceFormInfoForGroupList();
	List<IG933Info> serviceFormInfoForGroupListAsc = igcom03041VO.getServiceFormInfoForGroupListAsc();
	
	Map<String,String> urlMap = igcom03041VO.getUrlMap();
	
	if(null != igcom03041VO){
		noticeList = igcom03041VO.getNoticeList();
		noticeFlag = igcom03041VO.isShowflag();
	}
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
	
%>
<html:html>
<bean:define id="id" value="IGCOM0408" toScope="request" />
<bean:define id="title" value="首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script src="<html:rewrite forward='FusionCharts.js'/>"></script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css"/>
<link href="css/calendar.css" rel="stylesheet" type="text/css" />
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">

function goToNoticeInfoDetail(k){
	// alert("传递的值是"+k);
	var  nid=window.document.getElementsByName("nid")[k].value;
	//alert("nid值是"+nid);
	openSubWindow('/IGSYM0504.do?nid='+nid,"Notice","500","300");
	
}
function goToNoticeInfo(){
	openSubWindow('/IGSYM0504.do',"Notice","1000","600");
	
}
function back(year,month){
	var form = document.getElementById("submitForm");
	form.action="IGCOM0402_DW.do?forward=back&year=" + year + "&month=" + month;
	form.submit();
}

function next(year,month){
	var form = document.getElementById("submitForm");
	form.action="IGCOM0402_DW.do?forward=next&year=" + year + "&month=" + month;
	form.submit();
}

function goPage(year,month,date){
	var form = document.getElementById("submitForm");
	form.action="IGCOM0202.do?linkID=IGCOM0402_POP&actname=ACT02SVC&year=" + year + "&month=" + month + "&date=" + date + "&prtype=C_D";
	form.submit();
}

function showPersionList(){
	document.getElementById('persion').style.display='';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='none';
}
function showPersionListAsc(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='none';
}
function showGroupList(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='';
	document.getElementById('groupAsc').style.display='none';
}
function showGroupListAsc(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='';
}

function switchShowJob(str){
	if(str == 1){
		document.getElementById('persion').style.display='none';
		document.getElementById('persionAsc').style.display='';
		document.getElementById('group').style.display='none';
		document.getElementById('groupAsc').style.display='none';
		document.getElementById('showJobPersion').style.display='';
		document.getElementById('showJobGrpup').style.display='none';
	}else{
		document.getElementById('persion').style.display='none';
		document.getElementById('persionAsc').style.display='none';
		document.getElementById('group').style.display='none';
		document.getElementById('groupAsc').style.display='';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='';
	}
}

function showServiceFormForMe(){
	document.getElementById('serviceFormForMe').style.display='none';
	document.getElementById('serviceFormForMeAsc').style.display='';
	document.getElementById('serviceFormForGroup').style.display='none';
	document.getElementById('serviceFormForGroupAsc').style.display='none';
}
function showServiceFormForMeAsc(){
	document.getElementById('serviceFormForMe').style.display='';
	document.getElementById('serviceFormForMeAsc').style.display='none';
	document.getElementById('serviceFormForGroup').style.display='none';
	document.getElementById('serviceFormForGroupAsc').style.display='none';
}
function showServiceFormForGroup(){
	document.getElementById('serviceFormForMe').style.display='none';
	document.getElementById('serviceFormForMeAsc').style.display='none';
	document.getElementById('serviceFormForGroup').style.display='none';
	document.getElementById('serviceFormForGroupAsc').style.display='';
}
function showServiceFormForGroupAsc(){
	document.getElementById('serviceFormForMe').style.display='none';
	document.getElementById('serviceFormForMeAsc').style.display='none';
	document.getElementById('serviceFormForGroup').style.display='';
	document.getElementById('serviceFormForGroupAsc').style.display='none';
}

function switchShowServiceJob(flag){

	if(flag == 1){
		document.getElementById('serviceFormForMe').style.display='';
		document.getElementById('serviceFormForMeAsc').style.display='none';
		document.getElementById('serviceFormForGroup').style.display='none';
		document.getElementById('serviceFormForGroupAsc').style.display='none';
		document.getElementById('showSwchjobPersion').style.display='';
		document.getElementById('showSwchjobGroup').style.display='none';
	}else{
		document.getElementById('serviceFormForMe').style.display='none';
		document.getElementById('serviceFormForMeAsc').style.display='none';
		document.getElementById('serviceFormForGroup').style.display='';
		document.getElementById('serviceFormForGroupAsc').style.display='none';
		document.getElementById('showSwchjobPersion').style.display='none';
		document.getElementById('showSwchjobGroup').style.display='';
	}

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
function serviceFormLook(sfid){

	window.location = getAppRootUrl()  +"/IGCOM0202.do?linkID=IGSVC1004&actname=ACT02SVC0115&sfid="+sfid;

}
</script>


<body>

<div id="maincontent"><jsp:include page="/include/header2.jsp"/>
   <div id="portal_main">
    <div id="main_top_person">
        <div id="box8">
		<div id="showJobPersion" >
			<h1>处理中工作</h1><font style="font-family:Arial, Helvetica, sans-serif">个人&nbsp;|&nbsp;<a href="javascript:switchShowJob('2')" style="color: #006BC6">相关</a></font>
		</div>
		<div id="showJobGrpup" style="display:none">
			<h1>处理中工作</h1><font style="font-family:Arial, Helvetica, sans-serif"><a href="javascript:switchShowJob('1')" style="color: #006BC6">个人</a>&nbsp;|&nbsp;相关</font>
		</div>
    <div id="persionAsc">
	<table width="670" border="0" cellspacing="0" cellpadding="0">
		<tr align="left">
              <th width="40"></th>
              <th width="20"></th>
              <th width="80">编号</th>
              <th width="130">名称</th>
              <th width="110">类型</th>
              <th width="90"><a href="javascript:showPersionList();">开始时间<img src="images/timedown.gif" border="0"></a></th>
              <th width="70">处理角色</th>
              <th width="50">处理人</th>
              <th width="70">状态</th>
		</tr>
		<logic:iterate id="processRecordInfo" name="igcom03041VO" indexId="index" property="processRecordInfoForMeListAsc" type="com.deliverik.framework.workflow.prr.model.IG677Info">
					<tr class="my_work" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" height="20" align="left"
							 onclick="doLook('<%=urlMap.get(String.valueOf(processRecordInfo.getPrid()))+processRecordInfo.getPrid() %>');">
							<td>
				    			<ig:processWarningImg beginTime="<%=processRecordInfo.getPropentime()%>" processType="<%=processRecordInfo.getPrtype()%>" prStrategyVersion="<%=processRecordInfo.getPrStrategyVersion()%>" prPdid="<%=processRecordInfo.getPrpdid()%>" prUrgency="<%=processRecordInfo.getPrurgency()%>"/>				    		</td>
				    		<td>
    							<% 
								if("I".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("P".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("C".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("D".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("S".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WS".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WA".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WB".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WD".equals(processRecordInfo.getPrtype()) && StringUtils.isNotEmpty(processRecordInfo.getPrurgency())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("ID".equals(processRecordInfo.getPrtype()) && StringUtils.isNotEmpty(processRecordInfo.getPrurgency())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("PD".equals(processRecordInfo.getPrtype()) && StringUtils.isNotEmpty(processRecordInfo.getPrurgency())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("CD".equals(processRecordInfo.getPrtype()) && StringUtils.isNotEmpty(processRecordInfo.getPrurgency())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("DD".equals(processRecordInfo.getPrtype()) && StringUtils.isNotEmpty(processRecordInfo.getPrurgency())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("SD".equals(processRecordInfo.getPrtype()) && StringUtils.isNotEmpty(processRecordInfo.getPrurgency())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%> 						</td>
				    		<td><%=String.valueOf(processRecordInfo.getPrserialnum()) %></td>
				    		<td>
					    		<%
					    			String prtitle = processRecordInfo.getPrtitle();
					    			String showText = prtitle;
					    			if(prtitle.length() > 11){
					    				showText = showText.substring(0,10) + "...";
					    			}
					    		%><span title="<%=prtitle %>"><%=showText %></span>							</td>
				    			<%
						    		String prpdname = processRecordInfo.getPrpdname();
						    		String showText1 = prpdname;
						    		if(prpdname.length() > 8){
						    			showText1 = showText1.substring(0,7) + "...";
						    		}
				    			%>
				    		<td style="text-align: left"><img src="images/svc/<%=processRecordInfo.getPrtype().substring(0,1)%>.gif" border="0" width="39" height="12"/><span title="<%=prpdname %>"><%=showText1 %></span></td>
				    		<td><%=processRecordInfo.getPropentime()%></td>
				    		<td onmouseover="searchprocessJC('<%=processRecordInfo.getPrid()%>','jc${index}');" id="jc${index}"><%=processRecordInfo.getPprolename()%></td>
				    		<%if("P".equals(processRecordInfo.getPptype())
							){ %>
								<td><%=String.valueOf(processRecordInfo.getPpusername()) %></td>
							<%}else{ %> 
								<td><img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/></td>
							<%} %>
				    		<td>
				    			<%if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(processRecordInfo.getPrtype()) ||
									 IGPROCESSType.INCIDENT_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.PROBLEM_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.CHANGE_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.DEPLOYMENT_PRTYPE_D.equals(processRecordInfo.getPrtype())	   ||
									 IGPROCESSType.SERVICE_PRTYPE_D.equals(processRecordInfo.getPrtype())
								){ %>
									<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/>
								<%}else{ %> 
									<ig:codeValue
									ccid="<%=processRecordInfo.getPrtype() %>"
									cid="<%=processRecordInfo.getPrstatus() %>" /> <%} %>
				    		</td>
			  </tr>
               <tr>
                  <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
		     </tr>
		</logic:iterate>
              <tr>
                  <td colspan="9">
					<% if(processRecordInfoForMeList.size()>=10){%>
						<a href="IGCOM0202.do?linkID=IGSVC0101$actname=ACT02SVC0101"><img src="images/main_more.gif" border="0" class="more_img"/></a>
					<% }%>&nbsp;
                  </td>
		     </tr>
    </table>
    </div>

    <div id="persion" style="display:none">
	<table width="670" border="0" cellspacing="0" cellpadding="0">
		<tr align="left">
              <th width="40"></th>
              <th width="20"></th>
              <th width="80">编号</th>
              <th width="130">名称</th>
              <th width="110">类型</th>
              <th width="90"><a href="javascript:showPersionListAsc();">开始时间<img src="images/timeup.gif" border="0"></a></th>
              <th width="70">处理角色</th>
              <th width="50">处理人</th>
              <th width="70">状态</th>
		</tr>
		<logic:iterate id="processRecordInfo" name="igcom03041VO" indexId="index" property="processRecordInfoForMeList" type="com.deliverik.framework.workflow.prr.model.IG677Info">
					<tr class="my_work" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" height="20" align="left"
							 onclick="doLook('<%=urlMap.get(String.valueOf(processRecordInfo.getPrid()))+processRecordInfo.getPrid() %>');">
							<td>
				    			<ig:processWarningImg beginTime="<%=processRecordInfo.getPropentime()%>" processType="<%=processRecordInfo.getPrtype()%>" prStrategyVersion="<%=processRecordInfo.getPrStrategyVersion()%>" prPdid="<%=processRecordInfo.getPrpdid()%>" prUrgency="<%=processRecordInfo.getPrurgency()%>"/>
				    		</td>
				    		<td>
    							<% 
								if("I".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("P".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("C".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("D".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("S".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WS".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WA".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WB".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("ID".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("PD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("CD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("DD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("SD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
    						</td>
				    		<td><%=String.valueOf(processRecordInfo.getPrserialnum()) %></td>
				    		<td>
					    		<%
					    			String prtitle = processRecordInfo.getPrtitle();
					    			String showText = prtitle;
					    			if(prtitle.length() > 11){
					    				showText = showText.substring(0,10) + "...";
					    			}
					    		%><span title="<%=prtitle %>"><%=showText %></span>
							</td>
				    			<%
						    		String prpdname = processRecordInfo.getPrpdname();
						    		String showText1 = prpdname;
						    		if(prpdname.length() > 8){
						    			showText1 = showText1.substring(0,7) + "...";
						    		}
				    			%>
				    		<td style="text-align: left"><img src="images/svc/<%=processRecordInfo.getPrtype().substring(0,1)%>.gif" border="0" width="39" height="12"/><span title="<%=prpdname %>"><%=showText1 %></span></td>
				    		<td><%=processRecordInfo.getPropentime()%></td>
				    		<td onmouseover="searchprocessJC('<%=processRecordInfo.getPrid()%>','jc1${index}');" id="jc1${index}"><%=processRecordInfo.getPprolename()%></td>
				    		<%if("P".equals(processRecordInfo.getPptype())
							){ %>
								<td><%=String.valueOf(processRecordInfo.getPpusername()) %></td>
							<%}else{ %> 
								<td><img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/></td>
							<%} %>
				    		<td>
				    			<%if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(processRecordInfo.getPrtype()) ||
									 IGPROCESSType.INCIDENT_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.PROBLEM_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.CHANGE_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.DEPLOYMENT_PRTYPE_D.equals(processRecordInfo.getPrtype())	   ||
									 IGPROCESSType.SERVICE_PRTYPE_D.equals(processRecordInfo.getPrtype())
								){ %>
									<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/> 
								<%}else{ %> 
									<ig:codeValue
									ccid="<%=processRecordInfo.getPrtype() %>"
									cid="<%=processRecordInfo.getPrstatus() %>" /> <%} %>
				    		</td>
						</tr>
               <tr>
                  <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
		     </tr>
		</logic:iterate>
              <tr>
                  <td colspan="9">
					<% if(processRecordInfoForMeList.size()>=10){%>
						<a href="IGCOM0202.do?linkID=IGSVC0101$actname=ACT02SVC0101"><img src="images/main_more.gif" border="0" class="more_img"/></a>
					<% }%>&nbsp;
                  </td>
		     </tr>
    </table>
    </div>


   <div id="groupAsc" style="display:none">
	<table width="670" border="0" cellspacing="0" cellpadding="0">
		<tr align="left">
             <th width="40"></th>
             <th width="20"></th>
             <th width="80">编号</th>
             <th width="130">名称</th>
             <th width="110">类型</th>
             <th width="90"><a href="javascript:showGroupList();">开始时间<img src="images/timedown.gif" border="0"></a></th>
             <th width="70">处理角色</th>
             <th width="50">处理人</th>
             <th width="70">状态</th>
		</tr>
		<logic:iterate id="processRecordInfo" name="igcom03041VO" indexId="index" property="processRecordInfoForGroupListAsc" type="com.deliverik.framework.workflow.prr.model.IG677Info">
					<tr class="my_work" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" height="20" align="left"
							 onclick="doLook('<%=urlMap.get(String.valueOf(processRecordInfo.getPrid()))+processRecordInfo.getPrid() %>');">
							<td>
				    			<ig:processWarningImg beginTime="<%=processRecordInfo.getPropentime()%>" processType="<%=processRecordInfo.getPrtype()%>" prStrategyVersion="<%=processRecordInfo.getPrStrategyVersion()%>" prPdid="<%=processRecordInfo.getPrpdid()%>" prUrgency="<%=processRecordInfo.getPrurgency()%>"/>
				    		</td>
				    		<td>
    							<% 
								if("I".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("P".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("C".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("D".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("S".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WS".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WA".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WB".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("ID".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("PD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("CD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("DD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("SD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
    						</td>
				    		<td><%=String.valueOf(processRecordInfo.getPrserialnum()) %></td>
				    		<td>
					    		<%
					    			String prtitle = processRecordInfo.getPrtitle();
					    			String showText = prtitle;
					    			if(prtitle.length() > 11){
					    				showText = showText.substring(0,10) + "...";
					    			}
					    		%><span title="<%=prtitle %>"><%=showText %></span>
							</td>
				    			<%
						    		String prpdname = processRecordInfo.getPrpdname();
						    		String showText1 = prpdname;
						    		if(prpdname.length() > 8){
						    			showText1 = showText1.substring(0,7) + "...";
						    		}
				    			%>
				    		<td style="text-align: left"><img src="images/svc/<%=processRecordInfo.getPrtype().substring(0,1)%>.gif" border="0" width="39" height="12"/><span title="<%=prpdname %>"><%=showText1 %></span></td>
				    		<td><%=processRecordInfo.getPropentime()%></td>
				    		<td onmouseover="searchprocessJC('<%=processRecordInfo.getPrid()%>','jc2${index}');" id="jc2${index}"><%=processRecordInfo.getPprolename()%></td>
				    		<%if("P".equals(processRecordInfo.getPptype())
							){ %>
								<td><%=String.valueOf(processRecordInfo.getPpusername()) %></td>
							<%}else{ %> 
								<td><img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/></td>
							<%} %>
				    		<td>
				    			<%if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(processRecordInfo.getPrtype()) ||
									 IGPROCESSType.INCIDENT_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.PROBLEM_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.CHANGE_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.DEPLOYMENT_PRTYPE_D.equals(processRecordInfo.getPrtype())	   ||
									 IGPROCESSType.SERVICE_PRTYPE_D.equals(processRecordInfo.getPrtype())
								){ %>
									<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/>
								<%}else{ %> 
									<ig:codeValue
									ccid="<%=processRecordInfo.getPrtype() %>"
									cid="<%=processRecordInfo.getPrstatus() %>" /> <%} %>
				    		</td>
						</tr>
               <tr>
                  <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
		     </tr>
		</logic:iterate>
              <tr>
                  <td colspan="9">
					<% if(processRecordInfoForGroupList.size()>=10){%>
						<a href="IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102"><img src="images/main_more.gif" border="0" class="more_img"/></a>
					<% }%>&nbsp;
                  </td>
		     </tr>
    </table>
    </div>
    
   <div id="group" style="display:none">
	<table width="670" border="0" cellspacing="0" cellpadding="0">
		<tr align="left">
             <th width="40"></th>
             <th width="20"></th>
             <th width="80">编号</th>
             <th width="130">名称</th>
             <th width="110">类型</th>
             <th width="90"><a href="javascript:showGroupListAsc();">开始时间<img src="images/timeup.gif" border="0"></a></th>
             <th width="70">处理角色</th>
             <th width="50">处理人</th>
             <th width="70">状态</th>
		</tr>
		<logic:iterate id="processRecordInfo" name="igcom03041VO" indexId="index" property="processRecordInfoForGroupList" type="com.deliverik.framework.workflow.prr.model.IG677Info">
					<tr class="my_work" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" height="20" align="left"
							 onclick="doLook('<%=urlMap.get(String.valueOf(processRecordInfo.getPrid()))+processRecordInfo.getPrid() %>');">
							<td>
				    			<ig:processWarningImg beginTime="<%=processRecordInfo.getPropentime()%>" processType="<%=processRecordInfo.getPrtype()%>" prStrategyVersion="<%=processRecordInfo.getPrStrategyVersion()%>" prPdid="<%=processRecordInfo.getPrpdid()%>" prUrgency="<%=processRecordInfo.getPrurgency()%>"/>
				    		</td>
				    		<td>
    							<% 
								if("I".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("P".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("C".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("D".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("S".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WS".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WA".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WB".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid='<%=processRecordInfo.getPrtype() + "URGENCY_GRADE_CODE"%>' cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("WD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("ID".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("PD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("CD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("DD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
								<% 
								if("SD".equals(processRecordInfo.getPrtype())){
								%>
									<img src="images/<%=processRecordInfo.getPrurgency() %>.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="<%=processRecordInfo.getPrurgency() %>"/>" width="10" height="16" />
								<% 
								}
								%>
    						</td>
				    		<td><%=String.valueOf(processRecordInfo.getPrserialnum()) %></td>
				    		<td>
					    		<%
					    			String prtitle = processRecordInfo.getPrtitle();
					    			String showText = prtitle;
					    			if(prtitle.length() > 11){
					    				showText = showText.substring(0,10) + "...";
					    			}
					    		%><span title="<%=prtitle %>"><%=showText %></span>
							</td>
				    			<%
						    		String prpdname = processRecordInfo.getPrpdname();
						    		String showText1 = prpdname;
						    		if(prpdname.length() > 8){
						    			showText1 = showText1.substring(0,7) + "...";
						    		}
				    			%>
				    		<td style="text-align: left"><img src="images/svc/<%=processRecordInfo.getPrtype().substring(0,1)%>.gif" border="0" width="39" height="12"/><span title="<%=prpdname %>"><%=showText1 %></span></td>
				    		<td><%=processRecordInfo.getPropentime()%></td>
				    		<td onmouseover="searchprocessJC('<%=processRecordInfo.getPrid()%>','jc3${index}');" id="jc3${index}"><%=processRecordInfo.getPprolename()%></td>
				    		<%if("P".equals(processRecordInfo.getPptype())
							){ %>
								<td><%=String.valueOf(processRecordInfo.getPpusername()) %></td>
							<%}else{ %> 
								<td><img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/></td>
							<%} %>
				    		<td>
				    			<%if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(processRecordInfo.getPrtype()) ||
									 IGPROCESSType.INCIDENT_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.PROBLEM_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.CHANGE_PRTYPE_D.equals(processRecordInfo.getPrtype())		   ||
									 IGPROCESSType.DEPLOYMENT_PRTYPE_D.equals(processRecordInfo.getPrtype())	   ||
									 IGPROCESSType.SERVICE_PRTYPE_D.equals(processRecordInfo.getPrtype())
								){ %>
									<ig:processDefineTypeValue prid="<%=processRecordInfo.getPrid() %>"/>
								<%}else{ %> 
									<ig:codeValue
									ccid="<%=processRecordInfo.getPrtype() %>"
									cid="<%=processRecordInfo.getPrstatus() %>" /> <%} %>
				    		</td>
						</tr>
               <tr>
                  <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
		     </tr>
		</logic:iterate>
              <tr>
                  <td colspan="9">
					<% if(processRecordInfoForGroupList.size()>=10){%>
						<a href="IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102"><img src="images/main_more.gif" border="0" class="more_img"/></a>
					<% }%>&nbsp;
                  </td>
		     </tr>
    </table>
    </div>
 </div>
 
 
 
 
 
 
<div id="box9">
 <div id="showSwchjobPersion">
 	<h1>服务工单</h1><font style="font-family:Arial, Helvetica, sans-serif">个人&nbsp;|&nbsp;<a href="javascript:switchShowServiceJob('2')" style="color: #006BC6">全部</a></font>
</div>
<div id="showSwchjobGroup" style="display:none">
	<h1>服务工单</h1><font style="font-family:Arial, Helvetica, sans-serif"><a href="javascript:switchShowServiceJob('1')" style="color: #006BC6">个人</a>&nbsp;|&nbsp;全部</font>
</div>
    <div id="serviceFormForMe">
       <table width="94%" border="0" cellspacing="0" cellpadding="0" align="center">
         <tr align="center" valign="bottom" >
             <th width="65%" height="26">工单名称</th>
             <th width="30%"  height="26"><a href="javascript:showServiceFormForMe();">登记时间<img src="images/timedown.gif" border="0"></a></th>
          </tr>
		<logic:iterate id="bean" name="igcom03041VO" indexId="index" property="serviceFormInfoForMeList" type="com.deliverik.framework.workflow.prr.model.IG933Info">
			 <%
	    			String sftitle = bean.getSftitle();
	    			if(sftitle.length() > 14){
	    				sftitle = sftitle.substring(0,14) + "...";
	    			}
	    	%>
					<tr class="my_work" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" height="20" align="center"
							 onclick="serviceFormLook(${bean.sfid});" height="20">
						<td align="left" valign="bottom" ><logic:empty name="bean" property="sftitle">&nbsp;</logic:empty><%=sftitle%></td>
						<td valign="bottom" ><logic:empty name="bean" property="sfinstime">&nbsp;</logic:empty>${bean.sfinstime}</td>
					</tr>
                     <tr>
                       <td colspan="2"><img src="images/td_line_bg1.gif" border="0"/></td>
		             </tr>
		</logic:iterate>
        <tr>
           <td colspan="2">
           	<% if(serviceFormInfoForMeList.size()>=10){%>
				<a href="IGSVC1001.do?flag=1&sfstatus=0001"><img src="images/main_more.gif" border="0" class="more_img"/></a>
			<% }%>
           </td>
		</tr>
    </table>
    </div>

    
    <div id="serviceFormForMeAsc" style="display:none">
        <table width="94%" border="0" cellspacing="0" cellpadding="0" align="center">
         <tr align="center" valign="bottom" >
             <th width="65%" height="26">工单名称</th>
             <th width="30%"  height="26"><a href="javascript:showServiceFormForMeAsc();">登记时间<img src="images/timeup.gif" border="0"></a></th>
          </tr>
		<logic:iterate id="bean" name="igcom03041VO" indexId="index" property="serviceFormInfoForMeListAsc" type="com.deliverik.framework.workflow.prr.model.IG933Info">
			<%
	    			String sftitle = bean.getSftitle();
						if(sftitle.length() > 14){
							sftitle = sftitle.substring(0,14) + "...";
						}
	    	%>
					<tr class="my_work" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" height="20" align="center"
							 onclick="serviceFormLook(${bean.sfid});" height="20">
						<td align="left" valign="bottom" ><logic:empty name="bean" property="sftitle">&nbsp;</logic:empty><%=sftitle%></td>
						<td valign="bottom"><logic:empty name="bean" property="sfinstime">&nbsp;</logic:empty>${bean.sfinstime}</td>
					</tr>
                     <tr>
                       <td colspan="2"><img src="images/td_line_bg1.gif" border="0"/></td>
		             </tr>
		</logic:iterate>
		<tr>
           <td colspan="2">
           	<% if(serviceFormInfoForMeListAsc.size()>=10){%>
				<a href="IGCOM0202.do?linkID=IGSVC1001_SEARCH&atname=ACT02SVC0115&flag=1&sfstatus=0001"><img src="images/main_more.gif" border="0" class="more_img"/></a>
			<% }%>
           </td>
        </tr>
    </table>
    </div>
    
    <div id="serviceFormForGroup" style="display:none">
        <table width="94%" border="0" cellspacing="0" cellpadding="0" align="center">
         <tr align="center" valign="bottom" >
             <th width="65%" height="26">工单名称</th>
             <th width="30%"  height="26"><a href="javascript:showServiceFormForGroup();">登记时间<img src="images/timedown.gif" border="0"></a></th>
          </tr>
		<logic:iterate id="bean" name="igcom03041VO" indexId="index" property="serviceFormInfoForGroupList" type="com.deliverik.framework.workflow.prr.model.IG933Info">
			 <%
	    			String sftitle = bean.getSftitle();
					if(sftitle.length() > 14){
						sftitle = sftitle.substring(0,14) + "...";
					}
	    	%>
					<tr class="my_work" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" height="20" align="center"
							 onclick="serviceFormLook(${bean.sfid});" height="20">
						<td align="left" valign="bottom"><logic:empty name="bean" property="sftitle">&nbsp;</logic:empty><%=sftitle%></td>
						<td valign="bottom"><logic:empty name="bean" property="sfinstime">&nbsp;</logic:empty>${bean.sfinstime}</td>
					</tr>
                     <tr>
                       <td colspan="2"><img src="images/td_line_bg1.gif" border="0"/></td>
		             </tr>
		</logic:iterate>
		<tr>
           <td colspan="2">
           	<% if(serviceFormInfoForGroupList.size()>=10){%>
				<a href="IGCOM0202.do?linkID=IGSVC1001SEARCH&atname=ACT02SVC0115&flag=2&sfstatus=0001"><img src="images/main_more.gif" border="0" class="more_img"/></a>
			<% }%>
           </td>
        </tr>
    </table>
    </div>
    <div id="serviceFormForGroupAsc" style="display:none">
        <table width="94%" border="0" cellspacing="0" cellpadding="0" align="center">
         <tr align="center" valign="bottom" >
             <th width="65%" height="26">工单名称</th>
             <th width="30%"  height="26"><a href="javascript:showServiceFormForGroupAsc();">登记时间<img src="images/timeup.gif" border="0"></a></th>
          </tr>
		<logic:iterate id="bean" name="igcom03041VO" indexId="index" property="serviceFormInfoForGroupListAsc" type="com.deliverik.framework.workflow.prr.model.IG933Info">
			 <%
	    			String sftitle = bean.getSftitle();
					if(sftitle.length() > 14){
						sftitle = sftitle.substring(0,14) + "...";
					}
	    	%>
					<tr class="my_work" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'my_work');" height="20" align="center"
							 onclick="serviceFormLook(${bean.sfid});" height="20">
						<td align="left" valign="bottom" ><logic:empty name="bean" property="sftitle">&nbsp;</logic:empty><%=sftitle%></td>
						<td valign="bottom"><logic:empty name="bean" property="sfinstime">&nbsp;</logic:empty>${bean.sfinstime}</td>
					</tr>
                     <tr>
                       <td colspan="2"><img src="images/td_line_bg1.gif" border="0"/></td>
		             </tr>
		</logic:iterate>
		<tr>
           <td colspan="2">
           	<% if(serviceFormInfoForGroupListAsc.size()>=10){%>
				<a href="IGCOM0202.do?linkID=IGSVC1001SEARCH&atname=ACT02SVC0115&flag=2&sfstatus=0001"><img src="images/main_more.gif" border="0" class="more_img"/></a>
			<% }%>
           </td>
        </tr>
    </table>
    </div>

</div>
</div> 

<div id="main_middle_person">
<form id="submitForm" method="post">
    <div id="box3">
       <h1>变更计划</h1>
<%!String days[];%> <%
				days = new String[42];
				for (int i = 0; i < 42; i++) {
					days[i] = "";
				}
			%> <%
				GregorianCalendar currentDay = new GregorianCalendar();
				int today = currentDay.get(Calendar.DAY_OF_MONTH);
				int month = currentDay.get(Calendar.MONTH);
				int year = currentDay.get(Calendar.YEAR);
				
				
				
				int calendarYear = (showYear == null)?year:showYear;
				int calendarMonth = (showMonth == null)?month:showMonth;
			
				Calendar thisMonth = Calendar.getInstance();
				thisMonth.set(Calendar.MONTH, calendarMonth);
				thisMonth.set(Calendar.YEAR, calendarYear);
				thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
				thisMonth.set(Calendar.DAY_OF_MONTH, 1);
				
				
				int thistoday = thisMonth.get(Calendar.DAY_OF_MONTH);
				int thismonth = thisMonth.get(Calendar.MONTH);
				int thisyear = thisMonth.get(Calendar.YEAR);
				
				Calendar backCal = Calendar.getInstance();
				backCal.set(Calendar.MONTH, calendarMonth);
				backCal.set(Calendar.YEAR, calendarYear);
				backCal.setFirstDayOfWeek(Calendar.SUNDAY);
				backCal.set(Calendar.DAY_OF_MONTH, 1);
				
				Calendar nextCal = Calendar.getInstance();
				nextCal.set(Calendar.MONTH, calendarMonth);
				nextCal.set(Calendar.YEAR, calendarYear);
				nextCal.setFirstDayOfWeek(Calendar.SUNDAY);
				nextCal.set(Calendar.DAY_OF_MONTH, 1);
				
				backCal.set(Calendar.MONDAY,backCal.get(Calendar.MONDAY)-1);  
				nextCal.set(Calendar.MONDAY,backCal.get(Calendar.MONDAY)+1);  
				
				int backCalMaxDay = backCal.getActualMaximum(Calendar.DAY_OF_MONTH);
				int nextCalMaxDay = backCal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				
				int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
				int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

				int linkIndex = maxIndex+firstIndex;
				for(int i = 0; i < days.length-linkIndex; i++){
					days[(linkIndex)+i] = "<span class=\"gray\">"+String.valueOf(i+1)+"</span>";
				}
				
				for(int i = 0; i < firstIndex; i++){
					days[(firstIndex-1)-i] = "<span class=\"gray\">"+String.valueOf(backCalMaxDay-i)+"</span>";
				}
				
				for (int i = 0; i < maxIndex; i++) {
					days[firstIndex + i] = String.valueOf(i + 1);
				}
			%>
            <table width="244" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top: 10px;">
          <tr>
            <td>
				<table width="90" border="0" cellspacing="0" cellpadding="0"
					align="center">
					<tr>
						<td width="15"><a href="#"
							onclick="back(<%=calendarYear%>,<%=calendarMonth%>);"><img
							src="images/8.gif" alt="上月" border="0" /></a></td>
						<td width="60" align="center"><%=calendarYear%>年<%=calendarMonth + 1%>月</td>
						<td width="15"><a href="#"
							onclick="next(<%=calendarYear%>,<%=calendarMonth%>);"><img
							src="images/9.gif" alt="下月" border="0" /></a></td>
					</tr>
				</table>
           </td>
          </tr>
          <tr>
            <td>
                <table width="294" border="0" cellpadding="0" cellspacing="1" class="index_date" style="margin-top:5px;">
                  <tr>
                    <th>日</th>
                    <th>一</th>
                    <th>二</th>
                    <th>三</th>
                    <th>四</th>
                    <th>五</th>
                    <th>六</th>
                  </tr>

			<%
						for (int j = 0; j < 6; j++) {
					%>
			<tr>
				<%
							String todayYMD = year + "-" + month + "-" + today;

				

				
							for (int i = j * 7; i < (j + 1) * 7; i++) {
							String day = calendarYear + "/" + calendarMonth + "/" + (i - firstIndex + 1);
							String month_split="/";
							if((calendarMonth+1)<10){
								month_split="/0";
							}
							String day_split="/";
							if(((i - firstIndex + 1))<10){
								day_split="/0";
								
							
					} 
					String thistodayYMD= thisyear + "-" + thismonth + "-" + days[i];
					if(!thistodayYMD.equals(todayYMD)){
					%>
					
				<td bgcolor="#FFFFFF" <%if((days[i].length()<3) && (!"black".equals(((HashMap)request.getAttribute("dwmap")).get(days[i])))){ %>
					onclick="goPage('<%=calendarYear%>', '<%= (calendarMonth+1)%>', <%= (i - firstIndex + 1)%>)"
					style="cursor: hand" <%} %>>
				<% }else{%>
				<td bgcolor="#e3efff" <%if((days[i].length()<3) && (!"black".equals(((HashMap)request.getAttribute("dwmap")).get(days[i])))){ %>
					onclick="goPage('<%=calendarYear%>', '<%= (calendarMonth+1)%>', <%= (i - firstIndex + 1)%>)"
					style="cursor: hand" <%} %>>
					<%}%>
					
					
				<%if ("red".equals(((HashMap)request.getAttribute("dwmap")).get(days[i]))) {%>
				<span style="color: red"> <%}%> <%if ("blue".equals(((HashMap)request.getAttribute("dwmap")).get(days[i]))) {%>
				<span style="color: blue"> <%}%> <%if ("green".equals(((HashMap)request.getAttribute("dwmap")).get(days[i]))) {%>
				<span style="color: green"> <%}%> <%=days[i]%></span>&nbsp;</td>
				<%}%>
			</tr>
			<% } %>
              </table>  
            </td>
              </tr>
           </table>
</form>
         </div>

        <div id="box4">
         <h1>服务台</h1>
         <div class="all_service">
			<ig:menuAuth actname="ACT02SVC0101">
				<div class="service"><img src="images/2.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101">我的工作</html:link></span></div>
			</ig:menuAuth> <ig:menuAuth actname="ACT02SVC0102">
				<div class="service"><img src="images/a1.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102">相关工作</html:link></span></div>
			</ig:menuAuth> <ig:menuAuth actname="ACT02SVC0103">
				<div class="service"><img src="images/4.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0103&actname=ACT02SVC0103">我的发起</html:link></span></div>
			</ig:menuAuth> <ig:menuAuth actname="ACT02SVC0105">
				<div class="service"><img src="images/3.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0105&actname=ACT02SVC0105">工作监督</html:link></span></div>
			</ig:menuAuth> <ig:menuAuth actname="ACT02SVC0114">
				<div class="service"><img src="images/d1.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0110&actname=ACT02SVC0114">历史工作</html:link></span></div>
			</ig:menuAuth> <ig:menuAuth actname="ACT02SVC0113">
				<div class="service"><img src="images/c1.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGKGM0110&actname=ACT02SVC0113">知识查询</html:link></span></div>
			</ig:menuAuth> <ig:menuAuth actname="ACT02SVC0115">
				<div class="service"><img src="images/c1.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC1001&actname=ACT02SVC0115">工单查询</html:link></span></div>
			</ig:menuAuth> <ig:menuAuth actname="ACT02SVC0116">
				<div class="service"><img src="images/4.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC1002&actname=ACT02SVC0116">工单登记</html:link></span></div>
			</ig:menuAuth>
         </div>
        </div>
       <div id="box2">
       	<h1>通知</h1>
       		<%if(noticeList.size()>=5){ %>
				<a href='javascript:goToNoticeInfo()'><img src="images/main_more.gif" border="0" class="more_img"/></a>
			<%} %>
       	
             <ul>
			<%
           		if(noticeList.size()>0){
				for(int i=0,j=noticeList.size();i<j;i++){
					String info = (String)noticeList.get(i);
			%>
			<li><a href='javascript:goToNoticeInfoDetail(<%=i%>)'><%=info%></a></li>
			<%}}else{%>
			<li>目前没有通知！</li>
			<%}%>
             </ul>
        </div>
    </div>
  </div> 
</body>
</html:html>
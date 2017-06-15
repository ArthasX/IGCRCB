<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.soc.alarm.vo.IGALM05011VO"%>
<html:html>
<head>
<bean:define id="id" value="IGALM0501" toScope="request" />
<bean:define id="title" toScope="request">
	性能信息查询
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- header1 -->
<script type="text/javascript">
function checkForm(){
	var alertTime= '开始时间不能晚于结束时间！';
	if(!checkDateWithTimeShowForLE("get_StartTime","get_EndTime")){
		alert(alertTime);
		return false;
	}
	form.action = getAppRootUrl() + '/IGALM0501_SEARCH1.do';
	return true;
}

function clearAll(){
	
	$('get_StartTime').value='';
	$('get_EndTime').value='';
	$('ip').value='';
	$('servertype').value='';

}
WebCalendar.timeShow = true;//是否返回时间

//-->
</script>
</head>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGALM0501_SEARCH1">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation extname1="${urlable}"/>
	</p>
	</div>
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div class="conditions_border1">
			
				<div>
				&nbsp;&nbsp;开始时间：
				<html:text property="get_StartTime" size="14" readonly="true" />
			    <img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="showDate($('get_StartTime'))" border="0" />
				&nbsp;&nbsp;
				结束时间：<html:text property="get_EndTime" size="14" readonly="true" />
				<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="showDate($('get_EndTime'));" />
				&nbsp;&nbsp;
				设备IP：	<html:text property="ip" styleId="ip_like"
				errorStyleClass="inputError imeDisabled" size="14" maxlength="16"
				tabindex="2">
				</html:text>
				&nbsp;&nbsp;
				服务类型：
				<html:select property="servertype" style="width: 100px;" errorStyleClass="inputError">
				 <ig:optionsCollection ccid="PERF_MONITOR_TYPE" isMakeBlankRow="true" isCodeLabel="true"/>
				 </html:select>
				&nbsp;&nbsp;
				<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
					查询
				</html:submit>
				<html:button property="btn_search" value="重置" styleClass="button" onclick="clearAll();"></html:button>
				<html:hidden property="isquery"/>
			
				</div>
			</div>
			
		</div>
    </div>
	<div>
	<div style="float:center;width:98%; margin-left:10px; border-left:#2b6da8;">
	<div>
	<table class="table_style">
		<tr>
			<th width="4%">
			            序号
			</th>
			<th width="12%">
			            主机
			</th>
			<th width="8%" >
				IP
			</th>
			<th width="10%" >
				采集时间
			</th>
			<th width="10%" >
				脚本名称
			</th>
			<th width="6%">
				类型
			</th>
			<th width="12%">
				指标
			</th>
			
			<th width="12%">
				对象名称
			</th>
			
			<th width="10%">
				采集值
			</th>
		</tr>
	</table>
	<div style="overflow-x: hidden; padding-left: 0px; padding-right: 0px; height: 480px; overflow: auto;" >
		<table class="table_style">
		<logic:present name="IGALM05011VO" property="igalm0501VWList">
			<logic:iterate id="bean" name="IGALM05011VO"
				property="igalm0501VWList" indexId="index">
				<tr class="alarmcolor_level">
					<td  width="4%" style="text-align:center;">${PagingDTO.viewStartCount+index}</td> 
					<td  width="12%" style="text-align:center;">${bean.host}</td> 
					<td  width="8%" style="text-align:center;">${bean.ip}</td>
 					<td  width="10%" style="text-align:center;">${bean.collecttime}</td>
 					<td width="10%" style="text-align:center;">${bean.servername}</td> 
					<td width="4%" style="text-align:center;"><ig:codeValue ccid="PERF_MONITOR_TYPE" cid="${bean.servertype}" /></td>				
 					<td width="12%" style="text-align:center;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bean.category}</td> 
 					<td width="12%" style="text-align:center;">${bean.objectname}</td> 
 					<td width="10%" style="text-align:center;">${bean.cdata} ${bean.unit}</td> 
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	 <div  id="operate">
		<!-- paging -->
		<div style="float:left;width:80%;text-align:left;"><jsp:include page="/include/paging.jsp"/></div>
		<!-- /paging -->
	</div>
	</div>
	</div>
	</div>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGEMO0101" toScope="request" />
<bean:define id="title" value="告警" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<style>
.texthidden{
clear:both;
width:210px;
 overflow:hidden;
 text-overflow:ellipsis;
 white-space:nowrap;
 }
</style>
<script type="text/javascript">
function switchShowAlert(str){
	if(str == 1){
		document.getElementById('BussinessAlertDesc').style.display='none';
		document.getElementById('bussinessGroup').style.display='none';
		document.getElementById('hqAlertDesc').style.display='';
		document.getElementById('hqAlertGroup').style.display='';
	}else if(str==2){
		document.getElementById('hqAlertGroup').style.display='none';
		document.getElementById('hqAlertDesc').style.display='none';
		document.getElementById('bussinessGroup').style.display='';
		document.getElementById('BussinessAlertDesc').style.display='';
	}
}
</script>

<body onload="init()">
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
 <div id="contentWrap">
	<div id="content">
	    <div class="new_current" id="newKnowledge" style="width: 920px;height: 450px">
      <div class="new_wtitle" style="width: 920px">
			<div>
        	    <h1 style="float:left; font-size:12px; font-weight:bold; color:#006BC6; padding-left:5px; line-height:22px;"><img src="images/fengxianjianchaqingkuang.gif" style="vertical-align: middle;"/>&nbsp;告警</h1>
        	    <logic:equal value="1" name="IGAIM0150Form" property="oracleFlag">
	        	  	<div id="hqAlertGroup" style="float:right; padding-right:20px; line-height:22px;">
		        	    <font style="font-family:Arial, Helvetica, sans-serif">业务系统&nbsp;|&nbsp;
		        	    	<a href="javascript:switchShowAlert('2')" style="color: #006BC6">Oracle活动</a>
		        	    </font>
	        	    </div>
	        	  	<div id="bussinessGroup" style="float:right; padding-right:20px; line-height:22px; display: none">
		        	    <font style="font-family:Arial, Helvetica, sans-serif">
		        	    <a href="javascript:switchShowAlert('1')" style="color: #006BC6">业务系统</a>&nbsp;|&nbsp;
		        	    	Oracle活动
		        	    </font>
	        	    </div>
        	    </logic:equal>
        	    <logic:notEqual value="1" name="IGAIM0150Form" property="oracleFlag">
        	    	<div id="hqAlertGroup" style="float:right; padding-right:20px; line-height:22px;">
		        	    <font style="font-family:Arial, Helvetica, sans-serif">业务系统</font>
	        	    </div>
        	    </logic:notEqual>
			</div>

      </div>
      <div class="new_ccont" style="width: 920px">
<!--       	<div id="container" style="width: 680px; height: 205px; margin: 15px auto"></div> -->
      	<div id="hqAlertDesc"  style=" height: 428px; overflow: auto;">
            <table width="875" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px;overflow: auto;">
				<tr align="left" height="28">
	                <th width="13%"></th>
					<th width="15%" style="text-align:left;">告警触发时间</th>
					<th width="10%" style="text-align:left;">告警IP</th>
					<th width="26%" style="text-align:left;">业务系统</th>
					<th width="26%" style="text-align:left;">告警触发原因</th>
					<th width="10%" style="text-align:left;">当前值</th>
				</tr>
	<logic:iterate id="hqAlert" name="IGAIM01501VO" indexId="index" property="hqAlertListDetailVWList" type="com.deliverik.plugin.alert.hq.model.HQAlertListDetailVWInfo">
<%-- 		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${hqAlert.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${hqAlert.showurl }${hqAlert.prid }&jump=77');"> --%>
		<tr class="<ig:rowcss index="${index}"/>">
			<td><img src="images/plugin/hq${hqAlert.priority}.png" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.ALARM" /><ig:codeValue ccid='ALARM_PRIORITY' cid='${hqAlert.priority}'/>" /></td>
			<td style="text-align:left;">${hqAlert.tranToTime }</td>
			<td style="text-align:left;">${hqAlert.ip}</td>
			<td style="text-align:left;">${hqAlert.bname}</td>
			<td style="text-align:left;">${hqAlert.defName}</td>
			<td style="text-align:left;">${hqAlert.value}</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
	</logic:iterate>
 		
    </table>
    </div>
    <logic:equal value="1" name="IGAIM0150Form" property="oracleFlag">
      	<div id="bussinessAlertDesc"  style=" height: 428px; overflow: auto; display: none">
            <table width="875" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px;overflow: auto;">
				<tr align="left" height="28">
					<th width="13%" style="text-align:left;">告警触发时间</th>
					<th width="15%" style="text-align:left;">告警实例</th>
					<th width="10%" style="text-align:left;">告警类型</th>
					<th width="26%" style="text-align:left;">告警来源</th>
					<th width="26%" style="text-align:left;">告警触发原因</th>
					<th width="10%" style="text-align:left;">当前值</th>
				</tr>
	<logic:iterate id="oracleAlert" name="IGAIM01501VO" indexId="index" property="lst_CRM06Info" type="com.deliverik.infogovernor.soc.alarm.model.CRM06Info">
<%-- 		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${oracleAlert.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${oracleAlert.showurl }${oracleAlert.prid }&jump=77');"> --%>
		<tr class="<ig:rowcss index="${index}"/>">
			<td style="text-align:left;">${oracleAlert.tranToTime }</td>
			<td style="text-align:left;">${oracleAlert.hqservername}</td>
			<td style="text-align:left;">${oracleAlert.servertype}</td>
			<td style="text-align:left;">${oracleAlert.host}</td>
			<td style="text-align:left;"><div class="texthidden" title="${oracleAlert.createmessage}" style="cursor: hand">${oracleAlert.createmessage}</div></td>
			<td style="text-align:left;">${oracleAlert.ip2}</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
	</logic:iterate>
 		
    </table>
    </div>
    </logic:equal>
      </div>

    </div>
    </div>
	</div>
</div>
</div>
</body>
</html:html>
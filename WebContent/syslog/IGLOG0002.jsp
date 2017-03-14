<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.syslog.vo.IGLOG0002VO"%>
<html:html>
<head>
<bean:define id="id" value="IGMTM0101" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="mtmResources" key="ietitle.IGMTM0101" />
</bean:define>
<script src="js/menu/jquery.js" type="text/javascript"></script>
<script src="js/alerts/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="js/alerts/jquery.alerts.js" type="text/javascript" charset="gbk"></script>
<link href="js/alerts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<link href="js/menu/menu.css" rel="stylesheet" type="text/css" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- header1 -->
<script type="text/javascript">

//<!-- 预留
function checkForm(){
	var alertTime= '<bean:message bundle="mtmResources" key="message.IGMTM0102.001"/>';
	if(!checkDateWithTimeShowForLE("alarmtime_from","alarmtime_to")){
		alert(alertTime);
		return false;
	}
	form.action = getAppRootUrl() + "/IGLOG0002_Search.do";
	return true;
}



function setEntity(url){

	 var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		 if("_resetall"==temp){
			 document.forms[0].ename.value = "";
//			 document.forms[0].eid.value = "";
			 document.forms[0].esyscoding.value = "";
			 return false;
		 }
		if(null!=temp && temp.split("|").length>1){
			var syscode_eid = temp.split("|")[0];
			var name = temp.split("|")[1];
			var syscode;
			var eid;
			if(syscode_eid =="999")
			{
				alert("资产模型不可用！请选择其他模型！");
				return false;
				
			}else if(syscode_eid.split("_").length>1){
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
			}
			document.forms[0].ename.value = name;
		//	document.forms[0].eid.value = eid;
			document.forms[0].esyscoding.value = syscode;
		}			
	}

//修复所选
function fixedAlarm(obj){
	$("info").value = '';
	var message = '<bean:message bundle="mtmResources" key="message.IGMTM0101.002"/>';
	if(checkNum(obj)==0){
		alert(message);
        return false;
	}
	jField('处理信息', '', '告警修复', function(result) {
		if( result!=null&&result!=""){
			$("info").value = result.replace(/[\r\n]/g,' '); 
		}
		if(result != null){
			form.action = getAppRootUrl() + "/IGMTM0101_Fixed.do";
			form.submit();
		}
	});
}
//发起所选
function launchAlarm(name){	
	var objs = document.getElementsByName(name);
	var id = "";
	var length = 0;
	if(objs!=null){	
		for(var i=0;i<objs.length;i++){
			if(objs[i].checked){
				id = objs[i].value;
				length++;
			}
		}
	}	
	if(length==0){
		alert("请选择告警！");
	}else if(length>1){
		alert("只能发起一条告警信息");
	}else{						
		    if(window.confirm("是否确认发起告警流程？")){			
			window.parent.location.href = getAppRootUrl() + '/IGEXTWA0201_Disp.do?id='+id+'&prpdid=0104001&flag=0';
		    }
		
	}
}
function tiaozuan(prid,inde){
	window.parent.location.href = getAppRootUrl() + '/IGEXTWA0103_Disp.do?prid='+prid+"&ind="+inde;
}
function exportExcel(){
	jExcel('请输入文件标题：', '', '文件标题', function(result) {
		if( result != null && result != ""){
			$("exceltitle").value = result.replace(/[\r\n]/g,' '); 
		}else{
			$("exceltitle").value = "";
		}
		form.action = getAppRootUrl() + "/IGLOG0002_Search.do?report=yes";
		form.submit();
	});
}

function loadTags(){
	var currRow;
	var cell;
	var j = -1;
    var priorities = "${IGLOG0002VO.alarmPrioritiesStr}";
    var checkedStr = "${IGLOG0002VO.checkedPrioritiesStr}";
    var checkedStrArr = checkedStr.split("&");
	var prioritiesArr = priorities.split(",");

	for(var i=0;i<prioritiesArr.length;i++){
		if(prioritiesArr[i] != ""){
			var flag = false;
			var buf="";
			var values = prioritiesArr[i].split("&");
			if(i%2 == 0){
				j++;
				currRow=tb.insertRow();
			}
			cell=currRow.insertCell();
			if(checkedStr != ""){
			for(var k=0;k<checkedStrArr.length;k++){
				if(checkedStrArr[k] == ""){
					continue;
				}
				if(checkedStrArr[k] == values[0]){
					flag = true;
					break;
				}
			}
			if(flag) {
				buf = "checked";
			}
			}
			var h = '<input type="checkbox" name="priority" value="'+values[0]+'" styleId="priority" '+buf+'>'+values[1]+'</input>';
			cell.innerHTML= h;
		}
	}
}

WebCalendar.timeShow = true;//是否返回时间

//-->
</script>
</head>
<body onload="loadTags();">
<br>
<html:form styleId="form" action="/IGLOG0002_Search">
	<div>
	<div style="float:left;width:22%;">
	<div>
	<div class="conditions">
	<table align="center">
		<tr>
			<!--告警优先级-->
			<td>
			<table>
				<tr>
					<td>
						<bean:message bundle="mtmResources" key="label.IGLOG0001.AlarmPriority" />：
					</td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr></tr><tr></tr><tr>
				</tr>
			</table>
			 </td>
			<td>
			 <table id="tb">
			 </table>
			</td>
		</tr>
		<tr>
			<!--查询触发时间段-->
			<td><bean:message bundle="mtmResources" key="label.IGLOG0001.AlarmTimeFrom" />：</td>
			<td>
			<html:text property="alarmtime_from" size="15" readonly="true" />
			<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('alarmtime_from'))" border="0" />
			</td>
		</tr>
		<tr>
			<td><bean:message bundle="mtmResources" key="label.IGLOG0001.AlarmTimeTo" />：</td>
			<td>
			<html:text property="alarmtime_to" size="15" readonly="true" />
			<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('alarmtime_to'));" />
			</td>
		</tr>
		<tr>
			<!--告警状态-->
			<td><bean:message bundle="mtmResources" key="label.IGLOG0001.alarmState" />： </td>
			<td>
			<html:select
				name="IGLOG0002Form" styleId="alarmstate" property="alarmstate"
				style="width: 65px;" errorStyleClass="inputError">
				<html:option value=""></html:option>
				<html:option value="0">未处理</html:option>
				<html:option value="1">已处理</html:option>
			</html:select>
			</td>
		</tr>
		<tr>
			<!--告警IP-->
			<td><bean:message bundle="mtmResources" key="label.IGLOG0001.AlarmIP"/>：</td>
			<td>
			<html:text property="ip_like" styleId="ip_like"
				errorStyleClass="inputError imeDisabled" size="15" maxlength="16"
				tabindex="2">
			</html:text>
			</td>
		</tr>
		<tr>
			<!--关键字-->
			<td>关键字：</td>
			<td>
			<html:text property="word_like" styleId="word_like"
				errorStyleClass="inputError imeDisabled" size="15" maxlength="16"
				tabindex="2">
			</html:text>
			</td>
		</tr>
		
		<!-- 
		<tr>
		  	<td>设备类型：</td>
		  	<td>
			<html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999001');"/>
			<html:hidden property="esyscoding"/>
			</td>
		</tr>
 		-->
		<tr>
			<td>
			<html:hidden property="exceltitle"/>
			<html:button property="btn_search" value="导出" styleClass="button"  onclick="exportExcel();"></html:button>
			</td>
			<td>
			<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
				<bean:message bundle="mtmResources" key="button.IGMTM0101.btn_search" />
			</html:submit>
			</td>
		</tr>
	</table>
	</div>
	</div>
	</div>
	<div style="float:left;width:78%;"> 
	<!-- <div  id="results_list" style="float:left;width:78%;">-->
	<div>
		<span style="float:left;">
			<!--  message -->
			<ig:message />
			<span style="color: blue;">告警总数  :</span>
			${IGLOG0002VO.totalcount} 条
			<!--  /message -->
		</span>
	<div align="right">
	
		<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" />
		<img src="images/plugin/syslog8.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='8'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='8'/>
		
		<img src="images/plugin/syslog7.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='7'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='7'/>
		
		<img src="images/plugin/syslog6.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='6'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='6'/>
		
		<img src="images/plugin/syslog5.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='5'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='5'/>
		
		<img src="images/plugin/syslog4.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='4'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='4'/>
		
		<img src="images/plugin/syslog3.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='3'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='3'/>
		
		<img src="images/plugin/syslog2.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='2'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='2'/>
		
		<img src="images/plugin/syslog1.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='1'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='1'/>
		
		<img src="images/plugin/syslog0.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='0'/>" />
		<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='0'/>
		&nbsp;&nbsp;
	</div>
	</div>
	<div id="alarmList">
	<table class="table_style" style="width:auto" >
		<tr><!--
			<th width="4%">
			<logic:present name="IGLOG0002VO" property="historySysLogAlarmList">
				<label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','ids')"/></label>
			</logic:present>
			</th>
			-->
			<th width="5%"></th>
			<th width="14%" style="text-align:left;">
				告警触发时间
			</th>
			<th width="12%" style="text-align:left;">
				告警IP
			</th>
			<th style="text-align:left;">
				告警描述
			</th>

		</tr>
		</table>
		<div style="overflow:auto;overflow-x:hidden;padding-left:0px;padding-right:0px;border-left: 1px solid #2a6ca8;height:510px;">
		<table class="table_style" style="width:auto">
		<logic:present name="IGLOG0002VO" property="historySysLogAlarmList">
			<logic:iterate id="bean" name="IGLOG0002VO"
				property="historySysLogAlarmList" indexId="index">
				<tr class="alarmcolor_level${bean.rulelevel}">
					<!-- <td><input type="checkbox" name="ids" value="${bean.alarmid }"></td> -->
					<td width="5%">
						<img src="images/plugin/syslog${bean.rulelevel}.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.ALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='${bean.rulelevel}'/>" />
					</td>
					<td style="text-align:left;" width="14%" >${bean.syslogtime}</td>
					<td style="text-align:left;" width="12%">${bean.deviceip}</td>
					<td style="text-align:left;">${bean.syslogmsg}</td>			
				</tr>
			</logic:iterate>
		</logic:present>
		</table>
		</div>
	<div  id="operate">
		<!-- paging -->
		<div style="float:right;width:80%;text-align:right;"><jsp:include page="/include/paging.jsp"/></div>
		<!-- /paging -->
	</div>
	</div>
	</div>
	<!-- </div> -->
	</div>
</html:form>
<div class="zishiying"></div>

</body>
</html:html>
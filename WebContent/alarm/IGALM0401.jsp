<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.soc.alarm.vo.IGALM04021VO"%>
<html:html>
<head>
<bean:define id="id" value="IGALM0401" toScope="request" />
<bean:define id="title" toScope="request">
	告警信息查询页面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- header1 -->
<script type="text/javascript">

function searchAlm0401List(){
	var alarmList = document.getElementById("alarmList");
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false,parameters:'type=searchAlm0401List',
		 onSuccess:  function(req, json){
		 var result=req.responseText;
			 if(result!=''){
				 var val = createTable(result);
				 alarmList.innerHTML = val;
			 }
	     }
		});
	return false;
}
//创建表格
function createTable(val){
	var row = val.split("@_@");
	var start ='<table class="table_style"  style="width:auto">';
	for(var i=0;i<row.length;i++){
		var cell = row[i].split("#_#");
		var levelVal = "";
		switch(cell[0]){
			case '0' :{
				levelVal ="未知";
			}
			case '1' :{
				levelVal ="信息";
			}
			case '2' :{
				levelVal ="警告";
			}
			case '3' :{
				levelVal ="次要";
			}
			case '4' :{
				levelVal ="严重";
			}
			case '5' :{
				levelVal ="致命";
			}
		}
		var mo = '<tr class="alarmcolor_level'+cell[0]+'">'+
		'<td  width="5%">'+
		'<img src="images/plugin/syslog'+cell[0]+'.gif" align="middle" style="cursor: pointer;" alt="告警优先级：'+levelVal+'"/>'+
		'</td>'+
		'<td style="text-align:center;" width="15%">'+cell[1]+'</td>'+
		'<td style="text-align:center;" width="12%">'+cell[3]+'</td>'+
		'<td style="text-align:center;" width="12%">'+cell[4]+'</td>'+
		'<td style="text-align:center;" width="15%">'+cell[2]+'</td>'+
		'<td style="text-align:center;" width="19%">'+cell[5]+'</td>'+
		'</tr>'	;	

		start=start+mo;
	}
	var end = '</table>';	
    return start+end;
}
var autoSearch;
var rate;
function check(){
	rate = "${IGALM04021VO.refreshRate}";
	var currRow;
	var cell;
	var j = -1;
    var priorities = "${IGALM04021VO.alarmPrioritiesStr}";
    var checkedStr = "${IGALM04021VO.checkedPrioritiesStr}";
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
	 if('yes' != $('isquery').value){
		 autoSearch = setInterval("searchAlm0401List()",parseInt(rate)*1000);
	 }
}

function checkForm(){
	var alertTime= '开始时间不能晚于结束时间！';
	if(!checkDateWithTimeShowForLE("alarmtime_from","alarmtime_to")){
		alert(alertTime);
		return false;
	}
	var flag = checkIndexOf(document.getElementById('tb').innerHTML);
	form.action = getAppRootUrl() + '/IGALM0401_Disp.do?isquery=yes&isof='+flag;
	return true;
}

function clearAll(){
	$('alarmtime_from').value='';
	$('alarmtime_to').value='';
	$('ip_like').value='';
	$('word_like').value='';
	form.action = getAppRootUrl() + '/IGALM0401_Disp.do?isquery=no';
	form.submit();
	clearInterval(autoSearch);
	autoSearch = setInterval("searchAlm0401List()",parseInt(rate)*1000);
}

function checkIndexOf(str){
	if(str.indexOf('CHECKED')>=0){
		return true;
		}else{
			return false;
			}
}
WebCalendar.timeShow = true;//是否返回时间

</script>
</head>
<body onload="check();">
<div id="maincontent"><!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGALM0401_Disp">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation extname1="${urlable}"/>
	</p>
	</div>
	<div id="search">
	<div style="float:left;width:22%;">
	<div>
	<div class="conditions">
	<table align="center">
		<logic:present name="IGALM04021VO" property="alarmPrioritiesStr" >
		<tr >
			<!--告警优先级-->
			<td>
			<table>
				<tr>
					<td>
						告警级别：
					</td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr></tr><tr></tr><tr></tr>
			</table>
			 </td>
			<td>
			 <table id="tb">
			 
			 </table>
			</td>
		</tr>
		</logic:present>
		<tr>
			<!--查询触发时间段-->
			<td>
				 起始时间：
			</td>
			<td>
			<html:text property="alarmtime_from" size="15" readonly="true" />
			<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('alarmtime_from'))" border="0" />
			</td>
		</tr>
		<tr>
			<td>结束时间：</td>
			<td>
			<html:text property="alarmtime_to" size="15" readonly="true" />
			<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('alarmtime_to'));" />
			</td>
		</tr>
		<tr>
			<!--告警IP-->
			<td>设备IP：</td>
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

		<tr>
			<td>
			<html:button property="btn_search" value="重置" styleClass="button" onclick="clearAll();"></html:button>
			</td>
			<td>
			<html:hidden property="isquery"/>
			<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
				查询
			</html:submit>
			</td>
		</tr>
	</table>
	</div>
	</div>
	</div>
	<div style="float:left;width:77%;border-left:#2b6da8;">
	<div id="results_list" >
	<div>
		<span style="float:left;">
			<!--  message -->
			<ig:message />
			<!--  /message -->
		</span>
	<div align="right">
	告警级别:
		<img src="images/plugin/syslog5.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='5'/>" />
		<ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='5'/>
		<img src="images/plugin/syslog4.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='4'/>" />
		<ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='4'/>
		<img src="images/plugin/syslog3.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='3'/>" />
		<ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='3'/>
		<img src="images/plugin/syslog2.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='2'/>" />
		<ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='2'/>
		<img src="images/plugin/syslog1.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='1'/>" />
		<ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='1'/>
		<img src="images/plugin/syslog0.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.MOCHAALARM" /><ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='0'/>" />
		<ig:codeValue ccid='MOCHAALARM_PRIORITY' cid='0'/>
		&nbsp;&nbsp;
	</div>
	</div>
	<div>
	<table class="table_style">
		<tr>
			<th width="5%" style="text-align:center;">
			</th>
			<th width="15%" style="text-align:center;">
			            告警时间
			</th>
			<th width="12%" style="text-align:center;">
				告警设备IP
			</th>
			<th width="12%" style="text-align:center;">
				告警类型
			</th>
			<th width="15%" style="text-align:center;">
				告警对象
			</th>
			<th width="19%" style="text-align:center;">
				告警内容
			</th>
		</tr>
	</table>
	<div style="border-left: #2a6ca8 1px solid;overflow-x: hidden; padding-left: 0px; padding-right: 0px; height: 480px;overflow: auto;"  id="alarmList">
		<table class="table_style">
		<logic:present name="IGALM04021VO" property="igalm0401List">
			<logic:iterate id="bean" name="IGALM04021VO"
				property="igalm0401List" indexId="index">
				<tr class="alarmcolor_level${bean.rulelevel}">
				    <td  width="5%">
						<img src="images/plugin/syslog${bean.rulelevel}.gif" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.ALARM" /><ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='${bean.rulelevel}'/>" />
					</td>
					<td style="text-align:center;" width="15%">${bean.alarmtime}</td>
					<td style="text-align:center;" width="12%">${bean.serverip}</td>
					<td style="text-align:center;" width="12%">${bean.category}</td>
					<td style="text-align:center;" width="15%">${bean.objectname}</td>
					<td style="text-align:center;" width="19%">${bean.alarmmsg}</td>			
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
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
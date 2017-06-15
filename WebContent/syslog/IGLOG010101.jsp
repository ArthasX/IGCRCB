<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.syslog.vo.IGLOG0101VO"%>
<html:html>
<head>
<bean:define id="id" value="IGLOG0101" toScope="request" />
<bean:define id="title" toScope="request">
	设备日志信息页面
</bean:define>
<script src="js/menu/jquery.js" type="text/javascript"></script>
<script src="js/alerts/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="js/alerts/jquery.alerts.js" type="text/javascript" charset="gbk"></script>
<link href="js/alerts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<link href="js/menu/menu.css" rel="stylesheet" type="text/css" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- header1 -->
<style>
	.zjg2{height:20px; background-color:#b5cee6;}
	.zjg3{height:295px;overflow:auto;overflow-x:hidden;padding-left:5px;padding-right:5px;float: left; width: 100%;}
	.zjg5{width:150px; height:20px; float:left; background-image:url(images/mtm/zjg1.jpg);}
	.zjg5 ul{width:80%; height:20px; margin:0 auto;}
	.zjg5 li{font-size:12px; text-align:left; font-family:"宋体"; font-size:14px; font-weight:bold; color:#6793bc; padding-top:2px;}
	.zjg6{height:20px; float:right;}
	.zjg6 li{width:16px; height:16px; float:right; margin-right:10px;list-style-type:none; margin-top:3px; }	
</style>
<style>
#stormdiv{width:300px;}
#stormdiv li{height:22px;line-height:22px;font-weight: bold;color: red;}
</style>

<script type="text/javascript">

var buttonflag;//全局变量，控制查询按钮 0：查询， 1：收起

function getAlarmTotalCount(){
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{
		 asynchronous:false,
		 parameters:'type=getAlarmTotalCount',
		 onSuccess:  
			 function(req, json){
		 		var result=req.responseText;
		 		alarmcount.innerHTML = result+'&nbsp;';
	     	 }
		});
}
function searchsyslogList(){
	getAlarmTotalCount();
	var parametersStr = 'type=searchsyslogList';
	var objs = document.getElementsByName('ids');
	var checkedStr = "";
	var length = 0;
	if(objs!=null){	
		for(var i=0;i<objs.length;i++){
			if(objs[i].checked){
				checkedStr = checkedStr + objs[i].value + '_';
				length++;
			}
		}
	}
	if(length > 0) {
		parametersStr = parametersStr + '&checkedStr=' + checkedStr;
	}
	var alarmList = document.getElementById("alarmList");
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false,parameters:parametersStr,method:"post",
		 onSuccess:  function(req, json){
		 	 var result = req.responseText;
		 	 if(result == null) result = '';
		 	 var tableStr = createTable(result);
			 alarmList.innerHTML = tableStr;
	     }
		});
	return false;
}

	function createTable(str){
		if(str == '') return '';
		var row = str.split("@_@");
		var start = '<table class="table_style" style="width:auto;height:18px;" >';
		for(var i=0;i<row.length;i++){
			var cell = row[i].split("#_#");
			var level = cell[0];     //级别
			var id = cell[1];	     //ID
			var checkflag = cell[2]; //复选框
			var prid = cell[3];		 //流程ID（用于判断逻辑）	
			var levelword = cell[4]; //级别英文标识
			var createtime = cell[5];//发生时间
			var ip = cell[6];		 //ip
			var msg = cell[7];		 //告警信息
			var isalarm = cell[8];   //是否是告警
	
			var tr = '<tr class="alarmcolor_level'+level+'"><td width="6%">';
			if(prid == '0'){
				tr = tr + '<input type="checkbox" name="ids" value="'+id+'"  '+checkflag+' >';
			}else{
				tr = tr + '<img src="images/sitemap.png" border="0" onclick="tiaozuan('+prid+',1);" alt="查看流程" style="cursor: pointer;"/>';
			}
			tr = tr + '</td><td width="6%" style="text-align:left;">';
			if(isalarm == '1'){
				tr = tr + '<img src="images/plugin/hq3.png" align="middle"  style="cursor: pointer;" /></td>';
			}
			tr = tr + '<td style="text-align:left;" width="7%">'+levelword+'</td>';
			tr = tr + '<td style="text-align:left;" width="12%">'+createtime+'</td>';
			tr = tr + '<td style="text-align:center;" width="12%">'+ip+'</td>';
			tr = tr + '<td style="text-align:left;">'+msg+'</td></tr>';
			tr = tr + '<input type="hidden" value="'+isalarm+'" name="isalarm'+id+'"/>';
			tr = tr + '<input type="hidden" value="'+level+'" name="level'+id+'"/>';
			tr = tr + '<input type="hidden" value="'+ip+'" name="ip'+id+'"/>';
			tr = tr + '<input type="hidden" value="'+msg+'" name="msg'+id+'"/>';
	
			start = start + tr;
		}
		var end = '</table>';	
	    return start+end;
	}

var autoSearch;
var rate;
function loadAlarmLevel(isclear){
    var tableLength = tb.rows.length;
    for(var i = 0;i < tableLength;i++) {
        tb.deleteRow(i);
    }	
	buttonflag = 0;
	
	rate = "${IGLOG0101VO.refreshRate}";
	var currRow;
	var cell;
	var j = -1;
    var priorities = "${IGLOG0101VO.alarmPrioritiesStr}";
    var checkedStr = "${IGLOG0101VO.checkedPrioritiesStr}";
    var checkedStrArr = checkedStr.split("&");
	var prioritiesArr = priorities.split(",");
	currRow=tb.insertRow();
	cell=currRow.insertCell();
	cell.innerHTML = '';
	for(var i=0;i<prioritiesArr.length;i++){
		if(prioritiesArr[i] != ""){
			var flag = false;
			var buf="";
			var values = prioritiesArr[i].split("&");
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
			if(flag && isclear != 'yes') {
				buf = "checked";
			}
			}
			var h = '<input type="checkbox" name="priority" value="'+values[0]+'" styleId="priority" '+buf+'>'+values[1]+'</input>';
			cell.innerHTML= h;
		}
	}
	/* cell=currRow.insertCell();
	cell.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
		'<input type="button" value="确定" class="button" onclick="checkForm();"></input>';
	cell=currRow.insertCell();
	cell.innerHTML = '<input type="button" value="清空" class="button" onclick="clearAll();"></input>'; */
	if('yes' != $('isquery').value){
		autoSearch = setInterval("searchsyslogList()",parseInt(rate)*1000);
	}
}

function checkForm(){
	var alertTime= '<bean:message bundle="mtmResources" key="message.IGMTM0102.001"/>';
	if(!checkDateWithTimeShowForLE("alarmtime_from","alarmtime_to")){
		return false;
	}
	form.action = getAppRootUrl() + '/IGLOG0101_Search.do?isquery=yes';
	form.submit();
	//return true;
}

function clearAll(){
	$('alarmtime_from').value='';
	$('alarmtime_to').value='';
	$('ip_like').value='';
	$('word_like').value='';
	loadAlarmLevel('yes');
}

//修复所选
function fixedAlarm(name){
	var objs = document.getElementsByName(name);
	var id = "";
	var length = 0;
	if(objs!=null){	
		for(var i=0;i<objs.length;i++){
			if(objs[i].checked){
				id = objs[i].value;
				//var isalarm = $("isalarm"+id).value;
				//if(isalarm != 1){
					//alert("不能修复非告警信息！");
					//return false;
				//}
				length++;
			}
		}
	}	
	if(length==0){
		alert("请选择告警！");
	}else{	
	    if(window.confirm("是否修复选中告警？")){			
	    	form.action = getAppRootUrl() + '/IGLOG0101_Fix.do?isRealTimeCollect=1';
	    	form.submit();
		}
	}
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
		alert("只能发起一条告警信息！");
	}else{						
	    if(window.confirm("是否确认发起告警流程？")){			
			window.parent.location.href = getAppRootUrl() + '/IGEXTWA0201_Disp.do?id='+id+'&prpdid=0122001&flag=0';
		}
		
	}
}

//告警屏蔽
function filter(name){
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
	if(length>1){
		alert("只能选择一条告警信息！");
	}else{
        var url = "/IGLOG0101_FilterDisp.do?id="+id+"&isRealTimeCollect=1";
        openSubWindow(url, '_blank', '500', '300');	
	}
}

function encodeContent(data){  
	  return encodeURI(data).replace(/&/g,'%26').replace(/\+/g,'%2B').replace(/\s/g,'%20').replace(/#/g,'%23');  
} 

function alarmConfig(name){
	var objs = document.getElementsByName(name);
	var id = "";
	var length = 0;
	var ip;
	var msg;
	if(objs!=null){	
		for(var i=0;i<objs.length;i++){
			if(objs[i].checked){
				id = objs[i].value;
				length++;
			}
		}
	}	
	if(length>1){
		alert("只能选择一条告警信息！");
	}else if(length == 0){
		window.parent.location.href = getAppRootUrl()+"/IGLOG0043_DISP.do?couldReturn=yes&isRealTimeCollect=1";
	}else{
		ip = $("ip"+id).value;
		level = $("level"+id).value;
		msg = $("msg"+id).value;
        var url = "/IGLOG00022_Disp_Fast.do?deviceip="+ip+"&priority="+level+"&alarmmsgs="+encodeContent(msg);
        openSubWindow(url, '_blank', '800', '400');	
	}
}


function exportExcel(){
	jExcel('请输入文件标题：', '', '文件标题', function(result) {
		if( result != null && result != ""){
			$("exceltitle").value = result.replace(/[\r\n]/g,' '); 
		}else{
			$("exceltitle").value = "";
		}
		form.action = getAppRootUrl() + "/IGLOG0101_Search.do?report=yes";
		form.submit();
	});
}

function showSearchDiv(){
	search.style.display = "";
	buttonflag = 1;
	/* if(buttonflag == 0){
		document.getElementById("searchbutton").value = "收起";
		search.style.display = "";
		buttonflag = 1;
	}else if(buttonflag == 1){
		document.getElementById("searchbutton").value = "查询";
		search.style.display = "none";
		buttonflag = 0;
	} */
}
function closecat(){
	search.style.display = "none";
	buttonflag = 0;
}

function resetpage1(){
	searchsyslogList();
	clearInterval(autoSearch);
	autoSearch = setInterval("searchsyslogList()",parseInt(rate)*1000);
}

function resetpage2(){
	window.location.href = getAppRootUrl() + "/IGLOG0101_Search.do";
}

function tiaozuan(prid,inde){
	window.parent.location.href = getAppRootUrl() + '/IGEXTWA0103_Disp.do?prid='+prid+"&ind="+inde;
}

WebCalendar.timeShow = true;//是否返回时间

//-->
</script>

</head>
<body onload="getStormRecord();loadAlarmLevel();" style="height: 300;">
<html:form styleId="form" action="/IGLOG0101_Search">
	<div>
	<div class="zjg2">
		<div class="zjg5">
			<ul>
	        <li>实时设备日志</li>
	        </ul>
	    </div>
	    <div class="zjg6">
	        <ul>
	        <li><img src="images/mtm/refresh.gif" alt="刷新" onclick="resetpage2()" style="cursor: hand"/></li>
	        <li><img src="images/mtm/searchbutton1.gif" alt="查询" onclick="showSearchDiv()" id="searchbutton" style="cursor: hand"/></li>
	        <logic:present name="IGLOG0101VO" property="sysLogList" >
	        <logic:present name="IGLOG0101VO" property="isMaintain" >
	        <li><html:hidden property="exceltitle"/><img src="images/mtm/expbutton.gif" alt="导出" onclick="exportExcel()" style="cursor: hand"/></li>
	        <li><img src="images/mtm/repair.gif" alt="修复" onclick="fixedAlarm('ids');" style="cursor: hand"/></li>
        	</logic:present>
        	<li><img src="images/mtm/fqrwd.gif" onclick="launchAlarm('ids');" alt="发起任务单"  style="cursor: hand"/></li>
	        </logic:present>
	        <logic:equal name="MNT_AUTH" value="yes">
	        <logic:present name="IGLOG0101VO" property="isMaintain" >
	        <li><img src="images/mtm/initiatedTaskOrders.gif" alt="屏蔽" onclick="filter('ids');" style="cursor: hand"/></li>
        	<li><img src="images/mtm/zjg6.gif" onclick="alarmConfig('ids');" alt="告警设定"  style="cursor: hand"/></li>
	        </logic:present>
	        </logic:equal>
	        </ul>
     	</div>
    </div>
		<div style="float:left;width: 28%;margin-top:2px;">
			<table>
			<tr><td>
				<span class="red">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="images/plugin/hq3.png" align="middle"  alt="设备告警"/>
				<strong>告警总数:</strong></span>
				<span class="red">
				<strong id="alarmcount">
					<c:if test="${IGLOG0101VO.totalcount == null}">0</c:if>
					<c:if test="${IGLOG0101VO.totalcount != null}">${IGLOG0101VO.totalcount} </c:if>
				</strong>
				<strong>条</strong>
				</span>
			</td></tr>
			</table>
		</div>
		<div id="stormdiv" style="overflow:hidden;height:23px;float:left;width: 26%;margin-top:3px;"> 
			<ul id="stormbox1">
			</ul>
			<ul id="stormbox2"></ul>
		</div>
		<script type="text/javascript">
			
			var speed = 150;
			var stormdiv =  document.getElementById("stormdiv");
			var stormbox1 =  document.getElementById("stormbox1");
			var stormbox2 =  document.getElementById("stormbox2");

			function roll(){
				if(stormbox2.offsetTop-stormdiv.scrollTop<=0)  {  //当滚动到第二部分的顶部位置时
					stormdiv.scrollTop-=stormbox1.offsetHeight; //重置至第一部分顶部位置
				}else{
					stormdiv.scrollTop++ ;
				}
			}

			var getStormRecordStart;

			//实时获取最新告警风暴数据
			function getStormRecord(){
				clearInterval(getStormRecordStart)
				var str = '';
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{
					 asynchronous:false,
					 parameters:'type=getStormRecord',
					 onSuccess:  
						 function(req, json){
					 		var result=req.responseText;
					 		if(result == "none" || result == null || result == ""){
						 		str = '';
						 	}else{
						 		var records = result.split("&");
						 		for(var i=0;i<records.length;i++){
									var record = records[i];
									if(record == null || record == "") continue;
									var items = record.split("#");
									var xuhao = ' ';
									if(records.length > 1) xuhao = i + 1;//如果多于一条则增加序号
									str = str + '<li>'+xuhao+' <span>设备'+items[0]+'产生告警风暴，产生时间为'+items[1]+'，截止目前已屏蔽告警'+items[2]+'条</span></li>';
								 }
						 	}
				     	 }
					});
				stormbox1.innerHTML = str;
				stormbox2.innerHTML = stormbox1.innerHTML;
				var length = stormbox1.getElementsByTagName("li").length;
				if(length > 1){
					getStormRecordStart = setInterval(roll,speed);
					stormdiv.onmouseover=function() {clearInterval(getStormRecordStart)};
					stormdiv.onmouseout=function() {getStormRecordStart=setInterval(roll,speed)};
				}else if(length = 0){
					stormdiv.style.display = "none";
				}
			}

			var autoGetStormRecord = setInterval(getStormRecord,10*1000);//10秒刷新一次
			
		</script>
	<div style="width: 98.7%;display: none;" id="search">
	<div class="conditions">
		<table align="center">
			<tr>
				<!--查询触发时间段-->
				<td><bean:message bundle="mtmResources" key="label.IGLOG0001.AlarmTimeFrom" />：</td>
				<td>
					<html:text property="alarmtime_from" size="15" readonly="true" />
					<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('alarmtime_from'))" border="0" />
				</td>
				<td><bean:message bundle="mtmResources" key="label.IGLOG0001.AlarmTimeTo" />：</td>
				<td>
					<html:text property="alarmtime_to" size="15" readonly="true" />
					<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('alarmtime_to'));" />
				</td>
			</tr>
			<tr>
				<!--告警IP-->
				<td>设备IP：</td>
				<!--关键字-->
				<td>
					<html:text property="ip_like" styleId="ip_like" errorStyleClass="inputError imeDisabled" size="15" maxlength="16"
					tabindex="2"></html:text>
				</td>
				<td>关键字：</td>
				<td>
					<html:text property="word_like" styleId="word_like" errorStyleClass="inputError imeDisabled" size="15" maxlength="16"
					tabindex="2"></html:text>
				</td>
			</tr>
			<tr>
				<!--告警优先级-->
				<td colspan="4">告警级别：</td>
			</tr>
			<tr>
				<td colspan="4"><logic:present name="IGLOG0101VO" property="alarmPrioritiesStr" >
					<table id="tb" >
					</table>
					</logic:present></td>
			</tr>
			<tr align="right">
				<td colspan="4">
				<img src="images/mtm/searchbutton2.gif" alt="确定" onclick="checkForm()" style="cursor: hand"/>
				<img src="images/mtm/close.gif" alt="收起" onclick="closecat()" style="cursor: hand"/>
				</td>
			</tr>
		</table>	
	</div>
	</div>
	<div class="zjg3">
	<div>
		<span style="float:left;">
			<ig:message />
		</span>
	</div>
	<div>
	<table class="table_style" style="width:auto" >
		<tr>
			<th width="6%" style="text-align:center;">
			<logic:present name="IGLOG0101VO" property="sysLogList">
				<label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','ids')"/></label>
			</logic:present>
			</th>
			<th width="6%" style="text-align:left;">告警</th>
			<th width="7%" style="text-align:left;">级别</th>
			<th width="12%" style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;触发时间</th>
			<th width="12%" >设备IP</th>
			<th style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日志描述</th>
		</tr>
	</table>
	<div style="overflow-x: hidden; padding-left: 0px; padding-right: 0px; height: 260px; overflow: auto;"  id="alarmList">
		<table class="table_style"  style="width:auto">
		<logic:present name="IGLOG0101VO" property="list_vo">
			<logic:iterate id="bean" name="IGLOG0101VO"
				property="list_vo" indexId="index">
				<tr class="alarmcolor_level${bean.rulelevel}">
					<!-- 选择框或流程图标 -->
					<td width="6%" >
						<c:if test="${bean.prid==0}">
						 &nbsp;<input type="checkbox" name="ids" value="${bean.id}"> 
					    </c:if>
					    <c:if test="${bean.prid!=0 }">&nbsp;
						 &nbsp;<img src="images/sitemap.png" border="0" onclick="tiaozuan(${bean.prid },1);" alt="查看流程" style="cursor: pointer;"/>
					    </c:if>
					</td>
					
					<!-- 是否是告警 -->
					<td width="6%" style="text-align:left;">
						<c:if test="${bean.isalarm == 1}"> <!-- 是告警 -->
							<img src="images/plugin/hq3.png" align="middle" style="cursor: pointer;"  alt="设备告警"/>
						</c:if> 
						<input type="hidden" value="${bean.isalarm}" name="isalarm${bean.id}">
					</td>
					
					<!-- 告警级别 -->
					<td style="text-align:left;" width="7%">
						<ig:codeValue ccid='SYSLOGALARM_PRIORITY' cid='${bean.rulelevel}'/>
						<input type="hidden" value="${bean.rulelevel}" name="level${bean.id}"/>
					</td>
					
					<!-- 创建时间 -->
					<td style="text-align:left;" width="12%">${bean.createtime}</td>
					
					<!-- 设备IP -->
					<td style="text-align:center;" width="12%">${bean.deviceip}
					<input type="hidden" value="${bean.deviceip}" name="ip${bean.id}"/></td>
					
					<!-- 描述 -->
					<td style="text-align:left;">${bean.alarmmsg}
					<input type="hidden" value="${bean.alarmmsg}" name="msg${bean.id}"/>
					</td>	
							
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	
	</div>
<%-- 	<div id="operate" style="float:left;heigth:auto;text-align:left;">
		<div >
			<logic:present name="IGLOG0101VO" property="sysLogList" >
				&nbsp;<html:button property="btn_fixed"  value="修复" styleClass="button" onclick="fixedAlarm('ids');" style="height:20px;" />&nbsp;
				<html:button property="btn_fixed" value="发起任务单" styleClass="button" onclick="launchAlarm('ids');" style="height:20px;"/>&nbsp;
			</logic:present>
			<logic:equal name="MNT_AUTH" value="yes">
				<html:button property="btn_fixed" value="屏蔽" styleClass="button" style="height:20px;" onclick="filter('ids');"/>&nbsp;
				<html:button property="btn_fixed" value="告警设定" styleClass="button" onclick="alarmConfig('ids');" style="height:20px;"/>
			</logic:equal>
		
		</div>
	</div> --%>
	</div>
	</div>
	</div>
</html:form>
<div class="zishiying"></div>

</body>
</html:html>
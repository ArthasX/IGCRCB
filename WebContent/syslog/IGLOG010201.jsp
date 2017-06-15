<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.syslog.vo.IGLOG0102VO"%>
<html:html>
<head>
<bean:define id="id" value="IGLOG0102" toScope="request" />
<bean:define id="title" toScope="request">
	IGLOG0114
</bean:define>
<script src="js/menu/jquery.js" type="text/javascript"></script>
<script src="js/alerts/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="js/alerts/jquery.alerts.js" type="text/javascript"
	charset="gbk"></script>
<link href="js/alerts/jquery.alerts.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="js/menu/menu.css" rel="stylesheet" type="text/css" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- header1 -->
<script type="text/javascript">
	//<!-- 预留
	//<!-- 预留
	function checkForm() {
		var alertTime = '<bean:message bundle="mtmResources" key="message.IGMTM0102.001"/>';
		if (!checkDateWithTimeShowForLE("starttime_from", "starttime_to")) {
			alert(alertTime);
			return false;
		}
		if (!checkDateWithTimeShowForLE("endtime_from", "endtime_to")) {
			alert(alertTime);
			return false;
		}
		form.action = getAppRootUrl() + "/IGLOG0102_Search.do";
		return true;
	}

	//修复所选
	function fixedAlarm(obj) {
		$("info").value = '';
		var message = '<bean:message bundle="mtmResources" key="message.IGMTM0101.002"/>';
		if (checkNum(obj) == 0) {
			alert(message);
			return false;
		}
		jField('处理信息', '', '告警修复', function(result) {
			if (result != null && result != "") {
				$("info").value = result.replace(/[\r\n]/g, ' ');
			}
			if (result != null) {
				form.action = getAppRootUrl() + "/IGMTM0101_Fixed.do";
				form.submit();
			}
		});
	}
	//发起所选
	function launchAlarm(name) {
		var objs = document.getElementsByName(name);
		var id = "";
		var length = 0;
		if (objs != null) {
			for ( var i = 0; i < objs.length; i++) {
				if (objs[i].checked) {
					id = objs[i].value;
					length++;
				}
			}
		}
		if (length == 0) {
			alert("请选择告警！");
		} else if (length > 1) {
			alert("只能发起一条告警信息");
		} else {
			if (window.confirm("是否确认发起告警流程？")) {
				window.parent.location.href = getAppRootUrl()
						+ '/IGEXTWA0201_Disp.do?id=' + id
						+ '&prpdid=0104001&flag=0';
			}

		}
	}
	
	function tiaozuan(prid, inde) {
		var url = '/IGEXTWA0103_Disp.do?prid=' + prid + '&ind=' + inde +'&syslogflag=yes';
		openSubWindow(url, '_blank', '1000', '650');	
	}

	function exportExcel() {
		jExcel('请输入文件标题：', '', '文件标题', function(result) {
			if (result != null && result != "") {
				$("exceltitle").value = result.replace(/[\r\n]/g, ' ');
			} else {
				$("exceltitle").value = "";
			}
			form.action = getAppRootUrl() + "/IGLOG0102_Search.do?report=yes";
			form.submit();
		});
	}
	
	function loadTags() {
		var currRow;
		var cell;
		var j = -1;
		var priorities = "${IGLOG0102VO.alarmPrioritiesStr}";
		var checkedStr = "${IGLOG0102VO.checkedPrioritiesStr}";
		var checkedStrArr = checkedStr.split("&");
		var prioritiesArr = priorities.split(",");

		for ( var i = 0; i < prioritiesArr.length; i++) {
			if (prioritiesArr[i] != "") {
				var flag = false;
				var buf = "";
				var values = prioritiesArr[i].split("&");
				if (i % 2 == 0) {
					j++;
					currRow = tb.insertRow();
				}
				cell = currRow.insertCell();
				if (checkedStr != "") {
					for ( var k = 0; k < checkedStrArr.length; k++) {
						if (checkedStrArr[k] == "") {
							continue;
						}
						if (checkedStrArr[k] == values[0]) {
							flag = true;
							break;
						}
					}
					if (flag) {
						buf = "checked";
					}
				}
				var h = '<input type="checkbox" name="priority" value="'+values[0]+'" styleId="priority" '+buf+'>'
						+ values[1] + '</input>';
				cell.innerHTML = h;
			}
		}
	}

	WebCalendar.timeShow = true;//是否返回时间

	//-->

	var refer = true;
	function combo() {
		if (refer) {
			search.style.display = "";
			$("serach").value = "收起";
			refer = false;

			var flag = false;
			var checkedStr = "${IGLOG0102VO.checkedPrioritiesStr}";
			if (checkedStr == "")  return;
			var checkedStrArr = checkedStr.split("&");
			levels = document.getElementsByName("cvalue");
			if(levels!=null){	
				for(var i=0;i<levels.length;i++){
					for ( var k = 0; k < checkedStrArr.length; k++) {
						if (checkedStrArr[k] == "") {
							continue;
						}
						if (checkedStrArr[k] == levels[i].value) {
							flag = true;
							break;
						}
					}
					if (flag) {
						levels[i].checked  = true;
					}
					flag = false;
				}
			}
			
		} else {
			search.style.display = "none";
			$("serach").value = "查询";
			refer = true;
		}
	}
	function show(name) {
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
		if(length < 1){
			var url = "/IGLOG0114_Clear.do";
			openSubWindow(url, '_blank', '950', '400');	
		}else{
			form.action = getAppRootUrl() + "/IGLOG0102_Del.do";
			form.submit();
		}
	}

	function clearAll(){
		$('starttime_from').value='';
		$('starttime_to').value='';
		$('ip_like').value='';
		$('state').value='';

		$('endtime_from').value='';
		$('endtime_to').value='';
		$('word_like').value='';

		levels = document.getElementsByName("cvalue");
		if(levels!=null){	
			for(var i=0;i<levels.length;i++){
				levels[i].checked  = false;
			}
		}
	}


</script>
</head>
<body style="height: 710;">
<html:form styleId="form" action="/IGLOG0102_Search">
	<div>
	<div style="text-align: right;">
		<table>
			<tr>
				<td>
					<html:button property="serach" value="查询" 
					styleClass="button" onclick="combo();"></html:button>
				</td>
				<td>
					<html:hidden property="exceltitle" /> <html:button
					property="btn_search" value="导出" styleClass="button"
					onclick="exportExcel();"></html:button>
				</td>
			</tr>
		</table>
	</div>
	<div style="width: 98.7%;display: none;" id="search">
		<div id="contents" >
		<table align="center">
			<tr>
				<!--查询触发时间段-->
				<td colspan="4">确认时间：从
				<html:text property="starttime_from" size="15" readonly="true" /> 
					<img src="images/date.gif" style="cursor: pointer;" onClick="calendar($('starttime_from'))" /> 
				到<html:text property="starttime_to" size="15" readonly="true" /> 
					<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('starttime_to'));" />
				</td>
			<tr>
			<tr>
				<!--查询触发时间段-->
				<td colspan="4">修复时间：从
				<html:text property="endtime_from" size="15" readonly="true" />
					<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('endtime_from'))" border="0" /> 
				<!--查询触发时间段-->
				 到<html:text property="endtime_to" size="15" readonly="true" />
					<img src="images/date.gif" align="middle" style="cursor: pointer;" onClick="calendar($('endtime_to'))" border="0" />
				</td>
			</tr>
			<tr>
				<td colspan="4">告警等级：</td>
			</tr>
			<tr>
				<td colspan="4"><logic:present name="IGLOG0102VO" property="ruleli"> 
					<logic:iterate id="bean" name="IGLOG0102VO" property="ruleli" indexId="index">
						<input type="checkbox" name="cvalue" value="${bean.cid}">${bean.cvalue}
					</logic:iterate>
				</logic:present></td>
			</tr>
			<tr>
				<!--告警IP--> 
				<td><bean:message bundle="mtmResources" key="label.IGLOG0001.AlarmIP" />：</td>
				<td><html:text property="ip_like" styleId="ip_like" errorStyleClass="inputError imeDisabled" 
						size="15" maxlength="16" tabindex="2"></html:text> </td>
				<!--告警状态-->	
				<td><bean:message bundle="mtmResources" key="label.IGLOG0001.alarmState" />：</td>
				<td><html:select name="IGLOG0102Form" styleId="state" property="state" style="width: 100px;" errorStyleClass="inputError">
					<html:option value=""></html:option>
					<html:option value="0">已修复(非流程)</html:option>
					<html:option value="1">已修复(通过流程)</html:option>
					<html:option value="2">规则屏蔽</html:option>
					<html:option value="3">风暴屏蔽</html:option>
					</html:select> 
				</td>
			</tr>
			<tr>
				<!--关键字--> 
				<td>关键字：</td>
				<td><html:text property="word_like" styleId="word_like"
					errorStyleClass="inputError imeDisabled" size="15" maxlength="16"
					tabindex="2">
				</html:text></td>
				<td colspan="2">	
				<html:submit property="btn_search" styleClass="button" value="确认" onclick="return checkForm();">
				</html:submit>
				<input type="button" value="清空" class="button" onclick="clearAll();"></input>
				</td>
			</tr>
		</table>
		</div>
	</div>


	<div style="float: left; width: 100%;"><!-- <div  id="results_list" style="float:left;width:78%;">-->

	<div id="alarmList">
	<table class="table_style" style="width: auto">
		<tr>

			<th width="4%"><logic:present name="IGLOG0102VO"
				property="list_vo">
				<label><input type="checkbox" name="allbox" id="allbox"
					value="id" onclick="selectAll('allbox', 'id')";/>
				</label>
			</logic:present></th>
			<th width="5%">级别</th>
			<th width="9%">状态</th>
			<th width="14%" style="text-align: left;">触发时间</th>
			<th width="14%" style="text-align: left;">确认时间</th>
			<th width="14%" style="text-align: left;">修复时间</th>
			<th width="12%" style="text-align: left;">告警IP</th>
			<th style="text-align: left;">告警描述</th>
		</tr>
	</table>
	<div style="overflow-x: hidden; padding-left: 0px; padding-right: 0px; overflow: auto;height: 618px;"  id="alarmList">
	<table class="table_style" style="width: auto">
		<logic:present name="IGLOG0102VO" property="list_vo">
			<logic:iterate id="bean" name="IGLOG0102VO"
				property="list_vo" indexId="index">
				<tr class="alarmcolor_level${bean.rulelevel}">
					<td width="4%"><input type="checkbox" name="id"
						value="${bean.id}"></td>
					<td width="5%"><span style="text-align: center;"><ig:codeValue
						ccid='SYSLOGALARM_PRIORITY' cid='${bean.rulelevel}' /></span></td>
					<td width="9%">
						<logic:equal name="bean" property="state" value="0">
							已修复
						</logic:equal>
						<logic:equal name="bean" property="state" value="1">
							<span>
								<a href="javascript:tiaozuan(${bean.prid},1);" style="color: #FF0000;text-decoration: none;">已修复</a>
							</span>
						</logic:equal>
						<logic:equal name="bean" property="state" value="2">
							规则屏蔽
						</logic:equal>
						<logic:equal name="bean" property="state" value="3">
							风暴屏蔽
						</logic:equal>
					</td>
						
					<td style="text-align: left;" width="14%">${bean.createtime}</td>
					<td style="text-align: left;" width="14%">${bean.starttime}</td>
					<td style="text-align: left;" width="14%">${bean.endtime}</td>
					<td style="text-align: left;" width="12%">${bean.deviceip}</td>
					<td style="text-align: left;">${bean.alarmmsg}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
		<div style="float: left;">
			<logic:equal name="MNT_AUTH" value="yes">
				<html:button property="bsearch" value="取消屏蔽"
						styleClass="button" onclick="show('id');"></html:button>
			</logic:equal>
		</div>
		<div style="float: right;">
			<jsp:include page="/include/paging.jsp" />
		</div>
	</div>
	
	</div>
	</div>
	<!-- </div> --></div>
</html:form>
<div class="zishiying"></div>

</body>
</html:html>
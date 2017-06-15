<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html:html>
<bean:define id="id" value="IGLOG0106" toScope="request" />
<bean:define id="title" value="告警规则快速录入" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript" src="js/menu/jquery.js"></script>
<!-- /header1 -->
<script type="text/javascript">	

var jq = jQuery.noConflict();

function confirmDisp(){
	
	var msg = jq("input[name=alarmmsgs]").val();

	var condition = jq("select[name=alarmconditions]").val();

	var priority = jq("select[name=priority]").val();

	var tempName = jq("input[name=tempName]").val();

	var devicename = jq("input[name=devicename]").val();

	var deviceip = jq("input[name=deviceip]").val();

	var typeid = jq("select[name=typeid]").val();

	if(typeid == "novalue"){
		alert("请指定设备类型！");
		return false;
	}

	if(devicename.trim() == ""){
		alert("设备名称不能为空！");
		return false;
	}

	if(deviceip.trim() == ""){
		alert("设备ip不能为空！");
		return false;
	}

	if(tempName.trim() == ""){
		alert("模板名称不能为空！");
		return false;
	}

	if(priority == "" && condition == "0"){
		alert("条件和级别不能同时为空 ！");
		return false;
	}

	if(msg == "" && condition != "0"){
		alert("告警内容不能为空！");
		return false;
	}

	if(parseInt(jq("input[name=maxalarmtime]").val().trim()) > 1440){
		jq("input[name=maxalarmtime]").focus();
		alert("分钟数不能超过1440！");
		return false;
	}

	if(parseInt(jq("input[name=maxalarmnum]").val().trim()) > 100){
		jq("input[name=maxalarmnum]").focus();
		alert("最大重复告警数不能超过100！");
		return false;
	}

	window.close();
	return true;
}
</script>
<body>
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="formwrapper">
<html:form styleId="form"
	action="/IGLOG00022_Insert_Fast" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	
	<fieldset>
	<legend>告警规则录入</legend>
	<div>
		<label for="Name"><strong><span class="red">*</span>模板名称</strong>：</label> 
		<html:text property="tempName"  errorStyleClass="inputError imeDisabled" /> 
	</div>
	<div>
		<label for="Name"><strong><span class="red">*</span>设备名称</strong>：</label> 
		<html:hidden property="deviceid" value="${IGLOG0022VO.mss00001TB.deviceid}"/>
		<html:text property="devicename" errorStyleClass="inputError imeDisabled"  value="${IGLOG0022VO.mss00001TB.devicename}"/> <br/>
	</div>
	<div>
		<label for="Name"><strong><span class="red">*</span>设备类型</strong>：</label> 
		<html:select property="typeid" style="width: 85px;" errorStyleClass="inputError" tabindex="4" value="${IGLOG0022VO.mss00001TB.typeid}">
           <html:option value="novalue">尚未指定</html:option>
           <ig:optionsCollection ccid="SYSLOG_DEVICETYPE" isMakeBlankRow="false" isCodeLabel="true"/>
    	</html:select>
	</div>	
	<div>
		<label for="Name"><strong><span class="red">*</span>单网卡IP</strong>：</label> <html:text
		property="deviceip"  errorStyleClass="inputError imeDisabled"  value="${IGLOG0022VO.mss00001TB.deviceip}"/> 
	</div>
	<div>
		<label for="Name"><strong>&nbsp;双网卡IP</strong>：</label> 
		<html:text property="deviceip2"  errorStyleClass="inputError imeDisabled"  value="${IGLOG0022VO.mss00001TB.deviceip2}"/>
	</div>
	<div>
		<label for="Name"><strong><span class="red">*</span>级别</strong>：</label>
        <html:select property="priority" style="width: 110px;" errorStyleClass="inputError" value="${IGLOG0022VO.priority}">
       		<ig:optionsCollection ccid="SYSLOGALARM_PRIORITY" isMakeBlankRow="true" isCodeLabel="true" />
        </html:select>
	</div>
	<div>
		<label for="Name"><strong><span class="red">*</span>条件</strong>：</label>
    	<html:select property="alarmconditions" styleId="alarmconditions" style="width: 110px;" errorStyleClass="inputError" value="1" >
      	    <html:option value="0">没有条件</html:option>
		    <html:option value="1" >包含</html:option>
		    <html:option value="2">等于</html:option>
        </html:select>
    </div>
    <div>
    	<label for="Name"><strong><span class="red">*</span>告警内容</strong>：</label>
    	<html:textarea rows="6" cols="50" property="alarmmsgs" errorStyleClass="inputError imeActive" value="${IGLOG0022VO.alarmmsg}" styleId="alarmmsgs${index}" />
    </div>
	<div><label for="Name"><strong>&nbsp;告警抑制</strong>：</label>
		当<html:text property="maxalarmtime"  errorStyleClass="inputError imeActive" />分钟内发生
		<html:text property="maxalarmnum"  errorStyleClass="inputError imeActive" />次告警时，发送一次告警信息<br />
	</div>
	<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" /> 
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
	</fieldset>
	
</html:form></div>
</div>
</div>
<div class="zishiying"></div>


</div>
</body>
</html:html>
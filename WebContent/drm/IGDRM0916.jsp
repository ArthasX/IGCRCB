<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0916" toScope="request"/>
<bean:define id="title" value="应急处置dashboard" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript" src="js/swfobject.js"></script>
<body>
<div style="width: 953px; height: 140px; margin:0 auto;">
	<input type="hidden" id="prrXML" value="${flowCharXml}"/> 
	<div id="drmDashBoard" style="margin-left: 0px;">
		
	</div>
</div>
</body>
<script type="text/javascript">
var swfVersionStr = "11.1.0";
var xiSwfUrlStr = "playerProductInstall.swf";
var flashvars = {};
var params = {};
params.quality = "high";
params.bgcolor = "#ffffff";
params.allowscriptaccess = "sameDomain";
params.allowfullscreen = "true";
var attributes = {};
params.wmode = "opaque";
attributes.id = "drmDashBoardSWF";
attributes.name = "drmDashBoardSWF";
attributes.align = "middle";
swfobject.embedSWF("images/drmswf/emergcmd_ruler.swf", "drmDashBoard", "953", "140", swfVersionStr, xiSwfUrlStr,flashvars, params, attributes);
swfobject.createCSS("#drmDashBoard", "display:block;text-align:left;");



function getJSONData(type){
	var result="";
	//6,获取实时跟踪信息
	jQ.ajax({
		url:getAppRootUrl()+"/IGDRM0912_Json.do?prid=${prid}&type="+type,
		async:false,
		dataType:"text",
		success:function(data){
			result = data;
		}
	});
	return result;
}

//流程开始时间
function getStartTimeData(showType){
	return getJSONData(8);
}
//流程已用时
function getUseTimeData(showType){
	return getJSONData(9);
}
//停止时间
function getStopTimeData(showType){
	return getJSONData("overTime");
}

//流程图
function getFlowData(showType){
	return getJSONData("emergencyFlow");
}


//获取流程ID函数
function getPridJSFunc(){
	return '${prid}';
}
//获取Port端口号和IP函数
function getSocketInfo(){
 	return '192.168.0.154'+":"+'${port}';

// 	 	return '${ip}'+":"+'${port}';
}

//获取流程图信息
function getFlowChartData(){
	return jQ("#prrXML").val();
}
//得到是否为终止状态
function getPrstatus(){
	return '${stopProcess}';
}
function printLog(msg){
	(console&&console.log)&&(console.log(msg));
}
</script>
</html:html>
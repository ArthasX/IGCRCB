<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0913" toScope="request"/>
<bean:define id="title" value="应急处置dashboard-组合场景" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript" src="js/swfobject.js"></script>
<body>
<div style="width: 1024px; height: 768px; margin:0 auto;">
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
swfobject.embedSWF("images/drmswf/gsence.swf", "drmDashBoard", "100%", "100%", swfVersionStr, xiSwfUrlStr,flashvars, params, attributes);
swfobject.createCSS("#drmDashBoard", "digetFlowChartDatasplay:block;text-align:left;");



function getJSONData(type,flowId){
	var result="";
	//6,获取实时跟踪信息
	var curprid = '${prid}';
	if(flowId&&""!=flowId){
		curprid = flowId;
	}
	
	jQ.ajax({
		url:getAppRootUrl()+"/IGDRM0913_Json.do?prid="+curprid+"&type="+type,
		async:false,
		dataType:"text",
		success:function(data){
			result = data;
		}
	});
	
	return result;
}
//获取流程图信息-str7
function getFlowChartData(){
	return jQ("#prrXML").val();
}
//流程开始时间-str4
function getStartTimeData(showType){
	return getJSONData(14);
}
//流程图状态 0：已执行 1：正在执行 2：未执行- 15
function strImageState(showType){
	return getJSONData(15);
}
//组合场景实例流程已用时
function getUseTimeData(showType){
	return getJSONData(16);
}
//应急处置--组-发布信息
function getPostMessageData(showType){
	return getJSONData(17);
}
//应急处置--组-实时跟踪
function getTrackerData(showType){
	return getJSONData(18);
}
//实时跟踪-获取当前流程信息
function getTrackerTabData(showType){
	return getJSONData(19);
}
//实时跟踪-节点按钮
function getGroupProcessRecordList(){
	return getJSONData(20);
}
//获取流程组关闭节点信息
function getTerminateMsgFunc(){
	return getJSONData(21); 
}

//应急指挥--流程图
function getFlowNodeListData(showType){
	return getJSONData(2);
}
//应急指挥--应急组织
function getEmergencyOrganizationData(showType){
	return getJSONData(3);
}
//应急指挥-事件信息
function getEmergencyEventData(showType){
	return getJSONData(4);
}
//应急指挥--应急预案
function getEmergencyPlanData(showType){
	return getJSONData(5);
}
//应急指挥-进度
function getEmergencyProgressData(showType){
	return getJSONData(7);
}

//获取流程ID函数
function getPridJSFunc(){
	return '${prid}';
}
//获取流程组是否已关闭函数
function getPrStatusFunc(){
	return '${prstatus}';
}
//获取Port端口号和IP函数
function getSocketInfo(){
	//return '192.168.1.64'+":"+'${port}';
 	return '${ip}'+":"+'${port}';
}
function printLog(msg){
	//console.log(msg);
}
</script>
</html:html>
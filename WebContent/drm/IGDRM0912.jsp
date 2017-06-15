<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0912" toScope="request"/>
<bean:define id="title" value="应急处置dashboard" toScope="request"/>

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
swfobject.embedSWF("images/drmswf/sence_igcrcb.swf", "drmDashBoard", "100%", "100%", swfVersionStr, xiSwfUrlStr,flashvars, params, attributes);
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
//新流程图

//流程开始时间
function getStartTimeData(showType){
	return getJSONData(8);
}
//流程已用时
function getUseTimeData(showType){
	return getJSONData(9);
}
//应急指挥--发布信息
function getPostMessageData(showType){
	return getJSONData(6);
}
//停止时间
function getStopTimeData(showType){
	return getJSONData("stopTime");
}
//基本信息
function getBaseMsgData(showType){
	return getJSONData("baseMsg");
}

//流程图
function getFlowData(showType){
	return getJSONData("flowMsg");
}

function getLogMsgData(showType){
	return getJSONData("logMsg");
}





// //应急指挥--实时跟踪
// function getTrackerData(showType){
// 	return getJSONData(1);
// }
// //应急指挥--流程图
// function getFlowNodeListData(showType){
// 	return getJSONData(2);
// }
// //应急指挥--应急组织
// function getEmergencyOrganizationData(showType){
// 	return getJSONData(3);
// }
// //应急指挥-事件信息
// function getEmergencyEventData(showType){
// 	return getJSONData(4);
// }
// //应急指挥--应急预案
// function getEmergencyPlanData(showType){
// 	return getJSONData(5);
// }

// //应急指挥-进度
// function getEmergencyProgressData(showType){
// 	return getJSONData(7);
// }

// //流程图状态
// function strImageState(showType){
// 	return getJSONData(10);
// }
// //实时跟踪-节点按钮
// function getTrackerTabData(showType){
// 	return getJSONData(11);
// }
//获取流程ID函数
function getPridJSFunc(){
	return '${prid}';
}
//获取Port端口号和IP函数
function getSocketInfo(){
//  	return '192.168.0.154'+":"+'${port}';
	 	return '${ip}'+":"+'${port}';
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
function openSOCDetail(id,eiid){
	var url = "IGDRM0430_Disp.do?flag=open&id="+id+"&eiid="+eiid;
	window.showModalDialog(url,null,"dialogWidth:1100px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
</script>
</html:html>
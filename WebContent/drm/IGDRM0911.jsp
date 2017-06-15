
<%@page import="com.deliverik.framework.utility.ResourceUtility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0911" toScope="request"/>
<bean:define id="title" value="应急指挥Dashboard" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript" src="js/swfobject.js"></script>
<body>
<div style="width: 1024px; height: 768px; margin:0 auto;">
	<div id="drmDashBoard" style="margin-left: 0px;">
	</div>
</div>
</body>
<script type="text/javascript">
jQ(function(){
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
swfobject.embedSWF("images/drmswf/emergcmd.swf", "drmDashBoard", "100%", "100%", swfVersionStr, xiSwfUrlStr,flashvars, params, attributes);
swfobject.createCSS("#drmDashBoard", "display:block;text-align:left;");
})




//获取初始化信息方法分5个分别是'1'获取实时追踪日志信息、'2'获取流程状态信息列表、'3'获取就位人员信息、'4'获取事件信息、'5'获取预案资产信息

//'3'获取就位人员信息
function getJSONData(prid,showType){
// 	jQuery.log("调用查询type:"+showType);
	prid = getPridJSFunc();
	var res = "";
	jQuery.ajax({
		url:getAppRootUrl()+"/IGDRM0911_GETJSONDATA.do?prid="+prid+"&showType="+showType,
		async: false, 
		cache:false,
		dataType:"text",
		success:function(data){
				try{
					res = data;
				} catch(err){
					setTimeout("getJSONData()", 5000);
				}
		}
	});
	return res;
}
//应急指挥--实时跟踪
function getTrackerData(prid,showType){
	return getJSONData(prid,1);
}
//应急指挥--流程图
function getFlowNodeListData(prid,showType){
	return getJSONData(prid,2);
}
//应急指挥--应急组织
function getEmergencyOrganizationData(prid,showType){
	return getJSONData(prid,3);
}
//应急指挥-事件信息
function getEmergencyEventData(prid,showType){
	return getJSONData(prid,4);
}
//应急指挥--应急预案
function getEmergencyPlanData(prid,showType){
	return getJSONData(prid,5);
}
//应急指挥--发布信息
function getPostMessageData(prid,showType){
	return getJSONData(prid,6);
}
//应急指挥-进度
function getEmergencyProgressData(prid,showType){
	return getJSONData(prid,7);
}
//流程开始时间
function getStartTimeData(prid,showType){
	return getJSONData(prid,8);
}
//流程已用时
function getUseTimeData(prid,showType){
	return getJSONData(prid,9);
}
//应急资源
function getSocData(prid,showType){
	return getJSONData(prid,22);
}
//获取系统当前时间
function getSystemTime(prid,showType){
	return getJSONData(prid,"systemTime");
}


//获取流程ID函数
function getPridJSFunc(){
	return '${prid}';
}
//获取Port端口号和IP函数
function getSocketInfo(){
// 	return '192.168.1.154'+":"+'${port}';
	return '${ip}'+":"+'${port}';
}
//打开应急处置流程dashboard
function openRestoryWindow(cldprid){
	//应急指挥prid
	var curPrid = '${prid}';
	var cldtype = "1";
	jQuery.ajax({
		url:getAppRootUrl()+"/IGDRM0911_GETTYPE.do?curPrid="+curPrid,
		type:"POST",
		dataType:"text",
		async:false,
		success:function(result){
			cldtype = result;
		}
	});
	//组合场景
	if("0"==cldtype){
		//应急场景流程prid
		var url = getAppRootUrl()+"/IGDRM0913.do?prid="+cldprid+"&cldtype="+cldtype;
		this.subWindow = window.open(url, '应急处置Dashboard', 'width=1024, height=768, scrollbars=no, resizable=no, status=no, top=0, left=1024').focus();	
	}else{
		//应急场景流程prid
		var url = getAppRootUrl()+"/IGDRM0912.do?prid="+cldprid+"&cldtype="+cldtype;
		this.subWindow = window.open(url, '应急处置Dashboard', 'width=1024, height=768, scrollbars=no, resizable=no, status=no, top=0, left=1024').focus();
	}
	

}

/**
 *打开应急组织架构大屏 
 */
 function openRestoryZZWindow(){
	 var url ="/IGCOM0202.do?linkID=IGDRM1007&actname=ACT29DRM0104";
	 window.openSubWindow(url,"_blank", 1050, 600);
}
/**
 * 查看应急资源详细信息
 */
function openSOCDetail(id,eiid){
	var url = "/IGDRM0430_Disp.do?flag=open&id="+id+"&eiid="+eiid;
	window.openSubWindow(url,"组织架构关系图", 1010, 760);
}
var msg,speed,msgud;
jQuery(function(){
// 	getJSONData(1539,'sdfs');
});
var bsmUrl = '<%=ResourceUtility.getString("BSM_DashBorad_URL") %>';
/**
 *打开BSM弹出页面 
 */
 function openRestoryBSMWindow(){
	 window.open(bsmUrl, 'BSM配置管理', 'width=1920, height=1080,scrollbars=yes,resizable=yes,status=yes,resizable=yes,top=0,left=0').focus();
}
</script>
</html:html>
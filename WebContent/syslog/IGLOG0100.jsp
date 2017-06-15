<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<link href="styles/baobiao.css" rel="stylesheet" type="text/css" />
<bean:define id="id" value="IGLOG0100" toScope="request" />
<bean:define id="title" toScope="request">
	设备日志信息
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">
function initReport(){
	var tabNum=1;
	setTab("Alarm",tabNum,2);
}

function setTab(name,cursel,total){
	var AlarmContext = document.getElementById("AlarmContext");
	if(cursel == 1){
		AlarmContext.src="IGLOG0101_Search.do?isRealTimeCollect=2";
	}else if(cursel == 2){
		AlarmContext.src="IGLOG0102_Search.do?isRealTimeCollect=2";
	}
	for(var i=1;i<=total;i++){
		var menu=document.getElementById(name+i);
		menu.className=i==cursel?"hover":"";
	}
}
</script>
<body onload="initReport()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" /> 
<!--container 左菜单 右侧内容-->
	<div id="container" style="margin-top: 10px;background-color: transparent"><!--content  右侧内容-->
	<div class="Menubox">
      <ul>
    	<!-- 实时设备日志 -->
    	<li id="Alarm1" onClick="setTab('Alarm',1,2)">实时设备日志</li>
    	<!-- 历史设备日志 -->
    	<li id="Alarm2" onClick="setTab('Alarm',2,2)">历史设备日志</li>
      </ul>
    </div>
    <div class="Contentbox">
    	<iframe id="AlarmContext" src="" width="1002" height="715" marginheight="0" marginwidth="0" scrolling="auto" frameborder="0" align="middle">
    	
    	</iframe>
    	
 	</div>
	</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>
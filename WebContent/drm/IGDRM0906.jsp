<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0906" toScope="request"/>
<bean:define id="title" value="组合场景处置信息" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<script type="text/javascript" src="js/swfobject.js"></script>
<style type="text/css">
	.title{
		width:100%;
		text-align: left;
	}
</style>
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<%-- <jsp:include page="/include/header2.jsp" /> --%>
<!--container 左菜单 右侧内容-->
<div id="container">

    <!--content  右侧内容-->
    <div id="contentWrap">
		   <div id="formwrapper">
		   <logic:notEmpty name="IGDRM09061VO" property="groupProcessRecord">
			   <bean:define id="prInfo" name="IGDRM09061VO" property="groupProcessRecord"></bean:define>
				<div class="title">
					<div class="name">基本信息</div>
				</div>
				<div class="record_list">
					<TABLE class=table_style1 cellSpacing=2>
						<TR style="DISPLAY: none">
							<TH width="15%"></TH>
							<TD width="35%"></TD>
							<TH width="15%"></TH>
							<TD width="35%"></TD>
						</TR>
						<tr>
							<th>
								<label for="Name"><STRONG>工单号：</STRONG></label>
							</th>
							<td>${prInfo.pgrserialnum }</td>
							<th>
								<label for="Name"><STRONG>状态：</STRONG></label>
							</th>
							<td>
								<logic:empty name="prInfo" property="pgrclosetime">恢复中</logic:empty>
								<logic:notEmpty name="prInfo" property="pgrclosetime">关闭</logic:notEmpty>
							</td>
						</tr>
						<tr>
							<th>
								<label for="Name"><STRONG>发起人：</STRONG></label>
							</th>
							<td >${prInfo.pgrusername }</td>
							<th>
								<label for="Name"><STRONG>发起时间：</STRONG></label>
							</th>
							<td >${prInfo.pgropentime }</td>
						</tr>
						<tr>
							<th>
								<label for="Name"><STRONG>事件标题：</STRONG></label>
							</th>
							<td colspan="3">${prInfo.pgrtitle }</td>
						</tr>
					</TABLE>
				
				</div>
		   </logic:notEmpty>
		   <logic:empty name="IGDRM09061VO" property="groupProcessRecord">
		   		<bean:define id="prInfo" name="IGDRM09061VO" property="processList[0]" ></bean:define>
		   		<div class="title">
					<div class="name">基本信息</div>
				</div>
				<div class="record_list">
					<TABLE class=table_style1 cellSpacing=2>
						<TR style="DISPLAY: none">
							<TH width="15%"></TH>
							<TD width="35%"></TD>
							<TH width="15%"></TH>
							<TD width="35%"></TD>
						</TR>
						<tr>
							<th>
								<label for="Name"><STRONG>工单号：</STRONG></label>
							</th>
							<td>${prInfo.prserialnum }</td>
							<th>
								<label for="Name"><STRONG>状态：</STRONG></label>
							</th>
							<td>
								<logic:empty name="prInfo" property="prclosetime">恢复中</logic:empty>
								<logic:notEmpty name="prInfo" property="prclosetime">关闭</logic:notEmpty>
							</td>
						</tr>
						<tr>
							<th>
								<label for="Name"><STRONG>发起人：</STRONG></label>
							</th>
							<td >${prInfo.prusername }</td>
							<th>
								<label for="Name"><STRONG>发起时间：</STRONG></label>
							</th>
							<td >${prInfo.propentime }</td>
						</tr>
						<tr>
							<th>
								<label for="Name"><STRONG>事件标题：</STRONG></label>
							</th>
							<td colspan="3">${prInfo.prtitle }</td>
						</tr>
					</TABLE>
				
				</div>
		   </logic:empty>
		   
		   
		    <div class="title">
				<div class="name">流程图</div>
			</div>
				<input type="hidden" value="${IGDRM09061VO.groupProcessRecordXML}" id="FlowXML">
				<input type="hidden" value="${IGDRM09061VO.xmlHeight }" id="xmlheight"/>
			<div id="flowChartBox" style=" border:1px solid #A2CBF3; width:100%;height:${IGDRM09061VO.xmlHeight}px;">
				<div id="flashContent">
				<p>
		            To view this page ensure that Adobe Flash Player version 
		            11.1.0 or greater is installed. 
		        </p>
		        <script type="text/javascript"> 
		            var pageHost = ((document.location.protocol == "https:") ? "https://" : "http://"); 
		            document.write("<a href='http://www.adobe.com/go/getflashplayer'><img src='" 
		                            + pageHost + "www.adobe.com/images/shared/download_buttons/get_flash_player.gif' alt='Get Adobe Flash player' border='0'/></a>" ); 
		        </script>
		        </div> 
			</div>
			
			
			<logic:present name="IGDRM09061VO" property="noticeList">
				<div class="title">
					<div class="name">日志信息</div>
				</div>
				<div>
					<TABLE class=table_style2 style="WIDTH: 880px; MARGIN-LEFT: 30px" borderColor=#cccccc border=1>
						<TR>
							<TH width="15%">状态</TH>
							<TH width="15%">部门</TH>
							<TH width="40%">内容</TH>
							<TH width="10%">处理人</TH>
							<TH width="10%">操作</TH>
							<TH width="10%">处理时间</TH>
						</TR>
						<logic:iterate id="bean" name="IGDRM09061VO" property="noticeList">
							<tr>
								<td>${bean.psname } </td>
								<td>${bean.rlorgname }</td>
								<td>${bean.rlcomment }</td>
								<td>${bean.rlusername }</td>
								<td>${bean.rldesc }</td>
								<td>${bean.rltime }</td>
							</tr>
						</logic:iterate>
					</TABLE>
				</div>
			</logic:present>
    </div>
</div>
</div>
<script type="text/javascript">	

function initFlowChart(){
	var xml = document.getElementById("FlowXML").value;
	return xml;
}
function initFlowChartWidth(){
	return 0;
}
function initFlowChartHeight(){
	return document.getElementById("xmlheight").value;	
}
function initFlowChartCanMove(){
	return false;
}

function getChild(psdid){
	var prid = document.getElementById("prid").value;
	//设置请求的Action
	igAjax.ajaxAction = "/IGPRR0111_Ajax.do";
	//是否异步    false：同步    true：异步
	igAjax.asynchronous = false;
	//提交方式    "POST"    "GET"
	igAjax.method = "POST";
	//参数列表
	igAjax.parameters = {
		"psdid":psdid,
		"prid":prid
	};
	var xml = "";
	//回调函数
	igAjax.back = function(req, json){
		 var result=req.responseText;
		 if(result != null && result != ""){
			 xml = result;
		 };
	};
	//执行
	igAjax.doAjax();
	return xml;
}
var swfVersionStr = "11.1.0";
var xiSwfUrlStr = "playerProductInstall.swf";
var flashvars = {};
var params = {};
params.quality = "high";
params.bgcolor = "#ffffff";
params.allowscriptaccess = "sameDomain";
params.allowfullscreen = "true";
var attributes = {};
attributes.id = "flashContent";
attributes.name = "flashContent";
attributes.align = "middle";
swfobject.embedSWF("flowswf/FlowChart.swf", "flowChartBox", "100%", "100%",
    swfVersionStr, xiSwfUrlStr, 
    flashvars, params, attributes  );
swfobject.createCSS("#flashContent", "display:block;text-align:left;");
</script>
</body>
</html:html>
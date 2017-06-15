<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGPRD0202" toScope="request" />
<bean:define id="title" value="流程信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function initFlowChart(){
	var xml = document.getElementById("FlowXML").value;
	return xml;
}
function initFlowChartWidth(){
	return 0;
}
function initFlowChartHeight(){
	return ${IGPRD02021VO.flowChartHeight };
}
function initFlowChartCanMove(){
	return false;
}
function getChild(psdid){
	//设置请求的Action
	igAjax.ajaxAction = "/IGPRR0111_Ajax.do";
	//是否异步    false：同步    true：异步
	igAjax.asynchronous = false;
	//提交方式    "POST"    "GET"
	igAjax.method = "POST";
	//参数列表
	igAjax.parameters = {
		"psdid":psdid
	};
	var xml = "";
	//回调函数
	igAjax.back = function(req, json){
		 var result=req.responseText;
		 if(result != null && result != ""){
			 xml = result;
		 }
	};
	//执行
	igAjax.doAjax();
	return xml;
}
function enlarge(step){
	document.getElementById("flowChartBox").style.height = (parseInt(document.getElementById("xmlheight").value) + parseInt(step)) + "px";
}
function restore(){
	document.getElementById("flowChartBox").style.height = document.getElementById("xmlheight").value + "px";
}
</script>
<body>
<div id="location">
<div class="image"></div>
<p class="fonts1">流程信息</p>
</div>
<div id="formwrapper"><!--  message --> <ig:message /> <!--  /message -->
<logic:present name="IGPRD02021VO">
<div class="title">
	<div class="name">流程图</div>
</div>
<div id="flowChartBox" style="height:${IGPRD02021VO.flowChartHeight }px;">
	<input type="hidden" value="${IGPRD02021VO.flowChartXML}" id="FlowXML" >
	<input type="hidden" value="${IGPRD02021VO.flowChartHeight }" id="xmlheight"/>
	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="100%" height="100%"
			codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" 
			id="flowChartContent">
          <param name="movie" value="flex/FlowChart.swf" />
          <param name="wmode" value="Opaque" />
	</object>
</div>
<div class="title">
	<div class="name">流程信息</div>
</div>
<div style="width:98%;margin-left:auto;margin-right:auto;">
	<table class="table_style">
		<tr>
			<th width="5%">序号</th>
			<th width="10%">操作周期（分）</th>
			<th width="15%">任务简称</th>
			<th width="20%">任务描述</th>
			<th width="10%">执行团队</th>
			<th width="10%">团队成员</th>
			<th width="10%">前置任务</th>
			<th width="20%">附件</th>
		</tr>
		<logic:present name="IGPRD02021VO" property="voList">
			<logic:iterate id="vo" name="IGPRD02021VO" property="voList">
				<tr>
					<td width="5%">${vo.serial }</td>
					<td width="10%">${vo.handlingTime }</td>
					<td width="15%">${vo.processStatusDefinition.psdname }</td>
					<td width="20%">${vo.processStatusDefinition.psddesc }</td>
					<td colspan="2" width="20%">
						<logic:present name="vo" property="participantMap">
						<table border="0" style="width:100%">
							<logic:iterate id="map" name="vo" property="participantMap">
								<bean:size id="usersize" name="map" property="value"/>
									<c:if test="${usersize == 0 }">
										<tr style="border:none;">
											<td style="border:none;width:50%;">${map.key.rolename }</td>
											<td style="border:none;width:50%;">
											</td>
										</tr>
									</c:if>
									<c:if test="${usersize > 0 }">
										<logic:iterate id="user" name="map" property="value" indexId="idx">
											<tr style="border:none;">
												<c:if test="${idx == 0 }">
													<td rowspan="${usersize }" style="border:none;width:50%;">${map.key.rolename }</td>
												</c:if>
												<td style="border:none;width:50%;">${user.username }</td>
											</tr>
										</logic:iterate>
									</c:if>
							</logic:iterate>
						</table>
						</logic:present>
					</td>
					<td width="10%">${vo.prepositionTaskSerial }</td>
					<td width="20%">
						<logic:present name="vo" property="attList">
							<table border="0">
								<logic:iterate id="att" name="vo" property="attList">
									<tr style="border:none;">
										<td style="border:none;">
											<html:link action="downloadSvcFile.do?attId=${att.attid}&type=svc">
												<bean:define id="attname" name="att" property="attname" />
												<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
											</html:link>
										</td>
									</tr>
								</logic:iterate>
							</table>
						</logic:present>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
</div>
</logic:present>
</div>
</body>
</html>


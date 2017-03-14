<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGPRR0111" toScope="request" />
<bean:define id="title" value="流程图信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<script>
var tempPdid = 0;
</script>
<script src="<html:rewrite forward='context.js'/>"  ></script>
<script src="<html:rewrite forward='webflow.js'/>" charset="gb2312" language="JavaScript"></script>
<script src="<html:rewrite forward='function.js'/>"></script>
<script src="<html:rewrite forward='shiftlang.js'/>" ></script>
<script src="<html:rewrite forward='movestep.js'/>"></script>
<script type="text/javascript">
function initFlowChart(){
	var xml = document.getElementById("FlowXML").value;
	return xml;
}
function initFlowChartWidth(){
	return 0;
}
function initFlowChartHeight(){
	return ${IGPRR01111VO.xmlheight };
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
<style>

html{
overflow-x:auto;
overflow-y:auto;

}

</style>
<body>


<html:form action="/IGPRR0111_Disp" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程图</p>
	
	</div>
	<div id="formwrapper"><!--  message --> <ig:message /> <!--  /message -->
	<input type="hidden" value="${IGPRR01111VO.flowChartXml}" id="FlowXML" >
	<input type="hidden" value="${IGPRR01111VO.xmlheight }" id="xmlheight"/>
	<div id="flow">
		<table cellspacing="0" cellpadding="0" class="panel_style" align="center" >
		<tr>
		<td width="100%" style="height:${IGPRR01111VO.xmlheight}px;" id="flowChartBox">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="100%" height="100%"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" id="flowChartContent">
          <param name="movie" value="flex/FlowChart.swf" />
          <param name="wmode" value="Opaque" />
      </object>
		</td>
		</tr>			
		</table>
	</div>
	</div>
</html:form>
</body>
</html>


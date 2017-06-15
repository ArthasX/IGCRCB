<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<%@page import="java.util.List"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGDRM0702" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<jsp:include page="/include/header1.jsp" />

<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<script src="<html:rewrite forward='context.js'/>"  ></script>
<script src="<html:rewrite forward='webflow.js'/>" charset="gb2312"></script>
<script src="<html:rewrite forward='function.js'/>"></script>
<script src="<html:rewrite forward='shiftlang.js'/>" ></script>
<script src="<html:rewrite forward='movestep.js'/>"></script>
<style>
html{
overflow-x:auto;
overflow-y:auto;
}

</style>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript" src="js/tableform.js"></script>

<link rel="stylesheet" type="text/css" href="css/select2/select2.min.css">
<script type="text/javascript" src="js/select2/select2.full.js"></script>
<script type="text/javascript" src="js/select2/i18n/es.js"></script>

<script type="text/javascript">
var formFileArr = new Array();
var assetFormArr = new Array();
function initAttFormFile(){
	var str = '<ig:navigation />';
	if(str != ''){
		document.getElementById("daohang").innerHTML = str + "&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;";
	}
	if(formFileArr.length > 0){
		for(var i=0;i<formFileArr.length;i++){
			addSingleFileMuti(formFileArr[i]);
		}
	}
	if(assetFormArr.length > 0){
		for(var k=0;k<assetFormArr.length;k++){
			var params = assetFormArr[k].split("_");
			addSingleEntity(params[0],params[1],params[2],params[3],params[4]);
		}
	}
	<logic:present name="IGPRR01021VO" property="processStatusDef">
	<bean:define id="processStatusDef" name="IGPRR01021VO" property="processStatusDef"/>
	<logic:notEmpty name="processStatusDef" property="jsfunction">
		${processStatusDef.jsfunction}();
	</logic:notEmpty>
	</logic:present>
}


var arr_pididObj = new Array();
var arr_pidlabelObj = new Array();
//定义表单全路径实体对象
function pidObj(pidid, pidlabel, pididPar) {
	this.pidid = pidid;
	this.pidlabel = pidlabel;
	this.pidlabelFull = null;
	if(pididPar) {
		this.pididPar = pididPar;
	} else {
		this.pididPar = null;
	}
}
//通用表单
<logic:present name="IGPRR01021VO" property="processInfoDefmap">
<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
<logic:present name="psid">
	arr_pididObj['${pidid}'] = new pidObj('${psid.pidid}', '${psid.pidlabel}');
</logic:present>
</logic:iterate>
</logic:present>
//递归拼接表单名全路径
function getFullPidlabel(pidid) {
	var obj = arr_pididObj[pidid];
	if(!obj) return "";
	if(obj.pididPar) {
		return getFullPidlabel(obj.pididPar) + "#" + obj.pidlabel;
	} else{
		return obj.pidlabel;
	}
}
//将表单全路径赋予实体
for(var obj in arr_pididObj) {
	if(arr_pididObj[obj] instanceof pidObj) {
		arr_pididObj[obj].pidlabelFull = getFullPidlabel(obj);
	}
}
//填充表单全路径集合
for(var obj in arr_pididObj) {
	if(arr_pididObj[obj] instanceof pidObj) {
		arr_pidlabelObj[arr_pididObj[obj].pidlabelFull] = obj;
	}
}
//根据表单名获取通用表单控件
function getFormObj(pidlabel) {
	return $("pidid" + arr_pidlabelObj[pidlabel]);
}
//取得表格行号
function getTableRownum(obj,tableFlag){
	var rownum = "";
	var rownums = null;
	if("1" == tableFlag){
		var thisTD = obj.parentElement;
		var tb = obj.parentElement.parentElement.parentElement;
		if(tb.rows[0].name == "titlerow"){
			if(tb.rows.length > 2){
				rownums = tb.rows[2].cells[thisTD.cellIndex].childNodes;
			};
		}else{
			if(tb.rows.length > 1){
				rownums = tb.rows[1].cells[thisTD.cellIndex].childNodes;
			};
		};
	}else{
		var thisTD = obj.parentElement;
		var tr = thisTD.parentElement;
		if(tr.cells.length > thisTD.cellIndex + 1){
			rownums = tr.cells[thisTB.cellIndex + 1].childNodes;
		};
	}
	if(rownums != null && rownums.length > 0){
		for(var i=0;i<rownums.length;i++){
			if(rownums[i].name == "column_rownumber"){
				rownum = rownums[i].value;
			};
		};
	}
	return rownum;
}

//=====组装表单全路径集合开始
var arr_pididObj = new Array();
var arr_pidlabelObj = new Array();
//定义表单全路径实体对象
function pidObj(pidid, pidlabel, pididPar) {
	this.pidid = pidid;
	this.pidlabel = pidlabel;
	this.pidlabelFull = null;
	if(pididPar) {
		this.pididPar = pididPar;
	} else {
		this.pididPar = null;
	}
}
//递归拼接表单名全路径
function getFullPidlabel(pidid) {
	var obj = arr_pididObj[pidid];
	if(!obj) return "";
	if(obj.pididPar) {
		return getFullPidlabel(obj.pididPar) + "#" + obj.pidlabel;
	} else{
		return obj.pidlabel;
	}
}
//表格式表单的子表单
<logic:present name="AD_columnInfoMap">
<logic:iterate id="map" name="AD_columnInfoMap" indexId="index" >
<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
<bean:define id="lst_psid" name="map" property="value" type="java.util.List" />
<logic:iterate id="psid" name="lst_psid" indexId="index" >
if("rawdef" == "${pidid}"){
	arr_pididObj['${psid.pidid}']= new pidObj('${psid.pidid}', '${psid.pidlabel}');
}else{
	arr_pididObj['${psid.pidid}']= new pidObj('${psid.pidid}', '${psid.pidlabel}', '${pidid}');
}
</logic:iterate>
</logic:iterate>
</logic:present>
//将表单全路径赋予实体
for(var obj in arr_pididObj) {
	if(arr_pididObj[obj] instanceof pidObj) {
		arr_pididObj[obj].pidlabelFull = getFullPidlabel(obj);
	}
}
//填充表单全路径集合
for(var obj in arr_pididObj) {
	if(arr_pididObj[obj] instanceof pidObj) {
		arr_pidlabelObj[arr_pididObj[obj].pidlabelFull] = obj;

	}
}
//根据表单名获取通用表单控件
function getFormObj(pidlabel) {
	return $("pidid" + arr_pidlabelObj[pidlabel]);
}
//根据表单名获取表格式表单中的子表单表单控件
function getTableFormObj(pidlabel, rownumber) {
//		return $(arr_pidlabelObj[pidlabel] + "_" + obj.rownumber);
		return $(arr_pidlabelObj[pidlabel] + "_" + rownumber);
}
//根据表单名获取表格式表单中的check子表单的所有选项对象
function getTableFormCheckBox(pidlabel, rownumber){
	var obj = getTableFormObj(pidlabel, rownumber);
	var arr = new Array();
	if(obj != null){
		var spans = obj.parentElement.childNodes;
		if(spans != null && spans.length > 0){
			for(var i=0;i<spans.length;i++){
				var checks = spans[i].childNodes;
				if(checks != null && checks.length > 0){
					for(var k=0;k<checks.length;k++){
						if(checks[k].type == "checkbox"){
							arr[arr.length] = checks[k];
						};
					};
				};
			};
		};
	}
	return arr;
}

//根据表单名获取常规表单中的选项对象
function getFormCheckBox(pidlabel){
    var obj = getFormObj(pidlabel);
    var arr = new Array();
    if(obj != null){
        var spans = obj.parentElement.childNodes;
        if(spans != null && spans.length > 0){
            for(var i=0;i<spans.length;i++){
                var checks = spans[i].childNodes;
                if(checks != null && checks.length > 0){
                    for(var k=0;k<checks.length;k++){
                        if(checks[k].type == "checkbox"){
                            arr[arr.length] = checks[k];
                        };
                    };
                };
            };
        };
    }
    return arr;
}

//将表格式表单的复选框变为只读或可写
function disableTableCheckBox(objs,flag){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			objs[i].disabled = flag;
			if(flag){
				objs[i].checked = false;
				getTarget(objs[i].parentElement).value = "";
				//清空“其他”并设置为只读
				var showvalue = getShowTarget(objs[i].parentElement);
				showvalue.value = "";
				showvalue.style.display="none";
			};
		};
	};
}

//将常规表单的复选框变为只读或可写
function disableCheckBox(objs,flag){
    if(objs != null && objs.length > 0){
        for(var i=0;i<objs.length;i++){
            objs[i].disabled = flag;
            if(flag){
                objs[i].checked = false;
                //清空“其他”并设置为只读
                var showvalue = getNomalShowTarget(objs[i]);
                if (showvalue !=null){
	                showvalue.value = "";
	                showvalue.style.display="none";
                };
            };
        };
    };
}

//根据表单名获取表格式表单中的子表单表单控件集合
function getTableFormObjs(pidlabel) {
	var arr_objs = new Array();
	var j = 0;
	var inputs = document.getElementsByTagName("INPUT");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].id && inputs[i].id.indexOf(arr_pidlabelObj[pidlabel] + "_") > -1) {
			arr_objs[j++] = inputs[i];
		};
	}
	inputs = document.getElementsByTagName("TEXTAREA");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].id && inputs[i].id.indexOf(arr_pidlabelObj[pidlabel] + "_") > -1) {
			arr_objs[j++] = inputs[i];
		};
	}
	return arr_objs;
}

//根据表单名获取单附件
function getSingalFileObj(pidlabel, rownumber) {
	var obj;
	if(rownumber) {
		obj = getTableFormObj(pidlabel, rownumber);
	} else {
		obj = getFormObj(pidlabel);
	}
	//return obj.parentElement.childNodes[0].childNodes[0].childNodes[0].childNodes[0].childNodes[1];
	var temps =  obj.parentElement.childNodes[0].rows[0].cells[0].childNodes;
	var returnObj = null;
	for(var i=0;i<temps.length;i++){
		if(temps[i].type == "file"){
			returnObj = temps[i];
			break;
		};
	}
	return returnObj;
}

//取得附件类型表单的文本框对象
function getSingalFileTextObj(pidlabel, rownumber) {
	var obj;
    if(rownumber) {
        obj = getTableFormObj(pidlabel, rownumber);
    } else {
        obj = getFormObj(pidlabel);
    }
    var temps =  obj.parentElement.childNodes[0].rows[0].cells[0].childNodes;
    var returnObj = null;
    for(var i=0;i<temps.length;i++){
        if(temps[i].type == "text"){
            returnObj = temps[i];
            break;
        };
    }
    return returnObj;
}

//取得文本域div
function getEditDiv(obj){
    return obj.parentElement.childNodes[0];
}

function toback(type){

		window.parent.location.href = getAppRootUrl() + '/IGCOM0202.do?linkID=IGFXK0000&actname=ACT03FXK';
	
}
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
function enlarge(step){
	document.getElementById("flowChartBox").style.height = (parseInt(document.getElementById("xmlheight").value) + parseInt(step)) + "px";
}
function restore(){
	document.getElementById("flowChartBox").style.height = document.getElementById("xmlheight").value + "px";
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
</script>
<script type="text/javascript">
<!--
	jQuery(document).ready(function(){
		jQuery(".rlcomment").click(function(){
			removeShowRlComment();
			var $value = jQuery(this).find("[name='rlShowValue']").val();
			if($value){
				var event = window.event;
				//新激活图层
			    var newDiv = document.createElement("div");
			    newDiv.id = "rlshowvaluediv";
			    newDiv.style.top = (event.clientY + document.documentElement.scrollTop) + "px";
			    newDiv.style.left = (parseInt(document.body.scrollWidth) - 340) / 2 + "px"; // 屏幕居中
			    var str = "<div id='title'><div id='fountDiv'>处理记录</div><div id='imgDiv' onclick='removeShowRlComment();'><img src='images/title-delete.gif' width='20' height='20'/></div></div>";
			    newDiv.innerHTML = str + "<div id='content'><pre>" + $value + "</pre></div>";
			    document.body.appendChild(newDiv);   
			}
		});
	});
	function removeShowRlComment(){
		if(jQuery("#rlshowvaluediv").length > 0){
			jQuery("#rlshowvaluediv").remove();
		}
	}
//-->
</script>
<style type="text/css">
.rlcomment{cursor: hand;}
#rlshowvaluediv{
	word-wrap:break-word;
	position:absolute;
	z-index: 9999;
	width: 400px;
	min-height: 50px;
	background-color: #eee;
	border:1px solid #ccc;
}
#rlshowvaluediv #title{
	width:395px;
	height:23px;
	line-height:23px;
	font-weight: bold;
	background:url(images/title-23.gif);
	padding-left:5px;
}
#rlshowvaluediv #title #fountDiv{
	width:100px;
	height:23px;
	float: left;
}
#rlshowvaluediv #title #imgDiv{
	width:30px;
	height:23px;
	float: right;
	padding-top:3px;
	cursor: hand;
}
#rlshowvaluediv #content{
	width:395px;
	padding:5px;
	line-height: 20px;
}
</style>
<body onload="initAttFormFile();initFlowChart();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<jsp:include page="/drm/IGDRM0707.jsp"/>	
<jsp:include page="/drm/IGDRM0135.jsp" />
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRR0102" styleId="form"
	onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
	<span id="daohang"></span>流程信息（${IGPRR01021VO.process.prpdname}——<ig:processDefineTypeValue prid="${IGPRR01021VO.process.prid}"/>）
	</p>
 	<ig:ProcessBackUrlTag jump="${IGPRR0102Form.jump}"/>
    </div>
	<div id="formwrapper"><!--  message --> <ig:message /> <!--  /message -->
	<div class="title">
	<div class="name">流程图</div>
	</div>
	<div id="flowChartBox" style="width:100%;height:${IGPRR01021VO.xmlheight}px;">
		<input type="hidden" value="${IGPRR01021VO.flowChartXml}" id="FlowXML">
		<input type="hidden" value="${IGPRR01021VO.xmlheight }" id="xmlheight"/>
		<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" id="flowChartContent">
          <param name="movie" value="flex/FlowChart.swf" />
          <param name="wmode" value="Opaque" />
      </object>
	</div>
	<jsp:include page="/prr/IGPRR0136.jsp"/>
	<logic:present name="IGPRR01021VO">
	<logic:equal name="IGPRR01021VO" property="hid" value="1">
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
		<div class="record_list">
		<table cellspacing="2" class="table_style1">
			<tr style="display:none">
				<th width="15%"></th><td width="35%"></td><th width="15%"></th><td width="35%">
				<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
				<input type="hidden" id="addTableColumnFileStr" name="addTableColumnFileStr" value=""/>
				<input type="hidden" id="delTableColumnFileStr" name="delTableColumnFileStr" value=""/>
				</td>
			</tr>
			<jsp:include page="/prr/IGPRR0105.jsp"></jsp:include>
		</table>
		</div>
	</logic:present>
	</logic:equal>
	</logic:present>
	</div>
	
	<logic:present name="IGPRR01021VO" property="voList">
	<bean:size id="number" name="IGPRR01021VO" property="voList"/>
	<c:if test="${number > 0}">
	<div class="record_list" style="width:98%;margin-left:auto;margin-right:auto;">
		<div class="title">
	    	<div class="name">相关流程</div>
	    </div> 
	    <table cellspacing="2" class="table_style">
	    	<tr>
               <th width="20%">工单号</th>
               <th width="15%">流程名称</th>
               <th width="15%">流程类型</th>
               <th width="15%">发起时间</th>
               <th width="15%">状态</th>
               <th width="15%">处理人</th>
            </tr>
           	<logic:iterate id="element" name="IGPRR01021VO" property="voList">
           		<bean:define id="bean" name="element" property="info"/>
           		<tr>
                    <td>
          				<logic:equal value="P" name="element" property="type">
          					<img src="images/parentProcess.gif" align="middle" alt="主流程"/>
          				</logic:equal>
          				<logic:equal value="C" name="element" property="type">
          					<img src="images/childProcess.gif" align="middle" alt="子流程"/>
          				</logic:equal>
          				&nbsp;&nbsp;
	                    <a href="javascript:void(0)" onclick="openRelatedProcess('${bean.prid}','${bean.prtype}')">
	                    ${bean.prserialnum} </a>
                    </td>
                    <td>${bean.prtitle}</td>
                    <td>${bean.prpdname}</td>
                    <td>${bean.propentime}</td>
                    <td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
                    <td><ig:processDisposePersonValue prid="${bean.prid}" prstatus="${bean.prstatus}"/></td>
                </tr>
           	</logic:iterate>
	    </table>
	</div>
	</c:if>
</logic:present>
	<logic:present name="IGPRR01021VO" property="recordLogMap">
	<logic:equal name="IGPRR01021VO" property="hasCLRecord" value="1">
	<div class="title">
	<div class="name" onclick="tabbedPanel()" style="cursor: pointer;">日志信息<img id="loginfo" src="images/addd.gif" width="10" height="10" border="0"/>
	</div>
	</div>
	
	        <div id="TabbedPanels1" class="TabbedPanels" style="display:none;">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
			<c:if test="${map.key=='处理类日志'}">
				<li class="TabbedPanelsTab" tabindex="0" id="${map.key}" >
					${map.key}
				</li>
			</c:if>
			</logic:iterate>
		</ul>
		<div class="TabbedPanelsContentGroup">
		    <logic:present name="IGPRR01021VO">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap" indexId="number">
				<c:if test="${map.key=='处理类日志'}">
				<bean:define id="logList" name="map" property="value" type="java.util.List" />
				<div class="TabbedPanelsContent">
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<tr>
						<th width="15%">状态</th>
						<th width="15%">部门</th>
						<th width="40%">内容</th>
						<th width="10%">处理人</th>
						<th width="10%">操作</th>
						<th width="10%">处理时间</th>
					</tr>
				</table>
				</div>
				<div>
				<table class="table_style2" style="width:880px;margin-left:30px" border="1" bordercolor="#cccccc">
					<logic:iterate id="recordLog" name="logList" indexId="index" >	
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<td width="15%">${recordLog.psname}</td>
							<td width="15%">${recordLog.rlorgname}</td>
							<td width="40%" align="left" class="rlcomment">
							<pre><ig:SubstringShowEllipsisWriteTag len="100" showEllipsis="true"><bean:write name="recordLog" property="rlcomment" filter="false" /></ig:SubstringShowEllipsisWriteTag></pre>
							<textarea style="display:none;" rows="6" cols="60" name="rlShowValue">${recordLog.rlcomment }</textarea>
							<logic:present name="recordLog" property="attachmentList">
									<logic:notEmpty	name="recordLog" property="attachmentList">
										<bean:define id="attachmentList" name="recordLog" property="attachmentList" type="java.util.List" />
										<logic:iterate id="attachment" name="attachmentList" indexId="number">
											<html:link
												action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
												<bean:define id="attname" name="attachment" property="attname" />
												<%= attname.toString().substring(attname.toString().indexOf("_")+1) %>
											</html:link>
											<br />
										</logic:iterate>
									</logic:notEmpty>
							</logic:present>
							</td>
							<td width="10%">${recordLog.rlusername}</td>
							<td width="10%">${recordLog.rldesc}</td>
							<td width="10%"><SPAN class="red">${recordLog.rltime}</SPAN></td>
						</tr>
					</logic:iterate>
				</table>
				</div>
			</div>
			</c:if>
			</logic:iterate>
			</logic:present>
		</div>
		</div>
		<script type="text/javascript">
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			function tabbedPanel(){
				var path=jQuery("#loginfo").attr("src");
				if(path=="images/redu.gif"){
					jQuery("#loginfo").attr("src","images/addd.gif");
					jQuery("#TabbedPanels1").toggle();
				}else{
					jQuery("#loginfo").attr("src","images/redu.gif");
					jQuery("#TabbedPanels1").toggle();
				}
				
				//bullet_delete.png
				//////jQuery("#TabbedPanels1").hide();
			}
			//-->
		</script>
	</logic:equal>
	</logic:present>

	<logic:present name="IGPRR01021VO">
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<logic:notEqual value="#" name="IGPRR01021VO" property="status">
	<div class="title">
	<div class="name">处理记录</div>
	</div>
	<div class="record_list" style="width:98%;margin-left:auto;margin-right:auto;">
	<fieldset>
		<div>
		<html:textarea property="rlcomment" cols="60" errorStyleClass="inputError imeActive" rows="6"></html:textarea> <br />
<!-- 		<div class="editDiv" style="width:440px;min-height:85px;" contenteditable="true" onkeydown="editDivContent(this);" onblur="getProcessRlcommentValue(this);"> -->
<!-- 		</div> -->
		</div>
		<html:hidden property="rlcomment" styleId="rlcomment" name="IGPRR0102Form"/>
		<div><img src="images/attachment.gif" />
		<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;
		<table id="tb">
		</table>
		</div>
	</fieldset>
		</div>
	</logic:notEqual>
	</logic:notEqual>
	</logic:present>
<%-- 	</logic:notEqual> --%>
	<div id="formwrapper">
	<div class="enter">
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<logic:notEqual value="#" name="IGPRR01021VO" property="status">
		<div class="action">
			<img src="images/gengxin.gif" width="16" height="16" />
			<a href="###" onclick="checkForm('<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES %>','<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_NO %>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">保存</a>
		</div>
	</logic:notEqual>
	</logic:notEqual>
	<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:iterate id="bean" name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		  <c:if test="${bean.vbid != '02' && bean.vbid != '05' && bean.vbid != '06' && bean.vbid != '07'}">
			<div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
				<a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" onclick="checkForm('${bean.vbrequired}','${bean.vbrecord}','${bean.vbid}','${bean.vbid}','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">${bean.vbname}</a>
			</div>
		  </c:if>
		  <c:if test="${bean.vbid == '02'}">
		  	<div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
				<a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" onclick="affirm('${bean.vbrequired}','${bean.vbrecord}','${bean.vbid}','${bean.vbid}','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">${bean.vbname}</a>
			</div>
		  </c:if>
		  <c:if test="${bean.vbid == '05'}">
		    <div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
              <logic:equal name="IGPRR01021VO" property="isMoreRelevantProcess" value="1">
                  <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
                onclick="showChooseProcessPage('${IGPRR01021VO.process.prid}','${IGPRR01021VO.process.prtype}','${IGPRR0102Form.pdid}','${IGPRR0102Form.psdid}','${IGPRR01021VO.roleid}','','IGPRR0102_Disp.do?prid=${IGPRR01021VO.process.prid}')">${bean.vbname}</a>
              </logic:equal>
              <logic:notEqual name="IGPRR01021VO" property="isMoreRelevantProcess" value="1">
                  <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
                onclick="showInitProcessPage('${IGPRR01021VO.process.prid}','${IGPRR01021VO.relevantPdid}','','IGPRR0102_Disp.do?prid=${IGPRR01021VO.process.prid}')">${bean.vbname}</a>
              </logic:notEqual>
            </div>
		  </c:if>
		  <c:if test="${bean.vbid == '06'}">
		    <div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
              <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
              onclick="javascript:openSubIGKGM0206Parm('selectDisp=0&prid=${IGSVC0206Form.prid}');">${bean.vbname}</a>
            </div>
		  </c:if>
		  <c:if test="${bean.vbid == '07'}">
		    <div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
              <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="IGPRR0114_Disp.do?prid=${IGPRR01021VO.process.prid}">${bean.vbname}</a>
            </div>
		  </c:if>
		</logic:iterate>
	</logic:present>
	<jsp:include page="/prr/IGPRR0108.jsp"></jsp:include>
	</div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0102Form" />
	<html:hidden property="parprid" styleId="parprid" name="IGPRR0102Form" />
	<html:hidden property="parameters" styleId="pdid" name="IGPRR0102Form" />
	<html:hidden property="prid" styleId="prid" name="IGPRR0102Form" />
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0102Form" />
	<html:hidden property="action" styleId="action" name="IGPRR0102Form" />
	<html:hidden property="isInit" styleId="isInit" name="IGPRR0102Form" />
	<html:hidden property="pts" styleId="pts" name="IGPRR0102Form" />
	<html:hidden property="log_type" styleId="log_type" name="IGPRR0102Form" />
	<html:hidden property="tempRoleManager" styleId="tempRoleManager" name="IGPRR0102Form" />
	<html:hidden property="people_code" styleId="people_code" name="IGPRR0102Form" />
	<html:hidden property="psdmode_code" styleId="psdmode_code" name="IGPRR0102Form" />
	<html:hidden property="pieids" value=""/>
	<html:hidden property="roleid" styleId="roleid" name="IGPRR0102Form" />
	<html:hidden property="assign_orgsyscoding" styleId="assign_orgsyscoding" name="IGPRR0102Form" />
	<html:hidden property="eiorgcode" styleId="eiorgcode" name="IGPRR0102Form" />
</html:form></div>
<iframe id="iframe1" name="iframe1" width="0px" height="0px" onload="relevantProcess(${IGPRR01021VO.isMoreRelevantProcess})"></iframe>
</div>
</div>
</div>
<script>
var pdid = jQ("#pdid").val();
jQ(function($) {
	//场景参与人隐藏
 	//jQ("#pidid"+pdid+"023").parent().parent().attr("style","display:none;");
	if(jQ("#psdid").val() != pdid + '001'){
		//场景参与人table
		var $table = jQ("#"+pdid+"023_tableForm")[0];
		//第一行
		var $firstTr = jQ($table).find("tr").eq(0);
		var $firstTd = jQ($firstTr).find("th:first");
		//在之前添加一列checkbox,初始化 不可编辑
		$firstTr.prepend("<th><input type=\"checkbox\" id=\"checkall\" onclick=\"checkAll(this)\" disabled=\"true\"></th>");
		$firstTr.find("th").eq(3).attr("style","display:none;");
		$firstTr.find("th").eq(4).attr("style","display:none;");
		$firstTr.find("th").eq(5).attr("style","display:none;");
		
		//获取第二行第一列是否存在值，有值则回显，无则隐藏
		var $tvalue = $("#"+pdid+"023_tableForm > tbody > tr:eq(1) td:first").find("input[name='column_value']").val();
		if($tvalue){
			var pidaccess = $("#pidid"+pdid +"023").parent().find("input[name='pidaccess']").val();
			if(pidaccess == '2'){
				
				jQ("#"+pdid+"023_tableForm > tbody > tr > th:first").remove();
				
				var trlen = $("#"+pdid+"023_tableForm > tbody > tr").length;
				for(var tri = 1;tri < trlen; tri++){
					 var $tr = jQ("#"+pdid+"023_tableForm > tbody > tr").eq(tri);
					 //5
					 var $td5 = $tr.find(">td:eq(2)").attr("style","display:none;");
					 //6
					 var $td6 = $tr.find(">td:eq(3)").attr("style","display:none;");
					 //7
					 var $td7 = $tr.find(">td:eq(4)").attr("style","display:none;");
				 }
			}else{
				var trlen = $("#"+pdid+"023_tableForm > tbody > tr").length;
				for(var tri = 1;tri < trlen; tri++){
					 var $tr = jQ("#"+pdid+"023_tableForm > tbody > tr").eq(tri);
					 var psdid = $tr.find("> td:eq(4)").find("input[name='column_value']").val();
					 $tr.attr("id",psdid);
					 //第一列
					 $tr.prepend("<td><input type=\"checkbox\" name=\"checkbox\" value=\""+psdid+"\" onclick=\"checkone(this)\"></td>");
					 
					 //第二列 节点名称
					 var $td2 = $tr.find("> td:eq(1)");
					 var $td2text = $td2.find("input[name='column_value']").val();
					 $td2.prepend($td2text);
					 $td2.find("input[name='column_value']").attr("style","display:none;");
					 
					 //3 参与人
					 var $td3 = $tr.find(">td:eq(2)");
					 $td3.attr("style","padding:5px;");
					 var $td3Html = $td3.find("input[name='column_value']").val();
					 $td3.prepend($td3Html);
					 $td3.find("input[name='column_value']").attr("style","display:none;");
					 
					 //5
					 var $td5 = $tr.find(">td:eq(3)").attr("style","display:none;");
					 //6
					 var $td6 = $tr.find(">td:eq(4)").attr("style","display:none;");
					 //7
					 var $td7 = $tr.find(">td:eq(5)").attr("style","display:none;");
				 }
				//************全选按钮是否可编辑*********
	 			checkisDisabled();
			}
		}else{
			//第二行
	 		$table&&$table.deleteRow(1);
		}
		//查看权限
		if( '${IGPRR01021VO.lst_ParticipantVisibleButtonVWInfo}' == '' 
			|| '${IGPRR01021VO.lst_ParticipantVisibleButtonVWInfo}' == [] 
			|| '${IGPRR01021VO.lst_ParticipantVisibleButtonVWInfo}' == '[]' ) {
			//jQ("#"+pdid+"023_tableForm > tbody > tr td:first").each(function(){jQuery(this).remove()});
		}else{
			if(jQ("#psdid").val() == pdid + '003'){
				jQ("#"+pdid+"023_tableForm").after("<button class=\"buttonCX2\" style=\"padding:2px;\" onclick=\"adjustUser()\">调整参与人</button>");
			}else{
				jQ("#"+pdid+"023_tableForm > tbody > tr").each(function(){
					jQuery(this).children(":first").remove();
				});
			}
		}
	}
			
	jQ("#assetSelector"+pdid+"013").on("change",function(){
		var val = jQ("#assetSelector"+pdid+"013").val();
		jQ("#entity"+pdid+"013").val(val);
		jQ("#pidid"+pdid+"013").val("N/A");
		
		jQ("#"+pdid+"023_tableForm tr th input[type='checkbox']").each(function(){this.checked = false;});
		//清空表格数据
		jQ("#"+pdid+"023_tableForm tr:not(:first)").remove("tr");
		var pidValue = jQ("#entity"+pdid+"013").val();
		//查询场景关联流程的参与人信息
		jQ.ajax({
			type: "post",  
			dataType:'json',  
			url:"IGDRM0702_AjaxUser.do",
			data:{sp_eiid:pidValue.split("#")[1],cid:'CI600000001004',eiversion:pidValue.split("#")[2]},
			success: function(data){
				var i=0;
				for(var key in data){
					i++;
					var psdid = data[key].psdid;
					var psdname = data[key].psdname;
					var userrole = data[key].userrole;
					
					var $tr = jQ("<tr id=\""+psdid+"\"></tr>");
					$tr.appendTo($table);
					
					//checkbox
					var $td1 = jQ("<td></td>");
					$td1.html("<input type=\"checkbox\" name=\"checkbox\" value=\""+psdid+"\" onclick=\"checkone(this)\">");
					$td1.appendTo($tr);
					//节点名称
					var id2 = pdid+"024_" + i;
					var $td2 = jQ("<td></td>");
					$td2.html(psdname+"<input type=\"hidden\" name=\"column_value\" id=\""+id2+"\" rownumber=\""+i+"\" value=\""+psdname+"\">"
								+"<input name=\"column_pidid\" type=\"hidden\" value=\""+pdid+"024\">"
								+"<input name=\"column_rownumber\" type=\"hidden\" value=\""+i+"\">");
					
					$td2.appendTo($tr);
					//参与人
					var $td3 = jQ("<td></td>");
					//调整后的用户id
					var $td5 = jQ("<td></td>");
					//调整后的角色id
					var $td6 = jQ("<td></td>");
					
					$td3.appendTo($tr);
					$td5.appendTo($tr);
					$td6.appendTo($tr);
					
					$td3.attr("style","text-align:center;padding:2px;");
					
					$td5.attr("style","display:none;");
					$td6.attr("style","display:none;");
					
					//创建表格
					var $tabChild = jQ("<table class=\"table_form\" style=\"width:100%\">");
					$td3.append($tabChild);
					
					var roleuser = new Array();
					var roleids = new Array();
					
					for(var rolekey in userrole){
						var value = userrole[rolekey];
						if(value){
							var roleid = value.roleid;
							var rolename = value.rolename;
							var userinfo = value.userinfo;
							
							//创建行
							var $trcld1 = jQ("<tr></tr>");
							$trcld1.appendTo($tabChild);
							//创建列
							var $tdcld1 = jQ("<td style=\"width:30%;padding:3px;text-align:right;\"></td>");
							var $tdcld2 = jQ("<td style=\"width:70%;padding:3px;text-align:left;\"></td>");
							
							$tdcld1.appendTo($trcld1);
							$tdcld2.appendTo($trcld1);
							
							
							var roleuserinfo = "";
							var userinfoAry = new Array();
							var usernameAry = new Array();
							
							roleuserinfo = roleid + "#" + rolename + "_role_";
							
							roleids.push(roleid);
							
							for(var k=0; k<userinfo.length;k++){
								var user = userinfo[k];
								var userid = user["userid"];
								var username = user["username"];
								
								if(userid){
									usernameAry.push(username);
									userinfoAry.push(userid + "#" + username);
								}
							}
							
							$tdcld1.text(rolename+"：");
							$tdcld2.text(usernameAry.join(","));
							
							roleuserinfo += userinfoAry.join("_user_");
							roleuser.push(roleuserinfo);
						}
					}
					var id3 = pdid+"025_"+i;
					$td3.append("<input type=\"hidden\" name=\"column_value\" id=\""+id3+"\" rownumber=\""+i+"\" value='<table class=\"table_form\" style=\"width:100%\">"+$tabChild.html()+"</table>'>"
								+"<input name=\"column_pidid\" type=\"hidden\" value=\""+pdid+"025\">"
								+"<input name=\"column_rownumber\" type=\"hidden\" value=\""+i+"\">");
				
					 //隐藏值
					 $td5.append("<input type=\"hidden\" name=\"column_value\" id=\""+pdid+"026_"+i+"\" rownumber=\""+i+"\" value='"+roleids.join(",")+"'>"
								+"<input name=\"column_pidid\" type=\"hidden\" value=\""+pdid+"026\">"
								+"<input name=\"column_rownumber\" type=\"hidden\" value=\""+i+"\">");
					
					//隐藏值
					 $td6.append("<input type=\"hidden\" name=\"column_value\" id=\""+pdid+"027_"+i+"\" rownumber=\""+i+"\" value='"+roleuser.join("_roleuser_")+"'>"
								+"<input name=\"column_pidid\" type=\"hidden\" value=\""+pdid+"027\">"
								+"<input name=\"column_rownumber\" type=\"hidden\" value=\""+i+"\">");
					
					//节点id
					var id7 = pdid+"028_" + i;
					var $td7 = jQ("<td></td>");
					$td7.appendTo($tr);
					$td7.html("<input type=\"hidden\" name=\"column_value\" id=\""+id7+"\" rownumber=\""+i+"\" value=\""+psdid+"\">"
								+"<input name=\"column_pidid\" type=\"hidden\" value=\""+pdid+"028\">"
								+"<input name=\"column_rownumber\" type=\"hidden\" value=\""+i+"\">");
					$td7.attr("style","display:none;");
					
				
				}	
				//全选按钮
				checkisDisabled();
			}
		});
	});
	
	jQ("#assetSelector"+pdid+"010").on("change",function(){
		//专项预案
		var val = jQ("#assetSelector"+pdid+"010").val();
		
		if(!val){
			if(jQ("#entity"+pdid+"010").attr("eiid")){
				val = jQ("#entity"+pdid+"010").attr("eiid");
			}
		}else{
			jQ("#entity"+pdid+"010").val(val);
			jQ("#pidid"+pdid+"010").val("N/A");
		}
		
		jQ("#pidid"+pdid+"016").val(val.split("#")[1]);
		
		//清空下拉值
		jQ("#assetSelector"+pdid+"013").empty();		
		//清空表格数据
		jQ("#"+pdid+"023_tableForm tr th input[type='checkbox']").each(function(){this.checked = false;});
		jQ("#"+pdid+"023_tableForm tr:not(:first)").remove("tr");
		
		jQ("#select2-assetSelector"+pdid+"013-container").html("");	
		jQ("#entity"+pdid+"013").val("");
		jQ("#pidid"+pdid+"013").val("");
		
		//资产id
		var eiid = val.split("#")[1];
		
		if(eiid){
			jQ.ajax({  
				type: "post",  
				url:"IGDRM0702_Ajax.do",
		       	cache:false,  
		       	dataType:'json',  
		       	data:{pidid:pdid+"013",esyscoding:'999060',sp_eiid:eiid,scenceCategory:"1"},
		       	success: function(data){
		       		if(data.length > 0){
		       			jQ("#assetSelector"+pdid+"013").select2({
			       			 data:data,
			       			 placeholder:'请选择'
		       			}).trigger("change");
					}
				}  
			});
		}
	});
});


var allcheckEdit = true;

//初始化表格后，判断全选按钮是否可编辑
function checkisDisabled(){
	//获取其中一个节点的参与人角色
	var $roleTd = jQ("#"+pdid+"023_tableForm > tbody > tr:eq(1) > td:eq(3)");
	var roleval = $roleTd.find("input[name='column_value']").val();
	var trlen = jQ("#"+pdid+"023_tableForm > tbody > tr").length;
	//编辑
	var checkFlag = true;
	for(var i=1;i<trlen;i++){
		var $tri = jQ("#"+pdid+"023_tableForm > tbody > tr").eq(i);
		var $tdi = $tri.find(">td:eq(3)");
		var cval = $tdi.find("input[name='column_value']").val();
		
		var returnflag = compareObj(cval,roleval);
		
		if(returnflag == false){
			checkFlag = false;
			break;
		}
	}
	if(checkFlag){
		jQ("#checkall").attr("disabled",false);
		allcheckEdit = false;
	}else{
		jQ("#checkall").attr("disabled",true);
	}
}


//业务系统
function entityChange(){
	var eiidary = new Array();
	jQ("#tbentity"+pdid+"021").find("input[name^='entityId']").each(function(){
		if(jQ(this).val()){
			eiidary.push(jQ(this).val().split("#")[1].split("_")[1]);
		}
	});
	if(jQ("#pidid"+pdid+"021").parent().find("a[asm='"+pdid+"021']")){
		jQ("#pidid"+pdid+"021").parent().find("a[asm='"+pdid+"021']").each(function(){
			var eiid = jQ(this).attr("eiid");
			if(eiid){
				eiidary.push(eiid)
			}
		});
	}
	//清空原有的值
	jQ("#assetSelector"+pdid+"013").empty();		
	jQ("#assetSelector"+pdid+"010").empty();		
	jQ("#select2-assetSelector"+pdid+"010-container").html("");		
	jQ("#select2-assetSelector"+pdid+"013-container").html("");	
	jQ("#entity"+pdid+"013").val("");
	jQ("#entity"+pdid+"010").val("");	
	jQ("#pidid"+pdid+"010").val("");	
	jQ("#pidid"+pdid+"013").val("");
	//专项预案id                                                           
	jQ("#pidid"+pdid+"016").val("");
	//清空表格数据
	jQ("#"+pdid+"023_tableForm tr th input[type='checkbox']").each(function(){this.checked = false;});
	jQ("#"+pdid+"023_tableForm tr:not(:first)").remove("tr");
	
	if(eiidary != null && eiidary.length > 0){
		jQ.ajax({  
			type: "post",  
			url:"IGDRM0702_Ajax.do",
	       	cache:false,  
	       	dataType:'json',  
	       	data:{pidid:pdid+"010",esyscoding:'888001',sp_eiid:eiidary.join(",")},
	       	success: function(data){
	       		if(data.length > 0){
	       			jQ("#assetSelector"+pdid+"010").select2({
		       			 data:data,
		       			 placeholder:'请选择'
	       			}).trigger("change");
				}
			}  
		});
	}
}
//调整参与人
function adjustUser(){
	var len = jQ("#"+pdid+"023_tableForm tr td input[type='checkbox']:checked").length;
	if(len <= 0){
		alert("请选择要调整参与人的节点！");
		return ;
	}
	var checkone = jQ("#"+pdid+"023_tableForm tr td input[type='checkbox']:checked").eq(0);
	var $tdi = jQ(checkone).parent().parent().find(">td:eq(3)");
	var cval = $tdi.find("input[name='column_value']").val();
	openSubWindow('/IGDRM0702_AdjustUser.do?roleids='+cval, '', '960', '600');
}
//全选
function checkAll(obj){
	var checked = obj.checked;
	jQ("#"+pdid+"023_tableForm tr td input[type='checkbox']").not("[disabled='disabled']").each(function(){
		this.checked = checked;
	});
}

function checkone(obj){
	var checked = obj.checked;
	//判断当前选中的长度
	var len = jQ("#"+pdid+"023_tableForm tr td input[type='checkbox']:checked").length;
	if(checked){
		//1为 自己本身
		if(len == 1){
			var trindex = jQ(obj).parent().parent()[0].rowIndex;
			//全选按钮可选
			jQ("#checkall").attr("disabled",false);
			//相同角色可选
			var $roleTd = jQ(obj).parent().parent().find(" > td:eq(3)");
			var roleval = $roleTd.find("input[name='column_value']").val();
			
			//遍历，不同的则不可编辑
			jQ("#"+pdid+"023_tableForm > tbody > tr:not(:first)").each(function(i,e){
				//
				var $ctd = jQ(e).find(" > td:eq(3)");
				var cval = $ctd.find("input[name='column_value']").val();
				var returnflag = compareObj(cval,roleval);
				if(returnflag == false){
					jQ(e).find("td:first input[type='checkbox']").attr("disabled",true);
				}
			}); 
		}
		//else 存在其他选中，不做任何操作
	}else{
		//没有选中的，则所有都改为可选
		if(len == 0){
			//全选按钮不可选
			jQ("#checkall").attr("disabled",allcheckEdit);
			//其他按钮可选
			jQ("#"+pdid+"023_tableForm tr td input[type='checkbox']").each(function(){
				jQ(this).attr("disabled",false);
			});
			
			
		}
		//有选中的不做操作
	}
}

function compareObj(val1,val2){
	var obj1 = val1.split(",");
	var obj2 = val2.split(",");
	if(obj1.length != obj2.length){
		return false;
	}else{
		var returnFlag = true;
		for(var j in obj1){
			var equlaFlag = true;
			for(var k in obj2){
				if(obj1[j] == obj2[k]){
					equlaFlag = false;
					break;
				}
			}
			if(equlaFlag){
				returnFlag = false;
				break;
			}
		}
		return returnFlag;
	}
}

function setUserParam(objs,roleids,resultObj){
	 
	jQ("#"+pdid+"023_tableForm tr td input[type='checkbox']:checked").each(function(){
		
		 var psdid = jQ(this).val();
		 //列
		 var $thisTd3 = jQ("#"+psdid+" > td:eq(2)");
		 var $table = $thisTd3.find(">table>tbody");
		 var $childtd1 = $table.find(">tr>td:first");
		 var $childtd2 = $table.find(">tr>td:eq(1)");
		//设置显示部分的页面内容
		 $table.empty();
		 for(var k in resultObj){
			 $table.append("<tr></tr>");
			 $table.find("tr:last").append($childtd1.clone().empty().text(k+"：").get(0).outerHTML);
			 $table.find("tr:last").append($childtd2.clone().empty().text(resultObj[k]).get(0).outerHTML);
		 }
		 $thisTd3.find("input[name='column_value']").val("<table class=\"table_form\" style=\"width:100%\">"+$thisTd3.find(">table").html()+"</table>");
		 
		 jQ("#"+psdid+" > td:eq(3) input[name='column_value']").val(roleids);
		 //第5列装载人员和角色信息
		 jQ("#"+psdid+" > td:eq(4) input[name='column_value']").val(objs.join("_roleuser_"));
	});
}
var rightMenu = function(obj,e){
	
}
function currentLoad(){}
</script>
</body>
</html>
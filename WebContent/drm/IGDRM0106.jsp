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
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01021VO"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGDRM0106" toScope="request" />
<bean:define id="title" value="场景修订" toScope="request" />
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
<script type="text/javascript" src="js/process.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/tableform.js"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
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
	
	//获取流程图编辑器
	getFlowManger();
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
<body onload="initAttFormFile();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<jsp:include page="/prr/IGPRR0107.jsp"/>	
<jsp:include page="/prr/IGPRR0135.jsp" />
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
<!-- 	<div class="title"> -->
<!-- 	<div class="name">流程图</div> -->
<!-- 	</div> -->
<%-- 	<div id="flowChartBox" style="width:100%;height:${IGPRR01021VO.xmlheight}px;"> --%>
<%-- 		<input type="hidden" value="${IGPRR01021VO.flowChartXml}" id="FlowXML"> --%>
<%-- 		<input type="hidden" value="${IGPRR01021VO.xmlheight }" id="xmlheight"/> --%>
<!-- 		<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742" -->
<!-- 		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" id="flowChartContent"> -->
<!--           <param name="movie" value="flex/FlowChart.swf" /> -->
<!--           <param name="wmode" value="Opaque" /> -->
<!--       </object> -->
<!-- 	</div> -->
	<jsp:include page="/prr/IGPRR0136.jsp"/>
	<div id="showFlow"></div>
	<div id="flowContainer1" ></div>
	<div id="stautsInfoContainer" style="margin-left: 10px;margin-bottom: 10px;width:950px;">
		<div class="title" style="width:950px;">
			<div class="name" >场景信息 <img border=0 style='width:11px;height:11px;' id=openTableImg src='images/addd.gif' /></div>
		</div>
		
		<div id="stautsInfoDiv">
			<table class="table_style" id="stautsInfo">
			</table>
		</div>
	</div>
	<div style="height:5px;"></div>
	<div class="title">
		<div class="name">场景信息</div>
	</div>
	
	<logic:present name="IGPRR01021VO">
	<logic:equal name="IGPRR01021VO" property="hid" value="1">
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
		<div class="record_list"   style="margin-left: 8px;" >
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
	<!-- 相关流程Include页，可显示相关流程的更多信息 -->
	<bean:define id="relevantProcessJsp" name="IGPRR01021VO" property="relevantProcessJsp" type="java.lang.String" />
	<jsp:include page="${relevantProcessJsp}"/>
<%-- 	<logic:notEqual name="disp" value="none"> --%>
	<logic:present name="IGPRR01021VO">
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<logic:notEqual value="#" name="IGPRR01021VO" property="status">
	<div class="title">
	<div class="name">处理记录</div>
	</div>
	<div class="record_list" style="width:98%">
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
<%-- 		<div class="action" style="cursor:pointer;" onclick="checkForm('<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES %>','<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_NO %>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')"> --%>
<!-- 			<img src="images/gengxin.gif" width="16" height="16" /> -->
<!-- 			<a href="###">保存</a> -->
<!-- 		</div> -->
	</logic:notEqual>
	</logic:notEqual>
	<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:iterate id="bean" name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		  <c:if test="${bean.vbid != '02' && bean.vbid != '05' && bean.vbid != '06' && bean.vbid != '07'&& bean.vbid != '01'}">
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
</body>
<script type="text/javascript">
//单一场景定义流程
jQuery(function(){
	//当前单一场景定义流程pdid
	var pdid = jQuery("#pdid").val();
	//场景应急处置步骤
	var jStepPdid = jQuery("#pidid"+pdid+"004");
	jStepPdid.parent().parent().hide();
	//是否已演练
	var jIsPlan = jQuery("#pidid"+pdid+"005");
	jIsPlan.parent().parent().hide();
	//应急资源资产
	//var jSouEiid = jQuery("#pidid"+pdid+"006");
	//jSouEiid.parent().parent().hide();
	//old场景应急处置步骤
	var jOldStepPdid = jQuery("#pidid"+pdid+"008");
	jOldStepPdid.parent().parent().hide();
	//原资产ID
	var jOldEiid = jQuery("#pidid"+pdid+"009");
	jOldEiid.parent().parent().hide();
	//原应急资源资产ID
	var jOldSouEiid = jQuery("#pidid"+pdid+"010");
	jOldSouEiid.parent().parent().hide();
	//定义场景流程ID
	var defineSceneId = jQuery("#pidid"+pdid+"011");
	defineSceneId.parent().parent().hide();
	//状态信息list对象
	var jStautsInfoContainer = jQuery("#stautsInfoContainer");
	jStautsInfoContainer.hide();
	//状态信息list对象
	var jShowFlow = jQuery("#showFlow");
	jShowFlow.hide();
	
	//场景名称：").attr("readonly":"readonly"); 
 	jQuery("#pidid"+pdid+"001").attr("readonly","readonly"); 
	// 场景描述
 	jQuery("#pidid"+pdid+"002").attr("readonly","readonly"); 
	
	//发起-场景定义节点不显示单一场景定义流程相关信息
	if(jQuery("#psdid[value$='001']").length > 0){
		//发起-场景定义节点不显示单一场景定义流程相关信息
		jQuery("#flowInfo").css("display","none");
		//审批意见 opinions-驳回后需要显示审批意见
		var jOpinions = jQuery("#pidid"+pdid+"007");
		if(""==jOpinions.val()){
			jOpinions.parent().parent().hide();
		}
	}
	//场景类型
	var sceneType = jQuery("#pidid"+pdid+"012").val();
	if(null!=stepPdid&&""!=stepPdid){
	var jStautsInfoDiv = jQuery("#stautsInfoDiv");
	if (jQuery("#psdid[value$='001']").length > 0||jQuery("#psdid[value$='003']").length > 0) {
		var isMask = "0";
		//审批节点不能编辑
		if(jQuery("#psdid[value$='003']").length > 0){
			isMask = "1";
		}
		//jShowFlow.show();
		jShowFlow.click(function(){
			//发起节点（单一场景定义节点）
			//场景应急处置步骤pdid
			var stepPdid = jQuery("#pidid"+pdid+"004").val();
			//如果存在 场景应急处置步骤pdid
			if(stepPdid){
				url = 'IGDRM0107_Disp.do?pdid='+stepPdid;
				window.open(url, '场景应急处置步骤', '800', '600');
			}
		});
	}
	
	if (jQuery("#psdid[value$='003']").length > 0) {
		jStautsInfoContainer.show();
		jStautsInfoDiv.hide();
		//场景应急处置步骤pdid
		var stepPdid = jQuery("#pidid"+pdid+"004").val();
		var result = "";
		jQuery.ajax({
			type: "POST",
			url:"IGDRM0107_stautsInfo.do",
			data:'stepPdid='+stepPdid,
			async:false,
			success:function(result){
			//后台数据获取
			var jsonObj = eval('(' + result + ')');
			//画面容器对象.box
			var jSInfoContainer = jQuery("#stautsInfo");
			jSInfoContainer.html("");
			//nodata
			jSInfoContainer.append('<tr><th width="5%">序号</th><th width="15%">任务名称</th><th width="15%">团队</th><th width="50%">团队成员</th><th width="50%">应急资源</th></tr>');
			if ("" == jsonObj || jsonObj.length == 0) {
				jSInfoContainer.append('<div><div class="nodata">没有数据!</div></div>');
			} else {
				//存在数据:
				for ( var i = 0; i < jsonObj.length; i++) {
					jSInfoContainer.append('<tr><td width="5%">'+(i+1)
							+'</td><td width="15%">'+jsonObj[i].psdname
							+'</td><td width="15%">'+jsonObj[i].roleName
							+'</td><td width="35%">'+jsonObj[i].participant
							+'</td><td width="30%"><a href="#" onclick=\'openSubIGCOM0303('+jsonObj[i].eiid+','+jsonObj[i].eiversion+');\' >'+jsonObj[i].einame+'</td></tr>');
				}   
			}
		   }
		});
	}
	//关联预案是否可执行 下拉监听 
	var jOpenTableImg = jQuery("#openTableImg");
	jOpenTableImg.unbind("click");
	jOpenTableImg.bind('click', function(){
		var jThisBtn = jQuery(this);
		//收放按钮的地址
		var deal=jThisBtn.attr("src");
		//切换收放 按钮图片
		if(deal=="images/redu.gif"){
			jThisBtn.attr("src","images/addd.gif");
		}else{
			jThisBtn.attr("src","images/redu.gif");
		}
		//控制 审计问题单记录表格式表单 j对象 显隐
		jStautsInfoDiv.slideToggle(1);
		
	});
}
	//修改<添加资产>字样
	jQuery("#aAddEntity").text("添加资源");
	//预计恢复时间
	if(jQuery("#psdid").val().substring(jQuery("#psdid").val().length-3,jQuery("#psdid").val().length)=="001"){
		jQuery("#pidid"+pdid+"003").parent().parent().hide();
		//去掉绑定的事件
		jQuery("#pidid"+pdid+"003").removeAttr("onclick"); 
	}else{
		jQuery("#pidid"+pdid+"003").parent().parent().show();
		//去掉绑定的事件
		jQuery("#pidid"+pdid+"003").removeAttr("onclick");
	}
	//隐藏场景类型
	jQuery("#pidid"+pdid+"012").parent().parent().hide();
	//隐藏审批意见描述
	if(jQuery("#psdid").val().substring(jQuery("#psdid").val().length-3,jQuery("#psdid").val().length)=="001"){
		if(jQuery("input[name = 'pivarvalue[8]']").val()==""){
			jQuery("input[name = 'pivarvalue[8]']").parent().parent().hide();
		}
	}
	
});
//获取流程图编辑器
function getFlowManger(){
	if (jQuery("#psdid[value$='001']").length > 0||jQuery("#psdid[value$='003']").length > 0) {
		var isMask = "0";
		//审批节点不能编辑
		if(jQuery("#psdid[value$='003']").length > 0){
			isMask = "1";
		}
		//场景应急处置步骤pdid
		var stepPdid = jQuery("#pidid"+pdid+"004").val();
		//old场景应急处置步骤pdid
		var oldpdid = jQuery("#pidid"+pdid+"008").val();
		//场景类型
		var sceneType = jQuery("#pidid"+pdid+"012").val();
		if(null!=stepPdid&&""!=stepPdid){
			if(sceneType&&sceneType=='组合场景'){
				jQuery.ajax({
					type: "post",
					url:"IGDRM0201_Disp.do",
					data:'pgdid='+stepPdid+'&isMask='+isMask+'&isUpdate=update&oldpdid='+oldpdid,
					async:false,
					dataType:"html",
					success:function(html){
						jQuery("#flowContainer1").after(html);
					}
				});
			}else{
				jQuery.ajax({
					type: "post",
					url:"IGDRM0107_Disp.do",
					data:'pdid='+stepPdid+'&isMask='+isMask,
					async:false,
					dataType:"html",
					success:function(html){
						jQuery("#flowContainer1").after(html);
					}
				});
			}
		}
	}
}
//打开场景资产查询页面
function selectFlow(eiidStr,pdidStr){
	openSubWindow('/IGDRM0201_SDisp.do?eiids='+ eiidStr, '', '850', '600');
}
function returnAddFlowXml(xml){
	jQuery("#FlowManger")[0].addFlow(xml);
}
</script>
</html>
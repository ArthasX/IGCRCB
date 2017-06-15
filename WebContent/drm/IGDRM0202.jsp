﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<%@page import="java.util.List"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGDRM0202" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<jsp:include page="/include/header1.jsp" />

<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript" src="js/process.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/tableform.js"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript">
var gid='IGPRR0102';
var pdid = null;
function selectRole(){
	var roleid = document.getElementById("ppidstr").value;
	var pdid = document.getElementById("pdid").value;
	var prid = document.getElementById("prid").value;
	document.location.replace(getAppRootUrl() + "/IGPRR0102_Disp.do?&pdid="+pdid+"&roleid="+roleid.split("_")[1]+"&prid="+prid + "&ppidstr=" + roleid);
}
function changePrRolename(){
	var obj = IGPRR0102Form.prroleid;
	IGPRR0102Form.prrolename.value = obj.options[obj.selectedIndex].text;
}
function resetForm(){
	IGPRR0102Form.reset();
}
function checkForm(vbrequired,vbrecord,btnid,action,type,code,showConfirm){
	//提交保存流程XML
	saveFlowXml();
	var go="1";
	if(IGPRR0102Form.rlcomment){
		if($F('rlcomment').strlen()>450){
			alert("处理记录不能大于"+Math.floor(450/strByteFlag)+"个汉字！");
			go="0";
		}
	}
	if(action!="<%=IGPRDCONSTANTS.BUTTON_TERMINATE%>"){
		if(code != "3") {
			<logic:present name="IGPRR01021VO" property="processInfoDefmap">
				<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
					<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
					<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
					<logic:present name="psid">
					var obj = document.getElementById("pidid${psid.pidid}");
						<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
							<logic:equal value="1" name="psid" property="pidrequired">
								if(obj.value.trim() == ""){
									alert("请输入${psid.pidlabel}！");
									go="0";
									return;
								}
							</logic:equal>
							<logic:equal value="7" name="psid" property="pidtype">
								if(checkFloatNum(obj.value)){
						    		alert("${psid.pidlabel}为数字,整数位最多13位,小数位最多2位!");
									go="0";
									return;
								}
							</logic:equal>
							if(obj.value.strlen()>3000){
								alert("${psid.pidlabel}不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
								go="0";
								return;
							}
						</logic:equal>
					</logic:present>
				</logic:iterate>
			</logic:present>

			var input11 = document.getElementsByTagName('input');  
			  for (var i = 0; i < input11.length; i++) {   
			      var type11 = input11[i].type;  //取Type
			      var value11 = input11[i].value;
			      if(type11=='file'){
				      if(value11.indexOf(".exe")!=-1){
					      alert("请选择有效的附件文件！");
					      go="0";
				      }
			      }
			 }
		}
	}else{//中上流程
		if( window.confirm("您是否确认中止流程？")){
			$("action").value = action;
			form.submit();
		}
		go="0";
	}
	
	if(go=="1"){
		if(code == "3"){
			IGPRR0102Form.log_type.value = type;
			$("action").value = action;
			IGPRR0102Form.submit();
		}else{
			if( window.confirm("您是否确认提交？")){
				IGPRR0102Form.log_type.value = type;
				$("action").value = action;
				IGPRR0102Form.submit();
			}
		}
	}
}
function grantDutyPerson(){
	if( window.confirm("请确认是否要进行授权操作?")){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=grantDutyPerson&prid=${IGPRR0102Form.prid}&roleid='+$F("prroleid"),
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					alert(result);
					return true;
				}else{
					alert("授予部门管理员提交权限失败！");
					return false;	
				}	
		    }
			});
		
		return true;
	} else {
		return false;
	}
}
function noticeRoleManager(){
	if( window.confirm("请确认是否要短信通知部门负责人?")){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=noticeRoleManager&prid=${IGPRR0102Form.prid}&roleid='+$F("prroleid"),
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					alert(result);
					return true;
				}else{
					alert("部门负责人短信通知失败！");
					return false;	
				}	
		    }
			});
		return true;
	} else {
		return false;
	}
}

function ShowpProcessFlow(prid){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?prid='+prid,null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
function toSave(){
    if(window.confirm("您是否确认提交？")){
	    return true;
    } else {
        return false;
    }
}
function selectRoleUser(roleid){
	openSubWindow('/IGSYM0405.do?roleida='+roleid , 'newpage', '800', '600');
}
function setParamRoleUser(userid,username,roleid,orgid,orgname){
	var check=document.getElementsByName("roleids");
	for(var i=0;i<check.length;i++){
		if(check[i].value==roleid){
			document.getElementsByName("ppuserids")[i].value = userid;
			document.getElementsByName("ppusernames")[i].value = username;
			document.getElementsByName("pporgids")[i].value = orgid;
			document.getElementsByName("pporgnames")[i].value = orgname;
			break;
		}
	}
}
function roleManager(prid,people){
	$("people_code").value = people;
	$("psdmode_code").value = ${IGPRR01021VO.processStatusDef.psdmode};
	checkForm('<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>','3');
}
function assignOA(prid, prstatus, psdid, usertype){
	if("super" == usertype) {
		window.location.href = "IGPRR0113_Disp.do?flag=0&psdmode=2&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	} else {
		window.location.href = "IGPRR0113_Admin.do?flag=1&roleid=" + $F("prroleid") + "&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	}
}
function assignNormal(prid, prstatus, psdid, usertype){
	if("super" == usertype) {
		window.location.href = "IGPRR0113_Disp.do?psdmode=1&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	} else {
		window.location.href = "IGPRR0113_Admin.do?flag=0&roleid=" + $F("prroleid") + "&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	}
}

/**
 * 重写打开资产选择页面方法
 *zhangjian
 */
function selectEntity(index,pidid,syscoding){
	num = index;
	openSubWindow('/IGDRM0702_Disp.do'+'?pidid='+pidid + '&esyscoding=' + syscoding+'&sp_eiid='+sp_eiid , '', '850', '600');
}
/**
 * 重写资产查看方法
 * zhangjian
 */
function openSubIGCOM0303(eiid,civersion){
	param = $H({eiid: eiid,civersion:civersion}).toQueryString();
	
	openSubWindow('/IGCOM0328_Disp.do?' + param, '_blank', '1050', '600');
}
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
			addSingleEntity(params[0],params[1],params[2],params[3]);
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
var swfVersionStr = "10.0.0";
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
swfobject.embedSWF(
    "flowswf/FlowChart.swf", "flashContent", 
    "100%", "100%", 
    swfVersionStr, xiSwfUrlStr, 
    flashvars, params, attributes,
    function (obj){
   	 if(obj.success){
   		 flexObj = obj.ref;
   	 }
    }
    );
swfobject.createCSS("#flashContent", "display:block;text-align:left;");
</script>
<body onload="initAttFormFile();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
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
	<div id="flowInfo" >
		<div class="title" id="flowChartBox">
			<div class="name">流程图</div>
		</div>
		<div id="flowChartBox" style="width:100%;height:${IGPRR01021VO.xmlheight}px;">
			<input type="hidden" value="${IGPRR01021VO.flowChartXml}" id="FlowXML">
			<input type="hidden" value="${IGPRR01021VO.xmlheight }" id="xmlheight"/>
			<div id="flashContent" >
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
<!-- 	display:none; -->
		<jsp:include page="/prr/IGPRR0136.jsp"/>
	</div>
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
		<div class="record_list"  style="margin-left: 8px;">
		<table cellspacing="2" class="table_style1">
			<tr style="display:none">
				<th width="15%"></th><td width="35%"></td><th width="15%"></th><td width="35%">
				<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
				<input type="hidden" id="addTableColumnFileStr" name="addTableColumnFileStr" value=""/>
				<input type="hidden" id="delTableColumnFileStr" name="delTableColumnFileStr" value=""/>
				</td>
			</tr>
			<%
				String tdStartTag = "";
				String textSize = "32";
				String textAreaSize = "25";
				String lastrowwidth = "";
				String trStartTag = "";
				String trEndTag = "";
				int columnNum = 0;
				boolean privateIsNull = true;
			%>
			<bean:define id="useridprr" name="IGPRR01021VO" property="userid" type="java.lang.String" />
			<bean:define id="roleidprr" name="IGPRR01021VO" property="roleid" type="java.lang.Integer" />
			<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
				<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
				<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
				<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
				<logic:present name="psid">
				<% 
				if("2".equalsIgnoreCase(psid.getPidaccess()) || "3".equalsIgnoreCase(psid.getPidaccess()) || "4".equalsIgnoreCase(psid.getPidaccess())){
					String rowwidth = StringUtils.isEmpty(psid.getRowwidth())?"0":psid.getRowwidth().trim();
					rowwidth = StringUtils.isEmpty(rowwidth)?"0":rowwidth;
					tdStartTag = "<td>";
					textSize = "32";
					textAreaSize = "25";
					if(StringUtils.isEmpty(lastrowwidth)){
						trStartTag = "<tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("0".equalsIgnoreCase(lastrowwidth)){
						trStartTag = "</tr><tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("1".equalsIgnoreCase(lastrowwidth)){
						if("0".equals(rowwidth)){
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "<td></td><td></td></tr><tr>";
							}
							tdStartTag = "<td colspan=\"3\">";
						}else{
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "";
							}
						}
					}
					if("0".equalsIgnoreCase(rowwidth)){
						columnNum = 0;
					}else{
						columnNum = (columnNum+1)%2;
					}
					lastrowwidth = rowwidth;
					if("0".equals(rowwidth)){
						textSize = "82";
						textAreaSize = "60";
					}
				}
				%>
				<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="psid" property="pidaccess">
				<%=trStartTag %>
				<%if("Y".equals(psid.getTitledisplay()) || "T".equals(psid.getTitledisplay())){
					out.print("<td colspan=\"4\">");
				}else{ %>
				<th>
					<label for="Name" onmouseover="selStation('${psid.pidlabel}');" onmouseout="chide();" >
						<strong>
						<logic:equal value="3" name="psid" property="pidaccess">
							<logic:equal value="1" name="psid" property="pidrequired">
								<span class="red">*</span>
							</logic:equal>
							</logic:equal>
							${psid.pidlabel}：</strong>
					</label>
				</th>
				<%
				out.print(tdStartTag);
				} %>
				<ig:formToTag 
						name="IGPRR0102Form" 
						pidid="${pidid }" 
						property="pivarvalue" 
						formType="${psid.pidtype }" 
						pidaccess="${psid.pidaccess }"
						pidmode="${psid.pidmode }"
						size="<%= textSize%>"	
						userid="${IGPRR01021VO.userid }"
						roleid="${IGPRR01021VO.roleid }"
						orgid="${IGPRR01021VO.roleid }"
						options="${psid.pidoption }"	
						privatescope="${psid.privatescope}"
						piddefault="${psid.piddefault }"
						pdid="${psid.pdid }"
						ccid="${psid.ccid }"
						pidlabel="${psid.pidlabel }"
						piid="${psid.piid }"
						pidrequired="${psid.pidrequired }"
						textAreaSize="<%=textAreaSize %>"
						hasattach="${psid.hasattach }"
						piddisplay="${psid.piddisplay }"
						pidwidth="${psid.pidwidth }"
						pidrows="${psid.pidrows }"
						piduse="${psid.piduse }"
						showline="${psid.showline }"
						value="${psid.pidvalue}"
						pidunit="${psid.pidunit}"
						remarks="${psid.remarks}"
						pidcomment="${psid.pidcomment}"
						titledisplay="${psid.titledisplay }"
						pidhide="${psid.pidhide }"
						jsfunction="${psid.jsfunction }"
						showrownum="${psid.showrownum }"	
						selecedlast="${psid.selecedlast }"
						numbertype="${psid.numbertype }"
						align="${psid.align }"
						showstyles="${psid.showstyles}"/>
						<html:hidden property="pivarname" value="${psid.pidname}" /> 
						<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
						<html:hidden property="pivartype" value="${psid.pidtype}" /> 
						<html:hidden property="pidid" value="${psid.pidid}" />
						<html:hidden property="pidaccess" value="${psid.pidaccess}" />
						<html:hidden property="piid" value="${psid.piid}" />
						<html:hidden property="pidmode" value="${psid.pidmode}" />
						<html:hidden property="privatescope" value="${psid.privatescope}" />
					</td>
				</logic:notEqual>
				</logic:present>
			</logic:iterate>
			<% 
			if(StringUtils.isEmpty(lastrowwidth)){
			}
			if("0".equalsIgnoreCase(lastrowwidth)){
				trEndTag = "</tr>";
			}
			if("1".equalsIgnoreCase(lastrowwidth)){
				if(columnNum == 0){
					trEndTag = "</tr>";
				}else{
					trEndTag = "<td></td><td></td></tr>";
				}
			}
			%>
			<%=trEndTag%>
		</table>
		</div>
	</logic:present>
	</logic:equal>
	</logic:present>
	</div>
	<div style="display:none;">
		<logic:present name="IGPRR01021VO" property="processInfoDefmap">
			<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
				<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
				<%if("Y".equals(psid.getIsFlag())){ %>
					<ig:formToTag 
						name="IGPRR0102Form" 
						pidid="${psid.pidid }" 
						property="pivarvalue" 
						formType="${psid.pidtype }" 
						pidaccess="${psid.pidaccess }"
						pidmode="${psid.pidmode }"
						size="32"	
						userid="${IGPRR01021VO.userid }"
						roleid="${IGPRR01021VO.roleid }"
						orgid="${IGPRR01021VO.roleid }"
						options="${psid.pidoption }"	
						privatescope="${psid.privatescope}"
						piddefault="${psid.piddefault }"
						pdid="${psid.pdid }"
						ccid="${psid.ccid }"
						pidlabel="${psid.pidlabel }"
						piid="${psid.piid }"
						pidrequired="${psid.pidrequired }"
						textAreaSize="25"
						hasattach="${psid.hasattach }"
						piddisplay="${psid.piddisplay }"
						pidwidth="${psid.pidwidth }"
						pidrows="${psid.pidrows }"
						piduse="${psid.piduse }"
						showline="${psid.showline }"
						value="${psid.pidvalue}"
						pidunit="${psid.pidunit}"
						remarks="${psid.remarks}"
						pidcomment="${psid.pidcomment}"
						titledisplay="${psid.titledisplay }"
						pidhide="${psid.pidhide }"
						jsfunction="${psid.jsfunction }"
						showrownum="${psid.showrownum }"	
						selecedlast="${psid.selecedlast }"
						numbertype="${psid.numbertype }"
						align="${psid.align }"
						showstyles="${psid.showstyles}"/>
						<html:hidden property="pivarname" value="${psid.pidname}" /> 
						<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
						<html:hidden property="pivartype" value="${psid.pidtype}" /> 
						<html:hidden property="pidid" value="${psid.pidid}" />
						<html:hidden property="pidaccess" value="${psid.pidaccess}" />
						<html:hidden property="piid" value="${psid.piid}" />
						<html:hidden property="pidmode" value="${psid.pidmode}" />
						<html:hidden property="privatescope" value="${psid.privatescope}" />
				<%} %>
			</logic:iterate>
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
	<div class="name" onclick="dealre()" style="cursor: pointer;">处理记录<img id="dealrecord" src="images/addd.gif" width="10" height="10" border="0"/></div>
	</div>
	<div class="record_list" id="handlerecord" style="width:98%" style="display:none;">
	<fieldset>
		<div>
<%-- 		<html:textarea property="rlcomment" cols="60" errorStyleClass="inputError imeActive" rows="6"></html:textarea> <br /> --%>
		<div class="editDiv" style="width:440px;min-height:85px;" contenteditable="true" onkeydown="editDivContent(this);" onblur="getProcessRlcommentValue(this);">
		<bean:write name="IGPRR0102Form" property="rlcomment"/>
		</div>
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
			<div class="action" style="cursor:pointer;" onclick="checkForm('${bean.vbrequired}','${bean.vbrecord}','${bean.vbid}','${bean.vbid}','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')"><img src="images/${bean.vbimage}" width="16" height="16" />
				<a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###">${bean.vbname}</a>
			</div>
		  </c:if>
		  <c:if test="${bean.vbid == '02'}">
		  	<div class="action" style="cursor:pointer;" onclick="affirm('${bean.vbrequired}','${bean.vbrecord}','${bean.vbid}','${bean.vbid}','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')"><img src="images/${bean.vbimage}" width="16" height="16" />
				<a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###">${bean.vbname}</a>
			</div>
		  </c:if>
		  <c:if test="${bean.vbid == '05'}">
              <logic:equal name="IGPRR01021VO" property="isMoreRelevantProcess" value="1">
              	<div class="action" style="cursor:pointer;" onclick="showChooseProcessPage('${IGPRR01021VO.process.prid}','${IGPRR01021VO.process.prtype}','${IGPRR0102Form.pdid}','${IGPRR0102Form.psdid}','${IGPRR01021VO.roleid}','','IGPRR0102_Disp.do?prid=${IGPRR01021VO.process.prid}')"><img src="images/${bean.vbimage}" width="16" height="16" />
                  <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###">${bean.vbname}</a>
              	</div>
              </logic:equal>
              <logic:notEqual name="IGPRR01021VO" property="isMoreRelevantProcess" value="1">
              <div class="action" style="cursor:pointer;" onclick="showInitProcessPage('${IGPRR01021VO.process.prid}','${IGPRR01021VO.relevantPdid}','','IGPRR0102_Disp.do?prid=${IGPRR01021VO.process.prid}')"><img src="images/${bean.vbimage}" width="16" height="16" />
                  <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###">${bean.vbname}</a>
              </div>
              </logic:notEqual>
		  </c:if>
		  <c:if test="${bean.vbid == '06'}">
		    <div class="action" style="cursor:pointer;" onclick="javascript:openSubIGKGM0206Parm('selectDisp=0&prid=${IGSVC0206Form.prid}');"><img src="images/${bean.vbimage}" width="16" height="16" />
              <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###">${bean.vbname}</a>
            </div>
		  </c:if>
		  <c:if test="${bean.vbid == '07'}">
		    <div class="action" style="cursor:pointer;"><img src="images/${bean.vbimage}" width="16" height="16" />
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
	<html:hidden property="prid" styleId="prid" name="IGPRR0102Form" />
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0102Form" />
	<html:hidden property="action" styleId="action" name="IGPRR0102Form" />
	<html:hidden property="isInit" styleId="isInit" name="IGPRR0102Form" />
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
//鼠标移入表单label
function selStation(str){
	//空方法
}
//鼠标移出表单label
function chide(){
	//空方法
}
//单一场景定义流程
jQ(function(){
// 	当前单一场景定义流程pdid
	var pdid = jQ("#pdid").val();
	//场景应急处置步骤
	var jStepPdid = jQ("#pidid"+pdid+"004");
	jStepPdid.parent().parent().hide();
	//应急资源
// 	var jSouEiid = jQ("#pidid"+pdid+"006");
// 	jSouEiid.parent().parent().hide();
	//old场景应急处置步骤
	var jOldStepPdid = jQ("#pidid"+pdid+"012");
	jOldStepPdid.parent().parent().hide();
	//原资产ID
	var jOldEiid = jQ("#pidid"+pdid+"013");
	jOldEiid.parent().parent().hide();
	//原应急资源资产ID
	var jOldSouEiid = jQ("#pidid"+pdid+"014");
	jOldSouEiid.parent().parent().hide();
	//原prid
	var jOldprid = jQ("#pidid"+pdid+"015");
	jOldprid.parent().parent().hide();
	
 	//场景名称：").attr("readonly":"readonly"); 
 	jQ("#pidid"+pdid+"011").attr("readonly","readonly"); 
	// 场景描述
 	jQ("#pidid"+pdid+"002").attr("readonly","readonly"); 
	
	//状态信息list对象
	var jStautsInfoContainer = jQ("#stautsInfoContainer");
	jStautsInfoContainer.hide();
	//状态信息list对象
	var jShowFlow = jQ("#showFlow");
	jShowFlow.hide();
	//发起-场景定义节点不显示单一场景定义流程相关信息
	if(jQ("#psdid[value$='001']").length > 0){
		//发起-场景定义节点不显示单一场景定义流程相关信息
		jQ("#flowInfo").css("display","none");
		//当审批意见为空时不显示改表单
		//审批意见 opinions-驳回后需要显示审批意见
		var jOpinions = jQ("#pidid"+pdid+"010");
		if(""==jOpinions.val()){
			jOpinions.parent().parent().hide();
		}
	}
	
// 	var jStautsInfoDiv = jQ("#stautsInfoDiv");
// 	if (jQ("#psdid[value$='001']").length > 0||jQ("#psdid[value$='004']").length > 0) {
// 		var isMask = "0";
// 		//审批节点不能编辑
// 		if(jQ("#psdid[value$='004']").length > 0){
// 			isMask = "1";
// 		}
// 		//jShowFlow.show();
// 		jShowFlow.click(function(){
// 			//发起节点（单一场景定义节点）
// 			//场景应急处置步骤pdid
// 			var stepPdid = jQ("#pidid"+pdid+"004").val();
// 			//如果存在 场景应急处置步骤pdid
// 			if(stepPdid){
// 				url = 'IGDRM0107_Disp.do?pdid='+stepPdid;
// 				window.open(url, '场景应急处置步骤', '800', '600');
// 			}
// 		});
// 	}
	
// 	if (jQ("#psdid[value$='004']").length > 0) {
// 		jStautsInfoContainer.show();
// 		jStautsInfoDiv.hide();
// 		//场景应急处置步骤pdid
// 		var stepPdid = jQ("#pidid"+pdid+"004").val();
// 		var result = "";
// 		jQ.ajax({
// 			type: "POST",
// 			url:"IGDRM0107_stautsInfo.do",
// 			data:'stepPdid='+stepPdid,
// 			async:false,
// 			success:function(result){
// 			//后台数据获取
// 			var jsonObj = eval('(' + result + ')');
// 			//画面容器对象.box
// 			var jSInfoContainer = jQ("#stautsInfo");
// 			jSInfoContainer.html("");
// 			//nodata
// 			jSInfoContainer.append('<tr><th width="5%">序号</th><th width="15%">任务名称</th><th width="15%">团队</th><th width="50%">团队成员</th><th width="50%">应急资源</th></tr>');
// 			if ("" == jsonObj || jsonObj.length == 0) {
// 				jSInfoContainer.append('<div><div class="nodata">没有数据!</div></div>');
// 			} else {
// 				//存在数据:
// 				for ( var i = 0; i < jsonObj.length; i++) {
// 					jSInfoContainer.append('<tr><td width="5%">'+(i+1)
// 							+'</td><td width="15%">'+jsonObj[i].psdname
// 							+'</td><td width="15%">'+jsonObj[i].roleName
// 							+'</td><td width="35%">'+jsonObj[i].participant
// 							+'</td><td width="30%"><a href="#" onclick=\'openSubIGCOM0303('+jsonObj[i].eiid+','+jsonObj[i].eiversion+');\' >'+jsonObj[i].einame+'</td></tr>');
// 				}   
// 			}
// 		   }
// 		});
// 	}
// 	//关联预案是否可执行 下拉监听 
// 	var jOpenTableImg = jQ("#openTableImg").parent();
// 	jOpenTableImg.unbind("click").css({cursor: "pointer"});
// 	jOpenTableImg.bind('click', function(){
// 		var jThisBtn = jQ(this);
// 		//收放按钮的地址
// 		var deal=jThisBtn.attr("src");
// 		//切换收放 按钮图片
// 		if(deal=="images/redu.gif"){
// 			jThisBtn.attr("src","images/addd.gif");
// 		}else{
// 			jThisBtn.attr("src","images/redu.gif");
// 		}
// 		//控制 审计问题单记录表格式表单 j对象 显隐
// 		jStautsInfoDiv.slideToggle(1);
		
// 	});
	//修改<添加资产>字样
	jQ("#aAddEntity").text("添加资源");
	
});
//获取流程图编辑器
function getFlowManger(){
	if (jQ("#psdid[value$='001']").length > 0||jQ("#psdid[value$='004']").length > 0) {
		var isMask = "0";
		//审批节点不能编辑
		if(jQ("#psdid[value$='004']").length > 0){
			isMask = "1";
		}
		//场景应急处置步骤pdid
		var stepPdid = jQ("#pidid"+pdid+"004").val();
		if(null!=stepPdid&&""!=stepPdid){
	jQ.ajax({
			type: "post",
			url:"IGDRM0201_Disp.do",
			data:'pgdid='+stepPdid+'&isMask='+isMask,
			async:false,
			dataType:"html",
			success:function(html){
				jQ("#flowContainer1").after(html);
			}
		});
	
		}}
}


function openSubIGCOM0303(eiid,eiversion){
	var ciid ;
	jQ.ajax({
		url:getAppRootUrl()+"/IGDRM0405.do?eiid="+eiid+"&eiversion="+eiversion,
		type:"POST",
		dataType:"text",
		async:false,
		success:function(result){
			ciid = result;
		}
	});
	
	if(ciid&&ciid!="null"){
		var param = "";
		var type = "asm";
		param = $H({type: type, eiid: eiid, ciid:ciid}).toQueryString();
		openSubWindow('/download.do?' + param, '','800','600');
		
	}else{
		alert("附件丢失");
	}
	
}

</script>
</html>
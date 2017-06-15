<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<script>
var tempPdid = 0;
var num = 0;
var asmNum=0;
var tempNum=0;
function addEntity(pidid,syscoding , index, required, property) 
{	
	tempNum=index;
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='text' asm='" + pidid + "' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive' piid=''><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectEntity("+asmNum+", '" + pidid + "','"+ syscoding +"')\" style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif' alt='删除' onclick=\"deleteEntityItem(this, '" + pidid + "','" + property + "')\" style='cursor: hand'/><input type='hidden' name='entityId["+asmNum+"]' class='" + required +"'/><input type='hidden' name='" + pidid + "'/>";

	asmNum++;
}


function addSingleEntity(pidid,syscoding , index, required, property) 
{	
	tempNum=index;
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='text' asm='" + pidid + "' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive' piid=''><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectEntity("+asmNum+", '" + pidid + "','"+ syscoding +"')\" style='cursor: hand'/>&nbsp;&nbsp;<input type='hidden' name='entityId["+asmNum+"]' class='" + required +"'/><input type='hidden' name='" + pidid + "'/>";

	asmNum++;
	
}

function deleteEntityItem(obj, pidid, property)
{
	var curRow= obj.parentNode.parentNode;
	$("tbentity" + pidid).deleteRow(curRow.rowIndex);
	checkAsm(pidid, property);
	//业务系统
	var pdid = jQ("#pdid").val();
	if(pdid.substring(0,5) == '01386' &&  pidid == pdid + '026'){
		entityChange();
	}
}

function selectEntity(index, pidid, syscoding){
	num = index;
	openSubIGCOM0302PARAM('?pidid='+pidid + '&esyscoding=' + syscoding);
}
var pieids = "";
function delEntity(pieid, pidid, property){
	var flag = window.confirm("您是否确认删除？");
	if(flag){
		document.getElementById(pieid).style.display = "none";
		document.getElementById(pieid + "ENT").style.display = "none";
		pieids = pieids + "#" + pieid;
		document.forms[0].pieids.value = pieids;
		checkAsm(pidid, property);
		var pdid = jQ("#pdid").val();
		if(pdid.substring(0,5) == '01386' &&  pidid == pdid + '026'){
			jQ("#"+pieid).removeAttr("eiid");
			deleteSelect2(pdid + "015");
			deleteSelect2(pdid + "016");
			entityChange();
		}
	}
	return flag;
}

function delSingleEntity(pieid, pidid, property,pidid,syscoding,index,required){
	var flag = delEntity(pieid, pidid, property);
	if(flag){
		addSingleEntity(pidid,syscoding , index, required, property);
	}
}

function checkAsm(pidid, property) {
	var flag = true;
	var flag1 = true;
	var arr = document.getElementsByTagName("INPUT");
	for(var i=0; i<arr.length; i++) {
		if(arr[i].asm == pidid) {
			if(arr[i].type == "text" && arr[i].value > "") {
				flag = false;
				break;
			}
		}
	}
	if(flag) {
		var arr1 = document.getElementsByTagName("A");
		for(var i=0; i<arr1.length; i++) {
			if(arr1[i].asm == pidid) {
				if(arr1[i].style.display != "none") {
					flag1 = false;
					break;
				}
			}
		}
		if(flag1) {
			document.getElementById(property).value = "";
		}
	}
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory,eiversion, pidid) {
	if(setEntityObj != null){
		var showvalue = null;
		var showvalues = setEntityObj.parentElement.childNodes;
		if(showvalues != null){
			for(var i=0;i<showvalues.length;i++){
				if(showvalues[i].name == "show_value"){
					showvalue = showvalues[i];
				}
			}
		}
		var columnvalue = null;
		var columnvalues = setEntityObj.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes;
		if(columnvalues != null){
			for(var k=0;k<columnvalues.length;k++){
				if(columnvalues[k].name == "column_value"){
					columnvalue = columnvalues[k];
				}
			}
		}
		var crowIndex = setEntityObj.parentElement.parentElement.id;
		if("" == eiid){
			showvalue.value = "";
			if(columnvalue.value != ""){
				var str0 = columnvalue.value.split("_entityValue_")[0];
				var str1 = columnvalue.value.split("_entityValue_")[1];
				var str2 = "";
				if(columnvalue.value.split("_entityValue_").length == 3){
					str2 = columnvalue.value.split("_entityValue_")[2];
				}
				var strs = str1.split("#");
				var valueStr = "";
				for(var index=0;index<strs.length;index++){
					if(index > 0){
						valueStr += "#";
					}
					if(crowIndex != strs[index].split("_rowIndex_")[0]){
						valueStr += strs[index];
					}
				}
				if(str2 != ""){
					columnvalue.value = str0 + "_entityValue_" + valueStr + "_entityValue_" + str2;
				}else{
					columnvalue.value = str0 + "_entityValue_" + valueStr;
				}
			}
		}else{
			showvalue.value = einame + "(" + eiversion + ")";
			if(columnvalue.value == ""){
				columnvalue.value = "_entityValue_" + crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
			}else{
				var str0 = columnvalue.value.split("_entityValue_")[0];
				var str1 = columnvalue.value.split("_entityValue_")[1];
				var str2 = "";
				if(columnvalue.value.split("_entityValue_").length == 3){
					str2 = columnvalue.value.split("_entityValue_")[2];
				}
				var strs = str1.split("#");
				var flag = true;
				var valueStr = "";
				for(var index=0;index<strs.length;index++){
					if(index > 0){
						valueStr += "#";
					}
					if((crowIndex + "") == strs[index].split("_rowIndex_")[0]){
						flag = false;
						valueStr += crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
					}else{
						valueStr += strs[index];
					}
				}
				if(flag){
					valueStr += "#" + crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
				}
				if(str2 != ""){
					columnvalue.value = str0 + "_entityValue_" + valueStr + "_entityValue_" + str2;
				}else{
					columnvalue.value = str0 + "_entityValue_" + valueStr;
				}
			}
		}
		setEntityObj = null;
	}else{
		if("" == eiid){
			$("entityId[" + num + "]").value = "";
			$("entityname[" + num + "]").value = "";
		} else {
			$("entityId[" + num + "]").value = pidid + "#" + eiid + "#" + eiversion;
			$("entityname[" + num + "]").value = einame + "(" + eiversion +")";
			if(pidid != 'A'){
				$("pivarvalue[" + tempNum + "]").value = "N/A";
			}
		}
		
		num = 0;
	}
}
var relevantPorcess_prid;
var relevantProcess_pdid;
var relevantProcess_parameters;
var relevantProcess_url;
var relevantProcess_flag;
var relevantProcess_type;
var relevantProcess_psdid;
var relevantProcess_roleid;
/**
* 流程快捷发起(可发起多个流程类型，打开流程选择页面)
* 
*   prid：流程ID
*   prtype：流程类型
*   pdid:当前流程的流程类型id
*   psdid:当前流程状态id
*   roleid:当前流程状态参与者角色
*   parameters:其他信息
*   url：需要刷新的父页url
*/
function showChooseProcessPage(prid, prtype, pdid, psdid, roleid, parameters, url){
	relevantPorcess_prid = prid
	relevantProcess_pdid = pdid;
	relevantProcess_parameters = parameters;
	relevantProcess_url = url;
	relevantProcess_flag = true;
    relevantProcess_type = prtype;
	relevantProcess_psdid = psdid;
	relevantProcess_roleid = roleid;
		form.target="iframe1";
		checkForm('','','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>', "", true);
		form.target="_self";
		
}

/**
* 流程快捷发起（只可发起一种流程类型，打开发起页面）
* 
*   prid：流程ID
*   relevantPdid：相关发起的自定义流程类型id
*   parameters:其他信息
*   url：需要刷新的父页url
*/
function showInitProcessPage(prid, relevantPdid, parameters, url){
	relevantPorcess_prid = prid;
	relevantProcess_pdid = relevantPdid;
	relevantProcess_parameters = parameters;
	relevantProcess_url = url;
	relevantProcess_flag = true;
	form.target="iframe1";
	checkForm('','','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>', "", true);
	form.target="_self";
	
}
function relevantProcess(isMoreRelevantProcess){
	if(isMoreRelevantProcess!='1'){
		showInitProcessPageDialog();
	}else{
		showChooseProcessPageDialog();
	}
}

function showInitProcessPageDialog() {
	if(relevantProcess_flag){
		window.showModalDialog(getAppRootUrl() + "/IGCOM0401.do?parprid="+relevantPorcess_prid+
            "&prtype=WD&prpdid=" + relevantProcess_pdid+
            "&flag=0&ptid=8&parameters=" + relevantProcess_parameters,
            null,"dialogWidth:1080px;dialogHeight:650px;status:no;help:no;resizable:yes");
		window.location.href = relevantProcess_url;
	}
}
function showChooseProcessPageDialog() {
	if(relevantProcess_flag){
	    window.showModalDialog(getAppRootUrl() + "/IGPRM0003_RelevantProcess.do?prid=" + relevantPorcess_prid + 
	            "&prtype=" + relevantProcess_type+ 
	            "&pdid=" + relevantProcess_pdid+
	            "&psdid=" + relevantProcess_psdid+
	            "&roleid=" + relevantProcess_roleid+
	            "&parameters=" + relevantProcess_parameters,
	            null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	    window.location.href = relevantProcess_url;
	}
}

function selectOrgTree(index){
	num = index;
	var temp = window.showModalDialog('IGSYM0101_ROLETREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("pivarvalue[" + num + "]").value = '';
		$("pivartreename[" + num + "]").value = '';
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		$("pivarvalue[" + num + "]").value = temp.split("|")[0]+"_OrgTree_"+temp.split("|")[1];
		$("pivartreename[" + num + "]").value = temp.split("|")[1];
	}
	num = 0;
}
function openProcessInfoLog(prid){
	openSubWindow("/IGPRR0123.do?prid="+prid,"_blank",1100,600);
}
</script>
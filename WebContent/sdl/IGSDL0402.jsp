<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0402" toScope="request" />
<bean:define id="title" value="信息登记画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGSDL0402';
WebCalendar.timeShow   = true;          //是否返回时间
//选择资产
function selectEntity(){
	openSubIGCOM0302PARAM("?ecategory=SDL");
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
  	$("sieiid").value = eiid;
	$("sieiname").value = einame;
}
//选择工作
function openSVCPage(){
	openSubWindow('/IGSVC0107_Disp.do?prtype=I', '_blank','1000','600');
}

function setParams(prcorid,prcortype,prcortitle){
	$("siprid").value = prcorid;
    $("siprtitle").value = prcortitle;
}

var num=0;
function addFile() 
{
	currRow=tb.insertRow();
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='file' name='attachFile["+num+"]' class='inputbutton'><input type='button' class='delbutton' value='删除' onclick='deleteitem(this)'>";
	num++;
}

function deleteitem(obj)
{
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
}

function confirmDisp(){
	if($F('sitype').trim()==""){
		alert("类别不能为空！");
		return false;
	}
	if($F('sieiid').trim()==""){
		alert("相关资产不能为空！");
		return false;
	}
	if($F('sibegin').trim()==""){
		alert("开始时间不能为空！");
		return false;
	}
	if($F('siend').trim()==""){
		alert("结束时间不能为空！");
		return false;
	}
	if($F('sidesc').strlen()>512){
		alert("说明不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	
	var message = '';
	if ('${IGSDL0402Form.mode}' == '1'){
		message = '<bean:message key="IGCO10000.W003" arg0="信息基本信息" />';
	} else {
		message = '<bean:message key="IGCO10000.W001" arg0="信息基本信息" />';
	}
	if(!checkDateWithTimeShow("sibegin","siend")){
		alert("开始时间应小于结束时间！");
		return false;
	}
	if( window.confirm(message)){
		return true;
	} else {
		return false;
	}
}
function changeDiv(obj){ 
	if(obj.value == "C"||obj.value == "D"||obj.value == "P"){
		document.getElementById("a").style.display = "";
	} else{
		document.getElementById("a").style.display = "none";
		$("simark").value="";
	}
}

function checkSimark(){
	if($F("simark") != "" && $F("simark") != "0"){
		document.getElementById("a").style.display = "";
	}
	var sitype = document.forms[0].sitype.value;
	if(sitype!=null && sitype!=""){
		changeDiv(document.forms[0].sitype);
	}
	
	
}
</script>
<body onload="checkSimark();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->

<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">服务管理 &gt;&gt; 服务水平 &gt;&gt; <logic:equal
	name="IGSDL0402Form" property="mode" value="0">信息登记</logic:equal><logic:equal
	name="IGSDL0402Form" property="mode" value="1">信息变更</logic:equal></p>
<logic:equal name="IGSDL0402Form" property="mode" value="1">
	<div class="back"><a href="IGSDL0401_BACK.do" target="_self">返回</a></div>
</logic:equal></div>
<div id="formwrapper"><html:form action="/IGSDL0402.do"
	enctype="multipart/form-data">
	<ig:message />
	<fieldset><legend>详细信息</legend>
	<div><label for="Name"><strong><span class="red">*</span>类别</strong>：</label>
	<html:select property="sitype" onchange="changeDiv(this)"
		errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="SERVER_CATEGORY_CODE"
			isMakeBlankRow="true" isCodeLabel="true" />
	</html:select> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>相关资产</strong>：</label>
	<html:text property="sieiname" size="20" readonly="true" /> <img
		src="images/seek.gif" width="16" height="16" onclick="selectEntity()"
		style="cursor: hand" alt="查询" /><br />
	</div>
	<div><label for="Name"><strong>相关事件</strong>：</label> <html:text
		property="siprtitle" size="20" readonly="true" /> <img
		src="images/seek.gif" width="16" height="16" onclick="openSVCPage();"
		style="cursor: hand" alt="查询" /><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>开始时间</strong>：</label> <html:text
		property="sibegin" size="16" readonly="true" /> <img
		src="images/date.gif" onClick="calendar($('sibegin'))" border="0" />
	<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>结束时间</strong>：</label> <html:text
		property="siend" size="16" readonly="true" /> <img
		src="images/date.gif" onClick="calendar($('siend'))" border="0" /> <br />
	</div>
	<div id="a" style="display: none;"><label for="Name"><strong>评分</strong>：</label>
	<html:select property="simark" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="SERVICE_LEVEL_GRADE" isMakeBlankRow="true"
			isCodeLabel="true" />
	</html:select> <br />
	</div>
	<div><label for="Name"><strong>说明</strong>：</label> <html:textarea
		property="sidesc" cols="80" rows="6"></html:textarea> <br />
	</div>
	<div style="padding-left: 50px"><img src="images/attachment.gif" /><a
		href="javascript:addFile();" id="aAddAttach">添加附件</a>
	<table id="tb">
	</table>
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" /></div>
	<html:hidden property="siid" styleId="siid" />
	<html:hidden property="sieiid" styleId="sieiid" />
	<html:hidden property="mode" styleId="mode" />
	<html:hidden property="siprid" styleId="siprid" />
	<html:hidden property="siattkey" styleId="siattkey" />
</html:form></div>
</div>
</div>
</div>
</div>
</body>
</html:html>
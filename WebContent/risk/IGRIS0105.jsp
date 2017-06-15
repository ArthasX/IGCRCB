<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRIS0105" toScope="request" />
<bean:define id="title" value="审计项设定画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGRIS0105';

function selectUser(){
	openSubWindow('/IGSYM0205_Disp.do?', 'newpage', '800', '600');
}

function setParamUser(userid,username,pos){
	$("raduserid").value = userid;
	$("radusername").value = username;

}

function setAudit(){
	if($F('raid').trim() == ""){
		alert("请选择版本名称！");
		return false;
	}
	var temp = window.showModalDialog("IGRIS0104_TREE.do?raid="+$F('raid'),null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].radparcode.value = "";
		document.forms[0].radparname.value = "";
		$('raid').disabled = "";
		return false;
	}
	
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].radparcode.value = temp.split("|")[0];
		document.forms[0].radparname.value = temp.split("|")[1];
		$('raid').disabled = "disabled";
	}		
}

function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].radorgcoding.value = "";
		document.forms[0].radorg.value = "";
		return false;
	}
	
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].radorgcoding.value = temp.split("|")[0];
		document.forms[0].radorg.value = temp.split("|")[1];
	}		

}

function changeRaversion(){
	var obj = $("raid");
	$("raversion").value = obj.options[obj.selectedIndex].text;
}

function checkForm(){
		if($F('raid').trim() == ""){
			alert("请选择版本名称！");
			return false;
		}
		if($F('radparname').trim() == ""){
			alert("请选择上级审计项！");
			return false;
		}
		if($F('radname').trim() == ""){
			alert("请输入审计项名称！");
			return false;
		}
		if($F('radusername').trim() == ""){
			alert("请选择责任人！");
			return false;
		}
		if($F('radorg').trim() == ""){
			alert("请选择责任部门！");
			return false;
		}
		if($F('radrisklevel').trim() == ""){
			alert("请选择风险程度！");
			return false;
		}
		if($F('radfrequency').trim() == ""){
			alert("请选择控制频率！");
			return false;
		}
		if($F('radmode').trim() == ""){
			alert("请选择控制手段！");
			return false;
		}
		if($F('radtype').trim() == ""){
			alert("请选择控制类型！");
			return false;
		}
		if($F('radname').strlen()>32){
			alert("审计项名称不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
			return false;
		}if($F('raddesc').strlen()>256){
			alert("说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
			return false;
		}
		if ('${IGRIS0105Form.mode}' == '0'){
			message = '<bean:message key="IGCO10000.W001" arg0="审计项基本信息" />';
		} else {
			message = '<bean:message key="IGCO10000.W003" arg0="审计项基本信息" />';
		}
		if( window.confirm(message)){
			$('raid').disabled = "";
			return true;
		} else {
			return false;
		}
}
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">服务管理 &gt;&gt; 风险审计 &gt;&gt;
<logic:equal
	name="IGRIS0105Form" property="mode" value="0">审计项设定</logic:equal><logic:equal
	name="IGRIS0105Form" property="mode" value="1">审计项变更</logic:equal></p>
<logic:equal name="IGRIS0105Form" property="mode" value="1">
	<div class="back"><a href="IGRIS0104_Back.do" target="_self">返回</a></div> 
</logic:equal>
</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGRIS0105" onsubmit="return checkSubmit(this);">
	
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
		<logic:equal name="IGRIS0105Form" property="mode"
		value="0">
		<legend>新增审计项信息</legend>
	</logic:equal> <logic:equal name="IGRIS0105Form" property="mode" value="1">
		<legend>修改审计项信息</legend>
	</logic:equal>
	<logic:equal name="IGRIS0105Form"  property="mode" value="0">
	<div><label for="Name"><strong><span class="red">*</span>版本名称</strong>：</label>
	<logic:present name="labelList">
	<html:select property="raid" errorStyleClass="inputError imeActive" onchange="changeRaversion()" name="IGRIS0105Form" styleId="raid">
		<html:options collection="labelList" property="value" name="" labelProperty="label"/>
	</html:select> <html:hidden property="raversion" styleId="raversion" name="IGRIS0105Form"/>
	</logic:present>
	<br />
	</div>
	</logic:equal>
	<logic:equal name="IGRIS0105Form"  property="mode" value="1">
	<div><label for="Name"><strong><span class="red">*</span>版本名称</strong>：</label>
	<html:text property="raversion"  readonly="true" name="IGRIS0105Form" styleId="raversion" styleClass="inputDisable"></html:text>
	<html:hidden property="raid" styleId="raid" name="IGRIS0105Form"/>
	<br />
	</div>
	</logic:equal>
	
	<logic:equal name="IGRIS0105Form"  property="mode" value="0">
	<div><label for="Name"><strong><span class="red">*</span>上级审计项</strong>：</label>
	<html:text property="radparname"  readonly="true" name="IGRIS0105Form" styleId="radparname"></html:text>
	<img src="images/tree.gif" style="cursor: hand;" alt="选择上级审计项" width="16" height="16" border="0" onclick="setAudit();"/>
	<html:hidden property="radparcode" styleId="radparcode" name="IGRIS0105Form"/>
	<br/>
	</div>
	</logic:equal>
	<logic:equal name="IGRIS0105Form"  property="mode" value="1">
	<div><label for="Name"><strong><span class="red">*</span>上级审计项</strong>：</label>
	<html:text property="radparname"  readonly="true" name="IGRIS0105Form" styleId="radparname" styleClass="inputDisable"></html:text>
	<html:hidden property="radparcode" styleId="radparcode" name="IGRIS0105Form"/>
	<br/>
	</div>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span>审计项名称</strong>：</label>
	<html:text property="radname" errorStyleClass="inputError imeActive" name="IGRIS0105Form" styleId="radname" /><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>责任人</strong>：</label> <html:text
		property="radusername" errorStyleClass="inputError imeActive" name="IGRIS0105Form" styleId="radusername" readonly="true"/> 
		<a href="javascript:void(0)" onclick="selectUser();"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
		<html:hidden property="raduserid" styleId="raduserid" name="IGRIS0105Form"/>	
		<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>责任部门</strong>：</label> <html:text
		property="radorg" errorStyleClass="inputError imeActive" name="IGRIS0105Form" styleId="radorg" readonly="true"/> 
		<img src="images/tree.gif" style="cursor: hand;" alt="选择责任部门" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>
		<html:hidden property="radorgcoding" styleId="radorgcoding" name="IGRIS0105Form"/>
		<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>风险程度</strong>：</label>
	<html:select property="radrisklevel" name="IGRIS0105Form" styleId="radrisklevel">
		<ig:optionsCollection ccid="RADRISKLEVEL_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
		</html:select>
	<br />
	</div>
	
	<div><label for="Name"><strong><span class="red">*</span>控制频率</strong>：</label> 
		<html:select property="radfrequency" name="IGRIS0105Form" styleId="radfrequency">
		<ig:optionsCollection ccid="RADFREQUENCY_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
		</html:select>
		<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>控制手段</strong>：</label>
		<html:select property="radmode" name="IGRIS0105Form" styleId="radmode">
		<ig:optionsCollection ccid="RADMODE_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
		</html:select>
		<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>控制类型</strong>：</label>
		<html:select property="radtype" name="IGRIS0105Form" styleId="radtype">
		<ig:optionsCollection ccid="RADTYPE_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
		</html:select>
	<br />
	</div>
	<div><label for="Name"><strong>说明</strong>：</label> <html:textarea
		property="raddesc" cols="60" rows="6" errorStyleClass="inputError imeActive" name="IGRIS0105Form" styleId="raddesc"/> <br />
	</div>
	</fieldset>
	<html:hidden property="radlevel" styleId="radlevel" name="IGRIS0105Form"/>
	<html:hidden property="radstatus" styleId="radstatus" name="IGRIS0105Form"/>
	<html:hidden property="radid" styleId="radid" name="IGRIS0105Form"/>
	<html:hidden property="mode" styleId="mode" name="IGRIS0105Form"/>
	<html:hidden property="radcode" styleId="radcode" name="IGRIS0105Form"/>
	<div class="enter"><html:submit property="btn_insert" value="提交" styleClass="button" onclick="return checkForm();"/> 
	<html:reset property="btn_clear" styleClass="button" value="重置" /></div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
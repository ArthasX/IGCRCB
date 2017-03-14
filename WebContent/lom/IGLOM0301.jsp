<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.sym.bl.IGSYM03BLImpl"%>
<html:html>
<bean:define id="id" value="IGLOM0301" toScope="request" />
<bean:define id="title" value="预支费用基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--

	function setDefalutTypeDiv(){
		if ('${IGLOM0301Form.mode}' == '1') {
			if('${IGLOM0301Form.actype}' == '2'){
				$('type').style.display = "";
			}
		}
	}
	function setTypeDiv(){
		if($F('actype') == '2'){
			$('type').style.display = "";
		} else {
			$('type').style.display = "none";
			$('acchequenum').value = "";
		}
	}

	function checkACCHEQUENUM(obj){
			if(obj.value){
				if(obj.value.length>16)
					{
						alert("支票号长度已经超过16位，请重新输入！");
						obj.value = "";
						obj.focus();
					}
			}
		}

	function checkACSERIAL(obj){
			if(obj.value){
				if(obj.value.length>32)
					{
						alert("预支审批号长度已经超过32位，请重新输入！");
						obj.value = "";
						obj.focus();
					}
				}
		}
	
	function confirmDisp(){
		var message = '';
		if ('${IGLOM0301Form.mode}' == '0'){
			message = '<bean:message key="IGCO10000.W001" arg0="预支费用基本信息" />';
		} else {
			message = '<bean:message key="IGCO10000.W003" arg0="预支费用基本信息" />';
		}

		if($F("acamount").trim() == ""){
			alert("请输入预支金额！");
			return false;
		}
		if(isNaN($F("acamount").trim())){
			alert("预支金额格式不正确！");
			$("acamount").value = "";
			return false;
		} else {
				if($("acamount").value == 0) {
					alert("预支金额不能为0！");
					return false;
				}
			}
		if($("acdate").value.trim() == ""){
			alert("请选择计财记账日期！");
			return false;
		}
		if($("actype").value.trim() == ""){
			alert("请选择预支方式！");
			return false;
		}
		if($("actype").value == "2" && $("acchequenum").value.trim() == ""){
			alert("请输入支票号！");
			return false;
		}
		if($("acserial").value.trim() == ""){
			alert("请输入预支审批号！");
			return false;
		}
		if($F('acserial').strlen() > 32){
			alert("预支审批号不能大于32个字符！");
			return false;
		}
		if($F('accomment').strlen() > 256){
			alert("用途说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
			return false;
		}

		if( window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}

//-->
	</script>
<body onload="setDefalutTypeDiv()">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; <logic:equal
	name="IGLOM0301Form" property="mode" value="0">预支费用登记</logic:equal><logic:equal
	name="IGLOM0301Form" property="mode" value="1">预支费用变更</logic:equal></p>
<logic:equal name="IGLOM0301Form" property="mode" value="1">
	<div class="back"><a href="IGLOM0302_Back.do" target="_self">返回</a></div>
</logic:equal></div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGLOM0301" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
    <logic:equal name="IGLOM0301Form" property="mode" value="0">
	    <legend>预支费用添加</legend>
	</logic:equal>
	<logic:equal name="IGLOM0301Form" property="mode" value="1">
        <legend>预支费用变更</legend>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span>预支金额</strong>：</label>
	<html:text name="IGLOM0301Form" property="acamount" size="20"
		errorStyleClass="inputError imeActive" tabindex="1" onblur="checkFloatNumForYZ(this,'预支金额整数部分最大为10位，小数部分为2位！','预支金额请输入数字！');"/><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>计财记账日期</strong>：</label>
	<html:text name="IGLOM0301Form" property="acdate" styleId="acdate"
		size="12" tabindex="2" 
		errorStyleClass="inputError imeActive" readonly="true" /> <img
		src="images/date.gif" align="middle" onClick="calendar($('acdate'))"
		border="0" /> <br>
	</div>
	<div><label for="Name"><strong><span
		class="red">*</span>预支方式</strong>：</label> <html:select name="IGLOM0301Form"
		property="actype" styleId="actype" errorStyleClass="inputError" tabindex="3" onchange="setTypeDiv()">
		<html:options collection="AD_advancescost_actype" property="value" name="" labelProperty="label" />
	</html:select></div>
	<div id="type" style="display:none"><label for="Name"><strong><span class="red">*</span>支票号</strong>：</label>
	<html:text name="IGLOM0301Form" property="acchequenum" styleId="acchequenum" size="20"
		errorStyleClass="inputError imeActive" tabindex="4" onchange="checkACCHEQUENUM(this);"/>
		<br/>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>预支审批号</strong>：</label>
	<html:text name="IGLOM0301Form" property="acserial" styleId="acserial" size="20"
		errorStyleClass="inputError imeActive" tabindex="5" onchange="checkACSERIAL(this);"/><br />
	</div>

	<div><label for="Name"><strong>用途说明</strong>：</label> <html:textarea name="IGLOM0301Form"
		property="accomment" styleId="accomment" cols="60" rows="6" tabindex="6"
		errorStyleClass="inputError imeActive" /> <br />
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" /></div>
	<html:hidden property="acid" styleId="acid" name="IGLOM0301Form"/>
	<html:hidden property="mode" styleId="mode" name="IGLOM0301Form"/>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
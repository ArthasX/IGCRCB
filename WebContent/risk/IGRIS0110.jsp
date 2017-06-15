<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRIS0110" toScope="request" />
<bean:define id="title" value="审计版本信息登记画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

		function changeRaversion(){
			var obj = $("raid");
			$("raversion").value = obj.options[obj.selectedIndex].text;
		}
		function toback(){
	        form.action = getAppRootUrl() + "/IGRIS0109_Back.do";
	        form.submit();
	    }
	
	    function checkForm(){
	    	if($F('raid').trim() == ""){
	    		alert("请选择版本名称！");
	    		return false;
	    	}
	    	if($F('raicode').trim() == ""){
	    		alert("请选择审计编号！");
	    		return false;
	    	}
	    	if($F('raistart').trim() == ""){
	    		alert("请选择开始时间！");
	    		return false;
	    	}
	    	if($F('raiend').trim() == ""){
	    		alert("请选择结束时间！");
	    		return false;
	    	}
	    	if($F('raicode').strlen()>32){
	    		alert("审计编号不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if(!checkDate("raistart","raiend")){
	    		alert("开始时间不能晚于结束时间！");
	    		return false;
	    	}
	    	if($F('radesc').strlen()>128){
	    		alert("说明不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}else {
	    		var message = '';
	            if ('${IGRIS0110Form.mode}' == '0'){
	                message = '<bean:message key="IGCO10000.W001" arg0="审计发起基本信息" />';
	            } else {
	                message = '<bean:message key="IGCO10000.W003" arg0="审计发起基本信息" />';
	            }
				if( window.confirm(message)){
					return true;
				} else {
					return false;
				}
	    	}
	    }
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">服务管理 &gt;&gt; 风险审计 &gt;&gt; 
<logic:equal name="IGRIS0110Form" property="mode" value="0">审计发起</logic:equal> 
<logic:equal name="IGRIS0110Form" property="mode" value="1">审计发起变更</logic:equal></p>
<logic:equal name="IGRIS0110Form" property="mode" value="1">
	<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</logic:equal></div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGRIS0110" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><legend>审计发起信息</legend>
	<div><label for="Name"><strong><span class="red">*</span>版本名称</strong>：</label>
	<logic:present name="labelList">
	<logic:equal name="IGRIS0110Form" property="mode" value="0">
	<html:select property="raid" errorStyleClass="inputError imeActive" onchange="changeRaversion()" name="IGRIS0110Form" styleId="raid">
		<html:options collection="labelList" property="value" name="" labelProperty="label"/>
	</html:select> <html:hidden property="raversion" styleId="raversion" name="IGRIS0110Form"/>
	</logic:equal>
	</logic:present>
	<logic:equal name="IGRIS0110Form" property="mode" value="1">
	<html:text property="raversion" styleId="raversion" name="IGRIS0110Form" styleClass="inputDisable" style="width:200px;" readonly="true"/>
	</logic:equal><br>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>审计编号</strong>：</label>
	<logic:equal name="IGRIS0110Form" property="mode" value="0">
	<html:text name="IGRIS0110Form" property="raicode"
		styleId="raversion" size="8" style="width:200px;"
		errorStyleClass="inputError"/> </logic:equal>
	<logic:equal name="IGRIS0110Form" property="mode" value="1">
	<html:text name="IGRIS0110Form" property="raicode" styleClass="inputDisable"
		styleId="raversion" size="8" style="width:200px;"
		errorStyleClass="inputError" readonly="true"/> </logic:equal><br>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>开始时间</strong>：</label>
	<html:text property="raistart" styleId="raistart" name="IGRIS0110Form"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('raistart'))" border="0" style="cursor: hand" /><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>结束时间</strong>：</label>
	<html:text property="raiend" styleId="raiend" name="IGRIS0110Form"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('raiend'))" border="0" style="cursor: hand" /><br />
	</div>
	<div><label for="Name"><strong>说明</strong>：</label> <html:text
		name="IGRIS0110Form" property="raidesc" styleId="radesc"
		size="41" style="width:450px;" errorStyleClass="inputError" /> <br>
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return checkForm();" /></div>
		<html:hidden property="raiid" styleId="raiid" name="IGRIS0110Form"/>
		<html:hidden property="mode" styleId="mode" name="IGRIS0110Form"/>
		<logic:equal name="IGRIS0110Form" property="mode" value="1">
		<html:hidden property="raid" styleId="raid" name="IGRIS0110Form"/>
		</logic:equal>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
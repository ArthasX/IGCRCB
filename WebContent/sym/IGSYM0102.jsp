<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0102" toScope="request" />
<bean:define id="title" value="机构基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	//删除所选
	function confirmDisp(){
		var message = '';
		if ('${IGSYM0102Form.mode}' == '0'){
			message = '<bean:message key="IGCO10000.W001" arg0="机构基本信息" />';
		} else {
			message = '<bean:message key="IGCO10000.W003" arg0="机构基本信息" />';
		}
	
		
		if($("orgparname").value.trim()==""){
			alert("请选择上级机构！");
			return false;
		}
		if($("orgname").value.trim()==""){
			alert("请输入机构名称！");
			return false;
		}
		if($("orgname").value.indexOf('-')>-1){
			alert("机构名称不能包含'-'等特殊字符！");
			return false;
		}
		if($F('orgname').strlen()>(128-$F('orgparname').strlen())){
			alert("机构名称加上上级机构名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！\n  请调整机构名称或上级机构名称！");
			return false;
		}
		if($("orgphone").value.trim()!=""&&!isTel($("orgphone").value.trim())){
			alert("机构电话格式不正确！");
			return false;
		}
		if($("orgfax").value.trim()!=""&&!isTel($("orgfax").value.trim())){
			alert("机构传真格式不正确！");
			return false;
		}

		if($F('orgusercoding').strlen()>32){
			alert("机构编码不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('orgphone').strlen()>20){
			alert("机构电话不能大于20个字符！");
			return false;
		}
		if($F('orgfax').strlen()>20){
			alert("机构传真不能大于20个字符！");
			return false;
		}
		if($F('orgcontact').strlen()>32){
			alert("机构联系人不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('orgaddr').strlen()>128){
			alert("机构地址不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('orgdesc').strlen()>256){
			alert("机构说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
			return false;
		}

		if( window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}

	
	//改变上级机构名称
//	function changeParname(){
//		var obj = document.forms[0].orgpar;
//		if(obj.value!=""){
			//document.forms[0].orgparname.value = obj.options[obj.selectedIndex].text;
//		}else{
//			document.forms[0].orgparname.value = "";
//		}
//	}

	function setOrg(url){
		 
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].orgpar.value = "";
			document.forms[0].orgparname.value = "";
			return false;
		}
		
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].orgpar.value = temp.split("|")[0];
			document.forms[0].orgparname.value = temp.split("|")[1];
		}		

	}
//-->
	</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 机构管理 &gt;&gt; <logic:equal
	name="IGSYM0102Form" property="mode" value="0">机构新增</logic:equal><logic:equal
	name="IGSYM0102Form" property="mode" value="1">机构变更</logic:equal></p>
<logic:equal name="IGSYM0102Form" property="mode" value="1">
	<div class="back"><a href="IGSYM0101_RE.do" target="_self">返回</a></div> 
</logic:equal>
</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGSYM0102" onsubmit="return checkSubmit(this);">
	
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><logic:equal name="IGSYM0102Form" property="mode"
		value="0">
		<legend>新增机构信息</legend>
	</logic:equal> <logic:equal name="IGSYM0102Form" property="mode" value="1">
		<legend>修改机构信息</legend>
	</logic:equal>
	
	<logic:equal name="IGSYM0102Form"  property="mode" value="0">
		<div><label for="Name"><strong><span class="red">*</span>上级机构</strong>：</label>
		<html:text property="orgparname"  readonly="true"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" alt="选择上级机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>
		<html:hidden property="orgstatus" value="1"/>
		<br/>
		</div>
	</logic:equal>
	<logic:notEqual name="IGSYM0102Form"  property="mode" value="0">
		<div><label for="Name"><strong><span class="red">*</span>上级机构</strong>：</label>
		
		<p class="p2">&nbsp;&nbsp;<bean:write name="IGSYM0102Form" property="orgparname"/></p>
		<br/>
		<html:hidden property="orgparname" />
		<html:hidden property="orgstatus" />
		<html:hidden property="orgsyscoding"/>
		</div>
	</logic:notEqual>
	
	<div><label for="Name"><strong><span class="red">*</span>机构名称</strong>：</label>
	<html:text property="orgname"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="1" /><html:hidden property="orgnamebak"/> <span class="red" style="font-size:13px; ">（机构名称不能包含"-"等特殊字符！）</span><br />
	</div>
	<div><label for="Name"><strong>机构编码</strong>：</label> <html:text
		property="orgusercoding" errorStyleClass="inputError imeActive" tabindex="3" /> <br />
	</div>
	
	
	<div><label for="Name"><strong>机构电话</strong>：</label> <html:text
		property="orgphone" errorStyleClass="inputError imeActive" tabindex="4" /> <br />
	</div>
	<div><label for="Name"><strong>机构传真</strong>：</label> <html:text
		property="orgfax" errorStyleClass="inputError imeActive" tabindex="5" /> <br />
	</div>
	<div><label for="Name"><strong>机构联系人</strong>：</label> <html:text
		property="orgcontact" errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
	<div><label for="Name"><strong>机构地址</strong>：</label> <html:text
		property="orgaddr" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="3" /> <br />
	</div>
	<div><label for="Name"><strong>机构说明</strong>：</label> <html:textarea
		property="orgdesc" cols="60" rows="6" tabindex="7"
		errorStyleClass="inputError imeActive" /> <br />
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" /></div>
	<html:hidden property="orgid" styleId="orgid" />
	<html:hidden property="orgidstr" styleId="orgidstr" />
	<html:hidden property="mode" styleId="mode" />
	
	<html:hidden property="orgpar"/>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
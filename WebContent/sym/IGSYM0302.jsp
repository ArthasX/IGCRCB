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
<bean:define id="id" value="IGSYM0302" toScope="request" />
<bean:define id="title" value="角色基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--

	function deleteSelect(){
		var roletype = document.getElementById("roletype");
		for(var i = 0; i < roletype.length; i++){
			if(roletype[i].value=="IGBP01" || roletype[i].value=="IGBP05" || roletype[i].value=="IGBP04" ){
				if(document.getElementById("type").style.display==""){
					roletype.remove(i--);
				}
			}
		}
	}

	//删除所选
	function confirmDisp(){
		var message = '';
		if ('${IGSYM0302Form.mode}' == '0'){
			message = '<bean:message key="IGCO10000.W001" arg0="角色基本信息" />';
		} else {
			message = '<bean:message key="IGCO10000.W003" arg0="角色基本信息" />';
		}
		if(document.getElementById("type").style.display==""){
			if($("roletype").value.trim()==""){
				alert("请输入角色类型！");
				return false;
			}
		}

		if($("rolename").value.trim()==""){
			alert("请输入角色名称！");
			return false;
		}
		if($("roledomain").value.trim()==""){
			alert("请选择角色管理范围！");
			return false;
		}

		if($F('rolename').strlen()>64){
			alert("角色名称不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('roledesc').strlen()>128){
			alert("角色说明不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
			return false;
		}

		var roletype = document.forms[0].roletype.value;
		if(roletype!=null && roletype!="" && (roletype.indexOf("IGAC")>=0 || roletype == "IGBP50")){
			if($("assetdomain").value.trim()==""){
				alert("请选择资产管理内容！");
				return false;
			}
		}else{
			document.forms[0].assetdomainname.value = "";
			document.forms[0].assetdomain.value = "";
		}

		if($F("roletype").indexOf("IGBP") < 0 && $F("roledomain") == "<%=IGSYM03BLImpl.GROUP_ROLE_MARK%>") {
			alert("非流程角色的管理范围不能是用户自身机构！");
			return false;
		}
		
		if( window.confirm(message)){
			
			return true;
		} else {
			return false;
		}
	}

	function setOrg(){
		var url = "IGSYM0101_ROLETREE.do";
		if($F("roletype").indexOf("IGBP") > -1) {
			url = "IGSYM0101_ROLETREE.do?roledomain_q=role";
		} 
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].roledomain.value = "";
			document.forms[0].roledomainname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].roledomain.value = temp.split("|")[0];
			document.forms[0].roledomainname.value = temp.split("|")[1];
		}		

	}
	function setEntity(url){
		var newurl = url;
		var roletype = document.forms[0].roletype.value;
		if(roletype!=null && roletype!="" && roletype.indexOf("IGAC")>=0){
			if(roletype=="IGAC01"){
				//设备资产管理
				newurl = newurl+"?levelnode=IGAC01&socflag=yes";
			}else if(roletype=="IGAC02"){
				//合同资产管理
				newurl = newurl+"?levelnode=999011&socflag=yes";
			}else if(roletype=="IGAC04"){
				//服务资产管理
				newurl = newurl+"?levelnode=IGAC04&socflag=yes";
			}else if(roletype=="IGAC05"){
				//数据资产管理
				newurl = newurl+"?levelnode=999004&socflag=yes";
			}else if(roletype=="IGAC06"){
				//软件资产管理
				newurl = newurl+"?levelnode=999002&socflag=yes";
			}else if(roletype=="IGAC07"){
				//应用资产管理
				newurl = newurl+"?levelnode=999003&socflag=yes";
			}else if(roletype=="IGAC08"){
				//人员资产管理
				newurl = newurl+"?levelnode=999010&socflag=yes";
			}else if(roletype=="IGAC09"){
				//系统资产管理
				newurl = newurl+"?levelnode=999006&socflag=yes";
			}else if(roletype=="IGAC10"){
				//文档资产管理
				newurl = newurl+"?levelnode=999013&socflag=yes";
			}else if(roletype=="IGAC11"){
				//文档资产管理
				newurl = newurl+"?levelnode=999014&socflag=yes";
			}else if(roletype=="IGAC12"){
				//外包人员资产管理
				newurl = newurl+"?levelnode=999016&socflag=yes";
			}else{
				newurl = newurl+"?socflag=yes";
			}
		}
		if(roletype!=null && roletype!="" && roletype.indexOf("IGBP50")>=0){
			newurl = newurl+"?levelnode=888001&socflag=yes";
		}
		var temp = window.showModalDialog(newurl,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].assetdomainname.value = "";
			document.forms[0].assetdomain.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){

			var syscode_eid = temp.split("|")[0];
			var name = temp.split("|")[1];
			var syscode;
			var eid;
			var ecategory;
			if(syscode_eid =="999")
			{
				eid = "";
				syscode = syscode_eid;
				
			}else if(syscode_eid.split("_").length>1){
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
				ecategory = syscode_eid.split("_")[2];
			}
			document.forms[0].assetdomainname.value = name;
			document.forms[0].assetdomain.value = syscode;
		
		}		
		
	}
	var temp_assetdomainname='';
	var count=0;
	function setAssetDiv(obj){
		var roletype = document.forms[0].roletype.value;
		if(roletype!=null && roletype!="" && roletype.indexOf("IGAC")>=0 || roletype == "IGBP50"){
			document.getElementById("asset_domain").style.display="";
		}else{
			document.getElementById("asset_domain").style.display="none";
		}
		var assetdomain = document.forms[0].assetdomainname.value;
		if(assetdomain!=''&&count<1&&obj!=1){
			temp_assetdomainname=assetdomain;
		}
		if(obj==1&&count>0){
			if(temp_assetdomainname=='')
				document.getElementById("asset_domain").style.display="none";	
			else{
				document.getElementById("asset_domain").style.display="";							
				document.forms[0].assetdomainname.value=temp_assetdomainname;			
			}
		}
		if(obj!=1){
			count++;
		}
		document.forms[0].assetdomainname.value = "";
		document.forms[0].assetdomain.value = "";
	}
	function setDefalutAssetDiv(){
		var nowmode = document.forms[0].mode.value;
		if(nowmode==1){
			var roletype = document.forms[0].roletype.value;
			if(roletype!=null && roletype!="" && roletype.indexOf("IGAC")>=0){
				document.getElementById("asset_domain").style.display="";
			}else{
				document.getElementById("asset_domain").style.display="none";
			}
			if(roletype!=null && roletype!="" && roletype.indexOf("IGBP50")>=0){
				document.getElementById("asset_domain").style.display="";
			}else{
				document.getElementById("asset_domain").style.display="none";
			}
		}
	}

	function setDefalutTypeDiv(){
		var nowmode = document.forms[0].mode.value;
		if(nowmode==1){
			var roletype = document.forms[0].roletype.value;
			if(roletype!=null && roletype!="" && (roletype=="IGBP01"||roletype=="IGBP05"||roletype=="IGBP04")){
				document.getElementById("type").style.display="none";
			}else{
				document.getElementById("type").style.display="";
			}
		}
	}
//-->
	</script>
<body onload="setDefalutTypeDiv();deleteSelect();setDefalutAssetDiv();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 角色管理 &gt;&gt; <logic:equal name="IGSYM0302Form" property="mode"
		value="0">角色新增</logic:equal><logic:equal name="IGSYM0302Form" property="mode"
		value="1">角色变更</logic:equal></p>
<logic:equal name="IGSYM0302Form" property="mode" value="1">
	<div class="back"><a href="IGSYM0301_RE.do" target="_self">返回</a></div> 
</logic:equal>
</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGSYM0302" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><logic:equal name="IGSYM0302Form" property="mode"
		value="0">
		<legend>新增角色信息</legend>
	</logic:equal> <logic:equal name="IGSYM0302Form" property="mode" value="1">
		<legend>修改角色信息</legend>
	</logic:equal>
	
	<div id="type"><label for="Name"><strong><span class="red">*</span>角色类型</strong>：</label> 
	 <html:select name="IGSYM0302Form"  property="roletype" style="width: 130px;" errorStyleClass="inputError" onchange="setAssetDiv();">
	 <ig:optionsCollection ccid="ROLE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	 </html:select>
	</div>
	
	<div><label for="Name"><strong><span class="red">*</span>角色名称</strong>：</label> <html:text
		property="rolename"  size="20" 
		errorStyleClass="inputError imeActive" tabindex="1" /><html:hidden property="rolenamebak"/> <br />
	</div>
	
	<div><label for="Name"><strong><span class="red">*</span>管理范围</strong>：</label>
		<html:text property="roledomainname"  size="20"  readonly="true"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" alt="选择管理域" width="16" height="16" border="0" onclick="setOrg();"/>
		<html:hidden property="roledomain" />
		<br/>
	</div>
	
	
	<div id="asset_domain" style="display:none"><label for="Name"><strong><span class="red">*</span>资产管理内容</strong>：</label>
		<html:text property="assetdomainname"  size="20"  readonly="true"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" alt="选择资产管理内容" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do');"/>
		<html:hidden property="assetdomain" />
		<br/>
	</div>
	
	
	
	
	<div><label for="Name"><strong>角色说明</strong>：</label> <html:textarea
		property="roledesc" cols="60" rows="6" tabindex="7"
		errorStyleClass="inputError imeActive"/> <br />
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" onclick="setAssetDiv(1);" styleClass="button" value="重置"/></div>
	<html:hidden property="roleid" styleId="roleid" />
	<html:hidden property="roleidstr" styleId="roleidstr" />
	<html:hidden property="mode" styleId="mode" />
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
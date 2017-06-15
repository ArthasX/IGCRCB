<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0202" toScope="request" />
<bean:define id="title" value="用户基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//删除所选
	function confirmDisp(){

		var loginType = document.forms[0].loginType.value;

		if("1"==loginType){//LDAP登陆
			var message = '';
			if ('${IGSYM0202Form.mode}' == '0'){
				message = '<bean:message key="IGCO10000.W001" arg0="用户基本信息" />';
			} else {
				message = '<bean:message key="IGCO10000.W003" arg0="用户基本信息" />';
			}
			var password = document.forms[0].password.value;
		 	var repassword = document.forms[0].repassword.value;
			if(password!=repassword){
				alert("您两次填写的用户口令不一致，请重新填写！");
				document.forms[0].password.value="";
				document.forms[0].repassword.value="";
				document.forms[0].password.focus();
				return false;
			}
			if($("userid").value.trim() == ""){
				alert("请输入用户ID！");
				return false;
			}
			if(checkUserid($("userid").value)){
				alert("用户ID只能输入2-16个字符，可带数字、“_”、“.”的字符串！");
				return false;
			}
			if($("orgidstr").value.trim()==""){
				alert("请选择所属机构！");
				return false;
			}
			if($("username").value.trim()==""){
				alert("请输入用户姓名！");
				return false;
			}

			if($("usermobile").value.trim()==""){
				alert("请输入用户手机1！");
				return false;
			}
			if(isMobile($("fingerPrint").value.trim())){
				alert("用户手机2格式不正确！");
				return false;
			}
			if(isMobile($("usermobile").value.trim())){
				alert("用户手机1格式不正确！");
				return false;
			}
			if($("userphone").value.trim()!=""&&!isTel($("userphone").value.trim())){
				alert("用户电话格式不正确！");
				return false;
			}
			if($("useremail").value.trim()!=""&&!isEmail($("useremail").value.trim())){
				alert("用户邮箱格式不正确！");
				return false;
			}

			if($F('username').strlen()>32){
				alert("用户姓名不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
				return false;
			}
			
			if($F('usermobile').strlen()>16){
				alert("用户手机1不能大于16个字符！");
				return false;
			}
			if($F('fingerPrint').strlen()>16){
				alert("用户手机2不能大于16个字符！");
				return false;
			}
			if($F('userphone').strlen()>16){
				alert("用户电话不能大于16个字符！");
				return false;
			}
			if($F('useremail').strlen()>40){
				alert("用户邮箱不能大于40个字符！");
				return false;
			}
			if($F('userdesc').strlen()>128){
				alert("用户说明不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
				return false;
			}
			
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}else{
			var message = '';
			if ('${IGSYM0202Form.mode}' == '0'){
				message = '<bean:message key="IGCO10000.W001" arg0="用户基本信息" />';
			} else {
				message = '<bean:message key="IGCO10000.W003" arg0="用户基本信息" />';
			}
			var password = document.forms[0].password.value;
		 	var repassword = document.forms[0].repassword.value;
			if(password!=repassword){
				alert("您两次填写的用户口令不一致，请重新填写！");
				document.forms[0].password.value="";
				document.forms[0].repassword.value="";
				document.forms[0].password.focus();
				return false;
			}
			if($("userid").value.trim() == ""){
				alert("请输入用户ID！");
				return false;
			}
			if(checkUserid($("userid").value)){
				alert("用户ID只能输入2-16个字符，可带数字、“_”、“.”的字符串！");
				return false;
			}
			if($("orgidstr").value.trim()==""){
				alert("请选择所属机构！");
				return false;
			}
			if($("username").value.trim()==""){
				alert("请输入用户姓名！");
				return false;
			}
// 			if($("userinfo").value.trim()==""){
// 				alert("请输入客户经理号！");
// 				return false;
// 			}
			if($("password").value.trim()==""){
				alert("请输入用户口令！");
				return false;
			}
			if($("usermobile").value.trim()==""){
				alert("请输入用户手机1！");
				return false;
			}
			if(checkPassword($F("password"))){
				alert("用户口令格式不正确！");
				return false;
			}
			if(isMobile($("usermobile").value.trim())){
				alert("用户手机1格式不正确！");
				return false;
			}
			if($("fingerPrint").value.trim()!="" && isMobile($("fingerPrint").value.trim())){
				alert("用户手机2格式不正确！");
				return false;
			}
			if($("userphone").value.trim()!=""&&!isTel($("userphone").value.trim())){
				alert("用户电话格式不正确！");
				return false;
			}
			if($("useremail").value.trim()!=""&&!isEmail($("useremail").value.trim())){
				alert("用户邮箱格式不正确！");
				return false;
			}

			if($F('username').strlen()>32){
				alert("用户姓名不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
				return false;
			}
			/* if($F('userinfo').strlen()>32){
				alert("客户经理号不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
				return false;
			} */
			if($F('password').strlen()>16){
				alert("用户口令不能大于16个字符！");
				return false;
			}
			if($F('repassword').strlen()>16){
				alert("确认口令不能大于16个字符！");
				return false;
			}
			if($F('usermobile').strlen()>16){
				alert("用户手机1不能大于16个字符！");
				return false;
			}
			if($F('fingerPrint').strlen()>16){
				alert("用户手机2不能大于16个字符！");
				return false;
			}
			if($F('userphone').strlen()>16){
				alert("用户电话不能大于16个字符！");
				return false;
			}
			if($F('useremail').strlen()>40){
				alert("用户邮箱不能大于40个字符！");
				return false;
			}
			if($F('userdesc').strlen()>128){
				alert("用户说明不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
				return false;
			}
			
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}
	
		
	}
function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgidstr.value = "";
		document.forms[0].orgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].orgidstr.value = temp.split("|")[0];
		document.forms[0].orgname.value = temp.split("|")[1];
	}		

}
//校验登录名：只能输入2-16个字符、可带数字、“_”、“.”的字串    
function checkUserid(str){      
	var patrn=/^([a-zA-Z0-9]|[._]){2,16}$/;
	if (!patrn.test(str)){
		return true;
	}else{
		return false;  
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
<p class="fonts1">系统管理 &gt;&gt; 用户管理 &gt;&gt; <logic:equal
	name="IGSYM0202Form" property="mode" value="0">用户新增</logic:equal><logic:equal
	name="IGSYM0202Form" property="mode" value="1">用户变更</logic:equal></p>
<logic:equal name="IGSYM0202Form" property="mode" value="1">
	<div class="back"><a href="IGSYM0201_RE.do" target="_self">返回</a></div> 
</logic:equal>
</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGSYM0202" onsubmit="return checkSubmit(this);">
	<html:hidden name="IGSYM0202Form" property="loginType"/>
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><logic:equal name="IGSYM0202Form" property="mode"
		value="0">
		<legend>新增用户信息</legend>
	</logic:equal> <logic:equal name="IGSYM0202Form" property="mode" value="1">
		<legend>修改用户信息</legend>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span>用户ID</strong>：</label>
	<logic:equal name="IGSYM0202Form" property="mode" value="0">
		<html:text property="userid" maxlength="16" size="18"
			style="width:300px;" errorStyleClass="inputError imeActive"
			tabindex="1" />
	</logic:equal><logic:equal name="IGSYM0202Form" property="mode" value="1">
		<html:text property="userid" maxlength="16" size="18"
			style="width:300px;" errorStyleClass="inputError imeActive"
			tabindex="1" readonly="true" />
	</logic:equal> <br />
	</div>
	
		<div><label for="Name"><strong><span class="red">*</span>所属机构</strong>：</label>
		<html:text property="orgname" readonly="true"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
		<html:hidden property="orgidstr"/>
		<br/>
		</div>
	<div><label for="Name"><strong><span class="red">*</span>用户姓名</strong>：</label>
	<html:text property="username"  size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="3" /> <br />
	</div>
	<%-- <div style="display:none;"><label for="Name"><strong><span class="red">*</span>客户经理号</strong>：</label>
	<html:text property="userinfo"  size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="3" /> <br />
	</div> --%>
	<div><label for="Name"><strong><span class="red">*</span>用户首页</strong>：</label>
		<span> 
        <html:select property="usertype" errorStyleClass="inputError imeActive" style="width: 150px;">
		<html:options collection="hpList" property="value" name="" labelProperty="label"/>
		</html:select>
		</span>&nbsp;&nbsp;<br />
	</div>
	<logic:notEqual  name="IGSYM0202Form" property="loginType" value="1">
	<div><label for="Name"><strong><span class="red">*</span>用户口令</strong>：</label>
	<html:password property="password"  size="18"
		style="width:300px;" errorStyleClass="inputError imeActive" maxlength="16"
		tabindex="4" /><span class="red" style="font-size:13px; ">（长度在6-16之间，只能包含字母、数字和下划线）</span><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>确认口令</strong>：</label>
	<html:password property="repassword"  size="18"
		style="width:300px;" errorStyleClass="inputError imeActive" maxlength="16" value="${IGSYM0202Form.password}"
		tabindex="4" /> <br />
	</div>
	</logic:notEqual>
	
	<div><label for="Name"><strong><span class="red">*</span>用户手机1</strong>：</label> <html:text
		property="usermobile"  size="18" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
	<div><label for="Name"><strong>用户手机2</strong>：</label> <html:text
		property="fingerPrint"  size="18" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
<!--	<div><label for="Name"><strong>用户状态</strong>：</label> <html:text property="userstatus" maxlength="1" size="18" style="width:300px;"	errorStyleClass="inputError imeActive" tabindex="5" /> <br /></div>-->
	<div><label for="Name"><strong>用户电话</strong>：</label> <html:text
		property="userphone"  size="18" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
	<div><label for="Name"><strong>用户邮箱</strong>：</label> <html:text
		property="useremail"  size="18" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
	<div><label for="Name"><strong>用户说明</strong>：</label> <html:textarea
		property="userdesc" cols="60" rows="6" tabindex="7"
		errorStyleClass="inputError imeActive" /> <br />
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" /></div>
	<html:hidden property="mode" styleId="mode" />
	<html:hidden property="usertype" styleId="usertype" />
	<html:hidden property="deleteflag" value="${IGSYM0202Form.deleteflag}"/>
	<html:hidden property="userinfo" styleId="userinfo" />
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
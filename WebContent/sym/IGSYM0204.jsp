<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGSYM0204" toScope="request" />
<bean:define id="title" value="用户变更信息画面" toScope="request" />
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
	        message = '<bean:message key="IGCO10000.W003" arg0="用户基本信息" />';
		    if($("username").value.trim()==""){
			   alert("请输入用户姓名！");
			   return false;
		    }

			if($("usermobile").value.trim()==""){
			   alert("请输入用户手机1！");
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
	    	
		 	var password = document.forms[0].password.value;
		 	var repassword = document.forms[0].repassword.value;
		 	var message = '';
			if(password!=repassword){
				alert("您两次填写的用户口令不一致，请重新填写！");
				document.forms[0].password.value="";
				document.forms[0].repassword.value="";
				document.forms[0].password.focus();
				return false;
			}else{
				message = '<bean:message key="IGCO10000.W003" arg0="用户基本信息" />';
				if($("username").value.trim()==""){
					alert("请输入用户姓名！");
					return false;
				}
				/* if($("userinfo").value.trim()==""){
					alert("请输入客户经理号！");
					return false;
				} */
				if($("password").value.trim()==""){
					alert("请输入用户口令！");
					return false;
				}
				if($("repassword").value.trim()==""){
					alert("请输入确认用户口令！");
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
				<logic:present name="IGSYM02041VO" property="managerMap">
				<logic:iterate id="map" name="IGSYM02041VO" property="managerMap" indexId="index">
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
					var rolemanager = document.getElementsByName("rolemanager[${index}]");
					var rolemobile = $("rolemobile[${index}]");
					var mobile = document.getElementsByName("mobile[${index}]");
					var flag = true;
					if(mobile.length > 0) {
						if(mobile[1].checked) {
							for(var i = 0; i < <%= list.size()%>; i++) {
								if(rolemanager[i].checked) {
									flag = false;
									break;
								}
							}
							if(flag) {
								alert("请选择${map.key.rolename}角色的值班人！");
								return false;
							}
						} else if(mobile[0].checked){
							if(isMobile($("rolemobile[${index}]").value.trim())){
								alert("${map.key.rolename}角色值班手机格式不正确！");
								return false;
							}
						}
					}
				</logic:iterate>
			</logic:present>
				if( window.confirm(message)){
					return true;
				} else {
					return false;
				}
			}
	    }
		
	}
   // function getPassword(){
   //     var loginType = document.forms[0].loginType.value;
       
   //     if("1"==loginType){//LDAP登陆

   //     }else{
    //    	var pass = document.forms[0].password.value;
   // 	    if(pass!=null && pass!=""){
   // 		    document.forms[0].repassword.value = pass;
    //	    }
    //    }
	    
   // }
//改变上级机构名称
//function changeParname(){
//	var obj = document.forms[0].orgidstr;
	//if(obj.value!=""){
	//	document.forms[0].orgname.value = obj.options[obj.selectedIndex].text;
	//}else{
	//	document.forms[0].orgname.value = "";
	//}
//}
//检查更新状态
//function checkStatus(){
//	var flag = '<%=request.getAttribute("edit_status")%>';
//	if("success"==flag){
//		alert("用户信息变更成功！");
//		window.close();
//	}
//}

function selectRoleManager(){
	<logic:present name="IGSYM02041VO" property="managerMap">
	<logic:iterate id="map" name="IGSYM02041VO" property="managerMap" indexId="index">
		<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
		<bean:define id="roleidstr" value="${map.key.roleid}" type="java.lang.String" />
		var rolemanager = document.getElementsByName("rolemanager[${index}]");
		var rolemobile = $("rolemobile[${index}]");
		var mobile = document.getElementsByName("mobile[${index}]");
		if(mobile) {
			var role_mobile = $("role_mobile[" + ${index} + "]");
			var role_manager = $("role_manager[" + ${index} + "]");
			for(var i = 0; i < <%= list.size()%>; i++) {
			<logic:present name="IGSYM02041VO" property="roleMap">
					if('${IGSYM02041VO.mobileMap[roleidstr]}' == "1") {
						if(rolemanager[i].value == '${IGSYM02041VO.roleMap[roleidstr]}') {
							rolemanager[i].checked = true;
							role_mobile.style.display = "none";
							role_manager.style.display = "";
							mobile[1].checked = true;
						}
					} else if("${IGSYM02041VO.mobileMap[roleidstr]}" == "0"){
							rolemobile.value = "${IGSYM02041VO.roleMap[roleidstr]}";
							role_mobile.style.display = "";
							role_manager.style.display = "none";
							mobile[0].checked = true;
					}
			</logic:present>
			}
		}
	</logic:iterate>
</logic:present>
}

function selectMobile(index){
	var role_mobile = $("role_mobile[" + index + "]");
	var role_manager = $("role_manager[" + index + "]");
	if(role_mobile.style.display == "none") {
		role_mobile.style.display = "";
		role_manager.style.display = "none";
	} else {
		role_mobile.style.display = "none";
		role_manager.style.display = "";
	}
}
//-->
	</script>
<body style="background-color: #FFFFFF; background-image: none;" onload="selectRoleManager()">
<div id="maincontent">
<!--header  头部和 一级菜单-->

<!--container 左菜单 右侧内容-->
 <!--content  右侧内容-->
<div id="container">
<html:form styleId="form"
	action="/IGSYM0204_UPDATE" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">用户信息变更</p>

</div>
<div id="formwrapper">
	<html:hidden name="IGSYM0202Form" property="loginType"/>
	
	<!--  message -->
	<ig:message /> 
	<!--  /message -->
	<fieldset>
		<legend>基本信息</legend>
	
	<div><label for="Name"><strong>用户ID</strong>：</label>
		<p class="p2"><bean:write property="userid" name="IGSYM0202Form"/></p>
		
	 <br />
	</div>
	<!--<div><label for="Name"><strong>所属角色</strong>：</label>
		<p class="p2"><bean:write property="userrolename" name="IGSYM0202Form"/></p>
		
	 <br />
	</div>
	-->
	<div><label for="Name"><strong>所属机构</strong>：</label>
		<p class="p2"><bean:write property="orgname" name="IGSYM0202Form"/></p>
	 <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>用户姓名</strong>：</label>
	<html:text property="username" maxlength="16" size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="3" /> <br />
	</div>
	<%-- <div><label for="Name"><strong><span class="red">*</span>客户经理号</strong>：</label>
	<html:text property="userinfo" maxlength="16" size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="3" /> <br />
	</div> --%>
	
	<logic:notEqual  name="IGSYM0202Form" property="loginType" value="1">
	<div><label for="Name"><strong><span class="red">*</span>用户口令</strong>：</label>
	<html:password property="password" maxlength="16" size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="4" /><span class="red" style="font-size:13px;">（长度在6-16之间，只能包含字母、数字和下划线）</span><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>确认口令</strong>：</label>
	<html:password property="repassword" maxlength="16" size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="4" /> <br />
	</div>
	 </logic:notEqual>
	
	
	<div><label for="Name"><strong><span class="red">*</span>用户手机1</strong>：</label> <html:text
		property="usermobile" maxlength="11" size="18" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
	<div><label for="Name"><strong>用户手机2</strong>：</label> <html:text
		property="fingerPrint" maxlength="11" size="18" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
<!--	<div><label for="Name"><strong>用户状态</strong>：</label><bean:write property="userstatus" name="IGSYM0202Form"/><br /></div>-->
	<div><label for="Name"><strong>用户电话</strong>：</label> <html:text
		property="userphone" maxlength="16" size="18" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
	<div><label for="Name"><strong>用户邮箱</strong>：</label> <html:text
		property="useremail" maxlength="40" size="18" style="width:300px;"
		errorStyleClass="inputError imeActive" tabindex="6" /> <br />
	</div>
	<div><label for="Name"><strong>用户说明</strong>：</label> <html:textarea
		property="userdesc" cols="60" rows="6" tabindex="7"
		errorStyleClass="inputError imeActive" /> <br />
	</div>
	</fieldset>
	</div>
<div id="formwrapper">
<fieldset>
		<legend>角色信息</legend>
		<div>
	<table class="table_style12" align="left">
	<tr>
	<th width="25%">所属角色</th>
	<th width="25%">角色类型</th>
	<th width="25%">值班联系方式</th>
	<th width="50%"></th>
	</tr>
	<logic:present name="IGSYM02041VO" property="managerMap">
	<logic:iterate id="map" name="IGSYM02041VO" property="managerMap" indexId="index">
		<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
			<tr>
			<td>${map.key.rolename}</td>
			<td><ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${map.key.roletype}" /></td>
			<td>
				<logic:iterate id="bean" name="list" length="1">
				<html:radio property="mobile[${index}]" value="0" onclick="selectMobile(${index})"/>值班手机
				<html:radio property="mobile[${index}]" value="1" onclick="selectMobile(${index})"/>值班人
				</logic:iterate>
			</td>
			<td style="display: none" id="role_manager[${index}]">
				<logic:iterate id="bean" name="list">
					<html:radio property="rolemanager[${index}]" value="${bean.userida}"/>${bean.username}&nbsp;&nbsp;&nbsp;
				</logic:iterate> 
			</td>
			<td style="" id="role_mobile[${index}]">
			<logic:iterate id="bean" name="list" length="1">
				<html:text property="rolemobile[${index}]" maxlength="11" size="18"/><html:hidden property="roleid[${index}]" value="${map.key.roleid}"/>
			</logic:iterate>	
			</td>
			</tr>
	</logic:iterate>
	</logic:present>
	</table>
	</div>
</fieldset>
</div>
<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置"  />
		<html:button styleClass="button" property="button" value="关闭" onclick="window.close()" ></html:button>
			
	</div>
	<html:hidden property="userid" styleId="userid" />
	<html:hidden property="mode" styleId="mode" />
	<html:hidden property="orgname" styleId="orgname" />
	<html:hidden property="orgidstr" styleId="orgidstr" />
	<html:hidden property="userstatus" styleId="userstatus" />
	<html:hidden property="usertype" styleId="usertype" />
	<html:hidden property="userinfo" styleId="userinfo" />
</html:form>
<div id="Placeholder"></div>
</div>

</div>
</body>
</html:html>
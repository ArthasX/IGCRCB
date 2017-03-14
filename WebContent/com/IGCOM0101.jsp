<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html:html>
<bean:define id="id" value="IGCOM0101" toScope="request" />
<bean:define id="title" value="登录画面" toScope="request" />	
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="ja">
<script src="<html:rewrite forward='common.js'/>"></script>
<script src="<html:rewrite forward='png.js'/>"></script>
<title><bean:write name="id"/><bean:write name="title"/></title>
<base target="_self">
<style type="text/css">
body,td,th {
	font-family: "宋体";
	font-size: 14px;
	color: #565e69;
}
body {
	background-color: #edefef;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background:url(images/cgb/bg.jpg) repeat-x top;
}
#apDiv1 {
	position:relative;
	margin:0px auto;
	left:626px;
	top:26px;
	width: 240px;
	height:160px;
	z-index: 1;
	float:left;
}
.b { font-size:14px; font-weight:bold;}
#text1 { width:150px; height:20px; text-align:left; color:#4e4e4e; font-size:12px; border:none; border-color:#fff; border:1px solid #d8d8d8;}
</style>

<script language="javascript">

function checkForm(){
	document.forms[0].page_width.value=window.screen.width;
	document.forms[0].submit();
}

function enterToTab(){
  if( event.keyCode == 13){
	  checkForm();
  }
}

function load(){
	document.forms[0].password.value = "";
	document.forms[0].userid.focus();
}
</script>
</head>
<center>
<html:form action="/IGCOM0101" onsubmit="return checkSubmit(this);">
<body id="userlogin_body" onload="load()">
<table width="1024" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="86"><img src="images/cgb/login1024_01.jpg" width="1024" height="183" alt="" /></td>
  </tr>
  <tr>
    <td height="61"><img src="images/cgb/login1024_02.jpg" width="1024" height="61" alt="" /></td>
  </tr>
  <tr>
    <td height="43"><img src="images/cgb/login1024_03.jpg" width="1024" height="43" alt="" /></td>
  </tr>
  <tr>
    <td height="176" style=" background-image:url(images/cgb/login1024_04.jpg)">
     <div id="apDiv1">
    <table width="240" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="62" height="45">用户名：</td>
      
        <c:if test="${IGCOM0101Form.userexist == ''}">
        <td width="178" height="45" align="left"><html:text property="userid"  styleId="text1"/></td>
      	</c:if>
      <c:if test="${IGCOM0101Form.userexist == '0'}">
	      <td width="178" height="45" align="left"><html:text property="userid"  styleId="text1"/></td>
	   	</c:if>
	   	<c:if test="${IGCOM0101Form.userexist == '1'}">
	     <td width="178" height="45" align="left"><html:text property="userid"   value=""  styleId="text1"/></td>
	   	</c:if>
      </tr>
    <tr>
      <td height="45">密&nbsp;&nbsp;码：</td>
      <td height="45" align="left"><html:password property="password"  styleId="text1"   onkeydown="enterToTab()"/></td>
      </tr>
    <tr>
    	<font style="font-size: 12px;color: red;"><ig:message /></font>
      <td height="68" colspan="2" align="center"><img src="images/cgb/btn.gif" width="190" height="38" onclick="checkForm()" onkeydown="enterToTab()" style="cursor:pointer" /></td>
      </tr>
    </table>
    </div>   
    </td>
  </tr>
  <tr>
    <td height="55"><img src="images/cgb/login1024_05.jpg" width="1024" height="55" alt="" />
     
    </td>
  </tr>
  <tr>
    <td height="51"><img src="images/cgb/login1024_06.jpg" width="1024" height="51" alt="" /></td>
  </tr>
  <tr>
    <td height="48"><img src="images/cgb/login1024_07.jpg" width="1024" height="48" alt="" /></td>
  </tr>
  <tr>
    <td height="48"><img src="images/cgb/login1024_08.jpg" width="1024" height="48" alt="" /></td>
  </tr>
  <tr>
    <td height="55"><img src="images/cgb/login1024_09.jpg" width="1024" height="55" alt="" /></td>
  </tr>
</table>
<input type="hidden" name="page_width" />
</body>
</html:form>
</center>
</html:html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>

<bean:define id="id" value="IGCOM0000" toScope="request" />
<bean:define id="title" value="错误信息" toScope="request" />
<bean:define id="error"
	name="<%=org.apache.struts.Globals.EXCEPTION_KEY%>" type="Throwable" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<html:rewrite forward='common.js'/>"></script>
<title>系统信息</title>
<link rel="stylesheet" href="<html:rewrite forward='master.css'/>"
	type="text/css">
<base target="_self" />
</head>

<script type="text/javascript">
	if (top.location != self.location)
		top.location=self.location;
	function switch_disp(tName) {
		tMenu = document.all[tName].style;
		if (tMenu.display == 'none')
			tMenu.display = "block";
		else
			tMenu.display = "none";
	}
	function switchIndex(){
		window.location="./IGCOM0105.do?screen_width="+window.screen.width;
	}
</script>
<body style="background-color: #FFFFFF; background-image: none;">
<div id="maincontent">
<div class="msg_box2">
<div class="msg_img"><img src="images/exception.gif" border="0" /></div>
<div class="msgcontent"><span style="font-size: 14px;">出现系统内部错误，请您联系技术支持！</span></div>
</div>
<div style="margin-top: 0px; margin-left: 420px;"><logic:present
	name="error">
	<logic:notMatch value="AuthException" name="error" property="class">
		<a href="javaScript:switch_disp('detail')"><html:img
			page="/images/add_att.gif" alt="错误信息" border="0" hspace="0" />错误信息</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:switchIndex()">返回首页画面</a>
		<div id="detail"
			style="display: none; border: solid; border-width: 1px; border-color: deepskyblue; background-color: mintcream; margin-left: -420px;">
		<pre>
		<%
			org.apache.commons.lang.exception.ExceptionUtils
								.printRootCauseStackTrace(error,
										new java.io.PrintWriter(out));
		%>
		</pre></div>
	</logic:notMatch>
</logic:present></div>
</div>
</body>
</html:html>


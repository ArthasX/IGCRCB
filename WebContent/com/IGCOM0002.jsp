<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<link rel="stylesheet" href="<html:rewrite forward='master.css'/>" type="text/css">
<script src="<html:rewrite forward='common.js'/>"></script>
<bean:define id="id" value="IGCOM0002" toScope="request" />
<bean:define id="title" value="错误信息" toScope="request" />

<script type="text/javascript">
	if (top.location != self.location)
		top.location=self.location;
</script>

<body style="background-color: #FFFFFF; background-image: none;">
<div id="maincontent">
<div id="container">
<div class="msg_box"><form id="form"
	onsubmit="return checkSubmit(this);" action="IGCOM0103.do">
	<div class="msg_img"><img src="images/exception.gif"
		border="0" /></div>
	<div class="msgcontent"><span style="font-size: 14px;">画面超时，请返回登录画面重新登录！</span>
	<div>
		<html:link action="/IGCOM0101_Disp.do">返回登录画面 </html:link>
	</div>
	</div>
</form></div>
</div>
</div>
</body>
</html:html>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<link rel="stylesheet" href="<html:rewrite forward='master.css'/>" type="text/css">
<bean:define id="id" value="IGCOM0001" toScope="request"/>
<bean:define id="title" value="文件下载错误信息" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->

<script type="text/javascript">
	if (top.location != self.location)
		top.location=self.location;
</script>

<body style="background-color: #FFFFFF; background-image: none;">
<div id="maincontent">
<div id="container">
<div class="msg_box1">
	<div class="msg_img"><img src="images/exception.gif"
		border="0" /></div>
	<div class="msgcontent"><span style="font-size: 14px;">文件下载出现错误，请参照以下信息！</span></div>
	<div class="msgbtn">
		<!--  message -->
        &nbsp;<ig:message/>
        <!--  /message -->
	</div>
</div>
</div>
</div>
</body>
</html:html>


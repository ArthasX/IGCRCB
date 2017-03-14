<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRJ0100" toScope="request" />
<bean:define id="title" value="信息提示页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div class="msg">
<div class="taps">信息提示</div>
</div>
<div class="msg_box">
	<div class="msg_img"><img src="images/Round_Icon_09.gif"
		border="0" /></div>
	<div class="msgcontent1"><ig:message/></div>
	<div class="msgbtn">
		<input type="button" value="返回" class="button" onclick="window.location='IGPRJ0101.do';" />
	</div>
	<input type="hidden" name="mode" value="1"/>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>


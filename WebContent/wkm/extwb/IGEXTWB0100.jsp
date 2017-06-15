<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGEXTWB0100" toScope="request" />
<bean:define id="title" value="工作成功页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div class="msg">
<div class="taps">信息提示</div>
</div>
<div class="msg_box"><html:form styleId="form" action="/IGWKM0101.do?prtype=WB">
	<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
	<div class="msgcontent1">
		<ig:message/>
	</div>
	<div class="msgbtn"><html:submit property="btn_back" value="工作管理" styleClass="button" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工作工单号：<a href="<bean:write name="url"/>"><bean:write
		name="prserialnum" /></a></div>
</html:form></div>
</div>
</div>
</div>
</div>
</body>
</html:html>


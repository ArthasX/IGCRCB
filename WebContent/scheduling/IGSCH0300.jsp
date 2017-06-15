<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSCH0300" toScope="request" />
<bean:define id="title" value="企业定时任务成功页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<%
	String type = request.getParameter("type");
	String path = request.getParameter("path");
%>
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
<div class="msg_box" style="<%="error".equals(type)?"display:none":"" %>">
<html:form styleId="form" action="/IGSCH0101.do">
	<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
	<div class="msgcontent1"><ig:message/></div>
	<div class="msgbtn"><html:submit property="submit" value="任务查询"
		styleClass="button" /></div>
</html:form>
</div>

<div class="msg_box" style="<%="error".equals(type)?"":"display:none" %>">
	<div class="msg_img"><img src="images/exception.gif" border="0" /></div>
	<div class="msgcontent1"><ig:message/></div>
	<div class="msgbtn">
		<html:submit property="button" value="返回" styleClass="button" onclick="window.location='GSCH0001_Disp.do?type=WA';"></html:submit>
	</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>


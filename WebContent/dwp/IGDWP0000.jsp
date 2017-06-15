<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDWP0000" toScope="request" />
<bean:define id="title"	value="成功页面" toScope="request" />
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
	<div class="msg_img">
		<img src="images/Round_Icon_09.gif" border="0" />
	</div>
	<div class="msgcontent1"><div class="txMessageInf">操作成功！</div>
		<input type="button" class="button" value="个人任务" onclick="window.location='IGDWP0102_Disp.do';" />
        <input type="button" class="button" value="我的任务" onclick="window.location='IGDWP0101_Back.do';" />
	</div>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
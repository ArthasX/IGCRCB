<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	String contextPath = request.getContextPath();
%>

<html:html>
<bean:define id="id" value="IGCOM0203" toScope="request" />
<bean:define id="title" value="服务管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容--><div id="contentWrap">
<div id="content">


<div class="caption">
<div class="caption_img"><img src="images/xmxx.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT03SDL0301">
	<html:link action="/IGCOM0202.do?linkID=IGPRJ0101&actname=ACT03SDL0301">值班管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT03SDL0301" permission="false">
 	值班管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>通过检查项、值班人、值班时间等相关设定从而对机房安全隐患，设备运行情况等进行有效的管理和监控。<br/>&nbsp;</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/ysgl.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT03SDL0401">
	<a href="IGCOM0202.do?linkID=IGFIN0102&actname=ACT03SDL0401">机房进出</a>
</ig:menuAuth>
<ig:menuAuth actname="ACT03SDL0401" permission="false">
 	机房进出
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>通过建立机房进入申请、审批的过程管理，实现机房进出授权、安全的机房出入管理流程。<br/><br/></p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/gzap.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT02SVC06011">
	<html:link action="/IGCOM0202.do?linkID=IGSVC0801&actname=ACT02SVC0601">维修记录</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT02SVC06011" permission="false">
 	维修记录
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对服务器、网络设备等硬件设备的维修过程进行流程化管理，了解设备的故障情况。</p>
</div>
</div>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>

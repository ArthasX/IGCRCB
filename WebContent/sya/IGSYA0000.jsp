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
<bean:define id="id" value="IGSYA0000" toScope="request" />
<bean:define id="title" value="制度汇编首页" toScope="request" />
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

	<div style="height: 130px;">
		<div class="caption">
			<div class="caption_img"><img src="images/zsgl.gif"
				width="64" height="64" /></div>
			<div class="caption_right">
				<div class="caption_title">
				<p class="fonts1">
				<ig:menuAuth actname="ACT18SYA0101">
					<html:link action="/IGCOM0202.do?linkID=IGSYA0101&actname=ACT18SYA0101">制度汇编</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT18SYA0101" permission="false">
				 	制度汇编
				</ig:menuAuth>
				</p>
				</div>
				<div class="caption_content">
				<p>统一管理科技管理部门的制度管理文档，实现统一、规范的管理目标。</p>
				</div>
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

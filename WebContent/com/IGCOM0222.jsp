<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0222" toScope="request" />
<bean:define id="title" value="考勤管理首页" toScope="request" />
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

<div class="caption">
<div class="caption_img">
  <img src="images/sbgl2.png" width="64" height="64" />
</div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT14UCI0103">
	<html:link action="/IGCOM0202.do?linkID=IGUCI0104&actname=ACT14UCI0103">考勤管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT14UCI0103" permission="false">
 	考勤管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对科技部门人员的日常工作考勤情况进行管理，同时可以管理请假情况，并可以进行考勤统计。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img">
  <img src="images/fpgl.png" width="64" height="64" />
</div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT14UCI1401">
	<html:link action="/IGCOM0202.do?linkID=IGASM2401&actname=ACT14UCI1401">发票管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT14UCI1401" permission="false">
 	发票管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对科技部门的日常报销费用情况进行管理，并可以将相关发票上传至影像系统。</p>
</div>
</div>
</div>

<div class="caption">
<div class="caption_img">
  <img src="images/Recent_Documents.png" width="64" height="64" />
</div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT14UCI0201">
	<html:link action="/IGCOM0202.do?linkID=IGUCI0203&actname=ACT14UCI0201">加班管理 </html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT14UCI0201" permission="false">
 	加班管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对科技部门人员的日常加班情况进行管理，同时可以对与日常加班相关的事项进行管理，并可以对加班情况进行统计。</p>
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
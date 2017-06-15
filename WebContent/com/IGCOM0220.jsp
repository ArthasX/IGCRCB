<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSVC0001" toScope="request" />
<bean:define id="title" value="流程管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div class="caption">
<div class="caption_img"><img src="images/lcfx.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT04STA01">
	<html:link action="/IGCOM0202.do?linkID=IGDBM0104&actname=ACT04STA01">运行分析</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04STA01" permission="false">
	运行分析
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>显示4台主机的实时情况，分析4台主机使用率年度趋势。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/yxfx.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT04STA02">
	<html:link action="/IGCOM0202.do?linkID=IGDBM0103&actname=ACT04STA02">流程分析</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04STA02" permission="false">
	流程分析
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>统计未解决的事件、问题、变更数量，分析各类流程的平均解决时间的趋势。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/zhbb.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT04STA03">
	<html:link action="/IGCOM0202.do?linkID=IGCOM0211&actname=ACT04STA02">综合报表</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04STA03" permission="false">
	综合报表
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>以表格、饼图、柱图、曲线展示统计信息。</p>
</div>
</div>
</div>

</div>
</body>
</html:html>

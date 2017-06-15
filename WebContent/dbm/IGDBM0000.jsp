<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0000" toScope="request" />
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
<div class="caption_img"><img src="images/db_technology.png"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT16DBM0101">
	<html:link action="/IGCOM0202.do?linkID=IGDBM1201">科技运行总体分析</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT16DBM0101" permission="false">
	科技运行总体分析
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>为科技领导实时了解科技运行总体情况提供全面视图，为科技发展决策提供数据支撑。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/technology_process.png"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT16DBM0101">
	<html:link action="/IGCOM0202.do?linkID=IGDBM1202">科技运行流程分析</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT16DBM0101" permission="false">
	科技运行流程分析
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对事件、问题、变更等各类流程的数据进行统计汇总，为领导层更好地掌握科技运行情况提供依据。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/db_information.png"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT16DBM0301">
	<html:link action="/IGCOM0202.do?linkID=IGDBM1203">信息安全综合分析</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT16DBM0301" permission="false">
	信息安全综合分析
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>汇总展现信息安全工作总体的进展情况，使科技领导能够实时掌握各类信息安全相关工作的执行情况。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/ndkjybp.jpg"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT16DBM0401">
	<html:link action="/IGCOM0202.do?linkID=IGSMR0902">年度科技仪表盘</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT16DBM0401" permission="false">
	年度科技仪表盘
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>汇总展现非现场监管报送工作的总体情况，为领导掌握非现场报送情况提供管理依据。</p>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>

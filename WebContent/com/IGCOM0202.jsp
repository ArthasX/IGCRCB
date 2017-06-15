<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0202" toScope="request" />
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
<div class="caption_img"><img src="images/phone_book.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT02SVC0101">
	<html:link action="/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01380&actname=ACT02SVC0115">服务台</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT02SVC0101" permission="false">
	服务台
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对个人工作、部门工作以及其他相关进行集中汇总展现，便于了解相关工作状态，保证工作的及时处理和工作流程的顺利完成。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/folder_conflicted.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT02SVC0201">
	<html:link action="/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01080&actname=ACT02SVC0201">事件管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT02SVC0201" permission="false">
	事件管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对影响运行和业务服务的事件处理过程进行驱动和记录，并对事件管理的时间信息、参与角色信息进行记录，以支持统计、评审、服务定级和人员绩效评估等。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/folder_modifieds.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT02SVC0301">
	<html:link action="/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=0108301&actname=ACT02SVC0301">问题管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT02SVC0301" permission="false">
	问题管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对各种被动性问题和主动性问题进行规范处理，找出根本原因或者薄弱环节，提出消除这些薄弱环节的建议，并提供统计分析，以提升管理、预防故障。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/ww.gif" width="64"
	height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT02SVC0401">
	<html:link action="/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01084&actname=ACT02SVC0401">变更管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT02SVC0401" permission="false">
	变更管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对变更处理过程的变更计划、变更审批、变更实施、变更验证等关键环节进行驱动和记录，并根据需要更新资产配置数据库，保证变更的成功和业务服务的稳定运行。</p>
</div>
</div>
</div>


<div class="caption">
<div class="caption_img"><img src="images/gzap.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT02SVC0601">
	<html:link action="/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01100&actname=ACT02SVC0601">科技服务请求</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT02SVC0601" permission="false">
 	科技服务请求
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>服务请求是对日常业务部门或者IT部门内部需要的IT服务请求进行统一管理，从而实现规范化和有序化，保证服务请求及时完成，并能够进行量化和考核。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/zsgl.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT02SVC0113">
		<html:link action="/IGCOM0202.do?linkID=IGKGM0205&actname=ACT02SVC0113">知识管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT02SVC0113" permission="false">
		知识管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对事件、问题、变更以及其他工作流程中的相关信息进行统一管理，便于知识积累和传递。</p>
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

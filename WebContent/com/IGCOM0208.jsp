<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0208" toScope="request" />
<bean:define id="title" value="审计管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单-->
 <div id="contentWrap">
   <div id="content">
   
 <div class="caption">
<div class="caption_img"><img src="images/nsxm.png"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT12IAM0104">
	<html:link action="/IGCOM0202.do?linkID=IGIAM0104&actname=ACT12IAM0104">内审项目管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT12IAM0104" permission="false">
 	内审项目管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>依据内审计划，审计人员需要定期发起内审项目，内容包括审计的范围、内容、目标、重点、实施步骤和时间等，规范日常内部审计工作，提高审计工作的执行效率、效果。</p>
</div>
</div>
</div>

<div class="caption">
<div class="caption_img"><img src="images/nsgz.png" width="64"
	height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT12IAM0201">
	<html:link action="/IGCOM0202.do?linkID=IGIAM0201&actname=ACT12IAM0201">内审工作管理 </html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT12IAM0201" permission="false">
 	内审工作管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>为审计稽核部门提供日常内审检查工作的记录、查询与管理功能。审计人员可以根据审计项目、计划要求，执行检查工作。<br/>&nbsp;</p>
</div>
</div>
</div>

<div class="caption">
<div class="caption_img"><img src="images/sjbg.png" width="64"
	height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT12IAM0401">
	<html:link action="/IGCOM0202.do?linkID=IGIAM0401&actname=ACT12IAM0401">审计报告管理 </html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT12IAM0401" permission="false">
 	审计报告管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>审计报告管理。<br/>&nbsp;</p>
</div>
</div>
</div>

<div class="caption">
<div class="caption_img"><img src="images/wsxm.png" width="64"
	height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT12IAM0303">
	<html:link action="/IGCOM0202.do?linkID=IGIAM0303&actname=ACT12IAM0303">外审项目管理 </html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT12IAM0303" permission="false">
 	外审项目管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>针对人民银行、银监会或其他监管部门的专项检查要求或外审计划要求，进行外部审计项目的登记管理，以及对外审发现问题的跟踪整改工作管理。<br/>&nbsp;</p>
</div>
</div>
</div>

<div class="caption">
<div class="caption_img"><img src="images/jcwtgl.gif" width="64"
	height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT12IAM0501">
	<html:link action="IGCOM0202.do?linkID=IGIAM0501&custom=0&prpdid_like_or=01183&prpdid_like_or=01206&prtype=WD&actname=ACT12IAM0501">检查问题管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT12IAM0501" permission="false">
 	检查问题管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>检查问题管理提供检查人员记录内审及外审过程中发现的问题，并制定相应的整改计划交由领导审批，审批通过后进行问题整改及进度跟踪。<br/>&nbsp;</p>
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
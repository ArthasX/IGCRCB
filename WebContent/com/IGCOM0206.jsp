<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0206" toScope="request" />
<bean:define id="title" value="外包管理首页" toScope="request" />
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
<div class="caption_img"><img src="images/wlgl.png"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT08EPI0101">
	<html:link action="/IGCOM0202.do?linkID=IGASM0901&actname=ACT08EPI0101">资源池管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT08EPI0101" permission="false">
 	资源池管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对供货商、服务商、服务记录等资源情况进行统一管理，并对服务商、服务记录等情况进行全面记录，以支持日常工作和业务管理的需要。</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/htgl.png" width="64"
	height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT08EPI0201">
	<html:link action="/IGCOM0202.do?linkID=IGASM0401&actname=ACT08EPI0201">合同管理 </html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT08EPI0201" permission="false">
 	合同管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对合同文本、签约方以及其他关键信息等进行分类管理，并可以根据业务需要设置相关提示，便于用户查阅参考，以支持各种日常工作和业务管理的需要。<br/>&nbsp;</p>
</div>
</div>
</div>
<div class="caption">
<div class="caption_img"><img src="images/fxpg.png" width="64"
	height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT08EPI0301">
	<html:link action="/IGCOM0202.do?linkID=IGRAM0501&prtype=WD4&actname=ACT08EPI0301">风险评估 </html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT08EPI0301" permission="false">
 	风险评估
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>在信息科技项目建设过程中，对服务商的经营能力、财务状况和服务能力等各个方面的风险进行评估，提前发现、分析、防范风险，有效防止服务商风险对项目建设的影响，保证业务系统的持续、稳定运行。</p>
</div>
</div>
</div>
<%--  <div class="caption">
<div class="caption_img"><img src="images/wlgl.gif"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT01ASM0902">
	<html:link action="/IGCOM0202.do?linkID=IGASM0903&actname=ACT01ASM0902">服务资产</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT01ASM0902" permission="false">
 	服务资产
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对供货商、服务商、服务记录等资源情况进行统一管理，并对服务商、服务记录等情况进行全面记录，以支持日常工作和业务管理的需要。<br/>&nbsp;</p>
</div>
</div>
</div> --%>
<%-- <div class="caption">
<div class="caption_img"><img src="images/htgl.gif" width="64"
	height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT01ASM1002">
	<html:link action="/IGCOM0202.do?linkID=IGASM0403&actname=ACT01ASM1002">合同资产 </html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT01ASM1002" permission="false">
 	合同资产
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>对合同文本、签约方以及其他关键信息等进行分类管理，并可以根据业务需要设置相关提示，便于用户查阅参考，以支持各种日常工作和业务管理的需要。</p>
</div>
</div>
</div>
 --%>
</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
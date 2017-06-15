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
<bean:define id="id" value="IGCOM0204" toScope="request" />
<bean:define id="title" value="信息安全首页" toScope="request" />
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
		<div class="caption_img"><img src="images/jcxgl.jpg"
			width="64" height="64" /></div>
		<div class="caption_right">
			<div class="caption_title">
				<p class="fonts1">
				<ig:menuAuth actname="ACT04RIS0701">
					<html:link action="/IGCOM0202.do?linkID=IGRIS0601&actname=ACT04RIS0701">检查项管理</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT04RIS0701" permission="false">
				 	检查项管理
				</ig:menuAuth>
				</p>
			</div>
			<div class="caption_content">
				<p>根据信息安全工作需要，制定相应的检查项。依据策略设定时选择的检查项来执行检查任务和检查工作。为检查策略的设定和检查任务及检查工作的执行提供了支撑。</p>
			</div>
		</div>
	</div>
	<div class="caption">
		<div class="caption_img"><img src="images/fxjc.gif"
			width="64" height="64" /></div>
		<div class="caption_right">
			<div class="caption_title">
			<p class="fonts1">
			<ig:menuAuth actname="ACT04RIS0101">
				<html:link action="/IGCOM0202.do?linkID=IGRIS0201&actname=ACT04RIS0101">检查策略管理</html:link>
			</ig:menuAuth>
			<ig:menuAuth actname="ACT04RIS0101" permission="false">
			 	检查策略管理
			</ig:menuAuth>
			</p>
			</div>
			<div class="caption_content">
			<p>根据ISO27001相关体系要求，对信息安全风险管理策略和检查工作进行灵活定义，根据策略自动分配给设定的执行人。</p>
			</div>
		</div>
	</div>
	<div class="caption">
		<div class="caption_img"><img src="images/jcwtgl.gif"
			width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
		<p class="fonts1">
		<ig:menuAuth actname="ACT04RIS0201">
				<html:link action="/IGCOM0202.do?linkID=IGRIS0301&prtype=WD&prpdid=01021&actname=ACT04RIS0201">检查问题管理</html:link>
		</ig:menuAuth>
		<ig:menuAuth actname="ACT04RIS0201" permission="false">
		 	检查问题管理
		</ig:menuAuth>
		</p>
		</div>
		<div class="caption_content">
		<p>提供检查人员记录常规信息安全检查过程中发现的问题，并制定相应的整改计划交由领导审批，审批通过后进行问题整改及进度跟踪。</p>
		</div>
		</div>
	</div>
</div>
<div>
	<div class="caption">
		<div class="caption_img"><img src="images/wtgjgl.gif"
			width="64" height="64" /></div>
		<div class="caption_right">
			<div class="caption_title">
				<p class="fonts1">
				<ig:menuAuth actname="ACT04RIS0302">
					<html:link action="/IGCOM0202.do?linkID=IGRIS0205&actname=ACT04RIS0302">检查任务管理</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT04RIS0302" permission="false">
				 	检查任务管理
				</ig:menuAuth>
				</p>
			</div>
			<div class="caption_content">
				<p>根据信息安全检查策略自动发起检查任务，由责任人或者合作人来执行该检查任务，填写检查结果和说明等。可以根据信息安全工作需要，发起指派检查工作，由其他部门或人员来配合检查，并根据实际检查情况发起检查问题流程。</p>
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

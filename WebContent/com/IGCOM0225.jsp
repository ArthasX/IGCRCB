<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0225" toScope="request" />
<bean:define id="title" value="配置审计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
 <div id="contentWrap">
  <div id="content">
   
<div class="caption">
	<div class="caption_img"><img src="images/ACT05AUT01.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT05AUT0101">
					<html:link action="/IGCOM0202.do?linkID=IGAUT0101&actname=ACT05AUT0101">审计任务管理</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT05AUT0101" permission="false">
 					审计任务管理
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>对审计任务统一管理。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT05AUT02.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT05AUT0201">
					<html:link action="/IGCOM0202.do?linkID=IGAUT0201&actname=ACT05AUT0201">审计执行 </html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT05AUT0201" permission="false">
 					审计执行
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>对主机、中间件、数据库、虚拟设备、网络设备审计执行。</p>
		</div>
	</div>
</div>


<div class="caption">
	<div class="caption_img"><img src="images/ACT05AUT03.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT05AUT0301">
					<html:link action="/IGCOM0202.do?linkID=IGCOM0500&actname=ACT05AUT0301">审计结果查看</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT05AUT0301" permission="false">
 					审计结果查看
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>对主机、中间件、数据库、虚拟设备、网络设备审计结果查看。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT05AUT04.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT05AUT0401">
					<html:link action="/IGCOM0202.do?linkID=IGCOM0500&actname=ACT05AUT0401">问题整改管理</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT05AUT0401" permission="false">
 					问题整改管理
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>可进行问题整改发起、审批、执行、结果填写、督导。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT05AUT05.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT05AUT0501">
					<html:link action="/IGCOM0202.do?linkID=IGCOM0500&actname=ACT05AUT0501">预警处置管理</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT05AUT0501" permission="false">
 					预警处置管理
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>可进行预警处置发起、审批、执行、结果填写、工作督导。</p>
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
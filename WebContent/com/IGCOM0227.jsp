<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0227" toScope="request" />
<bean:define id="title" value="网络管理" toScope="request" />
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
	<div class="caption_img"><img src="images/ACT18IOP02.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT18IOP0202">
					<html:link action="/IGCOM0202.do?linkID=IGCIM1701&actname=ACT18IOP0202">设备管理</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT18IOP0202" permission="false">
 					设备管理
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>对网络设备配置统一管理。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT18IOP03.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT18IOP0301">
					<html:link action="/IGCOM0202.do?linkID=IGNMS0101&actname=ACT18IOP0301">网络拓扑 </html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT18IOP0301" permission="false">
 					网络拓扑
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>可查看网络拓扑展示。</p>
		</div>
	</div>
</div>


<div class="caption">
	<div class="caption_img"><img src="images/ACT18IOP01.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT18IOP0102">
					<html:link action="/IGCOM0202.do?linkID=IGIOP0102&actname=ACT18IOP0102">子网管理</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT18IOP0102" permission="false">
 					子网管理
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>可对子网和IP进行分配、收回管理。</p>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0209" toScope="request" />
<bean:define id="title" value="资产配置首页" toScope="request" />
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
		<div class="caption_img"><img src="images/mxgl.gif"
			width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
		<p class="fonts1">
		<ig:menuAuth actname="ACT01ASM0101">
			<html:link action="/IGCOM0202.do?linkID=IGASM0101&actname=ACT01ASM0101">模型管理</html:link>
		</ig:menuAuth>
		<ig:menuAuth actname="ACT01ASM0101" permission="false">
		 	模型管理
		</ig:menuAuth>
		</p>
		</div>
		<div class="caption_content">
		<p>系统提供符合行业标准的一般性预制资产配置模型，用户根据需要，对资产配置模型进行调整和扩充，以记录和监控资产配置的全面信息和变化情况。</p>
		</div>
		</div>
		</div>

		<div class="caption">
		<div class="caption_img"><img src="images/sbgl.gif"
			width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
		<p class="fonts1">
		<ig:menuAuth actname="ACT01ASM0402">
			<html:link action="/IGCOM0202.do?linkID=IGASM0320&actname=ACT01ASM0402">设备资产 </html:link>
		</ig:menuAuth>
		<ig:menuAuth actname="ACT01ASM0402" permission="false">
		 	设备资产
		</ig:menuAuth>
		</p>
		</div>
		<div class="caption_content">
		<p>对IT设备资产及其配置属性、使用属性、业务属性、财务属性、相关工作和运行情况进行全面的管理监控和统计分析。<br/>&nbsp;</p>
		</div>
		</div>
		</div>

		<div class="caption">
		<div class="caption_img"><img src="images/jfgl.gif"
			width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
		<p class="fonts1">
		<ig:menuAuth actname="ACT01ASM1201">
		<html:link action="/IGCOM0202.do?linkID=IGASM1101&actname=ACT01ASM1201">机房管理</html:link>
		</ig:menuAuth>
		<ig:menuAuth actname="ACT01ASM1201" permission="false">
		 	机房管理
		</ig:menuAuth>
		</p>
		</div>
		<div class="caption_content">
		<p>对数据中心的机房、机柜、空间以及各种机房设施进行统一管理，并管理与设备等资产的关联关系，为数据中心的管理提供详实准确的资料，保证数据中心安全稳定运行。</p>
		</div>
		</div>
		</div>

</div>
</div>
</div>
</body>
</html:html>
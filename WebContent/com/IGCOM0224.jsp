<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0224" toScope="request" />
<bean:define id="title" value="监管报表管理" toScope="request" />
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
	<div class="caption_img"><img src="images/ACT16AFF01.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT12SMR0101">
					<html:link action="/IGCOM0202.do?linkID=IGPRD0101&pttype=WD1&actname=ACT12SMR0101">报表定义</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT12SMR0101" permission="false">
 					报表定义
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>用于对年报、季报、不定期报表的流程进行定义，支持对每张报表的内容、填报人员、状态节点权限等进行配置和定义。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT16AFF02.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT12SMR0201">
					<html:link action="/IGCOM0202.do?linkID=IGSMR0101&actname=ACT12SMR0201">年度报表</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT12SMR0201" permission="false">
 					年度报表
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>提供非现场监管报表之年度报表的填报工作发起，填报过程监督，填报提醒，填报校验，填报结果导出与查看等功能。</p>
		</div>
	</div>
</div>


<div class="caption">
	<div class="caption_img"><img src="images/ACT16AFF03.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT12SMR0301">
					<html:link action="/IGCOM0202.do?linkID=IGSMR0601&actname=ACT12SMR0301">季度报表</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT12SMR0301" permission="false">
 					季度报表
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>提供非现场监管报表之季度报表的填报工作发起，填报过程监督，填报提醒，填报校验，填报结果导出与查看等功能。</p>
		</div>
	</div>
</div>


<div class="caption">
	<div class="caption_img"><img src="images/ACT16AFF04.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT12SMR0401">
					<html:link action="/IGCOM0202.do?linkID=IGSMR0701&actname=ACT12SMR0401">不定期报表</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT12SMR0401" permission="false">
 					不定期报表
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>提供非现场监管报表之不定期报表的填报工作发起，填报过程监督，填报提醒，填报校验，填报结果导出与查看等功能。</p>
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
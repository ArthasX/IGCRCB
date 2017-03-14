<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0223" toScope="request" />
<bean:define id="title" value="业务应用管理" toScope="request" />
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
	<div class="caption_img"><img src="images/yhgl.png"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT15BUS0201">
					<html:link action="/IGCOM0202.do?linkID=IGCIM1401&actname=ACT15BUS0201">应用AB角管理</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT15BUS0201" permission="false">
 					应用AB角管理
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>对应用系统的AB管理员统一管理。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/yingyongguanli.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT15BUS0101">
					<html:link action="/IGCOM0202.do?linkID=IGAIM0102&actname=ACT15BUS0101">应用管理 </html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT15BUS0101" permission="false">
 					应用管理
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>对业务应用进行统一管理，并对信息变更和使用情况进行全面记录，以支持日常工作和业务应用管理的需要。</p>
		</div>
	</div>
</div>


<div class="caption">
	<div class="caption_img"><img src="images/peizhishenji.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT15BUS0301">
					<html:link action="/IGCOM0202.do?linkID=IGCIM0136&actname=ACT15BUS0301">应用管理分析</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT15BUS0301" permission="false">
 					应用管理分析
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>可进行数据库表分析、表空间预警设置、应用管理状况查询。</p>
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
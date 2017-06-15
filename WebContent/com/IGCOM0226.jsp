<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0226" toScope="request" />
<bean:define id="title" value="配置预警" toScope="request" />
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
	<div class="caption_img"><img src="images/ACT06CIM01.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT06CIM0101">
					<html:link action="/IGCOM0202.do?linkID=IGCIM1701&actname=ACT06CIM0101">数据库预警</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT06CIM0101" permission="false">
 					数据库预警
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>可查询数据库表空间、用户变更预警信息。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT06CIM02.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT06CIM0201">
					<html:link action="/IGCOM0202.do?linkID=IGCIM1703&actname=ACT06CIM0201">操作系统预警 </html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT06CIM0201" permission="false">
 					操作系统预警
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>可查询操作系统用户变更、磁盘空间预警信息。</p>
		</div>
	</div>
</div>


<div class="caption">
	<div class="caption_img"><img src="images/ACT06CIM03.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT06CIM0301">
					<html:link action="/IGCOM0202.do?linkID=IGCOM0500&actname=ACT06CIM0301">虚拟设备预警</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT06CIM0301" permission="false">
 					虚拟设备预警
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>可查看虚拟设备CPU、内存、磁盘空间预警信息。</p>
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
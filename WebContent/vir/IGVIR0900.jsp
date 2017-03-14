<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR0900" toScope="request" />
<bean:define id="title" value="计费管理" toScope="request" />
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
				<ig:menuAuth actname="ACT19ACC0101">
					<html:link action="IGCOM0202.do?linkID=IGVIR0901">计费策略</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT19ACC0101" permission="false">
 					计费策略
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>设定虚拟化资源的计费方式。</p>
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
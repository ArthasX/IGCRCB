<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR0800" toScope="request" />
<bean:define id="title" value="统计分析" toScope="request" />
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
				<ig:menuAuth actname="ACT20VIR0801">
					<html:link action="/IGCOM0202.do?linkID=IGVIR0801&actname=ACT20VIR0801">我的个人资源</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT20VIR0801" permission="false">
 					我的个人资源
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>快速查看我的个人资源。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT05AUT01.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT20VIR0802">
					<html:link action="/IGCOM0202.do?linkID=IGVIR0802&actname=ACT20VIR0802">人员资源 </html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT20VIR0802" permission="false">
 					人员资源
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>人员资源统计。</p>
		</div>
	</div>
</div>


<div class="caption">
	<div class="caption_img"><img src="images/jggl.gif"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT20VIR0803">
					<html:link action="/IGCOM0202.do?linkID=IGVIR0803&actname=ACT20VIR0803">我的部门资源</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT20VIR0803" permission="false">
 					我的部门资源
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>我的部门资源统计。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT05AUT01.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT20VIR0804">
					<html:link action="/IGCOM0202.do?linkID=IGVIR0804&actname=ACT20VIR0804">部门资源</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT20VIR0804" permission="false">
 					部门资源
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>部门资源统计。</p>
		</div>
	</div>
</div>

<div class="caption">
	<div class="caption_img"><img src="images/ACT05AUT01.jpg"	width="64" height="64" /></div>
	<div class="caption_right">
		<div class="caption_title">
			<p class="fonts1">
				<ig:menuAuth actname="ACT20VIR0805">
					<html:link action="/IGCOM0202.do?linkID=IGVIR0805&actname=ACT20VIR0805">项目资源</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT20VIR0805" permission="false">
 					项目资源
				</ig:menuAuth>
			</p>
		</div>
		<div class="caption_content">
			<p>项目资源统计。</p>
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
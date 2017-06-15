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
<bean:define id="id" value="IGCRC1500" toScope="request" />
<bean:define id="title" value="文档管理首页" toScope="request" />
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
		<div class="caption_img"><img src="images/fxjc.gif"
			width="64" height="64" /></div>
		<div class="caption_right">
			<div class="caption_title">
			<p class="fonts1">
			<ig:menuAuth actname="ACT15SVC0101">
				<html:link action="/IGCOM0202.do?linkID=IGCRC1301&actname=ACT15SVC0101">文档查询</html:link>
			</ig:menuAuth>
			<ig:menuAuth actname="ACT15SVC0101" permission="false">
			 	文档查询
			</ig:menuAuth>
			</p>
			</div>
			<div class="caption_content">
			<p>文档查询为文档管理员和科技人员提供所有入库文档的查看入口。可以通过科技管理类、软件开发类、生产运行类对文档进行分类检索，并且可以对文档进行详细信息的查看</p>
			</div>
		</div>
	</div>
	<div class="caption">
		<div class="caption_img"><img src="images/jcwtgl.gif"
			width="64" height="64" /></div>
		<div class="caption_right">
		<div class="caption_title">
		<p class="fonts1">
		<ig:menuAuth actname="ACT15SVC0201">
			<a href="IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01041&actname=ACT15SVC0201">文档入库</a>
		</ig:menuAuth>
		<ig:menuAuth actname="ACT15SVC0201" permission="false">
		 	文档入库
		</ig:menuAuth>
		</p>
		</div>
		<div class="caption_content">
		<p>通过科技部门人员对各IT文档的入库申请，文档管理员对文档的有效分类和管理，实现了文档管理的电子化、规范化</p>
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
				<ig:menuAuth actname="ACT15SVC0301">
					<a href="IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01120&actname=ACT15SVC0301">文档借阅</a>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT15SVC0301" permission="false">
				 	文档借阅
				</ig:menuAuth>
				</p>
			</div>
			<div class="caption_content">
				<p>科技人员可以通过文档借阅功能来借阅关注的文档，由文档管理员对借阅的文档进行审批和归还管理</p>
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

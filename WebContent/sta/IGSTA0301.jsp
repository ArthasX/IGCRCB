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
<bean:define id="id" value="IGSTA0301" toScope="request" />
<bean:define id="title" value="统计分析首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">

					<div style="height: 130px;">
						<div class="caption">
							<div class="caption_img">
								<img src="images/kejxtj.png" width="64" height="64" />
							</div>
							<div class="caption_right">

								<div class="caption_title">
									<p class="fonts1">
										<ig:menuAuth actname="ACT17STA01">
											<html:link
												action="/IGCOM0202.do?linkID=IGCRC2001&actname=ACT17STA0301">科技运行统计</html:link>
										</ig:menuAuth>
										<ig:menuAuth actname="ACT17STA01" permission="false">
											科技运行统计
										</ig:menuAuth>
									</p>
								</div>
								<div class="caption_content">
									<p>汇总科技运行相关的绩效指标统计，为科技领导实时了解科技运行总体情况提供全面的报表展现。</p>
								</div>
							</div>
						</div>
						<div class="caption">
							<div class="caption_img">
								<img src="images/xxaq.png" width="64" height="64" />
							</div>
							<div class="caption_right">
								<div class="caption_title">
									<p class="fonts1">
										<ig:menuAuth actname="ACT17STA02">
											<html:link
												action="/IGCOM0202.do?linkID=IGRIS0225&actname=ACT17STA0201">信息安全统计</html:link>
										</ig:menuAuth>
										<ig:menuAuth actname="ACT17STA02" permission="false">
										 	信息安全统计
										</ig:menuAuth>
									</p>
								</div>
								<div class="caption_content">
									<p>了解信息安全管理的总体工作情况，便于对检查问题和整改情况的跟踪。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</br></br></p>
								</div>
							</div>
						</div>
						<div class="caption">
							<div class="caption_img">
								<img src="images/gzjd.png" width="64" height="64" />
							</div>
							<div class="caption_right">
								<div class="caption_title">
									<p class="fonts1">
										<ig:menuAuth actname="ACT17STA03">
											<html:link
												action="/IGCOM0202.do?linkID=IGSVC0105&actname=ACT17STA0101">工作监督</html:link>
										</ig:menuAuth>
										<ig:menuAuth actname="ACT17STA03" permission="false">
										 	工作监督
										</ig:menuAuth>
									</p>
								</div>
								<div class="caption_content">
									<p>监督科技整体的运行情况，实时掌握各类工单的处理进展。</p>
								</div>
							</div>
						</div>
					</div>
					<div></div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>

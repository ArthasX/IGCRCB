<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<head>
</head>
<bean:define id="id" value="IGPRR0100" toScope="request" />
<bean:define id="title" value="工作成功页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
	<div id="container">
		<!--content  右侧内容-->
		<div id="contentWrap">
			<div id="content">
				<div class="msg">
					<div class="taps">信息提示</div>
				</div>
				<div class="msg_box">
					<html:form styleId="form" action="/IGWKM0101.do">
						<div class="msg_img">
							<img src="images/Round_Icon_09.gif" border="0" />
						</div>
						<div class="msgcontent1">
							<ig:message />
							<br /> <br /> <br />
							<div>
								<input type="button" name="btn_close" value="关闭"
									onclick="window.close()" class="button">
							</div>

						</div>

					</html:form>
				</div>
			</div>
		</div>
		<div class="zishiying"></div>
	</div>


</body>
</html:html>
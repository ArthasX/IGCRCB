<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGPRD0101" toScope="request" />
<bean:define id="title" value="流程查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGPRD0101" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation />&gt;&gt; 导入校验错误信息</p>
	<div class="back"><html:link href="IGPRD0101_Back.do">返回</html:link></div> 
	</div>
	<div>
	<logic:present name="IGPRD01012VO" property="errorMessages">
	<ul>
		<logic:iterate id="message" name="IGPRD01012VO" property="errorMessages">
			<li class="red">${message }</li>
		</logic:iterate>
	</ul>
	</logic:present>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>

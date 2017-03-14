<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1403" toScope="request" />
<bean:define id="title" value="信息提示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 --><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div class="msg">
<div class="taps">信息提示</div>
</div>
<div class="msg_box">
<html:form styleId="form" action="/IGDRM1401_RE" onsubmit="return checkSubmit(this);">
	<div class="msg_img"><img src="images/Round_Icon_09.gif"
		border="0" /></div>
	<div class="msgcontent"><ig:message /></div>
	<div class="msgbtn">
	<html:button property="btn_back" value="继续新增" styleClass="button" onclick="continueAdd()"/>
	<html:button property="btn_add_conf" value="通知管理" styleClass="button" onclick="mesManage()"/></div>
</html:form>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
<script type="text/javascript">
function continueAdd(){
	form.action = getAppRootUrl() + "/IGDRM1402_Disp.do";
	form.submit();
}
function mesManage(){
	form.action = getAppRootUrl() + "/IGDRM1401_Disp.do";
	form.submit();
}
</script>
</body>
</html:html>
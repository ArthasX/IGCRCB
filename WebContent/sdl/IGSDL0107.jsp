<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0107" toScope="request" />
<bean:define id="title" value="定时任务成功页面" toScope="request" />

<%
	String type = request.getParameter("type");
	String path = request.getParameter("path");
%>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function onPage(){
	//var date = document.forms[0].qjcrttime.value;
	//window.location = 'IGMTP0103_Disp.do?date=' + date;
	window.location = 'IGCOM0105.do';
}

</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div class="msg">
<div class="taps">信息提示</div>
</div>
<html:form>
<div class="msg_box">
	<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
	<div class="msgcontent1"><ig:message/></div>
	<div class="msgbtn">
	<input type="button" name="button" value="返回首页" class="button" onclick="onPage();" />
<!--	<input type="button" name="button" value="计划查询" class="button" onclick="window.location='IGSDL0110.do';" />-->
	</div>
</div>
</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<base target="_self"/>
<bean:define id="id" value="IGEXTWB0100" toScope="request" />
<bean:define id="title"  toScope="request">工作成功页面</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function show(url){
	url=url.replace(new RegExp('.do'),'_SOC.do');
	document.forms[0].action = url;
	document.forms[0].submit();
	//window.showModalDialog(url,null,"dialogwidth:1024px;dialogheight:600px;status:no;help:no;resizable:yes");
	//window.close();
}
</script>
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	background-color: #FFFFFF;
}
</style>

<body>
<div id="content">
<div class="msg" style="width：730px">
<div class="taps">信息提示</div>
</div>
<div class="msg_box"><html:form styleId="form" action="/IGWKM0101.do?prtype=WB">
	<div class="msg_img"><img src="images/Round_Icon_09.gif" border="0" /></div>
	<div class="msgcontent1">
		<ig:message/>
	</div>
	<div class="msgbtn">
	<html:button property="btn_back"  styleClass="button" onclick="window.close();">
		关闭
	</html:button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工作工单号：<a href="javascript:show('<bean:write name="url"/>')"><bean:write
		name="prserialnum" /></a></div>
</html:form></div>
</div>
</body>
</html:html>


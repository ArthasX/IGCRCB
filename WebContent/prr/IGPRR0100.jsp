<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGPRR0100" toScope="request" />
<bean:define id="title"	value="工作成功页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>
function changeAction(){
	<logic:equal name="pts" value="ID">
		document.forms[0].action = getAppRootUrl() + "/IGSVC0201_Disp.do";
	</logic:equal>
	<logic:equal name="pts" value="PD">
		document.forms[0].action = getAppRootUrl() + "/IGSVC0301_Disp.do";
	</logic:equal>
	<logic:equal name="pts" value="CD">
		document.forms[0].action = getAppRootUrl() + "/IGSVC0401_Disp.do";
	</logic:equal>
	<logic:equal name="pts" value="DD">
		document.forms[0].action = getAppRootUrl() + "/IGSVC0501_Disp.do";
	</logic:equal>
	<logic:equal name="pts" value="SD">
		document.forms[0].action = getAppRootUrl() + "/IGSVC0801_Disp.do";
	</logic:equal>
	<logic:equal name="pts" value="WD">
	<logic:equal name="pdid" value="0100401">
		document.forms[0].action = getAppRootUrl() + "/IGWKM0101_Disp.do?prtype=WD&prpdid=01004&actname=ACT02SVC1501";
	</logic:equal> 
	<logic:notEqual name="pdid" value="0100401">
		document.forms[0].action = getAppRootUrl() + "/IGCOM0202.do?linkID=IGWKM0101&prtype=WD&actname=ACT02SVC0903";
	</logic:notEqual>
</logic:equal> 
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
<div class="msg_box"><html:form styleId="form" action="/IGWKM0101.do">
	<div class="msg_img">
		<img src="images/Round_Icon_09.gif" border="0" />
	</div>
	<div class="msgcontent1"><ig:message/>
	<br/>
	<br/>
	<br/>
	<div>
	工单号：
	<a href="javascript:doLook('IGPRR0102_Disp.do?prtype=<bean:write name="pts" />&prid=${prid}')">${prserialnum}</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
	</div>
	
	</div>

</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
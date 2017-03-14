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
<base target="_self">
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
	<c:if test="${pdid=='0100001'}">
	//document.forms[0].action = getAppRootUrl() + "/IGORL0201_Disp.do";
	document.forms[0].action = getAppRootUrl() + "/IGWKM0101_Disp.do?prtype=WD";
	</c:if>
	<c:if test="${pdid=='0100101'}">
	document.forms[0].action = getAppRootUrl() + "/IGORL0101_Disp.do";
	</c:if>
	<c:if test="${pdid=='0100201'}">
	document.forms[0].action = getAppRootUrl() + "/IGORL0301_Disp.do";
	</c:if>
	<c:if test="${pdid=='0100301'}">
	document.forms[0].action = getAppRootUrl() + "/IGORL0303_Disp.do";
	</c:if>
	<c:if test="${pdid!='0100301'&&pdid!='0100201'&&pdid!='0100101'&&pdid!='0100001'}">
	document.forms[0].action = getAppRootUrl() + "/IGWKM0101_Disp.do?prtype=WD";
	</c:if>
	</logic:equal> 
}
function show(url){
	document.forms[0].action = url;
	document.forms[0].submit();
	//window.location=url;
	//window.showModalDialog(url,null,"dialogwidth:1024px;dialogheight:600px;status:no;help:no;resizable:yes");
	//window.close();
}
//跳转到知识登记页面
function onclick(){
	if(window.opener){
		window.opener.parent.location =getAppRootUrl() + "/IGKGM0201_Disp.do?prid=${prid}";
	}else{
		window.returnValue=getAppRootUrl() + "/IGKGM0201_Disp.do?prid=${prid}";
	}
	window.close();
}
</script>
</head>
<bean:define id="id" value="IGPRR0100" toScope="request" />

<logic:equal name="pts" value="ID">
<bean:define id="title"	value="事件成功页面" toScope="request" />
</logic:equal>
<logic:equal name="pts" value="PD">
<bean:define id="title"	value="问题成功页面" toScope="request" />
</logic:equal>
<logic:equal name="pts" value="CD">
<bean:define id="title"	value="变更成功页面" toScope="request" />

</logic:equal>
<logic:equal name="pts" value="DD">
<bean:define id="title"	value="发布成功页面" toScope="request" />

</logic:equal>
<logic:equal name="pts" value="SD">
<bean:define id="title"	value="服务成功页面" toScope="request" />

</logic:equal>
<logic:equal name="pts" value="WD">
		<c:if test="${pdid=='0100001'}">
			<bean:define id="title"	value="服务请求成功页面" toScope="request" />
		</c:if>
		<c:if test="${pdid=='0100101'}">
			<bean:define id="title"	value="故障成功页面" toScope="request" />
		</c:if>
		<c:if test="${pdid=='0100201'}">
			<bean:define id="title"	value="变更成功页面" toScope="request" />
		</c:if>
		<c:if test="${pdid=='0100301'}">
			<bean:define id="title"	value="紧急变更成功页面" toScope="request" />
		</c:if>
		<c:if test="${pdid!='0100301'&&pdid!='0100201'&&pdid!='0100101'&&pdid!='0100001'}">
			<bean:define id="title"	value="工作成功页面" toScope="request" />
		</c:if>
</logic:equal> 
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="content">
<div class="msg">
<div class="taps">信息提示</div>
</div>
<div class="msg_box"><html:form styleId="form" action="/IGWKM0101.do">
	<div class="msg_img">
		<img src="images/Round_Icon_09.gif" border="0" />
	</div>
	<div class="msgcontent1"><ig:message/></div>
	<div class="msgbtn"><html:button property="btn_back" value="关闭" styleClass="button" onclick="javascript:window.close();"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
	<logic:equal name="pts" value="ID">
		事件工单号
	</logic:equal>
	<logic:equal name="pts" value="PD">
		问题工单号
	</logic:equal>
	<logic:equal name="pts" value="CD">
		变更工单号
	</logic:equal>
	<logic:equal name="pts" value="DD">
		发布工单号
	</logic:equal>
	<logic:equal name="pts" value="SD">
		服务工单号
	</logic:equal>
	<logic:equal name="pts" value="WD">
		<c:if test="${pdid=='0100001'}">
			工单号
		</c:if>
		<c:if test="${pdid=='0100101'}">
			工单号
		</c:if>
		<c:if test="${pdid=='0100201'}">
			单号
		</c:if>
		<c:if test="${pdid=='0100301'}">
			工单号
		</c:if>
		<c:if test="${pdid!='0100301'&&pdid!='0100201'&&pdid!='0100101'&&pdid!='0100001'}">
			工单号
		</c:if>
	</logic:equal>：
	<a href="javascript:show('IGPRR0102_Disp_SOC.do?prtype=<bean:write name="pts" />&prid=${prid}')">${prserialnum}</a>
	<logic:equal name="knowledge" value="knowledge">
	<logic:equal name="prstatus" value="C">
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:onclick()"><bean:message bundle="prrResources" key="link.IGPRR0100.knowledge"/></a>
	</logic:equal>
	</logic:equal>
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
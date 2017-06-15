<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<head>
<bean:define id="id" value="IGPRD0160" toScope="request" />
<bean:define id="title" value="通知人页面" toScope="request" />
<script language="JavaScript">
<!--
function getArguments(){
	return window.dialogArguments;	
}

function returnAndClose(obj){
  window.returnValue = obj;
  window.close();	
}
//-->
</script> 
<base target="_self">
</head>
<frameset id="main">
	<frame name="init" scrolling="auto" src='<%=request.getContextPath()%>/IGPRD0159_Disp.do?rowIndex=${IGPRD0160Form.rowIndex}' frameborder="0"/>
</frameset>
<body>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<head>
<script language="JavaScript">
<!--
function getArguments(){
	return window.dialogArguments;	
}

function returnAndClose(obj){
  window.returnValue = obj;
  window.close();	
}
-->
</script> 
<base target="_top">
<title>IGSMR0200显示页面</title>
</head>

<frameset id="main">
	<frame name="init" scrolling="auto" src="${IGSMR0200Form.url}?prid=${IGSMR0200Form.prid}&pidid=${IGSMR0200Form.pidid}&rownumber=${IGSMR0200.rownumber}"
		frameborder="0" />
</frameset>
<body>
</body>
</html:html>
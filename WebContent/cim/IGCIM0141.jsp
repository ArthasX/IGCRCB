<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<head>
<base target="_self">
<title>IGASM0341<bean:message bundle="asmResources" key="ietitle.IGASM0341"/></title>
<script type="text/javascript">
var gid='IGASM0341';
</script>
</head>
	
	<frameset cols="30%,*" id="igasm0341">
    <frame id="leftFrame" src="<%=request.getContextPath() %>/IGASM0342.do?eiid=${IGASM0301Form.eiid}&eiversion=${IGASM0301Form.eiversion}&eismallversion=${IGASM0301Form.eismallversion}" name="leftFrame" scrolling="auto" />
    <frame id="rightFrame" src="#" name="rightFrame" scrolling="auto" />
  	</frameset>
 	
  
  	
<body >
</body>
</html:html>
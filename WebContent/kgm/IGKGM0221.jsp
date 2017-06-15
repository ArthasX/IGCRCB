<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<head>
<base target="_self">
<title>IGKGM0221知识登记页面</title>
</head>
<frameset id="main">
    <frame name="init" scrolling="auto"
      src="<%=request.getContextPath()%>/IGKGM0202_add.do?proid=${IGKGM0201Form.proid}" frameborder="0"/>
</frameset>
<body>
</body>
</html:html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="birt" uri="/WEB-INF/tlds/birt.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<body onload="load_yearAndTypes()">
<!--container 左菜单 右侧内容-->

<!-- birt 显示框架 -->
<birt:viewer id="1"
			 reportDesign="${IGRPT0402Form.reportPath}"
			 isHostPage="true"
			 showTitle="false"
			 pattern="run"
			 frameborder="no"
			 format="html"> 
<!--参数set-->

<birt:param name="pdid" value="${IGRPT0402Form.pdid}"></birt:param>
<birt:param name="psdcode" value="${IGRPT0402Form.psdcode}"></birt:param>
<birt:param name="pidid" value="${IGRPT0402Form.pidid}"></birt:param>
<birt:param name="pidvalue" value="${IGRPT0402Form.pidvalue}"></birt:param>
<birt:param name="title" value="${IGRPT0402Form.title}"></birt:param>

</birt:viewer>
</body>

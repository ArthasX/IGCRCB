<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="birt" uri="/WEB-INF/tlds/birt.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<body onload="load_yearAndTypes()">
<!--container 左菜单 右侧内容-->

<!--
 <div style="border-color: red;border-width: 2px;">
<input type="text" name="reportPath" value="${IGRPT0302Form.reportPath}">
<input type="text" name="mode" value="${IGRPT0302Form.mode}">
<input type="text" name="dateTime" value="${IGRPT0302Form.dateTime}">
<input type="text" name="timeType" value="${IGRPT0302Form.timeType}">
<input type="text" name="storageName" value="${IGRPT0302Form.storageName}">
<input type="text" name="businessName" value="${IGRPT0302Form.businessName}">
<input type="text" name="hostName" value="${IGRPT0302Form.hostName}">
<input type="text" name="dbName" value="${IGRPT0302Form.dbName}">
<input type="text" name="vgName" value="${IGRPT0302Form.vgName}">
<input type="text" name="fsName" value="${IGRPT0302Form.fsName}">
<input type="text" name="tsName" value="${IGRPT0302Form.tsName}">
</div>
-->
<!-- birt 显示框架 -->
<birt:viewer id="1"
			 reportDesign="${IGRPT0302Form.reportPath}"
			 isHostPage="true"
			 showTitle="false"
			 pattern="run"
			 frameborder="no"
			 format="html"> 
<!--参数set-->

<birt:param name="mode" value="${IGRPT0302Form.mode}"></birt:param>
<birt:param name="dateTime" value="${IGRPT0302Form.dateTime}"></birt:param>
<birt:param name="timeType" value="${IGRPT0302Form.timeType}"></birt:param>
<birt:param name="storageName" value="${IGRPT0302Form.storageName}"></birt:param>

<birt:param name="businessName" value="${IGRPT0302Form.businessName}"></birt:param>
<birt:param name="hostName" value="${IGRPT0302Form.hostName}"></birt:param>
<birt:param name="dbName" value="${IGRPT0302Form.dbName}"></birt:param>
<birt:param name="vgName" value="${IGRPT0302Form.vgName}"></birt:param>
<birt:param name="fsName" value="${IGRPT0302Form.fsName}"></birt:param>
<birt:param name="tsName" value="${IGRPT0302Form.tsName}"></birt:param>
<!--
-->
</birt:viewer>
<!-- birt 显示框架  -->
</body>

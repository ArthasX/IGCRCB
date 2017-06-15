<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="birt" uri="/WEB-INF/tlds/birt.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<bean:define id="id" value="IGSYM1408" toScope="request" />
<bean:define id="title" toScope="request" >
report
</bean:define>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!-- birt 显示框架  -->
<birt:viewer id="bw1"
			 reportDesign="${IGSYM1408Form.reportpath}"
			 isHostPage="true"
			 showTitle="false"
			 pattern="run"
			 frameborder="no"
			 format="html">
<!--参数set-->
<birt:param name="dataid" value="${IGSYM1408Form.dataid}"></birt:param>
<birt:param name="dateFrom" value="${IGSYM1408Form.dateFrom}"></birt:param>
<birt:param name="dateTo" value="${IGSYM1408Form.dateTo}"></birt:param>
<birt:param name="timetype" value="${IGSYM1408Form.timetype}"></birt:param>
<birt:param name="checkboxs" value="${IGSYM1408Form.checkboxs}"></birt:param>
<birt:param name="mode" value="${IGSYM1408Form.mode}"></birt:param>
<birt:param name="compareDate" value="${IGSYM1408Form.compareDate}"></birt:param>
<birt:param name="timeFrom" value="${IGSYM1408Form.timeFrom}"></birt:param>
<birt:param name="timeTo" value="${IGSYM1408Form.timeTo}"></birt:param>
<birt:param name="device" value="${IGSYM1408Form.device}"></birt:param>

<!-- <birt:param name="timeFrom" value="${IGSYM1408Form.timeFrom}"></birt:param>
<birt:param name="timeTo" value="${IGSYM1408Form.timeTo}"></birt:param>
<birt:param name="timetype" value="${IGSYM1408Form.timetype}"></birt:param>
<birt:param name="checkbox" value="${IGSYM1408Form.checkbox1}"></birt:param>
<birt:param name="compareDate1" value="${IGSYM1408Form.CDate1}"></birt:param>
<birt:param name="compareDate2" value="${IGSYM1408Form.CDate2}"></birt:param>
<birt:param name="compareDate3" value="${IGSYM1408Form.CDate3}"></birt:param>
<birt:param name="compareDate4" value="${IGSYM1408Form.CDate4}"></birt:param>
<birt:param name="compareDate5" value="${IGSYM1408Form.CDate5}"></birt:param>
<birt:param name="Mode" value="${IGSYM1408Form.mode}"></birt:param> -->
</birt:viewer>
<!-- birt 显示框架  -->
</body>
</html:html>
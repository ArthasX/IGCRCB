<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils"%>
<%@ page import="java.util.*"%>
<%@ page import="com.deliverik.framework.security.*"%>
<html:html>
<head>
<bean:define id="id" value="IGWKI0101" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
</head>

<body>
	<div id="maincontent">
		<jsp:include page="/include/header2.jsp" />
	</div>
	<div id="container">
		<div id="contentWrap">
			<div id="content">
				<table class="table_style">
					<tr>
						<th>序号</th>
						<th>工单类型</th>
						<th>说明</th>
					</tr>

					<logic:present name="thirdList" scope="session">
						<logic:iterate id="list" name="thirdList" indexId="index">
							<logic:iterate id="map" name="list">
								<bean:define id="action" name="map" property="key" />
								<tr class="<ig:rowcss index="${index}"/>">
									<td>${index+1}</td>
									<c:choose>
										<c:when test="${action.actdesc==1}">
											<td><html:link action="${action.acturl}">
													<span>${action.actlabel}</span>
												</html:link></td>
										</c:when>
										<c:otherwise>
											<td><span>${action.actlabel}</span></td>
										</c:otherwise>
									</c:choose>
									<td>${action.actdesc}</td>
								</tr>
							</logic:iterate>
						</logic:iterate>
					</logic:present>
				</table>
			</div>
		</div>
	</div>

</body>
</html:html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html:html>
<bean:define id="id" value="IGEXTWB0108" toScope="request" />
<bean:define id="title" value="状态日志" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<body>
<div id="maincontent">
<div id="container">
<html:form action="/IGEXTWB0108" styleId="form"
	onsubmit="return checkSubmit(this);">
<div id="location" style="margin-top: 10px">
<div class="image"></div>
<p class="fonts1">状态日志</p>
</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">序号</th>
			<th width="20%">状态</th>
			<th width="30%">开始时间</th>
			<th width="30%">结束时间</th>
		</tr>
		<logic:present name="IGEXTWB01081VO" property="recordStatusLogList">
			<logic:iterate id="bean" name="IGEXTWB01081VO" property="recordStatusLogList"
				indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td>${index + 1}</td>
					<td>
					<c:choose>
							<c:when test="${index == 0}">
								发起
							</c:when>
							<c:when test="${bean.prstatus == 'C'}">
								关闭
							</c:when>
							<c:otherwise>
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
							</c:otherwise>
						</c:choose>
					</td>
					<td><bean:write name="bean"  property="rslOpenTime"  format="yyyy-MM-dd HH:mm:ss"/></td>
					<td><bean:write name="bean"  property="rslCloseTime"  format="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</html:form></div>
</div>
</body>
</html:html>

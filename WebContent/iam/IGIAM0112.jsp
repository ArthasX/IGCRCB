<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGIAM0112" toScope="request" />
<bean:define id="title" value="审计项目查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function setValue(iapid, iapName){
	if(!window.opener.closed){
        window.opener.setPrjParams(iapid, iapName);
     }
    window.close();
}
</script>
<body>
<div id="maincontent">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">审计项目查询</p>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">年度</th>
				<th width="10%">审计项目名称</th>
				<th width="10%">审计对象</th>
				<th width="8%">审计方式</th>
				<th width="10%">审计人员</th>
			</tr>
			<logic:present name="IGIAM01011VO" property="helpSearchList">
			<logic:notEmpty name="IGIAM01011VO" property="helpSearchList">
				<logic:iterate id="bean" name="IGIAM01011VO" property="helpSearchList" indexId="index">
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="setValue('${bean.iapId}','${bean.iapName}');">
						<td>${bean.iapYear}</td>
						<td>${bean.iapName}</td>
						<td>${bean.iapObject}</td>
						<td>${bean.iapWay}</td>
						<td>${bean.iapUserName}</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>
			</logic:present>
	</table>
	</div>
</div>
<div class="zishiying"></div>

</div>
</body>
</html:html>
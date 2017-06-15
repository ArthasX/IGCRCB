<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSVC0633" toScope="request" />
<bean:define id="title" value="技术支持工单查看页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>
var gid = "IGSVC0633";
</script>
<body>
<div id="maincontent">
<div id="container">
    <div id="location" style="margin-top:10px">
        <div class="image"></div>
            <p class="fonts1">技术支持工单查看</p>
    </div>
	<jsp:include page="/include/IGSVC11.jsp">
		<jsp:param name="vo" value="IGSVC05131VO"/>
	</jsp:include>
	<div style="margin-top:50px;" align="center">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
		
</div>
</div>
</body>
</html:html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="com.deliverik.infogovernor.prr.vo.IGPRR01011VO"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>

<html>
<bean:define id="id" value="IGCRC3000" toScope="request" />
<bean:define id="title" value="服务请求提交附件测试" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<script src="<html:rewrite forward='script.js'/>"></script>
<script src="js/jquery.form.js"></script>
<script type="text/javascript">

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> 
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGCRC3001" styleId="formID" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div>
	<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;
	<table id="tb">
	</table>
	</div>
	<br>
	<input type="submit" value="提交">
</html:form>
</div>
</div>


</div>
</div>

</body>
</html>


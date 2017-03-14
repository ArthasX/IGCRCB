<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<link href="styles/baobiao.css" rel="stylesheet" type="text/css" />
<bean:define id="id" value="IGRPT0304" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="rptResources" key="ietitle.IGRPT0301"/>
</bean:define>
<jsp:include page="/include/header1.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function gotoTem(){
		var reportname=$('templateName').value;
		$('birti').src="IGRPT0302_Service.do?templateName="+reportname;
	}
</script>
<body onload="gotoTem()">
<!--container 左菜单 右侧内容-->
<html:form	action="/IGRPT0302_Service.do" >
 <div class="r_main">
          <div class="Contentbox3" >
            <div id="con_three_1" >
	<!-- 下为 birt viewer 框架 -->
   <iframe id="birti" width="808" height="488" frameborder="0" scrolling="auto" src="" >
	</iframe>
	</div>
   </div>
</div>
<input type="hidden" name="templateName" value="${IGRPT0302Form.templateName}"/>
</html:form>
</body>
</html:html>
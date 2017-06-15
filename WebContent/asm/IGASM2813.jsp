<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM2813" toScope="request"/>
<bean:define id="title" value="信息提示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	function toback(){
		var form = document.forms[0];
    	form.action = getAppRootUrl() + "/IGASM2804.do?org.apache.struts.taglib.html.CANCEL=1";
    	form.submit();
    }
	</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
  

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
 <div class="msg">
			<div class="taps">信息提示</div>
			</div>
			<div class="msg_box">
				<div class="msg_img"><img src="images/Round_Icon_09.gif"
					border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<html:form action="/IGASM2804">
		        <html:submit property="btn_back" value="返回" styleClass="button" onclick="toback();"/>
		        </html:form>
			</div>
			</div>
		 </div>
    </div>
</div>


</div>
</body>
</html:html>
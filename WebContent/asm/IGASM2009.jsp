<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM2009" toScope="request"/>
<bean:define id="title"  toScope="request" value="Domain基本信息登记成功画面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	function toAdd(){
		var eiddid=document.getElementById("eiddid").value;
		var version=document.getElementById("version").value;
		form.action = getAppRootUrl() + "/IGASM2004_Disp.do?eiddid="+eiddid+"&&eiddversion="+version;
		form.submit();
	}
	</script>
<body>
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
			 <html:form styleId="form" action="/IGASM2009" onsubmit="return checkSubmit(this);">
				<div class="msg_img"><img src="images/Round_Icon_09.gif"
					border="0" /></div>
				<div class="msgcontent"><ig:message/>
				<html:submit property="btn_add_conf" styleClass="button" onclick="toAdd();" styleId="btn_add_conf" value="增加Domain信息"/>
		        <html:submit property="btn_back"  styleClass="button" styleId="btn_back" value="返回"/>
			</div>
			</html:form>
			<html:hidden property="eiddid" styleId="eiddid" name="IGASM2002Form"/>
			<html:hidden property="version" styleId="version" name="IGASM2002Form"/>
			</div>
		 </div>
    </div>
</div>


</div>
</body>
</html:html>
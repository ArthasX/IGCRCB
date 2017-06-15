<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGPRD0163" toScope="request" />
<bean:define id="title" value="成功页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function toback() {
         form.action = getAppRootUrl() + "/IGPRD0161_List.do" ;
         form.submit();
	}
	function toback1(){
	     form.action = getAppRootUrl() + "/IGPRD0161_List.do" ;
	     form.submit();
	}
	 function add(){
	     form.action = getAppRootUrl() + "/IGPRD0161_Back.do";
	     form.submit();
	 }
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div class="msg">
<div class="taps">信息提示</div>
</div>
<div class="msg_box"><html:form styleId="form" action="/IGPRD0161_List.do"
	onsubmit="return checkSubmit(this);">
	<div class="msg_img"><img src="images/Round_Icon_09.gif"
		border="0" /></div>
	<div class="msgcontent"><ig:message /></div>
	<div class="msgbtn">
		<logic:equal name="form" property="mode" value="0">
		      <html:submit property="btn_add_conf" value="继续新增" styleClass="button" onclick="add();"/>
               <html:submit property="btn_next" value="返回" styleClass="button" onclick="toback()"/>
	    </logic:equal>
	    <logic:equal name="form" property="mode" value="1">
	         <html:submit property="btn_next" value="返回" styleClass="button" onclick="toback1()"/>
	    </logic:equal>
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
 
</body>
</html:html>

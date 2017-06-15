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
<bean:define id="id" value="IGCIM0809" toScope="request" />
<bean:define id="title" value="关系分析画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
	function execute(){
		form.action = getAppRootUrl() +"/IGCIM0809_Disp.do?editAction=execut";
		document.forms[0].submit();
	}
</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
     <div id="contentWrap">
     	<div id="content">
     		<html:form styleId="form" action="/IGCIM0809_Disp" onsubmit="return checkSubmit(this);">
     			<div id="location">
                <div class="image"></div>
                    <p class="fonts1">配置管理 &gt;&gt;配置采集&gt;&gt;关系分析</p>
            	</div>
            	<br/>
            	<div id="search">
            		<div class="img"></div>
                   	<div class="conditions">
                   	<div><label>&nbsp;&nbsp; Bat名： </label> 
                   		<html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" maxlength="21" size="80" readonly="true"></html:text>&nbsp;&nbsp; 
                   		<input type="submit" name="btn_search" value="分析" class="button" onclick="execute();">&nbsp;&nbsp;<ig:message/>
						</div>
                   </div>
            	</div>
            	<br/>
     		</html:form>
     	</div>
     </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
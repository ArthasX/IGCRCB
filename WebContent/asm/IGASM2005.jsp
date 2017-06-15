<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2005" toScope="request" />
<bean:define id="title" toScope="request" value="Domain详细信息界面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">资产管理 &gt;&gt; Domain管理&gt;&gt; Domain管理
	&gt;&gt; 详细信息
	</p>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGASM2005" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<div class="txMessageInf"></div>
	<!--  /message -->
	<fieldset>
	<legend>
	Domain详细信息
	</legend>
	<div>
	<label for="Name">
	<strong>
	Domain名称
	</strong>：
	</label> 
	<html:text property="name" tabindex="2" style="width: 200px;" readonly="true" styleId="name" name="IGASM2005Form"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	Domain描述
	</strong>：
	</label> 
	<html:textarea property="description" rows="4" style="width: 450px;" readonly="true" styleId="description" name="IGASM2005Form"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	Domain版本号
	</strong>：
	</label> 
	<html:text property="version" tabindex="2" style="width: 10px;" readonly="true" styleId="version" name="IGASM2005Form"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	创建时间
	</strong>：
	</label> 
	<html:text property="createtime" tabindex="2" style="width: 90px;" readonly="true" styleId="createtime" name="IGASM2005Form"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	更新时间
	</strong>：
	</label> 
	<html:text property="updatetime" tabindex="2" style="width: 90px;" readonly="true" styleId="updatetime" name="IGASM2005Form"/>
	<br>
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_back"  styleClass="button" styleId="btn_back" value="返回"/>
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
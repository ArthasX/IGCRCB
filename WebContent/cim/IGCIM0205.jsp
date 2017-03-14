<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0205" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0205" />
</bean:define>
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
<p class="fonts1">
	<bean:define id="urlable">
		<bean:message bundle="asmResources" key="navigation.IGASM.EiDomainDefInfo" />
	</bean:define>
	<ig:navigation extname1="${urlable}" />
	</p>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGCIM0205" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<div class="txMessageInf"></div>
	<!--  /message -->
	<fieldset>
	<legend>
	<bean:message bundle="asmResources" key="label.IGCIM0205.ShowEiDDInfo"/>
	</legend>
	<div>
	<label for="Name">
	<strong>
	<bean:message bundle="asmResources" key="label.IGCIM0205.Name"/>
	</strong>：
	</label> 
	<html:text property="name" tabindex="2" style="width: 200px;" readonly="true" styleId="name" name="IGCIM0205Form"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	<bean:message bundle="asmResources" key="label.IGCIM0205.Description" />
	</strong>：
	</label> 
	<html:textarea property="description" rows="4" style="width: 450px;" readonly="true" styleId="description" name="IGCIM0205Form"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	<bean:message bundle="asmResources" key="label.IGCIM0205.Version"/>
	</strong>：
	</label> 
	<html:text property="version" tabindex="2" style="width: 10px;" readonly="true" styleId="version" name="IGCIM0205Form"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	<bean:message bundle="asmResources" key="label.IGCIM0205.Createtime"/>
	</strong>：
	</label> 
	<html:text property="createtime" tabindex="2" style="width: 90px;" readonly="true" styleId="createtime" name="IGCIM0205Form"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	<bean:message bundle="asmResources" key="label.IGCIM0205.Updatetime"/>
	</strong>：
	</label> 
	<html:text property="updatetime" tabindex="2" style="width: 90px;" readonly="true" styleId="updatetime" name="IGCIM0205Form"/>
	<br>
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_back"  styleClass="button" styleId="btn_back">
	<bean:message bundle="asmResources" key="button.IGCIM0205.btn_return"/>
		  </html:submit></div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
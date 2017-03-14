<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2205" toScope="request" />
<bean:define id="title" toScope="request">
	CI更新任务登记
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var alertAutdesce = '请输入CI更新任务描述！';
	var argAutdesce='CI更新任务描述不能大于';
	var argAutdesceCount='个汉字！';
    if($F('citdesc').trim()==""){
        alert(alertAutdesce);
        return false;
    }
   
    if($F('citdesc').strlen()>256){
		alert(argAutdesce+Math.floor(256/strByteFlag)+argAutdesceCount);
		return false;
	}

}
function toback(){
	form.action = getAppRootUrl() + "/IGASM2207.do";
	form.submit();
}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">资产管理 &gt;&gt; CI更新管理 &gt;&gt; 任务登记</p>
	<div class="back"><a href="javascript:toback();" target="_self">返回</a>
	</div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGASM2205" onsubmit="return checkSubmit(this);">
	<div class="message"><ig:message/></div>
	<fieldset>
	<logic:equal name="IGASM2205Form" property="mode" value="0">
		<legend>CI更新任务信息登记</legend>
	</logic:equal> <logic:equal name="IGASM2205Form" property="mode" value="1">
		<legend>CI更新任务信息修改</legend>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span>CI更新任务描述</strong>：
		</label> 
		<html:text property="citdesc" tabindex="2" style="width: 200px;" name="IGASM2205Form" styleId="citdesc"/>
	<br>
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_insert"
		styleClass="button" onclick="return checkForm();" styleId="btn_insert">
		提交
	</html:submit>
	<html:reset property="btn_clear" styleClass="button" >
			重置
		</html:reset>
	</div>
	<html:hidden property="citid" name="IGASM2205Form" styleId="citid"/>
	<html:hidden property="cittime" name="IGASM2205Form" styleId="cittime"/>
	<html:hidden property="citstatus" name="IGASM2205Form" styleId="citstatus"/>
	<html:hidden property="mode" styleId="mode" name="IGASM2205Form"/>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0250" toScope="request" />
<bean:define id="title" value="食堂入库基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function confirmDisp(){
			
			if($("gorequsername").value.trim()==""){
				alert("请填写登记人！");
				return false;
			}

			if($F('gorequsername').strlen()>32){
				alert("登记人不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
				return false;
			}
			
			return true;
			//if( window.confirm("您确定要提交吗？")){
			//	return true;
			//} else {
			//	return false;
			//}
		
		
	}

//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 食堂入库</p>

</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGLOM0250" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
	<legend>食堂入库基本信息</legend>
	<div><label for="Name"><strong><span class="red">*</span>登记人</strong>：</label>
	<html:text property="gorequsername"  size="20"  errorStyleClass="inputError imeActive"/> <br />
	</div>
	
	</fieldset>
	<html:hidden property="rid"/>
	<html:hidden property="goorg"/>
	<html:hidden property="goorgname"/>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" /></div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
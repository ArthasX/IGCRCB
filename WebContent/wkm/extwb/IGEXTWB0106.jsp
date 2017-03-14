<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGEXTWB0106" toScope="request" />
<bean:define id="title" value="个人工作中止页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
<!--
<%-- 提交表单--%>
var gid='IGEXTWB0106'; 
function goPage(url){
	document.forms[0].action=url;
	document.forms[0].submit();
}

function checkForm(){	
	if($F('rlcomment').strlen()<1){
		alert("处理记录不能为空！");
		return false;
	}
	if($F('rlcomment').strlen()>2000){
		alert("备注信息不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
		return false;
	}
	if( window.confirm("您是否确认提交？")){
		return true;
	} else {
		return false;
	}
}
//-->
</script>
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单-->

<!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGEXTWB0106" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<%-- 变更编号--%>
	<html:hidden property="prid" />
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">中止</p>
	<div class="back"><a href="IGEXTWB0103_Disp.do?prid=<bean:write name="IGEXTWB0106Form" property="prid" />&bkmode=<bean:write name="IGEXTWB0106Form" property="bkmode" />" target="_self">返回</a></div> 
	</div>
	<jsp:include page="/include/IGEXTWB.jsp">
		<jsp:param name="vo" value="IGEXTWB01031VO"/>
	</jsp:include>
	<div class="title">
	<div class="name">处理记录</div>
	</div>
	<div id="formwrapper">
	<ig:message/>
	<fieldset>
	<div>
	<html:textarea property="rlcomment" cols="80" rows="8" errorStyleClass="inputError imeActive"></html:textarea>
	<br />
	</div>
	<div style="padding-left: 50px"><img src="images/attachment.gif" /><a
		href="javascript:addFile();" id="aAddAttach">添加附件</a>
	<table id="tb">
	</table>
	</div>
	</fieldset>
	<div class="enter"><html:submit styleClass="button" value="提交" onclick="return checkForm();"/>
	<html:reset styleClass="button" value="重置" /></div>
	<div class="Placeholder"></div>
	</div>
</html:form></div>
</div>


</div>
</div>
</body>
</html:html>


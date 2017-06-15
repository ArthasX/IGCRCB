<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0208" toScope="request" />
<bean:define id="title" value="物品调剂基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function confirmDisp(){
			
			
			if($("goorgname").value.trim()==""){
				alert("请选择调剂机构！");
				return false;
			}
			if($("gorequsername").value.trim()==""){
				alert("请填写调剂人！");
				return false;
			}

			if($F('gorequsername').strlen()>32){
				alert("调剂人不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
				return false;
			}
			
			return true;
			//if( window.confirm("您确定要提交吗？")){
			//	return true;
			//} else {
			//	return false;
			//}
		
		
	}
function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].goorg.value = "";
		document.forms[0].goorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].goorg.value = temp.split("|")[0];
		document.forms[0].goorgname.value = temp.split("|")[1];
	}		

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
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 物品调剂</p>

</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGLOM0208" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
	<legend>物品调剂基本信息</legend>
	
	
	
	<div><label for="Name"><strong><span class="red">*</span>调剂机构</strong>：</label>
	<html:text property="goorgname" readonly="true"></html:text>
	<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择调剂机构"/>
	<html:hidden property="goorg"/>
	<br/>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>调剂人</strong>：</label>
	<html:text property="gorequsername"  size="20"  errorStyleClass="inputError imeActive"/> <br />
	</div>
	
	</fieldset>
	<html:hidden property="rid"/>
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
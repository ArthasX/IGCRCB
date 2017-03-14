<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2006" toScope="request" />
<bean:define id="title" toScope="request" value="导入对象信息登记界面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var arg0= "导入对象基本信息";
	var alertImpnameRestrict= "实体名只能输入不大于128个字母和数字、或“_”、“.”的字符串！";
	var alertImpeiname ="请输入实体名称！";
	var alertImpcitype = "请选择顶级CI类型！";
	var argImpeiname="实体名称不能大于";
	var argImpeinameCount="个汉字！";
    if($F('impeiname').trim()==""){
        alert(alertImpeiname);
        return false;
    }
    if($F('impcitype').trim()==""){
        alert(alertImpcitype);
        return false;
    }
   
    if(checkUserid(document.IGASM2006Form.impeiname.value)){
        alert(alertImpnameRestrict);
        return false;
    }
    if($F('impeiname').strlen()>128){
		alert(argImpeiname+Math.floor(128/strByteFlag)+argImpeinameCount);
		return false;
	}

}
function checkUserid(str){      
	var patrn=/^([a-zA-Z0-9]|[._-]){1,128}$/;    
	if (!patrn.test(str)){
		return true;
	}else{
		return false;  
	}  
}
function toback(){
	form.action = getAppRootUrl() + "/IGASM2007.do";
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
<p class="fonts1">资产管理 &gt;&gt; 导入管理 &gt;&gt; 对象登记</p>
	<div class="back"><a href="javascript:toback();" target="_self">返回</a>
	</div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGASM2006" onsubmit="return checkSubmit(this);">
	<div class="message"><ig:message/></div>
	<fieldset>
	<logic:equal name="IGASM2006Form" property="mode" value="0">
		<legend>导入对象信息添加</legend>
	</logic:equal> <logic:equal name="IGASM2006Form" property="mode" value="1">
		<legend>导入对象信息修改</legend>
	</logic:equal>
	<div><label for="Name"><strong><span class="red">*</span>实体名称</strong>：
		</label> 
		<html:text property="impeiname" tabindex="2" style="width: 200px;" name="IGASM2006Form" styleId="impeiname"/>
	<br>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>顶级CI类型</strong>：
		</label> 
		 <html:select name="IGASM2006Form" styleId="impcitype" property="impcitype" style="width: 130px;" errorStyleClass="inputError">
	 		<html:options collection="ADImpTypeList" property="value" name="" labelProperty="label"/>
	 	</html:select>
		 <br>
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_insert"
		styleClass="button" onclick="return checkForm();" styleId="btn_insert" value="提交"/>
	<html:reset property="btn_clear" styleClass="button" value="重置"/>
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
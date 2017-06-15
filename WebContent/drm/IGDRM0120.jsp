<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0120" toScope="request"/>
<bean:define id="title" value="" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<link type="text/css" rel="stylesheet"	href="<html:rewrite forward='tree.css'/>">
<style type="text/css">
	a img{
		border: 0px;
	}
	.hover{
		background-color: #d3d3d3;
		cursor: pointer;
		
	}
	.leftd{
		text-align: left;
	}
</style>
<script type="text/javascript">	
	if('${closeFlag}'){
		window.opener.form1.submit();
		window.close();
	}
	function confirmDisp(){
		var keywordValue = jQuery("#keyword").val();
		var strategyDescValue = jQuery("#strategyDesc").val();
		var blArgs = jQuery("#rsargs").val();
		if(!keywordValue){
			alert("请输入关键字！");
			return false;
		}
		if(!strategyDescValue){
			alert("请输入触发策略描述！");
			return false;
		}
		if(keywordValue.strlen()>128){
			alert("关键字不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
			return false;
		}
		if(blArgs){
		}
		if(strategyDescValue.strlen()>2048){
			alert("触发策略描述不能大于"+Math.floor(2048/strByteFlag)+"个汉字！");
			return false;
		}
		
	}
</script>
<!-- /header1 -->
<body >
<!--container 左菜单 右侧内容-->
	<div id="container" style="width: 700px;">
    <!--content  右侧内容-->
    	<div id="contentWrap">  
    		<html:form action="IGDRM0119.do" method="POST">
    		<html:hidden property="senceid" styleId="senceid"/>
    		<html:hidden property="rsid" styleId="rsid"/>
		    <fieldset>
				<logic:empty name="IGDRM0119Form" property="rsid">	
					<legend>新增触发策略</legend>
				</logic:empty> 
				<logic:notEmpty name="IGDRM0119Form" property="rsid">	
					<legend>修改触发策略</legend>
				</logic:notEmpty> 
				<table class="entb">
					<tr>
						<th width="20%"><label for="Name"><strong><span class="red">*</span>关键字:</strong></label></th>
						<td width="50%"><html:text property="keyword" styleId="keyword" /></td>
						<TD width="30%">多个关键字使用空格分割</TD>
					</tr>
					<tr>
						<th><label for="Name"><strong>触发规则BL:</strong></label></th>
						<td><html:text property="handleBL" styleId="handleBL"   style="width:400px;" errorStyleClass="inputError imeActive" /></td>
					</tr>
						<tr>
						<th><label for="Name"><strong>触发规则参数:</strong></label></th>
						<td><html:text property="rsargs" styleId="rsargs"   style="width:400px;" errorStyleClass="inputError imeActive" /></td>
						<td>多个参数通过空格分割</td>
					</tr>
					<tr>
						<th><label for="Name"><strong><span class="red">*</span>触发策略描述:</strong></label></th>
						<td><html:textarea	property="strategyDesc" styleId="strategyDesc" cols="60" rows="6" errorStyleClass="inputError imeActive" /></td>
					</tr>
				</table>
				<div class="enter"><html:submit property="btn_insert" value="提交"
					styleClass="button" onclick="return confirmDisp();" /> 
				</div>
			</fieldset>
    	</html:form>
	</div>
</div> 

</body>
</html:html>
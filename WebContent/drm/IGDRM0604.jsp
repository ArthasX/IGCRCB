<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM0604" toScope="request" />
<bean:define id="title" value="演练计划查看" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function toback(){
		document.forms[0].action=getAppRootUrl() + "/IGDRM0602_Back.do";
		document.forms[0].submit();
	}
	function checkSubmit(){
		var eles=document.getElementsByName("diname");
		for(var i=0;i<eles.length-1;i++){
			if(eles[i].value.trim()==""){
				alert("请输入演练名称！");
				return false;
			}
			if(eles[i].value.strlen()>256){
				alert("演练名称不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
				return false;
			}
		}
		eles=document.getElementsByName("dicontant");
		for(var i=0;i<eles.length-1;i++){
			if(eles[i].value.trim()==""){
				alert("请输入演练内容！");
				return false;
			}
			if(eles[i].value.strlen()>1024){
				alert("演练内容不能大于"+Math.floor(1024/strByteFlag)+"个汉字！");
				return false;
			}
		}
		eles=document.getElementsByName("didutyorg");
		for(var i=0;i<eles.length-1;i++){
			if(eles[i].value.trim()==""){
				alert("请输入负责部门！");
				return false;
			}
			if(eles[i].value.strlen()>512){
				alert("演练部门不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
		}
		eles=document.getElementsByName("partorg");
		for(var i=0;i<eles.length-1;i++){
			if(eles[i].value.trim()==""){
				alert("请输入参与部门！");
				return false;
			}
			if(eles[i].value.strlen()>512){
				alert("参与部门不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
		}
		eles=document.getElementsByName("discene");
		for(var i=0;i<eles.length-1;i++){
			if(eles[i].value.trim()==""){
				alert("请输入场景！");
				return false;
			}
			if(eles[i].value.strlen()>512){
				alert("场景不能大于"+Math.floor(1024/strByteFlag)+"个汉字！");
				return false;
			}
		}
		if(window.confirm("确认提交？")){
			return true;
		}else{
			return false;
		}
	}
</script>
<style type="text/css">
.formwrapper  th{
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc;
}
.formwrapper  td{
	border-bottom: 1px solid #d3d3d3;
}
.table_form_group{
    border-collapse:collapse;  
    margin-top:-1px;   
    margin-bottom:-1px;   
    width:920px;
}
.entb{
	margin: auto;
	width: 100%;
}
.entb th{
	width: 15%;
	text-align: right;
}
.entb td{
	text-align: left;
}
.entb select{
	width: 170px;
}
.entb input{
	margin-left: 5px;
	height: auto;
}
.entb textarea{
	width: 85%;
	height: 100px;
}
.table_form_group tr th{
	text-align: right;
	height: 25px;
}
.table_form_group tr td{
	text-align: left;
}
</style>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script language="JavaScript" src="js/tableform.js" type="text/javascript" charset="gbk"></script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation/></p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGDRM0603_EDIT"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	
		<fieldset>
		<legend>演练计划基本信息</legend>
		
			<table class="entb">
				<tr>
					<th style="width:146px;"><label for="Name"><strong>演练计划名称:</strong></th>
					<td  > <input type="text" readonly="readonly" value="${IGDRM06031VO.drillplan.dname}" /></td>
				</tr>
				<tr>
					<th><label for="Name"><strong>演练计划描述:</strong></th>
					<td ><textarea rows=""readonly="readonly" cols="">${IGDRM06031VO.drillplan.depict}</textarea></td>
				</tr>
			</table>
	</fieldset>
	
	<div class="message"><ig:message /></div>
	<fieldset>
		<legend>演练计划详细信息</legend>
		<html:hidden property="did" name="IGDRM0603Form" />
		<br/>
			<table name="table_form"  border="0" 	id="tf">
			<% int count=0; %>
			<logic:present name="IGDRM06031VO" property="drillItemList" >
			<logic:iterate id="bean" type="com.deliverik.infogovernor.drm.model.DrillplanitemInfo" name="IGDRM06031VO" property="drillItemList" indexId="index">
			<%count++; %>
			<tr>
				<td valign="top" style="border: none;"></td>
				<td style="border: none;">
					<table class="table_form_group" style="width:960px" id="tf">
						<tr></tr>
						<tr>
							<th style="width: 15%">演练名称：</th>
							<td style="width: 35%; text-align: left;" colspan="1">
							${bean.diname}
							</td>
							<th style="width: 15%">演练预期时间：</th>
							<td style="width: 35%; text-align: left;" colspan="1">
							${bean.expecttime}
							</td>
						</tr>
						<tr>
							<th >演练负责部门：</th>
							<td  colspan="1">
								${bean.didutyorg}
							</td>
							<th >演练参与部门：</th>
							<td  colspan="1">
								${bean.partorg}
							</td>
						</tr>
						
						<!-- 场景信息如果没有 则隐藏 -->
						<logic:empty name="bean" property="discene">
							<tr style="display: none;">
						</logic:empty>
						<logic:notEmpty name="bean" property="discene">
							<tr>
						</logic:notEmpty>
							<th>场景：</th>
							<td  colspan="3">
								${bean.discene}
							</td>
							<td style="display:none">
							<input id="diid_${index}" rownumber="${index}" type="text" 
								name="diid" value="${bean.did}" />
							</td>
						</tr>
						<tr>
							<th >演练内容：</th>
							<td colspan="3">
								${bean.dicontant}
							</td>
						</tr>
					</table>
					</logic:iterate>
					</logic:present>
					<!-- 如果可以编辑 -->
				</td>
			</tr>
			<tr>
				<td valign="top" style="border: none;"></td>
				<td style="border: none;"></td>
			</tr>
		</table>
		
	</fieldset>
	
	
	<div class="enter">
	<html:button property="btn_insert" value="返回" styleClass="button" onclick="toback();" />
<%-- 	<html:cancel styleClass="button" value="返回" /> --%>
	</div>
</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>
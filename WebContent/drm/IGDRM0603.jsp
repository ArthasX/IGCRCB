<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM0603" toScope="request" />
<bean:define id="title" value="演练条目编辑" toScope="request" />

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
// 		eles=document.getElementsByName("discene");
// 		for(var i=0;i<eles.length-1;i++){
// 			if(eles[i].value.trim()==""){
// 				alert("请输入场景！");
// 				return false;
// 			}
// 			if(eles[i].value.strlen()>512){
// 				alert("场景不能大于"+Math.floor(1024/strByteFlag)+"个汉字！");
// 				return false;
// 			}
// 		}
		if(window.confirm("确认提交？")){
			return true;
		}else{
			return false;
		}
	}
</script>
<style type="text/css">
	.table_form_group{
    border-collapse:collapse;  
    margin-top:-1px;   
    margin-bottom:-1px;   
    width:960px;
    }
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
		<div><label for="Name"><strong><span class="red">*</span>演练计划名称</strong>：</label>
			<html:text property="dname" styleId="dname" maxlength="16" size="18" 
	 			style="width:300px;" errorStyleClass="inputError imeActive" 
	 			 />
			<br/>
			</div>
		
		<div><label for="Name"><strong><span class="red">*</span>演练计划描述</strong>：</label> <html:textarea
			property="depict" styleId="depict" cols="60" rows="6" 
			errorStyleClass="inputError imeActive" /> <br />
		</div>
	</fieldset>
	
	
	<div class="title">
	<div class="name">演练计划详细信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<!-- hidden -->
	<html:hidden property="did" name="IGDRM0603Form" />
	
	<table name="table_form"  border="0" style="margin: -2px;"
		id="tf">
		<% int count=0; %>
		<logic:present name="IGDRM06031VO" property="drillItemList" >
		<logic:iterate id="bean" type="com.deliverik.infogovernor.drm.model.DrillplanitemInfo" name="IGDRM06031VO" property="drillItemList" indexId="index">
		<%count++; %>
		<tr>
			<td valign="top" style="border: none;"><img
				src="images/bullet_delete.png" name="delImg"
				onclick="deleteGroup(this.parentElement.parentElement);"
				style="cursor: hand" border="0" /></td>
			<td style="border: none;">
				<table class="table_form_group" style="width:960px" id="tf">
					<tr></tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练名称：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="diname_${index}" rownumber="${index}" type="text" size="60"
							name="diname" value="${bean.diname}" />
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练预期时间：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="expecttime_${index}" readonly="true" rownumber="${index}" type="text" 
							name="expecttime"  onclick="showDate(this);" value="${bean.expecttime}" />
							
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练负责部门：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="didutyorg_${index}" rownumber="${index}" type="text" size="60"
							name="didutyorg" value="${bean.didutyorg}"/>
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练参与部门：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="partorg_${index}" rownumber="${index}" type="text" size="60"
							name="partorg" value="${bean.partorg}"/>
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练内容：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<textarea style="height:70px;width:500px;" id="dicontant_${index}" rownumber="${index}" type="text" 
							name="dicontant" value="${bean.dicontant}" >${bean.dicontant}</textarea>
						</td>
						<td style="display:none">
						<input id="diid_${index}" rownumber="${index}" type="text" 
							name="diid" value="${bean.did}" />
						</td>
					</tr>
				</table>
				</logic:iterate>
				</logic:present>
				<!-- 如果可以编辑 -->
				<c:if test="${justsee!='T'}">
				<%if(count==0){ %>
				<tr>
					<td valign="top" style="border: none;"><img
						src="images/bullet_delete.png" name="delImg"
						onclick="deleteGroup(this.parentElement.parentElement);"
						style="cursor: hand" border="0" /></td>
					<td style="border: none;">
					<table class="table_form_group" style="width:960px" id="tf">
					<tr></tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练名称：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="diname_1" rownumber="1" type="text" size="60"
							name="diname" value="" />
						</td>
					</tr>

					<tr>
						<th style="width: 15%"><span class="red">*</span>演练预期时间：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="expecttime_1" readonly="true" rownumber="1" type="text" 
							name="expecttime"  onclick="showDate(this);" value="" />
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练负责部门：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="didutyorg_1" rownumber="1" type="text" size="60"
							name="didutyorg" value="" />
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练参与部门：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="partorg_1" rownumber="1" type="text" size="60"
							name="partorg" value="" />
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练内容：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<textarea id="dicontant_1" style="height:70px;width:500px;" rownumber="1" type="text" 
							name="dicontant" value="" ></textarea>
						</td>
						<td style="display:none">
						<input id="diid_1" rownumber="1" type="text" 
							name="diid" value="" />
						</td>
					</tr>
					</table>		
				<%} %>
				</c:if>
			</td>
		</tr>
		<tr>
			<td valign="top" style="border: none;"><img
				src="images/bullet_add.png" name="演练计划"
				onclick="addGroup(this.parentElement.parentElement);"
				style="cursor: hand" border="0" /></td>
			<td style="border: none;"></td>
		</tr>
	</table>
	<table style="display: none;" style="width:960px" class="table_form_group"
		id="tf_template">
		<tr></tr>
					<tr>
						<th style="15"><span class="red">*</span>演练名称：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="diname__#_" rownumber="_#_" type="text" size="60"
							name="diname" value="" />
						</td>
					</tr>

					<tr>
						<th style="width: 15%"><span class="red">*</span>演练预期时间：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="expecttime__#_" readonly="true" rownumber="_#_" type="text" 
							name="expecttime"  onclick="showDate(this);" value="" />
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练负责部门：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="didutyorg__#_" rownumber="_#_" type="text" size="60"
							name="didutyorg" value="" />
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练参与部门：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<input id="partorg__#_" rownumber="_#_" type="text" size="60"
							name="partorg" value="" />
						</td>
					</tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练内容：</th>
						<td style="width: 85%; text-align: left;" colspan="1">
						<textarea id="dicontant__#_" style="height:70px;width:500px;" rownumber="_#_" type="text" 
							name="dicontant" value="" ></textarea>
						</td>
						<td style="display:none">
						<input id="diid__#_" rownumber="_#_" type="text" 
							name="diid" value="" />
						</td>
					</tr>
	</table>
	
	<div class="enter">
	<html:submit property="btn_insert" value="提交" styleClass="button" />
<%-- 	<html:cancel styleClass="button" value="返回" /> --%>
	</div>
</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>
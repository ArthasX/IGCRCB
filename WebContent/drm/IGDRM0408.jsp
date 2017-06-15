<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html:html>
<bean:define id="id" value="IGDRM0408" toScope="request" />
<bean:define id="title" value="应急资源快捷登记" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
#entBox th{
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc;
}
#entBox td{
	border-bottom: 1px solid #d3d3d3;
}
#entBox{
	width: 95%;
	text-align: center;
	padding: 5px;
	margin: 0 auto;
	margin-top: 2px;
}
.entb{
	margin: auto;
	width: 100%;
/* 	border-collapse: collapse; */
/* 	border: 1px solid #f3f3f3; */
}
.entb th{
	width: 15%;
	text-align: right;
/* 	vertical-align: top; */
}
.entb td{
	width: 35%;
/* 	border: 1px solid #f3f3f3; */
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
</style>
<script type="text/javascript">
var gid = 'IGDRM0408';//当前页面设置gid
//"归档部门"机构树选择设置
function setOrg(url) {
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp) {
		document.forms[0].eiorgsyscoding.value = "";
		document.forms[0].eiorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1) {
		document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
		document.forms[0].eiorgname.value = temp.split("|")[1];
	}
}
//"登记"按钮点击触发校验
function confirmDisp() {
	//文档类型配置校验
// 	if(!jQ("#txtType").val()){
// 		alert("请选择文档类型！");
// 		return false;
// 	}
	//资产基本创建校验
	if(!jQ("#einame").val()){
		alert("请输入应急资源名称！");
		return false;
	}
	if(jQ("#einame").val().strlen()>120){
		alert("应急资源名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
		return false;
	}
	
	if(!jQuery("[name='files']").val()){
		alert("添加附件信息！");
		return false;
	}
	//资产配置项创建校验
	var message = '<bean:message key="IGCO10000.W001" arg0="资源信息" />';
	if(window.confirm(message)){
		return true;
	} else {
		return false;
	}
}
</script>
<body>
<div id="maincontent" style="padding:10px;">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
 <!--content  右侧内容-->
 <div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">应急资源快捷登记</p>
	
	</div>
	<div id="mainBox">
	<html:form action="/IGDRM0408" styleId="form" enctype="multipart/form-data"  onsubmit="return checkSubmit(this);">
	<fieldset>
			<legend>应急资源快捷登记</legend>
		<div id ="entBox">
			<html:hidden styleId="parFlag" name="IGDRM0408Form"  property="parFlag"/>
			<html:hidden styleId="pidid" name="IGDRM0408Form"  property="pidid"/>
			<html:hidden property="eiid" name="IGDRM0408Form" styleId="eiid" />
			<html:hidden property="eilabel" name="IGDRM0408Form" styleId="eilabel" />
			<table class="entb">
				<tr>
					<th>
						<label for="Name">
							<strong>
								<span class="red">*</span>
								&nbsp;资源名称:&nbsp;&nbsp;
							</strong>
						</label>
					</th>
					<td>
						<html:text property="einame" styleId="einame" style="width:85%;"></html:text>
					</td>
					
				</tr>
				<tr>
					<th>
						<label for="Name">
							<strong>
								<span class="red">*</span>
								&nbsp;资源附件:&nbsp;&nbsp;
								<html:hidden property="cids" value="CI400000000001"/>
							</strong>
						</label>
					</th>
					<td>
						<html:file property="files" size="40" />
						<html:hidden property="civalues" value="ciattach"/>
					</td>
					
				</tr>
				
							
								
				
			
			</table>
			<html:submit property="btn_insert" styleId="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" />
		</div>
		</fieldset>
		</html:form>
		<div id="attrBox"></div>
	</div>
	<div class="zishiying"></div>
</div>
</div>
</body>
<script>
jQ(function(){
	if(jQ("#eiid").val()){
		if(!window.opener.closed){
			if(jQ("#parFlag").val()){
				window.opener.setParamIGDRM0406("CM40000000", "YJZY", "应急资源", jQ("#eiid").val(), jQ("#eilabel").val(), jQ("#einame").val() ,"040");
			}else{
				//javaScript:setParentValue('CM40000000', 'YJZC', '应急资源', '7152', 'YJZC-0007', '变变变', '040', '1', '999040' );
				//window.opener.setParamIGCOM0302("CM40000000", "YJZY", "应急资源", jQ("#eiid").val(), jQ("#eilabel").val(), jQ("#einame").val(),"1" ,"040","999040");
				window.opener.setParamIGCOM0302("CM40000000", "YJZY", "应急资源", jQ("#eiid").val(), jQ("#eilabel").val(), jQ("#einame").val() ,"040",jQ("#pidid").val(),"999040");
			}
		}
		window.close();
		
	}
});

</script>


</html:html>
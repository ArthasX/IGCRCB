<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM0401" toScope="request" />
<logic:empty name="IGDRM0401Form" property="eiidstr">
<bean:define id="title" value="应急资源登记" toScope="request" />
</logic:empty>
<logic:notEmpty name="IGDRM0401Form" property="eiidstr">
<bean:define id="title" value="应急资源维护" toScope="request" />
</logic:notEmpty>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js">
</script>
<script>

var jQ = jQuery.noConflict(true);
</script>
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
var gid = 'IGDRM0401';//当前页面设置gid
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
		alert("请输入资源名称！");
		return false;
	}
	if(jQ("#einame").val().strlen()>120){
		alert("资源名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
		return false;
	}
	if(!jQ("#eiinsdate").val()){
		alert("请选择创建日期！");
		return false;
	}
	if(!jQuery("[name='files']").val()){
		alert("添加附件信息！");
		return false;
	}
	
	//资产配置项创建校验
	var checkFlag = true;
	//资产属性校验
	jQ("[name='civalues']").each(function(i,obj){
		//资产表单
		var jForm = jQuery(obj);
		//资产表单父节点
		var jFormDiv = jForm.parent();
		//资产属性类型
		var cattach = jFormDiv[0].cattach;
		//必填 0：非必填; 1：必填
		var crequired = jFormDiv[0].crequired;
		//表单名称
		var cname = jFormDiv[0].cname;
		
		//资产表单为 文本框/文本域-校验
		if("0"==cattach||"6"==cattach){
			//必填 0：非必填; 1：必填
			if("1"==crequired){
				if(!jForm.val()||""==jForm.val()){
					alert("请输入"+cname+"!");
					checkFlag = false;
					return false;
				}
				if(jForm.val().strlen()>3000){
					alert(cname+ "不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
					checkFlag = false;
					return false;
				}
			}
		}
		//资产表单为 下拉框-校验
		if("2"==cattach){
			//必填 0：非必填; 1：必填
			if("1"==crequired){
				if(!jForm.val()||""==jForm.val()){
					alert("请输入"+cname+"!");
					checkFlag = false;
					return false;
				}
			}
		}
		
	});
	//资产属性校验 false 校验不过
	if(!checkFlag){
		return false;
	}
	var message = '<bean:message key="IGCO10000.W001" arg0="资源信息" />';
	if(window.confirm(message)){
		return true;
	} else {
		return false;
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/><logic:notEmpty name="IGDRM0401Form" property="eiidstr"> &gt;&gt; 应急资源详细信息</logic:notEmpty></p>
	<logic:notEmpty name="IGDRM0401Form" property="eiidstr">
		<div class="back">
			<logic:empty name="IGDRM0401Form" property="flag">
					<a href="javascript:void(0);" onclick="toBack()">返回</a> 
			</logic:empty>
			<logic:notEmpty name="IGDRM0401Form" property="flag">
				<a href="javascript:void(0);" onclick="toBackSearch()">返回</a>
			</logic:notEmpty>
		 </div>
	</logic:notEmpty>
	</div>
	<div id="mainBox">
	<html:form action="/IGDRM0401" styleId="form" enctype="multipart/form-data"  onsubmit="return checkSubmit(this);">
	<fieldset>
		<logic:empty name="IGDRM0401Form" property="eiidstr">
			<legend>应急资源登记</legend>
		</logic:empty>
		<logic:notEmpty name="IGDRM0401Form" property="eiidstr">
			<legend>应急资源详细信息</legend>
		</logic:notEmpty>
		<div id ="entBox">
			<html:hidden property="eiidstr" styleId="eiidstr" />
<%-- 			<html:hidden property="eid" value="${IGDRM04011VO.configurationList[0].eid }"/> --%>
<%-- 			<html:hidden property="esyscoding" styleId="esyscoding" value="${IGDRM04011VO.configurationList[0].esyscoding }"/> --%>
			<table class="entb" id = "tbcontent">
				<tr>
					<th><label for="Name"><strong>
					<logic:empty name="IGDRM0401Form" property="eiidstr">
					<span class="red">*</span></logic:empty>
					&nbsp;应急资源分类:&nbsp;&nbsp;</strong></label></th>
					<td >
						<input name="ename" id="ename" value="<ig:GetMOdelNameByEiid eiid='${fn:split(IGDRM0401Form.eiidstr,"_")[1] }' id='${fn:split(IGDRM0401Form.eiidstr,"_")[0]}'/>" readonly="true"/>
<%-- 							<ig:GetMOdelNameByEiid eiid='${IGDRM0401Form.eiidstr.split("_")[1] }' id='${IGDRM0401Form.eiidstr.split("_")[0]}'/> --%>
<!-- 						<img width="16" height="16" id="imagewyj" class="imgIcon" style="cursor: hand;" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999040&type=0&socflag=yes');" alt="应急资源分类" src="images/seek.gif"/> -->
						<html:hidden property="esyscoding" styleId="esyscoding" value="${IGDRM0401Form.esyscoding}"/>
						<html:hidden property="eid" styleId="eid"/>
					</td>
					<th><label for="Name"><strong>
					<logic:empty name="IGDRM0401Form" property="eiidstr">
					<span class="red">*</span></logic:empty>
					&nbsp;资源编号:&nbsp;&nbsp;</strong></label></th>
					<td><html:text property="eilabel" styleId="eilabel" value="${IGDRM0401Form.eilabel }"  errorStyleClass="inputError imeActive" readonly="true" /></td>
				</tr>
				<tr>
					<th><label for="Name"><strong>
					<logic:empty name="IGDRM0401Form" property="eiidstr">
					<span class="red">*</span></logic:empty>
					&nbsp;资源名称:&nbsp;&nbsp;</strong></label></th>
					<td><html:text property="einame" styleId="einame" value="${IGDRM0401Form.einame }" style="width:85%;" readonly="true" ></html:text></td>
					<th><label for="Name"><strong>
					<logic:empty name="IGDRM0401Form" property="eiidstr">
					<span class="red">*</span>
					</logic:empty>
					&nbsp;创建日期:&nbsp;&nbsp;</strong></label></th>
					<td>
						<html:text property="eiinsdate" styleId="eiinsdate" value="${IGDRM0401Form.eiinsdate}"  errorStyleClass="inputError imeActive" readonly="true" />
<!-- 						<img align="middle" class="imgIcon" id="imagerq" onclick="calendar($('eiinsdate'))" src="images/date.gif" border="0"/> -->
					</td>
				</tr>
<!-- 				<tr> -->
<!-- 				<th> <label for="Name"><strong>应急资源说明:&nbsp;&nbsp;</strong> </label></th> -->
<!-- 					<td colspan="3"> -->
<%-- 						<html:textarea property="eidesc" styleId="eidesc"></html:textarea> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
			</table>
			<logic:empty name="IGDRM0401Form" property="eiidstr">
			<html:submit property="btn_insert" styleId="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" />
			</logic:empty>
			<logic:empty name="IGDRM0401Form" property="flag">
			</logic:empty>
			<logic:notEmpty name="IGDRM0401Form" property="flag">
			</logic:notEmpty>
		</div>
		</fieldset>
		</html:form>
		<div id="attrBox"></div>
	</div>
	<div class="zishiying"></div>
</div>
</div>
</div>
</div>
</body>
<script>
jQ(function(){
	window.tempHtml = jQ("#tbcontent").html();
	var jEsyscoding = jQ("#esyscoding");
	if(jEsyscoding.val()){
		loadConfig({syscode:jEsyscoding.val()});
	}else{
		loadConfig({syscode:"999040"});
	}
	
});
function toBack(){
	window.location.href = getAppRootUrl()+"/IGDRM0402_Back.do";
}
function toBackSearch(){
	window.location.href = getAppRootUrl()+"/IGDRM0402_Search_Back.do";
}
function setViewMode(){
	if(jQ("#eiidstr").val()){
		jQ("#btn_insert").hide();
		jQ("#btn_back").show();
		jQ(":input").attr("readonly","true");
		jQ("textarea").each(function(i,t){
			t = jQ(t);
			t.after(t.val());
			t.hide();
		})
		jQ(".imgIcon").hide();
	}
}
function loadConfig(obj,temFun){
	//查看非修改
	if('${IGDRM04011VO.flag}'=='DISP'){
		jQ.ajax({
			url:getAppRootUrl()+"/IGDRM0401_Config_view.do?esyscoding="+obj.syscode+(jQ("#eiidstr").val()?"&eiidstr="+jQ("#eiidstr").val():""),
			dataType:"html",
			success:function(result){
				jQ("#tbcontent").html("");
				jQ("#tbcontent").html(tempHtml+result).find("[delflag]").remove();
// //	 			console.log(jQ("#tbcontent").find("#tempForm tbody").html());
				jQ("#tbcontent").find("#tempForm").replaceWith(jQ("#tbcontent").find("#tempForm tbody"));
				if(jQ.type(temFun)==="function"){
					temFun(obj);
				}
			}, error : function(){
				console.log("");
			}
		})
		
	}else{
		jQ.ajax({
			url:getAppRootUrl()+"/IGDRM0401_Config.do?esyscoding="+obj.syscode+(jQ("#eiidstr").val()?"&eiidstr="+jQ("#eiidstr").val():""),
			dataType:"html",
			success:function(result){
				jQ("#tbcontent").html("");
				jQ("#tbcontent").html(tempHtml+result).find("[delflag]").remove();
//	 			console.log(jQ("#tbcontent").find("#tempForm tbody").html());
				jQ("#tbcontent").find("#tempForm").replaceWith(jQ("#tbcontent").find("#tempForm tbody"));
				if(jQ.type(temFun)==="function"){
					temFun(obj);
				}
			}
		})
	}
	

}
function setEntity(url) {
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if ("_resetall" == temp) {
		document.getElementById("esyscoding").value = "";
		document.getElementById("ename").value = "";
		document.getElementById("eid").value = "";
		return false;
	}
		if (null != temp && temp.split("|").length > 1) {
			var syscode_eid = temp.split("|")[0];
			var name = temp.split("|")[1];
			var syscode;
			var eid;
			if (syscode_eid.split("_").length > 1) {
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
			}
			if (syscode == "999040") {
	// 			alert("应急资源分类不可用！请选择其他分类！");
				// 				return false;
			}
		
			var obj = {eid:eid,syscode:syscode,ename:name}	;
			loadConfig(obj,function(obj){
				document.getElementById("ename").value = obj.ename;
				document.getElementById("esyscoding").value = obj.syscode;
				document.getElementById("eid").value = obj.eid;
				jQ.ajax({
					url : getAppRootUrl() + "/IGDRM0401_Label.do",
					type : "POST",
					data : {
						eid : obj.eid
					},
					success : function(result) {
						jQ("#eilabel").val(result);
					}
				})
			});
		}
}

</script>


</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM0601" toScope="request" />
<bean:define id="title" value="演练计划信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">

.table_form{
    border-collapse:collapse;     
}
.table_form tr th{ 
	color:#000000;   
    border:1px solid #98c6f2; 
    background-color:#e8f2fc;
    text-align:center; 
    height:20px;      
    padding:0px;
}    
.table_form tr td{ 
    border:1px solid #98c6f2;
}

</style>
<script type="text/javascript">	

	//删除所选
	function confirmDisp(){
		
		if(!jQ("#dname").val()){
			alert("请输入演练计划名称！");
			return false;
		}
		if(!jQ("#depict").val()){
			alert("请输入演练计划描述！");
			return false;
		}
		if(jQ("#dname").val().strlen()>512){
			alert("演练计划名称不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
			return false;
		}
		if(jQ("#depict").val().strlen()>1024){
			alert("演练计划描述不能大于"+Math.floor(1024/strByteFlag)+"个汉字！");
			return false;
		}
		var flag = false;
		jQ("input:visible[name=expecttime]").each(function(i, t) {
		    t = jQ(t);
			if(!t.val()){
				alert("请输入演练预期时间！");
				t.focus();
				flag = true;
				return false;
			}
		});
		if(flag) return false;
		jQ("input:visible[name=diname]").each(function(i, t) {
		    t = jQ(t);
			if(!t.val()){
				alert("请输入演练名称！");
				t.focus();
				flag = true;
				return false;
			}
			if(t.val().strlen()>256){
				alert("演练名称不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
				t.focus();
				flag = true;
				return false;
			}
		});
		if(flag) return false;
		jQ("input:visible[name=didutyorg]").each(function(i, t) {
		    t = jQ(t);
			if(!t.val()){
				alert("请输入负责部门！");
				t.focus();
				flag = true;
				return false;
			}
			if(t.val().strlen()>512){
				alert("负责部门不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				t.focus();
				flag = true;
				return false;
			}
		});
		if(flag) return false;
		jQ("input:visible[name=partorg]").each(function(i, t) {
		    t = jQ(t);
			if(!t.val()){
				alert("请输入参与部门！");
				t.focus();
				flag = true;
				return false;
			}
			if(t.val().strlen()>512){
				alert("参与部门不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				t.focus();
				flag = true;
				return false;
			}
		});
		if(flag) return false;
		jQ("textarea:visible[name=dicontant]").each(function(i, t) {
		    t = jQ(t);
			if(!t.val()){
				alert("请输入演练内容！");
				t.focus();
				flag = true;
				return false;
			}
			if(t.val().strlen()>256){
				alert("演练内容不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
				t.focus();
				flag = true;
				return false;
			}
		});
		if(!flag&&window.confirm("确认提交？")){
			if('${IGDRM0601Form.dserial}' != ''){
				document.forms[0].action = getAppRootUrl() + "/IGDRM0601_Edit.do";
			}
			return true;
		}
		return false;
	}
function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgidstr.value = "";
		document.forms[0].orgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].orgidstr.value = temp.split("|")[0];
		document.forms[0].orgname.value = temp.split("|")[1];
	}		

}
//校验登录名：只能输入2-16个字符、可带数字、“_”、“.”的字串    
function checkUserid(str){      
	var patrn=/^([a-zA-Z0-9]|[._]){2,16}$/;
	if (!patrn.test(str)){
		return true;
	}else{
		return false;  
	}    
}  

	</script>
<style type="text/css">
.entb th{
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc;
}
.entb td{
	border-bottom: 1px solid #d3d3d3;
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
.table_form_group{
    border-collapse:collapse;  
    margin-top:-1px;   
    margin-bottom:-1px;   
    width:920px;
}
.table_form_group tr th{
	text-align: right;
}
.table_form_group tr td{
	text-align: left;
}
.table_form_group input{
	width: 240px;
}
</style>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script language="JavaScript" src="js/tableform.js" type="text/javascript" charset="gbk"></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">
<ig:navigation extname1="${urlable}"/>
<logic:notEmpty name="IGDRM0601Form" property="dserial">	
		>> 演练计划修改
</logic:notEmpty> 
</p>
<div class="back"><a href="IGDRM0602_Back.do" target="_self">返回</a></div> 
</div>
<div id="formwrapper">
<html:form styleId="form" action="/IGDRM0601_Insert" enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
	<logic:empty name="IGDRM0601Form" property="dserial">	
		<legend>演练计划定义</legend>
	</logic:empty> 
	<logic:notEmpty name="IGDRM0601Form" property="dserial">	
		<legend>修改演练计划</legend>
	</logic:notEmpty> 
		
		<table class="entb">
			<logic:notEmpty name="IGDRM0601Form" property="dserial">
				<tr>
					<th><label for="Name"><strong>演练计划编号:</strong></label></th>
					<td><html:text property="dserial" readonly="true"/></td>
				</tr>
			</logic:notEmpty> 
			<tr>
				<th><label for="Name"><strong><span class="red">*</span>演练计划名称:</strong></label></th>
				<td><html:text property="dname" styleId="dname"   	style="width:400px;" errorStyleClass="inputError imeActive" /></td>
			</tr>
			<tr>
				<th><label for="Name"><strong><span class="red">*</span>演练计划描述:</strong></label></th>
				<td><html:textarea	property="depict" styleId="depict" cols="60" rows="6" 		errorStyleClass="inputError imeActive" /></td>
			</tr>
		</table>
	
	
	</fieldset>
	
	<!-- SJY -->
	<fieldset>
	<legend>演练任务信息</legend>
	<div>
		<br />
	</div>
	<table name="table_form"  border="0" style="margin: -2px;" id="tf"  class="table_form"> 
		<% int count=0; %>
		<logic:present name="IGDRM06031VO" property="drillItemList" >
		<logic:iterate id="bean" type="com.deliverik.infogovernor.drm.model.DrillplanitemInfo" name="IGDRM06031VO" property="drillItemList" indexId="index">
		<%count++; %>
		<tr class="rightMenu">
<!-- 			<td valign="top" style="border: none;"><img -->
<!-- 				src="images/bullet_delete.png" name="delImg" -->
<!-- 				onclick="deleteGroup(this.parentElement.parentElement);" -->
<!-- 				style="cursor: hand" border="0" /></td> -->
			<td style="border: none;">
				<table class="table_form_group" style="width:920px" id="tf">
					<tr></tr>
					<tr>
						<th style="width: 15%"><span class="red">*</span>演练任务预期时间：</th>
						<td style="width: 35%;" colspan="1">
							<input id="expecttime_${index}" readonly="true" rownumber="${index}" type="text" 	name="expecttime"   value="${bean.expecttime}" />
							<img align="middle" style="cursor: hand;" onclick="showDateImg(this)" src="images/date.gif" border="0"/>
						</td>
						<th style="width: 15%"><span class="red">*</span>演练任务名称：</th>
						<td style="width: 35%; text-align: left;" colspan="1">
						<input id="diname_${index}" rownumber="${index}" type="text" size="60"
							name="diname" value="${bean.diname}" />
						</td>
					</tr>
					<tr>
						<th ><span class="red">*</span>演练任务负责部门：</th>
						<td  colspan="1">
						<input id="didutyorg_${index}" rownumber="${index}" type="text" size="60"
							name="didutyorg" value="${bean.didutyorg}" />
						</td>
						<th ><span class="red">*</span>演练任务参与部门：</th>
						<td colspan="1">
						<input id="partorg_${index}" rownumber="${index}" type="text" size="60"
							name="partorg" value="${bean.partorg}" />
						</td>
					</tr>
					<tr>
						<th ><span class="red">*</span>演练任务内容：</th>
						<td  colspan="3">
						<textarea style="height:70px;width:500px;" id="dicontant_${index}" rownumber="${index}" type="text" 
							name="dicontant" value="${bean.dicontant}" >${bean.dicontant}</textarea>
						</td>
						<td style="display:none">
						<input id="diid_${index}" rownumber="${index}" type="text" 	name="diid" value="${bean.diid}" />
						</td>
					</tr>
				</table>
				</logic:iterate>
				</logic:present>
				<!-- 如果可以编辑 -->
				<c:if test="${justsee!='T'}">
				<%if(count==0){ %>
				<tr class="rightMenu">
<!-- 					<td valign="top" style="border: none;"><img -->
<!-- 						src="images/bullet_delete.png" name="delImg" -->
<!-- 						onclick="deleteGroup(this.parentElement.parentElement);" -->
<!-- 						style="cursor: hand" border="0" /></td> -->
					<td style="border: none;">
					<table class="table_form_group" style="width:920px" id="tf" class="table_form">
						<tr>
							<th style="width: 15%"><span class="red">*</span>演练任务预期时间：</th>
							<td style="width: 35%; text-align: left;" colspan="1">
								<input id="expecttime_1" readonly="true" rownumber="1" type="text" 	name="expecttime"   value="" />
								<img align="middle" style="cursor: hand;" onclick="showDateImg(this)" src="images/date.gif" border="0"/>
							</td>
							<th style="width: 15%"><span class="red">*</span>演练任务名称：</th>
							<td style="width: 35%; text-align: left;" colspan="1">
								<input id="diname_1" rownumber="1" type="text" size="60"	name="diname" value="" />
							</td>
						</tr>
						<tr>
							<th ><span class="red">*</span>演练任务负责部门：</th>
							<td  colspan="1">
							<input id="didutyorg_1" rownumber="1" type="text" size="60"	name="didutyorg" value="" />
							</td>
							<th ><span class="red">*</span>演练任务参与部门：</th>
							<td  colspan="1">
							<input id="partorg_1" rownumber="1" type="text" size="60"	name="partorg" value="" />
							</td>
						</tr>
						<tr>
							<th ><span class="red">*</span>演练任务内容：</th>
							<td  colspan="3">
								<textarea id="dicontant_1" style="height:70px;width:500px;" rownumber="1" type="text" 
								name="dicontant" value="" ></textarea>
							</td>
							<td style="display:none">
								<input id="diid_1" rownumber="1" type="text" 	name="diid" value="" />
							</td>
						</tr>
					</table>		
				<%} %>
				</c:if>
			</td>
		</tr>
<!-- 		<tr class="rightMenu"> -->
<!-- 			<td valign="top" style="border: none;"><img -->
<!-- 				src="images/bullet_add.png" name="演练计划" -->
<!-- 				onclick="addGroup(this.parentElement.parentElement);" -->
<!-- 				style="cursor: hand" border="0" /></td> -->
<!-- 			<td style="border: none;"></td> -->
<!-- 		</tr> -->
	</table>
	<table style="display: none;" style="width:920px" class="table_form_group" id="tf_template" class="table_form">
<!-- 		<tr></tr> -->
		<tr>
			<th style="width: 15%"><span class="red">*</span>演练任务预期时间：</th>
			<td style="width: 35%; text-align: left;" colspan="1">
				<input id="expecttime__#_" readonly="true" rownumber="_#_" type="text" 	name="expecttime"   value="" />
				<img align="middle" style="cursor: hand;" onclick="showDateImg(this)" src="images/date.gif" border="0"/>
			</td>
			<th style="width: 15%"><span class="red">*</span>演练任务名称：</th>
			<td style="width: 35%; text-align: left;" colspan="1">
			<input id="diname__#_" rownumber="_#_" type="text" size="60"
				name="diname" value="" />
			</td>
		</tr>
		<tr>
			<th ><span class="red">*</span>演练任务负责部门：</th>
			<td  colspan="1">
			<input id="didutyorg__#_" rownumber="_#_" type="text" size="60"
				name="didutyorg" value="" />
			</td>
			<th ><span class="red">*</span>演练任务参与部门：</th>
			<td colspan="1">
			<input id="partorg__#_" rownumber="_#_" type="text" size="60"
				name="partorg" value="" />
			</td>
		</tr>
		<tr>
			<th ><span class="red">*</span>演练任务内容：</th>
			<td  colspan="3">
			<textarea id="dicontant__#_" style="height:70px;width:500px;" rownumber="_#_" type="text" 
				name="dicontant" value="" ></textarea>
			</td>
			<td style="display:none">
			<input id="diid__#_" rownumber="_#_" type="text" 
				name="diid" value="" />
			</td>
		</tr>
	</table>
	</fieldset>
	<!-- SJY -->
	
	<c:if test="${justsee!='T'}">
		<div class="enter"><html:submit property="btn_insert" value="提交"
			styleClass="button" onclick="return confirmDisp();" /> 
		</div>
	</c:if>
	<html:hidden property="judgestatus" styleId="judgestatus" />
	<html:hidden property="did" styleId="did" name="IGDRM0601Form"/>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
	<script>
		function showDateImg(obj){
				showDate(jQ(obj).prev()[0]);
		}
			
	</script>
</html:html>
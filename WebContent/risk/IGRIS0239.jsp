<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGRIS0239" toScope="request" />
<bean:define id="title" value="指派检查工作批量分派" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<style type="text/css">
	.table_style4{    
	    width:100%;    
	    margin:0 auto;    
	    border-collapse:collapse;     
	    text-align:center;    
	}    
	.table_style4 th{
		color:#000000;   
	    border-top:1px solid #CCCCCC; 
	    background-color:#EEEEEE; 
	    height:20px;    
	}
</style>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">
function toSave(){
<logic:present name="IGCRC04031VO" property="assignInfo">
	<logic:iterate id="map" name="IGCRC04031VO" property="assignInfo" indexId="index">
		<c:if test="${map.key.assignflag == '1'}">
	   		var status${index} = document.getElementsByTagName("input");
	   		var noHasStatusUser${index} = true;
	   		for(var i=0;i<status${index}.length;i++){
		   		if(status${index}[i].type=="checkbox" &&
				   		status${index}[i].value.indexOf("${map.key.psdid}") == 0 && status${index}[i].checked){
		   			noHasStatusUser${index} = false;
		   		}
		   	}
	   		if(noHasStatusUser${index}) {
		   		alert("请选择${map.key.psdname}参与者！");	
		       	return false;
			}
		</c:if>
	</logic:iterate>
</logic:present>
    if(window.confirm("您是否确认提交？")){
    	  return true;
    } else {
        return false;
    }
}
function initSelected() {
	initSelectRole();
	hideRole();
}
function initSelectRole() {
	var arr_role = document.getElementsByName("role");
	var arr_roleid = new Array();
	var str_role = "<option value=''></option>";
	var split_role;
	var flag = true;
	for(var i = 0; i < arr_role.length; i++){
		split_role = arr_role[i].value.split("_");
		if($("role_" + split_role[0] + "_" + split_role[1]) && $("role_" + split_role[0] + "_" + split_role[1]).style.display == "none") {
			flag = false;
		}
		if(flag) {
			for(var k = 0; k < arr_roleid.length; k++) {
				if(arr_roleid[k] && arr_roleid[k].split("_")[1] == split_role[1]) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			arr_roleid[i] = split_role[0] + "_" + split_role[1];
			str_role += "<option value='" + split_role[1] + "'>" + split_role[2] + "</option>";
		}
		flag = true;
	}
	$("roleid_q").outerHTML = "<select name='roleid_q' id='roleid_q'>" + str_role + "</select>";
}
function fun_search() {
	displayRole();
	hideUser();
	hideRole();
}
function hideUser() {
	var arr_participants = document.getElementsByName("participants");
	var arr_username = document.getElementsByName("username");
	var arr_orgid = document.getElementsByName("orgid");
	var arr_userroleid = document.getElementsByName("userroleid");
	for(var i = 0; i < arr_username.length; i++){
		if(!arr_participants[i].checked) {
			if(
				($F("username_q").trim() == "" || arr_username[i].value.indexOf($F("username_q").trim()) >= 0)
				&& ($F("orgid_q").trim() == "" || arr_orgid[i].value.indexOf($F("orgid_q").trim()) >= 0)
				&& ($F("roleid_q").trim() == "" || arr_userroleid[i].value == $F("roleid_q"))
			){
				arr_username[i].parentElement.parentElement.style.display = "";
			} else {
				arr_username[i].parentElement.parentElement.style.display = "none";
			}
		}
	}
}
function displayRole() {
	var arr_input = document.getElementsByTagName("INPUT");
	for(var i = 0; i < arr_input.length; i++){
		if(arr_input[i].type == "checkbox" && arr_input[i].name.indexOf("checkboxs_") == 0 ) {
			var key = arr_input[i].name.substring(10);
			$(key).style.display = "";
			$("role_" + key).style.display = "";
			$("br_" + key).style.display = "";
		}
	}
}
function hideRole() {
	var arr_input = document.getElementsByTagName("INPUT");
	for(var i = 0; i < arr_input.length; i++){
		if(arr_input[i].type == "checkbox"
				&& arr_input[i].id.indexOf("checkboxs_") == 0) {
			var key = arr_input[i].id.substring(10);
			var arr_checkbox = document.getElementsByName("checkbox_" + key);
			var flag = true;
			for(var j = 0; j < arr_checkbox.length; j++){
				if(arr_checkbox[j].parentElement.parentElement.parentElement.style.display == "") {
					flag = false;
					break;
				}
			}
			if($("image_" + key)) {
				if(flag) {
					$(key).style.display = "none";
					if($("role_" + key)) {
						$("role_" + key).style.display = "none";
					}
					if($("br_" + key)) {
						$("br_" + key).style.display = "none";
					}
				}
			} else {
				if(!arr_input[i].checked) {
					if($F("roleid_q").trim() == "" || key.split("_")[1] == $F("roleid_q")){
						arr_input[i].parentElement.parentElement.style.display = "";
					} else {
						arr_input[i].parentElement.parentElement.style.display = "none";
					}
				}
			}
		}
			
	}
}

function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall" == temp){
		document.getElementById("orgid_q").value = "";
		document.getElementById("orgname_q").value = "";
		return false;
	}
	if(null != temp && temp.split("|").length > 1){
		document.getElementById("orgid_q").value = temp.split("|")[0];
		document.getElementById("orgname_q").value = temp.split("|")[1];
		return false;
	}
}
function toBack(){
	form.action = "IGCRC0402_Disp.do";
	form.submit();
}
</script>
<body onload="initSelected()">
<div id="maincontent">
<!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" /> 
<div id="container">
<div id="contentWrap">
<div id="content">
<html:form action="/IGCRC0406_ASSIGN" styleId="form" onsubmit="return checkSubmit(this);" >
	<html:hidden property="pdid"/>
	<html:hidden property="prstatus"/>
	<html:hidden property="buttonName"/>
	<html:hidden property="buttonCode"/>
	<logic:present name="IGCRC0403Form" property="prid">
		<logic:iterate id="prid" name="IGCRC0403Form" property="prid">
			<html:hidden property="prid" value="${prid }"/>
		</logic:iterate>
	</logic:present>
	<div id="location">
		<div class="image"></div>
		<p class="fonts1">
			参与者
		</p>
		<div class="back">
			<a href="javascript:toBack();">返回</a>
		</div>
    </div>
	<div id="results_list">
	    <div id="search">
			<div class="img"></div>
			<div class="conditions">
				<div>
					<label id="label_user" style="display: none">&nbsp;&nbsp;姓名：<input type="text" name="username_q" id="username_q"  size="10"/>&nbsp;&nbsp;</label>
					<label id="label_org" style="display: none">&nbsp;&nbsp;机构：<input type="text" name="orgname_q" id="orgname_q" size="20" readonly="readonly"/>
					<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>&nbsp;&nbsp;
					</label>
					<label>&nbsp;&nbsp;参与者：</label><select name="roleid_q" id="roleid_q" style="width:100px"><option value=""></option></select>
					<input type="hidden" name="orgid_q" id="orgid_q"/>
					<input type="button" value="查询" class="button" onclick="return fun_search();" style="height:20px"/>
				</div>
			</div>
		</div>
		<div style="padding-left:10px;">
		<ig:message />
		</div>
		<logic:present name="IGCRC04031VO" property="assignInfo">
			<div id="TabbedPanels1" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<logic:iterate id="map" name="IGCRC04031VO" property="assignInfo" indexId="index">
						<li class="TabbedPanelsTab">
							<c:if test="${map.key.assignflag == '1'}">
								<span class="red">*</span>
							</c:if>
							${map.key.psdname}
						</li>
					</logic:iterate>
				</ul>
				<div class="TabbedPanelsContentGroup">
					<logic:iterate id="map" name="IGCRC04031VO" property="assignInfo" indexId="index">
						<div class="TabbedPanelsContent">
							<logic:present name="map" property="value">
								<bean:define id="info" name="map" property="value"/>
								<logic:iterate id="info" name="map" property="value">
									<div style="width:540px;" id="${map.key.psdid}_${info.key.roleid}">
										<div style="width:540px; float:left;">
											<table class="table_style4" align="left">
												<tr>
													<th width="80%" align="left">
														<label>
															<input type="checkbox" id="checkboxs_${map.key.psdid }_${info.key.roleid}" onclick="selectAll('checkboxs_${map.key.psdid }_${info.key.roleid}','checkbox_${map.key.psdid }_${info.key.roleid}');" name="checkboxs_${map.key.psdid}_${info.key.roleid}" value=""/>
														</label>
														${info.key.rolename }
														<input type="hidden" name="role" value="${map.key.psdid}_${info.key.roleid}_${info.key.rolename}">
													</th>
													<th>
														<img id="image_${map.key.psdid}_${info.key.roleid}" style="cursor:hand;" src="images/minus.gif" width="12" height="12" onclick="toggleElement('role_${map.key.psdid}_${info.key.roleid}','image_${map.key.psdid}_${info.key.roleid}', '1')"/>
													</th>
												</tr>
											</table>
										</div>
										<logic:present name="info" property="value">
											<div id="role_${map.key.psdid}_${info.key.roleid}" style="width:540px;">
												<table  align="left"  class="table_style14">
													<logic:iterate id="bean" name="info" property="value">
														<tr>
															<td width="5%">
																<label>
																	<input type="checkbox" id="checkbox_${map.key.psdid}_${info.key.roleid}" name="participants" value="${map.key.psdid}_${info.key.roleid}_${bean.userida}"/>
																</label>
															</td>
															<td width="20%">
																${bean.username }
																<input type="hidden" name="username" value="${bean.username}">
															</td>
															<td width="25%">
																${bean.usermobile}
																<input type="hidden" name="userroleid" value="${info.key.roleid}">
															</td>
															<td width="50%">
																${bean.orgname}
																<input type="hidden" name="orgid" value="${bean.orgida}">
															</td>
														</tr>
													</logic:iterate>
												</table>
											</div>
											<br id="br_${map.key.psdid}_${info.key.roleid}"/>
											<script type="text/javascript">
												$("label_user").style.display = "";
												$("label_org").style.display = "";
											</script>
										</logic:present>
									</div>
								</logic:iterate>
							</logic:present>
						</div>
					</logic:iterate>
				</div>
			</div>
			<script type="text/javascript">
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			//-->
			</script>
		</logic:present>
	</div>
	<div id="operate">
		<span><html:submit property="btn_commit" value="提交" styleClass="button"  onclick="return toSave();"/></span>
		<span><html:reset property="btn_reset" value="重置" styleClass="button"/></span>
	</div>

</html:form>
</div>
</div>
</div>
</div>
</body>
</html>
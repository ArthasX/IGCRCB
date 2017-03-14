<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0104" toScope="request" />
<bean:define id="title" value="执行人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function toSave(){

	<logic:present name="IGPRR01041VO" property="lst_IGPRR01042VO">
	<logic:iterate id="bean" name="IGPRR01041VO" property="lst_IGPRR01042VO">
		var select_${bean.roleid} = document.getElementsByName("checkbox_${bean.roleid}");
		var select_${bean.roleid}_flag = true;
		for(var i = 0; i < select_${bean.roleid}.length; i++) {
			if(select_${bean.roleid}[i].checked) {
				select_${bean.roleid}_flag = false;
			}
		}
		if(select_${bean.roleid}_flag) {
			alert("请为\"${bean.rolename}\"指定执行人！");
			return false;
		}
	</logic:iterate>
	</logic:present>
        if(window.confirm("您是否确认提交？")){
		    return true;
        } else {
            return false;
        }
	}
function initSelected() {
	var arr_participants = document.getElementsByName("participants");
	var selected_participants = "";
	for(var i = 0; i < arr_participants.length; i++){
		if(arr_participants[i].checked){
			selected_participants += arr_participants[i].value + "###";
		}
	}
	createHiddenInput("selected_participants", selected_participants);
	hideRole();
	initSelectRole();
}
function initSelectRole() {
	var arr_role = document.getElementsByName("role");
	var arr_roleid = new Array();
	var str_role = "<option value=''></option>";
	var split_role;
	var flag = true;
	for(var i = 0; i < arr_role.length; i++){
		split_role = arr_role[i].value.split("_");
		if($("role_" + split_role[0]).style.display == "none") {
			flag = false;
		}
		if(flag) {
			for(var k = 0; k < arr_roleid.length; k++) {
				if(arr_roleid[k] && arr_roleid[k] == split_role[0]) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			arr_roleid[i] = split_role[0];
			str_role += "<option value='" + split_role[0] + "'>" + split_role[1] + "</option>";
		}
		flag = true;
	}
	$("roleid_q").outerHTML = "<select name='roleid_q' id='roleid_q' style='width:100px'>" + str_role + "</select>";
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
			$("role_" + key).style.display = "";
			$("br_" + key).style.display = "";
		}
	}
}
function hideRole() {
	var arr_input = document.getElementsByTagName("INPUT");
	for(var i = 0; i < arr_input.length; i++){
		if(arr_input[i].type == "checkbox" && arr_input[i].name.indexOf("checkboxs_") == 0 ) {
			var key = arr_input[i].name.substring(10);
			var arr_checkbox = document.getElementsByName("checkbox_" + key);
			var flag = true;
			for(var j = 0; j < arr_checkbox.length; j++){
				if(arr_checkbox[j].parentElement.parentElement.parentElement.style.display == "") {
					flag = false;
					break;
				}
			}
			if(flag) {
				$("role_" + key).style.display = "none";
				$("br_" + key).style.display = "none";
			}
		}
	}
}

function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall" == temp){
		document.forms[0].orgid_q.value = "";
		document.forms[0].orgname_q.value = "";
		return false;
	}
	if(null != temp && temp.split("|").length > 1){
		document.forms[0].orgid_q.value = temp.split("|")[0];
		document.forms[0].orgname_q.value = temp.split("|")[1];
		return false;
	}
}
//-->
	</script>
	
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
	<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body onload="initSelected()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRR0104" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">执行人</p>
<div class="back"><a href="IGPRR0102_Disp.do?pdid=${IGPRR0104Form.pdid}&roleid=${IGPRR0104Form.roleid}&prid=${IGPRR0104Form.prid}" target="_self">返回</a></div>
</div>
	<div id="results_list">
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div>
				<label id="label_user">&nbsp;&nbsp;姓名：<input type="text" name="username_q" id="username_q"  size="10"/>&nbsp;&nbsp;</label>
				<label id="label_org">&nbsp;&nbsp;机构：<input type="text" name="orgname_q" id="orgname_q" size="20" readonly="readonly"/>
				<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>&nbsp;&nbsp;
				</label>
				<label>&nbsp;&nbsp;角色：</label><select name="roleid_q" id="roleid_q" style="width:100px"><option value=""></option></select>
				<input type="hidden" name="orgid_q" id="orgid_q"/>
				<input type="button" value="查询" class="button" onclick="return fun_search();" style="height:20px"/>
			</div>
		</div>
	</div>
	<div style="padding-left: 10px">
	<ig:message/>
	</div>
	<logic:present name="IGPRR01041VO" property="lst_IGPRR01042VO">
	<div id="TabbedPanels1" class="TabbedPanels" >
	<ul>
		<li class="TabbedPanelsTab" tabindex="0">执行人</li>
	</ul>
	<div class="TabbedPanelsContentGroup">
		<div class="TabbedPanelsContent">
	<logic:present name="IGPRR01041VO" property="lst_IGPRR01042VO">
		<logic:iterate id="bean" name="IGPRR01041VO" property="lst_IGPRR01042VO">
			<div style="width:540px;" id="role_${bean.roleid}" >
				<div style="width:540px; float:left;">
					<TABLE class="table_style4" align="left">
						<TBODY>
							<TR>
								<TH width="80%" align="left"><LABEL><INPUT id="checkboxs_${bean.roleid}" onclick="selectAll('checkboxs_${bean.roleid}','checkbox_${bean.roleid}')" name="checkboxs_${bean.roleid}" value="" type="checkbox"></LABEL>${bean.rolename}<input type="hidden" name="role" value="${bean.roleid}_${bean.rolename}"></TH>
								<TH width="20%"><img id="image_${vo.processStatusDef.psdcode}_${bean.roleid}" style="cursor:hand;" src="images/minus.gif" width="12" height="12" onclick="toggleElement('role_${vo.processStatusDef.psdcode}_${bean.roleid}','image_${vo.processStatusDef.psdcode}_${bean.roleid}','1')"/></TH>
							</TR>
						</TBODY>
					</TABLE>
				</div>
				<logic:present name="bean" property="lst_ProcessExecutorVW">
					<div id="role_${vo.processStatusDef.psdcode}_${bean.roleid}" style="width:540px;">
						<TABLE  align="left"  class="table_style14">
							<TBODY>
									<TR bgcolor="#EEEEEE">
									  <TH width="5%"></TH>
									  <TH width="20%">姓名</TH>
									  <TH width="25%">电话</TH>
									  <TH width="50%">所属机构</TH>
									</TR>
								<logic:iterate id="info" name="bean" property="lst_ProcessExecutorVW">
									<TR>
									  <TD width="5%"><LABEL><c:if test="${info.doneFlag == '1' || info.doneFlag == '2' }"><INPUT type="checkbox" id="checkbox_${bean.roleid}" name="participants" value="${bean.roleid}_${info.userid}" checked="checked"/></c:if><c:if test="${info.doneFlag == '0' }"><INPUT type="checkbox" id="checkbox_${bean.roleid}" name="participants" value="${bean.roleid}_${info.userid}"/></c:if></LABEL></TD>
									  <TD width="20%">${info.username}<input type="hidden" name="username" value="${info.username}"><c:if test="${info.doneFlag == '2'}">(已处理)</c:if><c:if test="${info.doneFlag == '1'}">(未处理)</c:if></TD>
									  <TD width="25%">${info.usermobile}<input type="hidden" name="userroleid" value="${bean.roleid}"></TD>
									  <TD width="50%">${info.orgname}<input type="hidden" name="orgid" value="${info.orgsyscoding}"></TD>
									</TR>
								</logic:iterate>
							</TBODY>
						</TABLE>
					</div>
				</logic:present>
			</div>
			<br id="br_${bean.roleid}"/>
		</logic:iterate>
	</logic:present>
		</div>
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
	<logic:present name="IGPRR01041VO"
		property="lst_IGPRR01042VO">
		<bean:size id="lst_count" name="IGPRR01041VO" property="lst_IGPRR01042VO"/>
		<c:if test="${lst_count > 0}">
			<span> <html:submit property="btn_save" value="提交"
				styleClass="button"  onclick="return toSave();"/></span>
		</c:if>
	</logic:present>
	</div>
	<html:hidden property="prid" styleId="prid" name="IGPRR0104Form"/>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0104Form"/>
	<html:hidden property="roleid" styleId="roleid" name="IGPRR0104Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
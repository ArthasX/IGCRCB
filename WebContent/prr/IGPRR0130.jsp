<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0130" toScope="request" />
<bean:define id="title" value="参与者页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
function toSave(){
   if(window.confirm("您是否确认提交？")){
 		return true;
   } else {
       return false;
   }
}
	
function initSelectRole() {
	var arr_participants = document.getElementsByName("participants");
	var selected_participants = "";
	for(var i = 0; i < arr_participants.length; i++){
		if(arr_participants[i].checked){
			selected_participants += arr_participants[i].value + "###";
		}
	}
	createHiddenInput("selected_participants", selected_participants);
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
	hideRole();
}
function hideRole() {
	var arr_participants = document.getElementsByName("participants");
	var arr_roleid = document.getElementsByName("roleid");
	for(var i = 0; i < arr_participants.length; i++){
		if(!arr_participants[i].checked) {
			if(
				$F("roleid_q").trim() == "" || arr_roleid[i].value == $F("roleid_q")
			){
				$("role_" + arr_roleid[i].value).style.display = "";
			} else {
				$("role_" + arr_roleid[i].value).style.display = "none";
			}
		}
	}
}

//-->
	</script>
<body onload="initSelectRole()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRR0113" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">参与者</p>
<div class="back"><a href="IGPRR0102_Disp.do?pdid=${IGPRR0113Form.pdid}&roleid=${IGPRR0113Form.roleid}&prid=${IGPRR0113Form.prid}" target="_self">返回</a></div>
</div>
	<div id="results_list" style="width:400px; float:left; padding-left: 10px">
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div align="left">
				<label>&nbsp;&nbsp;角色：</label><select name="roleid_q" id="roleid_q" style="width:100px"><option value=""></option></select>
				<input type="hidden" name="orgid_q" id="orgid_q"/>
				<input type="button" value="查询" class="button" onclick="return fun_search();" style="height:20px"/>
			</div>
		</div>
	</div>
	<div style="padding-left: 10px">
	<ig:message/>
	</div>
	<div style="width:400px; float:left;">
	<table class="table_style4" align="left" style="width:400px; padding-left: 10px">
			<tr>
				<th width="30%"><label></label></th>
				<th width="70%">角色名称</th>
			</tr>
			<logic:present name="IGPRR01131VO" property="roleList">
				<logic:iterate id="bean" name="IGPRR01131VO" property="roleList">
					<tr id="role_${bean.roleid}">
					  <td width="30%"><LABEL><html:multibox styleId="checkbox_${bean.roleid}" property="participants" value="${bean.roleid}_"/></LABEL></td>
					  <td width="70%">${bean.rolename}<input type="hidden" name="role" value="${bean.roleid}_${bean.rolename}"><input type="hidden" name="roleid" value="${bean.roleid}"></td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	</div>
	<div id="operate">
	<logic:present name="IGPRR01131VO"
		property="roleList">
		<bean:size id="lst_count" name="IGPRR01131VO" property="roleList"/>
		<c:if test="${lst_count > 0}">
			<span><html:submit property="btn_save" value="提交" styleClass="button"  onclick="return toSave();"/></span>
			<span><html:reset property="btn_reset" value="重置" styleClass="button"/></span>
		</c:if>
	</logic:present>
	</div>
	<html:hidden property="prid" styleId="prid" name="IGPRR0113Form"/>
	<html:hidden property="psdmode" styleId="psdmode" name="IGPRR0113Form"/>
	<html:hidden property="roleid" styleId="roleid" name="IGPRR0113Form"/>
	<html:hidden property="prstatus" styleId="prstatus" name="IGPRR0113Form"/>
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0113Form"/>
	<html:hidden property="psdassign" styleId="psdassign" name="IGPRR0113Form"/>
	<html:hidden property="psdtype" styleId="psdtype" name="IGPRR0113Form"/>
	<html:hidden property="flag" styleId="flag" name="IGPRR0113Form"/>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0113Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
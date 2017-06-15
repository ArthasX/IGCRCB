<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0118" toScope="request" />
<bean:define id="title" value="分派参与者页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function toSave(obj){
		if(obj == '1') {
			<logic:present name="IGPRR01033VO" property="lst_IGPRR01034VO">
				<logic:iterate id="vo" name="IGPRR01033VO" property="lst_IGPRR01034VO"
					indexId="index">
					<c:if test="${vo.processStatusDef.psdtype == '2'}">
					   	if($F('ppsupers[${index}]') == ""){
					       	alert("请选择${vo.processStatusDef.psdname}状态的主办部门！");	
					       	return false;
					   	} else if($F('ppsupers[${index}]') != "") {
					   		var check${index} = document.getElementsByName("checkboxs_" + $F('ppsupers[${index}]'));
					   		var noHasUser${index} = true;
						   	for(var i=0;i<check${index}.length;i++){
						   		if(check${index}[i].checked){
						   			noHasUser${index} = false;
						   		}
						   	}
						   	if(noHasUser${index}) {
						   		alert("请选择${vo.processStatusDef.psdname}状态的主办部门参与者！");	
						       	return false;
							}
						}
					</c:if>
					<c:if test="${vo.processStatusDef.assignflag == '1'}">
					   		var status${index} = document.getElementsByTagName("INPUT");
					   		var noHasStatusUser${index} = true;
					   		for(var i=0;i<status${index}.length;i++){
						   		if(status${index}[i].type=="checkbox" &&
								   		status${index}[i].value.indexOf("${vo.processStatusDef.psdcode}") == 0 && status${index}[i].checked){
						   			noHasStatusUser${index} = false;
						   		}
						   	}
					   		if(noHasStatusUser${index}) {
						   		alert("请选择${vo.processStatusDef.psdname}状态的参与者！");	
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
		} else {
	        if(window.confirm("您是否确认保存？")){
	        	form.action = getAppRootUrl() + "/IGPRR0102_SaveExecutor.do";
			    return true;
	        } else {
	            return false;
	        }
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
		$("roleid_q").outerHTML = "<select name='roleid_q' id='roleid_q' style='width:100px'>" + str_role + "</select>";
		hideUser_pp_yes();
	}
	function fun_search() {
		displayRole();
		hideUser();
		if($F("ppcount_q").trim() != "" && $F("ppcount_q") == "1"){
            hideUser_pp_yes();
        }else if($F("ppcount_q").trim() != "" && $F("ppcount_q") == "2"){
            hideUser_pp_no();
        }
		hideRole();
	}
	
	//待办工作个数不为零的分派用户隐藏
    function hideUser_pp_yes() {
        var arr_participants = document.getElementsByName("participants");
        var arr_username = document.getElementsByName("username");
        var arr_orgid = document.getElementsByName("orgid");
        var arr_userroleid = document.getElementsByName("userroleid");
        var arr_ppcount = document.getElementsByName("ppcount");
        for(var i = 0; i < arr_username.length; i++){
            if(!arr_participants[i].checked) {
                if(($F("username_q").trim() == "" || arr_username[i].value.indexOf($F("username_q").trim()) >= 0)
                        && ($F("orgid_q").trim() == "" || arr_orgid[i].value == $F("orgid_q"))
                        && ($F("roleid_q").trim() == "" || arr_userroleid[i].value == $F("roleid_q")) && arr_ppcount[i].value == 0){
                    arr_username[i].parentElement.parentElement.style.display = "";
                } else {
                    arr_username[i].parentElement.parentElement.style.display = "none";
                }
            }
        }
    }
    
    //待办工作个数为零的分派用户隐藏
    function hideUser_pp_no() {
        var arr_participants = document.getElementsByName("participants");
        var arr_username = document.getElementsByName("username");
        var arr_orgid = document.getElementsByName("orgid");
        var arr_userroleid = document.getElementsByName("userroleid");
        var arr_ppcount = document.getElementsByName("ppcount");
        for(var i = 0; i < arr_username.length; i++){
            if(!arr_participants[i].checked) {
                if(($F("username_q").trim() == "" || arr_username[i].value.indexOf($F("username_q").trim()) >= 0)
                        && ($F("orgid_q").trim() == "" || arr_orgid[i].value == $F("orgid_q"))
                        && ($F("roleid_q").trim() == "" || arr_userroleid[i].value == $F("roleid_q")) && arr_ppcount[i].value > 0){
                    arr_username[i].parentElement.parentElement.style.display = "";
                } else {
                    arr_username[i].parentElement.parentElement.style.display = "none";
                }
            }
        }
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

	//全选
    function selectAll(name,obj) { 
        var checks = document.getElementsByName(obj);
        if(document.getElementById(name).checked){
            for(var i=0;i < checks.length;i++) 
            { 
                if(checks[i].parentElement.parentElement.parentElement.style.display == ""){
                    checks[i].checked = true;
                }else if(checks[i].parentElement.parentElement.parentElement.style.display == "none"){
                    checks[i].checked = false;
                }
            } 
        }else{
            for(var i=0;i < checks.length;i++) 
            { 
                checks[i].checked = false; 
            } 
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
<html:form styleId="form" action="/IGPRR0102_Assign" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">参与者</p>
<div class="back"><a href="IGPRR0102_Disp.do?pdid=${IGPRR0102Form.pdid}&prroleid=${IGPRR0102Form.prroleid}&prid=${IGPRR0102Form.prid}" target="_self">返回</a></div>
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
			<label>&nbsp;&nbsp;角色：</label><select name="roleid_q" id="roleid_q" style="width:100px"><option value=""></option></select>
			<input type="hidden" name="orgid_q" id="orgid_q"/>
			<label>&nbsp;&nbsp;是否空闲：</label><select name="ppcount_q" id="ppcount_q" style="width:100px">
                <option value=""></option>
                <option value="1" selected="selected">是</option>
                <option value="2">否</option>
            </select>
			<input type="button" value="查询" class="button" onclick="return fun_search();" style="height:20px"/>
		</div>
	</div>
</div>
<div style="padding-left: 10px">
<ig:message/>
</div>
<logic:present name="IGPRR01033VO" property="lst_IGPRR01034VO">
<div id="TabbedPanels1" class="TabbedPanels">
	<ul class="TabbedPanelsTabGroup">
		<logic:iterate id="vo" name="IGPRR01033VO" property="lst_IGPRR01034VO"
			indexId="index">
			<li class="TabbedPanelsTab" tabindex="0"><c:if test="${vo.processStatusDef.assignflag == '1'}"><span class="red">*</span></c:if>${vo.processStatusDef.psdname}</li>
		</logic:iterate>
	</ul>
	<div class="TabbedPanelsContentGroup">
		<logic:present name="IGPRR01033VO" property="lst_IGPRR01034VO">
			<logic:iterate id="vo" name="IGPRR01033VO" property="lst_IGPRR01034VO"
				indexId="index">
				<div class="TabbedPanelsContent">
					<c:if test="${vo.processStatusDef.psdtype == '2'}">
						<logic:present name="vo" property="labelList">
							<div style="width:540px;">
								<div style="width:540px; float:left;">
									<TABLE class="table_style4" align="left" <c:if test="${vo.processStatusDef.psdmode == '2' || vo.processStatusDef.psdassign == '1'}">style="width:300px;"</c:if>>
										<TBODY>
											<TR>
												<TH width="40%" align="left">
												<LABEL><span class="red">*</span>主办部门：</LABEL>
													<logic:present name="vo" property="labelList">
														<bean:define id="ADsuperList" name="vo" property="labelList" />
														<html:select name="IGPRR0102Form" property="ppsupers[${index}]" errorStyleClass="inputError imeActive" styleId="ppsuper">
															<html:options collection="ADsuperList" property="value" name="" labelProperty="label" />
														</html:select>
													</logic:present>
												</TH>
											</TR>
										</TBODY>
									</TABLE>
								</div>
							</div>
							<br>
						</logic:present>
					</c:if>
					<c:if test="${vo.processStatusDef.psdmode == '2' || vo.processStatusDef.psdassign == '1'}">
						<logic:present name="vo" property="lst_IGPRR01035VO">
							<div style="width:540px;">
								<div style="width:540px; float:left;">
									<table class="table_style4" align="left" style="width:300px;">
										<tr>
											<th width="20%"><label></label>
											</th>
											<th width="50%">角色名称</th>
										</tr>
										<logic:iterate id="bean" name="vo" property="lst_IGPRR01035VO">
											<tr id="${vo.processStatusDef.psdcode}_${bean.role.roleid}">
											  	<td height="20">
												<html:multibox property="participants_" value="${vo.processStatusDef.psdcode}_${bean.role.roleid}_"
													styleId="checkboxs_${vo.processStatusDef.psdcode}_${bean.role.roleid}"/>
												<input type="hidden" name="role" value="${vo.processStatusDef.psdcode}_${bean.role.roleid}_${bean.role.rolename}">
												</td>
												<td>${bean.role.rolename}</td>
											</tr>
										</logic:iterate>
									</table>
								</div>
							</div>
						</logic:present>
					</c:if>
					<c:if test="${vo.processStatusDef.psdmode != '2' && vo.processStatusDef.psdassign != '1'}">
						<logic:present name="vo" property="lst_IGPRR01035VO">
							<logic:iterate id="bean" name="vo" property="lst_IGPRR01035VO">
								<div style="width:540px;" id="${vo.processStatusDef.psdcode}_${bean.role.roleid}">
									<div style="width:540px; float:left;">
										<TABLE class="table_style4" align="left">
											<TBODY>
												<TR>
												<TH width="80%" align="left"><LABEL><INPUT id="checkboxs_${vo.processStatusDef.psdcode}_${bean.role.roleid}" onclick="selectAll('checkboxs_${vo.processStatusDef.psdcode}_${bean.role.roleid}','checkbox_${vo.processStatusDef.psdcode}_${bean.role.roleid}')" name="checkboxs_${vo.processStatusDef.psdcode}_${bean.role.roleid}" value="" type="checkbox"></LABEL>${bean.role.rolename}<input type="hidden" name="role" value="${vo.processStatusDef.psdcode}_${bean.role.roleid}_${bean.role.rolename}"></TH>
												<TH width="20%"><img id="image_${vo.processStatusDef.psdcode}_${bean.role.roleid}" style="cursor:hand;" src="images/minus.gif" width="12" height="12" onclick="toggleElement('role_${vo.processStatusDef.psdcode}_${bean.role.roleid}','image_${vo.processStatusDef.psdcode}_${bean.role.roleid}', '1')"/></TH>
												</TR>
											</TBODY>
										</TABLE>
									</div>
									<logic:present name="bean" property="lst_UserInfo">
										<div id="role_${vo.processStatusDef.psdcode}_${bean.role.roleid}" style="width:540px;">
											<TABLE  align="left"  class="table_style14">
												<TBODY>
													<logic:iterate id="info" name="bean" property="lst_UserInfo">
														<TR>
														  <TD width="5%"><LABEL><html:multibox styleId="checkbox_${vo.processStatusDef.psdcode}_${bean.role.roleid}" property="participants" value="${vo.processStatusDef.psdcode}_${bean.role.roleid}_${info.userida}"/></LABEL></TD>
													  <TD width="20%">${info.username}<input type="hidden" name="username" value="${info.username}"></TD>
													  <TD width="25%">${info.usermobile}<input type="hidden" name="userroleid" value="${bean.role.roleid}"></TD>
													  <TD width="50%">${info.orgname}<input type="hidden" name="orgid" value="${info.orgida}"><input type="hidden" name="ppcount" value="<ig:participateNumberOfJobs userid='${info.userida}'/>"></TD>
													</TR>
													</logic:iterate>
												</TBODY>
											</TABLE>
										</div>
									</logic:present>
								</div>
							<br id="br_${vo.processStatusDef.psdcode}_${bean.role.roleid}"/>
							<script type="text/javascript">
								$("label_user").style.display = "";
								$("label_org").style.display = "";
							</script>
							</logic:iterate>
						</logic:present>
					</c:if>
				</div>
			</logic:iterate>
		</logic:present>
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
<logic:present name="IGPRR01033VO"
	property="lst_IGPRR01034VO">
	<bean:size id="lst_count" name="IGPRR01033VO" property="lst_IGPRR01034VO"/>
	<c:if test="${lst_count > 0}">
		<!-- <span><html:submit property="btn_save" value="保存" styleClass="button"  onclick="return toSave('0');"/></span> -->
		<span><html:submit property="btn_commit" value="提交" styleClass="button"  onclick="return toSave('1');"/></span>
		<span><html:reset property="btn_reset" value="重置" styleClass="button"/></span>
	</c:if>
</logic:present>
<logic:notPresent name="IGPRR01033VO"
	property="lst_IGPRR01034VO">
		<span class="red">可分派参与者不存在</span>
</logic:notPresent>
</div>
<html:hidden property="prid" styleId="prid" name="IGPRR0102Form"/>
<html:hidden property="prroleid" styleId="prroleid" name="IGPRR0102Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
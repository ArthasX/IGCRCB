<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRD0159" toScope="request" />
<bean:define id="title" value="通知人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var parent_window = parent.getArguments()[0];
	var parent_notifierids = parent_window.document.getElementById("notifierids[${IGPRD0159Form.rowIndex}]");
	var parent_notifiernames = parent_window.document.getElementById("notifiernames[${IGPRD0159Form.rowIndex}]");
	var parent_span_notifiernames = parent_window.document.getElementById("notifiernames_${IGPRD0159Form.rowIndex}");
	function setDefaultValue() {
		var arr_notifiers = document.getElementsByName("notifiers");
		if(parent_notifierids.value > " ") {
			var arr_notifierids = parent_notifierids.value.split("###");
			for(var i=0; i < arr_notifierids.length; i++) {
				for(var j=0; j < arr_notifiers.length; j++) {
					if(arr_notifiers[j].value == arr_notifierids[i]) {
						arr_notifiers[j].checked = true;
					}
				}
			}
		}
	}
	
	function fun_confirm() {
		var ids = "";
		var names = "";
		var arr_notifiers = document.getElementsByName("notifiers");
		var arr_notifiernames = document.getElementsByName("notifiernames");
		var arr_notifierids = document.getElementsByName("notifierids");
		for(var i=0; i < arr_notifiers.length; i++) {
			if(arr_notifiers[i].checked) {
				if(ids.indexOf("#" + arr_notifierids[i].value + "#") > -1) {
					alert("通知人（" + arr_notifiernames[i].value + "）重复，请重新指定！");
					return false;
				}
				ids += arr_notifiers[i].value + "###";
				names += arr_notifiernames[i].value + "，";
			}
		}
		if(ids > " " && names > " "){
			parent_notifierids.value = ids.substring(0, ids.length - 3);
			parent_notifiernames.value = names.substring(0, names.length - 1);
			parent_span_notifiernames.innerHTML = names.substring(0, names.length - 1);
		} else {
			parent_notifierids.value = "";
			parent_notifiernames.value = "";
			parent_span_notifiernames.innerHTML = "";
		}
		window.close();
	}

	function fun_clear() {
		parent_notifierids.value = "";
		parent_notifiernames.value = "";
		parent_span_notifiernames.innerHTML = "";
		window.close();
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
	html{
		overflow-x:hidden;
		overflow-y:auto;
	}
	body{
		overflow-x:hidden;
	}
	</style>
<body onload="setDefaultValue()">
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<html:form styleId="form" action="/IGPRD0159_Disp" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">通知人</p>
</div>
	<div id="results_list"><ig:message />
	<logic:present name="IGPRD01591VO" property="lst_IGPRD01592VO">
		<logic:iterate id="bean" name="IGPRD01591VO" property="lst_IGPRD01592VO">
			<div style="width:540px;">
				<div style="width:540px; float:left;">
					<TABLE class="table_style4" align="left">
						<TBODY>
							<TR>
								<TH width="80%" align="left"><LABEL><INPUT id="checkboxs_${bean.roleid}" onclick="selectAll('checkboxs_${bean.roleid}','checkbox_${bean.roleid}')" name="checkboxs_${bean.roleid}" value="" type="checkbox"></LABEL>${bean.rolename}</TH>
								<TH width="20%"><img id="image_${bean.roleid}" style="cursor:hand;" src="images/minus.gif" width="12" height="12" onclick="toggleElement('role_${bean.roleid}','image_${bean.roleid}')"/></TH>
							</TR>
						</TBODY>
					</TABLE>
				</div>
				<logic:present name="bean" property="lst_userRoleInfo">
					<div id="role_${bean.roleid}" style="width:540px;">
						<TABLE  align="left"  class="table_style14">
							<TBODY>
								<logic:iterate id="info" name="bean" property="lst_userRoleInfo">
									<TR>
									  <TH width="20%"><LABEL><INPUT type="checkbox" id="checkbox_${bean.roleid}" name="notifiers" value="${bean.roleid}##${info.userid}"/></LABEL></TH>
									  <TH width="30%">${info.username}<input type="hidden" name="notifiernames" value="${info.username}"><input type="hidden" name="notifierids" value="${info.userid}"></TH>
									  <TH width="50%">${info.orgname}</TH>
									</TR>
								</logic:iterate>
							</TBODY>
						</TABLE>
					</div>
				</logic:present>
			</div>
			<br/>
		</logic:iterate>
	</logic:present>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01591VO"
		property="lst_IGPRD01592VO">
		<bean:size id="lst_count" name="IGPRD01591VO" property="lst_IGPRD01592VO"/>
		<c:if test="${lst_count > 0}">
			<input type="button" name="btn_confirm"  class="button" value="确认" onclick="fun_confirm()">
			<input type="button" name="btn_clear"  class="button" value="清空" onclick="fun_clear()">
			<input type="button"  name="btn_close" class="button" value="关闭" onclick="window.close();">
		</c:if>
	</logic:present>
	</div>
</html:form>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0120" toScope="request" />
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
function selectAlert(obj) {
	if(obj.value == '${IGPRR0113Form.ppsuperorgid}') {
		alert("主办部门不能删除！");
		obj.checked = true;
	}
}
function fun_search() {
	hideOrg();
}
function hideOrg() {
	var arr_participants = document.getElementsByName("participants");
	var arr_orgid = document.getElementsByName("orgid");
	for(var i = 0; i < arr_participants.length; i++){
		if(!arr_participants[i].checked) {
			if($F("orgid_q").trim() == "" || arr_orgid[i].value == $F("orgid_q")){
				$("org_" + arr_orgid[i].value).style.display = "";
			} else {
				$("org_" + arr_orgid[i].value).style.display = "none";
			}
		}
	}
}
//-->
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRR0113_org" onsubmit="return checkSubmit(this);">
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
				<label>&nbsp;&nbsp;机构：</label>
					<select name="orgid_q" id="orgid_q" >
						<option value=""></option>
						<logic:present name="IGPRR01131VO" property="org_List">
							<logic:iterate id="bean" name="IGPRR01131VO" property="org_List">
								<option value="${bean.orgsyscoding }">${bean.orgname }</option>
							</logic:iterate>
						</logic:present>
					</select>
				<input type="hidden" name="orgid_q" id="orgid_q"/>
				<input type="button" value="查询" class="button" onclick="fun_search();" style="height:20px"/>
			</div>
		</div>
	</div>
	<div style="padding-left: 10px">
	<ig:message/>
	</div>
	<div style="width:400px; float:left;">
	<table class="table_style4" align="left" style="width:400px; padding-left: 10px">
			<tr>
				<th width="30%"><label></label>
				</th>
				<th width="70%">机构名称</th>
			</tr>
			<logic:present name="IGPRR01131VO" property="org_List">
				<logic:iterate id="bean" name="IGPRR01131VO" property="org_List">
					<tr id="org_${bean.orgsyscoding}">
					  <td width="30%">
					  	<LABEL>
					  		<html:multibox styleId="checkbox_${bean.orgsyscoding}" property="participants" value="${bean.orgsyscoding}_${bean.orgname}" onclick="selectAlert(this)"/>
					  	</LABEL>
					  </td>
					  <td width="70%">
					  	${bean.orgname}
					  	<bean:define id="superorg" value="${bean.orgsyscoding}_${bean.orgname }"/>
					  	<logic:equal value="${superorg}" name="IGPRR0113Form" property="ppsuperorgid">
					  		(主办部门)
					  	</logic:equal>
						<input type="hidden" name="org" value="${bean.orgsyscoding}_${bean.orgname}">
						<input type="hidden" name="orgid" value="${bean.orgsyscoding}">
					  </td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	</div>
	<div id="operate">
	<logic:present name="IGPRR01131VO" property="org_List">
		<bean:size id="lst_count" name="IGPRR01131VO" property="org_List"/>
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
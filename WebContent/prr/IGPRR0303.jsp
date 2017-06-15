<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGPRR0303" toScope="request"/>
<bean:define id="title" value="人员选择页面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">
function setOrg(){
	var temp = window.showModalDialog('IGSYM0101_ROLETREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("orgname").value = "";
		document.getElementById("orgsyscoding").value = "";
	}
	if(null!=temp && temp.split("|").length>1){
		document.getElementById("orgname").value = temp.split("|")[1];
		document.getElementById("orgsyscoding").value = temp.split("|")[0];
	}
	
}
function addParticipant(){
	var checks = document.getElementsByName("participant");
	var userids = document.getElementsByName("par_userid");
	var usernames = document.getElementsByName("par_username");
	var orgids = document.getElementsByName("par_orgid");
	var orgnames = document.getElementsByName("par_orgname");
	var roleids = document.getElementsByName("par_roleid");
	var rolenames = document.getElementsByName("par_rolename");
	var phones = document.getElementsByName("par_phone");
	var count = 0;
	var returnValue = new Array();
	if(checks != null && checks.length > 0){
		for(var i=0;i<checks.length;i++){
			if(checks[i].checked){
				var info = new Array();
				info[0] = userids[i].value;
				info[1] = usernames[i].value;
				info[2] = orgids[i].value;
				info[3] = orgnames[i].value;
				info[4] = roleids[i].value;
				info[5] = rolenames[i].value;
				info[6] = phones[i].value;
				returnValue[returnValue.length] = info;
				count ++;
			}
		}
	}
	if(count > 0){
		if(!window.opener.closed){
			 var flag = window.opener.setParticipant(returnValue);
			 if(!flag){
				 window.close();
			 }
		}
	}else{
		alert("请选择人员！");
	}
}
function setRole(){
	var roletype = document.getElementById("roletype").value;
	var roleid_in = document.getElementById("roleid_in").value;
	openSubWindow('/IGPRR0302_Odd.do?roletype=' + roletype + '&roleidin=' + roleid_in, 'cpblank','1050','600');
}
function setRoleInfo(roleid,rolename){
	document.getElementById("roleid").value = roleid;
	document.getElementById("rolename").value = rolename;
}
</script>
<body>
<div id="maincontent">
<div id="container">
<div id="location">
<div class="image"></div>
<p class="fonts1">人员选择</p>
</div>
<html:form action="/IGPRR0303">
<div id="search">
	<div class="img"></div>
	<div class="conditions">
		<div>
			<span>
				机构：
				<html:text property="orgname" name="IGPRR0303Form" styleId="orgname" readonly="true"/>
				<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg();"/>
				<html:hidden property="orgsyscoding" styleId="orgsyscoding" name="IGPRR0303Form"/>
				<html:hidden property="single" styleId = "single" name="IGPRR0303Form"/>
			</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<span>
				角色：
				<html:text property="rolename" styleId="rolename" name="IGPRR0303Form" readonly="true"/>
				<img src="images/seek.gif" alt="角色查询"  style="cursor: hand" onclick="setRole();"/>
				<html:hidden property="roleid" styleId="roleid" name="IGPRR0303Form"/>
			</span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:hidden property="roletype" styleId="roletype" name="IGPRR0303Form"/>
			<html:hidden property="pidid" styleId="pidid" name="IGPRR0303Form"/>
			<html:hidden property="roleid_in" styleId="roleid_in" name="IGPRR0303Form"/>
			<html:submit styleClass="button" value="查询"/>
		</div>
	</div>
</div>
<div style="padding-left: 10px">
<ig:message/>
</div>
<div id="results_list" style="width:540px;margin-left:10px;">
	<logic:present name="IGPRR03031VO" property="userRoleInfoMap">
		<logic:iterate id="userRoleInfoIdMap" name="IGPRR03031VO" property="userRoleInfoMap">
			<bean:define id="userRoleInfoNameMap" name="userRoleInfoIdMap" property="value"/>
			<bean:define id="roleid" name="userRoleInfoIdMap" property="key"/>
			<logic:iterate id="map" name="userRoleInfoNameMap">
				<bean:define id="rolename" name="map" property="key"/>
				<bean:define id="list" name="map" property="value"/>
				<div>
					<table class="table_style4" style="width:100%;">
						<tr>
							<th width="80%" style="text-align:left;">
								&nbsp;<input type="checkbox" id="all_${roleid }" onclick="selectAll('all_${roleid}','check_${roleid }');"/> 
								${rolename }
							</th>
							<th width="20%">
								<img id="image_${roleid }" style="cursor:hand;" src="images/minus.gif" width="12" height="12" onclick="toggleElement('role_${roleid }','image_${roleid }', '1')"/>
							</th>
						</tr>
					</table>
				</div>
				<div id="role_${roleid }">
				<table>
				<logic:iterate id="bean" name="list">
					<tr>
						<td width="5%">
							<input type="checkbox" id="check_${roleid }" name="participant"/> 
						</td>
						<td width="20%">
							${bean.username }
							<input type="hidden" name="par_userid" value="${bean.userid }"/>
							<input type="hidden" name="par_username" value="${bean.username }"/>
							<input type="hidden" name="par_orgid" value="${bean.orgid }"/>
							<input type="hidden" name="par_orgname" value="${bean.orgname }"/>
							<input type="hidden" name="par_roleid" value="${bean.roleid }">
							<input type="hidden" name="par_rolename" value="${bean.rolename }"/>
							<input type="hidden" name="par_phone" value="${bean.usermobile }"/>
						</td>
						<td width="25%">
							${bean.usermobile }
						</td>
						<td width="70%">
							${bean.orgname }
						</td>
					</tr>
				</logic:iterate>
				</table>
				</div>
			</logic:iterate>
		</logic:iterate>
	</logic:present>
</div>
<div class="enter">
	<html:button property="btn_copy" styleClass="button" value="添加所选" onclick="addParticipant();"/>
	<html:button property="btn_close" styleClass="button" value="关闭" onclick="window.close();"/> 
</div>
</html:form>
</div>
</div>
</body>
<script type="text/javascript">
	if(jQ("#single").val()){
// 		jQ(":checkbox").each(function(i,t){
// 			t = jQ(t);
// 			//隐藏全选按钮
// 			if(t.attr("id").indexOf("all_")>-1){
// 				t.hide();
// 			}
// 			t.click(function(e){
// 				jQ(":checkbox").not(this).attr("checked",false);
// 			});
// 		});
		jQ(":checkbox[id^='all_']").hide();
		jQ(":checkbox").click(function(){jQ(":checkbox:checked").not(this).attr("checked",false);})
		
	}
	
</script>
</html:html>
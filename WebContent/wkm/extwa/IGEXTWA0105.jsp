﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGEXTWA0105" toScope="request" />
<bean:define id="title" value="审核人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="审核人" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择添加审核人。';
			confirmMsg = '请确认是否要进行审核人添加处理?';
			mode="1";
		}
        if(window.confirm(confirmMsg)){
			if(mode==0){
				if(getNum("roleid_del")==$("tab_del").rows.length-1){
					alert("请至少保留一个角色！");
		            return false;
				}
			}
			count=checkAndCreate(flag);
			if(count==0){
				alert(message);
	            return false;
			}
            form.action = getAppRootUrl() + "/IGEXTWA0105.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			var check=document.getElementsByName("roleid_add");
			var rolenames=document.getElementsByName("rolename");
			var userids=document.getElementsByName("ppuserid");
			var usernames=document.getElementsByName("ppusername");
			var orgids=document.getElementsByName("pporgid");
			var orgnames=document.getElementsByName("pporgname");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInput("roleids",check[i].value);
					createHiddenInput("rolenames",rolenames[i].value);
					createHiddenInput("ppuserids",userids[i].value);
					createHiddenInput("ppusernames",usernames[i].value);
					createHiddenInput("pporgids",orgids[i].value);
					createHiddenInput("pporgnames",orgnames[i].value);
				}
			}
		}else{
			var check=document.getElementsByName("roleid_del");
			var rolenames=document.getElementsByName("rolename_del");
			var usernames=document.getElementsByName("username_del");
			var orgnames=document.getElementsByName("orgname_del");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInput("roleids",check[i].value);
					createHiddenInput("rolenames",rolenames[i].value);
					createHiddenInput("ppusernames",usernames[i].value);
					createHiddenInput("pporgnames",orgnames[i].value);
				}
			}
		}
		return count;
	}	

	function selectRoleUser(roleid){
		openSubWindow('/IGSYM0406.do?roleida='+roleid , '_blank', '800', '600');
	}
	function setParamRoleUser(userid,username,roleid,orgid,orgname){
		var check=document.getElementsByName("roleid_add");
		for(var i=0;i<check.length;i++){
			if(check[i].value==roleid){
				if(userid != null && userid != ''){
					check[i].checked=true;
				}else{
					check[i].checked=false;
				}
				document.getElementsByName("ppuserid")[i].value = userid;
				document.getElementsByName("ppusername")[i].value = username;
				document.getElementsByName("pporgid")[i].value = orgid;
				document.getElementsByName("pporgname")[i].value = orgname;
				break;
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
<html:form styleId="form" action="/IGEXTWA0105" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">审核人</p>
<div class="back"><a href="IGEXTWA0103_Disp.do?prid=<bean:write name="IGEXTWA0105Form" property="prid" />&bkmode=<bean:write name="IGEXTWA0105Form" property="bkmode" />" target="_self">返回</a></div> 
</div>
	<div class="role_title">现有审核人</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style" align="left">
			<tr>
				<th width="10%"><label> <input type="checkbox"
					name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','roleid_del')"/> </label>
				</th>
				<th width="30%">角色</th>
				<th width="35%">审核人</th>
				<th width="35%">机构</th>
			</tr>
			<logic:present name="IGEXTWA01051VO" property="verifiorsList">
				<logic:iterate id="bean" name="IGEXTWA01051VO"
					property="verifiorsList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20"><label>
						<input type="checkbox" name="roleid_del" value="${bean.ppid}">
						 </label>
						</td>
						<td>${bean.pprolename}<input type="hidden" name="rolename_del" value="${bean.pprolename}">
						</td>
						<td>${bean.ppusername}<input type="hidden" name="username_del" value="${bean.ppusername}">
						</td>
						<td>${bean.pporgname}<input type="hidden" name="orgname_del" value="${bean.pporgname}">
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGEXTWA01051VO"
		property="verifiorsList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('0');" /></span>
	</logic:present>
	</div>
	<div class="role_title">可选角色</div>
	<div id="results_list">
	<table class="table_style" align="left">
			<tr>
				<th width="10%"><label> <input type="checkbox"
					name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','roleid_add')"/> </label>
				</th>
				<th width="30%">角色</th>
				<th width="35%">审核人</th>
				<th width="35%">机构</th>
			</tr>
			<logic:present name="IGEXTWA01051VO" property="roleList">
				<logic:iterate id="bean" name="IGEXTWA01051VO"
					property="roleList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20"><label>
						<input type="checkbox" name="roleid_add" value="${bean.roleid}">
						 </label>
						</td>
						<td>${bean.rolename}<input type="hidden" name="rolename" value="${bean.rolename}">
						</td>
						<td><input type="text" name="ppusername" size="40" style="text-align: center" readonly="readonly"/><input type="hidden" name="ppuserid"/>
						<a href="javascript:void(0)" onclick="selectRoleUser('${bean.roleid}');"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
						</td>
						<td><input type="text" name="pporgname" size="40" style="text-align: center"
						readonly="readonly" /><input type="hidden" name="pporgid" /></td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGEXTWA01051VO"
		property="roleList">
		<span> <html:submit property="btn_delete" value="添加所选"
			styleClass="button"  onclick="return deleteRec('1');"/></span>
	</logic:present>
	</div>
	<html:hidden property="prid" styleId="prid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
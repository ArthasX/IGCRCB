<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRM0305" toScope="request" />
<bean:define id="title" value="审批分派人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript"><!--	

	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="审批分派人" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择添加审批分派人。';
			confirmMsg = '请确认是否要进行审批分派人添加处理?';
			mode="1";
		}
        if(window.confirm(confirmMsg)){
			if(mode == "1"){
				if(document.getElementsByName("roleid_del").length==1){
					alert("只能有一个审批分派角色！");
		            return false;
				}
			}
			count=checkAndCreate(flag);
			if(count==0){
				alert(message);
	            return false;
			}
            form.action = getAppRootUrl() + "/IGPRM0305.do?mode="+mode;
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
				}
			}
		}
		return count;
	}	

	function selectRoleUser(roleid){
		openSubWindow('/IGSYM0405.do?roleida='+roleid , 'newpage', '800', '600');
	}
	function setParamRoleUser(userid,username,roleid,orgid,orgname){
		var check=document.getElementsByName("roleid_add");
		for(var i=0;i<check.length;i++){
			if(check[i].value==roleid){
				document.getElementsByName("ppuserid")[i].value = userid;
				document.getElementsByName("ppusername")[i].value = username;
				document.getElementsByName("pporgid")[i].value = orgid;
				document.getElementsByName("pporgname")[i].value = orgname;
				break;
			}
		}
	}
//--></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRM0305" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">审批分派人</p>
<div class="back"><a href="IGPRM0301_Disp.do?pdid=<bean:write name="IGPRM0305Form" property="pdid" />" target="_self">返回</a></div> 
</div>
<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<div class="role_title">现有审批分派人</div>
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%"></th>
				<th width="30%">角色</th>
				<th width="20%">审批分派人</th>
				<th width="30%">机构</th>
			</tr>
			<logic:present name="IGPRM03051VO" property="approveDispatcherList">
				<logic:iterate id="bean" name="IGPRM03051VO"
					property="approveDispatcherList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20"><label>
						<input type="radio" name="roleid_del" value="${bean.ppcomment}">
						 </label>
						</td>
						<td>${bean.pprolename}</td>
						<td>${bean.ppusername}</td>
						<td>${bean.pporgname}</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRM03051VO"
		property="approveDispatcherList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('0');" /></span>
	</logic:present>
	</div>
	<div class="role_title">可选角色</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="20%"></th>
				<th width="30%">角色</th>
				<th width="20%">审批分派人</th>
				<th width="30%">机构</th>
			</tr>
			<logic:present name="IGPRM03051VO" property="roleList">
				<logic:iterate id="bean" name="IGPRM03051VO"
					property="roleList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20"><label>
						<input type="radio" name="roleid_add" value="${bean.roleid}">
						 </label>
						</td>
						<td>${bean.rolename}<input type="hidden" name="rolename" value="${bean.rolename}">
						</td>
						<td><input type="text" name="ppusername" size="6" style="text-align: center" readonly="readonly"/><input type="hidden" name="ppuserid"/>
						<a href="javascript:void(0)" onclick="selectRoleUser('${bean.roleid}');"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
						</td>
						<td><input type="text" name="pporgname" size="18" style="text-align: center"
						readonly="readonly" /><input type="hidden" name="pporgid" /></td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRM03051VO"
		property="roleList">
		<span> <html:submit property="btn_delete" value="添加所选"
			styleClass="button"  onclick="return deleteRec('1');"/></span>
	</logic:present>
	</div>
	<html:hidden property="pdid" styleId="pdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
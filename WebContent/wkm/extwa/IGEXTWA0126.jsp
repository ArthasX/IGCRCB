<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGEXTWA0126" toScope="request" />
<bean:define id="title" value="参与人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">


	function deleteRec(){
	    var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="参与人" />';
	    var mode="0";
	    var count=0;
		message = '请选择添加参与人。';
		confirmMsg = '请确认是否要进行参与人添加处理?';
		mode="1";
	    
		count=checkAndCreate(1);
		if(count==0){
			alert(message);
            return false;
		}
		if(count==2){
			alert("请为每个选定的角色指定具体参与人！");
            return false;
		}
		form.action = getAppRootUrl() + "/IGEXTWA0126.do";
        form.submit();
        return true;
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
					if(userids[i].value==""){
						count=2;
						return count;
					}
				}
			}
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

	function back(){
		window.close();
	}
	</script>
<body>
<div id="maincontent">
<div id="content">
<html:form styleId="form" action="/IGEXTWA0112" onsubmit="return checkSubmit(this);">
	<div class="role_title">可选角色</div>
	<div id="results_list">
	<table class="table_style" align="left">
			<tr>
				<th width="10%"><label> <input type="checkbox"
					name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','roleid_add')"/> </label>
				</th>
				<th width="20%">角色</th>
				<th width="35%">参与人</th>
				<th width="35%">机构</th>
			</tr>
			<logic:present name="IGEXTWA01041VO" property="roleList">
				<logic:iterate id="bean" name="IGEXTWA01041VO"
					property="roleList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td><label>
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
	<logic:present name="IGEXTWA01041VO"
		property="roleList">
		<span>
			<input type="button" class="button" value="添加所选"  onclick="return deleteRec();"/>
		</span>
	</logic:present>
	<input type="button" class="button" value="关闭" onclick="back();">
	</div>
	<html:hidden property="prid" styleId="prid" name="IGEXTWA0104Form"/>
</html:form></div>
</div>
<div class="zishiying">
</div>
</body>
</html:html>
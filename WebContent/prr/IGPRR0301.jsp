<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0301" toScope="request" />
<bean:define id="title" value="OA角色配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
	.fieldsetdiv{
		height:260px;
		margin-left:2px;
	}
	.fieldsetstyle{
		fload:left;width:290px;
	}
	.enterCenter{
		margin-left:25px;
	}
</style>
<script type="text/javascript">
	var addRoleFlag = "";
	function addRole(flag){
		addRoleFlag = flag;
		var roleids = "";
		var objs = document.getElementsByName("roleid_"+flag);
		if(objs!=null){
			for(var i=0;i<objs.length;i++){
				if(i>0){
					roleids += ",";
				}
				roleids += objs[i].value;
			}
		}
		openSubWindow('/IGPRR0302_Disp.do?addFlag='+flag+'&roleids='+roleids , 'newpage', '800', '600');
	}
	
	function deleteRole(flag){
		var objs = document.getElementsByName("proids_" + flag);
		var delflag = false;
		if(objs!=null){
			for(var i=0;i<objs.length;i++){
				if(objs[i].checked){
					delflag = true;
					break;
				}
			}
		}
		if(objs!=null&&delflag){
			if(window.confirm("是否确认删除？")){
				form.action = 'IGPRR0301_Delete.do?deleteFlag='+flag;
				form.submit();
			}
		}else{
			alert("请选择要删除的角色信息！");
		}
	}
	function refresh(){
		window.location.href = 'IGPRR0301_Disp.do';
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" /> 
<!--container 左菜单 右侧内容-->
<div id="container">
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRR0301_Edit.do" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程定义&gt;&gt; OA角色配置</p>
	</div>
	<div style="width: 100%;height:15px;">
	</div>
	<div id="formwrapper">
	<fieldset class="fieldsetstyle">
		<legend>负责人角色</legend>
		<div class="fieldsetdiv">
		<table class="table_style">
			<tr>
				<th width="20%">
					<input type="checkbox" name="selectA" onclick="selectAll('selectA','proids_A');"/>
				</th>
				<th width="80%">角色名称</th>
			</tr>
			<logic:present name="IGPRR03011VO" property="ig001List_A">
				<logic:iterate id="bean" name="IGPRR03011VO" property="ig001List_A">
					<tr>
						<td>
							<input type="checkbox" name="proids_A" value="${bean.proid}"/>
							<input type="hidden" name="roleid_A" value="${bean.proroleid }"/>
						</td>
						<td>${bean.prorolename }</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
		</div>
		<div class="enterCenter">
		<html:button property="A" value="添加角色" styleClass="button" onclick="addRole('A');"/>
		<logic:present name="IGPRR03011VO" property="ig001List_A">
			<logic:notEmpty name="IGPRR03011VO" property="ig001List_A">
				<html:button property="A" value="删除所选" styleClass="button" onclick="deleteRole('A');"/>
			</logic:notEmpty>
		</logic:present>
		</div>
	</fieldset>
	<fieldset class="fieldsetstyle">
		<legend>值班人角色</legend>
		<div class="fieldsetdiv">
		<table class="table_style">
			<tr>
				<th width="20%"><input type="checkbox" name="selectB" onclick="selectAll('selectB','proids_B');"/></th>
				<th width="80%">角色名称</th>
			</tr>
			<logic:present name="IGPRR03011VO" property="ig001List_B">
				<logic:iterate id="bean" name="IGPRR03011VO" property="ig001List_B">
					<tr>
						<td>
							<input type="checkbox" name="proids_B" value="${bean.proid }"/>
							<input type="hidden" name="roleid_B" value="${bean.proroleid }"/>
						</td>
						<td>${bean.prorolename }</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
		</div>
		<div class="enterCenter">
		<html:button property="A" value="添加角色" styleClass="button" onclick="addRole('B');"/>
		<logic:present name="IGPRR03011VO" property="ig001List_B">
			<logic:notEmpty name="IGPRR03011VO" property="ig001List_B">
				<html:button property="A" value="删除所选" styleClass="button" onclick="deleteRole('B');"/>
			</logic:notEmpty>
		</logic:present>
		</div>
	</fieldset>
	<fieldset class="fieldsetstyle">
		<legend>执行人角色</legend>
		<div class="fieldsetdiv">
		<table class="table_style">
			<tr>
				<th width="20%"><input type="checkbox" name="selectC" onclick="selectAll('selectC','proids_C');"/></th>
				<th width="80%">角色名称</th>
			</tr>
			<logic:present name="IGPRR03011VO" property="ig001List_C">
				<logic:iterate id="bean" name="IGPRR03011VO" property="ig001List_C">
					<tr>
						<td>
							<input type="checkbox" name="proids_C" value="${bean.proid }"/>
							<input type="hidden" name="roleid_C" value="${bean.proroleid }"/>
						</td>
						<td>${bean.prorolename }</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
		</div>
		<div class="enterCenter">
		<html:button property="A" value="添加角色" styleClass="button" onclick="addRole('C');"/>
		<logic:present name="IGPRR03011VO" property="ig001List_C">
			<logic:notEmpty name="IGPRR03011VO" property="ig001List_C">
				<html:button property="A" value="删除所选" styleClass="button" onclick="deleteRole('C');"/>
			</logic:notEmpty>
		</logic:present>
		</div>
	</fieldset>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0418" toScope="request" />
<bean:define id="title" value="添加人员画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(obj){
		if(checkNum('urids')==0){
			alert("请选择添加人！");
	        return false;
		}
	    if(window.confirm("您是否确认保存？")){
	        form.action = getAppRootUrl() + "/IGSYM0418_Delete.do?roleid="+$F("roleid");
	        return true;
	    } else {
	        return false;
	    }
	}

	//添加授权用户按钮操作提示
	function insertRec(){
		openSubWindow('/IGSYM0419_Disp.do?roleid=' + $F("roleid"), '_blank', '800', '600');
	}
//-->
</script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM0418_Disp"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
<div class="back"><a href="IGSYM0301_RE.do" target="_self">返回</a></div>
</div>
	<input type="hidden" name="flag" value="1">
	
	<div class="role_title">被授权角色</div>
	<div id="results_list">

	<table class="table_style6" align="left" style="width: 80%">
		<logic:present name="IGSYM04181VO" property="roleInfo">
			<bean:define id="bean" name="IGSYM04181VO" property="roleInfo" />
			<tr>
				<th width="15%">名称</th>
				<td width="20%">${bean.rolename}</td>
				<th width="15%" >说明</th>
				<td width="50%">${bean.roledesc}</td>
			</tr>
		</logic:present>	
	</table>
	</div>
	<div class="role_title">已有被授权用户</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	
	<table class="table_style" align="left">
		<tr>
			<th width="10%">
				<input type="checkbox" name="checkbox" id="checkbox" onclick="selectAll('checkbox','urids')"/>
			</th>
			<th width="10%">用户ID</th>
			<th width="15%">所属机构</th>
			<th width="11%">用户姓名</th>
			<th width="12%">用户电话</th>
			<th width="12%">用户手机</th>
			<th width="30%">用户邮箱</th>
		</tr>
		<logic:present name="IGSYM04181VO" property="userInfoList">
			<logic:iterate id="bean" name="IGSYM04181VO" property="userInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:multibox property="urids" value="${bean.userida}" /></label></td>
					<td>${bean.userida}</td>
					<td>${bean.orgname}</td>
					<td>${bean.username}</td>
					<td>${bean.userphone}</td>
					<td>${bean.usermobile}</td>
					<td>${bean.useremail}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate" align="center">
	<span> <html:button property="btn_insert" value="添加授权用户" styleClass="buttonCX2" onclick="insertRec();" /></span>
	<logic:present name="IGSYM04181VO"
		property="userInfoList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('urid');" /></span>
	</logic:present>
	</div>
	<html:hidden property="roleid" name="IGSYM0418Form" styleId="roleid"/>
</html:form>
 
</div>
</div>
 
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0206" toScope="request" />
<bean:define id="title" value="用户查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGSYM0206';
function setParentValue(userid, username){
    if(!window.opener.closed){
        window.opener.setParamUser(userid, username, '${IGSYM0204Form.pos}');
    }
    window.close();
}
function clearParentValue(){
    if(!window.opener.closed){
        window.opener.setParamUser("", "", '${IGSYM0204Form.pos}');
    }
    window.close();
}
function checkParent(){
	if(!window.opener.setParamUser){
		document.getElementById("parent").style.display = "none";
	}
}
function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgidstr.value = "";
		document.forms[0].orgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].orgidstr.value = temp.split("|")[0];
		document.forms[0].orgname.value = temp.split("|")[1];
	}		

}        
	</script>
<body style="background-color: white; background-image: none;">
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGSYM0205"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">用户查询</p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>&nbsp;&nbsp;所属机构：</span><html:text name="IGSYM0204Form" property="orgname" styleId="orgname" readonly="true"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
	<html:hidden name="IGSYM0204Form" property="orgidstr" styleId="orgidstr"/>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="15%">用户ID</th>
			<th width="15%">所属机构</th>
			<th width="15%">用户姓名</th>
			<th width="12%">用户电话</th>
			<th width="12%">用户手机</th>
			<th width="31%">用户邮箱</th>
		</tr>
		<logic:present name="IGSYM02011VO" property="userList">
			<logic:iterate id="bean" name="IGSYM02011VO" property="userList"
				indexId="index">
				<tr onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.userid}','${bean.username}')">
					<td>${bean.userid}</td>
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
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="enter">
	<input id="parent" type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</html:form>
</div>
</div>
</body>
</html:html>
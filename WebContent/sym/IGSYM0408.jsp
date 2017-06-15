<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0408" toScope="request" />
<bean:define id="title" value="角色用户查询画面" toScope="request" />
<%
	String path = request.getParameter("path");
%>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
        function setParentValue(userid, username,orgid,orgname){
            if(!window.opener.closed){
                window.opener.setParamRoleUser(userid, username,'<bean:write name="IGSYM0408Form" property="roleida"/>',orgid,orgname);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamRoleUser("", "",'<bean:write name="IGSYM0408Form" property="roleida"/>',"","");
            }
            window.close();
        }
        function checkParent(){
			if(!window.opener.setParamRoleUser){
				document.getElementById("parent").style.display = "none";
			}
        }
        function setOrg(url){
   	   	 
	    	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	    	if("_resetall"==temp){
				document.forms[0].orgida.value = "";
				document.forms[0].orgname.value = "";
				return false;
			}
	    	if(null!=temp && temp.split("|").length>1){
	    		document.forms[0].orgida.value = temp.split("|")[0];
	    		document.forms[0].orgname.value = temp.split("|")[1];
	    	}		

	    }
       
	</script>
<body style="background-color: white; background-image: none;" onload="checkParent()">
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGSYM0408"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">角色用户查询</p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span>用户姓名:</span> <span> <html:text
		property="username" styleId="username"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" />
	</span>&nbsp;&nbsp;<span>所属机构:</span> <span> <html:text property="orgname" readonly="true" name="IGSYM0408Form" styleId="orgname"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" />
		<html:hidden property="orgida" name="IGSYM0408Form" styleId="orgida"/>&nbsp;&nbsp;</span><html:submit property="btn_search" styleClass="button" value="查询" /></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="15%">用户ID</th>
			<th width="15%">所属机构</th>
			<th width="15%">用户姓名</th>
			<!--				<th width="8%">用户状态</th>-->
			<th width="12%">用户电话</th>
			<th width="12%">用户手机</th>
			<th width="31%">用户邮箱</th>
		</tr>
		<logic:present name="IGSYM04081VO" property="userList">
			<logic:iterate id="bean" name="IGSYM04081VO" property="userList"
				indexId="index">
				<tr
					<%if((null != path || "system".equals(path)) && !"strategy".equals(path)){ %>
					<%}else{%> onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.userid}','${bean.username}','${bean.orgid}','${bean.orgname}')"
					<%} %>>
					<td>${bean.userid}</td>
					<td>${bean.orgname}</td>
					<td>${bean.username}</td>
					<!--						<td>${bean.userstatus}</td>-->
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
	<html:hidden property="roletype"  name="IGSYM0408Form" styleId="roletype"/>
</html:form></div>
</div>
</body>
</html:html>
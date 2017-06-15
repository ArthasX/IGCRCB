<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0405" toScope="request" />
<bean:define id="title" value="角色用户查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
        function setParentValue(userid, username){
            if(!window.opener.closed){
                window.opener.setParamOrgUser(userid, username,'${IGPRD0201Form.orgid}');
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamOrgUser("", "",'${IGPRD0201Form.orgid}');
            }
            window.close();
        }
        function checkParent(){
			if(!window.opener.setParamOrgUser){
				document.getElementById("parent").style.display = "none";
			}
        }
	</script>
<body style="background-color: white; background-image: none;" onload="checkParent()">
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGPRD0201" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">角色用户查询</p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span>用户姓名:</span> 
		<span> 
			<html:text property="username" styleId="username" errorStyleClass="inputError imeDisabled" size="15" maxlength="16" />
		</span>&nbsp;&nbsp;
		<html:hidden property="orgid" name="IGPRD0201Form" styleId="orgid"/>&nbsp;&nbsp;
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
		</tr>
		<logic:present name="IGPRD02011VO" property="userroleList">
			<logic:iterate id="bean" name="IGPRD02011VO" property="userroleList" indexId="index">
				<tr onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.userid}','${bean.username}')"
					>
					<td>${bean.userid}</td>
					<td>${bean.orgname}</td>
					<td>${bean.username}</td>
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
</html:form></div>
</div>
</body>
</html:html>